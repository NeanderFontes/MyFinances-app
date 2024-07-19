package com.myfinances.myfinances.controller;

import com.myfinances.myfinances.models.MyFinancesModel;
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
    public MyFinancesModel findById(@PathVariable(value = "id") Long id) {
        return myFinancesService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MyFinancesModel> findAll() {
        return myFinancesService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public MyFinancesModel create(@RequestBody MyFinancesModel addEntityModel) {
        return myFinancesService.create(addEntityModel);
    }

    @PutMapping(value = "{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public MyFinancesModel update(@RequestBody MyFinancesModel updateEntityModel) {
        return myFinancesService.update(updateEntityModel);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long deleteEntityModel) {
        myFinancesService.delete(deleteEntityModel);
        return ResponseEntity.noContent().build();
    }
}
