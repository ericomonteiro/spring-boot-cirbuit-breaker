package ericomonteiro.com.github.circuitbreaker.service

import ericomonteiro.com.github.circuitbreaker.feignclients.StubbyClient
import ericomonteiro.com.github.circuitbreaker.feignclients.StubbyHelloDto
import org.springframework.stereotype.Service

@Service
class StubbyService(
    private val stubbyClient: StubbyClient
) {
    fun stubbyHello(): StubbyHelloDto {
        return stubbyClient.hello()
    }
}