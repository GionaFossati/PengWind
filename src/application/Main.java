package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;


public class Main extends Application {
	
	private static Stage primaryStage;
    private static Parent rootCharacterName;
    private static Parent rootCharacterCustom;
    private static Parent rootMazeSelect;
    private static Parent rootMaze;
    private static Scene sceneCharacterName;
    private static Scene sceneCharacterCustom;
    private static Scene sceneMazeSelect;
    private static Scene sceneMaze;

	@Override
	public void start(Stage primaryStage) {
		
		Main.primaryStage = primaryStage;

		
		try {
			
			rootCharacterName = FXMLLoader.load(getClass().getResource("/application/views/rootCharacterName.fxml"));
			rootCharacterCustom = FXMLLoader.load(getClass().getResource("/application/views/rootCharacterCustom.fxml"));
			rootMazeSelect = FXMLLoader.load(getClass().getResource("/application/views/rootMazeSelect.fxml"));
			rootMaze = FXMLLoader.load(getClass().getResource("/application/views/rootMaze.fxml"));
			
			sceneCharacterName = new Scene(rootCharacterName, 800, 800);
			sceneCharacterCustom = new Scene(rootCharacterCustom, 800, 800);
			sceneMazeSelect = new Scene(rootMazeSelect, 800, 800);
			sceneMaze = new Scene(rootMaze, 800, 800);

			
//			Rectangle rec = new Rectangle(100,50);
//			rec.setFill(Color.CORAL);
//			rec.setRotate(30);
//			
//			Ellipse cir = new Ellipse(100, 50);
//			cir.setFill(Color.AQUAMARINE);
//			cir.setRotate(30);

			//in this ImageView
			FlowPane root = new FlowPane();
			
			root.setAlignment(Pos.CENTER);
			Scene scene = new Scene(root,400,400);
//			root.getChildren().addAll(rec,cir);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			goToCharacterNameScene();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void goToCharacterNameScene()
    {
        primaryStage.setScene(sceneCharacterName);
    }
    
    public static void goToCharacterCustomScene()
    {
        primaryStage.setScene(sceneCharacterCustom);
    }
    
    public static void goToMazeSelectScene()
    {
        primaryStage.setScene(sceneMazeSelect);
    }
    
    public static void goToMazeScene()
    {
        primaryStage.setScene(sceneMaze);
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
