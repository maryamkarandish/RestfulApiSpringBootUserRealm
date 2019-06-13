package com.example.brighttalk.service;

import com.example.brighttalk.BrighttalkApplication;
import com.example.brighttalk.exception.DuplicateRealmNameException;
import com.example.brighttalk.exception.InvalidArgumentException;
import com.example.brighttalk.exception.InvalidRealmNameException;
import com.example.brighttalk.exception.RealmNotFoundException;
import com.example.brighttalk.web.RealmDto;
import com.example.brighttalk.model.Realm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by m.karandish on 6/13/2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrighttalkApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RealmServiceTest {

    @Autowired
    private RealmService realmService;

    @Test
    public void getRealmWithValidId() {
        String id = "831";
        RealmDto realmDto = new RealmDto("name_" + id, "description_Test4" );
        Realm realm = assertAndSaveRealm(realmDto, true);

        Realm savedRealm = realmService.get(realm.getId().toString());

        assertThat(savedRealm).isEqualToComparingFieldByFieldRecursively(realm);
    }

    @Test(expected = InvalidArgumentException.class)
    public void getInvalidIdFormatTest() {
        String id = "invalid_number";

        Realm savedRealm = realmService.get(id);
    }

    @Test(expected = RealmNotFoundException.class)
    public void getInvalidIdAndNotFoundError() {
        String id = "68952";

        Realm savedRealm = realmService.get(id);
    }

    @Test
    public void saveRealmTest() {
        String id = "81";
        RealmDto realmDto = new RealmDto("name_" + id, "description_Test5");
        assertAndSaveRealm(realmDto, true);
    }



    @Test(expected = DuplicateRealmNameException.class)
    public void saveWithDuplicateNameTest() {
        String id = "645";
        RealmDto realmDto = new RealmDto("name_" + id, "description_Test6");
        assertAndSaveRealm(realmDto, true);
        assertAndSaveRealm(realmDto, true);
    }

    @Test(expected = InvalidRealmNameException.class)
    public void saveWithInvalidNameTest() {
        RealmDto realmDto = new RealmDto(null, "description_Test7");
        assertAndSaveRealm(realmDto, false);
    }

    private Realm assertAndSaveRealm(RealmDto realmDto, boolean doAssert) {
        Realm realm = realmService.save(realmDto);

        if(doAssert) {
            assertThat(realm.getId()).isNotNull().isGreaterThan(0L);
            assertThat(realm.getName()).isEqualTo(realmDto.getName());
            assertThat(realm.getDescription()).isEqualTo(realmDto.getDescription());
            assertThat(realm.getKey()).isNotEmpty();
        }
        return  realm;
    }
}
