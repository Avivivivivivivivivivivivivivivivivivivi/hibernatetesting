package com.avi.hibernatefun

import com.avi.hibernatefun.entity.AuthorEntity
import com.avi.hibernatefun.repository.AuthorJpaRepository
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.sql.DataSource


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatabaseMappingsTests(
  @Autowired val authorJpaRepository: AuthorJpaRepository,
  @Autowired val dataSource: DataSource,
  @Autowired val entityManager: EntityManager,
) {

  @BeforeAll
  fun `initialize database`() {
    ResourceDatabasePopulator()
      .apply {
        addScript(ClassPathResource("/sql/initDbTablesForTests.sql"))
        execute(dataSource)
      }

    val authors = mutableListOf<AuthorEntity>()

    for (i: Long in 1L..50L) {
      val authorEntity = AuthorEntity(name = "name${i}", lastName = "lastName${i}")
//      authorEntity.addBook(BookEntity(title = "title${i}"))
//      authorEntity.addBook(BookEntity(title = "title${1000 + i}"))
//      authorEntity.books =
//        mutableSetOf(
//          BookEntity(title = "title${i}"),
//          BookEntity(title = "title${1000 + i}")
//        )
      authors.add(authorEntity)
    }

    authorJpaRepository.saveAll(authors)
  }

  @Test
  @Transactional
  fun `test fetching queries for authors with books`() {
    val findAll = authorJpaRepository.findAll()

    val findAllEager = authorJpaRepository.findAllEager()
    findAllEager.forEach { author ->
      print("Author Name: ${author.name}")
      author.books.forEach { book ->
        print("Book Title: ${book.title}")
      }
      println()
    }
  }

}