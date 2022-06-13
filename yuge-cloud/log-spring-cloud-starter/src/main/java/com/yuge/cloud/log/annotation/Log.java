package com.yuge.cloud.log.annotation;

import com.yuge.cloud.log.enhance.DefaultLogEnhance;
import com.yuge.cloud.log.enhance.AbstractLogEnhance;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Log {

    /**
     * msg; 支持SpEL表达式
     *
     * 例：新增#param.name
     *     更新#enhance.name
     *     删除#enhacne.names
     * @return
     */
    String msg() default "";

    /**
     * enhance Args;  支持SpEL表达式
     * @return
     */
    String enhanceArgs() default "";

    /**
     * enhance Class
     *
     * @return
     */
    Class<? extends AbstractLogEnhance> enhanceClass() default DefaultLogEnhance.class;
}
