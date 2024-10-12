package JSON_Data.nopcommer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;
import java.io.IOException;

public class Payment {

    public static Payment getData() throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(GlobalConstants.RESOURCES_PATH + "userData.json"), Payment.class);
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @JsonProperty("visa")
    private String visa;
    @JsonProperty("data")
    private String data;
    @JsonProperty("cvc")
    private String cvc;
    @JsonProperty("Checkout")
    Checkout checkout;
    static class Checkout {
        @JsonProperty("amount")
        String amount;
        @JsonProperty("currency")
        String currency;
    }
    //lấy dữ liệu từ checkout ra amount
    public String getAmount() {
        return checkout.amount;
    }
    public String getCurrency() {
        return checkout.currency;
    }



}
