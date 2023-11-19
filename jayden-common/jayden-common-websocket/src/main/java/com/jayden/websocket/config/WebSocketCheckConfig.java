package com.jayden.websocket.config;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.List;
import java.util.Map;

@Component
// 鉴权拦截使用ServerEndpointConfig.Configurator
public class WebSocketCheckConfig extends ServerEndpointConfig.Configurator {

    /**
     * 重写checkOrigin进行鉴权
     */
    @Override
    public boolean checkOrigin(String originHeaderValue) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        // 校验逻辑
//        request.xxx()
        return true;
    }

    /**
     * 重写modifyHandshake提供可以通过HandshakeRequest的形式拿到WebSocket连接情况
     */
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        // 获取WebSocket的所有请求参数
        Map<String, List<String>> parameterMap = request.getParameterMap();
        // 获取erp相关的参数信息
        List<String> erpList = parameterMap.getOrDefault("erp", null);
        if (!CollectionUtils.isEmpty(erpList)) {
            // 使用ServerEndpointConfig来进行相应的参数传递(此处将erp相关参数信息作为用户参数传递)
            sec.getUserProperties().put("erp", erpList.get(0));
        }
    }

}
