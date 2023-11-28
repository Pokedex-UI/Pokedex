package com.pokemon;

import java.io.IOException;
import java.net.URI;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    private HBox cardContainer;
    private int currentIndex = 0;
    private Scene scene1, scene2, scene3;
    private Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 75);
    private Font biggerFont = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 130);
    private Font missionHeaderFont = Font.font("SERIF", FontWeight.BOLD, FontPosture.REGULAR, 32);
    private Font biggerFont2 = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 32);
    private Font smallerFont =  Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 14);
    private Font slightlyBiggerFont =  Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22);
    private Font slightlyBiggerFont2 =  Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 32);

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

        // Text - Welcome to the Pokemon Database!
        Text txtMissionHeader = new Text("Welcome to the Pokemon Database!");
        txtMissionHeader.setFont(missionHeaderFont);
        txtMissionHeader.setTextAlignment(TextAlignment.CENTER);

        // Text below header
        Text txtMissionBody = new Text("The world of Pokemon is vast, and we believe in making Pokémon information as clear and easy to digest as possible.\n" +
                                       "On this page you will find general information about the basic types of Pokemon and see featured Pokemon as well.\n"+
                                       "Use the menu above to get detailed Pokedex entries on information about evolution lines, abilities, and much more!");

        txtMissionBody.setFont(slightlyBiggerFont);
        txtMissionBody.setTextAlignment(TextAlignment.CENTER);

        // Create two separate vboxes to hold the text objects
        VBox vb_topHeader = new VBox(txtMissionHeader);
        vb_topHeader.setAlignment(Pos.CENTER);
        vb_topHeader.setPadding(new Insets(0, 0, 20, 0));

        VBox vb_bottomHeader = new VBox(txtMissionBody);
        vb_bottomHeader.setAlignment(Pos.CENTER);

        // VBox to hold separate ones
        VBox vb_missionStatement = new VBox(vb_topHeader, vb_bottomHeader);

        // This is required to keep everything in the middle
        Rectangle rectBackdrop = new Rectangle(0, 30, screenSize.getWidth(), 175);
        rectBackdrop.setFill(Color.TRANSPARENT);

        // Put everything together in a StackPane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectBackdrop, vb_missionStatement);

        // HBox to put everything together
        HBox hb_missionStatement = new HBox(stackPane);
        hb_missionStatement.setPadding(new Insets(30, 0, 0, 0));

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
        hb_featuredPokemonBanner.setPadding(new Insets(25, 0, 0, 0));

        // 5. END FEATURED POKEMON BANNER
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 6. BEGIN SCROLLPANE

        // Initialize cardContainer with spacing between cards
        cardContainer = new HBox(0);

        // Add your cards (rectangles with images and text) to the cardContainer
        // addCard method at bottom of code
        addCard("\nCharizard - 006","Generation 1\nEvolves from:\nCharmeleon\nCharmander\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\charizard.png");
        addCard("\nTyphlosion - 157","Generation 2\nEvolves from:\nQuilava\nCyndaquil\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\typhlosion.png");
        addCard("\nBlaziken - 257","Generation 3\nEvolves from:\nCombusken\nTorchic\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\blaziken.png");
        addCard("\nBlastoise - 009","Generation 1\nEvolves from:\nWartotle\nSquirtle\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\blastoise.png");
        addCard("\nFeraligatr - 260","Generation 2\nEvolves from:\nCroconaw\nTotodile\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\feraligatr.png");
        addCard("\nSwampert - 637","Generation 3\nEvolves from:\nMarshtomp\nMudkip\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\swampert.png");
        addCard("\nVenusaur - 003","Generation 1\nEvolves from:\nIvysaur\nBulbasaur\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\venusaur.png");
        addCard("\nMeganium - 154","Generation 2\nEvolves from:\nBayleef\nChikorita\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\meganium.png");
        addCard("\nSceptile - 254","Generation 3\nEvolves from:\nGrovyle\nTreecko\n", "file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\sceptile.png");

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
        HBox hb_footer = createFooter();
        // 7. END FOOTER
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

        recFirefrntgrnd.setOnMouseClicked(event ->
        {
            primaryStage.setScene(scene2);
        });

        // Scene 2 (Pokedex)
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Two charizard images on the header
        Image dbTitleImg1Fire = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle11.png");
        Image dbTitleImg2Fire = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle22.png");

        // ImageViews to show charizard images
        ImageView imageView1Fire = new ImageView(dbTitleImg1Fire);
        imageView1Fire.setFitWidth(140);
        imageView1Fire.setFitHeight(100);
        imageView1Fire.getStyleClass().add("shadow-label");
        ImageView imageView2Fire = new ImageView(dbTitleImg2Fire);
        imageView2Fire.setFitWidth(140);
        imageView2Fire.setFitHeight(100);
        imageView2Fire.getStyleClass().add("shadow-label");

        // Header code
        Label lbl_dbTitleSc2 = new Label("Pokédex Database");
        lbl_dbTitleSc2.getStyleClass().add("title-label");

        HBox hb_homeTitleSc2 = new HBox(40,imageView1Fire, lbl_dbTitleSc2,imageView2Fire);
        hb_homeTitleSc2.getStyleClass().add("hbox-with-gradient");
        hb_homeTitleSc2.setAlignment(Pos.CENTER);

        //// Menubar code
        // Home Button
        Button bttnHomeSc2 = new Button("Home");
        bttnHomeSc2.getStyleClass().add("bttn-label2");
        bttnHomeSc2.setPrefWidth(screenSize.getWidth()/2);


        // Pokedex menu items
        Menu pokedexMenuSc2 = new Menu("                                          Pokédex");
        MenuItem fireItemSc2 = new MenuItem("Fire Pokédex");
        MenuItem waterItemSc2 = new MenuItem("Water Pokédex");
        MenuItem grassItemSc2 = new MenuItem("Grass Pokédex");
        pokedexMenuSc2.getItems().addAll(fireItemSc2,waterItemSc2,grassItemSc2);

        // Pokedex menu styling
        MenuBar homeMenuBarSc2 = new MenuBar();
        homeMenuBarSc2.getMenus().addAll(pokedexMenuSc2);
        homeMenuBarSc2.getStyleClass().add("bttn-label");
        homeMenuBarSc2.setPrefWidth((screenSize.getWidth())/2);


        HBox hb_hometaskbarSc2 = new HBox(bttnHomeSc2,homeMenuBarSc2);
        hb_hometaskbarSc2.setAlignment(Pos.CENTER);
        hb_hometaskbarSc2.setPadding(new Insets(0,0,20,0));

        // Home button functionality
        bttnHomeSc2.setOnAction(event ->
        {
            primaryStage.setScene(scene1);
        });

        // Pokedex Entries

        // Row 1
        Image charmander = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\charmander.png");
        ImageView charmanderImageView = new ImageView(charmander);
        charmanderImageView.setPreserveRatio(true);
        charmanderImageView.setFitWidth(175);
        charmanderImageView.getStyleClass().add("fire-images");

        Image charmeleon = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\charmeleon.png");
        ImageView charmeleonImageView = new ImageView(charmeleon);
        charmeleonImageView.setPreserveRatio(true);
        charmeleonImageView.setFitWidth(175);
        charmeleonImageView.getStyleClass().add("fire-images");


        Image charizard = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\charizard.png");
        ImageView charizardImageView = new ImageView(charizard);
        charizardImageView.setPreserveRatio(true);
        charizardImageView.setFitWidth(225);
        charizardImageView.getStyleClass().add("fire-images");


        /*
            Labels and VBoxes
        */
        Label charmanderLabel = new Label("Charmander");
        charmanderLabel.setFont(slightlyBiggerFont2);
        Label charmanderGen = new Label("Generation 1");
        VBox charmanderVBox = new VBox(charmanderLabel, charmanderGen);
        charmanderVBox.setAlignment(Pos.CENTER);


        Label charmeleonLabel = new Label("Charmeleon");
        charmeleonLabel.setFont(slightlyBiggerFont2);
        Label charmeleonGen = new Label("Generation 3");
        VBox charmeleonVBox = new VBox(charmeleonLabel, charmeleonGen);
        charmeleonVBox.setAlignment(Pos.CENTER);
        // charmeleonLabel.getStyleClass().add("pokedex-text");


        Label charizardLabel = new Label("Charizard");
        charizardLabel.setFont(slightlyBiggerFont2);
        Label charizardGen = new Label("Generation 3");
        VBox charizardVBox = new VBox(charizardLabel, charizardGen);
        charizardVBox.setAlignment(Pos.CENTER);
        // charizardLabel.getStyleClass().add("pokedex-text");


        /*
            Hbox rows
        */
        HBox pokedexRow1 = new HBox(280, charmanderVBox, charmeleonVBox, charizardVBox);
        pokedexRow1.setAlignment(Pos.CENTER);

        HBox sc2Row1 = new HBox(245, charmanderImageView, charmeleonImageView, charizardImageView);
        sc2Row1.setAlignment(Pos.CENTER);

        // Row 2
        /*
            Images and ImageViews
        */
        Image cyndaquil = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\cyndaquil.png");
        ImageView cyndaquilImageView = new ImageView(cyndaquil);
        cyndaquilImageView.setPreserveRatio(true);
        cyndaquilImageView.setFitWidth(225);
        cyndaquilImageView.getStyleClass().add("fire-images");

        Image quilava = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\quilava.png");
        ImageView quilavaImageView = new ImageView(quilava);
        quilavaImageView.setPreserveRatio(true);
        quilavaImageView.setFitWidth(175);
        quilavaImageView.getStyleClass().add("fire-images");

        Image typhlosion = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\typhlosion.png");
        ImageView typhlosionImageView = new ImageView(typhlosion);
        typhlosionImageView.setPreserveRatio(true);
        typhlosionImageView.setFitWidth(175);
        typhlosionImageView.getStyleClass().add("fire-images");

        /*
            Labels and VBoxes
        */
        Label cyndaquilLabel = new Label("Cyndaquil");
        cyndaquilLabel.setFont(slightlyBiggerFont2);
        Label cyndaquilGen = new Label("Generation 2");
        VBox cyndaquilVBox = new VBox(cyndaquilLabel, cyndaquilGen);
        cyndaquilVBox.setAlignment(Pos.CENTER);

        Label quilavaLabel = new Label("Quilava");
        quilavaLabel.setFont(slightlyBiggerFont2);
        Label quilavaGen = new Label("Generation 2");
        VBox quilavaVBox = new VBox(quilavaLabel, quilavaGen);
        quilavaVBox.setAlignment(Pos.CENTER);

        Label typhlosionLabel = new Label("Typhlosion");
        typhlosionLabel.setFont(slightlyBiggerFont2);
        Label typhlosionGen = new Label("Generation 2");
        VBox typhlosionVBox = new VBox(typhlosionLabel, typhlosionGen);
        typhlosionVBox.setAlignment(Pos.CENTER);

        /*
            Hbox rows
        */
        HBox pokedexRow2 = new HBox(330, cyndaquilVBox, quilavaVBox, typhlosionVBox);
        pokedexRow2.setAlignment(Pos.CENTER);

        HBox sc2Row2 = new HBox(260, cyndaquilImageView, quilavaImageView, typhlosionImageView);
        sc2Row2.setAlignment(Pos.CENTER);

        /*
            Labels and VBoxes
        */
        Label torchicLabel = new Label("Torchic");
        torchicLabel.setFont(slightlyBiggerFont2);
        Label torchicGen = new Label("Generation 3");
        VBox torchicVBox = new VBox(torchicLabel, torchicGen);
        torchicVBox.setAlignment(Pos.CENTER);

        Label combuskenLabel = new Label("Combusken");
        combuskenLabel.setFont(slightlyBiggerFont2);
        Label combuskenGen = new Label("Generation 3");
        VBox combuskenVBox = new VBox(combuskenLabel, combuskenGen);
        combuskenVBox.setAlignment(Pos.CENTER);

        Label blazikenLabel = new Label("Blaziken");
        blazikenLabel.setFont(slightlyBiggerFont2);
        Label blazikenGen = new Label("Generation 3");
        VBox blazikenVBox = new VBox(blazikenLabel, blazikenGen);
        blazikenVBox.setAlignment(Pos.CENTER);

        // Row 3
        Image torchic = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\torchic.png");
        ImageView torchicImageView = new ImageView(torchic);
        torchicImageView.setPreserveRatio(true);
        torchicImageView.setFitWidth(175);
        torchicImageView.getStyleClass().add("fire-images");

        Image combusken = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\combusken.png");
        ImageView combuskenImageView = new ImageView(combusken);
        combuskenImageView.setPreserveRatio(true);
        combuskenImageView.setFitWidth(225);
        combuskenImageView.getStyleClass().add("fire-images");

        Image blaziken = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\blaziken.png");
        ImageView blazikenImageView = new ImageView(blaziken);
        blazikenImageView.setPreserveRatio(true);
        blazikenImageView.setFitWidth(175);
        blazikenImageView.getStyleClass().add("fire-images");

        /*
            Hbox rows
        */
        HBox pokedexRow3 = new HBox(330, torchicVBox, combuskenVBox, blazikenVBox);
        pokedexRow3.setAlignment(Pos.CENTER);

        HBox sc2Row3 = new HBox(250, torchicImageView, combuskenImageView, blazikenImageView);
        sc2Row3.setAlignment(Pos.CENTER);

        // VBox that puts the pokedex together
        VBox pokedexVbox = new VBox(50,sc2Row1, pokedexRow1, sc2Row2, pokedexRow2, sc2Row3, pokedexRow3);
        pokedexVbox.setPadding(new Insets(40,0,40,0));

