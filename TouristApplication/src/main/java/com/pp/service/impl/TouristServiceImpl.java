package com.pp.service.impl;

import com.pp.entity.Tourist;
import com.pp.exception.AgeLimitException;
import com.pp.exception.RecordNotFoundException;
import com.pp.repository.TouristRepository;
import com.pp.service.TouristService;
import com.pp.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService {

    @Autowired
    private TouristRepository touristRepository;

    @Override
    public Tourist registerTourist(Tourist tourist) throws AgeLimitException {
        //validating the age
        if (tourist.getAge() > 90) {
            throw new AgeLimitException(ConstantUtils.AGE_LIMIT_MESSAGE);
        }
        //registering the tourist
        return touristRepository.save(tourist);
    }

    @Override
    public String updateTourist(Tourist inputTourist) throws RecordNotFoundException, AgeLimitException {
        //Check for the record if it exist.
        Optional<Tourist> dbTourist = touristRepository.findById(inputTourist.getTouristId());
        //if record doesn't exist throw exception, else update the tourist
        if (!dbTourist.isPresent()) {
            throw new RecordNotFoundException(ConstantUtils.RECORD_DOES_NOT_EXIST);
            //Validation the Age
        } else if (inputTourist.getAge() > 90) {
            throw new AgeLimitException(ConstantUtils.AGE_LIMIT_MESSAGE);
        } else {
            //updating the fetched record with the given input tourist
            Tourist updateTourist = dbTourist.get();
            updateTourist.setAge(inputTourist.getAge());
            updateTourist.setGender(inputTourist.getGender());
            updateTourist.setFromPlace(inputTourist.getFromPlace());
            updateTourist.setNumberOfDaysVisits(inputTourist.getNumberOfDaysVisits());
            //calling the save method to save the updated-fetched record.
            touristRepository.save(updateTourist);
            return ConstantUtils.UPDATED_SUCCESSFULLY;
        }
    }

    @Override
    public void deleteTouristById(Long id) throws RecordNotFoundException {
        //search for the record
        Optional<Tourist> optionalTourist = touristRepository.findById(id);
        if (!optionalTourist.isPresent()) {
            throw new RecordNotFoundException(ConstantUtils.RECORD_DOES_NOT_EXIST);
        }
        //deleting the record by id
        touristRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Tourist> fetchTouristById(Long id) throws RecordNotFoundException {
        //search for the record
        Optional<Tourist> tourist = touristRepository.findById(id);
        if (!tourist.isPresent()) {
            throw new RecordNotFoundException(ConstantUtils.RECORD_DOES_NOT_EXIST);
        }
        return new ResponseEntity<>(tourist.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Tourist>> fetchTouristByName(String name) throws RecordNotFoundException {
        // searching the by name by using the custom jpa method call
        List<Tourist> touristList = touristRepository.findByName(name);
        if (CollectionUtils.isEmpty(touristList)) {
            throw new RecordNotFoundException(ConstantUtils.RECORD_DOES_NOT_EXIST);
        }
        return new ResponseEntity<>(touristList, HttpStatus.OK);
    }
}
