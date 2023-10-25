package com.demo.FriendsQuiz.Model;

import lombok.Data;

@Data
public class FriendWrapper {

    private Integer id;
    private String friendTitle;
    private String option1;
    private String option2;
    private String option3;

    public FriendWrapper(Integer id, String friendTitle, String option1, String option2, String option3) {
        this.id = id;
        this.friendTitle = friendTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }
}
