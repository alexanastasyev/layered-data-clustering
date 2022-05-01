package dev.alexanastasyev.nirbackend.controller;

import dev.alexanastasyev.nirbackend.model.CustomerClusteringModel;
import dev.alexanastasyev.nirbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/data")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerClusteringModel>> getCustomerModels() {
        try {
            List<CustomerClusteringModel> clusteringModels = customerService.getCustomerClusteringModels();
            return ResponseEntity.ok(clusteringModels);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(new ArrayList<>());
        }
    }

}