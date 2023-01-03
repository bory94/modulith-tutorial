package com.bory.modulithtutorial.customer

import com.bory.modulithtutorial.models.Customer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController(
    private val customerService: CustomerService
) {
    @PostMapping
    fun createCustomer(@RequestBody customer: Customer) {
        customerService.create(customer)
    }
}