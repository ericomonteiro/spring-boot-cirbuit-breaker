package ericomonteiro.com.github.circuitbreaker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class CircuitBreakerApplication

fun main(args: Array<String>) {
	runApplication<CircuitBreakerApplication>(*args)
}
