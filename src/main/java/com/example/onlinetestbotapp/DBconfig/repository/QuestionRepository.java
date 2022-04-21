package com.example.onlinetestbotapp.DBconfig.repository;

import com.example.onlinetestbotapp.DBconfig.entity.Messages;
import com.example.onlinetestbotapp.DBconfig.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
