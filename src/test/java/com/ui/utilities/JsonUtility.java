package com.ui.utilities;

import com.google.gson.Gson;
import com.pojos.Config;
import com.ui.constants.Environments;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;

import static com.ui.constants.Environments.QA;

public class JsonUtility {

    public static String readJson(Environments key) {

        try {
            Gson gson = new Gson();
            File file = new File(System.getProperty("user.dir") +"\\src\\test\\resources\\configuration"+File.separator+ "config.json");
            FileReader fileHandler = new FileReader(file);
            Config config = gson.fromJson(fileHandler, Config.class);
            System.out.println(config.getData());
            return config.getData().get(key.name()).getUrl();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
