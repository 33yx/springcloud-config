# 微服务架构和Springcloud

## 参考网站，官网，笔记

Spring Cloud 学习笔记：
\1. https://blog.csdn.net/u011863024/article/details/114298270
\2. https://blog.csdn.net/u011863024/article/details/114298282
\3. https://blog.csdn.net/u011863024/article/details/114298288

springboot官网：

https://spring.io/projects/spring-cloud





Spring Cloud<->Spring Boot具体版本依赖

    https://spring.io/projects/spring-cloud#overview
    https://start.spring.io/actuator/info

Spring Boot git

    https://github.com/spring-projects/spring-boot

Spring Cloud git

    https://github.com/spring-cloud

Spring Cloud Alibaba git

    https://github.com/alibaba/spring-cloud-alibaba
    版本依赖：https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E

Nacos

    git：https://github.com/alibaba/nacos/wiki
    官网：https://nacos.io/zh-cn/docs/quick-start.html

Sentinel git

    https://github.com/alibaba/Sentinel/wiki
    https://github.com/alibaba/Sentinel/releases/tag/1.8.2

Seata git

    https://github.com/seata/seata/releases


## 01.微服务架构概述

  ![image-20221223151537366](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223151537366.png)

![image-20221223152228525](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223152228525.png)

![image-20221223152834905](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223152834905.png)

主流：

![image-20221223153000780](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223153000780.png)

### 环境配置：

![image-20221223155714008](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223155714008.png)

![image-20221223161922974](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223161922974.png)

![image-20221223162148021](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223162148021.png)

![image-20221223162336594](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223162336594.png)

![image-20221223162352790](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223162352790.png)

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223162404281.png" alt="image-20221223162404281" style="zoom:200%;" />



## 02.微服务架构编码构建

![image-20221223163217484](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223163217484.png)

![image-20221223163349307](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223163349307.png)

### 1.父工程创建

![image-20221223163406948](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223163406948.png)

#### 6.注解生效激活![image-20221223165047820](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223165047820.png)

#### 7.java编译版本选8

![image-20221223165206654](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223165206654.png)



### 二.父工程POM

![image-20221226180316347](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221226180316347.png)

![image-20221223170144507](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223170144507.png)

<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>  

    <groupId>com.lun</groupId>
    <artifactId>LearnCloud</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <packaging>pom</packaging><!-- 这里添加，注意不是jar或war -->
    
    <!-- 统一管理jar包版本 -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <junit.version>4.12</junit.version>
        <log4j.version>1.2.17</log4j.version>
        <lombok.version>1.16.18</lombok.version>
        <mysql.version>5.1.47</mysql.version>
        <druid.version>1.1.16</druid.version>
        <mybatis.spring.boot.version>1.3.0</mybatis.spring.boot.version>
    </properties>
    
    <!-- 子模块继承之后，提供作用：
    	锁定版本+子modlue不用写groupId和version -->
    <dependencyManagement>
        <dependencies>
            <!--spring boot 2.2.2-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.2.2.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!--spring cloud Hoxton.SR1-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Hoxton.SR1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!--spring cloud alibaba 2.1.0.RELEASE-->
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>2.1.0.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
            </dependency>
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid.version}</version>
            </dependency>
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>${mybatis.spring.boot.version}</version>
            </dependency>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>${junit.version}</version>
            </dependency>
            <dependency>
                <groupId>log4j</groupId>
                <artifactId>log4j</artifactId>
                <version>${log4j.version}</version>
            </dependency>
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>${lombok.version}</version>
                <optional>true</optional>
            </dependency>
        </dependencies>
    </dependencyManagement>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <fork>true</fork>
                    <addResources>true</addResources>
                </configuration>
            </plugin>
        </plugins>
    </build>

![image-20221223172324177](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223172324177.png)

![image-20221223172454531](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223172454531.png)

![image-20221223172542970](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223172542970.png)

![image-20221223172637238](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223172637238.png)

![image-20221223172734289](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223172734289.png)

#### 3.构建步骤



![image-20221223173309608](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221223173309608.png)



#### 4.创建子模块

**流程**

1.建moudle

2.改pom

3.写yml

4.主启动

5.业务类

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>LearnCloud</artifactId>
        <groupId>com.lun</groupId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-provider-payment8001</artifactId>
    
    <dependencies>
        <!--包含了sleuth+zipkin-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
        </dependency>
        <!--eureka-client-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
            <!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->
        <!--
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.10</version>
        </dependency>
        <!--mysql-connector-java-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--jdbc-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

**yml配置**

![image-20221226154239309](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221226154239309.png)



server:
  port: 8001

spring:
  application:
    name: cloud-payment-service
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource            # 当前数据源操作类型
    driver-class-name: org.gjt.mm.mysql.Driver              # mysql驱动包
    url: jdbc:mysql://localhost:3306/my?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: root
    password: 1234

