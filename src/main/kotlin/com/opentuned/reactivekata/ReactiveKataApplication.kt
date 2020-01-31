package com.opentuned.reactivekata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono


@SpringBootApplication
class ReactiveKataApplication

fun main(args: Array<String>) {
	runApplication<ReactiveKataApplication>(*args)
}

@Configuration
class RouterConfig {
	@Bean
	fun routerFunction(): RouterFunction<ServerResponse> {
		return router {
			GET("/frp/hello-world") {
				ServerResponse.ok()
						.body(Mono.just("Hello ${it.queryParam("name").orElse("Jeroen")}"), String::class.java)
			}
		}
	}
}
