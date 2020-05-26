package com.kankan.eureka.listener;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description: 用于监听eureka停机
 * @author: kanfeng
 * @date: 2020-05-11 10:06
 */
@Component
public class EurekaInstanceListener {


    /**
    * @Description 服务下线事件
    * @Author  kanfeng
    * @Date   2020/5/11 10:12
    * @Param
    */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event){
        System.out.println(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
    }

    /**
    * @Description 服务注册事件
    * @Author  kanfeng
    * @Date   2020/5/11 10:14
    * @Param
    */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event){
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println(instanceInfo.getAppName() + "进行注册");
    }

    /**
    * @Description 服务续约事件
    * @Author  kanfeng
    * @Date   2020/5/11 10:14
    * @Param
    */
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event){
        System.out.println(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
    }

    /**
    * @Description Eureka注册中心启动事件
    * @Author  kanfeng
    * @Date   2020/5/11 10:15
    * @Param  
    */
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event){
        System.out.println("注册中心 启动");
    }

    /**
    * @Description 启动事件
    * @Author  kanfeng
    * @Date   2020/5/11 10:15
    * @Param
    */
    @EventListener
    public void listen(EurekaServerStartedEvent event){
        System.out.println("Eureka Server 启动");
    }

}
