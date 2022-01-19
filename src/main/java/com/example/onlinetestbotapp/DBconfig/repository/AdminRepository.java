package com.example.onlinetestbotapp.DBconfig.repository;

import com.example.onlinetestbotapp.DBconfig.entity.Admin;
import com.example.onlinetestbotapp.DBconfig.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByChatId(Long chatId);



    boolean existsByChatId(Long chatId);
}
