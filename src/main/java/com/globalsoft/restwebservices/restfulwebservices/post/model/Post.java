/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalsoft.restwebservices.restfulwebservices.post.model;

import com.globalsoft.restwebservices.restfulwebservices.user.model.User;

/**
 *
 * @author adebowale.odulaja
 */
public class Post {
    
    private int postId;
    private String postDetails;
    public User userId;

    public Post(int postId, String postDetails, User userId) {
        this.postId = postId;
        this.postDetails = postDetails;
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(String postDetails) {
        this.postDetails = postDetails;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
    
    
    
}
