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
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
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
public class App2 extends Application {
    public static void main(String[] args) {
        launch();
    }

    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws IOException {

        // Header code
        Image dbTitleImg1 = new Image("file:///D:/CPP/CS 2450 UI/PokePics/dbtitle11.png");
        Image dbTitleImg2 = new Image("file:///D:/CPP/CS 2450 UI/PokePics/dbtitle22.png");

        Label missionStatement = new Label("mission statement here");

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
        hb_homeTitle.setAlignment(Pos.CENTER);

        // Home Button
        Button bttnHome = new Button("Home");
        bttnHome.getStyleClass().add("bttn-label");
        bttnHome.setMinWidth(130); // Adjust the value as needed


        // Pokedex menu items
        Menu pokedexMenu = new Menu("Pokédex");
        MenuItem fireItem = new MenuItem("Fire Pokédex");
        MenuItem waterItem = new MenuItem("Water Pokédex");
        MenuItem grassItem = new MenuItem("Grass Pokédex");
        pokedexMenu.getItems().addAll(fireItem,waterItem,grassItem);

        // Pokedex menu styling
        MenuBar homeMenuBar = new MenuBar();
        homeMenuBar.getMenus().addAll(pokedexMenu);
        homeMenuBar.getStyleClass().add("bttn-label");

        HBox hb_hometaskbar = new HBox(560,bttnHome,homeMenuBar);
        hb_hometaskbar.setAlignment(Pos.CENTER);
        hb_hometaskbar.setPadding(new Insets(10,0,20,0));

        HBox hb_missionStatement = new HBox(10, missionStatement);
        hb_missionStatement.setAlignment(Pos.CENTER);
        hb_missionStatement.setPadding(new Insets(10,0,0,0));

        // 3 Pokedex layout
        Image fireImg = new Image("file:///D:/CPP/CS 2450 UI/PokePics/fire.png");
        Image waterImg = new Image("file:///D:/CPP/CS 2450 UI/PokePics/water.png");
        Image grassImg = new Image("file:///D:/CPP/CS 2450 UI/PokePics/grass.png");

        ImageView imageViewFire = new ImageView(fireImg);
        imageViewFire.setFitWidth(200);
        imageViewFire.setFitHeight(290);
        imageViewFire.getStyleClass().add("shadow-label");        //-----------------HERE

        ImageView imageViewWater = new ImageView(waterImg);
        imageViewWater.setFitWidth(200);
        imageViewWater.setFitHeight(350);
        imageViewWater.getStyleClass().add("shadow2-label");        //-----------------HERE

        ImageView imageViewGrass = new ImageView(grassImg);
        imageViewGrass.setFitWidth(200);
        imageViewGrass.setFitHeight(270);
        imageViewGrass.getStyleClass().add("shadow3-label");        //-----------------HERE

        HBox hb_3pokedex = new HBox(60,imageViewFire,imageViewWater,imageViewGrass);
        hb_3pokedex.setPadding(new Insets(80,0,0,90));

        Rectangle recFire = new Rectangle(80,250,230,380);
        recFire.setFill(null);
        recFire.setStroke(Color.BLACK);
        recFire.getStyleClass().add("shadow-label");        //-----------------HERE

        Rectangle recWater = new Rectangle(340,250,230,380);
        recWater.setFill(null);
        recWater.setStroke(Color.BLACK);
        recWater.getStyleClass().add("shadow2-label");        //-----------------HERE

        Rectangle recGrass = new Rectangle(600,250,230,380);
        recGrass.setFill(null);
        recGrass.setStroke(Color.BLACK);
        recGrass.getStyleClass().add("shadow3-label");        //-----------------HERE

        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 75);

        Text txtFire = new Text(140,610,"Fire");
        txtFire.setFont(font);
        txtFire.setFill(Color.BROWN);
        txtFire.setStroke(Color.BLACK);
        txtFire.setStrokeWidth(1);

        Text txtWater = new Text(380,610,"Water");
        txtWater.setFont(font);
        txtWater.setFill(Color.LIGHTBLUE);
        txtWater.setStroke(Color.BLACK);
        txtWater.setStrokeWidth(1);

        Text txtGrass = new Text(640,600,"Grass");
        txtGrass.setFont(font);
        txtGrass.setFill(Color.GREEN);
        txtGrass.setStroke(Color.BLACK);
        txtGrass.setStrokeWidth(1);

        // Set scene with vboxes and panes

        VBox rootVB = new VBox(hb_homeTitle,hb_hometaskbar,hb_missionStatement, hb_3pokedex);

        Pane rootGRP = new Pane(txtFire,txtWater,txtGrass,rootVB,recFire , recWater,recGrass);
        rootGRP.setStyle("-fx-background-color: #e0dede;");

        scene1 = new Scene(rootGRP, 890, 800);
        scene1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

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
        /////////////////////////////////////////////////

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
            Hbox rows
        */
        HBox pokedexRow3 = new HBox(255, torchicVBox, combuskenVBox, blaizkenVBox);
        pokedexRow3.setAlignment(Pos.CENTER);

        HBox sc2Row3 = new HBox(150, torchicImageView, combuskenImageView, blaizkenImageView);
        sc2Row3.setAlignment(Pos.CENTER);

        // VBox that puts the pokedex together
        VBox pokedexVbox = new VBox(50, sc2Row1, pokedexRow1, sc2Row2, pokedexRow2, sc2Row3, pokedexRow3);

        // VBox that puts everything together
        VBox layout2 = new VBox(hb_homeTitleSc2, hb_hometaskbarSc2, pokedexVbox);
        layout2.setStyle("-fx-background-color: white");

        // Add the rootGRP to a ScrollPane to allow scrolling
        ScrollPane fireScrollPane = new ScrollPane(layout2);
        fireScrollPane.setFitToWidth(true); // Allow the ScrollPane to resize horizontally
        fireScrollPane.setFitToHeight(true); // Allow the ScrollPane to resize vertically

        scene2 = new Scene(fireScrollPane, 890, 800);
        scene2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        /////////////////////////////////////////////////

        primaryStage.setTitle("Pokédex APP");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

}
