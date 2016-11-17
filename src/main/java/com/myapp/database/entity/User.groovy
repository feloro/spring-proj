package com.myapp.database.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by istomin.a on 16.11.2016.
 */
@Entity(name = "USER")
class User {
    @Id
    @Column
    Long id;

    @Column
    String email;
}
