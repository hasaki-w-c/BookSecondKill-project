# BookSecondKill

## 项目说明

本项目为模拟现实中电商的高并发环境来开发的一个项目。

我在次项目通过分为几个小项目来逐一解决高并发中的现实问题，每个小项目的功能如下：

secondkill : 是我最初搭建的版本，只相当于一个普通的简单电商项目，并没有引入高并发操作。

secondkill-redis : 是在高并发环境下，使用 Redis 缓存对静态数据的一个优化模块，以及流量防刷与反爬虫的实现模块。

secondkill-static : 是对页面使用程序方式的一个静态化处理，静态页面然后发送 Ajax 请求给 Nginx 代理处理动态数据，完成动静数据分离的一个模块。	

secondkill-sample : 是对秒杀活动场景的一个模拟实现模块，不涉及到和数据库操作相关。

secondkill-seckill : 是对高并发秒杀场景中超卖问题的一个解决，使用 Redis 来实现，以及使用RabbitMQ对订单流量进行一个削峰的模块。

secondkill-lb : 



