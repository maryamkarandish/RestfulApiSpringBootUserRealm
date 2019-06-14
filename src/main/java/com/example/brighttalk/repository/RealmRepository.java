package com.example.brighttalk.repository;

import com.example.brighttalk.model.Realm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by m.karandish on 6/13/2019.
 */
@Repository
public interface RealmRepository extends JpaRepository<Realm, Long> {
}
