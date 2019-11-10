package application.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ControllerMaze {
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
    @FXML
    private Text gameStateText;
	
	public Integer[] movementDirection = new Integer[2];
	private int[] pointsAroundCell = new int[] { -1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 1, -1, 1, 0, 1, 1 };


	@FXML
	void shortcutEvent(KeyEvent event) throws IOException {
		System.out.println(event.getCode());
		switch (event.getCode()) {
        case C:
        	changeDirectionPressed();
			btnChangeMove.setDisable(true);
			break;
        case M:
        	movePenguin();
    		btnChangeMove.setDisable(false);
			break;
        default:
            break;
        }
	}

//	function that moves penguin and enemies
	@FXML
	public void goOnPressed() throws IOException {
		movePenguin();
//		moveEnemies();
		btnChangeMove.setDisable(false);
		System.out.println(getCoord(penguinUser) +"  "+ getCoord(penguinUser));
		
		if (Arrays.equals(getCoord(penguinUser), getCoord(icebergOne))) {
			
			gameOver();
		}
	}

//	    function that triggers the change direction
	@FXML
	public void changeDirectionPressed() throws IOException {
		btnChangeMove.setDisable(true);
		System.out.println("pressed change dir");
		gameStateText.setText("Ok, now press the button in the cell you wish to go");
		btnMovement = new ArrayList<Button>();

		for (int k = 0; k < pointsAroundCell.length; k++) {
			Button btn = new Button();
			btn.getStyleClass().add("changepossible");
			btn.setPrefSize(20, 20);
			btn.setId("movementBtn");
			btnMovement.add(btn);
		}

		Integer[] pengCoord = getCoord(penguinUser);

		for (int i = 0; i < pointsAroundCell.length; i++) {
			int dy = pointsAroundCell[i];
			int dx = pointsAroundCell[++i];

			int newX = pengCoord[1] + dx;
			int newY = pengCoord[0] + dy;

			if (canMove(newY, newX)) {
				playField.add(btnMovement.get(i), newX, newY);
				GridPane.setHalignment(btnMovement.get(i), HPos.CENTER);
			}

			btnMovement.get(i).setOnMouseClicked(e -> {
				movementDirection[0] = dy;
				movementDirection[1] = dx;
				removeChangeDirButtons(pengCoord);
				gameStateText.setText("Direction Changed! Now press the M key to start moving!");
				System.out.println(
						"New movement direction -  X: " + movementDirection[0] + " Y: " + movementDirection[1]);

			}

			);
			
//			System.out.println(getCoord(penguinUser));
//			System.out.println(getCoord(icebergOne));
//			if (getCoord(penguinUser) == getCoord(familyGroup) || getCoord(penguinUser) == getCoord(icebergOne)
//					|| getCoord(penguinUser) == getCoord(icebergTwo) || getCoord(penguinUser) == getCoord(familyGroup)) {
//				gameOver();
//		}
		}
	}

	
	private boolean canMove(int Y, int X) {
		boolean response;
//		controls if it's trying to move out of grid or if there's an iceberg in the next cell 
		System.out.println("can move in Y: " + Y);
		System.out.println("can move in X: " + X);
		
		if (X >= 0 && Y >= 0 && X < 9 && Y < 9 /*&& getNodeByRowColumnIndex(Y, X) == null*/) {
			response = true;
		} else {
			response = false;
		}

		return response;
	}

	public Node getNodeByRowColumnIndex (int Y, int X) {
	    Node result = null;
	    Integer rowIndex = 0;
	    Integer columnIndex = 0;
	    ObservableList<Node> children = playField.getChildren();
	    for (Node node : children) {
	    	
	    	rowIndex = GridPane.getRowIndex(node) == null ? 0 : GridPane.getRowIndex(node);
	    	columnIndex = GridPane.getColumnIndex(node) == null ? 0 : GridPane.getColumnIndex(node);
	        
	    	if(rowIndex == Y && columnIndex == X) {
	            result = node;
	            break;
	        } 
	    }

	    return result;
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

		if ((canMove(newY, newX) && windDetected() ) == true) {
			playField.getChildren().remove(penguinUser);
			playField.add(penguinUser, newY, newX);
			gameStateText.setText("Penguin Moved!! Let's continue the game!");

		} else {
			System.out.println("I don't move otherwise you will go over smth or out of grid:  " + getNodeByRowColumnIndex(newY, newX) );
			gameStateText.setText("Better not to go in that direction! Maybe you could try change it..");
		}

	}

	private Integer[] getCoord(ImageView gridNode) {
//			cord[0] = row index --> Y
//			cord[1] = column index --> X

		Integer[] coord = new Integer[2];
		coord[0] = (Integer) gridNode.getProperties().get("gridpane-row");
		coord[1] = (Integer) gridNode.getProperties().get("gridpane-column");

		if (coord[1] == null) {
			coord[1] = 0;
		}

		if (coord[0] == null) {
			coord[0] = 0;
		}

		System.out.println(coord[0] + " " + coord[1]);

		return coord;
	}
	
	private void gameOver() throws IOException {
		
		//create the dialog box for when the game ends
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("GAME OVER");
		alert.setContentText("what do you want to do next?");
		ButtonType buttonRestart = new ButtonType("Play again");
		ButtonType buttonQuit = new ButtonType("Quit");
		alert.getButtonTypes().setAll(buttonRestart, buttonQuit);
		
		// event handling for restarting the game and quitting the game
		Optional<ButtonType> buttonPressed = alert.showAndWait();
		if (buttonPressed.get() == buttonRestart) {
			Parent loader = FXMLLoader.load(getClass().getResource("/application/views/rootMaze.fxml"));
			Scene sceneMaze = new Scene(loader, 800, 800);
			Stage stage = (Stage) penguinUser.getScene().getWindow();
			stage.setScene(sceneMaze);
		}
		if (buttonPressed.get() == buttonQuit) {
			System.exit(0);
		}
	}
	
	private boolean windDetected() {
   	 	ByteArrayOutputStream byteArrayOutputStream;
        TargetDataLine targetDataLine;
        int count;
        boolean stopCapture = false;
        byte tempBuffer[] = new byte[3800];
        int countzero, timeInSeconds;    
        short convert[] = new short[tempBuffer.length];
        boolean blowDetected = false;
        
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            stopCapture = false;
            timeInSeconds = 0;
            
            System.out.println("Starting microphone detection test...");
            
            while (!stopCapture) {
                AudioFormat audioFormat = new AudioFormat(8000.0F, 16, 1, true, false);
                DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
                targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
                targetDataLine.open(audioFormat);
                targetDataLine.start();
                count = targetDataLine.read(tempBuffer, 0, tempBuffer.length);
                byteArrayOutputStream.write(tempBuffer, 0, count); 
                
                try {
                	
                	// Byte Size
                    countzero = 0;
                    
                    for (int i = 0; i < tempBuffer.length; i++) {                                     
                        convert[i] = tempBuffer[i];
                        
                        if (convert[i] == 0) {
                            countzero++;
                        }
                        
                    }
                     
                   timeInSeconds++;
                    
                    /* Checks if lower than 800 bytes
                     * 800 bytes is low enough volume to block out unwanted noises
                     */
                    if (countzero < 800) {
                   	 	blowDetected = true;
                   	 	System.out.println(blowDetected + ": " + countzero + " bytes detected at " + timeInSeconds + " seconds");
                   	 	break;
                    } 
 
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                    return blowDetected;
                }
                
                Thread.sleep(0);
                targetDataLine.close();
            }
        } catch (Exception e) {
            System.out.println(e);
            return blowDetected;
        }
        
        return blowDetected;
        
   }
	
	

}