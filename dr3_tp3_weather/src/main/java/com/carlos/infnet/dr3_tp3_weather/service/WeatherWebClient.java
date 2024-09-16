package com.carlos.infnet.dr3_tp3_weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class WeatherWebClient {

    private final WebClient webClient;

    private final String apiKey = "f97f000c27b4cb0b61dcade6b342e5e9";

    public WeatherWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public Mono<String> getWeather(Double latitude, Double longitude) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("lat", latitude)
                        .queryParam("lon", longitude)
                        .queryParam("appid", apiKey)
                        .queryParam("units", "metric") 
                        .build())
                .retrieve()
                .bodyToMono(String.class); 
    }
}