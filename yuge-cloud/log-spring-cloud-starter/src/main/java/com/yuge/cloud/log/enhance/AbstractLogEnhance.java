package com.yuge.cloud.log.enhance;

/**
 * @author: yuge
 * @date: 2021-05-15
 **/
public abstract class AbstractLogEnhance<T> implements LogEnhance {

    public abstract T enhance(Object param);

}
