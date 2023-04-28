package homework.lesson8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import homework.lesson8.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "ECe1GiKtbcXBz8OAnuaGc2I2qPXRqXpm";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private DataBaseRepository dataBaseRepository = new DataBaseRepository();


    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl1 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request1 = new Request.Builder()
                        .url(httpUrl1)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request1).execute();
                String weatherResponse1 = oneDayForecastResponse.body().string();

                JsonNode dataTextNow = objectMapper
                        .readTree(weatherResponse1)
                                .at("/Headline/EffectiveDate");

                JsonNode weatherTextNow = objectMapper
                        .readTree(weatherResponse1)
                        .at("/Headline/Category");

                JsonNode temperatureTextNow = objectMapper
                        .readTree(weatherResponse1)
                        .at("/DailyForecasts/0/Temperature/Maximum/Value");

                double temperatureNow = (Double.parseDouble(String.valueOf(temperatureTextNow)) - 32) * 0.6;

                Weather forecast = new Weather(
                        selectedCity,
                        dataTextNow.toString(),
                        weatherTextNow.toString(),
                        temperatureNow);

                try {
                    dataBaseRepository.saveWeatherToDataBase(forecast);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("В городе \"" + selectedCity + "\":");
                System.out.println(
                        "на дату " + dataTextNow +
                        " ожидается " + weatherTextNow +
                        ", температура " + temperatureNow);
                System.out.println();
                break;

            case FIVE_DAYS:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request5 = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(request5).execute();
                String weatherResponse5 = fiveDayForecastResponse.body().string();

                System.out.println("В городе \"" + selectedCity + "\":");
                for (int i = 0; i < 5; i++) {


                    JsonNode dataText = objectMapper
                            .readTree(weatherResponse5)
                            .at("/DailyForecasts/" + i + "/Date");

                    JsonNode weatherText = objectMapper
                            .readTree(weatherResponse5)
                            .at("/DailyForecasts/" + i + "/Day/IconPhrase");

                    JsonNode temperatureText = objectMapper
                            .readTree(weatherResponse5)
                            .at("/DailyForecasts/" + i + "/Temperature/Maximum/Value");

                    double temperature = (Double.parseDouble(String.valueOf(temperatureText)) - 32) * 0.6;

                    try {
                        dataBaseRepository.saveWeatherToDataBase(
                                new Weather(
                                        selectedCity,
                                        dataText.toString(),
                                        weatherText.toString(),
                                        temperature
                                ));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(
                                    "на дату " + dataText +
                                    " ожидается " + weatherText +
                                    ", температура " + temperature);
                }
                System.out.println();
                break;
        }
    }

    @Override
    public List<Weather> getSavedToDBWeather() {
        return dataBaseRepository.getSavedToDBWeather();
    }

    private String detectCityKey(String selectCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
}