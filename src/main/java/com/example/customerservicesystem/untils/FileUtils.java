package com.example.customerservicesystem.untils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by jfdeng on 18-4-3.
 */

public class FileUtils {

    public static void insertFile(String fileName, String text){
        File file = new File(""+fileName+".txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter writer = new FileWriter(file,true);
            writer.write(text+"\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
