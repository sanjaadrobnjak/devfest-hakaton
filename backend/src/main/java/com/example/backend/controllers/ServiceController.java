package com.example.backend.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.db.ServiceRepo;
import com.example.backend.models.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {
    @GetMapping("/getAllServices")
    public ArrayList<Service> getAllServices() {
        return new ServiceRepo().getAllServices();
    }

    @PostMapping("/getService")
    public Service getService(@RequestBody Service service) {
        return new ServiceRepo().getService(service.getId());
    }
    
    @PostMapping("/createService")
    public int createService(@RequestBody Service service) {
        return new ServiceRepo().createService(service);
    }

    @PostMapping("/removeService")
    public int removeService(@RequestBody Service service) {
        return new ServiceRepo().removeService(service);
    }

    @PostMapping("/pickService")
    public int pickService(@RequestBody Service service) {
        return new ServiceRepo().pickService(service);
    }
    
}
