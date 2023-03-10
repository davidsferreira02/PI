package com.example.Prescription.controller;






import com.example.Prescription.Repository.PrescriptionRepository;
import com.example.Prescription.dto.PrescriptionDTO;
import com.example.Prescription.model.Prescription;
import com.example.Prescription.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    Service service;
    @PostMapping()
    public Prescription create(@RequestBody() PrescriptionDTO prescriptionDTO){

        return service.create(prescriptionDTO);
    }

    @GetMapping()
    public ResponseEntity allPrescrpitions(Model model){


        return ResponseEntity.ok(this.prescriptionRepository.findAll());


    }
   @DeleteMapping("{id}")
    public void delete( @PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Prescription update(@PathVariable Long id, @RequestBody PrescriptionDTO prescriptionDTO) {

        return service.update(id,prescriptionDTO);
    }




}

