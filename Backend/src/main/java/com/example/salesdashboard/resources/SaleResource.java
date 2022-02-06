package com.example.salesdashboard.resources;

import com.example.salesdashboard.dto.SaleDTO;
import com.example.salesdashboard.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource {
    @Autowired
    private SaleService resource;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SaleDTO>> findAll(){
        List<SaleDTO> sale = resource.findAll();
        return ResponseEntity.ok().body(sale);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<SaleDTO> findById(@PathVariable Long id){
        SaleDTO sale = resource.findById(id);
        return ResponseEntity.ok().body(sale);
    }

}
