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
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
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
    private Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 75);
    private Font biggerFont = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 130);
    private Font missionHeaderFont = Font.font("SERIF", FontWeight.BOLD, FontPosture.REGULAR, 32);
    private Font biggerFont2 = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 32);
    private Font smallerFont =  Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 14);
    private Font slightlyBiggerFont =  Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22);

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {

        /* TABLE OF CONTENTS FOR HOME PAGE:
         * 1. Header
         * 2. Menubar
         * 3. Mission Statement
         * 4. 3 Pokemon Type Cards
         * 5. Featured Pokemon Banner
         * 6. ScrollPane
         * 7. Footer
        */

        // get screensize of monitor
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        double centerPos = screenSize.getWidth()/4;

        System.out.println("---------Center POsistion is:" +centerPos);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 1. BEGIN HEADER

        // Two charizard images on the header
        Image dbTitleImg1 = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle11.png");
        Image dbTitleImg2 = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle22.png");

        // ImageViews to show charizard images
        ImageView imageView1 = new ImageView(dbTitleImg1);
        imageView1.setFitWidth(140);
        imageView1.setFitHeight(100);
        imageView1.getStyleClass().add("shadow-label");
        ImageView imageView2 = new ImageView(dbTitleImg2);
        imageView2.setFitWidth(140);
        imageView2.setFitHeight(100);
        imageView2.getStyleClass().add("shadow-label");

        // Label with header title
        Label lbl_dbTitle = new Label("Pokédex Database");
        lbl_dbTitle.getStyleClass().add("title-label");

        // HBox to put everything together
        HBox hb_header = new HBox(40,imageView1,lbl_dbTitle,imageView2);
        hb_header.getStyleClass().add("hbox-with-gradient");
        hb_header.setAlignment(Pos.TOP_CENTER);

        // 1. END HEADER
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 2. BEGIN MENUBAR

        // Home button
        Button bttnHome = new Button("Home");
        bttnHome.getStyleClass().add("bttn-label2");
        bttnHome.setPrefWidth(screenSize.getWidth()/2);

        // Pokedex button menu
        Menu pokedexMenu = new Menu("                                          Pokédex");
        MenuItem fireItem = new MenuItem("Fire Pokédex");
        MenuItem waterItem = new MenuItem("Water Pokédex");
        MenuItem grassItem = new MenuItem("Grass Pokédex");
        pokedexMenu.getStyleClass().add("menu");
        pokedexMenu.getItems().addAll(fireItem,waterItem,grassItem);

        // Initialize menuBar
        MenuBar homeMenuBar = new MenuBar();
        homeMenuBar.getMenus().addAll(pokedexMenu);
        homeMenuBar.getStyleClass().add("bttn-label");
        homeMenuBar.setPrefWidth((screenSize.getWidth())/2);

        // HBox to put everything together
        HBox hb_hometaskbar = new HBox(bttnHome,homeMenuBar);
        hb_hometaskbar.setAlignment(Pos.CENTER);
        hb_hometaskbar.setPadding(new Insets(0,0,0,0));

        // 2. END MENUBAR
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 3. BEGIN MISSION STATEMENT        

        Text txtMissionHeader = new Text("Welcome to the Pokemon Database!");
        txtMissionHeader.setFont(missionHeaderFont);

        Text txtMissionBody = new Text("The world of Pokémon connects people across the globe,beloved by kids, adults, \nand every Trainer in between! These incredible creatures have crossed \nborders and language barriers to reach the hearts of millions for over 25 years, \nbringing people together through the joy of play and discovery. We aim to delight \nour fans through excellentproducts and meaningful experiences.\n We hope to help make thew rold a better place for everyone by creating opportunities\n to bond and to grow through shared journeys and friendly competition!");
        txtMissionBody.setFont(slightlyBiggerFont);

        VBox vb_welcome = new VBox(10, txtMissionHeader,txtMissionBody);
        vb_welcome.setAlignment(Pos.CENTER);
        vb_welcome.setPadding(new Insets(50,0,50,screenSize.getWidth()/3));

        // HBox to put everything together
        HBox hb_missionStatement = new HBox(vb_welcome);
        hb_missionStatement.setAlignment(Pos.CENTER_LEFT);

        // 3. END MISSION STATEMENT
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 4. BEGIN 3 POKEMON TYPE CARDS      

        // Initialize Card images
        Image fireImgbg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\firecard2copy.jpg");
        Image fireImgfg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\firecardcopy2.jpg");

        Image waterImgbg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\watercard.jpg");
        Image waterImgfg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\watercard2.jpg");

        Image grassImgbg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\sceptile.jpg");
        Image grassImgfg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\grasscard2.jpg");

        Image backdrop1 = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\backdrop2.jpg");

        // Initialize Card rectangles
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
        
        Group rootGRP = new Group(recFire ,recFireText, recWater,recWaterText,recGrass,recGrassText,
        txtFireDescrip,txtFireTitle,txtWaterDescrip,txtWaterTitle, txtGrassTitle,txtGrassDescrip,recFirefrntgrnd,recWaterfrntgrnd,recGrassfrntgrnd);  

        HBox hb_typeCards = new HBox(rootGRP);
        hb_typeCards.setAlignment(Pos.CENTER);

        // 4. END 3 POKEMON TYPE CARDS
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 5. BEGIN FEATURED POKEMON BANNER

        Image featurePokeImg = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\featurepokemon2.png");

        ImageView featureBanner = new ImageView(featurePokeImg);
        featureBanner.setPreserveRatio(true);
        featureBanner.setFitWidth(1000);
        featureBanner.setFitHeight(350);
        Rectangle recFeaturePoke = new Rectangle(0,0,1000,350);
        recFeaturePoke.setArcWidth(20);
        recFeaturePoke.setArcHeight(20);
        recFeaturePoke.setFill(new ImagePattern(featurePokeImg));
        recFeaturePoke.setLayoutX(centerPos-100);

        // HBox to put everything together
        HBox hb_featuredPokemonBanner = new HBox(featureBanner);
        hb_featuredPokemonBanner.setAlignment(Pos.BASELINE_CENTER);
        // hb_featuredPokemonBanner.setPadding(new Insets(300, 0, 0, 0));

        // 5. END FEATURED POKEMON BANNER
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 6. BEGIN SCROLLPANE

        // Initialize cardContainer with spacing between cards
        cardContainer = new HBox(0);

        // Add your cards (rectangles with images and text) to the cardContainer
        // addCard method at bottom of code
        addCard("\nMy Fire Poke\t     637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\fire.png");
        addCard("\nMy Water Poke   637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\firebk.png");
        addCard("\nMy Grass Poke   637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\grass.png");
        addCard("\nMy Roky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\water.png");
        addCard("\nMy Roky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\water.png");
        addCard("\nMy Roky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\water.png");
        addCard("\nMy Roky Poke    637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\water.png");
        addCard("\nMy Fire Poke\t     637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\fire.png");
        addCard("\nMy Water Poke   637","\n\nType:\t\t  Fire\nAbilities:\t\t  Flame Body\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\firebk.png");

        // Feature pokemon functionality
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

        HBox hb_horizScrollBar_buttons = new HBox(1670,leftButton, rightButton);//--------------------------------------NOTE: You may need to change the 1550px scpace between buttons
        hb_horizScrollBar_buttons.setLayoutY(1200);

        // Put ScrollPane and Scroll bar buttons in group together
        Group scrollPaneGroup = new Group(FeaturePokeScrollPane, hb_horizScrollBar_buttons);

        // HBox to put everything together
        HBox hb_scrollPane = new HBox(scrollPaneGroup);
        hb_scrollPane.setAlignment(Pos.TOP_CENTER);
        hb_scrollPane.setPadding(new Insets(25, 0, 75, 0));

        // 6. END SCROLLPANE
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 7. BEGIN FOOTER

        // Labels with general information
        Label lbl_footerTitle = new Label("Pokédex Database");
        lbl_footerTitle.setLayoutX(100);
        lbl_footerTitle.setLayoutY(1530);
        lbl_footerTitle.getStyleClass().add("footer-title-text");

        Label lbl_footer  = new Label("All content & design ©AbaJEthan licensed under Devika Maini CS2450");
        lbl_footer.setLayoutX(100);
        lbl_footer.setLayoutY(1600);
        lbl_footer.getStyleClass().add("footer-text");

        Label lbl_phoneNumber = new Label("123-456-7890 | support@pokedexdatabase.com | @ 2023 Pokédex Database");
        lbl_phoneNumber.setLayoutX(100);
        lbl_phoneNumber.setLayoutY(1630);
        lbl_phoneNumber.getStyleClass().add("footer-text");


        // Background for lbl_footer
        Rectangle footerBackground = new Rectangle(0, 1500, screenSize.getWidth(), 200);
        footerBackground.setFill(Color.web("#717e8e"));

        // Put lbl_footer on top of background
        Group footerGroup = new Group(footerBackground, lbl_footerTitle, lbl_footer, lbl_phoneNumber);

        // HBox to put everything together
        HBox hb_footer = new HBox(footerGroup);
        hb_footer.setAlignment(Pos.CENTER);

        // 7. END FOOTER
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        VBox vb_HomePage = new VBox(hb_header, hb_hometaskbar, hb_missionStatement, hb_typeCards, hb_featuredPokemonBanner, hb_scrollPane, hb_footer);
        vb_HomePage.setAlignment(Pos.CENTER);

        Image image = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\water.png");
        ImageView imgview = new ImageView(image);

        BackgroundImage bckimg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background background = new Background(bckimg);;

        vb_HomePage.setStyle("-fx-background-image: url(file:///C:/Users/Josh/Documents/School/CS%202450/FinalProject/Pokedex/pokedex/src/main/java/com/resources/Abanob/backdrop2.jpg);" + "-fx-background-size: cover;");

        // Add the rootGRP to a ScrollPane to allow scrolling
        ScrollPane scrollPane = new ScrollPane(vb_HomePage);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setFitToHeight(true); // Allow the ScrollPane to resize vertically
        scrollPane.setBackground(background);

        scene1 = new Scene(scrollPane, screenSize.getWidth(), screenSize.getHeight());
        scene1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Pokédex APP");
        primaryStage.setScene(scene1);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    //----------------------------------HELPER FUNCTIONS----------------------------------
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
