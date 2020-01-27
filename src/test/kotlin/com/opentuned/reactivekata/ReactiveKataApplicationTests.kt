package com.opentuned.reactivekata

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class ReactiveKataApplicationTests {

	val webTestClient = WebTestClient.bindToRouterFunction(routerFunction()).build()

	@Test
	fun contextLoads() {
	}

	@Test
	fun `calling hello world endpoint returns 200`() {
		webTestClient.get().uri("/fpr/hello-world")
				.exchange()
				.expectStatus().isOk
	}

}
