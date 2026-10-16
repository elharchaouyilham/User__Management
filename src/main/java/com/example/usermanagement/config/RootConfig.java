
package com.example.usermanagement.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "com.example.usermanagement.service",
        "com.example.usermanagement.mapper"
})
@Import(PersistenceConfig.class)
public class RootConfig {
}
