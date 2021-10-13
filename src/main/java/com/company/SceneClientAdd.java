package com.company;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SceneClientAdd {


    Scene scene;



    Button buttonBack;
    Button buttonAdd;
    TextField textFieldName;
    TextField textFieldSurName;
    TextField textFieldPhone;
    TextField textFieldAddress;
    TextField textFieldBrand;
    TextField textFieldModel;
    TextField textFieldYear;

    SceneClientAdd(){
        int prefWidth = 230;
        int prefHeight = 200;

        VBox vBox = new VBox(40);
        HBox hBox1 = new HBox(20);
        HBox hBox2 = new HBox(20);
        HBox hBox3 = new HBox(20);
        HBox hBox4 = new HBox(20);
        HBox hBox5 = new HBox(20);

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
        final Text car = new Text("Client's car information                     ");
        car.setFont(font1);

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
        buttonAdd = new Button("Add");

        Font font = new Font("Helvetica",30);

        buttonBack.setFont(font);
        buttonAdd.setFont(font);


        buttonBack.setPrefSize(prefWidth/2, prefHeight/2);
        buttonAdd.setPrefSize(prefWidth/2, prefHeight/2);



        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);
        hBox5.setAlignment(Pos.CENTER);

        hBox1.getChildren().addAll(Name,textFieldName, car);
        hBox2.getChildren().addAll(Surname,textFieldSurName, brand, textFieldBrand);
        hBox3.getChildren().addAll(phone,textFieldPhone, model, textFieldModel);
        hBox4.getChildren().addAll(address,textFieldAddress, prodYear, textFieldYear);
        hBox5.getChildren().addAll(buttonBack,buttonAdd);

        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(135,135,135), CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5);


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

    public Button getButtonAdd() {
        return buttonAdd;
    }

    public void setButtonAdd(Button buttonAdd) {
        this.buttonAdd = buttonAdd;
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

}
