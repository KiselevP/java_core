package homework.lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Accuweather {
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "FUo3AvNwxW4fs4xs7RrbIAAk8eVqhJ2D";
    private static final String API_KEY_QUERY_PARAM = "apikey";

    private static final OkHttpClient okHttpClient = new OkHttpClient();


    public void getWeather(Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl1 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment("349727") /*NY*/
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request1 = new Request.Builder()
                        .url(httpUrl1)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request1).execute();
                String weatherResponse1 = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse1);
                break;

            case FIVE_DAYS:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment("349727") /*NY*/
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request5 = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(request5).execute();
                String weatherResponse = fiveDayForecastResponse.body().string();
                System.out.println(weatherResponse);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        Accuweather accuweather = new Accuweather();
        accuweather.getWeather(Period.FIVE_DAYS);
    }
}