package com.pokemon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.File;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private HBox cardContainer;
    private int currentIndex = 0;
    private Scene scene1, scene2;

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {

        // get screensize of monitor
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        double centerPos = screenSize.getWidth()/4;

        System.out.println("---------Center POsistion is:" +centerPos);


        Image dbTitleImg1 = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle11.png");
        Image dbTitleImg2 = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle22.png");


        ImageView imageView1 = new ImageView(dbTitleImg1);
        imageView1.setFitWidth(140);
        imageView1.setFitHeight(100);
        imageView1.getStyleClass().add("shadow-label");
        ImageView imageView2 = new ImageView(dbTitleImg2);
        imageView2.setFitWidth(140);
        imageView2.setFitHeight(100);
        imageView2.getStyleClass().add("shadow-label");

        Label lbl_dbTitle = new Label("Pokédex Database");
        lbl_dbTitle.getStyleClass().add("title-label");

        //Footer stuff
        Label lbl_footer  = new Label("All content & design ©AbaJEthan licended under Devika Maini CS2450");
        lbl_footer.setLayoutX(430);
        lbl_footer.setLayoutY(1530);
        lbl_footer.getStyleClass().add("footer-text");


        Rectangle footerBackground = new Rectangle(0, 1500, screenSize.getWidth(), 100);
        footerBackground.setFill(Color.web("#717e8e"));


        HBox hb_homeTitle = new HBox(40,imageView1,lbl_dbTitle,imageView2);
        hb_homeTitle.getStyleClass().add("hbox-with-gradient");
        hb_homeTitle.setAlignment(Pos.TOP_CENTER);

        Button bttnHome = new Button("Home");
        bttnHome.getStyleClass().add("bttn-label2");
        bttnHome.setPrefWidth(screenSize.getWidth()/2);
        // bttnHome.setPrefWidth(300);

        cardContainer = new HBox(0); // Set the spacing between cards

        // Add your cards (rectangles with images and text) to the cardContainer
        addCard("\nMy Fire Poke\t     637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\fire.png");
        addCard("\nMy Water Poke   637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\firebk.png");
        addCard("\nMy Grass Poke   637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\grass.png");
        addCard("\nMy Koky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle11.png");
        addCard("\nMy Roky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\water.png");
        addCard("\nMy Roky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\water.png");
        addCard("\nMy Roky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\water.png");
        addCard("\nMy Roky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\water.png");
        addCard("\nMy Fire Poke\t     637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\fire.png");
        addCard("\nMy Water Poke   637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\firebk.png");


        //Feature pokemon functionality
        ScrollPane FeaturePokeScrollPane = new ScrollPane();
        FeaturePokeScrollPane.setContent(cardContainer);
        FeaturePokeScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        FeaturePokeScrollPane.setLayoutY(1100);
        FeaturePokeScrollPane.setLayoutX(0);


        Image leftArrImg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\leftArr.png");
        ImageView buttnImage = new ImageView(leftArrImg);
        buttnImage.setFitWidth(40);
        buttnImage.setFitHeight(80);

        Image rightArrImg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\rightArr.png");
        ImageView buttnImage2 = new ImageView(rightArrImg);
        buttnImage2.setFitWidth(40);
        buttnImage2.setFitHeight(80);

        Button leftButton = new Button();
        leftButton.setOnAction(e -> scrollLeft());
        leftButton.setStyle("-fx-background-color: transparent; -fx-font-weight: bold; -fx-font-size: 32px;");
        leftButton.setGraphic(buttnImage);

        Button rightButton = new Button();
        rightButton.setStyle("-fx-background-color: transparent; -fx-font-weight: bold;");
        rightButton.setGraphic(buttnImage2);

        FadeTransition fadeIn_R_Bttn = new FadeTransition(Duration.millis(35), rightButton);
        fadeIn_R_Bttn.setFromValue(0.0);
        fadeIn_R_Bttn.setToValue(1.0);

        FadeTransition fadeOut_R_Bttn = new FadeTransition(Duration.millis(35), rightButton);
        fadeOut_R_Bttn.setFromValue(0.0);
        fadeOut_R_Bttn.setToValue(1.0);

        rightButton.setOnAction(e -> {
            fadeIn_R_Bttn.playFromStart();
            fadeOut_R_Bttn.playFromStart();
            scrollRight();});

            FadeTransition fadeIn_L_Bttn = new FadeTransition(Duration.millis(35), leftButton);
        fadeIn_L_Bttn.setFromValue(0.0);
        fadeIn_L_Bttn.setToValue(1.0);

        FadeTransition fadeOut_L_Bttn = new FadeTransition(Duration.millis(35), leftButton);
        fadeOut_L_Bttn.setFromValue(0.0);
        fadeOut_L_Bttn.setToValue(1.0);

        leftButton.setOnAction(e -> {
            fadeIn_L_Bttn.playFromStart();
            fadeOut_L_Bttn.playFromStart();
            scrollRight();});

        HBox hb_horizScrollBar_buttons = new HBox(screenSize.getWidth()/1.09,leftButton, rightButton);//--------------------------------------NOTE: You may need to change the 1550px scpace between buttons
        hb_horizScrollBar_buttons.setLayoutY(1200);
        hb_horizScrollBar_buttons.setPadding(new Insets(15,0,0,0));

        Image featurePokeImg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\featurepokemon2.png");

        Rectangle recFeaturePoke = new Rectangle(0,890,1000,350);
        recFeaturePoke.setArcWidth(20);
        recFeaturePoke.setArcHeight(20);
        recFeaturePoke.setFill(new ImagePattern(featurePokeImg));
        recFeaturePoke.setLayoutX(centerPos-100);

        Menu pokedexMenu = new Menu("                                          Pokédex");
        MenuItem fireItem = new MenuItem("Fire Pokédex");
        MenuItem waterItem = new MenuItem("Water Pokédex");
        MenuItem grassItem = new MenuItem("Grass Pokédex");
        pokedexMenu.getStyleClass().add("menu");
        pokedexMenu.getItems().addAll(fireItem,waterItem,grassItem);


        MenuBar homeMenuBar = new MenuBar();
        homeMenuBar.getMenus().addAll(pokedexMenu);
        homeMenuBar.getStyleClass().add("bttn-label");
        homeMenuBar.setPrefWidth((screenSize.getWidth())/2);

        HBox hb_hometaskbar = new HBox(bttnHome,homeMenuBar);
        hb_hometaskbar.setAlignment(Pos.CENTER);
    //    hb_hometaskbar.setMinWidth(800);
        hb_hometaskbar.setPadding(new Insets(0,0,20,0));

   //     HBox hb_missionStatement = new HBox(10, missionStatement);
   //     hb_missionStatement.setAlignment(Pos.CENTER);
   //     hb_missionStatement.setPadding(new Insets(10,0,0,0));

        // Home- Cards Images
    //    Image fireImg = new Image("file:///D:/CPP/CS 2450 UI/PokePics/fire.png");
    //    Image waterImg = new Image("file:///D:/CPP/CS 2450 UI/PokePics/water.png");
    //    Image grassImg = new Image("file:///D:/CPP/CS 2450 UI/PokePics/grass.png");

  //      Image backgroundImage = new Image("file:///D:/CPP/CS 2450 UI/PokePics/firebk.png");


        Image fireImgbg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\firecard2copy.jpg");
        Image fireImgfg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\firecardcopy2.jpg");

        Image waterImgbg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\watercard.jpg");
        Image waterImgfg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\watercard2.jpg");

        Image grassImgbg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\sceptile.jpg");
        Image grassImgfg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\grasscard2.jpg");

        Image backdrop1 = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\backdrop2.jpg");
        //ImageView  = new ImageView(backdrop1);

/*
        ImageView imageViewFire = new ImageView(fireImg);
        imageViewFire.setFitWidth(200);
        imageViewFire.setFitHeight(300);
        imageViewFire.getStyleClass().add("shadow-label");        //-----------------HERE
        imageViewFire.setX(90);
        imageViewFire.setY(280);

        ImageView imageViewWater = new ImageView(waterImg);
        imageViewWater.setFitWidth(200);
        imageViewWater.setFitHeight(370);
        imageViewWater.getStyleClass().add("shadow2-label");        //-----------------HERE
        imageViewWater.setX(350);
        imageViewWater.setY(240);

        ImageView imageViewGrass = new ImageView(grassImg);
        imageViewGrass.setFitWidth(200);
        imageViewGrass.setFitHeight(270);
        imageViewGrass.getStyleClass().add("shadow3-label");        //-----------------HERE
        imageViewGrass.setX(615);
        imageViewGrass.setY(290);
 */
      //  HBox hb_3pokedex = new HBox(60,imageViewFire,imageViewWater,imageViewGrass);
       // hb_3pokedex.setAlignment(Pos.BOTTOM_CENTER);
       // hb_3pokedex.setPadding(new Insets(80,0,0,90));

/*         Rectangle recBackgr = new Rectangle();
        recBackgr.setWidth(900);
        recBackgr.setHeight(1500);
        recBackgr.setFill(new ImagePattern(backdrop1)); */


        // Home- Cards Rectangles
                             // Rectangle(X,Y,Weidth, Height)
        Rectangle recFire = new Rectangle(80,480,230,190);
        recFire.setStroke(Color.BLACK);
        recFire.setArcWidth(20);
        recFire.setArcHeight(20);
        recFire.setFill(new ImagePattern(fireImgbg));
recFire.setLayoutX(centerPos - (129+69));   // 129 is the width of the frontground rectangle / 2

        Rectangle recFireText = new Rectangle(80,660,230,300);
        recFireText.setFill(Color.LIGHTSALMON);
        recFireText.setStroke(Color.LIGHTSALMON);
recFireText.setLayoutX(centerPos - (129+69));   // 129 is the width of the frontground rectangle / 2

      Rectangle recFirefrntgrnd= new Rectangle(77,480,238,484);
      recFirefrntgrnd.setFill(new ImagePattern(fireImgfg));
      recFirefrntgrnd.setArcWidth(20);
      recFirefrntgrnd.setArcHeight(20);
      recFirefrntgrnd.setOpacity(1.0);
      recFirefrntgrnd.getStyleClass().add("shadow-label");
      recFirefrntgrnd.setStroke(Color.BLACK);
recFirefrntgrnd.setLayoutX(centerPos - (129+69));   // 129 is the width of the frontground rectangle / 2

      Rectangle recWater = new Rectangle(340,480,230,190);
      recWater.setStroke(Color.BLACK);
      recWater.setArcWidth(20);
      recWater.setArcHeight(20);
      recWater.setFill(new ImagePattern(waterImgbg));
      recWater.setLayoutX(centerPos-69);

      Rectangle recWaterText = new Rectangle(340,660,230,300);
      recWaterText.setFill(Color.LIGHTSKYBLUE);
      recWaterText.setStroke(Color.LIGHTSKYBLUE);
      recWaterText.setLayoutX(centerPos-69);

      Rectangle recWaterfrntgrnd= new Rectangle(337,480,238,484);
      recWaterfrntgrnd.setFill(new ImagePattern(waterImgfg));
      recWaterfrntgrnd.setArcWidth(20);
      recWaterfrntgrnd.setArcHeight(20);
      recWaterfrntgrnd.setOpacity(1.0);
      recWaterfrntgrnd.getStyleClass().add("shadow2-label");
      recWaterfrntgrnd.setStroke(Color.BLACK);
      recWaterfrntgrnd.setLayoutX(centerPos-69);

      Rectangle recGrass = new Rectangle(600,480,230,190);
      recGrass.setStroke(Color.BLACK);
      recGrass.setArcWidth(20);
      recGrass.setArcHeight(20);
      recGrass.setFill(new ImagePattern(grassImgbg));
      recGrass.setLayoutX(centerPos + (129-69));

      Rectangle recGrassText = new Rectangle(600,660,230,300);
      recGrassText.setFill(Color.LIGHTGREEN);
      recGrassText.setStroke(Color.LIGHTGREEN);
      recGrassText.setLayoutX(centerPos + (129-69));

      Rectangle recGrassfrntgrnd= new Rectangle(600,480,238,484);
      recGrassfrntgrnd.setFill(new ImagePattern(grassImgfg));
      recGrassfrntgrnd.setArcWidth(20);
      recGrassfrntgrnd.setArcHeight(20);
      recGrassfrntgrnd.setOpacity(1.0);
      recGrassfrntgrnd.getStyleClass().add("shadow3-label");
      recGrassfrntgrnd.setStroke(Color.BLACK);
      recGrassfrntgrnd.setLayoutX(centerPos + (129-69));


        // Home- Cards Text
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 75);

        Font biggerFont = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 130);

        Font missionHeaderFont = Font.font("SERIF", FontWeight.BOLD, FontPosture.REGULAR, 32);

        Font biggerFont2 = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 32);

        Font smallerFont =  Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 14);

        Font slightlyBiggerFont =  Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22);


        Text txtMissionHeader = new Text("Welcome to the Pokemon Database!");
        txtMissionHeader.setFont(missionHeaderFont);
      //  txtMissionHeader.setX(155);
      //  txtMissionHeader.setY(300);

        Text txtMissionBody = new Text("The world of Pokémon connects people across the globe,beloved by kids, adults, \nand every Trainer in between! These incredible creatures have crossed \nborders and language barriers to reach the hearts of millions for over 25 years, \nbringing people together through the joy of play and discovery. We aim to delight \nour fans through excellentproducts and meaningful experiences.\n We hope to help make thew rold a better place for everyone by creating opportunities\n to bond and to grow through shared journeys and friendly competition!");
        txtMissionBody.setFont(slightlyBiggerFont);
      //  txtMissionBody.setX(155);
      //  txtMissionBody.setY(320);

        VBox vb_welcome = new VBox(10, txtMissionHeader,txtMissionBody);
      //  vb_welcome.setAlignment(Pos.CENTER);
        vb_welcome.setPadding(new Insets(200,0,0,screenSize.getWidth()/3));

        Text txtFireTitle =new Text(85,720," CHARIZARD");
        txtFireTitle.setFont(biggerFont2);
        txtFireTitle.setLayoutX(centerPos- (129 + 69)); // 129 is the width of the frontground rectangle / 2

        Text txtFireDescrip =new Text(85,760,"Fire types are notoriously rare in the \nearly stages of the games so choosing \nthe Fire variation starter is often \na plus. This is Abanob's favorite type!");
        txtFireDescrip.setFont(smallerFont);
        txtFireDescrip.setLayoutX(centerPos-(129 + 69));   // 129 is the width of the frontground rectangle / 2

        Text txtWaterTitle =new Text(344,720,"  GYRADOS");
        txtWaterTitle.setFont(biggerFont2);
        txtWaterTitle.setLayoutX(centerPos - 69);

        Text txtWaterDescrip =new Text(344,760,"Water is the most common type with \nover 150 Pokémon, which are based on \na wide variety of fish and other \nsea-dwelling creatures.");
        txtWaterDescrip.setFont(smallerFont);
        txtWaterDescrip.setLayoutX(centerPos -69);


        Text txtGrassTitle =new Text(605,720,"  SCEPTILE");
        txtGrassTitle.setFont(biggerFont2);
        txtGrassTitle.setLayoutX(centerPos + (129 - 69));


        Text txtGrassDescrip =new Text(605,760,"Grass is one of the weakest types \nstatistically, with 5 defensive \nweaknesses and 7 types that are resist-\nant to Grass moves. Furthermore, \nthree type combos paired with Grass \nhave 7 weaknesses: Grass/Psychic, \nGrass/Ice, and Grass/Dark.");
        txtGrassDescrip.setFont(smallerFont);
        txtGrassDescrip.setLayoutX(centerPos + (129 - 69));


   /*     Text txtFire = new Text(100,520,"Fire");
        txtFire.setFont(biggerFont);
        txtFire.setFill(Color.WHITE);
        txtFire.setStroke(Color.BLACK);
        txtFire.setStrokeWidth(1);

        Text txtWater = new Text(380,640,"Water");
        txtWater.setFont(font);
        txtWater.setFill(Color.LIGHTBLUE);
        txtWater.setStroke(Color.BLACK);
        txtWater.setStrokeWidth(1);

        Text txtGrass = new Text(640,630,"Grass");
        txtGrass.setFont(font);
        txtGrass.setFill(Color.GREEN);
        txtGrass.setStroke(Color.BLACK);
        txtGrass.setStrokeWidth(1);  */

        // Home - 3 Cards Fading In/Out
        FadeTransition fadeInFire = new FadeTransition(Duration.millis(200), recFirefrntgrnd);
        fadeInFire.setFromValue(0.0);
        fadeInFire.setToValue(1.0);
        FadeTransition fadeOutFire = new FadeTransition(Duration.millis(100), recFirefrntgrnd);
        fadeOutFire.setFromValue(1.0);
        fadeOutFire.setToValue(0.0);

        FadeTransition fadeInGrass = new FadeTransition(Duration.millis(200), recGrassfrntgrnd);
        fadeInGrass.setFromValue(0.0);
        fadeInGrass.setToValue(1.0);
        FadeTransition fadeOutGrass = new FadeTransition(Duration.millis(100), recGrassfrntgrnd);
        fadeOutGrass.setFromValue(1.0);
        fadeOutGrass.setToValue(0.0);

        FadeTransition fadeInWater = new FadeTransition(Duration.millis(200), recWaterfrntgrnd);
        fadeInWater.setFromValue(0.0);
        fadeInWater.setToValue(1.0);
        FadeTransition fadeOutWater = new FadeTransition(Duration.millis(100), recWaterfrntgrnd);
        fadeOutWater.setFromValue(1.0);
        fadeOutWater.setToValue(0.0);


        // Home- 3 Cards Events
         recFirefrntgrnd.setOnMouseEntered(event -> {
            fadeOutFire.playFromStart();
        });

        recFirefrntgrnd.setOnMouseExited(event -> {
            fadeInFire.playFromStart();
        });

         recWaterfrntgrnd.setOnMouseEntered(event -> {
                fadeOutWater.playFromStart();
        });

        recWaterfrntgrnd.setOnMouseExited(event -> {
                fadeInWater.playFromStart();
        });

        recGrassfrntgrnd.setOnMouseEntered(event -> {
                fadeOutGrass.playFromStart();
        });

        recGrassfrntgrnd.setOnMouseExited(event -> {
                fadeInGrass.playFromStart();
        });

