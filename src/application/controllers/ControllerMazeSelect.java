package application.controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerMazeSelect {

	@FXML
	private Button backBtn;

	@FXML
	private Button startBtn;

	@FXML
	private void addNavigationHandlers() {
		backBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Main.goToCharacterCustomScene();
			}

		});
		
		startBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Main.goToMazeScene();
				
			}
			
		});

	}

}
