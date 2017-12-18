# Netty Project

Netty is an asynchronous event-driven network application framework for rapid development of maintainable high performance protocol servers & clients.

## Links

* [Web Site](http://netty.io/)
* [Downloads](http://netty.io/downloads.html)
* [Documentation](http://netty.io/wiki/)
* [@netty_project](https://twitter.com/netty_project)

## How to build

For the detailed information about building and developing Netty, please visit [the developer guide](http://netty.io/wiki/developer-guide.html).  This page only gives very basic information.

You require the following to build Netty:

* Latest stable [Oracle JDK 7](http://www.oracle.com/technetwork/java/)
* Latest stable [Apache Maven](http://maven.apache.org/)
* If you are on Linux, you need [additional development packages](http://netty.io/wiki/native-transports.html) installed on your system, because you'll build the native transport.

---

### Netty 系列源码分析

1、[Netty 源码阅读之初始环境搭建](http://www.54tianzhisheng.cn/2017/12/08/netty-01-env/)

## Netty4 以后版本新特性

Netty 4.0 新特性：https://github.com/netty/netty/wiki/New-and-noteworthy-in-4.0

Netty 4.1 与 4.0 的区别：https://github.com/netty/netty/wiki/New-and-noteworthy-in-4.1

因为我现在看的源码是 4.1 版本，且 4.0 版本以后区别和以前很大，所以我把 4.x 都了解下

---

博客参考：http://ifeve.com/netty-4-0-new/

更多关于 netty 的博客可以参考：

1、http://ifeve.com/category/netty/

2、http://cmsblogs.com/

项目包结构大改变

```
项目名                                     代码行数    描述                                          
netty-parent	                          230616    Maven parent POM
netty-all      	                          0         包含以上所有artifacts的All-in-one的JAR
netty-bom                                 0
netty-buffer	                          5988      ByteBuf API，用来替换java.nio.ByteBuffer
netty-codec	                              18547     编解码框架，用于编写encoder及decoder
netty-codec-dns                           2579
netty-codec-haproxy                       1773
netty-codec-http	                      32739     HTTP, Web Sockets, SPDY, and RTSP相关的编解码器
netty-codec-http2                         26233
netty-codec-memcache                      1801
netty-codec-mqtt                          2190 
netty-codec-redis                         1546
netty-codec-smtp                          796
netty-codec-socks	                      3832      SOCKS协议相关的编解码器
netty-codec-stomp                         1047
netty-codec-xml                           689
netty-common	                          9298      工具类及日志接口
netty-dev-tools                           0
netty-example	                          11129     样例
netty-handler	                          20382     ChannelHandler 的相关实现
netty-handler-proxy	                      1849    
netty-microbench	                      5228      微基准测试（Microbenchmarks）
netty-resolver                            861
netty-resolver-dns                        5034
netty-tarball	                          0         Tarball distribution
netty-testsuite                           6190      整合的测试集
netty-testsuite-autobahn                  157       整合的测试集
netty-testsuite-osgi                      82        整合的测试集
netty-transport	                          23559     Channel API 及核心 transports
netty-transport-native-epoll              6228  	  Rxtx transport
netty-transport-native-kqueue             4499  	  
netty-transport-native-unix-common        1194  	
netty-transport-native-unix-common-tests  227	
netty-transport-rxtx	                  460        Rxtx transport
netty-transport-sctp	                  2007       SCTP transport
netty-transport-udt	                      2472       UDT transport
```

重要的几个：netty-codec、 netty-handler、 netty-transport、 netty-buffer

netty-codec 代码量：        93772

netty-handler 代码量：      22231

netty-transport 代码量：    40646

netty-buffer 代码量：       5988

统计代码行数的脚本：

[Try.java](./Try.java)

```
public static void main(String[] args) throws Exception {
    long count = Files.walk(Paths.get("C:\\JetBrains\\IDEAProject\\netty\\transport-udt"))    // 递归获得项目目录下的所有文件
            .filter(file -> !Files.isDirectory(file))   // 筛选出文件
            .filter(file -> file.toString().endsWith(".java"))  // 筛选出 java 文件
            .flatMap(Try.of(file -> Files.lines(file), Stream.empty()))     // 将会抛出受检异常的 Lambda 包装为 抛出非受检异常的 Lambda
            .filter(line -> !line.trim().isEmpty())         // 过滤掉空行
            .filter(line -> !line.trim().startsWith("//"))  //过滤掉 //之类的注释
            .filter(line -> !(line.trim().startsWith("/*") && line.trim().endsWith("*/")))  //过滤掉/* */之类的注释
            .filter(line -> !(line.trim().startsWith("/*") && !line.trim().endsWith("*/")))     //过滤掉以 /* 开头的注释（去除空格后的开头）
            .filter(line -> !(!line.trim().startsWith("/*") && line.trim().endsWith("*/")))     //过滤掉已 */ 结尾的注释
            .filter(line -> !line.trim().startsWith("*"))   //过滤掉 javadoc 中的文字注释
            .filter(line -> !line.trim().startsWith("@Override"))   //过滤掉方法上含 @Override 的
            .count();
    System.out.println("代码行数：" + count);
}
```

