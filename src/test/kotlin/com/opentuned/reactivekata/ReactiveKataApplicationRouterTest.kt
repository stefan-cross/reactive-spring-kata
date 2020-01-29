package com.opentuned.reactivekata

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class ReactiveKataApplicationRouterTest {

	val webTestClient = WebTestClient.bindToRouterFunction(routerFunction()).build()

	@Test
	fun contextLoads() {
	}

	@Test
	fun `calling hello world endpoint returns 200`() {
		webTestClient.get().uri("/frp/hello-world")
				.exchange()
				.expectStatus().isOk
	}

	@Test
	fun `calling hello world endpoint with query param returns param in body and 200`() {
		webTestClient.get().uri("/frp/hello-world?name=foo")
				.exchange()
				.expectStatus().isOk
				.expectBody().returnResult().responseBody.toString().contains("Hello foo")
	}
}
