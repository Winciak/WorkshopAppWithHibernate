package com.company;

import domain.Client;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.List;

public class SceneClientSearch {


    Scene scene;

    Button buttonBack;
    Button buttonSearch;
    Button buttonChoose;

    TextField textFieldSearch;

    TextField textFieldSurName;

    ListView<String> list = new ListView<String>();

    List<Client> clientList;


    SceneClientSearch(){
        int prefWidth = 230;
        int prefHeight = 200;

        VBox vBox = new VBox(40);
        HBox hBox1 = new HBox(20);
        HBox hBox2 = new HBox(20);
        HBox hBox5 = new HBox(20);

        Font font1 = new Font("Verdana", 20);

        final Text phone = new Text("Phone:    ");
        phone.setFont(font1);
        final Text address = new Text("Address: ");
        address.setFont(font1);
        final Text brand = new Text("Brand:    ");
        brand.setFont(font1);
        final Text model = new Text("Model:    ");
        model.setFont(font1);
        final Text prodYear = new Text("Pd. Year:");
        prodYear.setFont(font1);
        final Text car = new Text("Client's car information                     ");
        car.setFont(font1);

        textFieldSearch = new TextField();
        textFieldSearch.setFont(font1);
        textFieldSurName = new TextField();
        textFieldSurName.setFont(font1);


        buttonSearch = new Button("Search");
        buttonSearch.setFont(font1);

        buttonChoose = new Button("Selected Profile");
        buttonChoose.setFont(font1);
        buttonChoose.setWrapText(true);
        buttonChoose.setPrefSize(prefWidth/2, prefHeight/2);

        Font font = new Font("Helvetica",30);


        buttonBack = new Button("Back");
        buttonBack.setFont(font);
        buttonBack.setPrefSize(prefWidth/2, prefHeight/2);

        clientList =  Collections.emptyList();

        list.setPrefWidth(prefWidth*2);
        list.setCellFactory(cell -> {
            return new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item.toString());
                        setFont(font1);
                    }
                }
            };
        });



        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox5.setAlignment(Pos.CENTER);

        hBox1.getChildren().addAll(textFieldSearch, buttonSearch);
        hBox2.getChildren().addAll(list, buttonChoose);
        hBox5.getChildren().addAll(buttonBack);

        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(135,135,135), CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.getChildren().addAll(hBox1, hBox2, hBox5);


        this.scene = new Scene(vBox, 1800, 950, Color.rgb(135,135,135));
    }


    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Button getButtonSearch() {
        return buttonSearch;
    }

    public void setButtonSearch(Button buttonSearch) {
        this.buttonSearch = buttonSearch;
    }

    public Button getButtonBack() {
        return buttonBack;
    }

    public void setButtonBack(Button buttonBack) {
        this.buttonBack = buttonBack;
    }

    public TextField getTextFieldSearch() {
        return textFieldSearch;
    }

    public void setTextFieldSearch(TextField textFieldSearch) {
        this.textFieldSearch = textFieldSearch;
    }

    public ListView<String> getList() {
        return list;
    }

    public void setList(ListView<String> list) {
        this.list = list;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public Button getButtonChoose() {
        return buttonChoose;
    }

    public void setButtonChoose(Button buttonChoose) {
        this.buttonChoose = buttonChoose;
    }
}
