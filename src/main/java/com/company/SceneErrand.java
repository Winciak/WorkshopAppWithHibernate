package com.company;

import domain.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.List;

public class SceneErrand {


    Scene scene;

    Button buttonBack;
    Button buttonFinish;

    Button buttonSearch;
    Button buttonAdd;
    Button buttonDelete;


    TextField textFieldSearch;
    TextField textFieldSurName;

    Text labelTotal;

    ListView<String> listOfClients = new ListView<String>();

    ComboBox comboBoxCars;
    ListView<String> listOfServices = new ListView<String>();
    ListView<String> listOfAddedServices = new ListView<String>();

    List<Client> clientList;


    SceneErrand(){
        int prefWidth = 230;
        int prefHeight = 200;

        HBox hBoxAll = new HBox(30);
        VBox vBox = new VBox(40);
        VBox vBoxColumn1 = new VBox(40);
        VBox vBoxColumn2 = new VBox(40);
        VBox vBoxColumn3 = new VBox(40);
        VBox vBoxColumn4 = new VBox(40);
        HBox hBox1 = new HBox(20);
        HBox hBox2 = new HBox(20);
        HBox hBox5 = new HBox(100);

        Font font1 = new Font("Verdana", 20);



        textFieldSearch = new TextField();
        textFieldSearch.setFont(font1);

        labelTotal = new Text("Total: 0");
        labelTotal.setFont(font1);


        String cars[] = { "KIA Ceed (2007)", "KIA Ceed2 (2008)", "brand model (2009)" };
        comboBoxCars = new ComboBox(FXCollections.observableArrayList(cars));
        comboBoxCars.setStyle("-fx-font: 20px \"Verdana\";");


        buttonSearch = new Button("Search");
        buttonSearch.setFont(font1);
        buttonDelete = new Button("Delete");
        buttonDelete.setFont(font1);


        Font font = new Font("Helvetica",30);


        buttonBack = new Button("Back");
        buttonBack.setFont(font);
        buttonBack.setPrefSize(prefWidth/2, prefHeight/2);

        buttonFinish = new Button("Finish");
        buttonFinish.setFont(font);
        buttonFinish.setPrefSize((1.5*prefWidth)/2, prefHeight/2);

        buttonAdd = new Button("Add->");
        buttonAdd.setFont(font);

        clientList =  Collections.emptyList();

        listOfClients.setPrefWidth(prefWidth*2);
        listOfClients.setCellFactory(cell -> {
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

        listOfServices.setPrefWidth(prefWidth*2);
        listOfServices.setCellFactory(cell -> {
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

        ObservableList searchedClients = FXCollections.observableArrayList();
        searchedClients.add("External cleaning (50zł)");
        searchedClients.add("Internal cleaning (100zł)");
        searchedClients.add("Polishing (50zł)");
        searchedClients.add("Cleaning with foam(100zł)");
        searchedClients.add("Engine repair (300zł+)");
        searchedClients.add("Chassis repair (150zł+)");
        searchedClients.add("Varnishing (220zł)");

        listOfServices.setItems(searchedClients);

        listOfAddedServices.setPrefWidth(prefWidth*2);
        listOfAddedServices.setCellFactory(cell -> {
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


        hBoxAll.setAlignment(Pos.CENTER);

        hBox2.setAlignment(Pos.CENTER_LEFT);
        hBox5.setAlignment(Pos.CENTER);


        hBox1.getChildren().addAll(textFieldSearch,buttonSearch);
        vBoxColumn1.getChildren().addAll(hBox1, listOfClients);
        vBoxColumn2.getChildren().addAll(comboBoxCars, listOfServices);
        hBox2.getChildren().addAll(labelTotal, buttonDelete);
        vBoxColumn3.getChildren().addAll(hBox2, listOfAddedServices);

        hBoxAll.getChildren().addAll(vBoxColumn1,vBoxColumn2,buttonAdd, vBoxColumn3);
        hBox5.getChildren().addAll(buttonBack, buttonFinish);

        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(135,135,135), CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.getChildren().addAll(hBoxAll, hBox5);


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

    public ListView<String> getListOfClients() {
        return listOfClients;
    }

    public void setListOfClients(ListView<String> listOfClients) {
        this.listOfClients = listOfClients;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public ListView<String> getListOfServices() {
        return listOfServices;
    }

    public void setListOfServices(ListView<String> listOfServices) {
        this.listOfServices = listOfServices;
    }

}
