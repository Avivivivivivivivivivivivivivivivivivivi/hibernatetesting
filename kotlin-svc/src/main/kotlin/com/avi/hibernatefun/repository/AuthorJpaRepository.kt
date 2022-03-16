package com.avi.hibernatefun.repository

import com.avi.hibernatefun.entity.AuthorEntity
import org.springframework.data.repository.CrudRepository

interface AuthorJpaRepository : CrudRepository<AuthorEntity, Long>