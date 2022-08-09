package com.example.FlatironSpring;

import com.example.FlatironSpring.controller.Lab1TestingController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab1TestingControllerUnitTest {

    @Test
    void reverseNormal() {
        Lab1TestingController lab1TestingController = new Lab1TestingController();
        String helloStr = "Hello";
        assertEquals("olleH", lab1TestingController.reverse(helloStr));
    }

    @Test
    void reverseSpace() {
        Lab1TestingController lab1TestingController = new Lab1TestingController();
        String spacesString = "Bob boB";
        assertEquals("Bob boB", lab1TestingController.reverse(spacesString));

    }

    @Test
    void reverseWithNumbers() {
        Lab1TestingController lab1TestingController = new Lab1TestingController();
        String nmbStr = " 1 2 3 4 5 6 7 8 9";
        assertEquals("9 8 7 6 5 4 3 2 1 ", lab1TestingController.reverse(nmbStr));
    }
}