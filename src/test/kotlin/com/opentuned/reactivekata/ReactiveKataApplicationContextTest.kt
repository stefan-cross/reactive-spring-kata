package com.opentuned.reactivekata

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import org.springframework.test.web.reactive.server.WebTestClient

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class ReactiveKataApplicationContextTest {

    private lateinit var webTestClient : WebTestClient

    @Autowired
    lateinit var context: ApplicationContext

    @BeforeAll
    fun initClient() {
        webTestClient = WebTestClient
                .bindToApplicationContext(context)
                .configureClient()
                .build()
    }

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