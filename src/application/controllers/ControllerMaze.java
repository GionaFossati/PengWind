package application.controllers;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

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
	void shortcutEvent(KeyEvent event) {
		System.out.println(event.getCode());
		switch (event.getCode()) {
        case C:
        	changeDirectionPressed();
			btnChangeMove.setDisable(true);
			break;
        case M:
        	goOnPressed();
			btnChangeMove.setDisable(false);
			break;
        default:
            break;
        }
	}

//	    function that moves penguin and enemies
	@FXML
	public void goOnPressed() {
		movePenguin();
//		moveEnemies();
		btnChangeMove.setDisable(false);
	}

//	    function that triggers the change direction
	public Integer[] movementDirection = new Integer[2];
	private int[] points = new int[] { -1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 1, -1, 1, 0, 1, 1 };

	@FXML
	public void changeDirectionPressed() {
		btnChangeMove.setDisable(true);
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
			int newY = pengCoord[0] + dy;

			if (canMove(newY, newX)) {
				playField.add(btnMovement.get(i), newX, newY);
			}

			btnMovement.get(i).setOnMouseClicked(e -> {
				movementDirection[0] = dy;
				movementDirection[1] = dx;
				removeChangeDirButtons(pengCoord);
				System.out.println(
						"New movement direction -  X: " + movementDirection[0] + " Y: " + movementDirection[1]);

			}

			);
		}
	}

	private boolean canMove(int Y, int X) {
		boolean response;
		System.out.println(getNodeByRowColumnIndex(Y, X, playField));
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

	public Node getNodeByRowColumnIndex (int Y, int X, GridPane playField) {
	    Node result = null;
	    ObservableList<Node> childrens = playField.getChildren();
//	    System.out.println(childrens);
//	    for (Node node : childrens) {
//	        if(GridPane.getRowIndex(node) == null && GridPane.getColumnIndex(node) == null) {
//	            result =  ;
//	            break;
//	        }
//	    }

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

		if (coord[1] == null) {
			coord[1] = 0;
		}

		if (coord[0] == null) {
			coord[0] = 0;
		}

		System.out.println(coord[0] + " " + coord[1]);

		return coord;
	}
	
	private boolean windDetected() {
   	 	ByteArrayOutputStream byteArrayOutputStream;
        TargetDataLine targetDataLine;
        int count;
        boolean stopCapture = false;
        byte tempBuffer[] = new byte[8000];
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