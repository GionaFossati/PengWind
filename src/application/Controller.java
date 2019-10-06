package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


public class Controller {
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
	    
//	    listener for keypressed (is in the main AnchorPane)	    
	    @FXML
	    void shortcutFunction(KeyEvent event) {
	    	if (event.getCode() == KeyCode.SPACE) {
                goOnPressed();
//                System.out.println("detected");
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
			Integer[] pengCoord = getCoord(penguinUser);
			 
			 for (int i = 0; i < points.length; i++) {
		            int dx = points[i];
		            int dy = points[++i];

		            int newX = pengCoord[1] + dx;
		            int newY = pengCoord[0]+ dy;

		            Button btn = new Button();
					 btn.getStyleClass().add("changepossible");
					 btn.setPrefSize(20, 20);
					 
					 // problem: I want to remove buttons but I don't understand how, maybe from fx-id. But, how can i set an fxid to each button?
//					 if statement used to avoid to add points outside the grid and modify col & row number
					 if (newX != -1 && newY != -1 && newX != 8 && newY != 8) {
						 playField.add(btn, newX, newY);
					 }
					 
					 btn.setOnMouseClicked(
								e -> {
										movementDirection[0] = dx;
										movementDirection[1] = dy;
										removeChangeDirButtons(pengCoord);
										System.out.println("New movement direction -  Column: " + movementDirection[0] + " Row: " + movementDirection[1]);
									}
							
						);
			 }	
	    }
	    
	    private void removeChangeDirButtons(Integer[] pengCoord) {
//				 look at line 83
	    }
		
	    
		private void movePenguin() {
			Integer[] pengCoord = getCoord(penguinUser);
			
			String INT_X = movementDirection[1].toString();
			String INT_Y = movementDirection[0].toString();
			
			System.out.println("Move – X: " + INT_X + " Y: " + INT_Y);
			
			playField.add(penguinUser, pengCoord[1] + Integer.parseInt(INT_X) ,pengCoord[0] + Integer.parseInt(INT_Y));
			
		}
		
		private Integer[] getCoord(ImageView gridNode) {
//			coord[0] = row index
//			coord[1] = column index
			
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