/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalsoft.restwebservices.restfulwebservices.post.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globalsoft.restwebservices.restfulwebservices.user.model.User;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author adebowale.odulaja
 */
@Entity
public class Post implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer postId;
    private String postDetails;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    public User userId;

    public Post() {
    }
    
    

    public Post(int postId, String postDetails) {
        this.postId = postId;
        this.postDetails = postDetails;
        //this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
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
    

    @Override
    public String toString() {
        return "Post{" + "postId=" + postId + ", postDetails=" + postDetails +'}';
    }
    
    
    
}
