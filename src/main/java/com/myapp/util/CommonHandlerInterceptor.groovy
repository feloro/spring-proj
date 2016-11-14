package com.myapp.util

import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CommonHandlerInterceptor extends HandlerInterceptorAdapter{

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        if (modelAndView != null && modelAndView.getViewName()!=null && !modelAndView.getViewName().startsWith("redirect:")) {
            modelAndView.getModelMap().addAttribute("contextPath", request.getContextPath());

            String lang = request.getParameter("lang");
            if(lang!=null && !lang.isEmpty()){
                request.getSession().setAttribute("lang", lang);
            }
            if(request.getSession().getAttribute("lang")==null){
                request.getSession().setAttribute("lang", "ru");
            }
            modelAndView.getModelMap().addAttribute("lang", request.getSession().getAttribute("lang").toString());
        }
    }
}