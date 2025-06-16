package org.testes.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

@Getter
public class FakerApi {
    private static final String FAKER_API_URL = "https://fakerapi.it/api/v1/custom?_quantity=1&first_name=firstName&last_name=lastName&phone_number=phone&email_address=email&password=password";
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String password;

    public FakerApi() {
        generateFakeData();
    }

    private void generateFakeData() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(FAKER_API_URL);
            String jsonResponse = httpClient.execute(request, response -> 
                EntityUtils.toString(response.getEntity()));

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResponse);
            JsonNode dataNode = rootNode.get("data").get(0);

            this.firstName = dataNode.get("first_name").asText();
            this.lastName = dataNode.get("last_name").asText();
            this.phoneNumber = dataNode.get("phone_number").asText();
            this.emailAddress = dataNode.get("email_address").asText();
            this.password = dataNode.get("password").asText();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar dados fake: " + e.getMessage());
        }
    }
}