/*
        // Home- Cards Events
        imageViewFire.setOnMouseEntered(event -> {
        imageViewFire.setFitWidth(280);
        imageViewFire.setFitHeight(360);
        imageViewFire.setX(40);
        imageViewFire.setY(200);

        txtFire.setFont(biggerFont);
        txtFire.setX(50);
        });

        imageViewFire.setOnMouseExited(event -> {
        imageViewFire.setFitWidth(200);
        imageViewFire.setFitHeight(300);
        imageViewFire.setX(90);
        imageViewFire.setY(280);

        txtFire.setFont(font);
        txtFire.setX(140);
        });

        recFire.setOnMouseEntered(event -> {
        imageViewFire.setFitWidth(280);
        imageViewFire.setFitHeight(360);
        imageViewFire.setX(40);
        imageViewFire.setY(200);

        txtFire.setFont(biggerFont);
        txtFire.setX(50);
        });

        recFire.setOnMouseExited(event -> {
        imageViewFire.setFitWidth(200);
        imageViewFire.setFitHeight(300);
        imageViewFire.setX(90);
        imageViewFire.setY(280);

        txtFire.setFont(font);
        txtFire.setX(140);
        });

        txtFire.setOnMouseEntered(event -> {
        imageViewFire.setFitWidth(280);
        imageViewFire.setFitHeight(360);
        imageViewFire.setX(40);
        imageViewFire.setY(200);

        txtFire.setFont(biggerFont);
        txtFire.setX(50);
        });

        txtFire.setOnMouseExited(event -> {
        imageViewFire.setFitWidth(200);
        imageViewFire.setFitHeight(300);
        imageViewFire.setX(90);
        imageViewFire.setY(280);

        txtFire.setFont(font);
        txtFire.setX(140);
        });
 */

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
            Functionality to move between scenes:
                - Click on Pokedex
                - Click on Fire Pokedex
                - Moves to Fire Pokedex scene
        */
        fireItem.setOnAction(event ->
        {
            primaryStage.setScene(scene2);
        });

        // Scene 2 (Pokedex)
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Header code
        Label lbl_dbTitleSc2 = new Label("Pokédex Database");
        lbl_dbTitleSc2.getStyleClass().add("title-label");

        HBox hb_homeTitleSc2 = new HBox(lbl_dbTitleSc2);
        hb_homeTitleSc2.getStyleClass().add("hbox-with-gradient");
        hb_homeTitleSc2.setAlignment(Pos.CENTER);

        //// Menubar code
        // Home Button
        Button bttnHomeSc2 = new Button("Home");
        bttnHomeSc2.getStyleClass().add("bttn-label");
        bttnHomeSc2.setMinWidth(130); // Adjust the value as needed

        // Pokedex menu items
        Menu pokedexMenuSc2 = new Menu("Pokédex");
        MenuItem fireItemSc2 = new MenuItem("Fire Pokédex");
        MenuItem waterItemSc2 = new MenuItem("Water Pokédex");
        MenuItem grassItemSc2 = new MenuItem("Grass Pokédex");
        pokedexMenuSc2.getItems().addAll(fireItemSc2,waterItemSc2,grassItemSc2);

        // Pokedex menu styling
        MenuBar homeMenuBarSc2 = new MenuBar();
        homeMenuBarSc2.getMenus().addAll(pokedexMenuSc2);
        homeMenuBarSc2.getStyleClass().add("bttn-label");


        HBox hb_hometaskbarSc2 = new HBox(542,bttnHomeSc2,homeMenuBarSc2);
        hb_hometaskbarSc2.setAlignment(Pos.CENTER);
        hb_hometaskbarSc2.setPadding(new Insets(10,0,20,0));

        // Home button functionality
        bttnHomeSc2.setOnAction(event ->
        {
            primaryStage.setScene(scene1);
        });

        // Pokedex Entries

        // Row 1
        Image charmander = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Fire Pokemon\\charmander.jpg");
        ImageView charmanderImageView = new ImageView(charmander);
        charmanderImageView.setPreserveRatio(true);
        charmanderImageView.setFitWidth(175);

        Image charmeleon = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Fire Pokemon\\charmeleon.jpg");
        ImageView charmeleonImageView = new ImageView(charmeleon);
        charmeleonImageView.setPreserveRatio(true);
        charmeleonImageView.setFitWidth(175);

        Image charizard = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Fire Pokemon\\charizard.jpg");
        ImageView charizardImageView = new ImageView(charizard);
        charizardImageView.setPreserveRatio(true);
        charizardImageView.setFitWidth(175);

        /*
            Labels and VBoxes
        */
        Label charmanderLabel = new Label("Charmander");
        Label charmanderGen = new Label("Generation 1");
        VBox charmanderVBox = new VBox(charmanderLabel, charmanderGen);
        charmanderVBox.setAlignment(Pos.CENTER);

        Label charmeleonLabel = new Label("Charmeleon");
        Label charmeleonGen = new Label("Generation 3");
        VBox charmeleonVBox = new VBox(charmeleonLabel, charmeleonGen);
        charmeleonVBox.setAlignment(Pos.CENTER);

        Label charizardLabel = new Label("Charizard");
        Label charizardGen = new Label("Generation 3");
        VBox charizardVBox = new VBox(charizardLabel, charizardGen);
        charizardVBox.setAlignment(Pos.CENTER);

        /*
            Hbox rows
        */
        HBox pokedexRow1 = new HBox(255, charmanderVBox, charmeleonVBox, charizardVBox);
        pokedexRow1.setAlignment(Pos.CENTER);

        HBox sc2Row1 = new HBox(150, charmanderImageView, charmeleonImageView, charizardImageView);
        sc2Row1.setAlignment(Pos.CENTER);

        // Row 2

        /*
            Images and ImageViews
        */
        Image cyndaquil = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Fire Pokemon\\cyndaquil.jpg");
        ImageView cyndaquilImageView = new ImageView(cyndaquil);
        cyndaquilImageView.setPreserveRatio(true);
        cyndaquilImageView.setFitWidth(175);

        Image quilava = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Fire Pokemon\\quilava.jpg");
        ImageView quilavaImageView = new ImageView(quilava);
        quilavaImageView.setPreserveRatio(true);
        quilavaImageView.setFitWidth(175);

        Image typhlosion = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Fire Pokemon\\typhlosion.jpg");
        ImageView typhlosionImageView = new ImageView(typhlosion);
        typhlosionImageView.setPreserveRatio(true);
        typhlosionImageView.setFitWidth(175);

        /*
            Labels and VBoxes
        */
        Label cyndaquilLabel = new Label("Cyndaquil");
        Label cyndaquilGen = new Label("Generation 2");
        VBox cyndaquilVBox = new VBox(cyndaquilLabel, cyndaquilGen);
        cyndaquilVBox.setAlignment(Pos.CENTER);

        Label quilavaLabel = new Label("Quilava");
        Label quilavaGen = new Label("Generation 2");
        VBox quilavaVBox = new VBox(quilavaLabel, quilavaGen);
        quilavaVBox.setAlignment(Pos.CENTER);

        Label typhlosionLabel = new Label("Typhlosion");
        Label typhlosionGen = new Label("Generation 2");
        VBox typhlosionVBox = new VBox(typhlosionLabel, typhlosionGen);
        typhlosionVBox.setAlignment(Pos.CENTER);

        /*
            Hbox rows
        */
        HBox pokedexRow2 = new HBox(255, cyndaquilVBox, quilavaVBox, typhlosionVBox);
        pokedexRow2.setAlignment(Pos.CENTER);

        HBox sc2Row2 = new HBox(150, cyndaquilImageView, quilavaImageView, typhlosionImageView);
        sc2Row2.setAlignment(Pos.CENTER);

        // Row 3
        Image torchic = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Fire Pokemon\\torchic.jpg");
        ImageView torchicImageView = new ImageView(torchic);
        torchicImageView.setPreserveRatio(true);
        torchicImageView.setFitWidth(175);

        Image combusken = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Fire Pokemon\\combusken.jpg");
        ImageView combuskenImageView = new ImageView(combusken);
        combuskenImageView.setPreserveRatio(true);
        combuskenImageView.setFitWidth(175);

        Image blaizken = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Fire Pokemon\\blaziken.jpg");
        ImageView blaizkenImageView = new ImageView(blaizken);
        blaizkenImageView.setPreserveRatio(true);
        blaizkenImageView.setFitWidth(175);



        /*
            Labels and VBoxes
        */
        Label torchicLabel = new Label("Torchic");
        Label torchicGen = new Label("Generation 3");
        VBox torchicVBox = new VBox(torchicLabel, torchicGen);
        torchicVBox.setAlignment(Pos.CENTER);

        Label combuskenLabel = new Label("Combusken");
        Label combuskenGen = new Label("Generation 3");
        VBox combuskenVBox = new VBox(combuskenLabel, combuskenGen);
        combuskenVBox.setAlignment(Pos.CENTER);

        Label blaizkenLabel = new Label("Blaziken");
        Label blaizkenGen = new Label("Generation 3");
        VBox blaizkenVBox = new VBox(blaizkenLabel, blaizkenGen);
        blaizkenVBox.setAlignment(Pos.CENTER);

        /*
            Footer:
            Changed lbl_footer to lbl_footerFire (Fire Pokedex page)
            Changed footerBackground to footerBackgroundFire (Fire Pokedex page)
         */
        Label lbl_footerFire  = new Label("All content & design ©AbaJEthan licended under Devika Maini CS2450");
        lbl_footerFire.setLayoutX(475);
        lbl_footerFire.setLayoutY(1530);
        lbl_footerFire.getStyleClass().add("footer-text");

        Rectangle footerBackgroundFire = new Rectangle(0, 1500, screenSize.getWidth(), 100);
        footerBackgroundFire.setFill(Color.web("#717e8e"));

        Group footerGroupFire = new Group(footerBackgroundFire, lbl_footerFire);
        /*
            Hbox rows
        */
        HBox pokedexRow3 = new HBox(255, torchicVBox, combuskenVBox, blaizkenVBox);
        pokedexRow3.setAlignment(Pos.CENTER);

        HBox sc2Row3 = new HBox(150, torchicImageView, combuskenImageView, blaizkenImageView);
        sc2Row3.setAlignment(Pos.CENTER);

        // VBox that puts the pokedex together
        VBox pokedexVbox = new VBox(50, sc2Row1, pokedexRow1, sc2Row2, pokedexRow2, sc2Row3, pokedexRow3);

        // VBox that puts everything together
        VBox layout2 = new VBox(hb_homeTitleSc2, hb_hometaskbarSc2, pokedexVbox, footerGroupFire);
        layout2.setStyle("-fx-background-color: white");

        // (OPTIONAL) ADD THE BACKGROUND TO THE FIRE SCENE2
        layout2.setStyle("-fx-background-image: url(file:///D:/CPP/CS%202450%20UI/PokePics/backdrop2.jpg);" + "-fx-background-size: cover;");


        // Add the rootGRP to a ScrollPane to allow scrolling
        ScrollPane fireScrollPane = new ScrollPane(layout2);
        fireScrollPane.setFitToWidth(true); // Allow the ScrollPane to resize horizontally
        fireScrollPane.setFitToHeight(true); // Allow the ScrollPane to resize vertically

        scene2 = new Scene(fireScrollPane, screenSize.getWidth(), screenSize.getHeight());
        scene2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


        //CREATES ALL POPUPS, REFRENCE THIS FOR PARAMETERS
        //createPopup(String name, String image, String species, String height, String weight, String abilities
        Popup charmanderPopup = createPopup(charmanderLabel.getText(), charmanderLabel.getText(), "Lizard Pokémon", "0.6m", "18.7lbs", "Blaze");
        // Set action on ImageView click to show the popup
        charmanderImageView.setOnMouseClicked(event -> {
            charmanderPopup.show(charmanderImageView.getScene().getWindow());
        });

        Popup charmeleonPopup = createPopup(charmeleonLabel.getText(), charmeleonLabel.getText(), "Flame Pokémon", "1.1m", "41.9lbs", "Blaze");
        // Set action on ImageView click to show the popup
        charmeleonImageView.setOnMouseClicked(event -> {
            charmeleonPopup.show(charmeleonImageView.getScene().getWindow());
        });

        Popup charizardPopup = createPopup(charizardLabel.getText(), charizardLabel.getText(), "Flame Pokémon", "1.7m", "200lbs", "Solar Power");
        // Set action on ImageView click to show the popup
        charizardImageView.setOnMouseClicked(event -> {
            charizardPopup.show(charizardImageView.getScene().getWindow());
        });


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        VBox homeTopPartVB = new VBox(hb_homeTitle,hb_hometaskbar);
        homeTopPartVB.setAlignment(Pos.CENTER);

