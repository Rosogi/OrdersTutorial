package com.rosogisoft.loginverification;

import com.rosogisoft.loginverification.services.OrderBusinessService;
import com.rosogisoft.loginverification.services.OrderBusinessService2;
import com.rosogisoft.loginverification.services.OrderBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean(name = "OrderBusinessService")
    public OrderBusinessServiceInterface getOrdersBusiness(){
        return new OrderBusinessService2();
    }
}
