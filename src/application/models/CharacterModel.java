package application.models;

import javafx.scene.image.Image;

public class CharacterModel {
	
	private static Image characterImage;
	private static String characterName;
	
	//constructors
	public CharacterModel(String name, Image image) {
		CharacterModel.characterName = name;
		CharacterModel.characterImage = image;
	}
	
	public CharacterModel(String name) {
		CharacterModel.characterName = name;
	}
	
	public CharacterModel() {
		
	}
	
	public void setImage(Image image) {
		CharacterModel.characterImage = image;
	}
	
	public void setName(String name) {
		CharacterModel.characterName = name;
	}
	
	public Image getImage() {
		return characterImage;
	}
	
	public String getName() {
		return characterName;
	}

}
