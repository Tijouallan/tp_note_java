package com.example.tp_note_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    public HelloApplication() {
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820.0, 240.0);
        stage.setTitle("Mon menu");
        stage.setScene(scene);
        stage.show();
    }


   /* public static void main(String[] args) {
        //afficherPizzas();
        // new PizzaDAO().addPizza(new pizza("3 fromy",7,4));
       // new PizzaDAO().deleteAllPizzas();
        // afficherPizzas();
    }*/

    public static void afficherPizzas(){
        List<pizza> pizzas = new PizzaDAO().getAllPizzas();
        pizzas.stream().forEach(pizza -> System.out.println(pizza.toString()));
    }
}