mybatis:
  mapperLocations: classpath:mapper/*.xml
  type-aliases-package: com.lun.springcloud.entities    # 所有Entity别名类所在包

**开始业务类**

![image-20221226155243511](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221226155243511.png)

#### 五.热部署Devtools

![image-20221226180044875](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221226180044875.png)

#### 六.微服务之前的传递

消费者去调动提供者传参的时候，post请求传参，！服务提供者接收参数需要使用@RequestBody注解进行接收

![image-20221227101725232](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221227101725232.png)

![image-20221227101650552](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221227101650552.png)

#### 七.创建公共部分的模块

创建公共模块

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>LearnCloud</artifactId>
        <groupId>com.lun.springcloud</groupId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-api-commons</artifactId>
    
    <dependencies>
        <dependency>热部署依赖，不用可以不导
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>5.1.0</version>
        </dependency>
    </dependencies>

</project>

提取模块中的公共部分

![image-20230103111901239](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103111901239.png)

删除其他模块的公共部分

在其他模块的pom文件中引入依赖

```
<dependency><!--引入自己定义的api通用包，可以使用Payment支付Entity-->
    <groupId>com.xzf</groupId>
    <artifactId>cloud-api-commons</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```



# 初级篇

## 一.Eureka

### 1.Eureka基础知识：

![image-20230103144022372](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103144022372.png)

![image-20230103144008047](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103144008047.png)

![image-20230103144247331](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103144247331.png)

### 2.单机Eureka的构建

架构图：

![image-20230103144609759](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103144609759.png)

#### 2.1IDEA生成eurekaServer端服务注册中心

![image-20230103144641588](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103144641588.png)

![image-20230103145252270](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103145252270.png)

**改pom：**

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>LearnCloud</artifactId>
        <groupId>com.lun.springcloud</groupId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-eureka-server7001</artifactId>
    
    <dependencies>
        <!--eureka-server-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
        <!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->
        <dependency>
            <groupId>com.lun.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <!--boot web actuator-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!--一般通用配置-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>
    </dependencies>

</project>

**编写yml**

server:
  port: 7001

eureka:
  instance:
    hostname: locathost #eureka服务端的实例名称
  client:
    #false表示不向注册中心注册自己。
    register-with-eureka: false
    #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    fetch-registry: false
    service-url:
      #设置与Eureka server交互的地址查询服务和注册服务都需要依赖这个地址。
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

**测试：**

```
@EnableEurekaServer//表示这里是注册中心服务端
```

![image-20230103151416393](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103151416393.png)

![image-20230103150908391](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103150908391.png)

#### 2.2EurekaClient端cloud-provide-payment8001将注册进EurekaServer成为服务提供者provide

![image-20230103151252980](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103151252980.png)

![image-20230103151654080](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103151654080.png)

**改8001.pom**

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

**改yml：**

eureka:
  client:
    #表示是否将自己注册进Eurekaserver默认为true。
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetchRegistry: true
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka, http://eureka7002.com:7002/eureka

********主启动*：********

```
@EnableEurekaClient
```

![image-20230103152609518](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103152609518.png)

**测试：**

![image-20230103154000600](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103154000600.png)

![image-20230103154102044](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103154102044.png)

#### 2.3.EurekaClient端cloud-consumer-order80将注册进EurekaServer成为服务消费者consumer

![image-20230103154357879](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103154357879.png)

**改pom**

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

**改yml：**

server:
  port: 80

spring:
  application:
    name: cloud-order-service

eureka:
  client:
    #表示是否将自己注册进Eurekaserver默认为true。
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetchRegistry: true
    service-url:
      defaultZone: http://localhost:7001/eureka

**主启动**：

```
@EnableEurekaClient
```

**测试**：

![image-20230103154905130](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103154905130.png)



http://localhost/consumer/payment/get/1

![image-20230103155023003](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103155023003.png)

测试成功，能进行查询

### 3.集群Eureka构建步骤

**结构图：**



![image-20230103155535887](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103155535887.png)

**步骤图：**

![image-20230103155507800](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103155507800.png)

#### 3.1EurekaServer集群环境构建步骤

![image-20230104095717595](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104095717595.png)

![image-20230103160748056](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103160748056.png)

![image-20230103162923038](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103162923038.png)

**改7001的yml**

![image-20230103163748327](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103163748327.png)

```
server:
  port: 7001

eureka:
  instance:
    hostname: eureka7001.com #eureka服务端的实例名称
  client:
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      #集群指向其它eureka
      defaultZone: http://eureka7004.com:7004/eureka/
      #单机就是7001自己
      #defaultZone: http://eureka7001.com:7001/eureka/
```

```
server:
  port: 7004

eureka:
  instance:
    hostname: eureka7004.com #eureka服务端的实例名称
  client:
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      #集群指向其它eureka
      defaultZone: http://eureka7001.com:7001/eureka/
      #单机就是7002自己
      #defaultZone: http://eureka7002.com:7002/eureka/
```

**主启动：**

**测试**

7001指向7004，7004指向7001，搭建成功

!![image-20230103165554363](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103165554363.png)(C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103165458245.png)

![image-20230103165443989](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103165443989.png)

#### 3.2将支付，订单 服务发布到上面2台Eureka集群配置中

将它们的配置文件的eureka.client.service-url.defaultZone进行修改

eureka:
  client:
    #表示是否将自己注册进Eurekaserver默认为true。
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetchRegistry: true
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka, http://eureka7002.com:7002/eureka





```
server:
  port: 80

spring:
  application:
    name: cloud-order-service

eureka:
  client:
    #表示是否将自己注册进Eurekaserver默认为true。
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetchRegistry: true
    service-url:
#      defaultZone: http://localhost:7001/eureka
       defaultZone: http://eureka7001.com:7001/eureka, http://eureka7004.com:7004/eureka
```

#### 3.3测试

![image-20230103170429395](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103170429395.png)

![image-20230103170733285](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103170733285.png)

#### 3.4支付服务提供者8001集群环境搭建

#####  3.4.1搭建步骤

![image-20230103171246488](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103171246488.png)

#### 3.5负载均衡：

![image-20230103174355389](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103174355389.png)

用来查看使用了那个端口

```
@Value("${server.port}")
private String serverPort;
```

在消费者80的controller类中要修改写死的访问地址

![image-20230103174037720](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103174037720.png)

```
//    public static final String PAYMENT_URL="http://localhost:8001";单机时可以写死8001，
//    集群时不能，要用集群上服务提供者注册的名称  如：CLOUD-PAYMENT-SERVICE
      public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
```





![image-20230103174756993](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230103174756993.png)

### 4.actuator微服务信息完善

#### 4.1.服务名称修改：![image-20230104092613585](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104092613585.png)

##### 

**修改8001,8002yml**

![image-20230104093012253](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104093012253.png)



**测试：**

![image-20230104093607733](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104093607733.png)

​    健康测试   http://desktop-cm977pm:8002/actuator/health

![image-20230104093736673](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104093736673.png)

#### 3.6.2.IP信息提示

![image-20230104094126483](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104094126483.png)

**修改8001,8002yml**

![image-20230104094445759](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104094445759.png)

**测试：**

![image-20230104094847276](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104094847276.png)





### 5.服务器发现Discovery

![image-20230104095652391](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104095652391.png)

**修改8001,8002的Controller类**

![image-20230104100553146](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104100553146.png)

![image-20230104102104931](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104102104931.png)

```
@GetMapping(value = "/payment/discovery")
public Object discovery(){
     List<String> services=discoveryClient.getServices();
     for (String element : services){
         log.info("##@@@@element: "+element);
     }
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
     for (ServiceInstance instance:instances){
         log.info(instance.getServiceId()+"/t"+instance.getHost()+"/t"+instance.getPort()+"/t"+instance.getUri());
     }


     return this.discoveryClient;
}
```

**修改主启动**

```
@EnableDiscoveryClient
```

![image-20230104102214945](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104102214945.png)



**测试**

http://localhost:8001/payment/discovery

得到服务器上有什么服务

![image-20230104102545956](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104102545956.png)

后台数据：

![image-20230104102746434](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104102746434.png)



### 6.Eureka的自我保护

![image-20230104103110575](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104103110575.png)

![image-20230104103132352](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104103132352.png)



**服务提供者8001修改：**

![image-20230104104954709](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104104954709.png)

**服务注册中心7001修改**

![image-20230104104802299](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104104802299.png)

**测试：**

![image-20230104105201186](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104105201186.png)





## 二.Zookeeper服务注册与实现

![image-20230104105856566](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104105856566.png)

### 1.SpringCloud整合Zookeeper代替Eureka



**（1）下载zookeeper**

https://downloads.apache.org/zookeeper/

https://downloads.apache.org/zookeeper/zookeeper-3.7.1/

![image-20230104110628106](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104110628106.png)

**（2）解压**

tar -zxvf apache-zookeeper-3.7.1-bin.tar.gz

**（3）移动到指定文件夹**

mv apache-zookeeper-3.7.1-bin /usr/local/zookeeper-3.7.1

**（4）创建data和logs文件**

[root@xzf zookeeper-3.7.1]# mkdir data
[root@xzf zookeeper-3.7.1]# mkdir logs

![image-20230104111508944](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104111508944.png)

（**5）修改配置文件**

进入conf文件内 执行如下命令 复制并改名。

```crystal
[root@VM-16-2-centos conf]# cp zoo_sample.cfg zoo.cfg
```

```crystal
[root@VM-16-2-centos conf]# vim zoo.cfg
```

编辑zoo.[cfg文件](https://so.csdn.net/so/search?q=cfg文件&spm=1001.2101.3001.7020)：按a键  添加如下配置 esc  ：wq 保存并退出

```crystal
#数据文件夹
dataDir=/usr/local/zookeeper-3.7.1/data
#日志文件夹
dataLogDir=/usr/local/zookeeper-3.7.1/logs
```

然后我们修改系统配置文件：配置环境变量

```crystal
[root@VM-16-2-centos conf]# vim /etc/profile
```

```bash
#zookeeper-3.7.1配置
export ZOOKEEPER_HOME=/usr/local/zookeeper-3.7.1/
export PATH=$ZOOKEEPER_HOME/bin:$PATH
export PATH
```

**（6）运行文件：应用刚才的修改**

```crystal
[root@VM-16-2-centos conf]# source /etc/profile
```

**（7）启动zookeeper**

```crystal
[root@VM-16-2-centos conf]# cd /usr/local/zookeeper-3.7.1/
[root@VM-16-2-centos zookeeper-3.6.3]# cd bin
```

**（8）启动服务端**

```crystal
[root@VM-16-2-centos bin]# ./zkServer.sh start
```

![image-20230104145832043](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104145832043.png)

记得把端口打开

#### 1.1注册中心Zookeeper

![image-20230104110110325](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104110110325.png)



**关闭防火墙：**

![image-20230104150005966](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104150005966.png)

#### 1.2服务提供者

![image-20230104151956992](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104151956992.png)

**改pom**

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springCloud01</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.xzf</groupId>
    <artifactId>cloud-provider-payment8004</artifactId>

    <dependencies>
        <!-- SpringBoot整合Web组件 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency><!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->
            <groupId>com.xzf</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!-- SpringBoot整合zookeeper客户端 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
            <!--先排除自带的zookeeper3.5.3 防止与3.4.9起冲突-->
            <exclusions>
                <exclusion>
                    <groupId>org.apache.zookeeper</groupId>
                    <artifactId>zookeeper</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!--添加zookeeper3.4.9版本-->
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.9</version>
        </dependency>
<!--        <dependency>-->
<!--            <groupId>org.springframework.boot</groupId>-->
<!--            <artifactId>spring-boot-devtools</artifactId>-->
<!--            <scope>runtime</scope>-->
<!--            <optional>true</optional>-->
<!--        </dependency>-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

**写yml**

```
#8004表示注册到zookeeper服务器的支付服务提供者端口号
server:
  port: 8004

#服务别名----注册zookeeper到注册中心名称
spring:
  application:
    name: cloud-provider-payment
  cloud:
    zookeeper:
      connect-string: 129.204.198.127:2181 # 129.204.198.127:2181 #
```

**主启动类**

```
@EnableDiscoveryClient  //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
```

![image-20230104153641709](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104153641709.png)

**controller类**

```
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String servertPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper: "+servertPort+"\t"+ UUID.randomUUID().toString();
    }
}
```

**启动zookeeper的客户端**

记得之前要启动服务端

```
./zkCli.sh
```

![image-20230104154925709](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104154925709.png)

什么都没有

**测试启动**

可能报错，版本冲突

![image-20230104155609870](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104155609870.png)

解决方法：

```
<!-- SpringBoot整合zookeeper客户端 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
    <!--先排除自带的zookeeper3.5.3 防止与3.4.9起冲突-->
    <exclusions>
        <exclusion>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<!--添加zookeeper3.4.9版本-->
<dependency>
    <groupId>org.apache.zookeeper</groupId>
    <artifactId>zookeeper</artifactId>
    <version>3.4.9</version>
</dependency>
```



成功注册进去

![image-20230104155946448](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104155946448.png)

![image-20230104160103446](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104160103446.png)

![image-20230104160138710](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104160138710.png)

网页连接测试

http://localhost:8004/payment/zk

!(C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104160632261.png)

![image-20230104160543092](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104160543092.png)

#### 1.3服务消费者

![image-20230104161505865](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104161505865.png)

**pom**

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springCloud01</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.xzf</groupId>
    <artifactId>cloud-comsumerzk-order80</artifactId>

    <dependencies>
        <!-- SpringBoot整合Web组件 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- SpringBoot整合zookeeper客户端 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
            <!--先排除自带的zookeeper-->
            <exclusions>
                <exclusion>
                    <groupId>org.apache.zookeeper</groupId>
                    <artifactId>zookeeper</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!--添加zookeeper3.4.9版本-->
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.9</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>

```

**yml**

```
server:
  port: 80

#服务别名----注册zookeeper到注册中心名称
spring:
  application:
    name: cloud-consumer-order
  cloud:
    zookeeper:
      connect-string: 129.204.198.127:2181 # 129.204.198.127:2181 #
```

**主启动**

**业务类**

**测试**

![image-20230104164017267](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104164017267.png)

http://localhost/consumer/payment/zk

![image-20230104164200247](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104164200247.png)

## 三.Consul 服务注册与发现

![image-20230104164548995](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104164548995.png)

### 1.Consul简介

![image-20230104164637197](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230104164637197.png)



[What is Consul? | Consul | HashiCorp Developer](https://developer.hashicorp.com/consul/docs/intro)

What is Consul?

Consul is a service mesh solution providing a full featured control plane with service discovery, configuration, and segmentation functionality. Each of these features can be used individually as needed, or they can be used together to build a full service mesh. Consul requires a data plane and supports both a proxy and native integration model. Consul ships with a simple built-in proxy so that everything works out of the box, but also supports 3rd party proxy integrations such as Envoy. link

Consul是一个服务网格解决方案，它提供了一个功能齐全的控制平面，具有服务发现、配置和分段功能。这些特性中的每一个都可以根据需要单独使用，也可以一起用于构建全服务网格。Consul需要一个数据平面，并支持代理和本机集成模型。Consul船与一个简单的内置代理，使一切工作的开箱即用，但也支持第三方代理集成，如Envoy。

### 2.安装 并运行consul

下载：https://developer.hashicorp.com/consul/downloads

安装操作教程：https://blog.csdn.net/yi234567bo/article/details/125383711

 **./consul agent -dev** 启动

![image-20230105103001914](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105103001914.png)

**浏览器访问129.204.198.127:8500**

![image-20230105103044167](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105103044167.png)

**如果远程无法访问，比如我使用的腾讯云，后面要用内网(内)地址，使用外网(公)地址连接不上。
 浏览器访问时使用 外网(公)地址:8500**
 **两个命令都可以使用**

```
./consul agent -dev -client 10.0.8.12

./consul agent -dev -ui -node=consul-dev -client=10.0.8.12
```

### 3.服务提供者

![image-20230105103836114](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105103836114.png)

**pom文件**

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springCloud01</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-providerconsul-payment8006</artifactId>
    <dependencies>
        <!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->
        <dependency>
            <groupId>com.xzf</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!--SpringCloud consul-server -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-consul-discovery</artifactId>
        </dependency>
        <!-- SpringBoot整合Web组件 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!--日常通用jar包配置-->

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>
         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        
    </dependencies>

</project>
```

**yml文件**

```
###consul服务端口号
server:
  port: 8006

spring:
  application:
    name: consul-provider-payment
  ####consul注册中心地址
  cloud:
    consul:
      host: 129.204.198.127
      port: 8500
      discovery:
        #hostname: 127.0.0.1
        service-name: ${spring.application.name}
        heartbeat:
          enabled: true
```

**主启动类**

```
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class);
    }
}
```

**测试**

consul下载的windows1.8.4版本的,按照老师的配置来会有个小红叉叉

解决方法:在discovery:下加上heartbeat:(回车)enabled: true即可去掉

![image-20230105110642324](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105110642324.png)

http://localhost:8006/payment/consul

![image-20230105110840303](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105110840303.png)



### 4.服务消费者

![image-20230105112506971](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105112506971.png)

### 5.三个注册中心异同点

![image-20230105114244546](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105114244546.png)

![image-20230105114637844](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105114637844.png)

## 四. Ribbon负载均衡服务调用

![image-20230105115632138](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105115632138.png)

### 1.概述

![image-20230105115756266](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105115756266.png)

![image-20230105150201151](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105150201151.png)



##### 核心组件：

![image-20230105150316941](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105150316941.png)





**新建package和新建Rule规则类**



![image-20230105151005687](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105151005687.png)

```
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
```

**主启动类**

![image-20230105151216604](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105151216604.png)

```
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
```

**测试**

![image-20230105152304426](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105152304426.png)

##### **算法解析：**

![image-20230105152922832](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230105152922832.png)

## 五、OpenFeign服务接口调用

![image-20230106173802041](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230106173802041.png)

![image-20230106174013098](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230106174013098.png)





### 1.OpenFeign使用步骤

![image-20230106174852130](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230106174852130.png)

**pom文件**

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springCloud01</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-comsumer-feign-order80</artifactId>

    <dependencies>
        <!--openfeign-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <!--eureka client-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->
        <dependency>
            <groupId>com.xzf</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!--web-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!--一般基础通用配置-->

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

**yml文件**

```
server:
  port: 80

eureka:
  client:
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7004.com:7004/eureka/
```

**主启动类**

```
@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class);
    }
}
```

**业务类**

![image-20230106181321806](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230106181321806.png)

**小结**

![image-20230109093808090](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109093808090.png)

### 2.OpenFeign超时控制

**8001,8002control**

```
@GetMapping(value = "/payment/feign/timeout")
public String paymentFeignTimeout(){
    try{
        TimeUnit.SECONDS.sleep(3);
    }catch (InterruptedException e){
        e.printStackTrace();
    }

    return serverPort;
}
```

**80端controller**

```
@GetMapping(value = "/consumer/payment/feign/timeout")
public String paymentFeignTimeout(){

    return paymentFeignService.paymentFeignTimeout();
};
```

**80端service**

```
@GetMapping(value = "/payment/feign/timeout")
public String paymentFeignTimeout();
```

**测试：**http://localhost:8001/payment/feign/timeout

直接调用支付者：耗时3秒，正常得到数据



![image-20230109100100597](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109100100597.png)





http://localhost/consumer/payment/feign/timeout

通过消费端调用，由于消费端的OpenFeign默认等待秒钟，而支付端要秒所以报超时的错



![image-20230109102450284](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109102450284.png)





**OpenFeign时间配置**

![image-20230109103347036](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109103347036.png)

**yml文件配置**

```
#设置feign客户端超时时间(OpenFeign默认支持ribbon)(单位：毫秒)
ribbon:
  #指的是建立连接所用的时间，适用于网络状况正常的情况下,两端连接所用的时间
  ReadTimeout: 5000
  #指的是建立连接后从服务器读取到可用资源所用的时间
  ConnectTimeout: 5000
```

**测试成功**

http://localhost/consumer/payment/feign/timeout



![image-20230109104037789](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109104037789.png)

### 3.OpenFeign日志打印功能

![image-20230109104336407](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109104336407.png)

##### 1.日志级别

![image-20230109104508587](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109104508587.png)

##### 2.配置日志bean

```
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
```

##### 3.yml文件需要开启日志的Feigon文件

```yaml
logging:
  level:
    # feign日志以什么级别监控哪个接口
    com.lun.springcloud.service.PaymentFeignService: debug
```

##### 4.测试

![image-20230109110029041](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109110029041.png)

# 中级篇

## 一.Hystrix断路器

![image-20230109110321181](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109110321181.png)



### 1.概述

![image-20230109111632824](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109111632824.png)

#### 1.1分布式系统面临的问题![image-20230109110958112](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109110958112.png)

![image-20230109111148571](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109111148571.png)

#### 1.2是什么

![image-20230109111324238](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109111324238.png)

#### 1.3能干嘛

![image-20230109111740854](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109111740854.png)

### 2.Hystrix重要概念

![image-20230109112401512](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109112401512.png)

#### 2.1服务降级

![image-20230109112658037](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109112658037.png)

#### 2.2服务熔断

![image-20230109112841970](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109112841970.png)

#### 2.3服务限流

![image-20230109113028272](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109113028272.png)

### 3.hystrix案例

#### 3.1构建

**pom文件**

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springCloud01</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-provider-hystrix-payment8001</artifactId>


    

    <dependencies>
        <!--hystrix-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
        <!--eureka client-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!--web-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency><!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->
            <groupId>com.xzf</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

**yml文件**

```
server:
  port: 8001

spring:
  application:
    name: cloud-provider-hystrix-payment

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7004.com:7004/eureka
      # defaultZone: http://eureka7001.com:7001/eureka
```

**主启动**

```
@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class);
    }
}
```

#### 3.2高并发测试

![image-20230109150819248](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109150819248.png)

**jmeter压测测试**



![image-20230109152326414](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109152326414.png)

![image-20230109152402480](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109152402480.png)

![image-20230109152422306](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109152422306.png)

![image-20230109152616097](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109152616097.png)



**结论：**

![image-20230109152745327](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109152745327.png)

**新建80**

![image-20230109153112298](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109153112298.png)

**pom文件：**

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springCloud01</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-comsumer-feign-hystrox-order80</artifactId>


    <dependencies>
        <!--openfeign-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <!--hystrix-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
        <!--eureka client-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->
        <dependency>
            <groupId>com.xzf</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!--web-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!--一般基础通用配置-->
      
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
  
</project>
```

**yml文件：**

```
server:
  port: 80

eureka:
  client:
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7004.com:7004/eureka/
```

#### 3.30故障现象和导致原因

![image-20230109161854184](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109161854184.png)

#### 3.4如何解决？解决的要求

![image-20230109162022699](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109162022699.png)

![image-20230109162153263](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109162153263.png)

![image-20230109162210878](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109162210878.png)

#### 3.5服务降级

![image-20230109162523623](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230109162523623.png)

###### 3.5.1 8001先从自身找问题



![image-20230111102353621](C:\Users\xzf\Desktop\学习\image-20230111102353621.png)

###### 3.5.2 8001fallback

![image-20230111103129668](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111103129668.png)

![image-20230111103338815](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111103338815.png)

$\textcolor{red}{@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
})}$

```
@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
})
public String paymentInfo_TimeOut(Integer id){
    int time=5;
    try{
        TimeUnit.SECONDS.sleep(time);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    return "线程池： "+Thread.currentThread().getName()+"  paymentInfo_TimeOut,id"+"\t"+"o(n_n)o哈哈~  耗时"+time+"秒钟";
}
public String paymentInfo_TimeOutHandler(Integer id){
    return "线程池："+Thread.currentThread().getName()+"  paymentInfo_TimeOutHandler,id    "+id+"\t"+"(っ╥╯﹏╰╥c)";
}
```

![image-20230111103822731](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111103822731.png)

```
@EnableCircuitBreaker
```

**测试**：http://localhost:8001/payment/hystrix/timeout/1

![image-20230111105204762](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111105204762.png)

###### 3.5.3  80fallback

![image-20230111110600515](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111110600515.png)

**yml文件**

```
feign:
  hystrix:
    enabled: true
```

**主启动**

```
@EnableHystrix
```

**业务类**

@GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //int age = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }
    
    //善后方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }



###### 3.5.4 目前问题

![image-20230111112717115](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111112717115.png)

###### 3.5.5 解决问题

![image-20230111113035894](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111113035894.png)

![image-20230111113207144](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111113207144.png)

![image-20230111113225085](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111113225085.png)

![image-20230111113307826](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111113307826.png)

![image-20230111115845621](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111115845621.png)

![image-20230111120008207](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111120008207.png)





#### 3.6服务熔断

![image-20230111152907783](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111152907783.png)



![image-20230111152804341](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111152804341.png)



论文：[断路器 (martinfowler.com)](https://martinfowler.com/bliki/CircuitBreaker.html)



![image-20230111154421162](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111154421162.png)

###### PaymentService





        //=====服务熔断
        @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
                @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
        })
        public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
            if(id < 0) {
                throw new RuntimeException("******id 不能负数");
            }
            String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

$\textcolor{red}{controller}$

```
//====服务熔断
@GetMapping("/payment/circuit/{id}")
public String paymentCircuitBreaker(@PathVariable("id") Integer id)
{
    String result = paymentService.paymentCircuitBreaker(id);
    log.info("****result: "+result);
    return result;
}
```

$\textcolor{red}{}$

$\textcolor{red}{测试}$

![image-20230111160338191](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111160338191.png)



http://localhost:8001/payment/circuit/1：成功

http://localhost:8001/payment/circuit/-1： 失败



![image-20230111161018456](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111161018456.png)

$\textcolor{red}{}$

$\textcolor{red}{总结}$

![image-20230111161139020](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111161139020.png)

![image-20230111161213034](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111161213034.png)

![image-20230111161437997](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111161437997.png)

![image-20230111161503974](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111161503974.png)

### 4.服务监控hystrixDashboard

#### 4.1概述

![image-20230111162938199](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111162938199.png)

#### 4.2 仪表盘9001

![image-20230111163028371](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111163028371.png)

**pom文件**

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springCloud01</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-comsumer-hystrox-dashboard9001</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>


        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

**yml**

```
server:
  port: 9001
```

**主启动**

```
@EnableHystrixDashboard
```

![image-20230111164222575](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111164222575.png)

**测试：**成功

http://localhost:9001/hystrix

![image-20230111164533616](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111164533616.png)

#### 4.3断路器演示（服务监控hystrix/Dashborad）

### ![image-20230111164738184](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111164738184.png)

**主启动类：**

```
@EnableCircuitBreaker
```

```
/**
 *此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的坑
 *ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"，
 *只要在自己的项目里配置上下面的servlet就可以了
 *否则，Unable to connect to Command Metric Stream 404
 */
