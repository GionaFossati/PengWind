package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerThirdScene implements Initializable{
	
	@FXML
	private ImageView character;
	@FXML
	private Label label;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void setImagePrevScene(String imagePath) {
		character.setImage(new Image(imagePath));
	}

}
