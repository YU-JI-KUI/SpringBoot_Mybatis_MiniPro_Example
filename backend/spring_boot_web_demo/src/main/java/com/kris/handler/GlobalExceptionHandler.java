package com.kris.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 统一异常处理类，由注解 @ControllerAdvice 标识
 * 我们可以使用不同的方法来处理不同的异常信息，一般是每一个 Controller 都有一个自定义异常。
 * 然后我们使用 @ExceptionHandler(Exception.class) 来标识处理不同的异常。
 * @Author Kris
 * @Date 2019/9/6 14:13
 * @Version 1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有继承 Exception 的异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    private Map<String, Object> exceptionHandler(HttpServletRequest request, Exception e) {
        Map<String, Object> modelMap = new HashMap();
        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());
        return modelMap;
    }
}
