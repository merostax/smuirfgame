package com.example.progws21a5.button;

import java.io.File;

import de.ostfalia.prog.ws21.exceptions.FalscheSpielerzahlException;
import de.ostfalia.prog.ws21.exceptions.WiederholteFarbenException;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class newGameButton extends button {

    @Override
    public void setAction() {
        b.setOnMouseClicked(arg0 -> {
            try {
                handler.NewGame();
            } catch (FalscheSpielerzahlException e) {
                e.printStackTrace();
            } catch (WiederholteFarbenException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void setName() {
        File file = new File("src/main/java/com/example/progws21a5/pictures/NEWGAME.png");
        Image img = new Image(file.toURI().toString());
        image = new ImageView(img);
    }

}
