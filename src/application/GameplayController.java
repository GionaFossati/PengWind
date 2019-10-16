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
		            int dy = points[i];
		            int dx = points[++i];

		            int newX = pengCoord[1] + dx;
		            int newY = pengCoord[0]+ dy;
		            
					 if (canMove(newY,newX)) {
						 playField.add(btnMovement.get(i), newX, newY);
					 }
					 
					 
					 btnMovement.get(i).setOnMouseClicked(
								e -> {
										movementDirection[0] = dy;
										movementDirection[1] = dx;
										removeChangeDirButtons(pengCoord);
										System.out.println("New movement direction -  X: " + movementDirection[0] + " Y: " + movementDirection[1]);
										
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
	    
	    private Node getNodeFromPlayField(int Y, int X) {
		    for (Node node : playField.getChildren()) {
		        if (GridPane.getColumnIndex(node) == X && GridPane.getRowIndex(node) == Y) {
		            return node;
		        }
		    }
		    return null;
		}
	    
	    private void removeChangeDirButtons(Integer[] pengCoord) {
		    	for (Button btn : btnMovement) {
		    		playField.getChildren().remove(btn);
		    	}
	    	}
			 
	    
		private void movePenguin() {
			Integer[] pengCoord = getCoord(penguinUser);
			
			Integer newY = pengCoord[1] + movementDirection[1];
			Integer newX = pengCoord[0] + movementDirection[0];
			
			System.out.println("new X=" + newX);
			System.out.println("new Y=" + newY);
			System.out.println("Movement direction -  X: " + movementDirection[0] + " Y: " + movementDirection[1]);
			
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