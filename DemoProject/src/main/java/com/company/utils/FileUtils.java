package com.company.utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtils {

    public static void saveResponseToFile(String directory, String fileName, String responseBody) {
        // Ensure the directory exists
        File dir = new File(directory);
        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if (!created) {
                System.err.println("Failed to create directory: " + directory);
                return;
            }
        }

        // Save the response to the file
        File file = new File(dir, fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(responseBody);
            System.out.println("Response saved to file: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error while saving response to file: " + e.getMessage());
        }
    }
}
