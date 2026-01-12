package com.micromerce.workout

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DevWorkoutBackendKotlinApplication

fun main(args: Array<String>) {
    runApplication<DevWorkoutBackendKotlinApplication>(*args)
}
