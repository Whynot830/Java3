package com.example.pw12;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.*;
import java.security.MessageDigest;

@Component
public class FileHandler {
    String inputFileName;
    public void run(String inputFileName, String outputFileName) throws Exception {
        this.inputFileName = inputFileName;
        File in = new File(inputFileName);
        File out = new File(outputFileName);

        if (!in.exists()) {
            FileWriter writer = new FileWriter(outputFileName);
            writer.write("null");
            writer.close();
        } else {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            FileInputStream inputStream = new FileInputStream(inputFileName);
            FileOutputStream outputStream = new FileOutputStream(outputFileName);
            byte[] buffer = new byte[8192];
            int count;
            while ((count = inputStream.read(buffer)) > 0) {
                digest.update(buffer, 0, count);
            }
            inputStream.close();

            outputStream.write(digest.digest());
            outputStream.close();
        }

    }

    @PreDestroy
    public void destroy() {
        File inputFile = new File(inputFileName);
        if (inputFile.exists()) {
            inputFile.delete();
        }
    }
}
