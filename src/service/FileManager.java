package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileManager {
    private static final String FILE_PATH = "./data/tasks.json";

    public static void read() {

    }

    public static void write(ArrayList<Task> taskList) throws IOException {
        File file = new File(FILE_PATH);
        File parentDir = file.getParentFile();

        System.out.println(file);
        System.out.println(parentDir);

        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(FILE_PATH), taskList);
    }
}
