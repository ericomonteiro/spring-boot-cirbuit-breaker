package ericomonteiro.com.github.circuitbreaker.controller

import ericomonteiro.com.github.circuitbreaker.service.StubbyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HelloController(
    private val stubbyService: StubbyService
) {

    @GetMapping("/dummy")
    fun showSomething() = ResponseEntity.ok().body(stubbyService.stubbyHello())
}