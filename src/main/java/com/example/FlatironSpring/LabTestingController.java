package com.example.FlatironSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LabTestingController {

    @GetMapping("/reverse")
    public String reverse(String stringToReverse) {
        String str = stringToReverse, nstr="";
        char ch;
        for (int i=0; i<str.length(); i++) {
            ch= str.charAt(i);
            nstr= ch+nstr;
        }
        return nstr;
    }

}
