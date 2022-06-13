package com.yuge.ing.user.server.controller;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.user.common.api.UserRecordApi;
import com.yuge.ing.user.common.dto.UserRecordDTO;
import com.yuge.ing.user.common.param.UserRecordParam;
import com.yuge.ing.user.server.po.UserRecordEntity;
import com.yuge.ing.user.server.service.UserRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.yuge.cloud.web.core.controller.BaseController;

import java.security.SecureRandom;
import java.util.Random;

/**
 * <p>
 * 账号 前端控制器
 * </p>
 *
 * @author yuge
 * @since 2021-05-18
 */
@Slf4j
@RestController
@RequestMapping("/userRecord")
public class UserRecordController extends BaseController implements UserRecordApi {

    @Autowired
    private UserRecordService userRecordService;

    @PostMapping("/ribbon")
    public CommonResponse addForRibbon(@RequestBody UserRecordParam userRecordParam) {
        try {
            SecureRandom secureRandom = new SecureRandom();
            int cost = secureRandom.nextInt(1) + 5;
            cost *= 1000;
            log.info("addForRibbon remark : {}, cost: {} ms", userRecordParam.getRemark(), cost);
            Thread.sleep(cost);
        } catch (InterruptedException e) {
        }
        userRecordService.add(userRecordParam);
        return CommonResponse.success(true);
    }

    @GetMapping("/ribbon/{id}")
    public CommonResponse<UserRecordDTO> getForRibbon(@PathVariable("id") Long id) {
        try {
            SecureRandom secureRandom = new SecureRandom();
            int cost = secureRandom.nextInt(1) + 5;
            cost *= 1000;
            log.info("getForRibbon id : {}, cost: {} ms", id, cost);
            Thread.sleep(cost);
        } catch (InterruptedException e) {
        }
        UserRecordEntity entity = userRecordService.getById(id);
        if (entity == null) {
            return CommonResponse.success(null);
        }
        // 通过Map转换
        UserRecordDTO dto = new UserRecordDTO();
        BeanUtils.copyProperties(entity, dto);
        return CommonResponse.success(dto);
    }

}

