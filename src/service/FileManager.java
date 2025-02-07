package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Task;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileManager {
    private static final String FILE_PATH = "./data/tasks.json";

    public static ArrayList<Task> read() throws IOException {
        Path path = Path.of(FILE_PATH);
        String jsonString = Files.readString(path);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, new TypeReference<>() {});
    }

    public static void write(ArrayList<Task> taskList) throws IOException {
        File file = new File(FILE_PATH);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(FILE_PATH), taskList);
    }
}
