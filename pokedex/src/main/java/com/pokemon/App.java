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
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {

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

        Button bttnHome = new Button("Home");
        bttnHome.getStyleClass().add("bttn-label");
        // Button bttnQA = new Button("Pokédex Q&A");
        // bttnQA.getStyleClass().add("bttn-label");
        // Button bttnAbout = new Button("About/Contact US");
        // bttnAbout.getStyleClass().add("bttn-label");


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

        HBox hb_missionStatement = new HBox(10, missionStatement);
        hb_missionStatement.setAlignment(Pos.CENTER);
        hb_missionStatement.setPadding(new Insets(10,0,0,0));

        // Home- Cards Images
        Image fireImg = new Image("file:///D:/CPP/CS 2450 UI/PokePics/fire.png");
        Image waterImg = new Image("file:///D:/CPP/CS 2450 UI/PokePics/water.png");
        Image grassImg = new Image("file:///D:/CPP/CS 2450 UI/PokePics/grass.png");

        Image backgroundImage = new Image("file:///D:/CPP/CS 2450 UI/PokePics/firebk.png");



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

      //  HBox hb_3pokedex = new HBox(60,imageViewFire,imageViewWater,imageViewGrass);
       // hb_3pokedex.setAlignment(Pos.BOTTOM_CENTER);
       // hb_3pokedex.setPadding(new Insets(80,0,0,90));


        // Home- Cards Rectangles
                             // Rectangle(X,Y,Weidth, Height)
        Rectangle recFire = new Rectangle(80,280,230,380);
        recFire.setStroke(Color.BLACK);
        recFire.getStyleClass().add("shadow-label");        //-----------------HERE
        ImagePattern myip =new ImagePattern(backgroundImage);
        recFire.setFill(myip);

        Rectangle recWater = new Rectangle(340,280,230,380);
        recWater.setFill(null);
        recWater.setStroke(Color.BLACK);
        recWater.getStyleClass().add("shadow2-label");        //-----------------HERE

        Rectangle recGrass = new Rectangle(600,280,230,380);
        recGrass.setFill(null);
        recGrass.setStroke(Color.BLACK);
        recGrass.getStyleClass().add("shadow3-label");        //-----------------HERE

        // Home- Cards Text
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 75);

        Font biggerFont = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 130);

        Text txtFire = new Text(140,640,"Fire");
        txtFire.setFont(font);
        txtFire.setFill(Color.BROWN);
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
        txtGrass.setStrokeWidth(1);

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


        VBox rootVB = new VBox(hb_homeTitle,hb_hometaskbar,hb_missionStatement);

        Group rootGRP = new Group(rootVB,
        recFire , recWater,recGrass, txtFire,txtWater,txtGrass, imageViewFire, imageViewWater, imageViewGrass);
        rootGRP.setStyle("-fx-background-color: #e0dede;");


        Scene scene = new Scene(rootGRP, 890, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Pokédex APP");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
