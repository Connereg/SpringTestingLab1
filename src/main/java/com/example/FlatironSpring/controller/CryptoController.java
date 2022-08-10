package com.example.FlatironSpring.controller;

import com.example.FlatironSpring.dto.CoinDTO;
import com.example.FlatironSpring.service.CryptoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoController {
    private CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/crypto/{cryptoName}")
    public String getCryptoInfo(@PathVariable String cryptoName) {
        CoinDTO coin = cryptoService.getCrypto(cryptoName);

        String priceStatement = "The current price of " + coin.getName() + " is : " + coin.getPriceUsd();

        return priceStatement;
    }
}
