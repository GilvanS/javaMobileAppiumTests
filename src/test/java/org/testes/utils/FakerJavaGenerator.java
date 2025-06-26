package org.testes.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.javafaker.Faker;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *  Classe para geração de dados fake usando a biblioteca JafaFkaer
 * Comparação de perfomarce com FakerApi
 */
@Getter
public class FakerJavaGenerator {
	private static final String JSON_FILE_PATH = "src/test/resources/dados/faker-java.json";

	private String id;
	private String createdAt;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private String password;
	private String address;
	private String city;
	private String state;
	private String zipCode;

	@JsonIgnore
	private final Faker faker;

	public FakerJavaGenerator() {
		this.faker = new Faker(new Locale("pt-BR"));
		generateFakeData();
	}

	private void generateFakeData() {
		this.id = UUID.randomUUID().toString();
		this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.firstName = faker.name().firstName();
		this.lastName = faker.name().lastName();
		this.phoneNumber = faker.phoneNumber().phoneNumber();
		this.emailAddress = faker.internet().emailAddress(this.firstName + "." + this.lastName).toLowerCase();
		this.password = faker.internet().password();
	}

	public void salvarDadosEmJson() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);

			File jsonFile = new File(JSON_FILE_PATH);
			List<FakerJavaGenerator> dadosExistentes = new ArrayList<>();

			if (jsonFile.exists() && jsonFile.length() > 0) {
				try {
					dadosExistentes = mapper.readValue(jsonFile, mapper.getTypeFactory().constructCollectionType(List.class, FakerJavaGenerator.class));
				} catch (Exception e) {
					// Se falhar ao ler como lista, tenta ler como objeto único
					FakerJavaGenerator objetoUnico = mapper.readValue(jsonFile, FakerJavaGenerator.class);
					dadosExistentes.add(objetoUnico);
				}
			}

			dadosExistentes.add(this);
			mapper.writeValue(jsonFile, dadosExistentes);

		} catch (IOException e) {
			throw new RuntimeException("Erro ao salvar dados em JSON: " + e.getMessage());
		}
	}



}
