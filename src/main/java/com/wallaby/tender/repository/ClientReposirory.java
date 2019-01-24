package com.wallaby.tender.repository;

import com.wallaby.tender.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientReposirory extends JpaRepository<Client, Long> {
}