////////////////////////////////////////////////////////////////////////////////////////
    //FIRE FOOTER START
////////////////////////////////////////////////////////////////////////////////////////
        /*
            Footer:
            Changed lbl_footer to lbl_footerFire (Fire Pokedex page)
            Changed footerBackground to footerBackgroundFire (Fire Pokedex page)
         */
        HBox hb_footerF = createFooter();
////////////////////////////////////////////////////////////////////////////////////////
    //FIRE FOOTER END
////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // VBox that puts everything together
        VBox layout2 = new VBox(hb_homeTitleSc2, hb_hometaskbarSc2, pokedexVbox, hb_footerF);
        layout2.setStyle("-fx-background-color: white");

        // (OPTIONAL) ADD THE BACKGROUND TO THE FIRE SCENE2
        layout2.setStyle("-fx-background-image: url(file:./pokedex/src/main/java/com/resources/Abanob/backdrop2.jpg);" + "-fx-background-size: cover;");


        // Add the rootGRP to a ScrollPane to allow scrolling
        ScrollPane fireScrollPane = new ScrollPane(layout2);
        fireScrollPane.setFitToWidth(true); // Allow the ScrollPane to resize horizontally
        fireScrollPane.setFitToHeight(true); // Allow the ScrollPane to resize vertically

        scene2 = new Scene(fireScrollPane, screenSize.getWidth(), screenSize.getHeight());
        scene2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //POKEDEX POPUPS

        //CREATES ALL POPUPS, REFRENCE THIS FOR PARAMETERS
        //INSERT POKEMON POPUPS HERE
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

        Popup cyndaquilPopup = createPopup(cyndaquilLabel.getText(),cyndaquilLabel.getText(), "Fire Mouse Pokémon", "0.5m", "17.4lbs", "Blaze");
        cyndaquilImageView.setOnMouseClicked(event -> {
            cyndaquilPopup.show(cyndaquilImageView.getScene().getWindow());
        });

        Popup quilavaPopup = createPopup(quilavaLabel.getText(),quilavaLabel.getText(), "Volcano Pokémon", "0.9m", "41.9lbs", "Blaze");
        quilavaImageView.setOnMouseClicked(event -> {
            quilavaPopup.show(quilavaImageView.getScene().getWindow());
        });

        Popup typhlosionPopup = createPopup(typhlosionLabel.getText(),typhlosionLabel.getText(), "Volcano Pokémon", "1.7m", "175.3lbs", "Flash Fire");
        typhlosionImageView.setOnMouseClicked(event -> {
            typhlosionPopup.show(typhlosionImageView.getScene().getWindow());
        });

        Popup torchicPopup = createPopup(torchicLabel.getText(),torchicLabel.getText(), "Chick Pokémon", "0.4m", "5.3lbs", "Blaze");
        torchicImageView.setOnMouseClicked(event -> {
            torchicPopup.show(torchicImageView.getScene().getWindow());
        });

        Popup combuskenPopup = createPopup(combuskenLabel.getText(),combuskenLabel.getText(), "Young Fowl Pokémon", "0.9m", "43.3lbs", "Blaze");
        combuskenImageView.setOnMouseClicked(event -> {
            combuskenPopup.show(combuskenImageView.getScene().getWindow());
        });

        Popup blazikenPopup = createPopup(blazikenLabel.getText(),blazikenLabel.getText(), "Blaze Pokémon", "1.9m", "114.3lbs", "Speed Boost");
        blazikenImageView.setOnMouseClicked(event -> {
            blazikenPopup.show(blazikenImageView.getScene().getWindow());
        });
