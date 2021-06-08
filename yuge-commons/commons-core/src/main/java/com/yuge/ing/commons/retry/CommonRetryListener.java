package com.yuge.ing.commons.retry;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;
import com.yuge.ing.commons.result.CommonResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuge
 * @date: 2021-06-03
 **/
@Slf4j
public class CommonRetryListener implements RetryListener {

    private String caller;

    public CommonRetryListener() {
        this.caller = "";
    }

    public CommonRetryListener(String caller) {
        this.caller = caller;
    }

    public void onRetry(Attempt attempt) {
        if (attempt.hasException()) {
            Throwable throwable = attempt.getExceptionCause();
            if (throwable instanceof FeignException) {
                log.error("{} fail {} times , error: {}, response code: {}, msg: {}", caller, attempt.getAttemptNumber(), throwable.getMessage(),  ((FeignException) throwable).status(), ((FeignException) throwable).contentUTF8());
            } else {
                log.error("{} fail {} times , error: {}", caller, attempt.getAttemptNumber(), attempt.getExceptionCause().getMessage());
            }
        }

        if (attempt.hasResult()) {
            Object result = attempt.getResult();
            if (result instanceof CommonResponse && !((CommonResponse) result).isSuccess()){
                log.error("{} fail {} times , common response: {}", caller, attempt.getAttemptNumber(), result.toString());
            }
        }
    }

}
