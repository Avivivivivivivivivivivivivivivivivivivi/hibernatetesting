package com.avi.hibernatefun

import com.avi.hibernatefun.entity.Customer
import com.avi.hibernatefun.repository.CustomerJpaRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HibernatefunApplicationTests {

	@Autowired
	lateinit var customerJpaRepository: CustomerJpaRepository

	@Test
	fun contextLoads() {
		val findAll = customerJpaRepository.findAll()
		println("lalla")
	}

}
