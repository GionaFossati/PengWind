package application;

import java.io.IOException;

import com.sun.javafx.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {
//		First Screen Controller ˅˅˅˅
	    
		@FXML
	    private AnchorPane apMain;
	    @FXML
	    private Button btnPlay;
	    @FXML
	    private Button btnCharacterSelection;
	    @FXML
	    private Button btnLevelSelection;
	    
	    @FXML
	    void openCharacterSelector(MouseEvent event) throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("characterSelectScene.fxml"));
	    	Parent root = fxmlLoader.load();
	    	Stage stage = new Stage();
	    	stage.initModality(Modality.APPLICATION_MODAL);
	    	stage.setOpacity(1);
	    	stage.setTitle("My New Stage Title");
	    	stage.setScene(new Scene(root, 450, 450));
	    	stage.showAndWait();
	    }

	    @FXML
	    void openLevelSelection(MouseEvent event) {
	    	//opener here
	    }

	    @FXML
	    void openPlayField(MouseEvent event) throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gameScene.fxml"));
	    	Parent root = fxmlLoader.load();
	    	Stage stage = new Stage();
	    	stage.initModality(Modality.APPLICATION_MODAL);
	    	stage.setOpacity(1);
	    	stage.setTitle("My New Stage Title");
	    	stage.setScene(new Scene(root, 450, 450));
	    	stage.showAndWait();
	    }
	    
//		Level Selection Controller ˅˅˅˅
	
//		Character Selection Controller ˅˅˅˅
	
//		GamePlay Controller ˅˅˅˅
	    
		@FXML
	    private ImageView familyGroup;
	    @FXML
	    private ImageView penguinUser;
	    @FXML
	    private ImageView sharkOne;
	    @FXML
	    private ImageView sharkTwo;
	    @FXML
	    private ImageView sharkFour;
	    @FXML
	    private ImageView sharkThree;
	    @FXML
	    private ImageView icebergTwo;
	    @FXML
	    private ImageView icebergOne;
	    @FXML
	    private Button btnGoOn;
	    @FXML
	    private Button btnChangeMove;
	    @FXML
	    private GridPane playField;
	    
//	    attach eventHandler to each cell
		private void addGridEvent() {
		        playField.getChildren().forEach(item -> {
		            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
		                @Override
		                public void handle(MouseEvent event) {
		                	System.out.println(item.getProperties());
		                		 

		                }
		            });

		        });
		    }
		

}