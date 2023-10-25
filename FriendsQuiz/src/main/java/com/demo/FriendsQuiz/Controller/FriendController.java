package com.demo.FriendsQuiz.Controller;

import com.demo.FriendsQuiz.Model.Friend;
import com.demo.FriendsQuiz.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("friend")
public class FriendController {
    @Autowired
    FriendService friendService;
    @GetMapping("allFriends")
    public ResponseEntity<List<Friend>> getAllFriends(){
        return friendService.getAllFriends();
    }

    @GetMapping("category/{category}")
    public  ResponseEntity<List<Friend>> getFriendsByCategory(@PathVariable String category){
        return  friendService.getFriendsByCategory(category);
    }


    @PostMapping("add")
    public ResponseEntity<String> addFriend(@RequestBody Friend friend){
        return friendService.addFriend(friend);

    }


    @PutMapping("updateFriend/{id}")
    public ResponseEntity<String> modifyFriend(@RequestBody Friend friend, @PathVariable Integer id) {
        return friendService.modifyQuestions(friend,id);
    }

    @DeleteMapping("deleteFriend/{id}")
    public String deleteFriend(@PathVariable Integer id) {
        return friendService.deleteFriend(id);
    }

}