/*         BorderPane rootBP = new BorderPane();
        rootBP.setTop(rootVB);
        rootBP.setPrefWidth(screenSize.getWidth()); */

        Group rootGRP = new Group(FeaturePokeScrollPane,recFeaturePoke, hb_horizScrollBar_buttons,vb_welcome,homeTopPartVB,recFire ,recFireText, recWater,recWaterText,recGrass,recGrassText,
        txtFireDescrip,txtFireTitle,txtWaterDescrip,txtWaterTitle, txtGrassTitle,txtGrassDescrip,recFirefrntgrnd,recWaterfrntgrnd,recGrassfrntgrnd, footerBackground, lbl_footer);

        VBox  rootVB = new VBox(rootGRP);
        rootVB.setStyle("-fx-background-image: url(file:///D:/CPP/CS%202450%20UI/PokePics/backdrop2.jpg);" + "-fx-background-size: cover;");


        // Add the rootGRP to a ScrollPane to allow scrolling
        ScrollPane scrollPane = new ScrollPane(rootVB);
        scrollPane.setFitToWidth(true); // Allow the ScrollPane to resize horizontally
        scrollPane.setFitToHeight(true); // Allow the ScrollPane to resize vertically


        scene1 = new Scene(scrollPane, screenSize.getWidth(), screenSize.getHeight());
        scene1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