@Bean
public ServletRegistrationBean getServlet() {
    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
    registrationBean.setLoadOnStartup(1);
    registrationBean.addUrlMappings("/hystrix.stream");
    registrationBean.setName("HystrixMetricsStreamServlet");
    return registrationBean;
}
```



![image-20230111165824905](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111165824905.png)

![image-20230111165849405](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111165849405.png)

http://localhost:8001/hystrix.stream

![image-20230111170033988](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111170033988.png)

![image-20230111171540866](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111171540866.png)

![image-20230111171811393](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230111171811393.png)

## 二.Gateway新一代网关

![image-20230112092822866](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112092822866.png)

### 1.概述简介



![image-20230112093335424](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112093335424.png)

![image-20230112093307492](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112093307492.png)

![image-20230112093400723](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112093400723.png)

![image-20230112093422132](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112093422132.png)





![image-20230112093706670](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112093706670.png)





![image-20230112093948880](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112093948880.png)



![image-20230112093735228](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112093735228.png)

### 2.   三大核心概念

![image-20230112101015229](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112101015229.png![image-20230112101029685](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112101029685.png)

#### 路由：

![image-20230112101156486](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112101156486.png)

#### 断言：

![image-20230112101301811](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112101301811.png)

#### 过滤：

![image-20230112101419805](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112101419805.png)

#### 总体：

![image-20230112101653552](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112101653552.png)

### 3. Gateway工作流程

![image-20230112101824806](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112101824806.png)

![image-20230112101839616](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112101839616.png)



$\textcolor{red}{**核心逻辑:  路由转发+执行过滤器链**}$

### 4.入门配置

![image-20230112102405478](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112102405478.png)

**pom文件**

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springCloud01</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-gateway-gateway9527</artifactId>

    <dependencies>
        <!--gateway-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>
        <!--eureka-client-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->
        <dependency>
            <groupId>com.xzf</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!--一般基础配置类-->
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
       
```

