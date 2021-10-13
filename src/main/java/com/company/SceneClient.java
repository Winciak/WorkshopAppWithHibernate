package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class SceneClient {


    Scene scene;



    Button buttonBack;
    Button buttonNewClient;
    Button buttonSearch;

    SceneClient(){
        int prefWidth = 230;
        int prefHeight = 200;

        VBox vBox = new VBox(100);
        HBox hBox1 = new HBox(125);
        HBox hBox2 = new HBox(125);

        buttonNewClient = new Button("New Client");
        buttonSearch = new Button("Search Clients");
        buttonBack = new Button("Back");
//        Button buttonHalls = new Button("Halls");

        Font font = new Font("Helvetica",30);
        buttonNewClient.setFont(font);
        buttonSearch.setFont(font);
//        buttonHalls.setFont(font);
        buttonBack.setFont(font);

        buttonNewClient.setPrefSize(prefWidth, prefHeight);
        buttonSearch.setPrefSize(prefWidth, prefHeight);
//        buttonHalls.setPrefSize(prefWidth, prefHeight);
        buttonBack.setPrefSize(prefWidth/2, prefHeight/2);




        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(buttonNewClient,buttonSearch);
        hBox2.getChildren().addAll(buttonBack);

        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(135,135,135), CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.getChildren().addAll(hBox1,hBox2);


        this.scene = new Scene(vBox, 1800, 950, Color.rgb(135,135,135));
    }



    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Button getButtonBack() {
        return buttonBack;
    }

    public void setButtonBack(Button buttonBack) {
        this.buttonBack = buttonBack;
    }

    public Button getButtonNewClient() {
        return buttonNewClient;
    }

    public void setButtonNewClient(Button buttonNewClient) {
        this.buttonNewClient = buttonNewClient;
    }

    public Button getButtonSearch() {
        return buttonSearch;
    }

    public void setButtonSearch(Button buttonSearch) {
        this.buttonSearch = buttonSearch;
    }
}
