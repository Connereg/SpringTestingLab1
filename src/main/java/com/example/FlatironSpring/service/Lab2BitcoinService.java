package com.example.FlatironSpring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.lang.Double.parseDouble;

@Service
public class Lab2BitcoinService {

    public double getBitcoinPrice() {
        String apiURL = "http://api.coincap.io/v2/assets/bitcoin";
        RestTemplate restTemplate = new RestTemplate();
        String stringResult = restTemplate.getForObject(apiURL, Bitcoin.class).priceUsd;

        double doubleResult = parseDouble(stringResult);
        return doubleResult;
    }

}

class Bitcoin {

    public String id;
    public String priceUsd;
    public String name;

    //BITCOIN OBJ SHAPE
//    "id": "bitcoin",
//            "rank": "1",
//            "symbol": "BTC",
//            "name": "Bitcoin",
//            "supply": "19116887.0000000000000000",
//            "maxSupply": "21000000.0000000000000000",
//            "marketCapUsd": "440481113563.9369842003693659",
//            "volumeUsd24Hr": "10440498187.4192242449766378",
//            "priceUsd": "23041.4666134678195357",
//            "changePercent24Hr": "-3.5399742196628504",
//            "vwap24Hr": "23546.2200519051361111",
//            "explorer": "https://blockchain.info/"
}
