package com.example.salesdashboard.resources;

import com.example.salesdashboard.dto.SaleDTO;
import com.example.salesdashboard.dto.SaleSuccessDTO;
import com.example.salesdashboard.dto.SaleSumDTO;
import com.example.salesdashboard.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private SaleService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
        Page<SaleDTO> sale = service.findAll(pageable);
        return ResponseEntity.ok().body(sale);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<SaleDTO> findById(@PathVariable Long id){
        SaleDTO sale = service.findById(id);
        return ResponseEntity.ok().body(sale);
    }

    @RequestMapping(value = "/amount-by-seller",method = RequestMethod.GET)
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
        List<SaleSumDTO> sale = service.amountGroupedBySeller();
        return ResponseEntity.ok().body(sale);
    }

    @RequestMapping(value = "/success-by-seller",method = RequestMethod.GET)
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller(){
        List<SaleSuccessDTO> sale = service.successGroupedBySeller();
        return ResponseEntity.ok().body(sale);
    }


}
