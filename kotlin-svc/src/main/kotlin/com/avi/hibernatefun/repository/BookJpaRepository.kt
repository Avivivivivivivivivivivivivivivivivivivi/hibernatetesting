package com.avi.hibernatefun.repository

import com.avi.hibernatefun.entity.BookEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookJpaRepository : CrudRepository<BookEntity, Long>