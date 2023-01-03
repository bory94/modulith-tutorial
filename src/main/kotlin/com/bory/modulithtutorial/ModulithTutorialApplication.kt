package com.bory.modulithtutorial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.AsyncConfigurerSupport
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@EnableAsync
@SpringBootApplication
class ModulithTutorialApplication : AsyncConfigurerSupport() {
    override fun getAsyncExecutor(): Executor = ThreadPoolTaskExecutor().apply {
        corePoolSize = 10
        maxPoolSize = 30
        queueCapacity = 100
        setThreadNamePrefix("Async-")

        initialize()
    }
}

fun main(args: Array<String>) {
    runApplication<ModulithTutorialApplication>(*args)
}
