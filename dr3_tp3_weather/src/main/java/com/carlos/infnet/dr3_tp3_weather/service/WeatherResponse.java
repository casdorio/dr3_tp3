package com.carlos.infnet.dr3_tp3_weather.service;

import java.util.List;

import lombok.Data;

@Data
public class WeatherResponse {
    private Hourly hourly;

    @Data
    public static class Hourly {
        private List<Double> temperature_2m;
    }
}