/*         scene1.widthProperty().addListener((observable, oldValue, newValue) -> {
            // Update button size based on the new width
            bttnHome.setPrefWidth(newValue.doubleValue() / 2);
            homeMenuBarSc2.setPrefWidth(newValue.doubleValue() / 2);

        });
 */




        primaryStage.setTitle("Pokédex APP");
        primaryStage.setScene(scene1);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    //----------------------------------HELPER FUNCTIONS----------------------------------
    private Popup createPopup(String name, String image, String species, String height, String weight, String abilities) {
        // Create a popup
        Popup popup = new Popup();
    
        
        // Create content for the popup
        StackPane popUpBackground = new StackPane();
        VBox popUpContent = new VBox(10);
        popUpContent.setAlignment(Pos.CENTER); // Center the content vertically
        
    
        // Create a background rectangle with a light blue color
        Image pokedexBackground = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\pokedexbg.png");
        Rectangle background = new Rectangle(600, 650); // Set the desired width and height
        Rectangle blackBorder = new Rectangle(610, 660);
        blackBorder.setFill(Color.BLACK);
        background.setFill(new ImagePattern(pokedexBackground));
    
        
        // Create an ImageView with a specific size
        ImageView popUpImageView = new ImageView("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\" + image + ".png");
        popUpImageView.setFitWidth(400);  // Set the desired width
        popUpImageView.setFitHeight(400); // Set the desired height
        
        popUpContent.getChildren().addAll(
            new Button("Exit"),
            createStyledLabel(name, 30, FontWeight.BOLD, Color.BLACK),
            popUpImageView,
            createStyledLabel("Species: " + species, 19, FontWeight.NORMAL, Color.WHITE),
            createStyledLabel("Height: " + height, 19, FontWeight.NORMAL, Color.WHITE),
            createStyledLabel("Weight: " + weight, 19, FontWeight.NORMAL, Color.WHITE),
            createStyledLabel("Abilities: " + abilities, 19, FontWeight.NORMAL, Color.WHITE)
    );
        popUpBackground.getChildren().addAll(blackBorder, background, popUpContent);
    
        // Set action on button click to close the popup
        Button exitButton = (Button) popUpContent.getChildren().get(0); // Adjust the index based on your content
        exitButton.getStyleClass().add("bttn-label");
        exitButton.setOnAction(event -> popup.hide());
    
        popup.getContent().add(popUpBackground);
    
        return popup;
    }

    private Label createStyledLabel(String text, double fontSize, FontWeight fontWeight, Color textColor) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", fontWeight, fontSize));
        label.setTextFill(textColor);
        return label;
    }

    private void addCard(String titleTxt, String infoTxt, String imagePath) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200); // Set the width of the image
        imageView.setFitHeight(250); // Set the height of the image

        // Create a card with an image and text
        Card card = new Card(titleTxt, infoTxt, imageView);

        cardContainer.getChildren().add(card);
    }

    private void scrollLeft() {
        if (!cardContainer.getChildren().isEmpty()) {
            currentIndex = (currentIndex - 1 + cardContainer.getChildren().size()) % cardContainer.getChildren().size();
            cardContainer.getChildren().get(currentIndex).toFront();
        }
    }

    private void scrollRight() {
        if (!cardContainer.getChildren().isEmpty()) {
            currentIndex = (currentIndex + 1) % cardContainer.getChildren().size();
            cardContainer.getChildren().get(currentIndex).toFront();
        }
    }

    public static class Card extends HBox {
        public Card(String titleTxt, String infoTxt, ImageView imageView) {
            Text labelText = new Text(titleTxt);
            Text labelText2 = new Text(infoTxt);

            // Set the alignment of the label to the bottom center
            labelText.setStyle("-fx-fill: White; -fx-font-size: 18px; -fx-font-weight: bold;"); // Set the text color
            labelText2.setStyle("-fx-fill: White; -fx-font-size: 12px; -fx-font-weight: thin;"); // Set the text color

            StackPane txStackPane = new StackPane(labelText);
            txStackPane.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
            txStackPane.setAlignment(Pos.CENTER_LEFT);
            txStackPane.setPadding(new Insets(0,0,0,8));

            StackPane infoStackPane = new StackPane(labelText2);
            infoStackPane.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
            infoStackPane.setAlignment(Pos.CENTER_LEFT);
            infoStackPane.setPadding(new Insets(0,0,0,8));

            // Create a VBox to hold the image and label
            VBox cardContent = new VBox(0, imageView, txStackPane,infoStackPane);
            cardContent.setAlignment(Pos.BOTTOM_CENTER);

            getChildren().addAll(cardContent);
            setStyle("-fx-border-color: black;"); // Optional: Add a border to the card
        }
    }

}
