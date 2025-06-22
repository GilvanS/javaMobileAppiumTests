package org.testes.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.javafaker.Faker;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * Classe para geracao de dados fake usando a biblioteca JavaFaker
 * Comparacao de performance com FakerApi
 */
@Getter
public class JavaFakerGenerator {
    private static final String JSON_FILE_PATH = "src/test/resources/dados/javafaker_data.json";
    
    private String id;
    private String createdAt;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String password;
    private String fullName;
    private String addressLine;
    private String addressLine2;
    private String city;
    private String stateRegion;
    private String zipCode;
    private String country;
    private String cardNumber;
    private String cardFullName;
    private String expiryDate;
    private String cvv;

    private final Faker faker;

    public JavaFakerGenerator() {
        this.faker = new Faker(new Locale("pt-BR"));
        generateFakeData();
    }

    public JavaFakerGenerator(Locale locale) {
        this.faker = new Faker(locale);
        generateFakeData();
    }

    private void generateFakeData() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.phoneNumber = faker.phoneNumber().phoneNumber();
        this.emailAddress = faker.internet().emailAddress();
        this.password = faker.internet().password();
        this.fullName = faker.name().fullName();
        this.addressLine = faker.address().streetAddress();
        this.addressLine2 = faker.address().secondaryAddress();
        this.city = faker.address().city();
        this.stateRegion = faker.address().state();
        this.zipCode = faker.address().zipCode();
        this.country = faker.address().country();
        this.cardNumber = faker.finance().creditCard();
        this.cardFullName = this.fullName;
        this.expiryDate = String.format("%02d/%d", 
            faker.number().numberBetween(1, 12), 
            faker.number().numberBetween(2025, 2030));
        this.cvv = faker.number().digits(3);
    }

    public void salvarDadosEmJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            File jsonFile = new File(JSON_FILE_PATH);
            List<JavaFakerGenerator> dadosExistentes = new ArrayList<>();

            if (jsonFile.exists() && jsonFile.length() > 0) {
                dadosExistentes = mapper.readValue(jsonFile, mapper.getTypeFactory().constructCollectionType(List.class, JavaFakerGenerator.class));
            }

            dadosExistentes.add(this);
            mapper.writeValue(jsonFile, dadosExistentes);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar dados em JSON: " + e.getMessage());
        }
    }

    /**
     * Metodo para gerar dados adicionais especificos
     */
    public String gerarCpf() {
        return faker.number().digits(11);
    }

    public String gerarCnpj() {
        return faker.number().digits(14);
    }

    public String gerarDataNascimento() {
        return faker.date().birthday().toString();
    }

    public String gerarEmpresa() {
        return faker.company().name();
    }

    public String gerarProfissao() {
        return faker.job().title();
    }
} 