package com.example.progws21a5.button;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class musicButton extends button {

	@Override
	public void setName() {
		File file = new File("src/main/java/com/example/progws21a5/pictures/sound.png");
		Image img = new Image(file.toURI().toString());
		image = new ImageView(img);

	}

	@Override
	public void setAction() {
		b.setOnMouseClicked(arg0 -> handler.musicButtonPressed());
	}

	@Override
	protected void setStyle() {
		image.setFitHeight(30);
		image.setFitWidth(30);
		b.setGraphic(image);
        b.setStyle("-fx-background-radius: 30;" + "-fx-padding: 3 5 3 5");

	}

}