**yml文件**

```
server:
  port: 9527

spring:
  application:
    name: cloud-gateway

eureka:
  instance:
    hostname: cloud-gateway-service
  client: #服务提供者provider注册进eureka服务列表内
    service-url:
      register-with-eureka: true
      fetch-registry: true
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7004.com:7004/eureka
#      defaultZone: http://eureka7001.com:7001/eureka
```

**主启动类**

```
@SpringBootApplication
@EnableEurekaClient//开启注册到服务器
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class);
    }
}
```





##### 9527网关如何做路由映射那？？？

![image-20230112104323628](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112104323628.png)

**yml新增网关配置文件**

```
server:
  port: 9527

spring:
  application:
    name: cloud-gateway
  #############################新增网关配置###########################
  cloud:
    gateway:
      routes:
        - id: payment_routh #payment_route    #路由的ID，没有固定规则但要求唯一，建议配合服务名
          uri: http://localhost:8001          #匹配后提供服务的路由地址
          #uri: lb://cloud-payment-service #匹配后提供服务的路由地址
          predicates:
            - Path=/payment/get/**         # 断言，路径相匹配的进行路由

        - id: payment_routh2 #payment_route    #路由的ID，没有固定规则但要求唯一，建议配合服务名
          uri: http://localhost:8001          #匹配后提供服务的路由地址
          #uri: lb://cloud-payment-service #匹配后提供服务的路由地址
          predicates:
            - Path=/payment/lb/**         # 断言，路径相匹配的进行路由
####################################################################

eureka:
  instance:
    hostname: cloud-gateway-service
  client: #服务提供者provider注册进eureka服务列表内
    service-url:
      register-with-eureka: true
      fetch-registry: true
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7004.com:7004/eureka
#      defaultZone: http://eureka7001.com:7001/eureka
```



