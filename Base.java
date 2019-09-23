package com.qa.base;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base {

    public static int RESPONSE_STATUS_CODE_201=201;
    public int RESPONSE_STATUS_CODE_200=200;
    public int RESPONSE_STATUS_CODE_500=500;
    public int RESPONSE_STATUS_CODE_400=400;
    public int RESPONSE_STATUS_CODE_401=401;

public Properties prop;

    public  Base() {

        prop = new Properties();
        try {
         prop.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
