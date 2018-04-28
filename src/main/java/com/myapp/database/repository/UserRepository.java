package com.myapp.database.repository;

import com.myapp.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by istomin.a on 16.11.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
