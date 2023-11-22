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
public class App extends Application {
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

        HBox hb_hometaskbar = new HBox(565,bttnHome,homeMenuBar);
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
        Label labelScene2 = new Label("This is scene 2");
        Button buttonScene2 = new Button("Go to scene 1");

        buttonScene2.setOnAction(event -> 
        {
            primaryStage.setScene(scene1);
        });


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

        HBox hb_hometaskbarSc2 = new HBox(565,bttnHomeSc2,homeMenuBarSc2);
        hb_hometaskbarSc2.setAlignment(Pos.CENTER);
        hb_hometaskbarSc2.setPadding(new Insets(10,0,20,0));

        VBox layout2 = new VBox(hb_homeTitleSc2, hb_hometaskbarSc2, labelScene2, buttonScene2);
        scene2 = new Scene(layout2, 890, 800);
        scene2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // Home button functionality
        bttnHomeSc2.setOnAction(event ->
        {
            primaryStage.setScene(scene1);
        });
        /////////////////////////////////////////////////


        primaryStage.setTitle("Pokédex APP");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

}
