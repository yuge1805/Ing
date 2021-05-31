package com.yuge.cloud.log.aspect;

import com.yuge.cloud.log.annotation.Log;
import com.yuge.cloud.log.enhance.LogEnhance;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: yuge
 * @date: 2021-05-15
 **/
@Slf4j
@Aspect
@Component
public class LogAspect implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static final ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    private static final ExpressionParser expressionParser = new SpelExpressionParser();

    @Pointcut("@annotation(com.yuge.cloud.log.annotation.Log)")
    public void logPointCut() {
    }

    @After("logPointCut()")
    public void after(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.asList(args));

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Log annotation = method.getAnnotation(Log.class);
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
        System.out.println(Arrays.asList(parameterNames));

        EvaluationContext evaluationContext = new StandardEvaluationContext();
        for (int i = 0; i < parameterNames.length; i++) {
            evaluationContext.setVariable(parameterNames[i], args[i]);
        }

        // enhance
        if (StringUtils.hasText(annotation.enhanceArgs())) {
            Object argValue = expressionParser.parseExpression(annotation.enhanceArgs()).getValue(evaluationContext);
            LogEnhance logEnhance = applicationContext.getBean(annotation.enhanceClass());
            if (logEnhance == null) {
                System.out.println("null========================");
                return;
            }
            Object enhance = logEnhance.enhance(argValue);
            evaluationContext.setVariable("enhance", enhance);
        }

        if (StringUtils.hasText(annotation.msg())) {
            Object value = expressionParser.parseExpression(annotation.msg()).getValue(evaluationContext);
            System.out.println("================" + value.toString());
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
