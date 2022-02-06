package com.example.salesdashboard.services;

import com.example.salesdashboard.dto.SaleDTO;
import com.example.salesdashboard.entities.Sale;
import com.example.salesdashboard.repositories.SaleRepository;
import com.example.salesdashboard.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll(); //JPA will keep these sellers in cache, so it will not be called many times
        Page<Sale> result = repository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }

    @Transactional(readOnly = true)
    public SaleDTO findById(Long id){
        Sale sale = repository.findById(id).get();
        SaleDTO saleDTO = new SaleDTO(sale);
        return saleDTO;
    }


}
