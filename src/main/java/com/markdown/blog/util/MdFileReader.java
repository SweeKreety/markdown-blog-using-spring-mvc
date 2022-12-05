package com.markdown.blog.util;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MdFileReader {

    public static List<String> readLinesFromMdFile(String filename) {
        try {
            InputStream iStream = new ClassPathResource("/posts/" + filename) //IS is used to read data and classpath is used to load class files and resources
                    .getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));  //To read characters from input stream
            return bReader.lines()
                    .collect(Collectors.toList());   //Gathers input data into a new list
        } catch (IOException e) {
            e.printStackTrace();                      //For handling exceptions and errors which prints the details of where the exception occured
            return null;
        }
    }

    public static String getTitleFromFileName(String filename) {
        String fileNameBeforeExtension = filename.split(".md")[0];    //Tokens are meaningful words whilst delimiters are characters that separate tokens
        String[] tokens = fileNameBeforeExtension.split("_");

        String[] titleTokens = Arrays.copyOfRange(tokens, 1, tokens.length);
        return String.join(" ", titleTokens);
    }

    public static long getIdFromFileName(String filename) {
        String fileNameBeforeExtension = filename.split(".md")[0];
        return Long.parseLong(fileNameBeforeExtension.split("_")[0]);
    }
}
