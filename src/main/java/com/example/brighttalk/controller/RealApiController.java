package com.example.brighttalk.controller;

import com.example.brighttalk.exception.DuplicateRealmNameException;
import com.example.brighttalk.exception.InvalidArgumentException;
import com.example.brighttalk.exception.InvalidRealmNameException;
import com.example.brighttalk.exception.RealmNotFoundException;
import com.example.brighttalk.model.Realm;
import com.example.brighttalk.service.RealmService;
import com.example.brighttalk.web.RealmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by m.karandish on 6/13/2019.
 */
@RestController
@RequestMapping(value = "/service/user/realm")
public class RealApiController {
    @Autowired
    private RealmService realmService;


    /**
     * This service get realm user based on specific id
     * @param id
     * @return
     * @throws RealmNotFoundException
     * @throws InvalidArgumentException
     */
    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK )
    public Realm get(@PathVariable("id") String id) throws RealmNotFoundException, InvalidArgumentException {
        return realmService.get(id);
    }

    /**
     * This service create a new realm and save it to database
     * @param realmDto
     * @return
     * @throws DuplicateRealmNameException
     * @throws InvalidRealmNameException
     */
    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public Realm save(@RequestBody @Valid RealmDto realmDto) throws DuplicateRealmNameException, InvalidRealmNameException {
        return realmService.save(realmDto);
    }
}
