//package com.yangzhao.designPattern.observer.spring;
//
//
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.context.ApplicationEventPublisherAware;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService implements ApplicationEventPublisherAware {
//
//    private ApplicationEventPublisher applicationEventPublisher;
//
//
//    public void send(){
//        applicationEventPublisher.publishEvent(new YangZhaoEvent(this));
//    }
//
//
//    @Override
//    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//        this.applicationEventPublisher = applicationEventPublisher;
//    }
//}
