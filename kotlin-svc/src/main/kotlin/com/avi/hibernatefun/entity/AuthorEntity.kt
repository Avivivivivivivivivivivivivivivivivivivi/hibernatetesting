package com.avi.hibernatefun.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity(name = "Author")
class AuthorEntity(
  @Id
  val id: Long,

  val name: String,

  val lastName: String,

  @ManyToMany(
    cascade = [
      CascadeType.PERSIST,
      CascadeType.MERGE,
    ]
  )
  @JoinTable(
    name = "author_book",
    joinColumns = [JoinColumn(name = "author_id")],
    inverseJoinColumns = [JoinColumn(name = "book_id")],
  )
  val books: Set<BookEntity> = mutableSetOf()
)