package com.pp.controller;

import com.pp.entity.Tourist;
import com.pp.exception.AgeLimitException;
import com.pp.exception.RecordNotFoundException;
import com.pp.service.TouristService;
import com.pp.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tourist")
public class TouristController {

    @Autowired
    private TouristService touristService;

    @PostMapping(value = "/registration")
    private ResponseEntity<Tourist> registerTourist(@RequestBody Tourist tourist) throws AgeLimitException {
        tourist = touristService.registerTourist(tourist);
        return new ResponseEntity<>(tourist, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    private ResponseEntity<String> updateTourist(@RequestBody Tourist tourist) throws AgeLimitException, RecordNotFoundException {
        String status = touristService.updateTourist(tourist);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/get-tourist-list-by-name")
    private ResponseEntity<List<Tourist>> fetchTouristByName(@RequestParam("name") String name) throws RecordNotFoundException {
        return touristService.fetchTouristByName(name);
    }

    @GetMapping("/get-tourist-by-id")
    private ResponseEntity<Tourist> fetchTouristById(@RequestParam("id") Long id) throws RecordNotFoundException {
        return touristService.fetchTouristById(id);
    }

    @DeleteMapping("/delete-tourist-by-id")
    private ResponseEntity<String> deleteTouristById(@RequestParam("id") Long id) throws RecordNotFoundException {
        touristService.deleteTouristById(id);
        return new ResponseEntity<>(ConstantUtils.DELETED_SUCCESSFULLY, HttpStatus.OK);
    }
}
