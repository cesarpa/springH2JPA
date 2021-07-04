package com.cesarpa.repositories

import com.cesarpa.models.Alien
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface AlienRepository : CrudRepository<Alien, Integer> {
    fun findByName(name: String) : List<Alien>
    fun findByIdGreaterThan(int: Int) : List<Alien>
    @Query("SELECT * from ALIEN where tech=?1 order by name", nativeQuery = true)
    fun findByTechSorted(tech: String) : List<Alien>
}