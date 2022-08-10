package com.example.FlatironSpring.controller;

import com.example.FlatironSpring.dto.CoinDTO;
import com.example.FlatironSpring.service.Lab2BitcoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lab2BitcoinController {

    private Lab2BitcoinService bitcoinService;

    public Lab2BitcoinController(Lab2BitcoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }

    @GetMapping("/bitcoinPrice")
    public String checkBitcoinPrice() {
        String bitcoinStatement = "The current price of a Bitcoin is: ";
        CoinDTO bitcoin = bitcoinService.getBitcoin();
        bitcoinStatement += bitcoin.getPriceUsd();
        return bitcoinStatement;
    }
}
