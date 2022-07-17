package br.com.devjr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DevjrApplication

fun main(args: Array<String>) {
	runApplication<DevjrApplication>(*args)
}
