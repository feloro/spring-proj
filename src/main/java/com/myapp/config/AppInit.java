package com.myapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by anton.istomin on 28.04.2018.
 */
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[]{ContextLoader.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[]{ContextLoader.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
