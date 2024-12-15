package account;


import commons.BaseTest;

import java.io.*;
import java.util.Properties;


public class Level_31_Test_Properties_V2 extends BaseTest {

    public static void main(String[] args) {
        String ProjectPath = System.getProperty("user.dir");

            try (InputStream input = new FileInputStream(ProjectPath +  "\\enviromentConfig\\dev.properties")) {

                Properties prop = new Properties();

                // load a properties file
                prop.load(input);

                // get the property value and print it out
                System.out.println(prop.getProperty("db.user"));
                System.out.println(prop.getProperty("db.password"));
                System.out.println(prop.getProperty("db.url"));

            } catch (IOException ex) {
                ex.printStackTrace();
            }

    }
}