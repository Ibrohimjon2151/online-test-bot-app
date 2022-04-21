package com.example.onlinetestbotapp.DBconfig.repository;

import com.example.onlinetestbotapp.DBconfig.entity.CorrectAnswer;
import com.example.onlinetestbotapp.DBconfig.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CorrectAnswerRepository extends JpaRepository<CorrectAnswer, Integer> {

}
