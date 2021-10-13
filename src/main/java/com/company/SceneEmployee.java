package com.company;

import domain.Employee;
import domain.Hall;
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

import java.util.List;

public class SceneEmployee {

    Scene scene;


    List<Employee> employees;
    List<Hall> halls;


    Button buttonBack;
    Button buttonEdit;
    Button buttonNew;


    Button buttonSearch;

    TextField textFieldSearch;

    TextField textFieldName;
    TextField textFieldSurName;
    TextField textFieldPesel;
    TextField textFieldPosition;
    TextField textFieldHall;
    TextField textFieldSalary;

    ComboBox comboBoxHall;


    ListView<String> listView = new ListView<String>();

    SceneEmployee(){

        int prefWidth = 230;
        int prefHeight = 200;

        VBox vBox = new VBox(40);

        HBox hBox1 = new HBox(20);
        HBox hBox2 = new HBox(20);
        HBox hBox3 = new HBox(20);
        HBox hBox4 = new HBox(20);
        HBox hBox5 = new HBox(20);

        HBox hBoxListView = new HBox(20);

        HBox hBoxCar1 = new HBox(20);
        HBox hBoxCar2 = new HBox(20);
        HBox hBoxCar3 = new HBox(20);
        HBox hBoxCar4 = new HBox(20);

        HBox hBoxALL = new HBox(40);
        VBox vBoxLeft = new VBox(20);
        VBox vBoxRight = new VBox(40);
        VBox vBoxCar = new VBox(40);

        Font font1 = new Font("Verdana", 20);

        final Text Name = new Text("Name:     ");
        Name.setFont(font1);
        final Text Surname = new Text("Surname:");
        Surname.setFont(font1);
        final Text pesel = new Text("PESEL:    ");
        pesel.setFont(font1);
        final Text position = new Text("Position: ");
        position.setFont(font1);
        final Text hall = new Text("Hall:       ");
        hall.setFont(font1);

        final Text salary = new Text("Salary:   ");
        salary.setFont(font1);
        final Text prodYear = new Text("Pd. Year:");
        prodYear.setFont(font1);

        buttonSearch = new Button("Search");
        buttonSearch.setFont(font1);

        textFieldSearch = new TextField();
        textFieldSearch.setFont(font1);

        textFieldName = new TextField("");
        textFieldName.setFont(font1);
        textFieldSurName = new TextField("");
        textFieldSurName.setFont(font1);
        textFieldPesel = new TextField("");
        textFieldPesel.setFont(font1);
        textFieldPosition = new TextField("");
        textFieldPosition.setFont(font1);

        textFieldHall = new TextField("");
        textFieldHall.setFont(font1);
        textFieldHall.setVisible(false);
        textFieldSalary = new TextField("");
        textFieldSalary.setFont(font1);

        comboBoxHall = new ComboBox();
        comboBoxHall.setStyle("-fx-font: 20px \"Verdana\";");
        comboBoxHall.setMinWidth(262);
        comboBoxHall.setOnAction(comboBoxEvent);

        buttonBack = new Button("Back");
        buttonEdit = new Button("Edit");
        buttonNew = new Button("New");



        Font font = new Font("Helvetica",30);

        buttonBack.setFont(font);
        buttonEdit.setFont(font);
        buttonNew.setFont(font);




        buttonBack.setPrefSize(prefWidth/2, prefHeight/2);
        buttonEdit.setPrefSize(prefWidth/2, prefHeight/2);
        buttonNew.setPrefSize(prefWidth/2, prefHeight/2);


//        listView.setPrefHeight(275);
        listView.setMinWidth(prefWidth*2);

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


        hBox5.setAlignment(Pos.CENTER);

        hBoxALL.setAlignment(Pos.CENTER);
        hBoxListView.setAlignment(Pos.CENTER);


        hBoxListView.getChildren().addAll(textFieldSearch, buttonSearch);
        hBoxALL.getChildren().addAll(vBoxLeft,vBoxRight);

        vBoxLeft.getChildren().addAll(hBoxListView, listView);
        vBoxRight.getChildren().addAll(hBox1,hBox2,hBox3,hBox4,hBoxCar1,hBoxCar2);


        hBox1.getChildren().addAll(Name,textFieldName);
        hBox2.getChildren().addAll(Surname,textFieldSurName);
        hBox3.getChildren().addAll(pesel, textFieldPesel);
        hBox4.getChildren().addAll(position, textFieldPosition);
        hBoxCar1.getChildren().addAll(hall, comboBoxHall, textFieldHall);
        hBoxCar2.getChildren().addAll(salary, textFieldSalary);



        hBox5.getChildren().addAll(buttonBack, buttonEdit,buttonNew);

        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(135,135,135), CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.getChildren().addAll(hBoxALL, hBox5);


        this.scene = new Scene(vBox, 1800, 950, Color.rgb(135,135,135));
    }