测试

![image-20230112105005875](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112105005875.png)

**访问说明：**



![image-20230112110339487](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112110339487.png)

http://localhost:9527/payment/get/1

http://localhost:8001/payment/get/1





![image-20230112112126830](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230112112126830.png)





##### **YML配置说明**

![image-20230113101429938](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113101429938.png)





![image-20230113101447643](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113101447643.png)





![image-20230113101947367](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113101947367.png)

https://home.firefoxchina.cn/



**config文件**

![image-20230113103406792](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113103406792.png)

```
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_xzf",
                r-> r.path("/baidu")
                        .uri("https://news.baidu.com")).build();

        return routes.build();
    }
```



### 5.通过微服务名实现动态路由

![image-20230113110720066](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113110720066.png)

![image-20230113110857013](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113110857013.png)



**yml文件**

```
server:
  port: 9527

spring:
  application:
    name: cloud-gateway
  #############################新增网关配置###########################
  cloud:
    gateway:  # 新增
      discovery: #  新增
        locator: #  新增
          enabled: true #开启从注册中心动态创建路由的功能，利用微服务名进行路由   新增
      routes:
        - id: payment_routh #payment_route    #路由的ID，没有固定规则但要求唯一，建议配合服务名
#          uri: http://localhost:8001         #匹配后提供服务的路由地址
          uri: lb://cloud-payment-service #匹配后提供服务的路由地址  新增
          predicates:
            - Path=/payment/get/**         # 断言，路径相匹配的进行路由

        - id: payment_routh2 #payment_route    #路由的ID，没有固定规则但要求唯一，建议配合服务名
#          uri: http://localhost:8001          #匹配后提供服务的路由地址
          uri: lb://cloud-payment-service #匹配后提供服务的路由地址    新增
          predicates:
            - Path=/payment/lb/**         # 断言，路径相匹配的进行路由
####################################################################

eureka:
  instance:
    hostname: cloud-gateway-service
  client: #服务提供者provider注册进eureka服务列表内
    service-url:
      register-with-eureka: true
      fetch-registry: true
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7004.com:7004/eureka
#      defaultZone: http://eureka7001.com:7001/eureka
```



