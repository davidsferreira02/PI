package com.example.Prescription.controller;

import com.example.Prescription.Repository.PrescriptionRepository;
import com.example.Prescription.Schema.Schema;
import com.example.Prescription.dto.SchemaDTO;
import com.example.Prescription.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/schema")


public class SchemaController {








        @Autowired
        PrescriptionRepository schemaRepository;
        @Autowired
        Service service;
        @PostMapping()
        public Schema create(@RequestBody() SchemaDTO schemaDTO){

            return service.create(schemaDTO);
        }

        @GetMapping()
        public ResponseEntity allPrescrpitions(Model model){


            return ResponseEntity.ok(this.schemaRepository.findAll());


        }
        @DeleteMapping("{id}")
        public void delete( @PathVariable Long id){
            service.delete(id);
        }

        @PutMapping("/{id}")
        public Schema update(@PathVariable Long id, @RequestBody SchemaDTO schemaDTO) {

            return service.update(id,schemaDTO);
        }




    }

