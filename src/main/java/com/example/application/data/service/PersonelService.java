package com.example.application.data.service;

import com.example.application.data.entity.Personel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonelService {
    private PersonelRepository personelRepository;

    public PersonelService(PersonelRepository personelRepository){
        this.personelRepository = personelRepository;
    }

    public List<Personel> getAllPersonels(String stringFilter){
        if (stringFilter == null || stringFilter.isEmpty()){
            return personelRepository.findAll();
        }
        else{
            return personelRepository.search(stringFilter);
        }
    }
}
