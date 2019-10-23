package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class ControllerSecondScene implements Initializable {

	@FXML
	private Label characterName;
	@FXML
	private ImageView imageView;

	private Image initialImage = new Image("/application/images/BLUE.png");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		imageView.setImage(initialImage);

	}

	public void setName(String text) {
		characterName.setText(text);
	}

	// pass the image to the next scene: select level scene + get the name from the first scene
	@FXML
    void openNextStage(MouseEvent event) {
        
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/levelSelect.fxml"));
			Parent root = (Parent) loader.load();
			
			ControllerThirdScene thirdController = loader.getController();
			String imagePath = imageView.getImage().impl_getUrl();
			thirdController.setImagePrevScene(imagePath);
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	// button handlers
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
	// get to the previous scene when clicked on the button back
	// public void

}
