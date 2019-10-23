package application;
	
import java.io.IOException;

import application.controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane mainLayout;
	private Scene scene;
	private GameplayController c = new GameplayController();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("PengWind");
		showUI();
		startGame();
	}
	
//	FXML SceneBuilder Loader
	private void showUI() throws IOException {
		
//		load the FXML file
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/views/gameScene.fxml"));
		mainLayout = loader.load();
		
//		add the FXLM SceneBuilder to the Scene
		scene = new Scene(mainLayout);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		
//		lock window resize
		primaryStage.setResizable(false);
		
		primaryStage.show();
	}
	
//	FXML SceneBuilder Loader
	private void startGame() throws IOException {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
