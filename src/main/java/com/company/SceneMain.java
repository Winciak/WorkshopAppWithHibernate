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

public class SceneMain {

    Scene scene;



    Button buttonClient;
    Button buttonEmployee;
    Button buttonServices;
    Button buttonHalls;

    SceneMain(){
        int prefWidth = 230;
        int prefHeight = 200;

        VBox vBox = new VBox(100);
        HBox hBox1 = new HBox(125);
        HBox hBox2 = new HBox(125);

        buttonClient = new Button("Clients");
        buttonEmployee = new Button("Employees");
        buttonServices = new Button("Services");
        buttonHalls = new Button("Halls");

        Font font = new Font("Helvetica",35);
        buttonClient.setFont(font);
        buttonEmployee.setFont(font);
        buttonHalls.setFont(font);
        buttonServices.setFont(font);

        buttonClient.setPrefSize(prefWidth, prefHeight);
        buttonEmployee.setPrefSize(prefWidth, prefHeight);
        buttonHalls.setPrefSize(prefWidth, prefHeight);
        buttonServices.setPrefSize(prefWidth, prefHeight);



        File file = new File("src/main/java/com/company/resource/1.png");
        Image img = new Image(file.toURI().toString());
        ImageView imageView = new ImageView();
        imageView.setImage(img);

        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(buttonClient,buttonEmployee);
        hBox2.getChildren().addAll(buttonServices,buttonHalls);

        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(135,135,135), CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.getChildren().addAll(imageView,hBox1,hBox2);

        this.scene = new Scene(vBox, 1800, 950, Color.rgb(135,135,135));
    }




    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Button getButtonClient() {
        return buttonClient;
    }

    public void setButtonClient(Button buttonClient) {
        this.buttonClient = buttonClient;
    }

    public Button getButtonEmployee() {
        return buttonEmployee;
    }

    public void setButtonEmployee(Button buttonEmployee) {
        this.buttonEmployee = buttonEmployee;
    }

    public Button getButtonServices() {
        return buttonServices;
    }

    public void setButtonServices(Button buttonServices) {
        this.buttonServices = buttonServices;
    }

    public Button getButtonHalls() {
        return buttonHalls;
    }

    public void setButtonHalls(Button buttonHalls) {
        this.buttonHalls = buttonHalls;
    }
}
