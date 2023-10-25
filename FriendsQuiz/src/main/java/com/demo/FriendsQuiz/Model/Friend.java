package com.demo.FriendsQuiz.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Entity
@Table(name = "friends_quiz")
@Data
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String friendTitle;
    private String option1;
    private String option2;
    private String option3;
    private String rightAnswer;
    private String category;


}
