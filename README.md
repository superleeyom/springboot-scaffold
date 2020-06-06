## 简单介绍

一个最最最最最基础的，且轻量的 springboot 脚手架，依赖越少越好，可以完成最最最基本的 crud，其他的组件集成可以在此基础上自由发挥，框架组成：

- `spring boot 2.3`：
    - `spring-boot-starter-web`：web 组件
    - `spring-boot-starter-test`： 单元测试组件
- `mybatis plus 3.3.2`：ORM框架，比通用 Mapper 好用
- `hutool-all 5.3.5`：小而全的 Java 工具类库
- `javamelody-spring-boot-starter`：监控器，打印 http 请求 url，响应时间
- `lombok`：Java 实用工具，必备插件

## 如何使用

套用此脚手架，需要修改几个地方，有些地方我用占位符 `${xxx}` 代替：

`application.yml`：

```
# 默认配置
server:
  port: 9380
  servlet:
    context-path: /${customPath}
spring:
  application:
    name: ${customApplicationName}
  profiles:
    active: dev

# mybatis-plus
mybatis-plus:
  configuration:
    cache-enabled: true
    map-underscore-to-camel-case: true
  global-config:
    db-config:
      id-type: auto
      table-underline: true
  mapper-locations: classpath:mapper/*.xml
  typeAliasesPackage: ${customEntityPackage}
```

- `${customPath}`：自定义服务请求 url 的前缀
- `${customApplicationName}`：自定义服务名称，改成你自己的服务名
- `${customEntityPackage}`：如果你习惯目前的实体包结构，可以改成你自己喜欢的目录结构，这里需要改动一下

`application-*.yml`：

```
# 数据库
spring:
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/scaffold?useUnicode=true&useSSL=true&autoReconnect=true&allowMultiQueries=true
    username: root
    password: root
```
这里都知道，改成你自己的数据库。

`MybatisPlusConfig.java`：

```java
@Configuration
@MapperScan(basePackages = {"com.leeyom.scaffold.mapper"})
@EnableTransactionManagement
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
```

将`com.leeyom.scaffold.mapper`替换成你自己的 mapper 目录。


