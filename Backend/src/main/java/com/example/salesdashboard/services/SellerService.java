package com.example.salesdashboard.services;

import com.example.salesdashboard.dto.SellerDTO;
import com.example.salesdashboard.entities.Seller;
import com.example.salesdashboard.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;


    public List<SellerDTO> findAll(){
        List<Seller> result = repository.findAll();
        return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }


    public SellerDTO findById(Long id) {
        Seller seller = repository.findById(id).get();
        SellerDTO sellerDTO = new SellerDTO(seller);
        return sellerDTO;

    }
}
