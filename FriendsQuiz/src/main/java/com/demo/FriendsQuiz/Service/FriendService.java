package com.demo.FriendsQuiz.Service;

import com.demo.FriendsQuiz.Dao.FriendDao;
import com.demo.FriendsQuiz.Model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Service
public class FriendService {
    @Autowired
    FriendDao friendDao;
    public ResponseEntity<List<Friend>> getAllFriends() {
        try {
            return new ResponseEntity(friendDao.findAll(), OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Friend>> getFriendsByCategory(String category) {
       return new ResponseEntity(friendDao.findByCategory(category), OK);
    }

    public ResponseEntity<String> addFriend(Friend friend) {
        try {
            friendDao.save(friend);
            return new ResponseEntity("Successfully added your friend:)", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Can't add your friend", HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<String> modifyQuestions(Friend friend, Integer id) {
        friend.setId(id);
        friendDao.save(friend);
        return new ResponseEntity("Friend Modified", OK);
    }


    public String deleteFriend(Integer id) {
        friendDao.deleteById(id);
        return "Deleted " + id + "th friend.";
    }
}
