package com.rosogisoft.loginverification;

import com.rosogisoft.loginverification.services.OrderBusinessService;
import com.rosogisoft.loginverification.services.OrderBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class SpringConfig {
    @Bean(name = "OrderBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public OrderBusinessServiceInterface getOrdersBusiness(){
        return new OrderBusinessService();
    }
}
