# java-spring


作业作业作业作业


这里是实训啦

## 部署方法：

### Docker-compose

1. 修改数据库文件

```
src/main/resources/application.yml
src/main/java/net/dabbit/skd21/exam/utils/ExamGenerator.java
```

把数据库换为DB

2. 启动`docker-compose`

```
docker-compose up -d
```

3. 服务在`14101`端口啦

4. phpmyadmin 数据库管理器在`14102`端口


### Jar运行


1. 数据库