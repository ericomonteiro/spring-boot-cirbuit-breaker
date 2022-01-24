package ericomonteiro.com.github.circuitbreaker.service

import ericomonteiro.com.github.circuitbreaker.feignclients.StubbyClient
import ericomonteiro.com.github.circuitbreaker.feignclients.StubbyHelloDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory
import org.springframework.stereotype.Service

@Service
class StubbyService(
    private val stubbyClient: StubbyClient,
    private val circuitBreakerFactory: Resilience4JCircuitBreakerFactory
) {
    private val logger: Logger = LoggerFactory.getLogger(StubbyService::class.java)

    val circuitBreaker: Resilience4JCircuitBreaker =
        circuitBreakerFactory.create("myBreaker")

    fun stubbyHello(): StubbyHelloDto {
        return circuitBreaker.run(
            { closedMethod() },
            { throwable: Throwable -> fallbackMethod(throwable) })
    }

    private fun closedMethod(): StubbyHelloDto {
        logger.info("closed method")
        return stubbyClient.hello()
    }

    private fun fallbackMethod(throwable: Throwable): StubbyHelloDto {
        logger.info("fallback")
        return StubbyHelloDto("fallback method")
    }
}