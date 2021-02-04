# rabbitmq-sample-all

Samples for rabbitmq

## 简介

RabbitMQ是实现了高级消息队列协议（AMQP）的开源消息代理软件（亦称面向消息的中间件），它接受并转发消息。

RabbitMQ它接收、存储和转发数据消息的二进制。RabbitMQ服务器是由以高性能、健壮以及可伸缩性出名的 Erlang 写成。

## 历史

Rabbit科技有限公司开发了RabbitMQ，并提供对其的支持。

2010年4月被VMware旗下的SpringSource收购。RabbitMQ在2013年5月成为GoPivotal的一部分。

## 安装

```dockerfile
FROM rabbitmq:management-alpine
```
```
# docker-compose安装，账户/密码：admin/admin
docker-compose up -d
```
