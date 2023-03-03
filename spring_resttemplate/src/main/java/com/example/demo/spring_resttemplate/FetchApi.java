package com.example.demo.spring_resttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
@SpringBootTest
class FetchApi {
    String url="https://dog.ceo/api/breeds/image/random";

    @Test
    void getRequest(){
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Bearer xxxxxxx");
        HttpEntity entity=new HttpEntity("",headers);
        RestTemplate restTemplate=new RestTemplate();
        Object res=restTemplate.exchange(url, HttpMethod.GET,entity,Object.class);
        System.out.println(res);
    }

    @Test
    void postRequest(){
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer xxxxxxx");
        Person person=new Person("Casey",10);
        String json;
        try{
            json=new ObjectMapper().writeValueAsString(person);
        }
        catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }

        HttpEntity entity=new HttpEntity(json,headers);
        RestTemplate restTemplate=new RestTemplate();
        Object res=restTemplate.exchange(url, HttpMethod.POST,entity,Object.class);
        System.out.println(res);

    }
}
