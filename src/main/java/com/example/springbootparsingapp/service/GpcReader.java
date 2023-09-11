package com.example.springbootparsingapp.service;


import com.example.springbootparsingapp.entity.repository.Gpc074Repository;
import com.example.springbootparsingapp.entity.repository.Gpc075Repository;
import com.example.springbootparsingapp.model.Gpc074;
import com.example.springbootparsingapp.model.Gpc075;
import com.example.springbootparsingapp.model.GpcRecordList;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GpcReader {

    @Autowired
    private Gpc074Repository gpc074Repository;


    @Autowired
    private Gpc075Repository gpc075Repository;


    /**
     * Processes a GPC file located at the specified URL path.
     *
     * This method reads the file contents from the URL, parses the data into GpcRecordList objects,
     * and prints each GpcRecordList to the standard output.
     *
     * @param path The URL path to the GPC file to be processed.
     * @throws IOException If an I/O error occurs while reading the file or processing its contents.
     */
    public void procesGpcFile(String path) throws IOException {
        String fileContents = readFileFromUrl(path);
        List<String> list = Arrays.asList(fileContents.split(System.lineSeparator()));
        List<GpcRecordList> gpcRecordList = StringToObject(list);
        gpcRecordList.forEach(System.out::println);

    }
    /**
     * Converts a list of strings representing GPC records into a list of GpcRecordList objects.
     *
     * @param list The list of strings, each representing a GPC record.
     * @return A list of GpcRecordList objects parsed from the input strings.
     */
    private List<GpcRecordList> StringToObject(List<String> list) {
        List<GpcRecordList> gpcRecordList = new ArrayList<>(list.size());

        for (String data : list) {
            if (data.length() < 127) {
                System.err.println("Invalid GPC data.");
                continue;
            }
            String recordType = data.substring(0, 3).trim();

            switch (recordType) {

                case "074":
                    Gpc074 gpc074 = new Gpc074(data);
                    gpcRecordList.add(gpc074);
                    gpc074Repository.save(gpc074);
                    break;
                case "075":
                    Gpc075 gpc075 = new Gpc075(data);
                    gpcRecordList.add(gpc075);
                    gpc075Repository.save(gpc075);
                    break;
                default:
                    System.err.println("Invalid record type: " + recordType);
                    break;

            }
        }
        return gpcRecordList;
    }

    /**
     * Reads the contents of a file from a given URL and returns it as a string.
     *
     * @param path The URL path to the file to be read.
     * @return A string containing the contents of the file.
     * @throws IOException If an I/O error occurs while reading the file.
     * @throws IllegalArgumentException If the specified URL does not point to an existing file.
     */
    private String readFileFromUrl(String path) throws IOException {
        URL url = new URL(path);
        File file = new File(url.getFile());
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("Invalid file path: " + url.getFile());
        }
        String fileContents = FileUtils.readFileToString(file, "UTF-8");
        return fileContents;
    }

}

