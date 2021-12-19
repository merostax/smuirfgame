package com.example.progws21a5.button;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class loadGameButton extends button {

	@Override
	public void setName() {
		File file = new File("src/main/java/com/example/progws21a5/pictures/LOADGAME.png");
		Image img = new Image(file.toURI().toString());
		image = new ImageView(img);
	}

	@Override
	public void setAction() {
		b.setOnMouseClicked(arg0 -> handler.loadGame());
	}
}
