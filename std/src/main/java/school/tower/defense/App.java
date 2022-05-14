package school.tower.defense;

import school.tower.defense.Classes.Game;
import school.tower.defense.TowerTypes.Fulk;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    private MediaPlayer menuPlayer;
    private Stage stage;
    private StackPane root;
    private StackPane game;

    /**
     * starts the JavaFX application
     * @param stage the stage to be displayed
     * @throws IOException if the application fails to start
     */
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

    /**
     * Runs the JavaFX application
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Loads the menu scene
     * @throws IOException if fails to load the scene
     */
    public void loadMenu() throws IOException {
        root  = new StackPane();

        TranslateTransition fulkTransition = new TranslateTransition();
        TranslateTransition kwongTransition = new TranslateTransition();
        //RotateTransition titleTransition = new RotateTransition();
        Button startButton = new Button();
        Button instructions = new Button();
        BackgroundImage startImage = new BackgroundImage( new Image( getClass().getResource("Map/startButton.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage instructionsImage = new BackgroundImage( new Image( getClass().getResource("Map/instructionButton.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, true, true, true, false));
        //Image menuTitle = new Image(getClass().getResource("Map/menuTitle1.PNG").toExternalForm());
        //ImageView MENUTITLE = new ImageView(menuTitle);
        Text text = new Text("Student Tower Defense");
        Image fulk = new Image(getClass().getResource("Map/Teachers/Fulk.PNG").toExternalForm());
        ImageView FULK = new ImageView(fulk);
        Image kwong = new Image(getClass().getResource("Map/Teachers/Kwong.PNG").toExternalForm());
        ImageView KWONG = new ImageView(kwong);
        Media menuMusic = new Media(getClass().getResource("Music/awesomeness.wav").toExternalForm());
        //Tooltip startTooltip = new Tooltip("Start Game");
        // Image fulkGif = new Image(getClass().getResource("Map/OptionalLoginAnimation.gif").toExternalForm());
        // ImageView fulkGifView = new ImageView(fulkGif);
        menuPlayer = new MediaPlayer(menuMusic);

        root.setId("pane");
        text.setId("menutext");

        //startTooltip.setMaxWidth(100);
        //startTooltip.setWrapText(true);
        text.setTranslateY(-150);
        startButton.setBackground( new Background( startImage ));
        startButton.setTranslateY(-25);
        startButton.setMaxWidth(150);
        startButton.setMaxHeight(75);
        //startButton.setTooltip(startTooltip);
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

        /*
        MENUTITLE.setTranslateY(-150);
        titleTransition.setNode(MENUTITLE);
        MENUTITLE.setScaleX(0.5);
        MENUTITLE.setScaleY(0.5);
        //titleTransition.autoReverseProperty();
        titleTransition.setAutoReverse(true);
        titleTransition.setFromAngle(-30);
        titleTransition.setByAngle(60);
        titleTransition.setCycleCount(Animation.INDEFINITE);
        titleTransition.setDuration(new Duration(2));
        //TODO the rotation of STD title
`       */

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
        //root.getChildren().add(MENUTITLE);
        //root.getChildren().add(fulkGifView);

        fulkTransition.play();
        kwongTransition.play();
        menuPlayer.play();

        scene = new Scene(root, 640, 480, Color.BLACK);
    }

    /**
     * loads the instructions scene
     * @throws IOException if fails to load the scene
     */
    public void loadInstructions() throws IOException {
        StackPane inst = new StackPane();
        Button back = new Button();
        back.setText("Back to menu");
        back.setTranslateY(stage.getHeight() - 150);
        back.setOnMouseClicked(arg0 -> {
            stage.setHeight(480);
            stage.setWidth(640);
            scene.setRoot(root);
                
        });
        ImageView instruction = new ImageView(new Image(getClass().getResource("Map/InstructionScreen.png").toExternalForm()));
        inst.setId("inst");
        inst.getChildren().add(instruction);
        inst.getChildren().add(back);
        stage.setMaximized(true);
        scene.setRoot(inst);
    }

    /**
     * loads the game scene
     * @throws IOException if fails to load the scene
     */
    public void loadGame() throws IOException {
        //music things, dont worry about this
        menuPlayer.stop();
        Media gameMusic = new Media(getClass().getResource("Music/game.mp4").toExternalForm());
        menuPlayer = new MediaPlayer(gameMusic);
        menuPlayer.setVolume(0.5);
        menuPlayer.play();
        stage.setMaximized(true);

        //initialize objects
        int fulkCost = 10; //make sure to modify the tooltips when modifying this
        int kwongCost = 1; // also put more stats in the tooltips maybe??
        int dunlapCost = 1;
        int taylorCost = 10;
        int albakerCost = 100;
        int palloneCost = 1000;
        int[] fulkUpgradeAmt = {0};
        int[] kwongUpgradeAmt = {0};
        int[] dunlapUpgradeAmt = {0};
        int[] taylorUpgradeAmt = {0};
        int[] albakerUpgradeAmt = {0};
        int[] palloneUpgradeAmt = {0};
        int costOfUpgrade = 100;

        Text hpnum = new Text("69");
        Game g = new Game(stage, (int)stage.getWidth(), (int)stage.getHeight());

        Button mapping = new Button();
        Button fullscreen = new Button();

        Button fulkButton = new Button();
        Button kwongButton = new Button();
        Button dunlapButton = new Button();
        Button taylorButton = new Button();
        Button albakerButton = new Button();
        Button palloneButton = new Button();
        Button deleteButton = new Button();
        Button fulkUpgradeButton = new Button();
        Button kwongUpgradeButton = new Button();
        Button dunlapUpgradeButton = new Button();
        Button albakerUpgradeButton = new Button();
        Button palloneUpgradeButton = new Button();
        Button taylorUpgradeButton = new Button();
        
        BackgroundImage fulkImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Fulk.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage kwongImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Kwong.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage dunlapImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Dunlap.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage taylorImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Taylor.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage albakerImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Albaker.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage palloneImage = new BackgroundImage( new Image( getClass().getResource("Map/Teachers/Pallone.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage mappingBackground = new BackgroundImage(new Image( getClass().getResource("Map/transparent-picture.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));
        BackgroundImage upgradeButtonImage = new BackgroundImage( new Image( getClass().getResource("Map/Upgrade.PNG").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(150, 75, false, false, true, false));

        Image fulkPlace = new Image(getClass().getResource("Map/Teachers/Fulk.PNG").toExternalForm());
        Image kwongPlace = new Image(getClass().getResource("Map/Teachers/Kwong.PNG").toExternalForm());
        Image dunlapPlace = new Image(getClass().getResource("Map/Teachers/Dunlap.PNG").toExternalForm());
        Image taylorPlace = new Image(getClass().getResource("Map/Teachers/Taylor.PNG").toExternalForm());
        Image albakerPlace = new Image(getClass().getResource("Map/Teachers/Albaker.PNG").toExternalForm());
        Image pallonePlace = new Image(getClass().getResource("Map/Teachers/Pallone.PNG").toExternalForm()); 
        Image upgradePlace = new Image(getClass().getResource("Map/Upgrade.PNG").toExternalForm()); 


        Tooltip fulkTip = new Tooltip("Fulk \n(10 Money) \n\nHis mission is to propogate webcat to all educational institutions");
        Tooltip kwongTip = new Tooltip("Kwong \n(1 Money) \n\nThe better CS teacher (although it's up for debate)");
        Tooltip dunlapTip = new Tooltip("Dunlap \n(1 Money) \n\nThe reading quizes she gives will knock anyone off their feet");
        Tooltip taylorTip = new Tooltip("Taylor \n(10 Money) \n\nHe will prove freefall objects will gain speed over time");
        Tooltip albakerTip = new Tooltip("Albaker \n(100 Money) \n\nHer essay grading has all the foes in terror (just like her students)");
        Tooltip palloneTip = new Tooltip("Pallone \n(1000 Money) \n\nA Biology teacher who's awesome at everything :)");
        Tooltip fulkUpgradeTip = new Tooltip("Fulk's Upgrade 1 -- Damage increased to 2 damage per shot");
        Tooltip kwongUpgradeTip = new Tooltip("Kwong's Upgrade 1 -- Damage increased to 2 damage per shot");
        Tooltip taylorUpgradeTip = new Tooltip("Dunlap's Upgrade 1 -- Damage increased to 2 damage per shot");
        Tooltip dunlapUpgradeTip = new Tooltip("Taylor's Upgrade 1 -- Damage increased to 2 damage per shot");
        Tooltip albakerUpgradeTip = new Tooltip("Albaker's Upgrade 1 -- Damage increased to 2 damage per shot");
        Tooltip palloneUpgradeTip = new Tooltip("Pallone's Upgrade 1 -- Damage increased to 2 damage per shot");

        Text towers = new Text("Hire Teachers:");
        Text health = new Text("Health:");
        hpnum = new Text(g.getHealth() + "");
        Text money = new Text("Money:");
        Text moneynum = new Text(g.getMoney() + "");
        
        
        game = new StackPane();


        ArrayList<Button> buttons = new ArrayList<Button>();
        ArrayList<Tooltip> tips = new ArrayList<Tooltip>();
        ArrayList<Image> placeImages = new ArrayList<Image>();

        buttons.add(fulkButton);
        buttons.add(kwongButton);
        buttons.add(dunlapButton);
        buttons.add(taylorButton);
        buttons.add(albakerButton);
        buttons.add(palloneButton);
        buttons.add(fulkUpgradeButton);
        buttons.add(kwongUpgradeButton);
        buttons.add(albakerUpgradeButton);
        buttons.add(taylorUpgradeButton);
        buttons.add(dunlapUpgradeButton);
        buttons.add(palloneUpgradeButton);
        tips.add(fulkTip);
        tips.add(kwongTip);
        tips.add(dunlapTip);
        tips.add(taylorTip);
        tips.add(albakerTip);
        tips.add(palloneTip);
        tips.add(fulkUpgradeTip);
        tips.add(kwongUpgradeTip);
        tips.add(dunlapUpgradeTip);
        tips.add(taylorUpgradeTip);
        tips.add(albakerUpgradeTip);
        tips.add(palloneUpgradeTip);
        placeImages.add(fulkPlace);
        placeImages.add(kwongPlace);
        placeImages.add(dunlapPlace);   
        placeImages.add(taylorPlace);   
        placeImages.add(albakerPlace);
        placeImages.add(pallonePlace);
        placeImages.add(upgradePlace);


        //set values for objects
        for (Tooltip t : tips){
            t.setMaxWidth(250);
            //t.setFont(new Font(t.getFont().toString(), t.getFont().getSize()*1.25));
            t.setWrapText(true);
            t.setShowDelay(Duration.ZERO);
        }

        for (Button b : buttons){
            b.setMaxHeight(100);
            b.setMaxWidth(100);
        }

        fulkButton.setTooltip(fulkTip);
        kwongButton.setTooltip(kwongTip);
        dunlapButton.setTooltip(dunlapTip); 
        taylorButton.setTooltip(taylorTip);
        albakerButton.setTooltip(albakerTip);
        palloneButton.setTooltip(palloneTip);
        fulkUpgradeButton.setTooltip(fulkUpgradeTip);
        taylorUpgradeButton.setTooltip(taylorUpgradeTip);
        kwongUpgradeButton.setTooltip(kwongUpgradeTip);
        albakerUpgradeButton.setTooltip(albakerUpgradeTip);
        dunlapUpgradeButton.setTooltip(dunlapUpgradeTip);
        palloneUpgradeButton.setTooltip(palloneUpgradeTip);

        fullscreen.setText("Fullscreen");
        deleteButton.setText("Fire a Teacher");

        fulkButton.setBackground(new Background(fulkImage));
        kwongButton.setBackground(new Background(kwongImage));
        dunlapButton.setBackground(new Background(dunlapImage));
        taylorButton.setBackground(new Background(taylorImage));
        albakerButton.setBackground(new Background(albakerImage));
        palloneButton.setBackground(new Background(palloneImage));
        fulkUpgradeButton.setBackground(new Background(upgradeButtonImage));
        kwongUpgradeButton.setBackground(new Background(upgradeButtonImage));
        albakerUpgradeButton.setBackground(new Background(upgradeButtonImage));
        taylorUpgradeButton.setBackground(new Background(upgradeButtonImage));
        dunlapUpgradeButton.setBackground(new Background(upgradeButtonImage));
        palloneUpgradeButton.setBackground(new Background(upgradeButtonImage));



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

        fulkUpgradeButton.setTranslateX(0 - stage.getWidth()/2 + 125);
        fulkUpgradeButton.setTranslateY(0 - stage.getHeight()/2 + 125);
        fulkUpgradeButton.setScaleX(0.50);
        fulkUpgradeButton.setScaleY(0.50);

        kwongUpgradeButton.setTranslateX(0 - stage.getWidth()/2 + 125);
        kwongUpgradeButton.setTranslateY(0 - stage.getHeight()/2 + 200);
        kwongUpgradeButton.setScaleX(0.50);
        kwongUpgradeButton.setScaleY(0.50);

        dunlapUpgradeButton.setTranslateX(0 - stage.getWidth()/2 + 125);
        dunlapUpgradeButton.setTranslateY(0 - stage.getHeight()/2 + 275);
        dunlapUpgradeButton.setScaleX(0.50);
        dunlapUpgradeButton.setScaleY(0.50);

        taylorUpgradeButton.setTranslateX(0 - stage.getWidth()/2 + 125);
        taylorUpgradeButton.setTranslateY(0 - stage.getHeight()/2 + 350);
        taylorUpgradeButton.setScaleX(0.50);
        taylorUpgradeButton.setScaleY(0.50);

        albakerUpgradeButton.setTranslateX(0 - stage.getWidth()/2 + 125);
        albakerUpgradeButton.setTranslateY(0 - stage.getHeight()/2 + 425);
        albakerUpgradeButton.setScaleX(0.50);
        albakerUpgradeButton.setScaleY(0.50);

        palloneUpgradeButton.setTranslateX(0 - stage.getWidth()/2 + 125);
        palloneUpgradeButton.setTranslateY(0 - stage.getHeight()/2 + 500);
        palloneUpgradeButton.setScaleX(0.50);
        palloneUpgradeButton.setScaleY(0.50);

        fullscreen.setTranslateX(0 - stage.getWidth()/2 + 50);
        fullscreen.setTranslateY(0 - stage.getHeight()/2 + 650);
        deleteButton.setTranslateX(0-stage.getWidth()/2 + 50);
        deleteButton.setTranslateY(0 - stage.getHeight()/2 + 600);
        
        towers.setTranslateX(0 - stage.getWidth()/2 + 150);
        towers.setTranslateY(0 - stage.getHeight()/2 + 50);
        health.setTranslateX(stage.getWidth()/2 - 100);
        health.setTranslateY(0 - stage.getHeight()/2 + 75);
        hpnum.setTranslateX(stage.getWidth()/2 - 100);
        hpnum.setTranslateY(0 - stage.getHeight()/2 + 125);
        money.setTranslateX(stage.getWidth()/2 - 100);
        money.setTranslateY(0 - stage.getHeight()/2 + 175);
        moneynum.setTranslateX(stage.getWidth()/2 - 100);
        moneynum.setTranslateY(0 - stage.getHeight()/2 + 225);


        mapping.setMaxWidth(1920);
        mapping.setBackground(new Background(mappingBackground));
        mapping.setMaxHeight(1080);

        String[] teachers = new String[]{"", "Fulk", "Kwong", "Dunlap", "Taylor", "Albaker", "Pallone", "Fire a Teacher"}; //delete later
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
        fulkUpgradeButton.setOnAction(arg0 -> {
            System.out.println("case 8 start");
                    if (fulkUpgradeAmt[0] < 5)
                    {
                        if (g.getMoney() > costOfUpgrade)
                        {
                            g.subtractMoney(costOfUpgrade);
                            g.upgradeTower(8);
                            
                            if (fulkUpgradeAmt[0] == 0) {
                                System.out.println("upgrade 2 tooltip");
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 2 -- Speed increased by 2")); 
                            }
                            if (fulkUpgradeAmt[0] == 1) {
                                System.out.println("upgrade 3 tooltip");
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 3 -- Damage increased to 2 damage per shot")); 
                            }
                            if (fulkUpgradeAmt[0] == 2) {
                                System.out.println("upgrade 4 tooltip");
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 4 -- Speed increased by 2")); 
                            }
                            if (fulkUpgradeAmt[0] == 3) {
                                System.out.println("upgrade 5 tooltip");
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 5 -- Damage increased to 2 damage per shot")); 
                            }
                            if (fulkUpgradeAmt[0] == 4) {
                                System.out.println("upgrade 6 tooltip");
                                fulkUpgradeButton.setTooltip(new Tooltip("This upgrade path is maxed out. You cannot buy another upgrade here.")); 
                            }
                        }
                        else
                        {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setTitle("Not Enough Money");
                            alert2.setContentText("Not Enough money! You only have " + g.getMoney() + " dollars.");
                            alert2.setHeaderText("You need " + costOfUpgrade + " dollars to buy this upgrade.");
                            alert2.showAndWait();
                            teacherIndex[0] = 0;
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                    fulkUpgradeAmt[0]++;
                    teacherIndex[0] = 0;
        });
        kwongUpgradeButton.setOnAction(arg0 -> {
            teacherIndex[0] = 9;
        });
        dunlapUpgradeButton.setOnAction(arg0 -> {
            teacherIndex[0] = 10;
        });
        taylorUpgradeButton.setOnAction(arg0 -> {
            teacherIndex[0] = 11;
        });
        albakerUpgradeButton.setOnAction(arg0 -> {
            teacherIndex[0] = 12;
        });
        palloneUpgradeButton.setOnAction(arg0 -> {
            teacherIndex[0] = 13;
        });

        mapping.setOnMouseClicked(value ->  {
            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();

            double x = p.getX()/stage.getWidth();
            double y = p.getY()/stage.getHeight();

            //System.out.println(x + ", " + y);

            Image towerImage;
            ImageView tower;
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Not Enough Money");
            alert.setContentText("Not Enough money! You only have " + g.getMoney() + " dollars.");
            switch (teacherIndex[0]) {
                case 1:
                //change this, for testing purposes only
                    if (g.getMoney() > fulkCost){
                        towerImage = new Image(getClass().getResource("Map/Teachers/Fulk.PNG").toExternalForm());
                        tower = new ImageView(towerImage);
                        tower.setScaleX(0.5);
                        tower.setScaleY(0.5);
                        tower.setOnMouseClicked(arg0 -> {
                            if (teacherIndex[0] == 7){
                                g.addMoney(fulkCost/2);
                                moneynum.setText(g.getMoney() + "");
                                game.getChildren().remove(tower);
                            }
                        });
                        tower.setTranslateX(p.getX() - stage.getWidth()/2);
                        tower.setTranslateY(p.getY() - stage.getHeight()/2);
                        g.subtractMoney(fulkCost);
                        moneynum.setText(g.getMoney() + "");
                        game.getChildren().add(tower);
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                    }
                    else{
                        alert.setHeaderText("You need " + fulkCost + " dollars to hire Mr Fulk.");
                        alert.showAndWait();
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                    }
                    break;
                case 2:
                    if (g.getMoney() > kwongCost){
                        towerImage = new Image(getClass().getResource("Map/Teachers/Kwong.PNG").toExternalForm());
                        tower = new ImageView(towerImage);
                        tower.setScaleX(0.5);
                        tower.setScaleY(0.5);
                        tower.setOnMouseClicked(arg0 -> {
                            if (teacherIndex[0] == 7){
                                g.addMoney(kwongCost/2);
                                moneynum.setText(g.getMoney() + "");
                                game.getChildren().remove(tower);
                            }
                        });
                        tower.setTranslateX(p.getX() - stage.getWidth()/2);
                        tower.setTranslateY(p.getY() - stage.getHeight()/2);
                        game.getChildren().add(tower);
                        g.subtractMoney(kwongCost);
                        moneynum.setText(g.getMoney() + "");
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                    }
                    else{
                        alert.setHeaderText("You need " + kwongCost + " dollars to hire Mr Kwong.");
                        alert.showAndWait();
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                    }
                    break;
                case 3:
                    if (g.getMoney() > dunlapCost){
                        towerImage = new Image(getClass().getResource("Map/Teachers/Dunlap.PNG").toExternalForm());
                        tower = new ImageView(towerImage);
                        tower.setScaleX(0.5);
                        tower.setScaleY(0.5);
                        tower.setOnMouseClicked(arg0 -> {
                            if (teacherIndex[0] == 7){
                                g.addMoney(kwongCost/2);
                                moneynum.setText(g.getMoney() + "");
                                game.getChildren().remove(tower);
                            }
                        });
                        tower.setTranslateX(p.getX() - stage.getWidth()/2);
                        tower.setTranslateY(p.getY() - stage.getHeight()/2);
                        game.getChildren().add(tower);
                        g.subtractMoney(dunlapCost);
                        moneynum.setText(g.getMoney() + "");
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                        break;
                    }
                    else{
                        alert.setHeaderText("You need " + dunlapCost + " dollars to hire Mrs Dunlap.");
                        alert.showAndWait();
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                    }
                    break;
                case 4:
                    if (g.getMoney() > taylorCost){
                        towerImage = new Image(getClass().getResource("Map/Teachers/Taylor.PNG").toExternalForm());
                        tower = new ImageView(towerImage);
                        tower.setScaleX(0.5);
                        tower.setScaleY(0.5);
                        tower.setOnMouseClicked(arg0 -> {
                            if (teacherIndex[0] == 7){
                                g.addMoney(taylorCost/2);
                                moneynum.setText(g.getMoney() + "");
                                game.getChildren().remove(tower);
                            }
                        });
                        tower.setTranslateX(p.getX() - stage.getWidth()/2);
                        tower.setTranslateY(p.getY() - stage.getHeight()/2);
                        game.getChildren().add(tower);
                        g.subtractMoney(taylorCost);
                        moneynum.setText(g.getMoney() + "");
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                        break;
                    }
                    else{
                        alert.setHeaderText("You need " + taylorCost + " dollars to hire Mr Taylor.");
                        alert.showAndWait();
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                    }
                    break;
                case 5:
                    if (g.getMoney() > albakerCost){
                        towerImage = new Image(getClass().getResource("Map/Teachers/Albaker.PNG").toExternalForm());
                        tower = new ImageView(towerImage);
                        tower.setScaleX(0.5);
                        tower.setScaleY(0.5);
                        tower.setOnMouseClicked(arg0 -> {
                            if (teacherIndex[0] == 7){
                                g.addMoney(albakerCost/2);
                                moneynum.setText(g.getMoney() + "");
                                game.getChildren().remove(tower);
                            }
                        });
                        tower.setTranslateX(p.getX() - stage.getWidth()/2);
                        tower.setTranslateY(p.getY() - stage.getHeight()/2);
                        game.getChildren().add(tower);
                        g.subtractMoney(albakerCost);
                        moneynum.setText(g.getMoney() + "");
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                        break;
                    }
                    else{
                        alert.setHeaderText("You need " + albakerCost + " dollars to hire Mrs Albaker.");
                        alert.showAndWait();
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                    }
                    break;
                case 6:
                    if (g.getMoney() > palloneCost){
                        towerImage = new Image(getClass().getResource("Map/Teachers/Pallone.PNG").toExternalForm());
                        tower = new ImageView(towerImage);
                        tower.setScaleX(0.5);
                        tower.setScaleY(0.5);
                        tower.setOnMouseClicked(arg0 -> {
                            if (teacherIndex[0] == 7){
                                g.addMoney(palloneCost/2);
                                moneynum.setText(g.getMoney() + "");
                                game.getChildren().remove(tower);
                            }
                        });
                        tower.setTranslateX(p.getX() - stage.getWidth()/2);
                        tower.setTranslateY(p.getY() - stage.getHeight()/2);
                        game.getChildren().add(tower);
                        g.subtractMoney(palloneCost);
                        moneynum.setText(g.getMoney() + "");
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                        break;
                    }
                    else{
                        alert.setHeaderText("You need " + palloneCost + " dollars to hire Mr Pallone.");
                        alert.showAndWait();
                        teacherIndex[0] = 0;
                        scene.setCursor(Cursor.DEFAULT);
                    }
                    break;
                /*case 8:
                    System.out.println("case 8 start");
                    if (fulkUpgradeAmt[0] < 5)
                    {
                        if (g.getMoney() > costOfUpgrade)
                        {
                            g.subtractMoney(costOfUpgrade);
                            g.upgradeTower(8);
                            
                            if (fulkUpgradeAmt[0] == 0) {
                                System.out.println("upgrade 2 tooltip");
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 2 -- Speed increased by 2")); 
                            }
                            if (fulkUpgradeAmt[0] == 1) {
                                System.out.println("upgrade 3 tooltip");
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 3 -- Damage increased to 2 damage per shot")); 
                            }
                            if (fulkUpgradeAmt[0] == 2) {
                                System.out.println("upgrade 4 tooltip");
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 4 -- Speed increased by 2")); 
                            }
                            if (fulkUpgradeAmt[0] == 3) {
                                System.out.println("upgrade 5 tooltip");
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 5 -- Damage increased to 2 damage per shot")); 
                            }
                            if (fulkUpgradeAmt[0] == 4) {
                                System.out.println("upgrade 6 tooltip");
                                fulkUpgradeButton.setTooltip(new Tooltip("This upgrade path is maxed out. You cannot buy another upgrade here.")); 
                            }
                        }
                        else
                        {
                            alert.setHeaderText("You need " + costOfUpgrade + " dollars to hire Mr Pallone.");
                            alert.showAndWait();
                            teacherIndex[0] = 0;
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                    fulkUpgradeAmt[0]++;
                    teacherIndex[0] = 0;
                    break;
                    case 9: //recopy the case 8 code and copy paste
                    if (fulkUpgradeAmt[0] < 5)
                    {
                        if (g.getMoney() > costOfUpgrade)
                        {
                            g.upgradeTower(8);
                            
                            if (fulkUpgradeAmt[0] == 0) {
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 2 -- Speed increased by 2")); 
                            }
                            if (fulkUpgradeAmt[0] == 1) {
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 3 -- Damage increased to 2 damage per shot")); 
                            }
                            if (fulkUpgradeAmt[0] == 2) {
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 4 -- Speed increased by 2")); 
                            }
                            if (fulkUpgradeAmt[0] == 3) {
                                fulkUpgradeButton.setTooltip(new Tooltip("Fulk's Upgrade 5 -- Damage increased to 2 damage per shot")); 
                            }
                            if (fulkUpgradeAmt[0] == 4) {
                                fulkUpgradeButton.setTooltip(new Tooltip("This upgrade path is maxed out. You cannot buy another upgrade here.")); 
                            }
                        }
                        else
                        {
                            alert.setHeaderText("You need " + costOfUpgrade + " dollars to hire Mr Pallone.");
                            alert.showAndWait();
                            teacherIndex[0] = 0;
                            scene.setCursor(Cursor.DEFAULT);
                        }
                    }
                    fulkUpgradeAmt[0]++;
                    teacherIndex[0] = 0;
                    break;*/
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
        money.setId("money");
        moneynum.setId("money");

        game.getChildren().add(hpnum);
        game.getChildren().add(mapping);
        game.getChildren().add(fulkButton);
        game.getChildren().add(kwongButton);
        game.getChildren().add(towers);
        game.getChildren().add(dunlapButton);
        game.getChildren().add(taylorButton);
        game.getChildren().add(albakerButton);
        game.getChildren().add(palloneButton);
        game.getChildren().add(fulkUpgradeButton);
        game.getChildren().add(kwongUpgradeButton);
        game.getChildren().add(dunlapUpgradeButton);
        game.getChildren().add(taylorUpgradeButton);
        game.getChildren().add(albakerUpgradeButton);
        game.getChildren().add(palloneUpgradeButton);
        game.getChildren().add(health);
        game.getChildren().add(fullscreen);
        game.getChildren().add(deleteButton);
        game.getChildren().add(money);
        game.getChildren().add(moneynum);

        
        scene.setRoot(game);
        g.run(game, hpnum);
    }
}