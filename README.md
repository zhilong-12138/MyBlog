# MyBlog

#### 关于本地开发

可直接导入该项目于本地，修改配置文件中的数据库连接信息，导入附带数据库结构的SQL文件可直接生成所有表，项目中使用到的关于阿里云功能还需开发者自行前往阿里云进行相应功能开通。

**当你克隆项目到本地后可使用邮箱：sad@qq.com，密码：123456进行登录，也可自行注册并将其修改为最高管理权限。**



#### docker 安装redis 

1.安装最新版

```
 docker pull redis:latest
```

2.查看安装

```
docker ps
```

3.启动redis

```
docker run -itd --name myredis -p 6379:6379 redis
```

4.查询启动

```
docker ps
```

5.进入docker

```
docker exec -it 96f8a5e48782 /bin/bash
```

6.启动redis

```
redis-cli
```

7.设置密码

```shell
#查看密码
config get requirepass
#设置密码
config set requirepass redisroot
```



#### 安装oss文件服务器

```
docker pull minio/minio:RELEASE.2021-06-17T00-10-46Z 

docker run -p 9090:9000 --name minio -e "MINIO_ACCESS_KEY=admin" -e "MINIO_SECRET_KEY=admin123456" -v /mydata/minio/data:/data   -v /mydata/minio/config:/root/.minio -d minio/minio server /data --console-address ":9000" --address ":9090"

docker run -d -p 9000:9000 --name minio\
  -e "MINIO_ACCESS_KEY=admin" \
  -e "MINIO_SECRET_KEY=admin1973984292@qq.com" \
  -v /data/minio/data:/data \
  -v /data/minio/config:/root/.minio \
  minio/minio:RELEASE.2021-06-17T00-10-46Z server /data

Access Key: PX4DMSUD0TXO3F0OLLER
Secret Key: hOqY5E8R0dx+Mlynj4RdPCTSz9Yq4x09MOmNu4S8
```



### 项目部署

1.打包jar

2.编写dockerFile

```dockerfile
# Docker image for springboot file run
# VERSION 0.0.1
# Author: eangulee
# 基础镜像使用java
FROM java:8
# 作者
MAINTAINER zzl <sad@gmail.com>  
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp 
# 将jar包添加到容器中并更名为app.jar
ADD /data/docker/myblog.jar app.jar 
# 运行jar包
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
```

3.创建 /data/docker 文件夹

```shell
cd /data
mkdir docker
```

4.创建 Dockerfile文件

```shell
cd /data/docker
vi Dockerfile
```

5.上传项目jar包，当前目录编译Dockerfile 看好，最后面有个"."点！

```dockerfile
docker build -t myblog .
-t 参数是指定此镜像的tag名
```

6.启动服务

```shell
docker run -d -p 8080:28081 myblog
-d参数是让容器后台运行 
-p 是做端口映射，此时将服务器中的8080端口映射到容器中的8085(项目中端口配置的是8085)端口
```

7. 访问网站

直接浏览器访问： http://你的服务器ip地址:8080/

http://101.34.238.174:8080/
