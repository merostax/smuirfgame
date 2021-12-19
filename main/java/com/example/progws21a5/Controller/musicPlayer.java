package com.example.progws21a5.Controller;
import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class musicPlayer {
    private final String musicPath = "Background.mp3";
    private boolean pause;
    private MediaPlayer mediaPlayer;
    private Media media;
    private Runnable repeat;

    public musicPlayer() {
        File f = new File(musicPath);
        media = new Media(f.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        repeat = () -> {
            if (!pause) {
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setOnEndOfMedia(repeat);
                mediaPlayer.play();
            }
        };
    }

    public void startMusic() {
        pause = false;
        mediaPlayer.setOnEndOfMedia(repeat);
        mediaPlayer.play();
    }


    public void stopMusic() {
        mediaPlayer.stop();
        pause = true;
    }

    public boolean isPlaying() {
        return !pause;
    }

}
