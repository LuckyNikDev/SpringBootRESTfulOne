package com.example.springrestful_1.repository;

import com.example.springrestful_1.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
