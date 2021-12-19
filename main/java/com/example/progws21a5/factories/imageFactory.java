package com.example.progws21a5.factories;

import java.io.File;

import javafx.scene.image.Image;

public class imageFactory {
    private static imageFactory imgFactory;

    private imageFactory() {

    }

    public static imageFactory getImageFactory() {
        if (imgFactory == null) {
            return imgFactory = new imageFactory();
        }

        return imgFactory;
    }

    public Image getImage(String name, double width, double height) {
        File file = getFile(name);
        assert file != null;
        return new Image(file.toURI().toString(), width, height, false, true);

    }

    public Image getImage(String name) {
        File file = getFile(name);
        assert file != null;
        return new Image(file.toURI().toString());
    }

    private File getFile(String name) {
        return switch (name) {
            case "tuberose" -> new File("src/main/java/com/example/progws21a5/pictures/tuberose.png");
            case "redsmurf" -> new File("src/main/java/com/example/progws21a5/pictures/redsmurf.png");
            case "bluesmurf" -> new File("src/main/java/com/example/progws21a5/pictures/bluesmurf.png");
            case "greensmurf" -> new File("src/main/java/com/example/progws21a5/pictures/greensmurf.png");
            case "yellowsmurf" -> new File("src/main/java/com/example/progws21a5/pictures/yellowsmurf.png");
            case "lake" -> new File("src/main/java/com/example/progws21a5/pictures/lake.png");
            case "Pilz" -> new File("src/main/java/com/example/progws21a5/pictures/Pilz.png");
            case "Bzz" -> new File("src/main/java/com/example/progws21a5/pictures/Bzz.png");
            case "dorf" -> new File("src/main/java/com/example/progws21a5/pictures/dorf.png");
            case "arrowright" -> new File("src/main/java/com/example/progws21a5/pictures/arrowright.png");
            case "arrowleft" -> new File("src/main/java/com/example/progws21a5/pictures/arrowleft.png");
            case "arrow" -> new File("src/main/java/com/example/progws21a5/pictures/arrow.png");
            case "background" -> new File("src/main/java/com/example/progws21a5/pictures/background.jpg");
            case "Schlumpfine" -> new File("src/main/java/com/example/progws21a5/pictures/Schlumpfine.png");
            case "Doc" -> new File("src/main/java/com/example/progws21a5/pictures/Oberschlumpf.png");
            case "ROCK" -> new File("src/main/java/com/example/progws21a5/pictures/ROCK.png");
            default -> null;
        };
    }
}
