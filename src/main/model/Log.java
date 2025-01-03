package model;

import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static Log instance;
    private StringBuilder logEntries;

    private Log() {
        logEntries = new StringBuilder();
    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void addEntry(String entry) {
        logEntries.append(entry).append("\n");
        System.out.println(entry); // Debugging
    }

    public void saveLog(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(logEntries.toString());
            System.out.println("Log saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing log file: " + e.getMessage());
        }
    }
}
