package com.demo.FriendsQuiz.Controller;

import com.demo.FriendsQuiz.Model.Answer;
import com.demo.FriendsQuiz.Model.FriendWrapper;
import com.demo.FriendsQuiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }


    @GetMapping("get/{id}")
    public ResponseEntity<List<FriendWrapper>> getQuizFriends(@PathVariable Integer id){
       return quizService.getQuizFriends(id);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Answer> answers){

        return quizService.calculateResult(id, answers);


    }


}
