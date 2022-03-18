package com.avi.hibernatefun.entity

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "book")
class BookEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
  @SequenceGenerator(name = "book_generator", sequenceName = "book_seq")
  var id: Long? = null,

  var title: String,

  @ManyToMany(
    mappedBy = "books",
    fetch = FetchType.LAZY,
  )
  var authors: MutableSet<AuthorEntity> = mutableSetOf(),

  ) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as BookEntity

    if (id != other.id) return false
    if (title != other.title) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + title.hashCode()
    return result
  }
}