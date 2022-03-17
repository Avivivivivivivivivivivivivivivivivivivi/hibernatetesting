package com.avi.hibernatefun.repository

import com.avi.hibernatefun.entity.AuthorEntity
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.QueryHints
import org.springframework.data.repository.CrudRepository
import javax.persistence.QueryHint

interface AuthorJpaRepository : CrudRepository<AuthorEntity, Long> {

  @EntityGraph(value = "graph.Author.all")
  @Query("SELECT a FROM AuthorEntity a")
  @QueryHints(QueryHint( name = org.hibernate.annotations.QueryHints.READ_ONLY, value = "true") )
  fun findAllEager(): MutableIterable<AuthorEntity>

}