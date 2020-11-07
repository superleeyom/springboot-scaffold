## 简单介绍

一个最最最最最基础的，且轻量的 springboot 脚手架，依赖越少越好，可以完成最最最基本的 crud，其他的组件集成可以在此基础上自由发挥，框架组成：

- `spring boot`：
    - `spring-boot-starter-web`：web 组件
    - `spring-boot-starter-test`： 单元测试组件
- `mybatis plus`：ORM框架，比通用 Mapper 好用
- `hutool-all`：小而全的 Java 工具类库
- `javamelody-spring-boot-starter`：监控器，打印 http 请求 url，响应时间
- `lombok`：Java 实用工具，必备插件
- `validator`：参数校验相关的注解

## 如何使用

创建一个名称为：`scaffold` 的数据库，执行 sql：

```sql
DROP TABLE IF EXISTS user;
CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);
INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');
```

### 修改 application.yml

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

`application-*.yml`配置文件中，修改数据库配置：

```
# 数据库
spring:
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/scaffold?useUnicode=true&useSSL=true&autoReconnect=true&allowMultiQueries=true
    username: root
    password: root
```

修改dev环境的日志级别目录：
```
# 日志级别
logging:
  level:
    com.leeyom.scaffold.mapper: debug
```

### 修改`MybatisPlusConfig.java`

`MybatisPlusConfig.java`配置中，修改 mapper 的包扫描路径，将`com.leeyom.scaffold.mapper`替换成你自己的 mapper 目录：

```java
@Configuration
@MapperScan(basePackages = {"com.leeyom.scaffold.mapper"})
@EnableTransactionManagement
public class MybatisPlusConfig {
    
    /**
     * 内置插件：接入分页插件、乐观锁插件
     *
     * @return 插件拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // 乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }
}
```

最后访问：[http://127.0.0.1:9380/scaffold/user/selectAll](http://127.0.0.1:9380/scaffold/user/selectAll) 测试下。

## 注意

用 IDEA 启动项目的时候，如果安装了`JRebel mybatisPlus extension`插件，请务必停用此插件，因为此插件不支持最新版本的 `mybatis-plus 3.4.0` 版本，会报`Invalid bound statement (not found)`异常，**插件版本号升级到 0.0.3 后便可以解决此问题**。

## 推荐

IDEA 结合插件 [api-generator](https://github.com/Forgus/api-generator) 可以一键生成接口文档，无代码入侵，虽然 Swagger 也可以，但是需要额外引入相关依赖，同时代码侵入性太强了（需要增加注解）。
