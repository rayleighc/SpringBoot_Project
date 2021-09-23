package org.generation.WebProject.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@Configuration
public class MvcConfig implements WebMvcConfigurer {



    //to configure Spring MVC and set up view controllers to expose these templates and static folders
    //e.g. HTMLs, CSS/Images/JS folders
    public void addViewControllers(ViewControllerRegistry registry) {
        //Map the browser's URL to a specific View (HTML) inside resources/templates directory
        registry.addViewController("/").setViewName("todolist");
        registry.addViewController("/todolist").setViewName("todolist");
        registry.addViewController("/todolistform").setViewName("todolistform");
    }







}
