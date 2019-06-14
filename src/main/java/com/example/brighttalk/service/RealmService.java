package com.example.brighttalk.service;

import com.example.brighttalk.exception.DuplicateRealmNameException;
import com.example.brighttalk.exception.InvalidArgumentException;
import com.example.brighttalk.exception.InvalidRealmNameException;
import com.example.brighttalk.exception.RealmNotFoundException;
import com.example.brighttalk.model.Realm;
import com.example.brighttalk.repository.RealmRepository;
import com.example.brighttalk.web.RealmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * Created by m.karandish on 6/13/2019.
 */
@Service
public class RealmService {


    @Autowired
    private RealmRepository realmRepository;

    /**
     * this method have tried to fetch a realm based on an Id
     * @param id
     * @return
     */
    public Realm get(final String id) {
        try {
            Long idNumber = Long.valueOf(id);
            return realmRepository.findById(idNumber).orElseThrow(() -> new RealmNotFoundException());
        } catch (NumberFormatException ex) {
            throw new InvalidArgumentException();
        }
    }

    /**
     * This method add a realm to the database after passing the validations
     * @param realmDto
     * @return
     */
    public Realm save(final RealmDto realmDto) {

        // checking the name is not empty
        if (StringUtils.isEmpty(realmDto.getName())) {
            throw new InvalidRealmNameException();
        }
        // checking the name is not null
        if (realmDto.getName()== null) {
            throw new InvalidRealmNameException();
        }

        String key = genereateNewKey(realmDto.getName());
        Realm realm = new Realm(realmDto.getName(), realmDto.getDescription(), key);
        try {
            return realmRepository.save(realm);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRealmNameException();
        }catch (InvalidRealmNameException ex) {
            throw new InvalidRealmNameException();
        }
    }

    /**
     * This method generated new Key to set in the Key field in Realm Entity
     * @param name
     * @return
     */
    public String genereateNewKey(String name) {
        return UUID.randomUUID().toString();
    }
}
