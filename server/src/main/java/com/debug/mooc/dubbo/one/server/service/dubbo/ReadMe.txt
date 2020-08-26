
提供发布的dubbo服务类所在包,接口所在的子模块api里,即
com.debug.mooc.dubbo.one.api.service.Xxx

dubbo核心业务都在这个包名里,其实现则在本子模块server实现,即
com.debug.mooc.dubbo.one.server.service.dubbo.Xxx
因为本子模块有dubbo的注解

使用结构相同的推荐使用dubbo协议,因为就像调用本地的类的方法一样简单