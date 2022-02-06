package com.example.salesdashboard.services;

import com.example.salesdashboard.dto.SaleDTO;
import com.example.salesdashboard.entities.Sale;
import com.example.salesdashboard.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;

    public List<SaleDTO> findAll() {
        List<Sale> result = repository.findAll();
        return result.stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
    }

    public SaleDTO findById(Long id){
        Sale sale = repository.findById(id).get();
        SaleDTO saleDTO = new SaleDTO(sale);
        return saleDTO;
    }


}
