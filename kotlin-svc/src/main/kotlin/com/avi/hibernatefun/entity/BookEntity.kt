package com.avi.hibernatefun.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity(name = "Book")
class BookEntity(
  @Id
  val id: Long,

  val title: String,

  @ManyToMany(mappedBy = "books")
  val authors: Set<AuthorEntity> = mutableSetOf()
)