    private EventHandler<MouseEvent> selectListView = actionEvent ->{

        int index = listView.getSelectionModel().getSelectedIndex();
        Employee employee = employees.get(index);
        textFieldName.setText(employee.getName());
        textFieldSurName.setText(employee.getSurname());
        textFieldPesel.setText(employee.getPesel());
        textFieldPosition.setText(employee.getPosition());
        comboBoxHall.getSelectionModel().select(employee.getHall().getId());
        textFieldSalary.setText(String.valueOf(employee.getSalary()));

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> comboBoxEvent = actionEvent ->{
        String string;
        try {
             string = (String) comboBoxHall.getSelectionModel().getSelectedItem();
        } catch (ClassCastException e){
             string = String.valueOf(comboBoxHall.getSelectionModel().getSelectedItem());
        }

        if(string.equals("New Hall")){
            textFieldHall.setVisible(true);
        }
        else textFieldHall.setVisible(false);

    };

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Button getButtonBack() {
        return buttonBack;
    }

    public void setButtonBack(Button buttonBack) {
        this.buttonBack = buttonBack;
    }

    public Button getButtonEdit() {
        return buttonEdit;
    }

    public void setButtonEdit(Button buttonEdit) {
        this.buttonEdit = buttonEdit;
    }

    public Button getButtonNew() {
        return buttonNew;
    }

    public void setButtonNew(Button buttonNew) {
        this.buttonNew = buttonNew;
    }

    public ListView<String> getListView() {
        return listView;
    }

    public void setListView(ListView<String> listView) {
        this.listView = listView;
    }

    public Button getButtonSearch() {
        return buttonSearch;
    }

    public void setButtonSearch(Button buttonSearch) {
        this.buttonSearch = buttonSearch;
    }

    public TextField getTextFieldSearch() {
        return textFieldSearch;
    }

    public void setTextFieldSearch(TextField textFieldSearch) {
        this.textFieldSearch = textFieldSearch;
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

    public TextField getTextFieldPesel() {
        return textFieldPesel;
    }

    public void setTextFieldPesel(TextField textFieldPesel) {
        this.textFieldPesel = textFieldPesel;
    }

    public TextField getTextFieldPosition() {
        return textFieldPosition;
    }

    public void setTextFieldPosition(TextField textFieldPosition) {
        this.textFieldPosition = textFieldPosition;
    }

    public TextField getTextFieldHall() {
        return textFieldHall;
    }

    public void setTextFieldHall(TextField textFieldHall) {
        this.textFieldHall = textFieldHall;
    }

    public TextField getTextFieldSalary() {
        return textFieldSalary;
    }

    public void setTextFieldSalary(TextField textFieldSalary) {
        this.textFieldSalary = textFieldSalary;
    }

    public ComboBox getComboBoxHall() {
        return comboBoxHall;
    }

    public void setComboBoxHall(ComboBox comboBoxHall) {
        this.comboBoxHall = comboBoxHall;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

}
