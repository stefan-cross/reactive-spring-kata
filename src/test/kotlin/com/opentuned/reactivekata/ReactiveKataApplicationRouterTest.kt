package com.opentuned.reactivekata

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

@SpringBootTest
class ReactiveKataApplicationRouterTest {

	@Autowired
	private lateinit var routerFunction: RouterFunction<ServerResponse>

	private lateinit var webTestClient: WebTestClient;

	@BeforeEach
	fun setupWebClient() {
		webTestClient = WebTestClient.bindToRouterFunction(routerFunction).build()
	}

	@Test
	fun contextLoads() {
	}

	@Test
	fun `calling hello world endpoint returns 200`() {
		webTestClient.get().uri("/frp/hello-world")
				.exchange()
				.expectStatus().isOk
				.expectBody().returnResult().responseBody.toString().contains("Hello Jeroen")
	}

	@Test
	fun `calling hello world endpoint with query param returns param in body and 200`() {
		webTestClient.get().uri("/frp/hello-world?name=foo")
				.exchange()
				.expectStatus().isOk
				.expectBody().returnResult().responseBody.toString().contains("Hello foo")
	}
}
