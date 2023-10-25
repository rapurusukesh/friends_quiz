package com.demo.FriendsQuiz.Dao;

import com.demo.FriendsQuiz.Model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendDao extends JpaRepository<Friend, Integer> {

    List<Friend> findByCategory(String category);
    @Query(value = "SELECT * FROM friends_quiz f WHERE f.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Friend> findRandomFriendsByCategory(String category, int numQ);
}
