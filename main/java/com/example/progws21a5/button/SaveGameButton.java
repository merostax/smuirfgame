package com.example.progws21a5.button;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SaveGameButton extends button {

    @Override
    public void setName() {
        File file = new File("src/main/java/com/example/progws21a5/pictures/SAVEGAME.png");
        Image img = new Image(file.toURI().toString());
        image = new ImageView(img);
    }

    @Override
    protected void setStyle() {
        b.setStyle("-fx-background-color:rgba(38,124,25,0.89);");
        b.setLayoutX(200);
        b.setLayoutY(200);
    }

    @Override
    public void setAction() {

    }
}
