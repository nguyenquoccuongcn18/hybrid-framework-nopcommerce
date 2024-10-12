package JSON_Data.nopcommer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;
import pojoData.nopcommer.UserInfo;

import java.io.File;
import java.io.IOException;

public class DataJson {

    public static DataJson getData() throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(GlobalConstants.RESOURCES_PATH + "userData.json"), DataJson.class);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;


}
