# 运行依赖

## 指定仓库

因目前框架是SNAPSHOT版本，故需要在maven的pom文件中指定中心仓库位置

```xml

<repositories>
    <!-- snapshots版本,中央仓库不同步,需要指定如下仓库 -->
    <repository>
        <id>matrix-snapshot</id>
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots/</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>
```

## 引入springboot依赖

```xml

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>3.0.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## 指定编译版本

框架是基于JDK17编译

```xml

<maven.compiler.source>17</maven.compiler.source>
<maven.compiler.target>17</maven.compiler.target>
```

# 运行参数

在框架的依赖中，Jdk9以后，存在一些模块化方面的冲突，在运行时，需要增加如下参数;

```
--add-opens java.base/java.lang=ALL-UNNAMED
```

# 运行配置

框架使用自己的核心配置处理机制，相关的配置文件会位于matrix-framework目录，目录位置的指定可以是以下几种方式：

## 应用的classpath也就是maven代码结构的resources目录

```
src/main/resources
```

## 使用-D参数指定到任意位置

```
-DconfigRoot={location}
```

## 在springboot的application配置文件中使用import指定任意位置

```
spring.config.import=matrix://{location}
```

## 配置文件说明

### jdbc.properties

配置多个数据源

### logback.xml

日志输出配置

### codegenerator.xml

DDD结构代码生成配置

# 使用data模块

## 运行依赖

```xml
<!-- matrix-data module -->
<dependency>
    <groupId>wang.liangchen.matrix</groupId>
    <artifactId>matrix-framework-data-spring-boot-starter</artifactId>
    <version>${version.matrix}</version>
</dependency>
        <!-- 引入MySQL或者PostgreSQL连接器 -->
```

## 启用模块

```
@EnableJdbc
```

## 切换数据源

在方法上标注注解，可实现嵌套切换数据源。*注意相关的类和方法必须是被spring代理的

```
@DataSourceAssign("primary")
```

# 使用基于数据库的分布式锁

## 运行依赖

```xml
<!-- matrix-lock -->
<dependency>
    <groupId>wang.liangchen.matrix</groupId>
    <artifactId>matrix-framework-lock-spring-boot-starter</artifactId>
    <version>${version.matrix}</version>
</dependency>
```

## 启用模块

```
@EnableLock
```

## 使用方法

### 普通方法

注解的普通方法，必须有返回值

```java
public class Example {
    @MatrixLock(lockGroup = "group", lockKey = "key", lockAtLeast = "1m", lockAtMost = "5m")
    public String lock() {
        ThreadUtil.INSTANCE.sleep(TimeUnit.SECONDS, 1);
        return "lock is acquired by:" + Thread.currentThread().getName();
    }
}
```

### 结合spring的@scheduled注解

此类方法必须为void

```java
public class Example {
    @Scheduled(fixedDelay = 20)
    @MatrixLock(lockGroup = "group", lockKey = "key_1", lockAtLeast = "1m", lockAtMost = "5m")
    public void executeInLock() {
        ThreadUtil.INSTANCE.sleep(TimeUnit.SECONDS, 10);
        System.out.println("=======> executeInLock");
    }
}
```

# 基于数据库的序列号

```
Long number = SequenceUtil.INSTANCE.sequenceNumber(sequenceKey);
```

# 使用web模块

## 运行依赖

```xml
<!-- matrix-web module -->
<dependency>
    <groupId>wang.liangchen.matrix</groupId>
    <artifactId>matrix-framework-web-spring-boot-starter</artifactId>
    <version>${version.matrix}</version>
</dependency>
```

## 启用模块

```
@EnableWeb
```

## 主要特征

* 所有的响应均不使用http status表达状态，框架尽可能将所有响应处理成200。前端只需根据响应体中的success和code进行逻辑判断，无需关注多个因素。
* 可将参数requestId自动封装至响应体和响应头，用于前端标识一个请求
* 404状态被特殊处理，返回格式化的响应
* 支持格式化void返回
* 支持格式化直接对象返回
* 支持使用异常处理流程,异常全局处理后格式化返回
* 支持使用ReturnWrapper处理流程，用于用户显式封装正常或异常的返回
* 支持sse和deferredResult方式的长轮询

# 多级缓存使用
matrix-cache 是一个多级缓存框架，使用CacheAsidePattern懒加载数据。初次请求步骤如下：
* 读取节点本地缓存
* 读取分布式缓存(redis)
* 读取数据库
* 写分布式缓存
* 写节点本地缓存
## 运行依赖

```xml
<!-- matrix-cache
<dependency>
    <groupId>wang.liangchen.matrix.cache</groupId>
    <artifactId>matrix-cache-sdk-spring-boot-starter</artifactId>
    <version>${version.matrix}</version>
</dependency>
-->
<!-- matrix-cache enable local cache
<dependency>
   <groupId>com.github.ben-manes.caffeine</groupId>
   <artifactId>caffeine</artifactId>
</dependency>
-->
<!-- matrix-cache enable distributed cache
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
</dependency>
-->
```

## 缓存使用

兼容SpringCache所有注解。增强细粒度（缓存级）缓存过期注解。

```
@CacheExpire(ttl=5,TimeUtil = TimeUtil.SECOND)
```