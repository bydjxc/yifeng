package com.yifeng.yfcore.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yifeng.yfcore.common.ReturnCode;
import com.yifeng.yfcore.exception.ParamException;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * @Author: Kevin
 * @Description: bean验证器<br>
 * @Date Created in 14:24 2019/4/2
 * @Modified By
 * @Version 1.0
 */
public class BeanValidator {
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public static <T> Map<String, String> validate(T t, Class ... groups){
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> validate = validator.validate(t, groups);
        if (validate.isEmpty()){
            return Collections.emptyMap();
        }else {
            LinkedHashMap<String, String> map = Maps.newLinkedHashMap();
            Iterator<ConstraintViolation<T>> iterator = validate.iterator();
            while (iterator.hasNext()){
                ConstraintViolation<T> validation = iterator.next();
                // validation.getPropertyPath().toString()字段名称 validation.getMessage()错误信息
                map.put(validation.getPropertyPath().toString(), validation.getMessage());
            }
            return map;
        }
    }

    public static Map<String, String> validateList(Collection<?> collection){
        Preconditions.checkNotNull(collection);
        Iterator<?> iterator = collection.iterator();
        Map<String, String> map;
        do {
            if (!iterator.hasNext()){
                return Collections.emptyMap();
            }
            Object next = iterator.next();
            map = validate(next, new Class[0]);
        } while (map.isEmpty());
        return map;
    }

    public static Map<String, String> validateObject(Object first, Object ... objects){
        if (objects != null && objects.length > 0){
            return validateList(Lists.asList(first, objects));
        }else {
            return validate(first, new Class[0]);
        }
    }

    public static void check(Object param) throws ParamException{
        Map<String, String> map = BeanValidator.validateObject(param);
        if (MapUtils.isNotEmpty(map)){
            throw new ParamException(map.toString(), ReturnCode.PARAM.getCode());
        }
    }
}
