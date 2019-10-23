package application.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerNavigation {
	@FXML
	private ImageView image1;
	


	// method that changes the image after you click on a button
	public void changeImageAfterButton(ActionEvent event) throws IOException {

		Button currentButton = (Button) event.getSource();
		String id = currentButton.getId();

		if (id.equals("button_red")) {
			Image newImg = new Image("application/images/RED.png");
			image1.setImage(newImg);
		}
		if (id.equals("button_orange")) {
			Image newImg = new Image("application/images/ORANGE.png");
			image1.setImage(newImg);
		}
		if (id.equals("button_yellow")) {
			Image newImg = new Image("application/images/YELLOW.png");
			image1.setImage(newImg);
		}
		if (id.equals("button_green")) {
			Image newImg = new Image("application/images/GREEN.png");
			image1.setImage(newImg);
		}
		if (id.equals("button_purple")) {
			Image newImg = new Image("application/images/PURPLE.png");
			image1.setImage(newImg);
		}
		if (id.equals("button_black")) {
			Image newImg = new Image("application/images/BLUE.png");
			image1.setImage(newImg);
		}
	}

	// pass on Image from the choice made on previous scene
	// TODO: check deze links
	// https://stackoverflow.com/questions/14187963/passing-parameters-javafx-fxml
	// https://stackoverflow.com/questions/30814258/javafx-pass-parameters-while-instantiating-controller-class/30815504
	// https://www.youtube.com/results?search_query=passing+parameters+javafx+fxml
	// https://www.youtube.com/watch?v=x3UlAwS6dEE

	// When this method is called, it will change the scene to
	// characterSelect_FirstScene.fxml
	public void changeScreenToFirstScene(ActionEvent event) throws IOException {

		Parent characterSelectCustomizeParent = FXMLLoader
				.load(getClass().getResource("/application/views/characterSelect_FirstScene.fxml"));
		Scene characterSelectCustomizeScene = new Scene(characterSelectCustomizeParent);

		// This line gets the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(characterSelectCustomizeScene);
		window.show();
	}

	// When this method is called, it will change the scene to
	// characterSelectCustomize_Color.fxml
	public void changeScreenToCustomizeColor(ActionEvent event) throws IOException {

		Parent characterSelectCustomizeParent = FXMLLoader
				.load(getClass().getResource("/application/views/characterSelectCustomize_Color.fxml"));
		Scene characterSelectCustomizeScene = new Scene(characterSelectCustomizeParent);

		// This line gets the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(characterSelectCustomizeScene);
		window.show();
	}

	// When this method is called, it will change the scene to
	// characterSelectCustomize_Eye_Color.fxml
	public void changeScreenToCustomizeEyeColor(ActionEvent event) throws IOException {

		Parent characterSelectCustomizeParent = FXMLLoader
				.load(getClass().getResource("/application/views/characterSelectCustomize_EyeColor.fxml"));
		Scene characterSelectCustomizeScene = new Scene(characterSelectCustomizeParent);

		// This line gets the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(characterSelectCustomizeScene);
		window.show();

	}

	// When this method is called, it will change the scene to
	// characterSelectCustomize_Accessories.fxml
	public void changeScreenToCustomizeAccessories(ActionEvent event) throws IOException {

		Parent characterSelectCustomizeParent = FXMLLoader
				.load(getClass().getResource("/application/views/characterSelectCustomize_Accessories.fxml"));
		Scene characterSelectCustomizeScene = new Scene(characterSelectCustomizeParent);

		// This line gets the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(characterSelectCustomizeScene);
		window.show();

	}

	// When this method is called, it will change the scene to gameScene.fxml
	public void changeScreenToGameScene(ActionEvent event) throws IOException {

		Parent characterSelectCustomizeParent = FXMLLoader.load(getClass().getResource("/application/views/gameScene.fxml"));
		Scene characterSelectCustomizeScene = new Scene(characterSelectCustomizeParent);

		// This line gets the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(characterSelectCustomizeScene);
		window.show();

	}
}
