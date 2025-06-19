package org.br.com.api.utils;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.extern.apachecommons.CommonsLog;
import org.br.com.api.model.usuarios.UsuarioCms;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@CommonsLog
@Getter
public class FakerApiData {
    private static final Faker faker = new Faker(new Locale("pt-BR"));
    private static UsuarioCms usuarioPadrao;
    
    @Getter
    private static String nameCompleto;
    @Getter
    private static String nomeUsuario;
    @Getter
    private static String email;
    @Getter
    private static String password;
    @Getter
    private static String city;
    @Getter
    private static String country;
    @Getter
    private static String productName;
    @Getter
    private static String price;
    @Getter
    private static String description;
    @Getter
    private static String quantity;


    /**
     * Gera um usuário CMS fake com dados aleatórios ou retorna o usuário padrão.
     *
     * @return um objeto UsuarioCms com dados fictícios
     */
    public static UsuarioCms gerarUsuarioCmsFake() {
        if (usuarioPadrao == null) {
            usuarioPadrao = new UsuarioCms();
            usuarioPadrao.setNomeCompleto(faker.name().fullName());
            usuarioPadrao.setNomeUsuario(faker.name().username());
            usuarioPadrao.setEmail(faker.internet().emailAddress());
            usuarioPadrao.setSenha(gerarSenhaValida());
        }
        return usuarioPadrao;
    }

    /**
     * Gera uma senha válida que atende aos requisitos da API.
     * Requisitos: pelo menos 8 caracteres, uma letra maiúscula e um número.
     *
     * @return uma senha válida
     */
    private static String gerarSenhaValida() {
        String senha = faker.internet().password(8, 12) + "A1";
        return senha;
    }

    /**
     * Converte uma string de preço para um inteiro.
     *
     * @param precoString A string representando o preço.
     * @return O valor do preço como inteiro.
     * @throws IllegalArgumentException se não puder converter o preço.
     */
    public static Integer parsePrice(String precoString) {
        try {
            NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
            Number number = format.parse(precoString);
            return number.intValue();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Preço inválido: " + precoString, e);
        }
    }

    public static Map<String, String> gerarDadosAtualizacaoUsuario() {
        Map<String, String> dadosAtualizacao = new HashMap<>();
        
        // Gera um nome de usuário único
        String novoNomeUsuario;
        String nomeUsuarioAtual = "";
        do {
            novoNomeUsuario = faker.name().username();
        } while (novoNomeUsuario.equals(nomeUsuarioAtual));
        
        dadosAtualizacao.put("nomeCompleto", faker.name().fullName());
        dadosAtualizacao.put("nomeUsuario", faker.name().username());
        dadosAtualizacao.put("senha", gerarSenhaValida());
        
        return dadosAtualizacao;
    }

    /**
     * Limpa o usuário padrão para forçar a geração de um novo.
     */
    public static void limparUsuarioPadrao() {
        usuarioPadrao = null;
    }
} 