/**
 * 
 */
package controlador;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Felipe
 *
 */
public class ControladorLogin {

	@FXML
	private Button buttonLogin;

	@FXML
	private PasswordField entradaPassword;

	@FXML
	private TextField entradaUser;
	
	@FXML
    private TextField tipoUsuario;
	
	@FXML
    private Label mensagemLogin;

	@FXML
	void logar(ActionEvent event) throws IOException {
		String id = entradaUser.getText();
		String senha = entradaPassword.getText();
		String tipoUser = tipoUsuario.getText();
		int tipo = Integer.parseInt(tipoUser);
		SetNewPage page = new SetNewPage();
		if (tipo == 1) {
			if (modelos.ControladorGerentes.checkIdSenha(id, senha)) {
				page.newPage(buttonLogin, "/view/ViewMenuGerente.fxml");
			} else {
				mensagemLogin.setText("Senha ou id incorretos");
			}
		}
		else if (tipo == 2) {
			if (modelos.ControladorFuncionarios.checkIdSenha(id, senha)) {
				page.newPage(buttonLogin, "/view/ViewMenuFuncionario.fxml");
			} else {
				mensagemLogin.setText("Senha ou id incorretos");
			}
		}
	}

}
