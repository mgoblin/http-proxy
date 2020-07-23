package ru.uip.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import ru.uip.proxy.routes.UpperRoute;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${spring.cloud.gateway.uris.upper}")
    private String upperUri;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) throws URISyntaxException {
        return builder.routes()
                .route("upper_route", new UpperRoute(new URI(upperUri)))
                .build();
    }

}
