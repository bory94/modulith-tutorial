package com.bory.modulithtutorial.order

import com.bory.modulithtutorial.models.Order
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController(
    private val orderService: OrderService
) {
    @PostMapping
    fun create(@RequestBody order: Order) {
        orderService.createOrder(order)
    }
}