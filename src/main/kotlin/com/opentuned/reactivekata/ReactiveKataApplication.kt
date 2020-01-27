package com.opentuned.reactivekata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveKataApplication

fun main(args: Array<String>) {
	runApplication<ReactiveKataApplication>(*args)
}