http://localhost:9527/payment/lb

![image-20230113111736038](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113111736038.png)

### 6.Predicate的使用（断言）

![image-20230113111802911](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113111802911.png)



常用的Route Predicate Factory

    The After Route Predicate Factory
    The Before Route Predicate Factory
    The Between Route Predicate Factory
    The Cookie Route Predicate Factory
    The Header Route Predicate Factory
    The Host Route Predicate Factory
    The Method Route Predicate Factory
    The Path Route Predicate Factory
    The Query Route Predicate Factory
    The RemoteAddr Route Predicate Factory
    The weight Route Predicate Factory


**yml文件**

```
spring:
  cloud:
    gateway:
      routes:
      - id: after_route
        uri: https://example.org
        predicates:
        # 这个时间后才能起效
        - After=2017-01-20T17:42:47.789-07:00[America/Denver]

```

可以通过下述方法获得上述格式的时间戳字符串

```
import java.time.ZonedDateTime;


public class T2
{
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);

       //2021-02-22T15:51:37.485+08:00[Asia/Shanghai]
    }
}
```



**The Cookie Route Predicate Factory**

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: cookie_route
        uri: https://example.org
        predicates:
        - Cookie=username,zzxy
```

测试

```shell
# 该命令相当于发get请求，且没带cookie

