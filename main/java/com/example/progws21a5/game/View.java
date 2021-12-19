package com.example.progws21a5.game;
import com.example.progws21a5.Controller.eventHandler;
import com.example.progws21a5.factories.sceneFactory;
import com.example.progws21a5.layouts.ExitConfrmationWindow;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class View extends Application {
    private Scene scene;
    private static Stage window;
    private static sceneFactory factory;

    @Override
    public void start(Stage arg0) {
        factory = sceneFactory.getSceneFactory();
        window = arg0;
        window.setTitle("Schlumpfe-Spiel");
        window.setResizable(false);
        setDimentions();
        scene = factory.getScene("Game", window.getHeight(), window.getWidth());
        setScene();
        setExitConfirmation();
        window.show();
        eventHandler.getInstance().viewIsReady();

    }

    private void setDimentions() {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());

    }

    private void setExitConfirmation() {
        window.setOnCloseRequest(event -> {
                event.consume();
                ExitConfrmationWindow.display();

        });
    }

    public void setScene(final String name) {
        Platform.runLater(() -> {
            scene = factory.getScene(name, window.getHeight(), window.getWidth());
            window.setScene(scene);
        });
    }
    public void setScene(final Scene newScene) {
        Platform.runLater(() -> {
            scene = newScene;
            window.setScene(scene);
        });
    }

    private void setScene() {
        Platform.runLater(() -> {
            if (window != null) {
                window.setScene(scene);
            }
        });
    }

    public double getWidth() {
        return window.getWidth();
    }
    public double getHeight() {
        return window.getHeight();
    }

    public void exit() {
        Platform.exit();
    }

}
