package com.bory.modulithtutorial.order

import com.bory.modulithtutorial.events.OrderCreatedEvent
import com.bory.modulithtutorial.models.Order
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val eventPublisher: ApplicationEventPublisher
) {
    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(OrderService::class.java)
    }

    @Transactional
    fun createOrder(order: Order) {
        LOGGER.debug("Creating Order ::: $order")
        eventPublisher.publishEvent(OrderCreatedEvent(order))
    }
}