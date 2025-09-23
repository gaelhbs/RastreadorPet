package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
