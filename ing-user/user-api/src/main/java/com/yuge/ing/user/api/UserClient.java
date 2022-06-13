package com.yuge.ing.user.api;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.user.common.param.UserRecordParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: yuge
 * @date: 2021-05-08
 **/
@FeignClient(value = "ing-user", contextId = "user")
public interface UserClient {

}
