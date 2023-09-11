package com.example.springbootparsingapp.controller;

import com.example.springbootparsingapp.service.GpcReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GpcController {

    @Autowired
    GpcReader gpcReader;

    @GetMapping("/readFIle")
    public void readFile(@RequestParam("filePath")String filePath){
        try{
            gpcReader.procesGpcFile(filePath);

    } catch (IOException e){
        e.printStackTrace();
    }
  }
}
