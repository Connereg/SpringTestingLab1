package com.example.FlatironSpring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabTestingControllerUnitTest {

    @Test
    void reverseNormal() {
        LabTestingController labTestingController = new LabTestingController();
        String helloStr = "Hello";
        assertEquals("olleH", labTestingController.reverse(helloStr));
    }

    @Test
    void reverseSpace() {
        LabTestingController labTestingController = new LabTestingController();
        String spacesString = "Bob boB";
        assertEquals("Bob boB", labTestingController.reverse(spacesString));

    }

    @Test
    void reverseWithNumbers() {
        LabTestingController labTestingController = new LabTestingController();
        String nmbStr = " 1 2 3 4 5 6 7 8 9";
        assertEquals("9 8 7 6 5 4 3 2 1 ", labTestingController.reverse(nmbStr));
    }
}