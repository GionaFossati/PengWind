package application.controllers;

import application.Main;
import application.models.CharacterModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControllerCharacterName {

	private CharacterModel model;

	@FXML
	private Button btnNext;
	@FXML
	private TextField textFieldName;

	public ControllerCharacterName() {
		model = new CharacterModel();
	}

	public CharacterModel getModel() {
		return model;
	}

	@FXML
	private void nextClicked(MouseEvent event) {

		model.setName(textFieldName.getText());
		System.out.println(model.getName());
		Main.goToCharacterCustomScene();

	}

}
