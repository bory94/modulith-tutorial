package com.bory.modulithtutorial.models

import java.time.LocalDateTime
import java.util.*

data class Order(
    val uuid: UUID = UUID.randomUUID(),
    val customerUuid: UUID = UUID.randomUUID(),
    val createdTime: LocalDateTime = LocalDateTime.now()
)