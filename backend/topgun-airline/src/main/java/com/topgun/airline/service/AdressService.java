package com.topgun.airline.service;

import com.topgun.airline.domain.Adress;
import com.topgun.airline.domain.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    public Adress saveAdress(Adress newAdress){
        return adressRepository.save(newAdress);
    }

    public Adress getAdressById(Long id){
        Optional<Adress> optionalAdress = adressRepository.findById(id);
        return optionalAdress.orElse(null);
    }

    public List<Adress> allAdresses(){
        return adressRepository.findAllByActiveTrue();
    }

    public Adress updateAdress(Long id, Adress inputAdress){
        Optional<Adress> optionalAdress = adressRepository.findById(id);
        if(optionalAdress.isPresent()){
            Adress updatedAdress = optionalAdress.get();
            updatedAdress.setCountry(inputAdress.getCountry());
            updatedAdress.setUser(inputAdress.getUser());
            updatedAdress.setNumber(inputAdress.getNumber());
            updatedAdress.setZipCode(inputAdress.getZipCode());
            adressRepository.save(inputAdress);
            return updatedAdress;
        }
        return null;
    }

    public Adress deleteAdress(Long id){
        Optional<Adress> optionalAdress = adressRepository.findById(id);
        if(optionalAdress.isPresent()){
            Adress adress = optionalAdress.get();
            adress.deactivateAdress();
            return adressRepository.save(adress);
        }
        return null;
    }
}
