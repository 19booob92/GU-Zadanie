package utils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.User;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


public class FileOperations {

	static final Logger logger = Logger.getLogger(FileOperations.class);
	
    final static String SAVE_URL = "userDB";

    private static Gson gson = new Gson();

    static public void saveUser(User user) {
        createDir();

        File file = new File(getFileName(user.getName(), user.getId()));

        FileWriter writer;
        try {
            writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(gson.toJson(user));
            bufferedWriter.close();

        } catch (IOException e) {
            logger.error("Nie mozna zapisac pliku \n" + e.getStackTrace());
        }
    }

    static public void saveUser(Collection<User> users) {
        for (User user : users) {
            saveUser(user);
        }
    }
    
    static public List<User> readAllUsers() throws JsonSyntaxException, IOException {
        File folder = new File(SAVE_URL);
        File[] listOfFiles = folder.listFiles();
        List<User> users = new ArrayList<>(); 
        
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".json")) {
                User tmpUser = gson.fromJson(FileUtils.readFileToString(file), User.class);
                users.add(tmpUser);
            }
        }
        return users;
    }

    static public List<User> readAllUsersWithGivenItemsCost(long cost) throws JsonSyntaxException, IOException {
        File folder = new File(SAVE_URL);
        File[] listOfFiles = folder.listFiles();
        List<User> usersWithGivenItemsCost = new ArrayList<>(); 
        
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".json")) {
                User tmpUser = gson.fromJson(FileUtils.readFileToString(file), User.class);
                if (tmpUser.getAllProductsCost() >= cost) {
                    usersWithGivenItemsCost.add(tmpUser);
                }
            }
        }
        return usersWithGivenItemsCost;
    }

    private static void createDir() {
        File dir = new File(SAVE_URL);

        if (!dir.exists()) {
            dir.mkdir();
        }
    }
    
    static public void deleteAllUsers() {
        File folder = new File(SAVE_URL);
        File[] listOfFiles = folder.listFiles();
        
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".json")) {
                file.delete();
            }
        }
    }

    private static String getFileName(String name, long id) {
        StringBuilder fileName = new StringBuilder();
        fileName.append(SAVE_URL);
        fileName.append("/");
        fileName.append(id);
        fileName.append("_");
        fileName.append(name);
        fileName.append(".json");
        return fileName.toString();
    }
}
