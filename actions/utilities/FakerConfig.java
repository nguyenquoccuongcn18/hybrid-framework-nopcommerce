package utilities;

import net.datafaker.Faker;

import java.util.Locale;

public class FakerConfig {
    static Faker fakerConfig = new Faker(new Locale("en-US"));
    public static FakerConfig getFaker() {
        return new FakerConfig();
    }
    public String generateRandomName() {
        return fakerConfig.name().fullName();
    }
    public String getFirtname(){
        return fakerConfig.name().firstName();
    }
    public String getLastName(){
        return fakerConfig.name().lastName();
    }
    public String getPassword(){
        return fakerConfig.internet().password(6, 10);
    }
    public String getRandomEmail() {
        return fakerConfig.internet().emailAddress();
    }
}