curl http://localhost:9527/payment/lb

```

![image-20230113115049880](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113115049880.png)

```shell
# 带cookie的
curl http://localhost:9527/payment/lb --cookie "chocolate=chip"
```

![image-20230113115115303](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113115115303.png)



The Header Route Predicate Factory

```
spring:
  cloud:
    gateway:
      routes:
      - id: header_route
        uri: https://example.org
        predicates:
        - Header=X-Request-Id, \d+  #带正数
```

```shell
# 带指定请求头的参数的CURL命令
curl http://localhost:9527/payment/lb -H "X-Request-Id:123"
```

![image-20230113115839082](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113115839082.png)

![image-20230113115858941](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113115858941.png)

**小结**

说白了，Predicate就是为了实现一组匹配规则，让请求过来找到对应的Route进行处理。

### 7.Filter的使用

![image-20230113141451483](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113141451483.png)

#### 是什么

![image-20230113141535763](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113141535763.png)

![image-20230113141909537](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113141909537.png)

**config类**，实现两个接口

```
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        log.info("***********come in MyLogGateWayFilter:  "+new Date());

        String uname = exchange.getRequest().getQueryParams().getFirst("uname");

        if(uname == null)
        {
            log.info("*******用户名为null，非法用户，o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder()
    {
        return 0;
    }

}
```

浏览器输入：

- http://localhost:9527/payment/lb - 反问异常
- http://localhost:9527/payment/lb?uname=abc - 正常反问



## 三.SpringCloud Config分布式配置中心

![image-20230113151130146](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113151130146.png)

### 1.概述

![image-20230113151939675](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113151939675.png)

#### 配置问题：

![image-20230113151838272](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113151838272.png)

#### 是什么

![image-20230113152033191](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113152033191.png)

![image-20230113152316399](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113152316399.png)

#### 能干嘛

![image-20230113152413017](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113152413017.png)

### 2.Config服务端配置与测试

![image-20230113152841731](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113152841731.png)

https://gitee.com/dashboard



https://blog.csdn.net/weixin_65793170/article/details/128563290

https://blog.csdn.net/qq_15125937/article/details/125604629

https://www.pudn.com/news/6228cfb99ddf223e1ad14b02.html

https://blog.csdn.net/LOVE_Me__/article/details/109240187?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-109240187-blog-126443672.pc_relevant_multi_platform_whitelistv4&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-109240187-blog-126443672.pc_relevant_multi_platform_whitelistv4&utm_relevant_index=1



git@github.com:33yx/springcloud-config.git

上传内容：

```bash
git push origin master
```

![image-20230113175106026](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113175106026.png)

总结：其实只需要进行下面几步就能把本地项目上传到Github

1、在本地创建一个版本库（即文件夹），通过git init把它变成Git仓库；

2、把项目复制到这个文件夹里面，再通过git add .把项目添加到仓库；

3、再通过git commit -m "注释内容"把项目提交到仓库；

4、在Github上设置好SSH密钥后，新建一个远程仓库，通过git remote add origin https://github.com/guyibang/TEST2.git将本地仓库和远程仓库进行关联；

5、最后通过git push -u origin master把本地仓库的项目推送到远程仓库（也就是Github）上；（若新建远程仓库的时候自动创建了README文件会报错，解决办法看上面）。

这里只是总结了Git上传项目的一些基本操作，要想更好地使用Git还需更进一步的学习。



**pom文件**

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springCloud01</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-config-center-3344</artifactId>

    <dependencies>
        <!--添加消息总线RabbitMQ支持-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```



**yml文件**

```
server:
  port: 3344

spring:
  application:
    name:  cloud-config-center #注册进Eureka服务器的微服务名
  cloud:
    config:
      server:
        git:
          uri: https://github.com/33yx/springcloud-config.git #GitHub上面的git仓库名字
          ####搜索目录
          username: xzfyun
          password: 123456
          search-paths:
            - springcloud-config
      ####读取分支
      label: master

#服务注册到eureka地址
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka, http://eureka7004.com:7004/eureka
```

![image-20230113180619938](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230113180619938.png)



**测试：**http://config-3344.com:3344/master/config-dev.yml

![image-20230116100411567](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116100411567.png)

### 3.Config 客户端配置与测试

![image-20230116111948873](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116111948873.png)



**pom**

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>springCloud01</artifactId>
        <groupId>com.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-config-client-3355</artifactId>

    <dependencies>
        <!--添加消息总线RabbitMQ支持-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>


        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>



</project>
```

**yml文件**

![image-20230116113007872](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116113007872.png)

![image-20230116112820488](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116112820488.png)

```
server:
  port: 3355

spring:
  application:
    name: config-client
  cloud:
    #Config客户端配置
    config:
      label: master #分支名称
      name: config #配置文件名称
      profile: dev #读取后缀名称   上述3个综合：master分支上config-dev.yml的配置文件被读取http://config-3344.com:3344/master/config-dev.yml
      uri: http://localhost:3344 #配置中心地址k


#服务注册到eureka地址
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka, http://eureka7004.com:7004/eureka
```

**业务类**

```
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }

}
```

**测试：**

![image-20230116113900099](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116113900099.png)

http://localhost:3355/configInfo

![image-20230116114417559](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116114417559.png)

![image-20230116114501312](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116114501312.png)

**问题**

![image-20230116115140846](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116115140846.png)

### 4.Config客户端之动态刷新

![image-20230116154007656](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116154007656.png)

![image-20230116154057898](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116154057898.png)

避免每次更新配置都要重启客户端微服务3355

动态刷新步骤：

修改3355模块

**POM引入actuator监控**

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

**修改YML，添加暴露监控端口配置：**

```yaml
# 暴露监控端点
management:
  endpoints:
    web:
      exposure:
        include: "*"
