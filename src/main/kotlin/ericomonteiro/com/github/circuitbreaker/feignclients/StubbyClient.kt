package ericomonteiro.com.github.circuitbreaker.feignclients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "stubbyClient", url = "http://localhost:8884")
interface StubbyClient {

    @GetMapping("/hello")
    fun hello(): StubbyHelloDto

}

data class StubbyHelloDto(val status: String)