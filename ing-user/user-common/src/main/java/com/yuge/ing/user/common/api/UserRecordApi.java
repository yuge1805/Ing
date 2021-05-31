package com.yuge.ing.user.common.api;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.user.common.param.UserRecordParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: yuge
 * @date: 2021-05-18
 **/
public interface UserRecordApi {

    @PostMapping("/")
    CommonResponse add(@RequestBody UserRecordParam userRecordParam);

}
