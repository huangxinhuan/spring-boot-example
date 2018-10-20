package com.example.web.demo;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HandlerMethodReturnValueHandlerProxy implements HandlerMethodReturnValueHandler {


    private HandlerMethodReturnValueHandler proxyObject;

    public HandlerMethodReturnValueHandlerProxy(HandlerMethodReturnValueHandler proxyObject){
        this.proxyObject = proxyObject;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return proxyObject.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {

        Map<String, Object> returnObject = new HashMap<>();
        returnObject.put("timestamp", new Date().getTime());
        if(returnValue instanceof Exception){
            returnObject.put("ret", 0);
            returnObject.put("msg", ((Exception) returnValue).getMessage());
            returnObject.put("data", null);
        }else {
            returnObject.put("ret", 1);
            returnObject.put("msg", "OK");
            returnObject.put("data", returnValue);
        }
        proxyObject.handleReturnValue(returnObject, returnType, mavContainer, webRequest);
    }
}
