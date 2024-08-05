package com.pp.service;

import com.pp.entity.Tourist;
import com.pp.exception.AgeLimitException;
import com.pp.exception.RecordNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface TouristService {
    Tourist registerTourist(Tourist tourist) throws AgeLimitException;

    String updateTourist(Tourist tourist) throws AgeLimitException, RecordNotFoundException;

    void deleteTouristById(Long id) throws RecordNotFoundException;

    ResponseEntity<Tourist> fetchTouristById(Long id) throws RecordNotFoundException;

    ResponseEntity<List<Tourist>> fetchTouristByName(String name) throws RecordNotFoundException;
}
