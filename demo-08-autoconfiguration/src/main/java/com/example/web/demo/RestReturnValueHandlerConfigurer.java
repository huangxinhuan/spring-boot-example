package com.example.web.demo;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.Arrays;
import java.util.List;

@Configuration
public class RestReturnValueHandlerConfigurer implements InitializingBean {

    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Override
    public void afterPropertiesSet() throws Exception {

        List<HandlerMethodReturnValueHandler> handlers = handlerAdapter.getReturnValueHandlers();
        if(handlers != null && handlers.size() > 0) {
            HandlerMethodReturnValueHandler[] newHandlers =  new HandlerMethodReturnValueHandler[handlers.size()];
            for (int i = 0; i < handlers.size(); i++) {
                if (handlers.get(i) instanceof RequestResponseBodyMethodProcessor) {
                    newHandlers[i] = new HandlerMethodReturnValueHandlerProxy(handlers.get(i));
                }else {
                    newHandlers[i] = handlers.get(i);
                }

            }
            handlerAdapter.setReturnValueHandlers(Arrays.asList(newHandlers));
        }
    }
}
