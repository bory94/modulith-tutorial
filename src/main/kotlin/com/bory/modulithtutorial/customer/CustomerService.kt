package com.bory.modulithtutorial.customer

import com.bory.modulithtutorial.events.OrderCreatedEvent
import com.bory.modulithtutorial.models.Customer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.modulith.ApplicationModuleListener
import org.springframework.stereotype.Service

@Service
class CustomerService {
    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(CustomerService::class.java)
    }

    @ApplicationModuleListener
    fun on(event: OrderCreatedEvent) {
        LOGGER.debug("CustomerService::on(OrderCreatedEvent) <== event = [$event]")

        val customer = Customer(event.order.customerUuid, "CustomerName")
        customer.addOrder(event.order)

        LOGGER.debug("CustomerService::on(OrderCreatedEvent) <== customer = [$customer]")
    }

    fun create(customer: Customer) {
        LOGGER.debug("CustomerService::create(Customer) <== customer = [$customer]")
    }
}