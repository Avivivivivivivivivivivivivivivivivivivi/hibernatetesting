package com.avi.hibernatefun.repository

import com.avi.hibernatefun.entity.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CustomerJpaRepository : CrudRepository<Customer, UUID>