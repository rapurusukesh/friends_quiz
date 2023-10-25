package com.demo.FriendsQuiz.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Entity
 @Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany
    private List<Friend> friends;
}
