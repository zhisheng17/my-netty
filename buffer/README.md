### netty-buffer

netty 4.0 之前，ByteBuf 叫 ChannelBuffer ，4.0 之后成为了单独项目 buffer，并且为了性能优化，加入了 BufferPool 之类的机制

### 资料

1、[Netty源码解读（二）Netty中的buffer](http://ifeve.com/netty-2-buffer/)

### 更新

ChannelBuffer  ——>  ByteBuf 

4.0 引入了 ByteBuf, 可以通过 ByteBufAllocator 实现来分配的池

### 准备写的文章

1、Netty 源码阅读之 ByteBuf

    https://www.cnblogs.com/xianyijun/p/5432884.html
    http://blog.csdn.net/u010853261/article/details/53690780

2、Netty 源码阅读之 DirectByteBuf VS HeapByteBuf

3、Netty 源码阅读之 CompositeBuffer

