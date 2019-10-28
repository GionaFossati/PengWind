package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.models.CharacterModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerMazeSelect implements Initializable{
	
	private CharacterModel model;

	@FXML
	private Button backBtn;

	@FXML
	private Button startBtn;
	
	@FXML
	private ImageView imageView;
	
	@FXML
	private Label characterName;
	
	
	public ControllerMazeSelect(){
		this.model = new CharacterModel();
	}
	
//	ControllerMazeSelect(){
//		model = new CharacterModel();
////		imageView.setImage(model.getImage());
//		
//	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		imageView.setImage(model.getImage());
		characterName.setText(model.getName());
		
	}

	@FXML
	private void backClicked(MouseEvent event) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("/application/views/rootCharacterCustom.fxml"));
		Scene sceneCharacterCustom = new Scene(loader, 800, 800);
		Stage stage = (Stage) characterName.getScene().getWindow();
		stage.setScene(sceneCharacterCustom);
	}

	@FXML
	private void startClicked(MouseEvent event) throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("/application/views/rootMaze.fxml"));
		Scene sceneMaze = new Scene(loader, 800, 800);
		Stage stage = (Stage) characterName.getScene().getWindow();
		stage.setScene(sceneMaze);
	}


}
