package com.example.tp_note_java;


import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.*;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.scene.control.TableView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
public class HelloController implements Initializable {

    @FXML
    private TableView table;
    @FXML
    private TableColumn recette;
    @FXML
    private TableColumn prix;
    @FXML
    private TableColumn nbIngredient;

    @FXML
    private Button vider;

    @FXML
    private TextField field_recette;
    @FXML
    private TextField field_prix;
    @FXML
    private TextField field_nbIngredient;

    @FXML
    private Button ajouter;
    @FXML
    private TableView<pizza> pizzaTableView;

    private PizzaDAO pizzaDAO;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaDAO = new PizzaDAO();
        afficheColonnes();
        loadPizzas();
    }

    public void addPizza(pizza pizza) {
        pizzaDAO.addPizza(pizza);
        loadPizzas();
    }

    public void deleteAllPizzas() {
        pizzaDAO.deleteAllPizzas();
        loadPizzas();
    }
    private void afficheColonnes() {
        TableColumn<pizza, String> recette = new TableColumn<>("Nom");
        recette.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<pizza, Integer> prix = new TableColumn<>("Prix");
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));

        TableColumn<pizza, Integer> nbIngredient = new TableColumn<>("Nombre d'ingrédients");
        nbIngredient.setCellValueFactory(new PropertyValueFactory<>("nbIng"));

        pizzaTableView.getColumns().addAll(recette, prix, nbIngredient);
    }


    private void loadPizzas() {
        ObservableList<pizza> pizzas = FXCollections.observableArrayList(pizzaDAO.getAllPizzas());
        pizzaTableView.setItems(pizzas);
    }

   /* @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recette.setCellFactory(new PropertyValueFactory<pizza,String>("nom"));
        prix.setCellFactory(new PropertyValueFactory<pizza, Integer>("prix"));
        nbIngredient.setCellFactory(new PropertyValueFactory<pizza,Integer>("nbIngredients"));


        var data = new PizzaDAO().getAllPizzas();

        for(int i = 1; i < data.size(); ++i) {

            this.table.getItems().add(codeValue);
        }

    }
    // a refaire mais pour sql pas pour csv
    public List<List<String>> getData() {
        List<List<String>> menu = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/pays.csv"));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    records.add(Arrays.asList(values));
                }
            } catch (Throwable var6) {
                try {
                    br.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            br.close();
            return records;
        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }
    }*/
}
