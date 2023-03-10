package com.example.demo.controller;

import com.example.demo.Repository.PrescriptionRepository;
import com.example.demo.dto.SchemaDTO;
import com.example.demo.model.Schema;
import com.example.demo.service.Service;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schema")
@RequiredArgsConstructor
public class SchemaController {

    @NonNull
    private final PrescriptionRepository prescriptionRepository;
    @NonNull
    private final Service service;

    @PostMapping("")
    public Schema create(@RequestBody() SchemaDTO schemaDTO){

        return service.createSchema(schemaDTO);
    }

    @GetMapping("")
    public Iterable<Schema> allPrescrpitions(){


        return service.allSchemas();


    }
    @DeleteMapping("{id}")
    public void delete( @PathVariable Long id){
        service.deleteSchema(id);
    }

    @PutMapping("/{id}")
    public Schema update(@PathVariable Long id, @RequestBody SchemaDTO schemaDTO) {

        return service.updateSchema(id,schemaDTO);
    }


}
