package ru.uip.proxy.mappers;

import org.reactivestreams.Publisher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class BodyMapper {
    public static Publisher<String> toUpperCase(ServerWebExchange exchange, String s) {
        return Mono.just(s.toUpperCase());
    }
}
