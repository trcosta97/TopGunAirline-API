package com.topgun.airline.controller;

import com.topgun.airline.domain.address.Address;
import com.topgun.airline.domain.address.AddressDTO;
import com.topgun.airline.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/address")
    public ResponseEntity<Address> persistAddress(@RequestBody AddressDTO data){
        var address = new Address(data);
        addressService.saveAdress(address);
        return ResponseEntity.ok(address);
    }
}
