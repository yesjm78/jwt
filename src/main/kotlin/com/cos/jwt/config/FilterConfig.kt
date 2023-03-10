package com.cos.jwt.config

import com.cos.jwt.filter.MyFilter1
import com.cos.jwt.filter.MyFilter2
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig {

    @Bean
    fun filter1(): FilterRegistrationBean<MyFilter1> {
        val bean: FilterRegistrationBean<MyFilter1> = FilterRegistrationBean(MyFilter1())
        bean.addUrlPatterns("/*")
        bean.order = 0 // 낮은 번호가 필터중에서 가장 먼저 실행됨
        return bean
    }

    @Bean
    fun filter2(): FilterRegistrationBean<MyFilter2> {
        val bean: FilterRegistrationBean<MyFilter2> = FilterRegistrationBean(MyFilter2())
        bean.addUrlPatterns("/*")
        bean.order = 1 // 낮은 번호가 필터중에서 가장 먼저 실행됨
        return bean
    }

}