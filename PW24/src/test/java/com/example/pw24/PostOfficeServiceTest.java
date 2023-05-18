package com.example.pw24;

import com.example.pw24.Repos.PostOfficeRepo;
import com.example.pw24.Services.PostOfficeService;
import com.example.pw24.Tables.PostOffice;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class PostOfficeServiceTest {
    @Mock
    private PostOfficeRepo postOfficeRepo;
    private PostOfficeService postOfficeService;

    @BeforeEach
    void init() {
        this.postOfficeService = new PostOfficeService(postOfficeRepo);
    }

    @Test
    void createEntity() {
        PostOffice postOffice = new PostOffice();
        postOffice.setOfficeName("office999");
        postOffice.setCityName("NY");

        postOfficeService.createEntity(postOffice);

        ArgumentCaptor<PostOffice> officeArgumentCaptor = ArgumentCaptor.forClass(PostOffice.class);

        Mockito.verify(postOfficeRepo).save(officeArgumentCaptor.capture());

        PostOffice officeArgumentCaptorValue = officeArgumentCaptor.getValue();
        assertEquals("office999", officeArgumentCaptorValue.getOfficeName());
        assertEquals("NY", officeArgumentCaptorValue.getCityName());

    }
    @Test
    void readAllEntity() {
        PostOffice postOffice1 = new PostOffice();
        PostOffice postOffice2 = new PostOffice();
        postOffice1.setOfficeName("office1");
        postOffice1.setCityName("St. Petersburg");
        postOffice2.setOfficeName("office2");
        postOffice2.setCityName("Berlin");

        Mockito.when(postOfficeRepo.findAll()).thenReturn(List.of(postOffice1, postOffice2));

        List<PostOffice> expectedOffices = postOfficeService.readAllEntity();

        Mockito.verify(postOfficeRepo).findAll();
        assertNotEquals(null, expectedOffices);
        assertEquals(2, expectedOffices.size());
        assertEquals("office1", expectedOffices.get(0).getOfficeName());
        assertEquals("Berlin", expectedOffices.get(1).getCityName());
    }
}
