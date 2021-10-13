package com.company;

import domain.Car;
import domain.Client;
import domain.Employee;
import domain.Hall;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Main extends Application {

    SceneClient sceneClient = new SceneClient();
    SceneMain sceneMain = new SceneMain();
    SceneClientAdd sceneClientAdd = new SceneClientAdd();
    SceneClientSearch sceneClientSearch = new SceneClientSearch();
    SceneClientProfile sceneClientProfile = new SceneClientProfile();

    SceneEmployee sceneEmployee = new SceneEmployee();

    SceneErrand sceneErrand = new SceneErrand();


    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    @Override
    public void start(Stage primaryStage) throws Exception{
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();



//        Hall hall = new Hall();
//        hall.setArea(50);
//
//        Hall hall2 = new Hall();
//        hall2.setArea(100);
//
//
//        Employee client = new Employee();
//        client.setName("Name2");
//        client.setSurname("EmployeeSur2");
//        client.setPesel("99102200000");
//        client.setPosition("Mechanik");
//        client.setSalary(new BigDecimal(2500.00));
//        client.setHall(hall);
//
//        Employee client2 = new Employee();
//        client2.setName("Andrew");
//        client2.setSurname("Doors");
//        client2.setPesel("99102211111");
//        client2.setPosition("Detailer");
//        client2.setSalary(new BigDecimal(2000.00));
//        client2.setHall(hall2);
//
//
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(hall);
//        entityManager.persist(hall2);
//        entityManager.persist(client);
//        entityManager.persist(client2);
//        entityManager.getTransaction().commit();
//
//        entityManager.refresh(client);

        entityManager.close();
//        entityManagerFactory.close();


        BorderPane border = new BorderPane();
        primaryStage.setTitle("Workshapp");

        sceneMain.getButtonClient().setOnAction(MainToClientScene);
        sceneClient.getButtonBack().setOnAction(clientBackToMain);
        sceneClient.getButtonNewClient().setOnAction(clientToAddClientScene);
        sceneClient.getButtonSearch().setOnAction(clientToSearchClientScene);
        sceneClientAdd.getButtonBack().setOnAction(addClientBackToClientScene);
        sceneClientAdd.getButtonAdd().setOnAction(addClientEvent);
        sceneClientSearch.getButtonBack().setOnAction(searchClientBackToClientScene);
        sceneClientSearch.getButtonSearch().setOnAction(searchClientEvent);
        sceneClientSearch.getButtonChoose().setOnAction(searchClientSToClientProfileScene);

        sceneClientProfile.getButtonBack().setOnAction(profileClientBackToSearchClientScene);
        sceneClientProfile.getButtonEditClient().setOnAction(editClientEvent);
        sceneClientProfile.getButtonAddCar().setOnAction(addCarEvent);
        sceneClientProfile.getButtonEditCar().setOnAction(editCarEvent);

        sceneMain.getButtonEmployee().setOnAction(MainToEmployeeScene);
        sceneMain.getButtonServices().setOnAction(MainToServicesScene);

        sceneEmployee.getButtonBack().setOnAction(EmployeeBackToMainScene);
        sceneEmployee.getButtonSearch().setOnAction(searchEmployeeEvent);
        sceneEmployee.getButtonNew().setOnAction(addEmployeeEvent);
        sceneEmployee.getButtonEdit().setOnAction(editEmployeeEvent);

        sceneErrand.getButtonSearch().setOnAction(searchClientEvent2);


        primaryStage.setScene(sceneMain.getScene());
        primaryStage.show();
    }

//-----------------------------------MAIN-------------CLIENT----------------------------

    private EventHandler<ActionEvent> MainToClientScene = actionEvent ->{
        Stage stage;
        stage = (Stage) sceneMain.getScene().getWindow();

        stage.setScene(sceneClient.getScene());

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> clientBackToMain = actionEvent ->{
        Stage stage;
        stage = (Stage) sceneClient.getScene().getWindow();

        stage.setScene(sceneMain.getScene());

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> clientToAddClientScene = actionEvent ->{
        Stage stage;
        stage = (Stage) sceneClient.getScene().getWindow();

        sceneClientAdd.getTextFieldAddress().setText("");
        sceneClientAdd.getTextFieldBrand().setText("");
        sceneClientAdd.getTextFieldModel().setText("");
        sceneClientAdd.getTextFieldName().setText("");
        sceneClientAdd.getTextFieldPhone().setText("");
        sceneClientAdd.getTextFieldSurName().setText("");
        sceneClientAdd.getTextFieldYear().setText("");

        stage.setScene(sceneClientAdd.getScene());

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> addClientBackToClientScene = actionEvent ->{
        Stage stage;
        stage = (Stage) sceneClientAdd.getScene().getWindow();

        stage.setScene(sceneClient.getScene());

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> clientToSearchClientScene = actionEvent ->{
        Stage stage;
        stage = (Stage) sceneClient.getScene().getWindow();

        sceneClientSearch.getTextFieldSearch().setText("");
        sceneClientSearch.setClientList(Collections.emptyList());
        sceneClientSearch.getList().getItems().clear();

        stage.setScene(sceneClientSearch.getScene());

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> searchClientBackToClientScene = actionEvent ->{
        Stage stage;
        stage = (Stage) sceneClientSearch.getScene().getWindow();

        stage.setScene(sceneClient.getScene());

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> searchClientSToClientProfileScene = actionEvent ->{
        Stage stage;
        stage = (Stage) sceneClientSearch.getScene().getWindow();

        int index = sceneClientSearch.getList().getSelectionModel().getSelectedIndex();
        Client selectedClient = sceneClientSearch.getClientList().get(index);

        sceneClientProfile.getTextFieldName().setText(selectedClient.getName());
        sceneClientProfile.getTextFieldSurName().setText(selectedClient.getSurname());
        sceneClientProfile.getTextFieldPhone().setText(String.valueOf(selectedClient.getPhone()));
        sceneClientProfile.getTextFieldAddress().setText(selectedClient.getAddress());

        ObservableList cars = FXCollections.observableArrayList();

        if(selectedClient.getCars().size() > 0){
            for(int i=0;i<selectedClient.getCars().size(); i++){
                cars.add(selectedClient.getCars().get(i).getBrand() + " " + selectedClient.getCars().get(i).getModel() + " "
                        + String.valueOf(selectedClient.getCars().get(i).getYear()).substring(0,4) );
            }
        }

        sceneClientProfile.getListView().setItems(cars);
        sceneClientProfile.setClient(selectedClient);
        sceneClientProfile.setCars(cars);
        stage.setScene(sceneClientProfile.getScene());

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> profileClientBackToSearchClientScene = actionEvent ->{
        Stage stage;
        stage = (Stage) sceneClientProfile.getScene().getWindow();

        sceneClientSearch.getTextFieldSearch().setText("");
        sceneClientSearch.setClientList(Collections.emptyList());
        sceneClientSearch.getList().getItems().clear();

        stage.setScene(sceneClientSearch.getScene());

        actionEvent.consume();
    };


//-------------------------------CLIENT--------------DATABASE----------------------------------

    private EventHandler<ActionEvent> searchClientEvent = actionEvent ->{
        entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Client.class);

        ObservableList searchedClients = FXCollections.observableArrayList();
        List<Client> list = criteria.add(Restrictions.eq("surname", sceneClientSearch.getTextFieldSearch().getText())).list();

        if(list.size()>0){
            for(int i=0; i<list.size(); i++){
                searchedClients.add(list.get(i).getName() + " " + list.get(i).getSurname() + " (" + list.get(i).getCars().get(0).getBrand() + " " +
                                    list.get(i).getCars().get(0).getModel() + ")");
            }
        }

        sceneClientSearch.getList().setItems(searchedClients);

        sceneClientSearch.setClientList(list);

        entityManager.close();
        actionEvent.consume();
    };

    private EventHandler<ActionEvent> addClientEvent = actionEvent -> {
        entityManager = entityManagerFactory.createEntityManager();

        Client client = new Client();
        Car car = new Car();
        client.setName(sceneClientAdd.getTextFieldName().getText());
        client.setSurname(sceneClientAdd.getTextFieldSurName().getText());
        client.setPhone(Integer.parseInt(sceneClientAdd.getTextFieldPhone().getText()));
        client.setAddress(sceneClientAdd.getTextFieldAddress().getText());

        car.setBrand(sceneClientAdd.getTextFieldBrand().getText());
        car.setModel(sceneClientAdd.getTextFieldModel().getText());
        car.setYear(java.sql.Date.valueOf(sceneClientAdd.getTextFieldYear().getText() + "-01-02"));
        car.setClient(client);

        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.persist(client);
        entityManager.getTransaction().commit();

        entityManager.refresh(client);

        entityManager.close();
        actionEvent.consume();
    };

    private EventHandler<ActionEvent> addCarEvent = actionEvent -> {
        entityManager = entityManagerFactory.createEntityManager();


        Car car = new Car();
        Client client = sceneClientProfile.getClient();

        car.setBrand(sceneClientProfile.getTextFieldBrand().getText());
        car.setModel(sceneClientProfile.getTextFieldModel().getText());
        car.setYear(java.sql.Date.valueOf(sceneClientProfile.getTextFieldYear().getText() + "-01-02"));
        car.setClient(client);

        sceneClientProfile.getCars().add(car.getBrand() + " " + car.getModel() + " "
                + String.valueOf(car.getYear()).substring(0,4) );

        sceneClientProfile.getListView().setItems(sceneClientProfile.getCars());


        entityManager.getTransaction().begin();
        entityManager.persist(car);

        entityManager.getTransaction().commit();

        entityManager.refresh(car);

        sceneClientProfile.getTextFieldBrand().setText("");
        sceneClientProfile.getTextFieldModel().setText("");
        sceneClientProfile.getTextFieldYear().setText("");


        entityManager.close();
        actionEvent.consume();
    };

    private EventHandler<ActionEvent> editClientEvent = actionEvent -> {
        entityManager = entityManagerFactory.createEntityManager();

        Client client = sceneClientProfile.getClient();

        entityManager.getTransaction().begin();

        client = entityManager.find(Client.class, client.getId());
        client.setName(sceneClientProfile.getTextFieldName().getText());
        client.setSurname(sceneClientProfile.getTextFieldSurName().getText());
        client.setPhone(Integer.parseInt(sceneClientProfile.getTextFieldPhone().getText()));

        entityManager.getTransaction().commit();

        entityManager.close();
        actionEvent.consume();
    };

    private EventHandler<ActionEvent> editCarEvent = actionEvent -> {
        entityManager = entityManagerFactory.createEntityManager();

        int index = sceneClientProfile.getListView().getSelectionModel().getSelectedIndex();


        Car car = sceneClientProfile.getClient().getCars().get(index);

        entityManager.getTransaction().begin();

        car = entityManager.find(Car.class, car.getId());
        car.setBrand(sceneClientProfile.getTextFieldBrand().getText());
        car.setModel(sceneClientProfile.getTextFieldModel().getText());
        car.setYear(java.sql.Date.valueOf(sceneClientProfile.getTextFieldYear().getText() + "-01-02"));

        entityManager.getTransaction().commit();


        sceneClientProfile.getCars().set(index, car.getBrand() + " " + car.getModel() + " " + String.valueOf(car.getYear()).substring(0,4) );

        sceneClientProfile.getListView().setItems(sceneClientProfile.getCars());


        sceneClientProfile.getTextFieldBrand().setText("");
        sceneClientProfile.getTextFieldModel().setText("");
        sceneClientProfile.getTextFieldYear().setText("");


        entityManager.close();
        actionEvent.consume();
    };

//----------------------------------------MAIN----------------EMPLOYEE----------------------------------

    private EventHandler<ActionEvent> MainToEmployeeScene = actionEvent ->{
        Stage stage;
        stage = (Stage) sceneMain.getScene().getWindow();

        stage.setScene(sceneEmployee.getScene());

        entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);

        sceneEmployee.setEmployees(loadAllData(Employee.class, session));
        ObservableList employeesList = FXCollections.observableArrayList();

        if(sceneEmployee.getEmployees().size()>0){
            for(int i=0; i<sceneEmployee.getEmployees().size(); i++){
                employeesList.add( (i+1) + ". " +sceneEmployee.getEmployees().get(i).getName() + " "
                        + sceneEmployee.getEmployees().get(i).getSurname() +" "
                        + sceneEmployee.getEmployees().get(i).getPosition() );
            }
        }

        sceneEmployee.getListView().setItems(employeesList);

        sceneEmployee.setHalls(loadAllData(Hall.class, session));
        ObservableList hallsList = FXCollections.observableArrayList();

        if(sceneEmployee.getHalls().size()>0){
            for(int i=0; i<sceneEmployee.getHalls().size(); i++){
                hallsList.add(sceneEmployee.getHalls().get(i).getId() );
            }
        }
        hallsList.add("New Hall");

        sceneEmployee.getComboBoxHall().setItems(hallsList);

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> EmployeeBackToMainScene = actionEvent -> {
        Stage stage;
        stage = (Stage) sceneEmployee.getScene().getWindow();

        stage.setScene(sceneMain.getScene());

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> searchEmployeeEvent = actionEvent ->{
        entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Employee.class);

        ObservableList searchedEmployees = FXCollections.observableArrayList();
        List<Employee> list = criteria.add(Restrictions.eq("surname", sceneEmployee.getTextFieldSearch().getText())).list();

        if(list.size()>0){
            for(int i=0; i<list.size(); i++){
                searchedEmployees.add( (i + 1) + ". " +list.get(i).getName() + " " + list.get(i).getSurname() + " " + list.get(i).getPosition());
            }
            sceneEmployee.setEmployees(list);
        }
        else{
            sceneEmployee.setEmployees(loadAllData(Employee.class, session));

            if(sceneEmployee.getEmployees().size()>0){
                for(int i=0; i<sceneEmployee.getEmployees().size(); i++){
                    searchedEmployees.add( (i + 1) + ". " + sceneEmployee.getEmployees().get(i).getName() + " "
                            + sceneEmployee.getEmployees().get(i).getSurname() + " "
                            + sceneEmployee.getEmployees().get(i).getPosition() );
                }
            }

        }

        sceneEmployee.getListView().setItems(searchedEmployees);


        entityManager.close();
        actionEvent.consume();
    };

    private EventHandler<ActionEvent> addEmployeeEvent = actionEvent -> {
        entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);

        Employee employee = new Employee();


        employee.setName(sceneEmployee.getTextFieldName().getText());
        employee.setSurname(sceneEmployee.getTextFieldSurName().getText());
        employee.setSalary(new BigDecimal(sceneEmployee.getTextFieldSalary().getText()));
        employee.setPosition(sceneEmployee.getTextFieldPosition().getText());
        employee.setPesel(sceneEmployee.getTextFieldPesel().getText());

        if(!sceneEmployee.getTextFieldHall().isVisible()) {
            long id = (long) sceneEmployee.getComboBoxHall().getSelectionModel().getSelectedItem();
            Hall hall = entityManager.find(Hall.class, id);
            employee.setHall(hall);

            entityManager.getTransaction().begin();

            entityManager.persist(employee);

            entityManager.getTransaction().commit();
        }
        else {
            sceneEmployee.setHalls(loadAllData(Hall.class, session));

            Hall hall = new Hall();
            hall.setArea(Integer.parseInt(sceneEmployee.getTextFieldHall().getText()));
            employee.setHall(hall);

            entityManager.getTransaction().begin();

            entityManager.persist(hall);
            entityManager.persist(employee);

            entityManager.getTransaction().commit();

            entityManager.refresh(hall);

            sceneEmployee.getTextFieldHall().setText("");
            sceneEmployee.getTextFieldHall().setVisible(false);

            sceneEmployee.setHalls(loadAllData(Hall.class, session));
            ObservableList hallsList = FXCollections.observableArrayList();

            if(sceneEmployee.getHalls().size()>0){
                for(int i=0; i<sceneEmployee.getHalls().size(); i++){
                    hallsList.add(sceneEmployee.getHalls().get(i).getId() );
                }
            }
            hallsList.add("New Hall");

            sceneEmployee.getComboBoxHall().setItems(hallsList);
        }

        sceneEmployee.getTextFieldName().setText("");
        sceneEmployee.getTextFieldSurName().setText("");
        sceneEmployee.getTextFieldPesel().setText("");
        sceneEmployee.getTextFieldPosition().setText("");
        sceneEmployee.getTextFieldSalary().setText("");


        entityManager.close();
        actionEvent.consume();
    };

    private EventHandler<ActionEvent> editEmployeeEvent = actionEvent -> {
        entityManager = entityManagerFactory.createEntityManager();

        int index = sceneEmployee.getListView().getSelectionModel().getSelectedIndex();


        Employee employee = sceneEmployee.getEmployees().get(index);

        entityManager.getTransaction().begin();

        employee = entityManager.find(Employee.class, employee.getId());
        employee.setName(sceneEmployee.getTextFieldName().getText());
        employee.setSurname(sceneEmployee.getTextFieldSurName().getText());
        employee.setPesel(sceneEmployee.getTextFieldPesel().getText());
        employee.setPosition(sceneEmployee.getTextFieldPosition().getText());
        employee.setSalary(new BigDecimal(sceneEmployee.getTextFieldSalary().getText()));

        long id = (long) sceneEmployee.getComboBoxHall().getSelectionModel().getSelectedItem();
        Hall hall = entityManager.find(Hall.class, id);
        employee.setHall(hall);


        entityManager.getTransaction().commit();
        entityManager.refresh(employee);


        sceneEmployee.getListView().getItems().set(index, (index+1) + ". " + employee.getName() + " " + employee.getSurname() + " " + employee.getPosition());

        sceneEmployee.getEmployees().set(index, employee);

        sceneEmployee.getTextFieldName().setText("");
        sceneEmployee.getTextFieldSurName().setText("");
        sceneEmployee.getTextFieldPesel().setText("");
        sceneEmployee.getTextFieldPosition().setText("");
        sceneEmployee.getTextFieldSalary().setText("");



        entityManager.close();
        actionEvent.consume();
    };

//-----------------------MAIN-------------SERVICES-------------------------------------------------------------

    private EventHandler<ActionEvent> MainToServicesScene = actionEvent ->{
        Stage stage;
        stage = (Stage) sceneMain.getScene().getWindow();

        stage.setScene(sceneErrand.getScene());

        actionEvent.consume();
    };

    private EventHandler<ActionEvent> searchClientEvent2 = actionEvent ->{
        entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Client.class);

        ObservableList searchedClients = FXCollections.observableArrayList();
        List<Client> list = criteria.add(Restrictions.eq("surname", sceneErrand.getTextFieldSearch().getText())).list();

        if(list.size()>0){
            for(int i=0; i<list.size(); i++){
                searchedClients.add(list.get(i).getName() + " " + list.get(i).getSurname() + " (" + list.get(i).getCars().get(0).getBrand() + " " +
                        list.get(i).getCars().get(0).getModel() + ")");
            }
        }


        sceneErrand.getListOfClients().setItems(searchedClients);


        sceneErrand.setClientList(list);

        entityManager.close();
        actionEvent.consume();
    };

    public static void main(String[] args) {
        launch(args);
    }

    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }
}
