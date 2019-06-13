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

    public Realm get(final String id) {
        try {
            Long idNumber = Long.valueOf(id);
            return realmRepository.findById(idNumber).orElseThrow(() -> new RealmNotFoundException());
        } catch (NumberFormatException ex) {
            throw new InvalidArgumentException();
        }
    }

    public Realm save(final RealmDto realmDto) {
        if (StringUtils.isEmpty(realmDto.getName())) {
            throw new InvalidRealmNameException();
        }


        String key = genereateNewKey(realmDto.getName());
        Realm realm = new Realm(realmDto.getName(), realmDto.getDescription(), key);
        try {
            return realmRepository.save(realm);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRealmNameException();
        }
    }

    public String genereateNewKey(String name) {
        return UUID.randomUUID().toString();
    }
}
