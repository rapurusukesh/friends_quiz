package com.demo.FriendsQuiz.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Answer {

    private Integer id;
    private String response;
}
