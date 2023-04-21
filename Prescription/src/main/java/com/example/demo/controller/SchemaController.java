package com.example.demo.controller;

import com.example.demo.Repository.PrescriptionRepository;
import com.example.demo.dto.SchemaDTO;
import com.example.demo.model.Schema;
import com.example.demo.service.Service;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/schema")
@RequiredArgsConstructor
public class SchemaController {


    @NonNull
    private final Service service;


    @PostMapping("")
    public Schema create(@RequestBody() SchemaDTO schemaDTO) throws IOException {


        return service.createSchema(schemaDTO);
    }

    @GetMapping("")
    public Iterable<Schema> allPrescrpitions() {


        return service.allSchemas();


    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSchema(id);
    }

    @PutMapping(value = "/{id}")
    public Schema update(@PathVariable Long id, @RequestBody SchemaDTO schemaDTO) throws IOException {

        return service.updateSchema(id, schemaDTO);
    }


}
