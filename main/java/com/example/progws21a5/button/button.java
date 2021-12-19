package com.example.progws21a5.button;

import com.example.progws21a5.Controller.eventHandler;
import com.example.progws21a5.factories.imageFactory;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public abstract class button {
    protected Button b;
    protected eventHandler handler = eventHandler.getInstance();
    protected imageFactory imgFactory = imageFactory.getImageFactory();
    protected ImageView image;

    public button() {
        createButton();
        setName();
        setAction();
        setStyle();
    }

    public Button getButton() {
        return b;
    }

    private void createButton() {
        b = new Button();
    }

    protected void setStyle() {
        image.setFitHeight(75);
        image.setFitWidth(200);
        b.setGraphic(image);
        b.setStyle("-fx-background-color:#ffb833;" + "-fx-background-radius: 30;" + "-fx-padding: 10 20 10 20");
    }
 
    public abstract void setName();

    public abstract void setAction();
}
