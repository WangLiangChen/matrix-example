package com.sintrue.matrix.example.test;

import com.sintrue.matrix.example.dao.entity.ExampleSettings;
import com.sintrue.matrix.example.service.ExampleService;
import com.sintrue.matrix.example.service.message_pl.ExampleRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ExampleTest {
    @Inject
    private ExampleService service;


    @Test
    public void testInsert() {
        ExampleRequest request = ExampleRequest.newInstance();
        request.setStaffName("wanglc");
        // JSON Field
        ExampleSettings exampleSettings = new ExampleSettings();
        exampleSettings.setGender("MALE");
        exampleSettings.setBirthday(LocalDate.of(2000, 1, 1));
        request.setStaffSettings(exampleSettings);

        this.service.insert(request);
    }

    @Test
    public void testInsertBulk() {
        List<ExampleRequest> requests = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ExampleRequest request = ExampleRequest.newInstance();
            request.setStaffName("wanglc" + i);
            // JSON Field
            ExampleSettings exampleSettings = new ExampleSettings();
            exampleSettings.setGender("MALE");
            exampleSettings.setBirthday(LocalDate.of(2000, 1, 1));
            request.setStaffSettings(exampleSettings);
            requests.add(request);
        }

        this.service.insert(requests);
    }

    @Test
    public void testDelete() {
        this.service.delete(456807060718289601L);
    }
}
