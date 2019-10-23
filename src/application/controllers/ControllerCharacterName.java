package application.controllers;

import application.Main;
import application.models.CharacterModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

	/**
	 * Adds handlers to back button and continue button.
	 */
	@FXML
	private void addNavigationHandlers() {
		btnNext.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event)
            {
            	//TODO: get the character name text to the model
            	//model.setName(textFieldName.getText());
//            	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/rootCharacterCustom.fxml"));
//            	ControllerCharacterCustom secController = loader.getController();
//    			secController.setCharacterName(textFieldName.getText());
            	
            	model.setName(textFieldName.getText());
            	System.out.println(model.getName());
            	Main.goToCharacterCustomScene();

            }
 
        });
	}
	
	
	
	

}
