package com.yuge.ing.user.api;

import com.yuge.ing.user.common.api.UserRecordApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * todo： 验证可行性、专业性后，修正user-api包名为user-client；
 *
 *
 * @author: yuge
 * @date: 2021-05-18
 **/
@FeignClient(value = "ing-user", contextId = "userRecord", path = "/user/userRecord")
public interface UserRecordClient extends UserRecordApi {
}
