/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalsoft.restwebservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adebowale.odulaja
 */
@RestController
public class PersonController {
    
    @GetMapping("v1/person") //More preferred
    public PersonV1 personV1(){
        return new PersonV1("Adebowale Adebola");
    }
    
    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Adebowale", "Adebola"));
    }
    
    @GetMapping(value="/person/param", params = "version=1") //called by http//localhost:8080/person/param?version=1
    public PersonV1 paramV1(){
        return new PersonV1("Adebowale Adebola");
    }
    
    @GetMapping(value="/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Adebowale", "Adebola"));
    }
    
    @GetMapping(value="/person/header", headers = "X-API-VERSION=1") //called by http//localhost:8080/person/header and parse header as X-API-VERSION
    public PersonV1 headerV1(){
        return new PersonV1("Adebowale Adebola");
    }
    
    @GetMapping(value="/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Adebowale", "Adebola"));
    }
    
    @GetMapping(value="/person/produces", produces = "application/vnd.globalsoft.webserv-v1+json") //called by http//localhost:8080/person/produces and parse header as Accept then value will be 'application/vnd.globalsoft.webserv-v1+json'
    public PersonV1 produceV1(){
        return new PersonV1("Adebowale Adebola");
    }
    
    @GetMapping(value="/person/produces", produces = "application/vnd.globalsoft.webserv-v2+json")
    public PersonV2 produceV2(){
        return new PersonV2(new Name("Adebowale", "Adebola"));
    }
    
}
