/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalsoft.restwebservices.restfulwebservices.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author adebowale.odulaja
 */
@ApiModel(description = "Saves and Give details of a user!")//We have access to this annotation because swagger dependency was included in the pom.xml
public class User {
    
    private Integer id;
    
    @Size(min=2, message="Name must be greater than 2 characters")//you can also add a second param here e.g message="name must be > 2 characters"
    @ApiModelProperty(notes = "User name should have at least 2 characters")
    private String name;
    
    @Past
    @ApiModelProperty(notes = "Birth date can not be in the future.")
    private Date birthDate;
    
    protected User(){
        
    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", birthDate=" + birthDate + '}';
    }
    
}
