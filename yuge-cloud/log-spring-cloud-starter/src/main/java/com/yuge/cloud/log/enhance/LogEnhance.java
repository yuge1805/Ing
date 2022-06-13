package com.yuge.cloud.log.enhance;

/**
 * @author: yuge
 * @date: 2021-05-15
 **/
public interface LogEnhance<T> {

    T enhance(Object param);

}
