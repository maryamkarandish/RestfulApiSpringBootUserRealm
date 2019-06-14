package com.example.brighttalk.controller;

import com.example.brighttalk.exception.DuplicateRealmNameException;
import com.example.brighttalk.exception.InvalidArgumentException;
import com.example.brighttalk.exception.InvalidRealmNameException;
import com.example.brighttalk.exception.RealmNotFoundException;
import com.example.brighttalk.model.Realm;
import com.example.brighttalk.service.RealmService;
import com.example.brighttalk.web.RealmDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import lombok.extern.slf4j.Slf4j;

/**
 * Created by m.karandish on 6/13/2019.
 */
@RunWith(Parameterized.class)
@WebMvcTest
public class RealmApiControllerTest {

    private final String REALM_URL = "/service/user/realm/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RealmService realmService;

    @ClassRule
    public static final SpringClassRule SCR = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    private MediaType mediaType;

    public RealmApiControllerTest(MediaType mediaType) {
        this.mediaType = mediaType;
    }
    Realm realmTest;
    @Before
    public void init(){
         realmTest = new Realm("name_Test", "description_Test", "key_Test");

    }
    @Parameterized.Parameters
    public static List<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {MediaType.APPLICATION_JSON},
                {MediaType.parseMediaType("application/xml; charset=utf-8")},
        });
    }


    private RealmDto createRealmDto(String id) {
        return new RealmDto("name_" + id, "descriptionTest");
    }

    private Realm createRealm(String id) {
        Realm realm = new Realm("name_" + id, "descriptionTest", "key_" + id);
        realm.setId(Long.valueOf(id));
        return realm;
    }

    private String createRequestBody(final Object obj) {
        try {
            return getObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ObjectMapper getObjectMapper() {
        if (MediaType.APPLICATION_JSON.equals(mediaType)) {
            return new ObjectMapper();
        } else {
            return new XmlMapper();
        }
    }

    @Test
    public void getRealmWithValidId() throws Exception {
        String id = "5965";
        Realm mockRealm = createRealm(id);
        given(realmService.get(id)).willReturn(mockRealm);


        String response = mockMvc.perform(get(REALM_URL + id)
                .contentType(mediaType)
                .accept(mediaType))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertThat(response).contains(mockRealm.getId().toString()).contains(mockRealm.getName())
                .contains(mockRealm.getDescription()).contains(mockRealm.getKey());
    }

    @Test
    public void getValidIdAndReturnRealm2() throws Exception {
        String id = "5964";
        Realm mockRealm = createRealm(id);
        given(realmService.get(id)).willReturn(mockRealm);

        String response = mockMvc.perform(get(REALM_URL + id)
                .contentType(mediaType)
                .accept(mediaType))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertThat(response).contains(mockRealm.getId().toString()).contains(mockRealm.getName())
                .contains(mockRealm.getDescription()).contains(mockRealm.getKey());
    }



    @Test
    public void saveRealm() throws Exception {
        String id = "5963";
        RealmDto realmDto = createRealmDto(id);
        Realm mockRealm = createRealm(id);
        given(realmService.save(realmDto)).willReturn(mockRealm);

        mockMvc.perform(post(REALM_URL)
                .content(createRequestBody(realmDto))
                .accept(mediaType)
                .contentType(mediaType))
                .andExpect(status().isCreated());
    }

    @Test
    public void getInvalidArgumentError() throws Exception {

        String id = "5360";
        given(realmService.get(id)).willThrow(InvalidArgumentException.class);

        try{
            mockMvc.perform(get(REALM_URL + id)
                    .header("host", "localhost:8080")
                    .contentType(mediaType)
                    .accept(mediaType))
                    .andExpect(status().isNotFound())
                    .andReturn().getResponse().getContentAsString();
        } catch (NestedServletException e) {
            assertThat(e.getCause().getClass()).isEqualTo(InvalidArgumentException.class);
        }
    }

   @Test
    public void saveWithNullNameReturnInvalidRealmNameError() throws Exception {
        String id = "5969";
        RealmDto realmDto = new RealmDto(null, "descriptionTest" + id);
        given(realmService.save(realmDto)).willThrow(InvalidRealmNameException.class);
         mockMvc.perform(post(REALM_URL)
                .content(createRequestBody(realmDto))
                .accept(mediaType)
                .contentType(mediaType))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void saveAndReturnDescriptionError() throws Exception {

        String id = "5961";
        String description = "this is a test description for more than 255 charachter:"+
                "Assertion is a statement in java. It can be used to test your " +
                "assumptions about the program. While executing assertion, it is believed"+
                "to be true. If it fails, JVM will throw an error named AssertionError."+
                "It is mainly used for testing purpose.";
        RealmDto realmDto = new RealmDto(null, description);
        given(realmService.save(realmDto)).willThrow(IllegalArgumentException.class);

        mockMvc.perform(post(REALM_URL)
                .content(createRequestBody(realmDto))
                .accept(mediaType)
                .contentType(mediaType))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
    }


    @Test
    public void getRealmNotFoundError() throws Exception {

        String id = "5961";
        given(realmService.get(id)).willThrow(RealmNotFoundException.class);
        try {
            mockMvc.perform(get(REALM_URL + id)
                    .contentType(mediaType)
                    .accept(mediaType))
                    .andExpect(status().isBadRequest())
                    .andReturn().getResponse().getContentAsString();
        } catch (NestedServletException e) {
            assertThat(e.getCause().getClass()).isEqualTo(RealmNotFoundException.class);
        }
    }
}
