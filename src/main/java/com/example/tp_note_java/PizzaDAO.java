package com.example.tp_note_java;

import com.example.tp_note_java.pizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {

    public List<pizza> getAllPizzas() {
        List<pizza> pizzas = new ArrayList<>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pizzeria", "root", "");

             Statement   stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pizza;");

            while (rs.next()) {



                pizza pizza = new pizza(rs.getString(2), rs.getInt(3), rs.getInt(4));
                pizzas.add(pizza);
            }
            conn.close();


        } catch (Exception e) {
            System.out.printf(String.valueOf(e));
        };
        return pizzas;
    }



        public void addPizza(pizza pizza) {


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pizzeria", "root", "");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO pizza ( nom, prix, nb_ing) VALUES ( ?, ?, ?)")) {

            stmt.setString(1, pizza.getNom());
            stmt.setInt(2, pizza.getPrix());
            stmt.setInt(3, pizza.getNbIngredients());

            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.printf(String.valueOf(e));
        };
    }

    public void deleteAllPizzas() {


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pizzeria", "root", "");
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM pizza")) {

            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.printf(String.valueOf(e));
        };
    }
}

