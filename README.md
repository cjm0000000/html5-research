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

#### HTML页面结构
    <!DOCTYPE html>
    <html lang="cn">
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="green120@126.com">
    <title>在线下单</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/bootstrap/css/sticky-footer-navbar.css">
    <style>
        .json-result {
            width: 400px;
            height: 60px;
            display: block;
            position: absolute;
            top: 10px;
            left: 50%;
            margin-left: -200px;
            margin-top: -30px;
        }
    </style>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/bootstrap/assets/js/html5shiv.js"></script>
    <script src="/bootstrap/assets/js/respond.min.js"></script>
    <![endif]-->
    </head>
    <body style="padding-top: 70px;">
    <div id="wrap" class="page-container">
    ### 顶部导航模板
    #parse("nav-bar.vm")

    ### 面包屑导航模板
    #parse("breadcrumb-nav.vm")

    <!-- Bootstrap core JavaScript -->
    <script src="/bootstrap/assets/js/jquery-1.10.2.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    ### Main模板
    #parse("${mainViewName}.vm")
    </div>
    <!-- /container -->

    ### 底部模板
    #include("footer.vm")
    </body>
    </html>

所有的页面都按照这个模板来生成（此模板根据Bootstrap的资源构建）。这个模板包含了4个子模板：顶部的导航模板、面包屑导航模板、Main模板以及底部模板。我们最需要关注的时Main模板，通过动态加载Main模板，来帮助我么用这个模板加载不同的页面。

#### 显示订单提交页面
这个页面本来是个静态的HTML页面，但是这里为了简单说明另外一个问题——如何把后端数据展示给用户。就先从后端读取订单数据，填充到表单。  
后端代码（`RoleAction`）如下：  

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public ModelAndView showOrder() {
        String templateName = "order";
        Order order = createOrder();
        ModelAndView mv = new ModelAndView("index", "mainViewName", templateName);
        mv.addObject("model", order);
        return mv;
    }
关键点：通过配置的`mainViewName`来找到对应的模板文件。

前端模板代码（`order.vm`）如下：

    <link rel="stylesheet" href="/bootstrap/plugins/select/css/bootstrap-select.min.css">
    <div class="container">
    <h3>寄 件</h3>
    <div class="well" id="orderForm">
        <h4>寄件人信息</h4>
        <hr/>
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="sendName" class="col-md-1 control-label">姓 名</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="sendName" name="sender.name" value="$!model.sender.name" placeholder="寄件人姓名">
                </div>
            </div>
            <div class="form-group">
                <label for="sendPhone" class="col-md-1 control-label">手机/固话</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="sendPhone" name="sender.phone" value="$!model.sender.phone" placeholder="寄件人手机号码或者固话">
                </div>
            </div>
            <div class="form-group">
                <label for="sendAddr" class="col-md-1 control-label">上门地址</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="sendAddr" name="sender.addr" value="$!model.sender.addr" placeholder="上门收件地址">
                </div>
            </div>
            <h4>收件人信息</h4>
            <hr/>
            <div class="form-group">
                <label for="recvName" class="col-md-1 control-label">姓 名</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="recvName" name="recver.name" value="$!model.recver.name" placeholder="收件人姓名">
                </div>
            </div>
            <div class="form-group">
                <label for="recvPhone" class="col-md-1 control-label">手机/固话</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="recvPhone" name="recver.phone" value="$!model.recver.phone" placeholder="收件人手机号码或者固话">
                </div>
            </div>
            <div class="form-group">
                <label for="recvAddr" class="col-md-1 control-label">收货地址</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="recvAddr" name="recver.addr" value="$!model.recver.addr" placeholder="收件人地址">
                </div>
            </div>
            <h4>物品信息</h4>
            <hr/>
            <div class="form-group">
                <label for="weight" class="col-md-1 control-label">重 量</label>
                <div class="col-md-2">
                    <select class="selectpicker" id="weight" name="goods.weight" value="$!model.goods.weight" data-width="100%">
                        <option value="1" selected> 1公斤以下 </option>
                        <option value="2"> 1-5公斤</option>
                        <option value="3"> 5公斤以上 </option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-md-10">
                    <div class="checkbox">
                        <label>
                            <input name="goods.sign" value="1" type="checkbox"> 我的货物不重，但是体积很大
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-md-10">
                    <button class="btn btn-success" id="saveOrder">确认下单</button>
                    <button type="reset" class="btn btn-danger">重 置</button>
                </div>
            </div>
        </form>
    </div>
    </div>
    <script src="/bootstrap/plugins/select/js/bootstrap-select.min.js"></script>
    <script src="/js/plugins/jquery.form.min.js"></script>
    <script src="/js/order.js"></script>
    <script>
    $('select').selectpicker();
    </script>

这个页面其实是一个加入Bootstrap样式的HTML脚本，中间嵌入了一些Velocity脚本。

通过jQuery（`order.js`）来交互：

    $("#saveOrder").on('click', function(){
        $('#saveOrder').attr('disabled',true);
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
    });

通过Ajax方式提交表单到后端接口`orders/create`。

后端如何处理：

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String create(@Valid Order order, BindingResult br) {
        if (br.hasErrors()) {
            return validateError(br.getFieldError().getField(), br.getFieldError().getDefaultMessage());
        }
        // 这里省略N行。。。
        return info("下单成功。");
    }
    
后端采用JSON和前端通信，这个方法还做了简单的Validation（`JSR-303/JSR-349 Bean Validation`）。

PS：所有实例代码都可以在当前工程找到。

### 自动化测试
待续……