package com.example.webfluxnativesupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebfluxNativeSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxNativeSupportApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions
				.route().path("/api", builder -> builder
						.GET("", request -> ServerResponse.noContent().build())
						.POST("", request -> ServerResponse.noContent().build())
						.GET("/{id}", request -> ServerResponse.noContent().build())
						.PUT("/{id}", request -> ServerResponse.noContent().build())
						.DELETE("/{id}", request -> ServerResponse.noContent().build())
				)
				.onError(Exception.class, (error,request) -> Mono.error(error))
				.build();
	}

}
