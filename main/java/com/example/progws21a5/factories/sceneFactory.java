package com.example.progws21a5.factories;

import com.example.progws21a5.layouts.EndGame;
import com.example.progws21a5.layouts.Start;
import com.example.progws21a5.layouts.layout;
import javafx.scene.Scene;

public class sceneFactory {
    private static sceneFactory sceneFactory;

    private sceneFactory() {
    }

    public static sceneFactory getSceneFactory() {
        if (sceneFactory == null) {
            return sceneFactory = new sceneFactory();
        }

        return sceneFactory;
    }

    public Scene getScene(String name, double Height, double Width) {
        layout scene;
        switch (name) {
            case "Game":
                scene = new Start(Height, Width);
                break;
            case "EndGame":
                scene = new EndGame(Height, Width);
                break;
            default:
                return null;
        }

        return scene.getScene();

    }
}
