package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.StoreRequestDTO;
import com.Entity.Store;
import com.Repostory.StoreRepository;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public String createStore(StoreRequestDTO requestDTO) {

     

        boolean storeExists = storeRepository.findByStoreCode(requestDTO.getStoreCode()).isPresent();

        if(storeExists)
        {
            return "Store Code Already Exists";
        }



        Store store = new Store();

        store.setStoreName( requestDTO.getStoreName() );

        store.setStoreCode( requestDTO.getStoreCode() );

        store.setOwnerName( requestDTO.getOwnerName());

        store.setPhone( requestDTO.getPhone());

        store.setEmail(requestDTO.getEmail() );

        store.setAddress(requestDTO.getAddress());

        store.setCity( requestDTO.getCity());

        store.setState( requestDTO.getState());

        store.setCountry(requestDTO.getCountry());

        store.setPincode( requestDTO.getPincode());

        store.setStoreType( requestDTO.getStoreType());

        store.setIsActive(true);

        storeRepository.save(store);

        return "Store Created Successfully";
    }

    public List<Store> getAllStores() {

        return storeRepository.findAll();
    }
}