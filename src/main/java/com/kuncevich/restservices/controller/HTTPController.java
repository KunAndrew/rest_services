package com.kuncevich.restservices.controller;

import com.kuncevich.restservices.model.Months;
import com.kuncevich.restservices.model.StringLengthSort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;


@RestController
public class HTTPController {
    @PostMapping(value = "/first")
    public ResponseEntity<?> post(@RequestBody ArrayList<String> unsortList) {
        ArrayList<String> sortList = new ArrayList<>();
        Comparator<String> stringLengthComparator = new StringLengthSort();
        Collections.sort(unsortList, stringLengthComparator);

        for (String str : unsortList) {
            String tempstr = str;
            sortList.add("(" + tempstr.length() + "): " + tempstr);
        }

        return new ResponseEntity<>(sortList, HttpStatus.OK);
    }

    @GetMapping(value = "/second")
    public ResponseEntity<?> read(@RequestBody Optional<String> number) {
        if (number.isPresent()) {
            if (Months.isRightNumericMonth(number.get())) {
                int i = Integer.valueOf(number.get());
                return new ResponseEntity<>(Months.getMonthFromNumber(i).getFormatedString(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("INCORRECT INPUT DATA", HttpStatus.BAD_REQUEST);
    }
}
