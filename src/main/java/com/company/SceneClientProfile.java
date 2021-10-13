package com.company;

import domain.Car;
import domain.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Collections;

public class SceneClientProfile {


    Scene scene;


    Client client;


    Button buttonBack;
    Button buttonEditClient;
    Button buttonEditCar;
    Button buttonAddCar;
    Button buttonErrand;
    TextField textFieldName;
    TextField textFieldSurName;
    TextField textFieldPhone;
    TextField textFieldAddress;


    TextField textFieldBrand;
    TextField textFieldModel;
    TextField textFieldYear;

    ObservableList cars = FXCollections.observableArrayList();

    ListView<String> listView = new ListView<String>();

    SceneClientProfile(){
        int prefWidth = 230;
        int prefHeight = 200;

        VBox vBox = new VBox(40);
        HBox hBox1 = new HBox(20);
        HBox hBox2 = new HBox(20);
        HBox hBox3 = new HBox(20);
        HBox hBox4 = new HBox(20);
        HBox hBox5 = new HBox(20);

        HBox hBoxCar1 = new HBox(20);
        HBox hBoxCar2 = new HBox(20);
        HBox hBoxCar3 = new HBox(20);
        HBox hBoxCar4 = new HBox(20);

        HBox hBoxALL = new HBox(20);
        VBox vBoxLeft = new VBox(40);
        VBox vBoxRight = new VBox(40);
        VBox vBoxCar = new VBox(40);

        Font font1 = new Font("Verdana", 20);

        final Text Name = new Text("Name:     ");
        Name.setFont(font1);
        final Text Surname = new Text("Surname:");
        Surname.setFont(font1);
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


        textFieldName = new TextField();
        textFieldName.setFont(font1);
        textFieldSurName = new TextField();
        textFieldSurName.setFont(font1);
        textFieldPhone = new TextField();
        textFieldPhone.setFont(font1);
        textFieldAddress = new TextField();
        textFieldAddress.setFont(font1);

        textFieldBrand = new TextField();
        textFieldBrand.setFont(font1);
        textFieldModel = new TextField();
        textFieldModel.setFont(font1);
        textFieldYear = new TextField();
        textFieldYear.setFont(font1);

        buttonBack = new Button("Back");
        buttonEditClient = new Button("Edit");
        buttonErrand = new Button("Errand ->");

        buttonAddCar = new Button("Add Car");
        buttonEditCar = new Button("Edit");

        Font font = new Font("Helvetica",30);

        buttonBack.setFont(font);
        buttonEditClient.setFont(font);
        buttonErrand.setFont(font);

        buttonAddCar.setFont(font1);
        buttonEditCar.setFont(font1);


        buttonBack.setPrefSize(prefWidth/2, prefHeight/2);
        buttonEditClient.setPrefSize(prefWidth/2, prefHeight/2);
        buttonErrand.setPrefHeight(prefHeight/2);

        listView.setPrefHeight(275);

        listView.setCellFactory(cell -> {
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

        listView.setOnMouseClicked(selectListView);


        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);
        hBox5.setAlignment(Pos.CENTER);
        hBoxCar1.setAlignment(Pos.CENTER);
        hBoxCar2.setAlignment(Pos.CENTER);
        hBoxCar3.setAlignment(Pos.CENTER);
        hBoxCar4.setAlignment(Pos.CENTER);
        hBoxALL.setAlignment(Pos.CENTER);

        hBoxALL.getChildren().addAll(vBoxLeft,vBoxRight,vBoxCar);
        vBoxLeft.getChildren().addAll(hBox1,hBox2,hBox3,hBox4);
        vBoxRight.getChildren().add(listView);
        vBoxCar.getChildren().addAll(hBoxCar1,hBoxCar2,hBoxCar3,hBoxCar4);

        hBox1.getChildren().addAll(Name,textFieldName);
        hBox2.getChildren().addAll(Surname,textFieldSurName);
        hBox3.getChildren().addAll(phone,textFieldPhone);
        hBox4.getChildren().addAll(address,textFieldAddress);

        hBoxCar1.getChildren().addAll(brand,textFieldBrand);
        hBoxCar2.getChildren().addAll(model, textFieldModel);
        hBoxCar3.getChildren().addAll(prodYear, textFieldYear);
        hBoxCar4.getChildren().addAll(buttonEditCar,buttonAddCar);

        hBox5.getChildren().addAll(buttonBack, buttonEditClient,buttonErrand);

        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(135,135,135), CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.getChildren().addAll(hBoxALL, hBox5);


        this.scene = new Scene(vBox, 1800, 950, Color.rgb(135,135,135));
    }

    private EventHandler<MouseEvent> selectListView = actionEvent ->{

        int index = listView.getSelectionModel().getSelectedIndex();
        Car car = client.getCars().get(index);
        textFieldBrand.setText(car.getBrand());
        textFieldModel.setText(car.getModel());
        textFieldYear.setText(String.valueOf(car.getYear()).substring(0,4));

        actionEvent.consume();
    };

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

    public Button getButtonEditClient() {
        return buttonEditClient;
    }

    public void setButtonEditClient(Button buttonEditClient) {
        this.buttonEditClient = buttonEditClient;
    }

    public TextField getTextFieldName() {
        return textFieldName;
    }

    public void setTextFieldName(TextField textFieldName) {
        this.textFieldName = textFieldName;
    }

    public TextField getTextFieldSurName() {
        return textFieldSurName;
    }

    public void setTextFieldSurName(TextField textFieldSurName) {
        this.textFieldSurName = textFieldSurName;
    }

    public TextField getTextFieldPhone() {
        return textFieldPhone;
    }

    public void setTextFieldPhone(TextField textFieldPhone) {
        this.textFieldPhone = textFieldPhone;
    }

    public TextField getTextFieldAddress() {
        return textFieldAddress;
    }

    public void setTextFieldAddress(TextField textFieldAddress) {
        this.textFieldAddress = textFieldAddress;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ListView<String> getListView() {
        return listView;
    }

    public void setListView(ListView<String> listView) {
        this.listView = listView;
    }

    public Button getButtonEditCar() {
        return buttonEditCar;
    }

    public void setButtonEditCar(Button buttonEditCar) {
        this.buttonEditCar = buttonEditCar;
    }

    public Button getButtonAddCar() {
        return buttonAddCar;
    }

    public void setButtonAddCar(Button buttonAddCar) {
        this.buttonAddCar = buttonAddCar;
    }

    public TextField getTextFieldBrand() {
        return textFieldBrand;
    }

    public void setTextFieldBrand(TextField textFieldBrand) {
        this.textFieldBrand = textFieldBrand;
    }

    public TextField getTextFieldModel() {
        return textFieldModel;
    }

    public void setTextFieldModel(TextField textFieldModel) {
        this.textFieldModel = textFieldModel;
    }

    public TextField getTextFieldYear() {
        return textFieldYear;
    }

    public void setTextFieldYear(TextField textFieldYear) {
        this.textFieldYear = textFieldYear;
    }

    public ObservableList getCars() {
        return cars;
    }

    public void setCars(ObservableList cars) {
        this.cars = cars;
    }
}
