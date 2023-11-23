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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.FileChooser;
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

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {

        Image dbTitleImg1 = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle11.png");
        Image dbTitleImg2 = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle22.png");

      //  Label missionStatement = new Label("mission statement here");

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


        HBox hb_homeTitle = new HBox(40,imageView1,lbl_dbTitle,imageView2);
        hb_homeTitle.getStyleClass().add("hbox-with-gradient");
        hb_homeTitle.setAlignment(Pos.TOP_CENTER);

        Button bttnHome = new Button("Home");
        bttnHome.getStyleClass().add("bttn-label");
        // Button bttnQA = new Button("Pokédex Q&A");
        // bttnQA.getStyleClass().add("bttn-label");
        // Button bttnAbout = new Button("About/Contact US");
        // bttnAbout.getStyleClass().add("bttn-label");

        cardContainer = new HBox(0); // Set the spacing between cards

        // Add your cards (rectangles with images and text) to the cardContainer
        addCard("\nMy Fire Poke\t     637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\fire.png");
        addCard("\nMy Water Poke   637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\firebk.png");
        addCard("\nMy Grass Poke   637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\grass.png");
        addCard("\nMy Koky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle11.png");
        addCard("\nMy Roky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\water.png");


        ScrollPane FeaturePokeScrollPane = new ScrollPane();
        FeaturePokeScrollPane.setContent(cardContainer);
        FeaturePokeScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        FeaturePokeScrollPane.setLayoutY(900);

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

        HBox hb_horizScrollBar_buttons = new HBox(735,leftButton, rightButton);
        hb_horizScrollBar_buttons.setLayoutY(1000);
        hb_horizScrollBar_buttons.setPadding(new Insets(15,0,0,0));

        Image featurePokeImg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\featurepokemon2.png");

        Rectangle recFeaturePoke = new Rectangle(0,690,1000,350);
                recFeaturePoke.setArcWidth(20);
        recFeaturePoke.setArcHeight(20);
        recFeaturePoke.setFill(new ImagePattern(featurePokeImg));

        Menu pokedexMenu = new Menu("Pokédex");
        MenuItem fireItem = new MenuItem("Fire Pokédex");
        MenuItem waterItem = new MenuItem("Water Pokédex");
        MenuItem grassItem = new MenuItem("Grass Pokédex");
        pokedexMenu.getItems().addAll(fireItem,waterItem,grassItem);

        MenuBar homeMenuBar = new MenuBar();
        homeMenuBar.getMenus().addAll(pokedexMenu);
        homeMenuBar.getStyleClass().add("bttn-label");

        HBox hb_hometaskbar = new HBox(565,bttnHome,homeMenuBar);
        hb_hometaskbar.setAlignment(Pos.CENTER);
        hb_hometaskbar.setPadding(new Insets(10,0,20,0));

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

        Image grassImgbg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\grasscard.jpg");
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

        Rectangle recBackgr = new Rectangle();
        recBackgr.setWidth(900);
        recBackgr.setHeight(1500);
        recBackgr.setFill(new ImagePattern(backdrop1));


        // Home- Cards Rectangles
                             // Rectangle(X,Y,Weidth, Height)
        Rectangle recFire = new Rectangle(80,280,230,190);
        recFire.setStroke(Color.BLACK);
        recFire.setArcWidth(20);
        recFire.setArcHeight(20);
        recFire.setFill(new ImagePattern(fireImgbg));

        Rectangle recFireText = new Rectangle(80,460,230,300);
        recFireText.setFill(Color.LIGHTSALMON);
        recFireText.setStroke(Color.LIGHTSALMON);


      Rectangle recFirefrntgrnd= new Rectangle(77,280,238,484);
      recFirefrntgrnd.setFill(new ImagePattern(fireImgfg));
      recFirefrntgrnd.setArcWidth(20);
      recFirefrntgrnd.setArcHeight(20);
      recFirefrntgrnd.setOpacity(0.0);
      recFirefrntgrnd.getStyleClass().add("shadow-label");
      recFirefrntgrnd.setStroke(Color.BLACK);


      Rectangle recWater = new Rectangle(340,280,230,190);
      recWater.setStroke(Color.BLACK);
      recWater.setArcWidth(20);
      recWater.setArcHeight(20);
      recWater.setFill(new ImagePattern(waterImgbg));

      Rectangle recWaterText = new Rectangle(340,460,230,300);
      recWaterText.setFill(Color.LIGHTSKYBLUE);
      recWaterText.setStroke(Color.LIGHTSKYBLUE);

      Rectangle recWaterfrntgrnd= new Rectangle(337,280,238,484);
      recWaterfrntgrnd.setFill(new ImagePattern(waterImgfg));
      recWaterfrntgrnd.setArcWidth(20);
      recWaterfrntgrnd.setArcHeight(20);
      recWaterfrntgrnd.setOpacity(0.0);
      recWaterfrntgrnd.getStyleClass().add("shadow2-label");
      recWaterfrntgrnd.setStroke(Color.BLACK);


        Rectangle recGrass = new Rectangle(600,280,230,190);
        recGrass.setStroke(Color.BLACK);
        recGrass.setArcWidth(20);
        recGrass.setArcHeight(20);
        recGrass.setFill(new ImagePattern(grassImgbg));

        Rectangle recGrassText = new Rectangle(600,460,230,300);
        recGrassText.setFill(Color.LIGHTGREEN);
        recGrassText.setStroke(Color.LIGHTGREEN);

        Rectangle recGrassfrntgrnd= new Rectangle(600,280,238,484);
        recGrassfrntgrnd.setFill(new ImagePattern(grassImgfg));
        recGrassfrntgrnd.setArcWidth(20);
        recGrassfrntgrnd.setArcHeight(20);
        recGrassfrntgrnd.setOpacity(0.0);
        recGrassfrntgrnd.getStyleClass().add("shadow3-label");
        recGrassfrntgrnd.setStroke(Color.BLACK);

        // Home- Cards Text
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 75);

        Font biggerFont = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 130);

        Font missionHeaderFont = Font.font("SERIF", FontWeight.BOLD, FontPosture.REGULAR, 24);

        Font biggerFont2 = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 32);

        Font smallerFont =  Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 14);

        Text txtMissionHeader = new Text("Bringing the world together through Pokémon");
        txtMissionHeader.setFont(missionHeaderFont);
        txtMissionHeader.setX(175);
        txtMissionHeader.setY(130);

        Text txtMissionBody = new Text("The world of Pokémon connects people across the globe,beloved by kids, adults, \nand every Trainer in between! These incredible creatures have crossed \nborders and language barriers to reach the hearts of millions for over 25 years, \nbringing people together through the joy of play and discovery.");
        txtMissionBody.setFont(smallerFont);
        txtMissionBody.setX(175);
        txtMissionBody.setY(150);


        Text txtFireTitle =new Text(85,520,"Add Title Here");
        txtFireTitle.setFont(biggerFont2);

        Text txtFireDescrip =new Text(85,560,"Add here some text...");
        txtFireDescrip.setFont(smallerFont);

        Text txtWaterTitle =new Text(344,520,"Add Title Here");
        txtWaterTitle.setFont(biggerFont2);

        Text txtWaterDescrip =new Text(344,560,"Add here some text...");
        txtWaterDescrip.setFont(smallerFont);

        Text txtGrassTitle =new Text(605,520,"Add Title Here");
        txtGrassTitle.setFont(biggerFont2);

        Text txtGrassDescrip =new Text(605,560,"Add here some text...");
        txtGrassDescrip.setFont(smallerFont);

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

        FadeTransition fadeInWater = new FadeTransition(Duration.millis(200), recWaterfrntgrnd);
        fadeInWater.setFromValue(0.0);
        fadeInWater.setToValue(1.0);

        FadeTransition fadeInGrass = new FadeTransition(Duration.millis(200), recGrassfrntgrnd);
        fadeInGrass.setFromValue(0.0);
        fadeInGrass.setToValue(1.0);

        FadeTransition fadeOutFire = new FadeTransition(Duration.millis(100), recFirefrntgrnd);
        fadeOutFire.setFromValue(1.0);
        fadeOutFire.setToValue(0.0);

        FadeTransition fadeOutWater = new FadeTransition(Duration.millis(100), recWaterfrntgrnd);
        fadeOutWater.setFromValue(1.0);
        fadeOutWater.setToValue(0.0);

        FadeTransition fadeOutGrass = new FadeTransition(Duration.millis(100), recGrassfrntgrnd);
        fadeOutGrass.setFromValue(1.0);
        fadeOutGrass.setToValue(0.0);

        // Home- 3 Cards Events
         recFirefrntgrnd.setOnMouseEntered(event -> {
            fadeInFire.playFromStart();
        });

        recFirefrntgrnd.setOnMouseExited(event -> {
            fadeOutFire.playFromStart();
        });

         recWaterfrntgrnd.setOnMouseEntered(event -> {
                fadeInWater.playFromStart();
        });

        recWaterfrntgrnd.setOnMouseExited(event -> {
                fadeOutWater.playFromStart();
        });

        recGrassfrntgrnd.setOnMouseEntered(event -> {
                fadeInGrass.playFromStart();
        });

        recGrassfrntgrnd.setOnMouseExited(event -> {
                fadeOutGrass.playFromStart();
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

        VBox rootVB = new VBox(hb_homeTitle,hb_hometaskbar);

        Group rootGRP = new Group(recBackgr,FeaturePokeScrollPane,recFeaturePoke, hb_horizScrollBar_buttons,txtMissionHeader,txtMissionBody,rootVB,recFire ,recFireText, recWater,recWaterText,recGrass,recGrassText,
        txtFireDescrip,txtFireTitle,txtWaterDescrip,txtWaterTitle, txtGrassTitle,txtGrassDescrip,recFirefrntgrnd,recWaterfrntgrnd,recGrassfrntgrnd);
/*
        Group rootGRP = new Group(rootVB,
        recFire , recWater,recGrass, txtFire,txtWater,txtGrass, imageViewFire, imageViewWater, imageViewGrass);
        rootGRP.setStyle("-fx-background-color: #e0dede;");
 */
        // Add the rootGRP to a ScrollPane to allow scrolling
        ScrollPane scrollPane = new ScrollPane(rootGRP);
   //     scrollPane.setFitToWidth(true); // Allow the ScrollPane to resize horizontally
        scrollPane.setFitToHeight(true); // Allow the ScrollPane to resize vertically

        Scene scene = new Scene(scrollPane, 910, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Pokédex APP");
        primaryStage.setScene(scene);
        primaryStage.show();
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
