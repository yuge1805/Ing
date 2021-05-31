package com.yuge.ing.business.server.thirdparty;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.user.common.param.UserRecordParam;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: yuge
 * @date: 2021-05-21
 **/
@FeignClient(name = "thirdUser", contextId = "thirdUserService", url = "http://127.0.0.1:18080", path = "/user", configuration = ThirdUserConfiguration.class)
public interface ThirdUserService {

    @PostMapping("/userRecord/")
    Response add(@RequestBody UserRecordParam userRecordParam);

    @PostMapping("/userRecord/")
    CommonResponse add2(@RequestBody UserRecordParam userRecordParam);

    @PostMapping("/userRecord/")
    ResponseEntity<CommonResponse> add3(@RequestBody UserRecordParam userRecordParam);

}
