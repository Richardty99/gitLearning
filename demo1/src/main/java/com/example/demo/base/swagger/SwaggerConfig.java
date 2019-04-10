package com.example.demo.base.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: HX001
 * @Date: 2019/4/9 09:35
 * @Description:
 * swagger 配置文档 参考https://www.jianshu.com/p/dcaff30f91cc?tdsourcetag=s_pctim_aiomsg
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     * responseMessages：全局配置responseModel 参考https://www.jianshu.com/p/4539e312ce87
     * @return
     */
    public Docket createRestApi(){
        List<ResponseMessage> responseMessages=new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder().code(404).message("找不到资源").responseModel(new ModelRef("RequestModel")).build());
        responseMessages.add(new ResponseMessageBuilder().code(422).message("参数校验异常").responseModel(new ModelRef("RequestModel")).build());
        responseMessages.add(new ResponseMessageBuilder().code(401).message("权限不足").responseModel(new ModelRef("RequestModel")).build());
        responseMessages.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("RequestModel")).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.example.demo.controller"
                ))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * http://项目实际地址/doc.html
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Richard.demo")
                .description("Swagger测试文档")
                .termsOfServiceUrl("http://www.baidu.com")
                .version("1.0")
                .build();
    }
}