```

**@RefreshScope业务类Controller修改**

import org.springframework.cloud.context.config.annotation.RefreshScope;
...

@RestController
**@RefreshScope//<-----**
public class ConfigClientController
{
...
}



**测试**

此时修改github配置文件内容 -> 访问3344 -> 访问3355(要等一下，机器可能运行缓慢)

http://localhost:3355/configInfo

3355改变没有??? **没有**，还需一步![image-20230116155009818](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116155009818.png)





![image-20230116155026864](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116155026864.png)

How

需要运维人员发送Post请求刷新3355



![image-20230116155125696](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116155125696.png)

```shell
curl -X POST "http://localhost:3355/actuator/refresh"
```



**新问题**

![image-20230116161558385](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116161558385.png)

为了应付上述问题，而引入下一章节（消息总线）

## 四. Springcloud Bus消息总线

![image-20230116162154470](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116162154470.png)

### 1.概述

![image-20230116162209224](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116162209224.png)



![image-20230116162228831](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116162228831.png)

![image-20230116162331887](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116162331887.png)

![image-20230116162521061](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116162521061.png)

![image-20230116162839602](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116162839602.png)

### 2.RabbitMQ环境配置

![image-20230116163203071](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116163203071.png)

![image-20230116171439274](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116171439274.png)

![image-20230116171604076](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116171604076.png)



![image-20230116171501717](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116171501717.png)

![image-20230116171659080](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116171659080.png)

![image-20230116171517766](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116171517766.png)

![image-20230116171721241](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116171721241.png)

![image-20230116171736693](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116171736693.png)

![image-20230116171749590](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116171749590.png)

### 3.SpringCloud Bus动态刷新全局广播

![image-20230116171933506](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116171933506.png)

#### 1.设计思想

![image-20230116172349293](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230116172349293.png)

#### 2.测试：

![image-20230117103258043](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117103258043.png)

http://config-3344.com:3344/master/config-dev.yml

http://localhost:3355/configInfo![image-20230117110518978](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117110518978.png)

![image-20230117110452886](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117110452886.png)





![image-20230117110428541](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117110428541.png)

```
curl -X POST "http://localhost:3344/actuator/bus-refresh"
```

![image-20230117110622159](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117110622159.png)

![image-20230117110635927](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117110635927.png)

一次刷新全部变化，广播通知，处处生效

### 4.Springcloud Bus动态刷新定点通知（有些通知，有些不通知）

![image-20230117111446550](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117111446550.png)

![image-20230117111520292](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117111520292.png)

![image-20230117111610946](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117111610946.png)

```
curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355
```

差别:

![image-20230117112003349](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117112003349.png)

**总结：**

![image-20230117112428376](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117112428376.png)







## 五.Springcloud Stream 消息驱动

![image-20230117113306051](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117113306051.png)

![image-20230117113330382](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117113330382.png)

#### 设计思想

![image-20230117114605058](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117114605058.png)

![image-20230117114620454](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117114620454.png)



![image-20230117114838393](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117114838393.png)

![image-20230117114717029](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117114717029.png)

![image-20230117114805824](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117114805824.png)

![image-20230117114921738](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117114921738.png)

![image-20230117115015813](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20230117115015813.png)
