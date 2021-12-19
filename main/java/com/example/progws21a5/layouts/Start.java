package com.example.progws21a5.layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Start extends layout {

    private Group root = new Group();
    private static final String[] BUTTONS = { "New Game", "Load Game", "Exit" };

    public Start(double height, double width) {
        super(height, width);
        setBackground();
        setButtons();
        setMusicButton();
        scene = new Scene(root, windowWidth, windowHeight);

    }

    private void setMusicButton() {
    	Button music = factory.getButton("music").getButton();
    	music.setAlignment(Pos.TOP_LEFT);
		VBox v = new VBox();
		v.getChildren().add(music);
		v.setPadding(new Insets(30, 0, 0, 50));
		root.getChildren().add(v);
	}

	private void setButtons() {
		VBox vbox = new VBox(30);
        for (String crnt : BUTTONS)
            vbox.getChildren().add(factory.getButton(crnt).getButton());
        vbox.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().add(vbox);
        vbox.setPadding(new Insets(windowHeight - 700, 50, 150, windowWidth - 300));
    }


    private void setBackground() {
        Image background = imgFactory.getImage("background", windowWidth, windowHeight);
        ImageView img = new ImageView(background);
        root.getChildren().add(img);
    }

}
