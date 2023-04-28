package homework.lesson8.entity;

public class Weather {
    private String cityName;
    private String dataForecast;
    private String weather;
    private double temperature;

    public Weather(String city, String localDate, String weather, double temperature) {
        this.cityName = city;
        this.dataForecast = localDate;
        this.weather = weather;
        this.temperature = temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDataForecast() {
        return dataForecast;
    }

    public void setDataForecast(String dataForecast) {
        this.dataForecast = dataForecast;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + cityName + '\'' +
                ", localDate='" + dataForecast + '\'' +
                ", weather='" + weather + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
