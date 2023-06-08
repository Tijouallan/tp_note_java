package com.example.tp_note_java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class pizzaTest {

    @Test
    short getNom() {
        pizza pizza = new pizza("margarita",6,2);
        Assertions.assertEquals("margarita",getNom());

    }

    @Test
    void setPrix() {
    }
}