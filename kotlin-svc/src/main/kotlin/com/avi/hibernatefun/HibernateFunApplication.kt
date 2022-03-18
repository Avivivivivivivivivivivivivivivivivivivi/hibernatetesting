package com.avi.hibernatefun

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
  runApplication<HibernateFunApplication>(*args)
}

@SpringBootApplication
class HibernateFunApplication

