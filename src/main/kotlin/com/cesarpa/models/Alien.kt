package com.cesarpa.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Alien {
    @Id
    var id: Int?  = null
    @Column
    var name: String? = null
}