#### demo show

[点击查看演示地址](http://sauzny.github.io/ext/j/z3.html)

### 一、简述
最近用java做了一个和图片相关的功能，发现了一个开源项目[cognitivej](https://github.com/CognitiveJ/cognitivej)，这个项目使用的是jdk1.8，gradle编译，所以学习了一下java8和gradle。

**需要**

*   Java 8
*   微软注册开发者key ([免费注册](https://www.microsoft.com/cognitive-services/))
*   依赖仓库JCente

### 二、功能描述
基于CognitiveJ（Image Analysis in Java）做一个识别图片的webservice。包括五官标记，性别年龄，图片描述功能。

**使用技术**

| 技术名字 | 描述 |
|--------|--------|
| spring-boot | spring框架，提供web容器三种，tomcat（默认）、jetty、undertow，我使用的是undertow |
| gradle | 一种基于maven或者ant的打包工具 |
| bootstrap | 前端框架，封装了很多css+js的功能组件，插件丰富 |

### 三、java相关

eclipse如不过不支持java8，可自行安装插件，eclipse中依次打开“Help”–》“Eclipse Marketplace”,在搜索栏中输入“java8”进行搜索

#### 1）java8时间工具包

* 输出一个带有时区的时间戳：`LocalDateTime.now().toString()+ZonedDateTime.now().getOffset().toString();`
* 输出结果：`2016-08-30T10:57:11.544+08:00`

#### 2）获取applicationContext

* 需要在一个不在spring容器中的类中引入一个spring管理的实例。
* 使用实例名字获取一个spring管理的实例。

启动函数：
```
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		final ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

		//初始化时，记录applicationContext
		SpringUtils.setApplicationContext(applicationContext);
	}
}
```
SpringUtils：
```
public final class SpringUtils {

	private SpringUtils(){}

	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtils.applicationContext = applicationContext;
	}

}
```

#### 3）spring boot 指定外部静态资源&&跨域设置

```
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Autowired private CommonConfUtils commonConfUtils;

	/**
	 * 	方法描述:  静态资源映射
	 *
	 *  @author : ljx 创建时间 2016年8月26日 上午11:04:24
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/tempUpPath/**")
        	.addResourceLocations("file:///"+commonConfUtils.getTempUpPath());

        registry.addResourceHandler("/tempDownPath/**")
        	.addResourceLocations("file:///"+commonConfUtils.getTempDownPath());

        super.addResourceHandlers(registry);
    }

	/**
	 * 	方法描述:  跨域设置
	 *
	 *  @author : ljx 创建时间 2016年8月26日 下午3:36:16
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/c/**").allowedOrigins("*")
				.allowedMethods("POST", "GET", "OPTIONS")
				.allowedHeaders("Content-Type", "Accept", "X-Requested-With")
				.allowCredentials(true)
				.maxAge(3600);
	}

}
```

#### 四、gradle

#### 1）win-gradle安装

* [官网下载地址](https://gradle.org/gradle-download/)
* 选择Complete distribution (binaries, sources and offline documentation)
* 配置环境变量`C:\gradle-2.14.1\bin`
* 检查配置结果`gradle -v`

![win-gradle.png](ext/win-gradle.png)

#### 2）eclipse-gradle插件的使用

1.eclipse中依次打开“Help”–》“Eclipse Marketplace”,在搜索栏中输入“buildship”进行搜索；
![buildship.png](ext/buildship.png)

2.点击install，等待安装完成，按照提示重启eclipse即可。

3.安装成功后，可以在Window–>Show View–>Others…中和File–>New–> Other…中看到增加的Gradle选项。配置gradle的目录。

4.在eclipse中创建gradle-progect，new project选择 gradle， 一直下一步。

![gradle-java-01.png](ext/gradle-java-01.png)

创建项目结果

![gradle-java-02.png](ext/gradle-java-02.png)

调整eclipse试图，在Window–>Show View–>Others…中选择 gradle task

![gradle-java-03.png](ext/gradle-java-03.png)

在gradle task视图中，build可以编译项目，项目根目录下生成build文件夹

![gradle-java-04.png](ext/gradle-java-04.png)

#### 3）gradled的配置文件build，引入依赖，排除依赖，设置字符集

build.gradle

```

// 局部变量使用关键字def声明，从配置文件中获取，版本号

def groupString = "com.sauzny"
def artifactId = "gradlejava"
def versionString=file('src/main/resources/version.txt').text.trim()

println ""
println "//自定义输出//////////////////////////////////"
println "//"
println "//  groupString : " + groupString
println "//  artifactId : " + artifactId
println "//  versionString : " + versionString
println "//"
println "//////////////////////////////////////////"
println ""

// project的属性
group = groupString
version = versionString

// 构建脚本
buildscript {

	// 自定义属性，使用ext扩展块可以一次添加多个属性
	ext {
		springBootVersion = '1.4.0.RELEASE'
	}

	repositories {

		// 本地系统文件
		//ivy { url "../local-repo" }

		// 本地 maven 仓库
		//mavenLocal()

		// 远程 maven 仓库
		//maven { url "http://repo.mycompany.com/maven2" }

		// maven中央仓库
		mavenCentral()

		// jcenter中央仓库
		//jcenter()
	}

	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
	}
}

// 依赖的插件 java

// java插件添加的task
// build task 		当运行gradle build命令时		Gradle将会编译和测试你的代码，并且创建一个包含类和资源的JAR文件。
// clean task 		当运行gradle clean命令时		Gradle将会删除build生成的目录和所有生成的文件。
// assemble task 	当运行gradle assemble命令时	Gradle将会编译并打包代码，但是并不运行单元测试。
// check task 		当运行gradle check命令时		Gradle将会编译并测试你的代码，其他的插件会加入更多的检查步骤。

// task build - clean 删除项目根目录下生成build文件夹
// task build - bulid 打包，在项目根目录下生成build文件夹，build之前先clean
apply plugin: 'java'

// 依赖的插件  eclipse spring-boot groovy
apply plugin: 'eclipse'
apply plugin: 'spring-boot'
apply plugin: 'groovy'

// maven-publish task: publish - publishToMavenLocal 发布到本地maven仓库 默认的.m2中
// publish只是将根目录中的build文件中的内容移动过去，所以 应该 clean -> build -> publishToMavenLocal
// 引入其他配置文件
apply plugin: 'maven-publish'
apply from: file('publish.gradle')


//编译时使用的java版本，设置字符集
sourceCompatibility = 1.8
targetCompatibility = 1.8
[compileJava, compileTestJava, javadoc]*.options*.encoding = 'UTF-8'

// 仓库
repositories {

		// 本地系统文件
		//ivy { url "../local-repo" }

		// 本地 maven 仓库
		//mavenLocal()

		// 远程 maven 仓库
		//maven { url "http://repo.mycompany.com/maven2" }

		// maven中央仓库
		//mavenCentral()

		// jcenter中央仓库
		jcenter()
}

// 依赖
dependencies {


	// 编译阶段
	compile ('org.springframework.boot:spring-boot-starter-web') {
		// 排除tomcat的依赖
		exclude group: 'org.springframework.boot', module: 'spring-boot-starter-tomcat'
	}

	compile ('org.springframework.boot:spring-boot-starter-undertow')

    compile 'org.slf4j:slf4j-api:1.7.21'
    compile 'cognitivej:cognitivej:0.6.2'
    compile 'org.projectlombok:lombok:1.16.10'
	compile 'commons-fileupload:commons-fileupload:1.3.2'
    compile "net.coobird:thumbnailator:0.4.8"


	// 测试阶段
	testCompile('org.springframework.boot:spring-boot-starter-test')
    testCompile 'junit:junit:4.12'
}

eclipse {
	classpath {
		 containers.remove('org.eclipse.jdt.launching.JRE_CONTAINER')
		 containers 'org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8'
	}
}

// 排除资源文件
processResources {
    exclude { "随便写点什么就能将所有的资源文件排除，我也没有找到指定文件的排除方法"}
}

```

publish.gradle

```
// 局部变量使用关键字def声明，从配置文件中获取，版本号

def groupString = "com.sauzny"
def artifactId = "gradlejava"
def versionString=file('src/main/resources/version.txt').text.trim()

group = groupString
version = versionString

// custom tasks for creating source/javadoc jars
task sourcesJar(type: Jar, dependsOn: classes) {
    classifier = 'sources'
    from sourceSets.main.allSource
}

task javadocJar(type: Jar, dependsOn: javadoc) {
    classifier = 'javadoc'
    from javadoc.destinationDir
    javadoc.failOnError = false
}

// add javadoc/source jar tasks as artifacts
artifacts {
    archives sourcesJar, javadocJar
}

task release() {
    dependsOn 'assemble', 'bintrayUpload'
}

publishing {
    publications {
        mavenJava(MavenPublication) {
            from components.java
            artifact sourcesJar
            artifact javadocJar
        }
    }
}


//apply plugin: 'maven' -- 未知是否需要
//上传到nexus -- 未测试
//uploadArchives {
//    repositories {
//        mavenDeployer {
//            repository(url: "http://localhost:8081/nexus/content/repositories/thirdparty") {
//                authentication(userName: "admin", password: "admin123")
//            }
//            pom.groupId = group
//            pom.artifactId = artifactId
//            pom.version = version
//        }
//    }
//}

```

### 五、web前端

#### 1）bootstrap fileupload 插件的使用

依赖版本：

![bootstrap-3.x-blue](https://img.shields.io/badge/bootstrap-3.x-blue.svg)
![bootstrap-3.x-blue](https://img.shields.io/badge/jquery-2.x-blue.svg)

[bootstrap fileupload 官方地址](http://plugins.krajee.com/file-input)

在官方页面中注意：

[必备](http://plugins.krajee.com/file-input#pre-requisites)，版本依赖

[下载](http://plugins.krajee.com/file-input#manual-install)，zip包

[举例](http://plugins.krajee.com/file-input/demo)，我看了半天也看的不是很明白……

下面是我使用的代码

js脚本代码片段：
```
<script type="text/javascript">
    $(document).ready(function(){
		initFileInput('multipart');
		callback();
    });

// 组件初始化
function initFileInput(ctrlName) {
    var control = $('#' + ctrlName);
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: ip_port+"gradlejava/c/attributes/detectFacialLandmarksExample?upType=multipart", //上传的地址
        allowedFileExtensions : ['jpeg', 'jpg', 'png','gif']//接收的文件后缀
    });
}

//回调函数
function callback(){
	$("#multipart").on("fileuploaded", function (event, data, previewId, index) {

        console.log(data);

        var imageUrl = data.response.imageUrl;
        if (imageUrl == undefined) {
            toastr.error('文件格式类型不正确');
            return;
        }
    });
}

</script>
```

html代码片段：

```
		<div class="container kv-main">
            <form enctype="multipart/form-data">
                <input id="multipart" name="multipart" type="file" multiple >
            </form>
            </div>
        </div>
```

#### 2）http跨域问题

（在服务器端设置了允许跨域，spring-boot设置）

post在跨域时会先向服务器端发送一个options的请求，设置（xmlhttprequest对象）request.setRequestHeader('X-Request-With', null);可以使客户端不发送options请求。


### 六、遗留问题

- 对java8的使用，学习lambda表达式以及其他新的特性，使用在代码中
- spring-boot的定时任务，增加对临时文件目录的监控，压缩或者删除文件，避免磁盘占用过多
- 对gradle的学习，配置文件中的个属性的作用，编写自己的Groovy脚本

**列出问题，详细信息之后继续补充**