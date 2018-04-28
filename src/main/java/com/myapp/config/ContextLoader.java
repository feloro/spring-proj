package com.myapp.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by anton.istomin on 27.04.2018.
 */
@Configuration
@EnableWebMvc
@PropertySource(value = "classpath:config.properties", ignoreResourceNotFound = true)
@ComponentScan({"com.myapp.*"})
@Import({WebSecurity.class, Database.class})
public class ContextLoader {

}
