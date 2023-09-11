package com.example.springbootparsingapp;

import com.example.springbootparsingapp.entity.repository.Gpc074Repository;
import com.example.springbootparsingapp.entity.repository.Gpc075Repository;
import com.example.springbootparsingapp.model.Gpc074;
import com.example.springbootparsingapp.model.Gpc075;
import com.example.springbootparsingapp.service.GpcReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class SpringBootParsingAppApplicationTests {

    @Autowired
    private Gpc075Repository gpc075Repository;

    @Autowired
    private Gpc074Repository gpc074Repository;

    @Autowired
    private GpcReader gpcReader;

    @BeforeEach
    void setUp() {
        gpc074Repository.deleteAll();
        gpc075Repository.deleteAll();
    }
    @AfterEach
    void tearDown() {
        gpc074Repository.deleteAll();
        gpc075Repository.deleteAll();
    }

    @Test
    void contextLoads() throws IOException {
        gpcReader.procesGpcFile("file:///C:/Users/R9-290/Desktop/SpringBootParsingApp/GcpData.txt");
        List<Gpc074> all074 = gpc074Repository.findAll();
        assert all074.size() == 1;
        List<Gpc075> all075 = gpc075Repository.findAll();
        assert all075.size() == 5;





    }



}
