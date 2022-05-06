package school.tower.defense;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
        game.setId("game");
        root.setId("pane");
        Button btn = new Button();
        Text text = new Text("Student Tower Defense");
        text.setTranslateY(-150);
        btn.setTranslateX(-150);
        text.setId("menutext");
        BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("Map/start.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));
        btn.setBackground( new Background( backgroundImage ));
        btn.setMaxSize(100, 100);
        btn.setOnAction(value ->  {
            scene.setRoot(game);
            btn.setDisable(true);
        });
        root.getChildren().add(btn);
        root.getChildren().add(text);
        scene = new Scene(root, 640, 480, Color.BLACK);
    }

}