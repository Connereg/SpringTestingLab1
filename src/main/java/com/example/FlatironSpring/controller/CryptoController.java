package com.example.FlatironSpring.controller;

import com.example.FlatironSpring.dto.CoinDTO;
import com.example.FlatironSpring.service.CryptoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CryptoController {
    private CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/crypto/{cryptoName}")
    public String getCryptoInfo(@PathVariable String cryptoName) {
        log.trace("Getting Crypto Info (Controller)");

        CoinDTO coin = cryptoService.getCrypto(cryptoName);

        log.info("Price Statement to be Generated with " + cryptoName + " (Controller)");
        String priceStatement = "The current price of " + coin.getName() + " is : " + coin.getPriceUsd();

        return priceStatement;
    }
}
