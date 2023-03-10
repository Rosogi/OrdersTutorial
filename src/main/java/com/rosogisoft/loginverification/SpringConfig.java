package com.rosogisoft.loginverification;

import com.rosogisoft.loginverification.services.OrderBusinessService;
import com.rosogisoft.loginverification.services.OrderBusinessService2;
import com.rosogisoft.loginverification.services.OrderBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class SpringConfig {
    @Bean(name = "OrderBusinessService2", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public OrderBusinessServiceInterface getOrdersBusiness(){
        return new OrderBusinessService2();
    }
}
