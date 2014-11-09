本项目用于研究不同UI技术的适用场景
===

### 比较流行的前端框架
我了解的比较典型的前端技术主要有：[ExtJS](http://www.sencha.com/products/extjs/), [jQuery](http://jquery.com/), [Bootstrap](https://github.com/twbs/bootstrap)。
我不太了解但是还算流行的技术有：[AngularJS](https://angularjs.org/), [KISSY](http://docs.kissyui.com/5.0/)。

以下是一个大致的对比图：

<table>
	<tr>
		<th>类库/框架</th>
		<th>License</th>
		<th>优点</th>
		<th>缺点</th>
		<th>适用场景</th>
	</tr>
	<tr>
		<td>ExtJS</td>
		<td>GPL 3.0</td>
		<td>非常完善的组件和UI，容易构建复杂的页面</td>
		<td>收费；学习成本高；运行性能比较一般；类库比较巨大，网络环境差的时候尤其明显</td>
		<td>内部系统，复杂的企业系统</td>
	</tr>
	<tr>
		<td>jQuery</td>
		<td>MIT</td>
		<td>体积小；学习成本低；丰富的DOM选择器；插件丰富；几乎是JS的标准</td>
		<td>无法向后兼容；插件质量层次不齐</td>
		<td>各种场景都适合</td>
	</tr>
	<tr>
		<td>Bootstrap</td>
		<td>MIT</td>
		<td>体积小，性能高；响应式；移动优先；可定制化</td>
		<td>不兼容IE8以下浏览器</td>
		<td>页面结构不复杂的互联网站点：web、wap等</td>
	</tr>
	<tr>
		<td>AngularJS</td>
		<td>MIT</td>
		<td>MVC框架（上面三者确切的说是类库），上手相对容易，支持Ioc；模板功能丰富强大；绑定</td>
		<td>比较笨重（集大成）；复杂的应用场景，性能不高</td>
		<td></td>
	</tr>
	<tr>
		<td>KISSY</td>
		<td>MIT</td>
		<td>KISSY 是一款跨终端、模块化、高性能、使用简单的 JavaScript 框架</td>
		<td>未明确</td>
		<td>淘宝用的就是它</td>
	</tr>
</table>

### JavaScript VS ActionScript

都是基于[ECMAScript](http://zh.wikipedia.org/zh-cn/ECMAScript)。
之间的区别可以看[一篇StackOverFlow上的文章](http://stackoverflow.com/questions/2268276/what-are-the-key-differences-between-javascript-and-actionscript-3)。

### JS编码规范
建议参考谷歌的规范：[Google JavaScript Style Guide](http://google-styleguide.googlecode.com/svn/trunk/javascriptguide.xml).

这里讲的比较全面了。

### jQuery
几乎任何项目都可以用jQuery。目前最新版`1.11.1`不到100KB，可称得上小巧了。jQuery在DOM操作上很方便，有非常丰富的selector。对于重量型的富客户端项目也可以用`jQuery-EasyUI`来取代`ExtJS`。

#### 详细的API
jQuery的[API](http://api.jquery.com/)写的非常详尽，每个函数除了说明外，还会带上示例代码，帮助我们更好地理解。
#### 强大的Selector
jQuery具备非常强大的DOM选择器，我们可以根据ID, CSS, XPATH等来操作DOM节点，我们可以用各种方式获取到下面的DIV。

    <div id="id" name="name" class="div-wrap"></div>

- by ID        $('#id')  
- by CSS       $('.div-wrap')  
- by XPATH     $("div[name='name']")  

#### 方便的AJAX操作
- GET  
- 
    var jqxhr = $.get( "example.php", function() {
        alert( "success" );
    }).done(function() {
        alert( "second success" );
    }).fail(function() {
        alert( "error" );
    }).always(function() {
        alert( "finished" );
    });

- POST  
- 
    $.post( "example.php", function() {
        alert( "success" );
    }).done(function() {
        alert( "second success" );
    }).fail(function() {
        alert( "error" );
    }).always(function() {
        alert( "finished" );
    });

- Ajax Form（需要`jquery.form`插件）
- 
    $('.form-horizontal').ajaxSubmit({
        url: '/orders/create',
        type: 'post',
        success: function(responseText){
            var res = $.parseJSON(responseText);
            if(res.success){
                var form = $("#orderForm");
                form.empty();
                form.append(res.msg);
            }else{
                cleanErrorCss();
                $("input[name='"+ res.field +"']").parent().parent().addClass('has-error');
                $('#saveOrder').attr('disabled',false);
            }
        }
    });

#### 丰富的插件
http://plugins.jquery.com/

### Bootstrap
[Bootstrap](https://github.com/twbs/bootstrap)是Twitter开源的CSS框架。它在GitHub的收藏数超过了7万，非常热门。通过Bootstrap我们可以快速地构建风格统一的HTML5页面。  
Bootstrap也具备非常完整的文档：[English](http://getbootstrap.com/getting-started/)、[中文](http://v3.bootcss.com/)。

#### 丰富的插件
Bootstrap本身提供了不多的功能，要实现一些酷炫的效果，需要借助一些第三方插件，以下是我用到的一些插件：  
- [select](https://github.com/silviomoreto/bootstrap-select)  
- [switch](https://github.com/nostalgiaz/bootstrap-switch)  
- [model](https://github.com/jschr/bootstrap-modal)  
- [datetimepicker](https://github.com/tarruda/bootstrap-datetimepicker)  

### 后端选型
对于后端选型，要求能够方便返回JSON，也能方便返回HTML，很多MVC框架都能胜任。这里会推荐Spring自家的MVC框架——[SpringMVC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)。个人觉得它功能强大，优雅并且简单。

#### 返回JSON（Ajax）还是返回HTML
根据应用场景，个人建议交互不强的页面用HTML，交互强的用Ajax。

#### JSP还是模板
JSP固然是最简单的，但是个人觉得也最容易把代码写烂，所以我不推荐JSP。用模板技术，虽然增加一些学习成本，但是等掌握了模板以后会更加高效，并且代码容易保持简洁。  
Java世界比较出名的两种模板技术是[Velocity](http://velocity.apache.org/)和[FreeMarker](http://freemarker.org/)。在这两者之间如何做选择，其实不那么重要，选一种深入学习即可。

### 一个简单的案例

#### 选型
为了简化，这里把持久化以及复杂的业务逻辑省略了。
本着研究的目的，这里选择了Spring4.1.1作为核心框架（包含Ioc + MVC），采用`Velocity`作为模板引擎，`Bootstrap`和`jQuery`作为页面交互组件。实现一个很简单的页面：订单提交。

