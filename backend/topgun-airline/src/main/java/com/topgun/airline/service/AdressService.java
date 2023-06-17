package com.topgun.airline.service;

import com.topgun.airline.domain.adress.Address;
import com.topgun.airline.domain.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    public Address saveAdress(Address newAddress){
        return adressRepository.save(newAddress);
    }

    public Address getAdressById(Long id){
        Optional<Address> optionalAdress = adressRepository.findById(id);
        return optionalAdress.orElse(null);
    }

    public List<Address> allAdresses(){
        return adressRepository.findAllByActiveTrue();
    }

    public Address updateAdress(Long id, Address inputAddress){
        Optional<Address> optionalAddress = adressRepository.findById(id);
        if(optionalAddress.isPresent()){
            Address updatedAddress = optionalAddress.get();
            if(inputAddress.getCountry() != null){
                updatedAddress.setCountry(inputAddress.getCountry());
            }
            if(inputAddress.getUser() != null){
                updatedAddress.setUser(inputAddress.getUser());
            }
            if(inputAddress.getNumber() != null){
                updatedAddress.setNumber(inputAddress.getNumber());
            }
            if(inputAddress.getZipCode() != null){
                updatedAddress.setZipCode(inputAddress.getZipCode());
            }

            adressRepository.save(updatedAddress);
            return updatedAddress;
        }
        return null;
    }

    public Address deleteAdress(Long id){
        Optional<Address> optionalAddress = adressRepository.findById(id);
        if(optionalAddress.isPresent()){
            Address address = optionalAddress.get();
            address.setActive(false);
            return adressRepository.save(address);
        }
        return null;
    }
}
