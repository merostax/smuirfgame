package com.example.progws21a5.Controller;
import com.example.progws21a5.game.View;
import com.example.progws21a5.layouts.EndGame;
import com.example.progws21a5.layouts.ExitConfrmationWindow;
import com.example.progws21a5.layouts.Game;
import com.example.progws21a5.layouts.Start;
import de.ostfalia.prog.ws21.exceptions.FalscheSpielerzahlException;
import de.ostfalia.prog.ws21.exceptions.WiederholteFarbenException;

public class eventHandler {

    private static eventHandler handler;
    private View view;
    private musicPlayer music;

    public static eventHandler getInstance() {
        if (handler == null)
            handler = new eventHandler();
        return handler;
    }

    public void viewIsReady() {
        music = new musicPlayer();
        music.startMusic();
    }

    public void NewGame() throws FalscheSpielerzahlException, WiederholteFarbenException {
        view = new View();
        Game gameScene = new Game(view.getHeight(), view.getWidth());
        view.setScene(gameScene.getScene());
    }



    public void continueGame() {

    }
    public void saveGame() {
    }

    public void loadGame() {

    }
    public void EndProgram() {
        view.exit();
    }

    public void ExitConfirmation() {
        System.out.println("exit confirmation");
        ExitConfrmationWindow.display();
    }


    public void EndGame(String winnerName) {
        EndGame scene = new EndGame(view.getHeight(), view.getWidth());
        scene.setWinner(winnerName);
        view.setScene(scene.getScene());
    }





    public void musicButtonPressed() {
        if (music.isPlaying()) {
            music.stopMusic();
        } else {
            music.startMusic();
        }
    }



}
