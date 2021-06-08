package com.yuge.ing.user.server.controller;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.user.common.api.UserRecordApi;
import com.yuge.ing.user.common.param.UserRecordParam;
import com.yuge.ing.user.server.service.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.yuge.cloud.web.core.controller.BaseController;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 账号 前端控制器
 * </p>
 *
 * @author yuge
 * @since 2021-05-18
 */
@RestController
@RequestMapping("/userRecord")
public class UserRecordController extends BaseController implements UserRecordApi {

    @Autowired
    private UserRecordService userRecordService;

    @PostMapping("/1")
    public CommonResponse add(@RequestBody UserRecordParam userRecordParam) {
        userRecordService.add(userRecordParam);
        return CommonResponse.success(true);
    }

}

