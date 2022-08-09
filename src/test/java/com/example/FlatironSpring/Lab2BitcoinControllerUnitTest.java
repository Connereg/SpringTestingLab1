package com.example.FlatironSpring;

import com.example.FlatironSpring.controller.Lab2BitcoinController;
import com.example.FlatironSpring.service.Lab2BitcoinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class Lab2BitcoinControllerUnitTest {

    @Test
    void checkBitcoinPrice() {
        Lab2BitcoinService bitcoinService = Mockito.mock(Lab2BitcoinService.class);
        double bitcoinPriceFaked = 100.00;
        Lab2BitcoinController bitcoinController = new Lab2BitcoinController(bitcoinService);
        when(bitcoinService.getBitcoinPrice()).thenReturn(bitcoinPriceFaked);
        //
        String expected = "The current price of a Bitcoin is: " + 100.00;
        String actual = bitcoinController.checkBitcoinPrice();
        assertEquals(expected, actual);
    }
}