package application.controllers;

import java.io.IOException;

import application.controllers.ControllerSecondScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerFirstScene {
	
	
    @FXML
    private TextField textField;

    @FXML
    void openNewStage(ActionEvent event) {
    
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/characterSelectCustomize_Color.fxml"));
			Parent root = (Parent) loader.load();
			
			ControllerSecondScene secController = loader.getController();
			secController.setName(textField.getText());
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
