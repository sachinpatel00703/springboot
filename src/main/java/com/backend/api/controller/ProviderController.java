package com.backend.api.controller;

import com.backend.api.exception.ResourceNotFoundException;
import com.backend.api.model.Downtime;
import com.backend.api.model.Provider;
import com.backend.api.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping
    public String get(){
        return "Welcome to downtime API!";
    }

    // read all data
    @GetMapping("getall-downtime")
    public List<Provider> getAllProvider(){
        return providerRepository.findAll();
    }

    //create downtime
    @PostMapping("create-downtime")
    public Provider createDowntime(@RequestBody Downtime downtime, @RequestParam(name = "provider_name") String providerName,@RequestParam(name = "flow_name") String flowName){
        Provider provider = new Provider();
        provider.setProviderName(providerName);
        provider.setFlowName(flowName);
        provider.setDownFrom(downtime.getDownFrom());
        provider.setDownTo(downtime.getDownTo());
        return providerRepository.save(provider);
    }

    //delete downtime
    @DeleteMapping("delete-downtime/{id}")
    public ResponseEntity<HttpStatus> deleteProvider(@PathVariable long id){

        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Provider does not exist with id: " + id));

        providerRepository.delete(provider);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    //update downtime with an id

    @PutMapping("update-downtime/{id}")
    public ResponseEntity<Provider> updateProvider(@PathVariable long id,@RequestBody Downtime downtime) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Provider does not exist with id: " + id));

        provider.setDownFrom(downtime.getDownFrom());
        provider.setDownTo(downtime.getDownTo());
        providerRepository.save(provider);

        return ResponseEntity.ok(provider);
    }
}
