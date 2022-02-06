package com.example.salesdashboard.resources;

import com.example.salesdashboard.dto.SellerDTO;
import com.example.salesdashboard.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerResources {
    @Autowired
    private SellerService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SellerDTO>> findAll() {
        List<SellerDTO> sellerList = service.findAll();
        return ResponseEntity.ok().body(sellerList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SellerDTO> findById(@PathVariable Long id){
        SellerDTO seller = service.findById(id);
        return ResponseEntity.ok().body(seller);
    }
}
