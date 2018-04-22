/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalsoft.restwebservices.restfulwebservices.repository;

import com.globalsoft.restwebservices.restfulwebservices.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author adebowale.odulaja
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    
}
