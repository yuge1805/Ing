package com.yuge.ing.business.server.controller;

import com.yuge.ing.business.server.thirdparty.ThirdOtherService;
import com.yuge.ing.business.server.thirdparty.ThirdUserService;
import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.user.common.param.UserRecordParam;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @author: yuge
 * @date: 2021-05-21
 **/
@Slf4j
@RestController
@RequestMapping("/third")
public class ThirdController {

    @Autowired
    private ThirdUserService thirdUserService;

    @Autowired
    private ThirdOtherService thirdOtherService;

    @PostMapping("/1")
    public CommonResponse add(@RequestBody UserRecordParam userRecordParam) {
        userRecordParam.setRemark(LocalDate.now().toString());
        Response response = thirdUserService.add(userRecordParam);
        return CommonResponse.success(true);
    }

    @PostMapping("/other/1")
    public CommonResponse addOther(@RequestBody UserRecordParam userRecordParam) {
        userRecordParam.setRemark(LocalDate.now().toString());
        Response response = thirdOtherService.add(userRecordParam);
        return CommonResponse.success(true);
    }

    @PostMapping("/2")
    public CommonResponse add2(@RequestBody UserRecordParam userRecordParam) {
        userRecordParam.setRemark(LocalDate.now().toString());
        CommonResponse response = thirdUserService.add2(userRecordParam);
        return CommonResponse.success(true);
    }

    @PostMapping("/3")
    public CommonResponse add3(@RequestBody UserRecordParam userRecordParam) {
        userRecordParam.setRemark(LocalDate.now().toString());
        ResponseEntity<CommonResponse> response = thirdUserService.add3(userRecordParam);
        return CommonResponse.success(true);
    }


}
