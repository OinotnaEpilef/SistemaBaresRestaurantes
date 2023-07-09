/**
 * 
 */
package controlador;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Felipe
 *
 */
public class SetNewPage {
	public void newPage(Button btn, String path) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(path));
		Scene scene = new Scene(root,400,400);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		Stage currentStage = (Stage) btn.getParent().getScene().getWindow();
		currentStage.close();
	}
}
