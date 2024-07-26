package com.myfinances.myfinances.controller;

import com.myfinances.myfinances.dto.MyFinancesDTO;
import com.myfinances.myfinances.services.MyFinancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/myfinances")
public class MyFinancesController {
    @Autowired
    MyFinancesService myFinancesService;

    @GetMapping(value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public MyFinancesDTO findById(@PathVariable(value = "id") Long id) {
        return myFinancesService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MyFinancesDTO> findAll() {
        return myFinancesService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public MyFinancesDTO create(@RequestBody MyFinancesDTO addEntityDTO) {
        return myFinancesService.create(addEntityDTO);
    }

    @PutMapping(value = "{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public MyFinancesDTO update(@RequestBody MyFinancesDTO updateEntityDTO) {
        return myFinancesService.update(updateEntityDTO);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long deleteEntityModel) {
        myFinancesService.delete(deleteEntityModel);
        return ResponseEntity.noContent().build();
    }
}
