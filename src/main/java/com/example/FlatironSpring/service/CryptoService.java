package com.example.FlatironSpring.service;

import com.example.FlatironSpring.dto.CoinDTO;
import com.example.FlatironSpring.dto.DataDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import static java.lang.Double.parseDouble;

@Service
@Slf4j
public class CryptoService {

    public CoinDTO getCrypto(String cryptoName) {
        String apiURL = "https://api.coincap.io/v2/assets/" + cryptoName;
        log.debug("Trying to access API with " + apiURL);
        RestTemplate restTemplate = new RestTemplate();
        DataDTO dataDTOReturn = restTemplate.getForObject(apiURL, DataDTO.class);
        return dataDTOReturn.getData();
    }

}
