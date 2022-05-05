package school.tower.defense;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        StackPane root  = new StackPane();
        StackPane game = new StackPane();
        game.setId("game");
        root.setId("pane");
        Button btn = new Button();
        btn.setText("Continue");
        btn.setOnAction(value ->  {
          scene.setRoot(game);
           System.out.println("Continue");
        });
        root.getChildren().add(btn);
        scene = new Scene(root, 640, 480, Color.BLACK);
        URL url = this.getClass().getResource("style.css");
        System.out.println(url);
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

}