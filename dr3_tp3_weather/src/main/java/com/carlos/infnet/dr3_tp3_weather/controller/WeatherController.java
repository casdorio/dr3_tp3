package com.carlos.infnet.dr3_tp3_weather.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.infnet.dr3_tp3_weather.service.WeatherWebClient;

import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WeatherController {
    private final WeatherWebClient weatherWebClient;

    @GetMapping("/weather")
    public Mono<String> getWeather(@RequestParam Double latitude, @RequestParam Double longitude) {
        return weatherWebClient.getWeather(latitude, longitude)
                .map(response -> {
                    return "Weather Data: " + response;
                });
    }
}
