package application.controllers;

import java.io.IOException;

import application.Main;
import application.models.CharacterModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControllerCharacterName {

	private CharacterModel model;

	@FXML
	private Button btnNext;
	@FXML
	private TextField textFieldName;

	public ControllerCharacterName() {
		this.model = new CharacterModel();
	}

	public CharacterModel getModel() {
		return model;
	}

	@FXML
	private void nextClicked(MouseEvent event) throws IOException {
		model.setName(textFieldName.getText());
		Parent loader = FXMLLoader.load(getClass().getResource("/application/views/rootCharacterCustom.fxml"));
		Scene sceneCharacterCustom = new Scene(loader, 800, 800);
		Stage stage = (Stage) textFieldName.getScene().getWindow();
		stage.setScene(sceneCharacterCustom);

	}
	
//	private void pressedEnter(ActionEvent event) {
//		if (event.equals(Keycode))
//	}

}
