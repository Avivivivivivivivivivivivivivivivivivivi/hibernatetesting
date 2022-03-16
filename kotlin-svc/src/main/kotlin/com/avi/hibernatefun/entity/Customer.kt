package com.avi.hibernatefun.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Customer(
  @Id
  val id: UUID,

  @Column
  val name: String
)