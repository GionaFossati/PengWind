package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.models.CharacterModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
		model = new CharacterModel();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(model.getName());
		imageView.setImage(initialImage);
		characterName.setText(model.getName());

	}
	
	public void setCharacterName() {
		characterName.setText(model.getName());
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
	private void nextClicked(MouseEvent event) {
		model.setImage(imageView.getImage());
		Main.goToMazeSelectScene();
		System.out.print(model.getName());
	}
	
	@FXML
	private void backClicked(MouseEvent event) {
		Main.goToCharacterNameScene();

	}

}
