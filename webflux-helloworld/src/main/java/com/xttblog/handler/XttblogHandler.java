package com.xttblog.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;

/**
 * XttblogHandler
 *
 * @author xtt
 * @date 2018/9/26 下午6:56
 */
@Component
public class XttblogHandler {
    public Mono<ServerResponse> helloXttblog(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).header("Content-Type","text/plain; charset=utf-8")
                .body(BodyInserters.fromObject("Hello, 业余草：www.xttblog.com !"));

    }
}
