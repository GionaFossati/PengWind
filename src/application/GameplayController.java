package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


public class GameplayController {
//		GamePlay Controller ˅˅˅˅
	    
		private ArrayList<Button> btnMovement;
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
	    
//	    listener for keypressed (is in the main AnchorPane)	    
	    @FXML
	    void shortcutFunction(KeyEvent event) {
	    	if (event.getCode() == KeyCode.SPACE) {
                goOnPressed();
            } else if (event.getCode() == KeyCode.C) {
            	changeDirectionPressed();
            }
	    }
	    
//	    function that moves penguin and enemies
	    @FXML
		public void goOnPressed() {
								movePenguin();
//								moveEnemies();
		}
	    
//	    function that triggers the change direction
	    public Integer[] movementDirection = new Integer[2];
	    private int[] points = new int[] {
	              -1, -1,
	              -1, 0,
	              -1, 1,
	              0, -1,
	              0, 1,
	              1, -1,
	              1, 0,
	              1, 1
	              };
	    @FXML
		public void changeDirectionPressed() {
			System.out.println("pressed change dir");
			btnMovement = new ArrayList<Button>();
			
			for (int k = 0; k < points.length; k++) {
		            Button btn = new Button();
					 btn.getStyleClass().add("changepossible");
					 btn.setPrefSize(20, 20);
					 btn.setId("movementBtn");
					 btnMovement.add(btn);
			 }
			
			Integer[] pengCoord = getCoord(penguinUser);
			 
			for (int i = 0; i < points.length; i++) {
		            int dx = points[i];
		            int dy = points[++i];

		            int newX = pengCoord[1] + dx;
		            int newY = pengCoord[0]+ dy;
		            
					 // problem: I want to remove buttons but I don't understand how, maybe from fx-id. But, how can i set an fxid to each button?
//					 if statement used to avoid to add points outside the grid and modify col & row number
					 if (canMove(newY,newX)) {
						 playField.add(btnMovement.get(i), newX, newY);
					 }
					 
					 
					 
					 btnMovement.get(i).setOnMouseClicked(
								e -> {
										movementDirection[0] = dx;
										movementDirection[1] = dy;
										removeChangeDirButtons(pengCoord);
										System.out.println("New movement direction -  Column: " + movementDirection[0] + " Row: " + movementDirection[1]);
										
								}
							
						);
			 }	
	    }
	    
	    private boolean canMove (int Y, int X) {
	    	 boolean response;
	    	 if (X != -1 && Y != -1 && X < 10 && Y < 8) {
				 response = true;
			 } else {
				 response = false;
			 }
	    	return response;
	    }
	    
	    private void removeChangeDirButtons(Integer[] pengCoord) {
		    	for (Button btn : btnMovement) {
		    		playField.getChildren().remove(btn);
		    	}
	    	}
			 
	    
		private void movePenguin() {
			Integer[] pengCoord = getCoord(penguinUser);
			
			Integer newX = pengCoord[1] + movementDirection[1];
			Integer newY = pengCoord[0] + movementDirection[0];
			
			System.out.println("new X=" +newX);
			System.out.println("new Y=" + newY);
			
			if (canMove(newY, newX)) {
				playField.getChildren().remove(penguinUser);
				playField.add(penguinUser, newY, newX);
			
			} else {
				System.out.println("I don't move otherwise you will go out of bounds!");
			}
			
		}
		
		private Integer[] getCoord(ImageView gridNode) {
//			cord[0] = row index --> Y
//			cord[1] = column index --> X
			
			Integer[] coord = new Integer[2];
			coord[0] = (Integer) gridNode.getProperties().get("gridpane-row");
			coord[1] = (Integer) gridNode.getProperties().get("gridpane-column");
			
			if (coord[1] == null)  {
				coord[1] = 0;
			}
			
			if (coord[0] == null)  {
				coord[0] = 0;
			}
			

			System.out.println(coord[0] + " " + coord[1]);
			
			return coord;
		}
		
}