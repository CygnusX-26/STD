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
        Image fulk = new Image(getClass().getResource("Map/fulk.PNG").toExternalForm());
        ImageView FULK = new ImageView(fulk);
        Image kwong = new Image(getClass().getResource("Map/Kwong.PNG").toExternalForm());
        ImageView KWONG = new ImageView(kwong);
        Media menuMusic = new Media(getClass().getResource("Music/awesomeness.wav").toExternalForm());
        Tooltip startTooltip = new Tooltip("Start Game");
        menuPlayer = new MediaPlayer(menuMusic);

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
        
        BackgroundImage fulkImage = new BackgroundImage( new Image( getClass().getResource("Map/fulk.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage kwongImage = new BackgroundImage( new Image( getClass().getResource("Map/Kwong.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage dunlapImage = new BackgroundImage( new Image( getClass().getResource("Map/Dunlap.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage taylorImage = new BackgroundImage( new Image( getClass().getResource("Map/Taylor.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage albakerImage = new BackgroundImage( new Image( getClass().getResource("Map/Albaker.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage palloneImage = new BackgroundImage( new Image( getClass().getResource("Map/Pallone.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage mappingBackground = new BackgroundImage(new Image( getClass().getResource("Map/transparent-picture.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));

        Image fulkPlace = new Image(getClass().getResource("Map/fulk.PNG").toExternalForm());

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

        fulkButton.setBackground(new Background(fulkImage));
        kwongButton.setBackground(new Background(kwongImage));
        dunlapButton.setBackground(new Background(dunlapImage));
        taylorButton.setBackground(new Background(taylorImage));
        albakerButton.setBackground(new Background(albakerImage));
        palloneButton.setBackground(new Background(palloneImage));

        fulkButton.setTranslateX(-725);
        fulkButton.setTranslateY(-325);
        
        kwongButton.setTranslateX(-725);
        kwongButton.setTranslateY(-250);

        dunlapButton.setTranslateX(-725);
        dunlapButton.setTranslateY(-175);

        taylorButton.setTranslateX(-725);
        taylorButton.setTranslateY(-100);

        albakerButton.setTranslateX(-725);
        albakerButton.setTranslateY(-25);

        palloneButton.setTranslateX(-725);
        palloneButton.setTranslateY(50);

        fullscreen.setTranslateX(-725);
        fullscreen.setTranslateY(450);
        
        towers.setTranslateX(-675);
        towers.setTranslateY(-375);
        health.setTranslateX(675);
        health.setTranslateY(-375);
        hpnum.setTranslateX(675);
        hpnum.setTranslateY(-325);


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
            System.out.println("Kwong");
            teacherIndex[0] = 2;
        });
        dunlapButton.setOnAction(value ->  {
            System.out.println("Dunlap");
            teacherIndex[0] = 3;
        });
        taylorButton.setOnAction(value ->  {
            System.out.println("Taylor");
            teacherIndex[0] = 4;
        });
        albakerButton.setOnAction(value ->  {
            System.out.println("Albaker");
            teacherIndex[0] = 5;
        });
        palloneButton.setOnAction(value ->  {
            System.out.println("Pallone");
            teacherIndex[0] = 6;
        });

        mapping.setOnMouseClicked(value ->  {
            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            if (teacherIndex[0] == 1) {
                Image towerImage = new Image(getClass().getResource("Map/fulk.PNG").toExternalForm());
                ImageView tower = new ImageView(towerImage);
                tower.setTranslateX(p.getX() - 960);
                tower.setTranslateY(p.getY() - 540);
                game.getChildren().add(tower);
                teacherIndex[0] = 0;
            }
            scene.setCursor(Cursor.DEFAULT);
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

        
        scene.setRoot(game);
    }

}