package com.springboot.centreequestre.controller;

import com.springboot.centreequestre.exception.ResourceNotFoundException;
import com.springboot.centreequestre.model.Reprise;
import com.springboot.centreequestre.repository.RepriseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RepriseController {

    @Autowired
    private RepriseRepository repriseRepository;

    //Get all reprises
    @GetMapping("/reprises")
    public List<Reprise> getReprises(){
        return this.repriseRepository.findAll();
    }

    //Create Reprise
    @PostMapping("/reprises")
    public Reprise addReprise(@Valid @RequestBody Reprise reprise){
        return this.repriseRepository.save(reprise);
    }

    //Afficher une reprise avec un certain id
    @GetMapping("/reprises/{id}")
    public ResponseEntity<Reprise> getRepriseById(@PathVariable(value = "id") Long repriseId)
            throws ResourceNotFoundException {
        Reprise reprise = repriseRepository.findById(repriseId)
                .orElseThrow(() -> new ResourceNotFoundException("Reprise not found for this id :: " + repriseId));
        return ResponseEntity.ok().body(reprise);
    }

    //Modifier une reprise
    @PutMapping("/reprises/{id}")
    public ResponseEntity<Reprise> updateReprise(@PathVariable(value = "id") Long repriseId,
                                           @Valid @RequestBody Reprise repriseDetails) throws ResourceNotFoundException {
        Reprise reprise = repriseRepository.findById(repriseId)
                .orElseThrow(() -> new ResourceNotFoundException("Reprise not found for this id :: " + repriseId));

        reprise.setTitle(repriseDetails.getTitle());
        reprise.setHeure_deb(repriseDetails.getHeure_deb());
        reprise.setHeure_fin(repriseDetails.getHeure_fin());
        reprise.setMax_cavalier(repriseDetails.getMax_cavalier());
        reprise.setNiveau(repriseDetails.getNiveau());

        final Reprise updatedReprise = repriseRepository.save(reprise);
        return ResponseEntity.ok(updatedReprise);
    }

    //Supprimer une reprise
    @DeleteMapping("/reprises/{id}")
    public Map<String, Boolean> deleteReprise(@PathVariable(value = "id") Long repriseId)
            throws ResourceNotFoundException {
        Reprise reprise = repriseRepository.findById(repriseId)
                .orElseThrow(() -> new ResourceNotFoundException("Reprise not found for this id :: " + repriseId));

        repriseRepository.delete(reprise);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
