package com.xttblog.router;

import com.xttblog.handler.XttblogHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * HelloWebFlux
 *
 * @author xtt
 * @date 2018/9/26 下午6:11
 */
@Configuration
public class HelloWebFlux {

    @Bean
    public RouterFunction<ServerResponse> helloXttblog(XttblogHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        handler::helloXttblog).filter((serverRequest, handlerFunction) -> {
                    return ServerResponse.status(HttpStatus.OK).header("Content-Type","text/plain; charset=utf-8").build();
                });
    }
}
