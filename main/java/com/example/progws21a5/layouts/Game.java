package com.example.progws21a5.layouts;

import com.example.progws21a5.button.SaveGameButton;
import com.example.progws21a5.button.bewegebutton;
import com.example.progws21a5.button.wurfelbutton;
import de.ostfalia.prog.ws21.enums.Farbe;
import de.ostfalia.prog.ws21.enums.Richtung;
import de.ostfalia.prog.ws21.exceptions.FalscheSpielerzahlException;
import de.ostfalia.prog.ws21.exceptions.WiederholteFarbenException;
import de.ostfalia.prog.ws21.interfaces.Figur;
import de.ostfalia.prog.ws21.interfaces.IZombieSchluempfe;
import de.ostfalia.prog.ws21.mainZomieschlumpfe.ZombieSchluempfe;
import de.ostfalia.prog.ws21.wurfel.Wurfel;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static de.ostfalia.prog.ws21.mainZomieschlumpfe.ZombieSchluempfe.spieleranzahl;

public class Game extends layout {
    private Group root;
    private TextField textField;
    private TextField textreadField;
    private String textread;
    private String text = "4";
    private bewegebutton bewegebutton = new bewegebutton();
    private wurfelbutton wurfelbutton = new wurfelbutton();
    private Button weiter = new Button();
    private Button abzweigen = new Button();
    ImageView rock1;
    ImageView rock2;
    ImageView rock3;
    ImageView rock4;
    ImageView rock5;
    ImageView rock6;
    ImageView rock7;
    ImageView rock8;
    ImageView rock9;
    ImageView rock10;
    ImageView rock11;
    ImageView rock12;


    ImageView rock13;
    ImageView rock14;
    ImageView rock15;
    ImageView rock16;
    ImageView rock17;
    ImageView rock18;
    ImageView rock19;
    ImageView rock20;
    ImageView rock21;
    ImageView rock22;
    ImageView rock23;
    ImageView rock24;
    ImageView rock25;
    ImageView rock26;
    ImageView rock27;
    ImageView rock28;
    ImageView rock29;
    ImageView rock30;
    ImageView rock31;
    ImageView rock32;
    ImageView rock33;
    ImageView rock34;
    ImageView rock35;
    ImageView rock0;
    ImageView dorf;

    ImageView Schlumpfine;
    ImageView Bzz;
    ImageView BLAUA;
    ImageView BLAUB;
    ImageView BLAUC;
    ImageView BLAUD;
    ImageView ROTA;
    ImageView ROTB;
    ImageView ROTC;
    ImageView ROTD;
    ImageView GRUENA;
    ImageView GRUENB;
    ImageView GRUENC;
    ImageView GRUEND;
    ImageView GELBA;
    ImageView GELBB;
    ImageView GELBC;
    ImageView GELBD;
    List<ImageView> rocks = new ArrayList<>();


    IZombieSchluempfe spieler;

    public Game(double height, double width) throws FalscheSpielerzahlException, WiederholteFarbenException {

        super(height, width);
        Group root = setLayout();
        setMusicButton();
        setmap();
        setplayers();
        setButtons();
        settext();
        scene = new Scene(root, windowWidth, windowHeight);

    }

