package application.controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ControllerMazeSelect {

	@FXML
	private Button backBtn;

	@FXML
	private Button startBtn;

	@FXML
	private void backClicked(MouseEvent event) {
		Main.goToCharacterCustomScene();
	}

	@FXML
	private void startClicked(MouseEvent event) {
		Main.goToMazeScene();
	}

}
