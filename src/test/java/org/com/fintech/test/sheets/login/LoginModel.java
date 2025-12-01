package org.com.fintech.test.sheets.login;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.com.fintech.core.data.DataModel;


@Data
@SuperBuilder
@NoArgsConstructor // <-- Add this annotation
public class LoginModel implements DataModel {

	private String cpf;
	private String senha;
	private String idUsuario; // O UUID do usuário
}