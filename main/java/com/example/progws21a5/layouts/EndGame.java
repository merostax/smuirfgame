package com.example.progws21a5.layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndGame extends layout {
    private Group root = new Group();
    private String winnerName = "";
    private  Label winner;

    public EndGame(double height, double width) {
        super(height, width);
        addBackground();
        addButton();
        addWinner();
        scene = new Scene(root, windowWidth, windowHeight);
    }
    private void addWinner() {
        winner = new Label();
        winner.setText(winnerName);
        winner.setTextFill(Color.web("#FFCA28"));
        winner.setFont(Font.font("Cambria", FontWeight.BOLD, 60));
        winner.setLayoutX(windowWidth * 0.3);
        winner.setLayoutY(windowHeight * 0.5);
        root.getChildren().add(winner);

    }

    private void addButton() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(windowHeight - 150, windowWidth / 2 - 70, 100, windowWidth / 2 - 140));
        vBox.getChildren().add(factory.getButton("Main Menu").getButton());
        root.getChildren().add(vBox);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
    }

    private void addBackground() {
        Image background = imgFactory.getImage("end", windowWidth, windowHeight);
        ImageView img = new ImageView(background);
        root.getChildren().add(img);
    }
    public void setWinner (String winnerName) {
    	this.winnerName = winnerName;
        winner.setText(winnerName);
    }

}
