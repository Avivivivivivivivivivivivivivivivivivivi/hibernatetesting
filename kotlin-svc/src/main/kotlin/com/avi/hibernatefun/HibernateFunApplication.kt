package com.avi.hibernatefun

import com.avi.hibernatefun.entity.AuthorEntity
import com.avi.hibernatefun.repository.AuthorJpaRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener

fun main(args: Array<String>) {
	runApplication<HibernateFunApplication>(*args)
}

@SpringBootApplication
class HibernateFunApplication(val authorJpaRepository: AuthorJpaRepository){
	@EventListener
	fun onReady(e :ApplicationReadyEvent){
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
}

