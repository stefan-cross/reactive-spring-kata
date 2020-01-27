package com.opentuned.reactivekata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@SpringBootApplication
class ReactiveKataApplication

fun main(args: Array<String>) {
	//runApplication<ReactiveKataApplication>(*args)
	SpringApplicationBuilder(ReactiveKataApplication::class.java)
			.initializers(
				beans {
					bean {
						routerFunction()
					}
			})
			.build()
			.run(*args)
}

fun routerFunction(): RouterFunction<ServerResponse> {
	return router {
		GET("/fpr/hello-world") {
			ServerResponse.ok().body(Mono.just("Hello ${it.queryParam("name")}"), String::class.java)
		}
	}
}
