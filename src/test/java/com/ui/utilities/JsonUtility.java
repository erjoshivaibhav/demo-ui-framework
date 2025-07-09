package com.ui.utilities;

import com.google.gson.Gson;
import com.pojos.Config;
import com.pojos.Env;
import com.ui.constants.Environments;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtility {

    public static Env readJson(Environments env) {

        try {
            Gson gson = new Gson();
            File file = new File(System.getProperty("user.dir") +"\\src\\test\\resources\\configuration"+File.separator+ "config.json");
            FileReader fileHandler = new FileReader(file);
            Config config = gson.fromJson(fileHandler, Config.class);
            return config.getData().get(env.name());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
