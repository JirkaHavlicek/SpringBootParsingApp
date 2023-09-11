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

    /**
     * Reads and processes a GPC file located at the specified file path.
     *
     * This endpoint accepts a file path as a request parameter and uses the GpcReader service to
     * read and process the GPC file. Any exceptions encountered during the process are logged.
     *
     * @param filePath The file path of the GPC file to be processed.
     */
    @GetMapping("/readFIle")
    public void readFile(@RequestParam("filePath")String filePath){
        try{
            gpcReader.procesGpcFile(filePath);

    } catch (IOException e){
        e.printStackTrace();
    }
  }
}
