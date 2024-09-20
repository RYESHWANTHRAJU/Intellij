package com.a2z.demo.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Converter {

    public  <T> T convertStringToDTO(String from, Class<T> to) {
        try {
            return new ObjectMapper().readValue( from, to);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public <T> String convertDtoToString(T dto) {
        try {
            return new ObjectMapper().writeValueAsString(dto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

