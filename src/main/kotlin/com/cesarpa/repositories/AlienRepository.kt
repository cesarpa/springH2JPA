package com.cesarpa.repositories

import com.cesarpa.models.Alien
import org.springframework.data.repository.CrudRepository

interface AlienRepository : CrudRepository<Alien, Integer>