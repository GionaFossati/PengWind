package application;

//import application.models.CharacterModel;
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

    private static Scene sceneCharacterName;
    
    //private CharacterModel myModel;

	@Override
	public void start(Stage primaryStage) {
		
		Main.primaryStage = primaryStage;

		
		try {
			
			rootCharacterName = FXMLLoader.load(getClass().getResource("/application/views/rootCharacterName.fxml"));
			sceneCharacterName = new Scene(rootCharacterName, 800, 800);
			//in this ImageView
			FlowPane root = new FlowPane();
			
			root.setAlignment(Pos.CENTER);
			Scene scene = new Scene(root,400,400);
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
   
	
	public static void main(String[] args) {
		launch(args);
	}
}
