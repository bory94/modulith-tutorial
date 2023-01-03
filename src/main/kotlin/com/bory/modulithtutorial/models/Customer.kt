package com.bory.modulithtutorial.models

import java.util.*

data class Customer(
    val uuid: UUID = UUID.randomUUID(),
    val name: String,
    private val orderList: MutableList<Order> = mutableListOf()
) {
    fun addOrder(order: Order) {
        orderList.add(order)
    }

    fun removeOrder(orderUuid: UUID) {
        orderList.removeIf { order -> order.uuid == orderUuid }
    }

    fun orderList() =
        orderList.toList()
}