package com.avi.hibernatefun.entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.NamedAttributeNode
import javax.persistence.NamedEntityGraph
import javax.persistence.SequenceGenerator
import javax.persistence.Table


@NamedEntityGraph(
  name = "graph.Author.all",
  attributeNodes = [NamedAttributeNode("books")],
)
@Entity
@Table(name = "author")
class AuthorEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
  @SequenceGenerator(name = "author_generator", sequenceName = "author_seq")
  var id: Long? = null,

  @Column(name = "author_name")
  var name: String,

  var lastName: String,

  @ManyToMany(
    cascade = [
      CascadeType.PERSIST,
      CascadeType.MERGE,
    ],
    fetch = FetchType.LAZY,
  )
  @JoinTable(
    name = "author_book",
    joinColumns = [JoinColumn(name = "author_id")],
    inverseJoinColumns = [JoinColumn(name = "book_id")],
  )
  var books: MutableSet<BookEntity> = mutableSetOf(),

  ) {
  fun addBook(book: BookEntity) {
    books.add(book)
    book.authors.add(this)
  }

  fun removeBook(book: BookEntity) {
    books.remove(book)
    book.authors.remove(this)
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as AuthorEntity

    if (id != other.id) return false

    return true
  }

  override fun hashCode(): Int {
    return id.hashCode()
  }
}