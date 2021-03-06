# BookSecondKill

## 项目说明

本项目为模拟现实中电商的高并发环境来开发的一个项目。

我在次项目通过分为几个小项目来逐一解决高并发中的现实问题，每个小项目的功能如下：

- secondkill : 是我最初搭建的版本，只相当于一个普通的简单电商项目，并没有引入高并发操作。


- secondkill-redis : 是在高并发环境下，使用 Redis 缓存对静态数据的一个优化模块，以及流量防刷与反爬虫的实现模块。


- secondkill-static : 是对页面使用程序方式的一个静态化处理，静态页面然后发送 Ajax 请求给 Nginx 代理处理动态数据，完成动静数据分离的一个模块。	


- secondkill-sample : 是对秒杀活动场景的一个模拟实现模块，不涉及到和数据库操作相关。


- secondkill-seckill : 是对高并发秒杀场景中超卖问题的一个解决，使用 Redis 来实现，以及使用RabbitMQ对订单流量进行一个削峰的模块。


- secondkill-lb : 使用 Nginx 负载均衡实现多台服务器同时处理请求，以及设置 Redis Session 共享，设置 Nginx 静态资源缓存，以及使用 Nginx 的 Gzip 进行资源的压缩。

## 项目环境

- JDK 版本 ：JDK 1.8
- MySQL ：8.0.21
- 开发环境 ：IntelliJ IDEA Ultimate 2020.3
- 框架 ：Springboot 2.4.3  ,  Mybatis 3.5.6
- 模板引擎 ：Freemarker 2.3.31  
- maven : 3.6.3
- Redis : Redis-x64-3.2.100
- Nginx : 1.19.7
- RabbitMQ : 3.8.14

## 包结构说明

### src 目录下

#### main 目录下

##### java 目录下

- com.hasaki_w_c.secondkill.controller : 对应 controller 层
- com.hasaki_w_c.secondkill.dao : 对应 dao 层
- com.hasaki_w_c.secondkill.entity ：对应 JavaBean 存放层
- com.hasaki_w_c.secondkill.service : 对应 service 层
- com.hasaki_w_c.secondkill.util : 对应 配置类 层
- SecondkillApplication ： Springboot 启动类

##### resources 目录下

- mapper : Mybatis 配置与 dao 接口对应的 xml 文件
- static : 静态资源文件
- templates : Freemarker 页面文件
- application.yml ：Springboot 配置文件

#### test 目录下

- 存放一些测试代码（本项目没有测试的代码）

## Bug 及修改

项目有关 bug 和 踩过的坑，我的博客都有一定的记录，附上博客地址（[https://blog.csdn.net/qq_45456859](https://blog.csdn.net/qq_45456859)）。