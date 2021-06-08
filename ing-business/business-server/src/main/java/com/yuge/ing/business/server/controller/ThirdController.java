package com.yuge.ing.business.server.controller;

import com.github.rholder.retry.*;
import com.yuge.ing.business.server.thirdparty.ManualFeignClient;
import com.yuge.ing.business.server.thirdparty.ThirdOtherService;
import com.yuge.ing.business.server.thirdparty.ThirdUserService;
import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.commons.retry.CommonRetryListener;
import com.yuge.ing.user.common.param.UserRecordParam;
import feign.FeignException;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private ManualFeignClient manualFeignClient;

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

    @PostMapping("/other/2")
    public CommonResponse addOther2(@RequestBody UserRecordParam userRecordParam) {
        userRecordParam.setRemark(LocalDate.now().toString());
        Retryer retryer = RetryerBuilder.newBuilder()
                .retryIfExceptionOfType(FeignException.class)
                .retryIfRuntimeException()
                // 可通过异常，避免判断结果
                // 哪种更优雅，需要实践
                .retryIfResult(result -> {
                    if (result instanceof CommonResponse) {
                        return !((CommonResponse) result).isSuccess();
                    }
                    return false;
                })
                .withWaitStrategy(WaitStrategies.fixedWait(10, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .withRetryListener(new CommonRetryListener("thirdOtherService.add2"))
                .build();
        try {
            CommonResponse response = (CommonResponse) retryer.call(() -> thirdOtherService.add2(userRecordParam));
        } catch (Exception e) {
            log.error("add2 error!", e);
        }
        return CommonResponse.success(true);
    }

    @PostMapping("/manual/2")
    public CommonResponse addManual2(@RequestBody UserRecordParam userRecordParam) {
        userRecordParam.setRemark(LocalDate.now().toString());
        CommonResponse response = manualFeignClient.add2(userRecordParam);
        return CommonResponse.success(true);
    }

    @PostMapping("/3")
    public CommonResponse add3(@RequestBody UserRecordParam userRecordParam) {
        userRecordParam.setRemark(LocalDate.now().toString());
        ResponseEntity<CommonResponse> response = thirdUserService.add3(userRecordParam);
        return CommonResponse.success(true);
    }


}
