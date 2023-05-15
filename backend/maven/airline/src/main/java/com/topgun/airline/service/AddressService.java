package com.topgun.airline.service;

import com.topgun.airline.domain.address.Address;
import com.topgun.airline.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address saveAdress( Address address){
        Address addressPersisted =addressRepository.save(address);
        return addressPersisted;
    }

    public Address findById(Long id){
        Optional<Address> adress = addressRepository.findById(id);
        if(adress.isPresent()){
            return new Address(adress.get());
        }
        return null;
    }

    public List<Address> allAddresses(){
        List<Address> addresses = addressRepository.findAllByAtivoTrue();
        return addresses;
    }

    public Address updateAddress(Address newAddress, Long id){
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            Address address = addressOptional.get();
            address.setZipCode(newAddress.getZipCode());
            address.setCountry((newAddress.getCountry()));
            address.setUser((newAddress.getUser()));
            address.setNumber(newAddress.getNumber());
            address.setActive(newAddress.isActive());
            addressRepository.save(newAddress);
            return address;
        }
        return null;
    }

    public Address deactivateAdress(Long id){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isPresent()){
            Address adress = optionalAddress.get();
            adress.deactivate();
            addressRepository.save(adress);
            return adress;
        }
        return null;
    }





}
