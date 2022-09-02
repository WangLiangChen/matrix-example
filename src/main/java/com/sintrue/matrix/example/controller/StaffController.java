package com.sintrue.matrix.example.controller;

import com.sintrue.matrix.example.service.ExampleService;
import com.sintrue.matrix.example.service.StaffRequest;
import com.sintrue.matrix.example.service.StaffResponse;
import org.springframework.web.bind.annotation.*;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.web.response.FormattedResponse;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-09-02 14:10
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    private final ExampleService exampleService;

    @Inject
    public StaffController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping
    public void add(@RequestBody StaffRequest staffRequest) {
        exampleService.add(staffRequest);
        // {"success":true,"code":"","level":"OFF","message":"","debug":"","requestId":"","payload":{}}
    }

    @PostMapping("/pagination")
    public FormattedResponse pagination(@RequestBody StaffRequest staffRequest) {
        PaginationResult<StaffResponse> pagination = exampleService.pagination(staffRequest);
        return FormattedResponse.success().payload(pagination);
        /*
         {
          "success": true,
          "code": "",
          "level": "OFF",
          "message": "",
          "debug": "",
          "requestId": "",
          "payload": {
            "datas": [
              {
                "staffId": "438292558515316842",
                "staffText": "staff1",
                "createDatetime": "2022-09-02 15:25:22",
                "createDate": "2022-09-02",
                "state": {
                  "state_id": "100"
                }
              }
            ],
            "totalRecords": 1,
            "pageNumber": 1,
            "pageSize": 10
          }
        }
        */
    }

    @PostMapping("/list")
    public FormattedResponse list(@RequestBody StaffRequest staffRequest) {
        List<StaffResponse> list = exampleService.list(staffRequest);
        return FormattedResponse.success().payload(list);
        /*
        {
          "success": true,
          "code": "",
          "level": "OFF",
          "message": "",
          "debug": "",
          "requestId": "",
          "payload": [
            {
              "staffId": "438292558515316842",
              "staffText": "staff1",
              "createDatetime": "2022-09-02 15:25:22",
              "createDate": "2022-09-02",
              "state": {
                "state_id": "100"
              }
            }
          ]
        }
        */
    }

    @GetMapping("/{id}")
    public FormattedResponse find(@PathVariable("id") Long staffId) {
        StaffResponse staffResponse = exampleService.find(staffId);
        return FormattedResponse.success().payload(staffResponse);
        /*
        {
          "success": true,
          "code": "",
          "level": "OFF",
          "message": "",
          "debug": "",
          "requestId": "",
          "payload": {
            "staffId": "438292558515316842",
            "staffText": "staff1",
            "createDatetime": "2022-09-02 15:25:22",
            "createDate": "2022-09-02",
            "state": {
              "state_id": "100"
            }
          }
        }
       */
    }

}
