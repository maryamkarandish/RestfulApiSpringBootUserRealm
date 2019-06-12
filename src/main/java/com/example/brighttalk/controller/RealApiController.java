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

/**
 * Created by m.karandish on 6/12/2019.
 */
@RestController
@RequestMapping("/service/user/realm")
public class RealApiController {
    @Autowired
    private RealmService realmService;

    @GetMapping("/{id}")
    @ResponseStatus( HttpStatus.OK )
    public Realm get(@PathVariable("id") String id) throws RealmNotFoundException, InvalidArgumentException {
        return realmService.get(id);
    }

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public Realm save(@RequestBody RealmDto realmDto) throws DuplicateRealmNameException, InvalidRealmNameException {
        return realmService.save(realmDto);
    }
}
