package ru.uip.proxy.routes;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.http.HttpMethod;
import ru.uip.proxy.mappers.BodyMapper;

import java.net.URI;
import java.util.function.Function;

public class UpperRoute implements Function<PredicateSpec, Route.AsyncBuilder> {

    private final URI routeUri;

    public UpperRoute(URI routeUri) {
        this.routeUri = routeUri;
    }

    @Override
    public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
        return predicateSpec
                .method(HttpMethod.GET)
                .and()
                .path("/upper")
                .filters(f -> f
                        .rewritePath(".*", "/")
                        .modifyResponseBody(String.class, String.class, BodyMapper::toUpperCase)
                )
                .uri(routeUri);
    }
}
