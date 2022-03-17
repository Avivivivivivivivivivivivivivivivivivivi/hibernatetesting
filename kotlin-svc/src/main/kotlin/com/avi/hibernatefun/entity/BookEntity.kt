package com.avi.hibernatefun.entity

import javax.persistence.*

@Entity
@Table(name = "Book")
class BookEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
  @SequenceGenerator(name = "book_generator", sequenceName = "book_seq")
  val id: Long? = null,

  val title: String,

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