    private void settext() {
        textreadField = new TextField();
        textreadField.setPromptText("Hier schreiben ...");
        textreadField.setLayoutX(650);
        textreadField.setLayoutY(630);
        textreadField.setPrefWidth(280);
        textreadField.setPrefHeight(50);
        textreadField.setStyle(""
                + "-fx-font-size: 50px;"
                + "-fx-font-weight: bolder;"
                + "-fx-font-family: fantasy;");
        textreadField.setStyle("-fx-background-color:#7b8621;");
        textField = new TextField();
        textField.setPromptText("Geben Sie bitte die Anzahl der Spieler ein   ");
        textField.setLayoutX(350);
        textField.setLayoutY(630);
        textField.setPrefWidth(280);
        textField.setPrefHeight(50);
        textField.setStyle(""
                + "-fx-font-size: 50px;"
                + "-fx-font-weight: bolder;"
                + "-fx-font-family: fantasy;");
        textField.setStyle("-fx-background-color:#7b8621;");
        textread = textField.getText();
        root.getChildren().addAll(textField, textreadField);


        wurfelbutton.setOnMouseClicked(e -> {
            Wurfel wurfel = new Wurfel();
            String wurfelName = wurfel.wurfel();
            textField.setText(" Sie haben  " + wurfelName + " gewurfelt");
            text = wurfelName;
            if (text.equals("Bzz") || text.equals("Schlumpfine")) {
                String figur = "";
                figur = wurfelName;
                while (wurfelName.equals("Bzz") || wurfelName.equals("Schlumpfine")) {

                    wurfelName = wurfel.wurfel();
                }
                String finalFigur = figur;
                String finalWurfelName = wurfelName;
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                text = finalWurfelName;
                                textField.setText("Fur " + finalFigur + " wurde " + finalWurfelName + " gewurfelt");

                            }
                        },
                        2000
                );
            }

        });
        bewegebutton.setOnMouseClicked(ee -> {
            textField.setText("Tragen Sie bitte der Name von der Figur ein, dass Sie bewegen mochten: ");
            textreadField.setOnAction(e -> textread = textreadField.getText());
        });
        abzweigen.setOnMouseClicked(e -> movefigur(textread, text, Richtung.ABZWEIGEN));
        weiter.setOnMouseClicked(e -> movefigur(textread, text, Richtung.WEITER));
        textField.setOnAction(e -> {
            int spieleranzahl = Integer.parseInt(text);
            List<Farbe> anzahlspieler = null;
            try {
                anzahlspieler = spieleranzahl(spieleranzahl);
            } catch (FalscheSpielerzahlException ex) {
                ex.printStackTrace();
            }
            spieler = null;
            try {
                assert anzahlspieler != null;
                spieler = new ZombieSchluempfe(anzahlspieler.toArray(Farbe[]::new));
            } catch (FalscheSpielerzahlException | WiederholteFarbenException ex) {
                ex.printStackTrace();
            }

            assert spieler != null;
            text = "Der nachste Spieler ist :" + spieler.getFarbeAmZug();
            textField.setText(text);

        });


    }

    private void movefigur(String textread, String text, Richtung richtung) {

        boolean boll = spieler.bewegeFigur(textread, Integer.parseInt(text), richtung);
        Figur a = spieler.getfigur(textread);
        int position = a.getPosition();
        System.out.println(position);
        if (boll) {
            Double xx = rocks.get(position).getX();
            Double yy = rocks.get(position).getY();
            switch (textread) {
                case "Bzz":
                    figurmove(Bzz, rocks.get(position-1).getX(),rocks.get(position-1).getY());
                case "Schlumpfine":
                    figurmove(Schlumpfine, rocks.get(position-1).getX(),rocks.get(position-1).getY());
                case "BLAU-A":
                    figurmove(BLAUA, xx, yy);
                case "BLAU-B":
                    figurmove(BLAUB, xx, yy);
                case "BLAU-C":
                    figurmove(BLAUC, xx, yy);
                case "BLAU-D":
                    figurmove(BLAUD, xx, yy);
                case "GELB-A":
                    figurmove(GELBA, xx, yy);
                case "GELB-B":
                    figurmove(GELBB, xx, yy);
                case "GELB-C":
                    figurmove(GELBC, xx, yy);
                case "GELB-D":
                    figurmove(GELBD, xx, yy);
                case "ROT-A":
                    figurmove(ROTA, xx, yy);
                case "ROT-B":
                    figurmove(ROTB, xx, yy);
                case "ROT-C":
                    figurmove(ROTC, xx, yy);
                case "ROT-D":
                    figurmove(ROTD, xx, yy);
                case "GRUEN-A":
                    figurmove(GRUENA, xx, yy);
                case "GRUEN-B":
                    figurmove(GRUENB, xx, yy);
                case "GRUEN-C":
                    figurmove(GRUENC, xx, yy);
                case "GRUEN-D":
                    figurmove(GRUEND, xx, yy);
            }
        }

    }

    public void falschmove(ImageView figur, Double i, Double i1) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(3));
        figur.setOnMouseClicked(e -> {
            translateTransition.setNode(figur);
            if (i + figur.getX() > scene.getWidth()) {
                translateTransition.setToX(i-figur.getX());
            }
            else {
                translateTransition.setToX(i-70);}
            if (i + figur.getX() > scene.getWidth()) {
                translateTransition.setToY(i1-figur.getY());
            }
            else{
                translateTransition.setToY(i1);}
            translateTransition.setCycleCount((int) 2f);
            translateTransition.setAutoReverse(true);
            translateTransition.play();

        });
    }
    public void figurmove(ImageView figur, Double i, Double i1) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(3));
        figur.setOnMouseClicked(e -> {
            translateTransition.setNode(figur);
            translateTransition.setToX(i-80);
            translateTransition.setToY(i1);
            translateTransition.play();



        });

    }

    private void setButtons() {

        bewegebutton.setText("MOVE");
        bewegebutton.setLayoutX(350);
        bewegebutton.setLayoutY(700);
        bewegebutton.setPrefHeight(50);
        bewegebutton.setPrefWidth(120);
        bewegebutton.setStyle("-fx-background-color:#2e8621;");
        root.getChildren().add(bewegebutton);
        wurfelbutton.setText("ROLL");
        wurfelbutton.setLayoutX(500);
        wurfelbutton.setLayoutY(700);
        wurfelbutton.setPrefHeight(50);
        wurfelbutton.setPrefWidth(120);
        wurfelbutton.setStyle("-fx-background-color:#2e8621;");
        root.getChildren().add(wurfelbutton);
        weiter.setText("WEITER ");
        weiter.setLayoutX(650);
        weiter.setLayoutY(700);
        weiter.setPrefHeight(50);
        weiter.setPrefWidth(120);
        weiter.setStyle("-fx-background-color:#2e8621;");

        abzweigen.setText("ABZWEIGEN ");
        abzweigen.setLayoutX(800);
        abzweigen.setLayoutY(700);
        abzweigen.setPrefHeight(50);
        abzweigen.setPrefWidth(120);
        abzweigen.setStyle("-fx-background-color:#2e8621;");
        root.getChildren().addAll(weiter, abzweigen);

    }


    private ImageView createRock(Image rock, double setx, double sety) {
        ImageView img = new ImageView(rock);
        img.setX(setx);
        img.setY(sety);
        img.setPreserveRatio(true);
        return img;
    }

    private void setmap() {
        rock0 = createRock(imgFactory.getImage("ROCK", 200, 200), 300, 0);
        rock1 = createRock(imgFactory.getImage("ROCK", 200, 200), 300, 0);
        //top
        root.getChildren().add(rock1);
        rock2 = createRock(imgFactory.getImage("ROCK", 200, 200), 500, 0);
        root.getChildren().add(rock2);
        rock3 = createRock(imgFactory.getImage("ROCK", 200, 200), 700, 0);
        root.getChildren().add(rock3);
        rock4 = createRock(imgFactory.getImage("ROCK", 200, 200), 900, 0);

        root.getChildren().add(rock4);
        rock5 = createRock(imgFactory.getImage("ROCK", 200, 200), 1100, 0);
        root.getChildren().add(rock5);
        rock6 = createRock(imgFactory.getImage("ROCK", 200, 200), 1500, 0);
        root.getChildren().add(rock6);
        rock7 = createRock(imgFactory.getImage("ROCK", 200, 200), 1300, 0);
        root.getChildren().add(rock7);
        rock14 = createRock(imgFactory.getImage("ROCK", 200, 200), 1670, 0);
        root.getChildren().add(rock14);

        //left
        rock28 = createRock(imgFactory.getImage("ROCK", 200, 200), 100, 400);
        root.getChildren().add(rock28);

        //right
        rock15 = createRock(imgFactory.getImage("ROCK", 200, 200), 1670, 200);
        root.getChildren().add(rock15);

        //down
        rock23 = createRock(imgFactory.getImage("ROCK", 200, 200), 700, 770);
        root.getChildren().add(rock23);
        rock22 = createRock(imgFactory.getImage("ROCK", 200, 200), 900, 770);
        root.getChildren().add(rock22);
        rock21 = createRock(imgFactory.getImage("ROCK", 200, 200), 1100, 770);
        root.getChildren().add(rock21);
        rock20 = createRock(imgFactory.getImage("ROCK", 200, 200), 1300, 770);
        root.getChildren().add(rock20);
        rock19 = createRock(imgFactory.getImage("ROCK", 200, 200), 1500, 770);
        root.getChildren().add(rock19);
        rock18 = createRock(imgFactory.getImage("ROCK", 200, 200), 1670, 770);
        root.getChildren().add(rock18);

        //middlee right
        rock8 = createRock(imgFactory.getImage("ROCK", 200, 200), 810, 180);
        root.getChildren().add(rock8);
        rock9 = createRock(imgFactory.getImage("ROCK", 200, 200), 980, 180);
        root.getChildren().add(rock9);
        rock10 = createRock(imgFactory.getImage("ROCK", 200, 200), 1150, 180);
        root.getChildren().add(rock10);
        rock12 = createRock(imgFactory.getImage("ROCK", 200, 200), 1350, 300);
        root.getChildren().add(rock12);
        rock13 = createRock(imgFactory.getImage("ROCK", 200, 200), 1500, 200);
        root.getChildren().add(rock13);
        rock35 = createRock(imgFactory.getImage("ROCK", 200, 200), 150, 200);
        root.getChildren().add(rock35);
        rock34 = createRock(imgFactory.getImage("ROCK", 200, 200), 300, 200);
        root.getChildren().add(rock34);
        rock33 = createRock(imgFactory.getImage("ROCK", 200, 200), 480, 200);
        root.getChildren().add(rock33);
        rock32 = createRock(imgFactory.getImage("ROCK", 200, 200), 620, 200);
        root.getChildren().add(rock32);
        //middle left
        rock30 = createRock(imgFactory.getImage("ROCK", 200, 200), 500, 400);
        root.getChildren().add(rock30);
        rock31 = createRock(imgFactory.getImage("ROCK", 200, 200), 700, 400);
        root.getChildren().add(rock31);

        //arrow
        root.getChildren().add(createRock(imgFactory.getImage("arrow", 100, 100), 770, 160));
        root.getChildren().add(createRock(imgFactory.getImage("arrowright", 100, 100), 250, 140));
        root.getChildren().add(createRock(imgFactory.getImage("arrowleft", 100, 100), 720, 350));
        root.getChildren().add(createRock(imgFactory.getImage("arrow", 150, 150), 900, 480));
        root.getChildren().add(createRock(imgFactory.getImage("arrowright", 80, 80), 1620, 140));
        //dorf
        dorf = createRock(imgFactory.getImage("dorf", 300, 300), 1000, 450);
        root.getChildren().add(dorf);
        //doc
        rock29 = createRock(imgFactory.getImage("Doc", 200, 200), 300, 400);
        root.getChildren().add(rock29);


        //pilz
        rock24 = createRock(imgFactory.getImage("Pilz", 200, 200), 500, 780);
        root.getChildren().add(rock24);
        //lake
        rock16 = createRock(imgFactory.getImage("lake", 200, 200), 1670, 600);
        root.getChildren().add(rock16);
        rock17 = createRock(imgFactory.getImage("lake", 200, 200), 1670, 400);
        root.getChildren().add(rock17);

        rock27 = createRock(imgFactory.getImage("lake", 200, 200), 100, 600);
        root.getChildren().add(rock27);
        rock26 = createRock(imgFactory.getImage("lake", 200, 200), 300, 780);
        root.getChildren().add(rock26);
        rock25 = createRock(imgFactory.getImage("lake", 200, 200), 100, 780);
        root.getChildren().add(rock25);
        //tuberose
        rock11 = createRock(imgFactory.getImage("tuberose", 200, 200), 1200, 300);
        root.getChildren().add(rock11);
        //Schlumpfine
        Schlumpfine = createRock(imgFactory.getImage("Schlumpfine", 100, 100), 350, 50);
        root.getChildren().add(Schlumpfine);
        //bzz
        Bzz = createRock(imgFactory.getImage("Bzz", 150, 150), 1520, 780);
        root.getChildren().add(Bzz);
        Collections.addAll(rocks,rock0, rock1, rock2, rock3, rock4, rock5, rock6, rock7, rock8, rock9, rock10, rock11, rock12, rock13, rock14,
                rock15, rock16,
                rock17, rock18, rock19, rock20, rock21, rock22, rock23, rock24, rock25, rock26, rock27, rock28, rock29, rock30, rock31,
                rock32, rock33, rock34, rock35, dorf);
    }

    private void setplayers() {
        //red
        ROTA = createRock(imgFactory.getImage("redsmurf", 50, 30), 120, 13);
        root.getChildren().add(ROTA);
        ROTB = createRock(imgFactory.getImage("redsmurf", 50, 30), 150, 13);
        root.getChildren().add(ROTB);
        ROTC = createRock(imgFactory.getImage("redsmurf", 50, 30), 190, 13);
        root.getChildren().add(ROTC);
        ROTD = createRock(imgFactory.getImage("redsmurf", 50, 30), 220, 13);
        root.getChildren().add(ROTD);
        //green
        GRUENA = createRock(imgFactory.getImage("greensmurf", 50, 30), 120, 60);
        root.getChildren().add(GRUENA);
        GRUENB = createRock(imgFactory.getImage("greensmurf", 50, 30), 150, 60);
        root.getChildren().add(GRUENB);
        GRUENC = createRock(imgFactory.getImage("greensmurf", 50, 30), 190, 60);
        root.getChildren().add(GRUENC);
        GRUEND = createRock(imgFactory.getImage("greensmurf", 50, 30), 220, 60);
        root.getChildren().add(GRUEND);

        //blue
        BLAUA = createRock(imgFactory.getImage("bluesmurf", 50, 30), 120, 100);
        root.getChildren().add(BLAUA);
        BLAUB = createRock(imgFactory.getImage("bluesmurf", 50, 30), 150, 100);
        root.getChildren().add(BLAUB);
        BLAUC = createRock(imgFactory.getImage("bluesmurf", 50, 30), 190, 100);
        root.getChildren().add(BLAUC);
        BLAUD = createRock(imgFactory.getImage("bluesmurf", 50, 30), 220, 100);
        root.getChildren().add(BLAUD);
        //yellow
        GELBA = createRock(imgFactory.getImage("yellowsmurf", 50, 30), 120, 150);
        root.getChildren().add(GELBA);
        GELBB = createRock(imgFactory.getImage("yellowsmurf", 50, 30), 150, 150);
        root.getChildren().add(GELBB);
        GELBC = createRock(imgFactory.getImage("yellowsmurf", 50, 30), 190, 150);
        root.getChildren().add(GELBC);
        GELBD = createRock(imgFactory.getImage("yellowsmurf", 50, 30), 220, 150);
        root.getChildren().add(GELBD);

    }


    private void setMusicButton() {
        Button music = factory.getButton("music").getButton();
        music.setAlignment(Pos.TOP_LEFT);
        VBox v = new VBox();
        v.getChildren().add(music);
        v.setPadding(new Insets(30, 0, 0, 50));
        root.getChildren().add(v);

    }


    private Group setLayout() {
        Image background = imgFactory.getImage("background", windowWidth, windowHeight);
        ImageView img = new ImageView(background);
        img.setPreserveRatio(true);
        img.setFitWidth(windowWidth);
        root = new Group();
        root.getChildren().add(img);
        Canvas canvas = new Canvas(windowWidth, windowHeight);
        root.getChildren().add(canvas);
        return root;
    }


    public double getWidth() {
        return windowWidth;
    }

    public double getHeight() {
        return windowHeight;
    }

    public Group getRoot() {
        return root;
    }

}