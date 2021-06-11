package com.yuge.ing.user.common.api;

import com.yuge.ing.commons.result.CommonResponse;
import com.yuge.ing.user.common.dto.UserRecordDTO;
import com.yuge.ing.user.common.param.UserRecordParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: yuge
 * @date: 2021-05-18
 **/
public interface UserRecordApi {

    @PostMapping("/ribbon")
    CommonResponse addForRibbon(@RequestBody UserRecordParam userRecordParam);

    @GetMapping("/ribbon/{id}")
    CommonResponse<UserRecordDTO> getForRibbon(@PathVariable("id") Long id);
}
