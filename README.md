#### demo show

[点击查看演示地址](http://sauzny.github.io/ext/j/z3.html)

#### 一、简述
最近用java做了一个和图片相关的功能，发现了一个开源项目[cognitivej](https://github.com/CognitiveJ/cognitivej)，这个项目使用的是jdk1.8，gradle编译，所以学习了一下java8和gradle。

**需要**

*   Java 8
*   微软注册开发者key ([免费注册](https://www.microsoft.com/cognitive-services/))
*   依赖仓库JCente

#### 二、功能描述
基于CognitiveJ（Image Analysis in Java）做一个识别图片的webservice。包括五官标记，性别年龄，图片描述功能。

**使用技术**

| 技术名字 | 描述 |
|--------|--------|
| spring-boot | spring框架，提供web容器三种，tomcat（默认）、jetty、undertow，我使用的是undertow |
| gradle | 一种基于maven或者ant的打包工具 |
| bootstrap | 前端框架，封装了很多css+js的功能组件，插件丰富 |

#### 三、java相关

- java8时间工具包
- 获取applicationContext
- spring boot 指定外部静态资源

#### 四、gradle

- eclipse-gradle插件的使用
- build文件中，引入依赖，排除依赖，设置字符集

#### 五、web前端

- bootstrap fileupload 插件的使用
- http跨域问题

** 列出问题，详细信息之后继续补充 **