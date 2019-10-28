package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.models.CharacterModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerCharacterCustom implements Initializable {

	@FXML
	private Label characterName;
	@FXML
	private Button backBtn;
	@FXML
	private Button nextBtn;
	@FXML
	private ImageView imageView;
	CharacterModel model;
	
	private Image initialImage = new Image("/application/images/BLUE.png");

	public ControllerCharacterCustom() {
		this.model = new CharacterModel();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageView.setImage(initialImage);
		characterName.setText(model.getName());

	}
	
	//set the characterName label to the character name stored in CharacterModel
	public void setCharacterName(String name) {
		characterName.setText(name);
	}
	
	// method that changes the image after you click on a button
	public void changeImageAfterButton(ActionEvent event) throws IOException {

		Button currentButton = (Button) event.getSource();
		String id = currentButton.getId();

		if (id.equals("button_red")) {
			Image newImg = new Image("/application/images/RED.png");
			imageView.setImage(newImg);
		}
		if (id.equals("button_orange")) {
			Image newImg = new Image("/application/images/ORANGE.png");
			imageView.setImage(newImg);
		}
		if (id.equals("button_yellow")) {
			Image newImg = new Image("/application/images/YELLOW.png");
			imageView.setImage(newImg);
		}
		if (id.equals("button_green")) {
			Image newImg = new Image("/application/images/GREEN.png");
			imageView.setImage(newImg);
		}
		if (id.equals("button_purple")) {
			Image newImg = new Image("/application/images/PURPLE.png");
			imageView.setImage(newImg);
		}
		if (id.equals("button_blue")) {
			Image newImg = new Image("/application/images/BLUE.png");
			imageView.setImage(newImg);
		} else {

		}
	}

	@FXML
	private void nextClicked(MouseEvent event) throws IOException {
		
		model.setImage(imageView.getImage());
		Parent loader = FXMLLoader.load(getClass().getResource("/application/views/rootMazeSelect.fxml"));
		Scene sceneMazeSelect = new Scene(loader, 800, 800);
		Stage stage = (Stage) characterName.getScene().getWindow();
		stage.setScene(sceneMazeSelect);
	}
	
	@FXML
	private void backClicked(MouseEvent event) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("/application/views/rootCharacterName.fxml"));
		Scene sceneCharacterName = new Scene(loader, 800, 800);
		Stage stage = (Stage) characterName.getScene().getWindow();
		stage.setScene(sceneCharacterName);

	}

}
