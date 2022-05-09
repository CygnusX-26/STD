package school.tower.defense;

import java.io.IOException;
import java.net.URL;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
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

        menuPlayer.stop();
        Media gameMusic = new Media(getClass().getResource("Music/game.mp4").toExternalForm());
        menuPlayer = new MediaPlayer(gameMusic);
        menuPlayer.setVolume(0.5);
        menuPlayer.play();
        stage.setMaximized(true);

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

        Tooltip fulkTip = new Tooltip("Fulk");
        Tooltip kwongTip = new Tooltip("Kwong");
        Tooltip dunlapTip = new Tooltip("Dunlap");
        Tooltip taylorTip = new Tooltip("Taylor");
        Tooltip albakerTip = new Tooltip("Albaker");
        Tooltip palloneTip = new Tooltip("Pallone");

        fulkTip.setMaxWidth(100);
        fulkTip.setWrapText(true);
        fulkTip.setShowDelay(Duration.ZERO);
        kwongTip.setMaxWidth(100);
        kwongTip.setWrapText(true);
        kwongTip.setShowDelay(Duration.ZERO);
        dunlapTip.setMaxWidth(100);
        dunlapTip.setWrapText(true);
        dunlapTip.setShowDelay(Duration.ZERO);
        taylorTip.setMaxWidth(100);
        taylorTip.setWrapText(true);
        taylorTip.setShowDelay(Duration.ZERO);
        albakerTip.setMaxWidth(100);
        albakerTip.setWrapText(true);
        albakerTip.setShowDelay(Duration.ZERO);
        palloneTip.setMaxWidth(100);
        palloneTip.setWrapText(true);
        palloneTip.setShowDelay(Duration.ZERO);

        fulkButton.setTooltip(fulkTip);
        kwongButton.setTooltip(kwongTip);
        dunlapButton.setTooltip(dunlapTip);
        taylorButton.setTooltip(taylorTip);
        albakerButton.setTooltip(albakerTip);
        palloneButton.setTooltip(palloneTip);




        Text towers = new Text("Towers:");
        Text health = new Text("Health:");
        Text hpnum = new Text("69");
        
        StackPane game = new StackPane();

        fulkButton.setBackground(new Background(fulkImage));
        kwongButton.setBackground(new Background(kwongImage));
        dunlapButton.setBackground(new Background(dunlapImage));
        taylorButton.setBackground(new Background(taylorImage));
        albakerButton.setBackground(new Background(albakerImage));
        palloneButton.setBackground(new Background(palloneImage));


        fulkButton.setMaxHeight(50);
        fulkButton.setMaxWidth(50);
        fulkButton.setTranslateX(-725);
        fulkButton.setTranslateY(-325);
        
        kwongButton.setMaxHeight(50);
        kwongButton.setMaxWidth(50);
        kwongButton.setTranslateX(-725);
        kwongButton.setTranslateY(-265);

        dunlapButton.setMaxHeight(50);
        dunlapButton.setMaxWidth(50);
        dunlapButton.setTranslateX(-725);
        dunlapButton.setTranslateY(-205);

        taylorButton.setMaxHeight(50);
        taylorButton.setMaxWidth(50);
        taylorButton.setTranslateX(-725);
        taylorButton.setTranslateY(-145);

        albakerButton.setMaxHeight(50);
        albakerButton.setMaxWidth(50);
        albakerButton.setTranslateX(-725);
        albakerButton.setTranslateY(-85);

        palloneButton.setMaxHeight(50);
        palloneButton.setMaxWidth(50);
        palloneButton.setTranslateX(-725);
        palloneButton.setTranslateY(-25);
        
        towers.setTranslateX(-675);
        towers.setTranslateY(-375);
        health.setTranslateX(675);
        health.setTranslateY(-375);
        hpnum.setTranslateX(675);
        hpnum.setTranslateY(-325);

        fulkButton.setOnAction(value ->  {
            System.out.println("Fulk");
        });
        kwongButton.setOnAction(value ->  {
            System.out.println("Kwong");
        });
        dunlapButton.setOnAction(value ->  {
            System.out.println("Dunlap");
        });
        taylorButton.setOnAction(value ->  {
            System.out.println("Taylor");
        });
        albakerButton.setOnAction(value ->  {
            System.out.println("Albaker");
        });
        palloneButton.setOnAction(value ->  {
            System.out.println("Pallone");
        });





        game.setId("game"); 
        towers.setId("towers");
        health.setId("health");
        hpnum.setId("hpnum");

        game.getChildren().add(fulkButton);
        game.getChildren().add(kwongButton);
        game.getChildren().add(towers);
        game.getChildren().add(dunlapButton);
        game.getChildren().add(taylorButton);
        game.getChildren().add(albakerButton);
        game.getChildren().add(palloneButton);
        game.getChildren().add(health);
        game.getChildren().add(hpnum);

    
        scene.setRoot(game);
    }

}