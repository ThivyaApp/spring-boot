package com.springboot.centreequestre.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.centreequestre.model.Cheval;
import com.springboot.centreequestre.repository.ChevalRepository;
import com.springboot.centreequestre.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
//link : http://localhost:8080/centreequestre/api/v1/horses/1

public class ChevalController {

    @Autowired
    private ChevalRepository chevalRepository;

    //Afficher tous les chevaux
    @GetMapping("/horses")
    public List<Cheval> getAllHorses() {
        return chevalRepository.findAll();
    }

    //Afficher un cheval avec un certain id
    @GetMapping("/horses/{id}")
    public ResponseEntity<Cheval> getHorseById(@PathVariable(value = "id") Long horseId)
            throws ResourceNotFoundException {
        Cheval horse = chevalRepository.findById(horseId)
                .orElseThrow(() -> new ResourceNotFoundException("Horse not found for this id :: " + horseId));
        return ResponseEntity.ok().body(horse);
    }

    //Créer un cheval
    @PostMapping("/horses")
    public Cheval createHorse(@Valid @RequestBody Cheval horse) {
        return chevalRepository.save(horse);
    }

    //Actualiser les données d'un cheval
    @PutMapping("/horses/{id}")
    public ResponseEntity<Cheval> updateHorse(@PathVariable(value = "id") Long horseId,
                                                   @Valid @RequestBody Cheval horseDetails) throws ResourceNotFoundException {
        Cheval horse = chevalRepository.findById(horseId)
                .orElseThrow(() -> new ResourceNotFoundException("Horse not found for this id :: " + horseId));

        horse.setName(horseDetails.getName());
        horse.setType(horseDetails.getType());
        horse.setAge(horseDetails.getAge());
        final Cheval updatedHorse = chevalRepository.save(horse);
        return ResponseEntity.ok(updatedHorse);
    }

    //Supprimer un cheval
    @DeleteMapping("/horses/{id}")
    public Map<String, Boolean> deleteHorse(@PathVariable(value = "id") Long horseId)
            throws ResourceNotFoundException {
        Cheval horse = chevalRepository.findById(horseId)
                .orElseThrow(() -> new ResourceNotFoundException("Horse not found for this id :: " + horseId));

        chevalRepository.delete(horse);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }






}
