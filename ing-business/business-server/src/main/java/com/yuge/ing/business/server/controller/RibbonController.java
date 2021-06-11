package com.yuge.ing.business.server.controller;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.user.api.UserRecordClient;
import com.yuge.ing.user.common.dto.UserRecordDTO;
import com.yuge.ing.user.common.param.UserRecordParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yuge
 * @date: 2021-06-09
 **/
@Slf4j
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private UserRecordClient userRecordClient;

    /**
     * 测试ribbon retry - get
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CommonResponse<UserRecordDTO> queryUserRecord(@PathVariable("id") Long id) {
        CommonResponse<UserRecordDTO> response = userRecordClient.getForRibbon(System.currentTimeMillis());
        log.info("response result: {}", response.isSuccess());
        return CommonResponse.success(response.getData());
    }

    /**
     * 测试ribbon retry - post
     * @param userRecordParam
     * @return
     */
    @PostMapping
    public CommonResponse addUserRecord(@RequestBody UserRecordParam userRecordParam) {
        userRecordParam.setRemark(System.currentTimeMillis() + "");
        CommonResponse response = userRecordClient.addForRibbon(userRecordParam);
        log.info("response result: {}", response.isSuccess());
        return CommonResponse.success(true);
    }

}
