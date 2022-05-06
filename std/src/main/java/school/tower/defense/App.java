package school.tower.defense;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        loadMenu();
        URL url = this.getClass().getResource("style.css");
        String css = url.toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Student Tower Defense");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static void loadGame() throws IOException {
        System.out.println("test");
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
        StackPane game = new StackPane();
        StackPane inst = new StackPane();

        game.setId("game");
        root.setId("pane");
        inst.setId("inst");

        Button startButton = new Button();
        Button instructions = new Button();
        BackgroundImage startImage = new BackgroundImage( new Image( getClass().getResource("Map/start.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));
        BackgroundImage instructionsImage = new BackgroundImage( new Image( getClass().getResource("Map/Instructions.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));
        Text text = new Text("Student Tower Defense");
        Image fulk = new Image(getClass().getResource("Map/fulk.PNG").toExternalForm());
        ImageView FULK = new ImageView(fulk);
        Image kwong = new Image(getClass().getResource("Map/Kwong.PNG").toExternalForm());
        ImageView KWONG = new ImageView(kwong);


        text.setTranslateY(-150);
        text.setId("menutext");
        startButton.setBackground( new Background( startImage ));
        startButton.setMaxSize(100, 100);
        instructions.setBackground(new Background( instructionsImage ));
        instructions.setMaxSize(200, 200);
        instructions.setTranslateY(50);
        FULK.setTranslateX(200);
        KWONG.setTranslateX(-200);


        startButton.setOnAction(value ->  {
            scene.setRoot(game);
            startButton.setDisable(true);
        });
        instructions.setOnAction(value -> {
            scene.setRoot(inst);
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
        scene = new Scene(root, 640, 480, Color.BLACK);
    }

    public void loadInstructions() throws IOException {
        System.out.println("test");
    }

}