//////////////////////////////////////////
//POKEDEX POPUP END
//////////////////////////////////////////


        // Scene 3 (Pokedex)
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Two charizard images on the header
        Image dbTitleImg1Water = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle11.png");
        Image dbTitleImg2Water = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\dbtitle22.png");

        // ImageViews to show charizard images
        ImageView imageView1Water = new ImageView(dbTitleImg1Water);
        imageView1Water.setFitWidth(140);
        imageView1Water.setFitHeight(100);
        imageView1Water.getStyleClass().add("shadow-label");
        ImageView imageView2Water = new ImageView(dbTitleImg2Water);
        imageView2Water.setFitWidth(140);
        imageView2Water.setFitHeight(100);
        imageView2Water.getStyleClass().add("shadow-label");

        // Header code
        Label lbl_dbTitleSc3 = new Label("Pokédex Database");
        lbl_dbTitleSc3.getStyleClass().add("title-label");

        HBox hb_homeTitleSc3 = new HBox(40,imageView1Fire, lbl_dbTitleSc2,imageView2Fire);
        hb_homeTitleSc3.getStyleClass().add("hbox-with-gradient");
        hb_homeTitleSc3.setAlignment(Pos.CENTER);

        //// Menubar code
        // Home Button
        Button bttnHomeSc3 = new Button("Home");
        bttnHomeSc3.getStyleClass().add("bttn-label2");
        bttnHomeSc3.setPrefWidth(screenSize.getWidth()/2);


        // Pokedex menu items
        Menu pokedexMenuSc3 = new Menu("                                          Pokédex");
        MenuItem fireItemSc3 = new MenuItem("Fire Pokédex");
        MenuItem waterItemSc3 = new MenuItem("Water Pokédex");
        MenuItem grassItemSc3 = new MenuItem("Grass Pokédex");
        pokedexMenuSc3.getItems().addAll(fireItemSc3,waterItemSc3,grassItemSc3);

        // Pokedex menu styling
        MenuBar homeMenuBarSc3 = new MenuBar();
        homeMenuBarSc3.getMenus().addAll(pokedexMenuSc2);
        homeMenuBarSc3.getStyleClass().add("bttn-label");
        homeMenuBarSc3.setPrefWidth((screenSize.getWidth())/2);


        HBox hb_hometaskbarSc3 = new HBox(bttnHomeSc3,homeMenuBarSc3);
        hb_hometaskbarSc3.setAlignment(Pos.CENTER);
        hb_hometaskbarSc3.setPadding(new Insets(0,0,20,0));

        // Home button functionality
        bttnHomeSc3.setOnAction(event ->
        {
            primaryStage.setScene(scene1);
        });

        // Pokedex Entries

        // Row 1
        Image blastoise = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Water Pokemon\\blastoise.jpg");
        ImageView blastoiseImageView = new ImageView(blastoise);
        blastoiseImageView.setPreserveRatio(true);
        blastoiseImageView.setFitWidth(175);
        blastoiseImageView.getStyleClass().add("water-images");

        Image croconaw = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Water Pokemon\\croconaw.jpg");
        ImageView croconawImageView = new ImageView(croconaw);
        croconawImageView.setPreserveRatio(true);
        croconawImageView.setFitWidth(175);
        croconawImageView.getStyleClass().add("water-images");


        Image feraligatr = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Water Pokemon\\feraligatr.jpg");
        ImageView feraligatrImageView = new ImageView(feraligatr);
        feraligatrImageView.setPreserveRatio(true);
        feraligatrImageView.setFitWidth(175);
        feraligatrImageView.getStyleClass().add("water-images");


        /*
            Labels and VBoxes
        */
        Label blastoiseLabel = new Label("Blastoise");
        blastoiseLabel.setFont(slightlyBiggerFont2);
        Label blastoiseGen = new Label("Generation 1");
        VBox blastoiseVBox = new VBox(blastoiseLabel, blastoiseGen);
        blastoiseVBox.setAlignment(Pos.CENTER);


        Label croconawLabel = new Label("Croconaw");
        croconawLabel.setFont(slightlyBiggerFont2);
        Label croconawGen = new Label("Generation 2");
        VBox croconawVBox = new VBox(croconawLabel, croconawGen);
        croconawVBox.setAlignment(Pos.CENTER);
        // charmeleonLabel.getStyleClass().add("pokedex-text");


        Label feraligatrLabel = new Label("Feraligatr");
        feraligatrLabel.setFont(slightlyBiggerFont2);
        Label feraligatrGen = new Label("Generation 2");
        VBox feraligatrVBox = new VBox(feraligatrLabel, feraligatrGen);
        feraligatrVBox.setAlignment(Pos.CENTER);
        // charizardLabel.getStyleClass().add("pokedex-text");


        /*
            Hbox rows
        */
        HBox pokedexWaterRow1 = new HBox(280, blastoiseVBox, croconawVBox, feraligatrVBox);
        pokedexWaterRow1.setAlignment(Pos.CENTER);

        HBox sc3Row1 = new HBox(245, blastoiseImageView, croconawImageView, feraligatrImageView);
        sc3Row1.setAlignment(Pos.CENTER);

        // VBox that puts the pokedex together
        VBox pokedexSc3Vbox = new VBox(50,sc3Row1, pokedexWaterRow1);
        pokedexSc3Vbox.setPadding(new Insets(40,0,40,0));

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // VBox that puts everything together
        VBox layout3 = new VBox(hb_homeTitleSc3, hb_hometaskbarSc3, pokedexSc3Vbox, hb_footerF);
        layout3.setStyle("-fx-background-color: white");

        // (OPTIONAL) ADD THE BACKGROUND TO THE FIRE SCENE2
        layout3.setStyle("-fx-background-image: url(file:./pokedex/src/main/java/com/resources/Abanob/backdrop2.jpg);" + "-fx-background-size: cover;");


        // Add the rootGRP to a ScrollPane to allow scrolling
        ScrollPane waterScrollPane = new ScrollPane(layout3);
        waterScrollPane.setFitToWidth(true); // Allow the ScrollPane to resize horizontally
        waterScrollPane.setFitToHeight(true); // Allow the ScrollPane to resize vertically

        scene3 = new Scene(waterScrollPane, screenSize.getWidth(), screenSize.getHeight());
        scene3.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


        waterItem.setOnAction(event ->
        {
            primaryStage.setScene(scene3);
        });

        recWaterfrntgrnd.setOnMouseClicked(event ->
        {
            primaryStage.setScene(scene3);
        });




        VBox vb_HomePage = new VBox(hb_header, hb_hometaskbar, hb_missionStatement, hb_typeCards, hb_featuredPokemonBanner, hb_scrollPane, hb_footer);
        vb_HomePage.setAlignment(Pos.CENTER);


        vb_HomePage.setStyle("-fx-background-image: url(file:./pokedex/src/main/java/com/resources/Abanob/backdrop2.jpg);" + "-fx-background-size: cover;");

        // Add the rootGRP to a ScrollPane to allow scrolling
        ScrollPane scrollPane = new ScrollPane(vb_HomePage);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setFitToHeight(true); // Allow the ScrollPane to resize vertically

        scene1 = new Scene(scrollPane, screenSize.getWidth(), screenSize.getHeight());
        scene1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Pokédex APP");
        primaryStage.setScene(scene1);
        primaryStage.setMaximized(true);
        primaryStage.show();

    }


    //----------------------------------HELPER FUNCTIONS----------------------------------
    private Popup createPopup(String name, String image, String species, String height, String weight, String abilities) {
        // Create a popup
        Popup popup = new Popup();

        //Popup background is the image background
        //Popup content has the actual images and text
        StackPane popUpBackground = new StackPane();
        VBox popUpContent = new VBox(10);
        popUpContent.setAlignment(Pos.CENTER); // Center the content vertically

        Image pokedexBackground = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\pokedexbg.png");
        Rectangle background = new Rectangle(600, 650);
        Rectangle blackBorder = new Rectangle(610, 660);
        blackBorder.setFill(Color.BLACK);
        background.setFill(new ImagePattern(pokedexBackground));

        ImageView popUpImageView = new ImageView("file:.\\pokedex\\src\\main\\java\\com\\resources\\transparent_pokemon\\" + image + ".png");
        popUpImageView.setFitWidth(400);
        popUpImageView.setFitHeight(400);

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

        // Set up fade-in animation
        popUpBackground.setOpacity(0.0);
        FadeTransition fadeIn = new FadeTransition(Duration.millis(500), popUpBackground);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        // Set action on button click to close the popup
        Button exitButton = (Button) popUpContent.getChildren().get(0); // Adjust the index based on your content
        exitButton.getStyleClass().add("bttn-label");
        exitButton.setOnAction(event -> {
            FadeTransition fadeOut = new FadeTransition(Duration.millis(500), popUpBackground);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(e -> popup.hide());
            fadeOut.play();
        });

        popup.getContent().add(popUpBackground);

        // Play the fade-in animation when the popup is shown
        popup.setOnShown(e -> fadeIn.play());

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
    public HBox createFooter() {
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
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

        // Images and ImageViews
        Image discordImage = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\discord.png");
        ImageView discordImageView = new ImageView(discordImage);
        discordImageView.setPreserveRatio(true);
        discordImageView.setFitWidth(100);
        discordImageView.setLayoutX(1700);
        discordImageView.setLayoutY(1570);

        Image facebookImage = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\facebook.png");
        ImageView facebookImageView = new ImageView(facebookImage);
        facebookImageView.setPreserveRatio(true);
        facebookImageView.setFitWidth(100);
        facebookImageView.setLayoutX(1600);
        facebookImageView.setLayoutY(1575);

        Image linkedinImage = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\linkedin.png");
        ImageView linkedinImageView = new ImageView(linkedinImage);
        linkedinImageView.setPreserveRatio(true);
        linkedinImageView.setFitWidth(100);
        linkedinImageView.setLayoutX(1500);
        linkedinImageView.setLayoutY(1565);

        Image instagramImage = new Image("file:.\\pokedex\\src\\main\\java\\com\\resources\\Abanob\\instagram.png");
        ImageView instagramImageView = new ImageView(instagramImage);
        instagramImageView.setPreserveRatio(true);
        instagramImageView.setFitWidth(90);
        instagramImageView.setLayoutX(1400);
        instagramImageView.setLayoutY(1570);


        // Background for lbl_footer
        Rectangle footerBackground = new Rectangle(0, 1500, screenSize.getWidth(), 200);
        footerBackground.setFill(Color.web("#717e8e"));

        // Put lbl_footer on top of background
        Group footerGroup = new Group(footerBackground, lbl_footerTitle, lbl_footer, lbl_phoneNumber, discordImageView, facebookImageView, linkedinImageView,
            instagramImageView);

        // HBox to put everything together
        HBox hb_footer = new HBox(footerGroup);
        hb_footer.setAlignment(Pos.CENTER);

            instagramImageView.setOnMouseClicked(event -> {
            getHostServices().showDocument("https://www.instagram.com/pokemon/");
        });

        facebookImageView.setOnMouseClicked(event -> {
            getHostServices().showDocument("https://www.facebook.com/Pokemon/");
        });

        linkedinImageView.setOnMouseClicked(event -> {
            getHostServices().showDocument("https://www.linkedin.com/company/pokemon/");
        });

        discordImageView.setOnMouseClicked(event -> {
            getHostServices().showDocument("https://www.discord.com/");
        });
        return hb_footer;
    }

    public static class Card extends HBox {
        public Card(String titleTxt, String infoTxt, ImageView imageView) {
            Text labelText = new Text(titleTxt);
            Text labelText2 = new Text(infoTxt);
            labelText2.setTextAlignment(TextAlignment.CENTER);

            // Set the alignment of the label to the bottom center
            labelText.setStyle("-fx-fill: White; -fx-font-size: 22px; -fx-font-weight: bold;"); // Set the text color
            labelText2.setStyle("-fx-fill: White; -fx-font-size: 18px; -fx-font-weight: normal;"); // Set the text color

            StackPane txStackPane = new StackPane(labelText);
            txStackPane.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
            txStackPane.setAlignment(Pos.CENTER);
            txStackPane.setPadding(new Insets(0,0,0,8));

            StackPane infoStackPane = new StackPane(labelText2);
            infoStackPane.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
            infoStackPane.setAlignment(Pos.BOTTOM_CENTER);
            infoStackPane.setPadding(new Insets(0,0,0,8));

            // Create a VBox to hold the image and label
            VBox cardContent = new VBox(0, imageView, txStackPane,infoStackPane);
            cardContent.setAlignment(Pos.BOTTOM_CENTER);

            getChildren().addAll(cardContent);
            setStyle("-fx-border-color: black;"); // Optional: Add a border to the card
        }
    }

}
