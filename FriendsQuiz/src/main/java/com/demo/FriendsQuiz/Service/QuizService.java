package com.demo.FriendsQuiz.Service;

import com.demo.FriendsQuiz.Dao.FriendDao;
import com.demo.FriendsQuiz.Dao.QuizDao;
import com.demo.FriendsQuiz.Model.Answer;
import com.demo.FriendsQuiz.Model.Friend;
import com.demo.FriendsQuiz.Model.FriendWrapper;
import com.demo.FriendsQuiz.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    FriendDao friendDao;



    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Friend> friends = friendDao.findRandomFriendsByCategory(category, numQ);

        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setFriends(friends);
        quizDao.save(quiz);


        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<FriendWrapper>> getQuizFriends(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Friend> friendsFromDB = quiz.get().getFriends();
        List<FriendWrapper> friendsForUser = new ArrayList<>();
        for(Friend f: friendsFromDB){
            FriendWrapper fw = new FriendWrapper(f.getId(), f.getFriendTitle(), f.getOption1(),f.getOption2(), f.getOption3());
            friendsForUser.add(fw);
        }


        return new ResponseEntity<>(friendsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Answer> answers) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Friend> friends = quiz.get().getFriends();
        int result=0;
        int i=0;
        for(Answer answer: answers){
            if(answer.getResponse().equals(friends.get(i).getRightAnswer()))
                    result++;

            i++;

        }return new ResponseEntity<>(result,HttpStatus.OK);


    }
}
