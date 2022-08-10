package com.example.FlatironSpring.service;

import com.example.FlatironSpring.dto.CoinDTO;
import com.example.FlatironSpring.dto.DataDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.lang.Double.parseDouble;

@Service
public class Lab2BitcoinService {

    public CoinDTO getBitcoin() {
        String apiURL = "https://api.coincap.io/v2/assets/bitcoin";
        RestTemplate restTemplate = new RestTemplate();
        DataDTO dtoReturn = restTemplate.getForObject(apiURL, DataDTO.class);
        CoinDTO coinReturn = dtoReturn.getData();
        return coinReturn;

    }

}

