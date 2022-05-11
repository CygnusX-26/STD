package school.tower.defense;

import java.awt.MouseInfo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import school.tower.defense.Classes.Game;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    private MediaPlayer menuPlayer;
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        loadMenu();
        this.stage = stage;
        URL url = this.getClass().getResource("style.css");
        String css = url.toExternalForm();
        scene.getStylesheets().add(css);
        this.stage.setScene(scene);
        this.stage.setTitle("Student Tower Defense");
        this.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public void loadMenu() throws IOException {
        StackPane root  = new StackPane();

        TranslateTransition fulkTransition = new TranslateTransition();
        TranslateTransition kwongTransition = new TranslateTransition();
        Button startButton = new Button();
        Button instructions = new Button();
        BackgroundImage startImage = new BackgroundImage( new Image( getClass().getResource("Map/start.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage instructionsImage = new BackgroundImage( new Image( getClass().getResource("Map/Instructions.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, true, true, true, false));
        Text text = new Text("Student Tower Defense");
        Image fulk = new Image(getClass().getResource("Map/Teachers/Fulk.PNG").toExternalForm());
        ImageView FULK = new ImageView(fulk);
        Image kwong = new Image(getClass().getResource("Map/Teachers/Kwong.PNG").toExternalForm());
        ImageView KWONG = new ImageView(kwong);
        Media menuMusic = new Media(getClass().getResource("Music/awesomeness.wav").toExternalForm());
        Tooltip startTooltip = new Tooltip("Start Game");
        menuPlayer = new MediaPlayer(menuMusic);


        //pacman animation area
        










        root.setId("pane");
        text.setId("menutext");

        startTooltip.setMaxWidth(100);
        startTooltip.setWrapText(true);
        text.setTranslateY(-150);
        startButton.setBackground( new Background( startImage ));
        startButton.setTranslateY(-25);
        startButton.setMaxWidth(150);
        startButton.setMaxHeight(75);
        startButton.setTooltip(startTooltip);
        instructions.setBackground(new Background( instructionsImage ));
        instructions.setMaxWidth(150);
        instructions.setMaxHeight(75);
        instructions.setTranslateY(50);
        FULK.setTranslateX(200);
        KWONG.setTranslateX(-200);
        fulkTransition.setNode(FULK);
        fulkTransition.setByY(50);
        fulkTransition.setAutoReverse(true);
        fulkTransition.setCycleCount(Animation.INDEFINITE);
        kwongTransition.setNode(KWONG);
        kwongTransition.setByY(50);
        kwongTransition.setAutoReverse(true);
        kwongTransition.setCycleCount(Animation.INDEFINITE);
        menuPlayer.setAutoPlay(true);
        menuPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        startButton.setOnAction(value ->  {
            try {
                loadGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
            startButton.setDisable(true);
        });

        instructions.setOnAction(value -> {
            try{
                loadInstructions();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            
        });


        root.getChildren().add(startButton);
        root.getChildren().add(text);
        root.getChildren().add(FULK);
        root.getChildren().add(KWONG);
        root.getChildren().add(instructions);

        fulkTransition.play();
        kwongTransition.play();
        menuPlayer.play();

        scene = new Scene(root, 640, 480, Color.BLACK);
    }

    public void loadInstructions() throws IOException {
        StackPane inst = new StackPane();
        inst.setId("inst");
        scene.setRoot(inst);
        System.out.println("test");
    }

    public void loadGame() throws IOException {
        //music things, dont worry about this
        menuPlayer.stop();
        Media gameMusic = new Media(getClass().getResource("Music/game.mp4").toExternalForm());
        menuPlayer = new MediaPlayer(gameMusic);
        menuPlayer.setVolume(0.5);
        menuPlayer.play();
        stage.setFullScreen(true);

        //initialize objects

        Button mapping = new Button();
        Button fullscreen = new Button();
        // Game g = new Game();

        Button fulkButton = new Button();
        Button kwongButton = new Button();
        Button dunlapButton = new Button();
        Button taylorButton = new Button();
        Button albakerButton = new Button();
        Button palloneButton = new Button();
        Button deleteButton = new Button();
        
        BackgroundImage fulkImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Fulk.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage kwongImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Kwong.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage dunlapImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Dunlap.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage taylorImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Taylor.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage albakerImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Albaker.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage palloneImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Pallone.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage mappingBackground = new BackgroundImage(new Image( getClass().getResource("Map/transparent-picture.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));

        Image fulkPlace = new Image(getClass().getResource("Map/Teachers/Fulk.PNG").toExternalForm());
        Image kwongPlace = new Image(getClass().getResource("Map/Teachers/Kwong.PNG").toExternalForm());
        Image dunlapPlace = new Image(getClass().getResource("Map/Teachers/Dunlap.PNG").toExternalForm());
        Image taylorPlace = new Image(getClass().getResource("Map/Teachers/Taylor.PNG").toExternalForm());
        Image albakerPlace = new Image(getClass().getResource("Map/Teachers/Albaker.PNG").toExternalForm());
        Image pallonePlace = new Image(getClass().getResource("Map/Teachers/Pallone.PNG").toExternalForm()); 


        Tooltip fulkTip = new Tooltip("Fulk");
        Tooltip kwongTip = new Tooltip("Kwong");
        Tooltip dunlapTip = new Tooltip("Dunlap");
        Tooltip taylorTip = new Tooltip("Taylor");
        Tooltip albakerTip = new Tooltip("Albaker");
        Tooltip palloneTip = new Tooltip("Pallone");

        Text towers = new Text("Towers:");
        Text health = new Text("Health:");
        Text hpnum = new Text("69");
        
        StackPane game = new StackPane();


        ArrayList<Button> buttons = new ArrayList<Button>();
        ArrayList<Tooltip> tips = new ArrayList<Tooltip>();
        ArrayList<Image> placeImages = new ArrayList<Image>();

        buttons.add(fulkButton);
        buttons.add(kwongButton);
        buttons.add(dunlapButton);
        buttons.add(taylorButton);
        buttons.add(albakerButton);
        buttons.add(palloneButton);
        tips.add(fulkTip);
        tips.add(kwongTip);
        tips.add(dunlapTip);
        tips.add(taylorTip);
        tips.add(albakerTip);
        tips.add(palloneTip);
        placeImages.add(fulkPlace);
        placeImages.add(kwongPlace);
        placeImages.add(dunlapPlace);   
        placeImages.add(taylorPlace);   
        placeImages.add(albakerPlace);
        placeImages.add(pallonePlace);


        //set values for objects
        for (Tooltip t : tips){
            t.setMaxWidth(100);
            t.setWrapText(true);
            t.setShowDelay(Duration.ZERO);
        }

        for (Button b : buttons){
            b.setMaxHeight(75);
            b.setMaxWidth(75);
        }

        fulkButton.setTooltip(fulkTip);
        kwongButton.setTooltip(kwongTip);
        dunlapButton.setTooltip(dunlapTip); 
        taylorButton.setTooltip(taylorTip);
        albakerButton.setTooltip(albakerTip);
        palloneButton.setTooltip(palloneTip);
        fullscreen.setText("Fullscreen");
        deleteButton.setText("Sell a tower");

        fulkButton.setBackground(new Background(fulkImage));
        kwongButton.setBackground(new Background(kwongImage));
        dunlapButton.setBackground(new Background(dunlapImage));
        taylorButton.setBackground(new Background(taylorImage));
        albakerButton.setBackground(new Background(albakerImage));
        palloneButton.setBackground(new Background(palloneImage));

        fulkButton.setTranslateX(0 - stage.getWidth()/2 + 50);
        fulkButton.setTranslateY(0 - stage.getHeight()/2 + 125);
        
        kwongButton.setTranslateX(0 - stage.getWidth()/2 + 50);
        kwongButton.setTranslateY(0 - stage.getHeight()/2 + 200);

        dunlapButton.setTranslateX(0 - stage.getWidth()/2 + 50);
        dunlapButton.setTranslateY(0 - stage.getHeight()/2 + 275);

        taylorButton.setTranslateX(0 - stage.getWidth()/2 + 50);
        taylorButton.setTranslateY(0 - stage.getHeight()/2 + 350);

        albakerButton.setTranslateX(0 - stage.getWidth()/2 + 50);
        albakerButton.setTranslateY(0 - stage.getHeight()/2 + 425);

        palloneButton.setTranslateX(0 - stage.getWidth()/2 + 50);
        palloneButton.setTranslateY(0 - stage.getHeight()/2 + 500);

        fullscreen.setTranslateX(0 - stage.getWidth()/2 + 50);
        fullscreen.setTranslateY(0 - stage.getHeight()/2 + 650);
        deleteButton.setTranslateX(0-stage.getWidth()/2 + 50);
        deleteButton.setTranslateY(0 - stage.getHeight()/2 + 600);
        
        towers.setTranslateX(0 - stage.getWidth()/2 + 75);
        towers.setTranslateY(0 - stage.getHeight()/2 + 75);
        health.setTranslateX(stage.getWidth()/2 - 100);
        health.setTranslateY(0 - stage.getHeight()/2 + 75);
        hpnum.setTranslateX(stage.getWidth()/2 - 100);
        hpnum.setTranslateY(0 - stage.getHeight()/2 + 125);


        mapping.setMaxWidth(1920);
        mapping.setBackground(new Background(mappingBackground));
        mapping.setMaxHeight(1080);

        String[] teachers = new String[]{"", "Fulk", "Kwong", "Dunlap", "Taylor", "Albaker", "Pallone"}; //delete later
        final int[] teacherIndex = {0};
        fulkButton.setOnAction(value ->  {
            scene.setCursor(new ImageCursor(fulkPlace));
            teacherIndex[0] = 1;
        });
        kwongButton.setOnAction(value ->  {
            scene.setCursor(new ImageCursor(kwongPlace));
            teacherIndex[0] = 2;
        });
        dunlapButton.setOnAction(value ->  {
            scene.setCursor(new ImageCursor(dunlapPlace));
            teacherIndex[0] = 3;
        });
        taylorButton.setOnAction(value ->  {
            scene.setCursor(new ImageCursor(taylorPlace));
            teacherIndex[0] = 4;
        });
        albakerButton.setOnAction(value ->  {
            scene.setCursor(new ImageCursor(albakerPlace));
            teacherIndex[0] = 5;
        });
        palloneButton.setOnAction(value ->  {
            scene.setCursor(new ImageCursor(pallonePlace));
            teacherIndex[0] = 6;
        });
        deleteButton.setOnAction(arg0 -> {
            teacherIndex[0] = 7;
        });

        mapping.setOnMouseClicked(value ->  {
            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            Image towerImage;
            ImageView tower;
            switch (teacherIndex[0]) {
                case 1:
                    towerImage = new Image(getClass().getResource("Map/Teachers/Fulk.PNG").toExternalForm());
                    tower = new ImageView(towerImage);
                    tower.setOnMouseClicked(arg0 -> {
                        if (teacherIndex[0] == 7){
                            game.getChildren().remove(tower);
                        }
                    });
                    tower.setTranslateX(p.getX() - stage.getWidth()/2);
                    tower.setTranslateY(p.getY() - stage.getHeight()/2);
                    game.getChildren().add(tower);
                    teacherIndex[0] = 0;
                    scene.setCursor(Cursor.DEFAULT);
                    break;
                case 2:
                    towerImage = new Image(getClass().getResource("Map/Teachers/Kwong.PNG").toExternalForm());
                    tower = new ImageView(towerImage);
                    tower.setOnMouseClicked(arg0 -> {
                        if (teacherIndex[0] == 7){
                            game.getChildren().remove(tower);
                        }
                    });
                    tower.setTranslateX(p.getX() - stage.getWidth()/2);
                    tower.setTranslateY(p.getY() - stage.getHeight()/2);
                    game.getChildren().add(tower);
                    teacherIndex[0] = 0;
                    scene.setCursor(Cursor.DEFAULT);
                    break;
                case 3:
                    towerImage = new Image(getClass().getResource("Map/Teachers/Dunlap.PNG").toExternalForm());
                    tower = new ImageView(towerImage);
                    tower.setOnMouseClicked(arg0 -> {
                        if (teacherIndex[0] == 7){
                            game.getChildren().remove(tower);
                        }
                    });
                    tower.setTranslateX(p.getX() - stage.getWidth()/2);
                    tower.setTranslateY(p.getY() - stage.getHeight()/2);
                    game.getChildren().add(tower);
                    teacherIndex[0] = 0;
                    scene.setCursor(Cursor.DEFAULT);
                    break;
                case 4:
                    towerImage = new Image(getClass().getResource("Map/Teachers/Taylor.PNG").toExternalForm());
                    tower = new ImageView(towerImage);
                    tower.setOnMouseClicked(arg0 -> {
                        if (teacherIndex[0] == 7){
                            game.getChildren().remove(tower);
                        }
                    });
                    tower.setTranslateX(p.getX() - stage.getWidth()/2);
                    tower.setTranslateY(p.getY() - stage.getHeight()/2);
                    game.getChildren().add(tower);
                    teacherIndex[0] = 0;
                    scene.setCursor(Cursor.DEFAULT);
                    break;
                case 5:
                    towerImage = new Image(getClass().getResource("Map/Teachers/Albaker.PNG").toExternalForm());
                    tower = new ImageView(towerImage);
                    tower.setOnMouseClicked(arg0 -> {
                        if (teacherIndex[0] == 7){
                            game.getChildren().remove(tower);
                        }
                    });
                    tower.setTranslateX(p.getX() - stage.getWidth()/2);
                    tower.setTranslateY(p.getY() - stage.getHeight()/2);
                    game.getChildren().add(tower);
                    teacherIndex[0] = 0;
                    scene.setCursor(Cursor.DEFAULT);
                    break;
                case 6:
                    towerImage = new Image(getClass().getResource("Map/Teachers/Pallone.PNG").toExternalForm());
                    tower = new ImageView(towerImage);
                    tower.setOnMouseClicked(arg0 -> {
                        if (teacherIndex[0] == 7){
                            game.getChildren().remove(tower);
                        }
                    });
                    tower.setTranslateX(p.getX() - stage.getWidth()/2);
                    tower.setTranslateY(p.getY() - stage.getHeight()/2);
                    game.getChildren().add(tower);
                    teacherIndex[0] = 0;
                    scene.setCursor(Cursor.DEFAULT);
                    break;
                default:
                    teacherIndex[0] = 0;
                    scene.setCursor(Cursor.DEFAULT);
            }
        });

        fullscreen.setOnAction(value ->  {
            stage.setFullScreen(true);
        });




        game.setId("game"); 
        towers.setId("towers");
        health.setId("health");
        hpnum.setId("hpnum");

        game.getChildren().add(mapping);
        game.getChildren().add(fulkButton);
        game.getChildren().add(kwongButton);
        game.getChildren().add(towers);
        game.getChildren().add(dunlapButton);
        game.getChildren().add(taylorButton);
        game.getChildren().add(albakerButton);
        game.getChildren().add(palloneButton);
        game.getChildren().add(health);
        game.getChildren().add(hpnum);
        game.getChildren().add(fullscreen);
        game.getChildren().add(deleteButton);

        
        scene.setRoot(game);
    }

}