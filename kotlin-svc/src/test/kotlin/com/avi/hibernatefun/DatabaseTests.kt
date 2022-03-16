package com.avi.hibernatefun

import com.avi.hibernatefun.repository.BookJpaRepository
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator
import javax.sql.DataSource

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatabaseTests(
  @Autowired val bookJpaRepository: BookJpaRepository,
  @Autowired val dataSource: DataSource,
) {

  init {
    ResourceDatabasePopulator().apply {
      addScript(ClassPathResource("/sql/initDbForTests.sql"))
      execute(dataSource)
    }
  }

  @Test
  fun contextLoads() {
    val findAll = bookJpaRepository.findAll()
    findAll.forEach {
      println("${it.id}, ${it.title}")
    }
  }

}
