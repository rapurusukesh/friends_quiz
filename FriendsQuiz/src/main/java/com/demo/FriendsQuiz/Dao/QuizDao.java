package com.demo.FriendsQuiz.Dao;

import com.demo.FriendsQuiz.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {


}
