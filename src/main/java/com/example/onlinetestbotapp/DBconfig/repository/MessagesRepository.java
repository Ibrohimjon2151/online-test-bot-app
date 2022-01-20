package com.example.onlinetestbotapp.DBconfig.repository;

import com.example.onlinetestbotapp.DBconfig.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessagesRepository extends JpaRepository<Messages, Integer> {

    Optional<Messages> findByTitle(String title);

    boolean findByTitleAndStatus(String title, boolean status);
}
