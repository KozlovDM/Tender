package com.wallaby.tender.repository;

import com.wallaby.tender.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Message, Long> {
}
