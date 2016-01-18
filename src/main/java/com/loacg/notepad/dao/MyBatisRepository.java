package com.loacg.notepad.dao;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * notepad
 *
 * 标识MyBatis的DAO,方便{@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描
 *
 * Date: 1/18/2016
 * Author: Sendya <yinliangliang@rd.keytop.com.cn>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisRepository {
    String value() default "";
}