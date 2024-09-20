package com.a2z.demo.controller;

import com.a2z.demo.model.Student;
import com.a2z.demo.util.Converter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestClient
{
    private static final String GET_ALL_STUDENTS_API="http://localhost:8080/students/all";
    private static final String GET_STUDENT_BY_RNO_API="http://localhost:8080/students/{rno}";
    private static final String CREATE_STUDENT_API="http://localhost:8080/students";
    private static final String UPDATE_STUDENT_API="http://localhost:8080/students";
    private static final String DELETE_STUDENT_API="http://localhost:8080/students/{rno}";
    static RestTemplate restTemplate=new RestTemplate();
    //The RestTemplate is a synchronous client to perform HTTP requests, such as GET, POST, PUT, DELETE, etc.
    // It allows interaction with RESTful web services.
    public static void main(String args[]) {
        callGetAllStudentsAPI();
        callGetStudentByRno(1);

       // String studentJson = "{\"rno\":4,\"name\":\"John Doe\",\"branch\":\"MECH\",\"gender\":\"male\",\"cgpa\":7.8}";
        Student studentJson=new Student();
        studentJson.setRno(5);
        studentJson.setName("Varun");
        studentJson.setBranch("EEE");
        studentJson.setGender("male");
        studentJson.setCgpa(9.0);
        Converter converter=new Converter();
        callCreateStudentAPI(converter.convertDtoToString(studentJson));

//        Student student=new Student();
//        student.setRno(5);
//        student.setName("Varun");
//        student.setBranch("ECE");
//        student.setGender("male");
//        student.setCgpa(8.33);
//        Converter converter=new Converter();
//
//        //String studentJson = "{\"rno\":4,\"name:\":\"Varun\",\"branch\":\"MECH\",\"gender\":\"male\",\"cgpa\":8.5}";
//        callUpdateStudentAPI(converter.convertDtoToString(student));
       // callUpdateStudentAPI(student);

       // callDeleteStudentAPI(4);
    }

    private static void callGetAllStudentsAPI() {
        // Create headers
        HttpHeaders httpHeaders = new HttpHeaders();

        //Telling server: "Hey, I want the response in JSON format (application/json). Please return the data in that format."
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        // Create an entity with headers but no body
        HttpEntity<String> entity = new HttpEntity<>("parameters",httpHeaders);

        // Make the GET request
        ResponseEntity<String> result = restTemplate.exchange(GET_ALL_STUDENTS_API, HttpMethod.GET, entity, String.class);

        // Print the result
        System.out.println(result.getBody());
    }

    private static void callGetStudentByRno(Integer rno)
    {
        // Create headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        // Create an entity with headers but no body
        HttpEntity<String> entity = new HttpEntity<>("parameters",httpHeaders);

        // Make the GET request
        ResponseEntity<String> result = restTemplate.exchange(GET_STUDENT_BY_RNO_API, HttpMethod.GET, entity, String.class,rno);

        // Print the result
        System.out.println(result.getBody());

    }

    private static void callCreateStudentAPI(String studentJson)
    {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity=new HttpEntity<>(studentJson,httpHeaders);
        ResponseEntity<String> result=restTemplate.exchange(CREATE_STUDENT_API,HttpMethod.POST,entity, String.class);
        System.out.println(result.getBody());
    }

//    private static void callUpdateStudentAPI(Student student)
//    {
//        HttpHeaders httpHeaders=new HttpHeaders();
//       // httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Student> entity=new HttpEntity<>(student,httpHeaders);
//
//        ResponseEntity<String> result = restTemplate.exchange(UPDATE_STUDENT_API, HttpMethod.PUT, entity, String.class);
//
//        System.out.println(result.getBody());
//    }

    private static void callUpdateStudentAPI(String student)
    {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity=new HttpEntity<>(student,httpHeaders);

        ResponseEntity<String> result = restTemplate.exchange(UPDATE_STUDENT_API, HttpMethod.PUT, entity, String.class);

        System.out.println(result.getBody());
    }

    private static void callDeleteStudentAPI(Integer rno)
    {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity=new HttpEntity<>(httpHeaders);
        ResponseEntity<String> result=restTemplate.exchange(DELETE_STUDENT_API,HttpMethod.DELETE,entity, String.class,rno);
        System.out.println(result.getBody());
    }

}

