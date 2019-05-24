package com.grak.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created on 2019/5/23.
 *  REST 简介
 *  架构约束
 *      统一接口 （Uniform interface）
 *      C/S架构  (Client-Server)
 *      无状态 （状态集中在客户端，http是无状态的）
 *      可缓存（cacheable）
 *      分层系统
 *      按需代码
 *
 *      定义：@Controller 、@RestController(Controller + ResponseBody)
 *      映射：@RequestMapping、@*Mapping(GetMapping、PostMapping、PutMapping、DeleteMapping、PathMapping)
 *      请求：@RequestParam、@RequestHeader、@CookieValue
 *
 *      响应：@ResponseBody、ResponseEntity(内容包括主体和响应头)、ResponseCookie(响应Cookie内容)
 *      拦截：@RestControllerAdvice、HandlerInterceptor(处理方法拦截)
 *      跨域：@CrossOrigin、CorsFilter
 *
 *      处理方法参数解析器：HandlerMethodArgumentResolverComposite
 *      处理方法返回值解析器：HandlerMethodReturnValueHandlerComposite
 *
 * @author hy
 * @since 1.0
 */
@SpringBootApplication
public class ApplicationMain {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationMain.class,args);
    }
}
