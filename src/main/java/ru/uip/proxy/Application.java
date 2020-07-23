package ru.uip.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("upper_route", r -> r
                        .method(HttpMethod.GET)
                        .and()
                        .path("/upper")
                        .filters(f -> f
                                .rewritePath(".*", "/")
                                .modifyResponseBody(String.class, String.class, BodyMapper::toUpperCase)
                        )
                        .uri("https://yandex.ru")
                )
                .build();
    }

}
