package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Prescription")
public class Controller {
    @Autowired Service service;
    @PostMapping()
    public Prescription create( @RequestBody() PrescriptionDTO prescriptionDTO){
        return service.create(prescriptionDTO);
    }

    @GetMapping("/{id}")
    public Iterable<Prescription> allPrescrpitions(){
        return service.allPrescriptions();

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
