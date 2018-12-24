<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${ctx }/css/style.css"
          type="text/css" />
    <link rel="stylesheet" href="${ctx }/css/amazeui.min.css" />
    <link rel="stylesheet" href="${ctx }/css/pageStyle.css">

</head>
<body style="background:#f3f3f3;">

<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">文章管理
        </strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 新增</button>
                </div>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">

        </div>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input type="text" class="am-form-field" id="input_search">
                <span class="am-input-group-btn">
                    <button class="am-btn am-btn-default" type="button" id="input_search_btn">搜索</button>
                </span>
            </div>
        </div>
    </div>
</div>

<div class="goods_list">
    <ul class="title_ul">
        <li>序号</li>
        <li>标题</li>
        <li>学科</li>
        <li>技能</li>
        <li>编辑</li>
        <li>删除</li>
    </ul>

    <s:iterator value="list">
        <ul class="list_goods_ul">
            <li>aaa</li>
            <li>bbb</li>
            <li>ccc</li>
            <li>ddd</li>
            <li>
                <a href="#">
                <img class="img_icon" src="${ctx }/images/edit_icon.png" alt=""></a>
            </li>
            <li>
                <a href="#">
                    <img class="img_icon" src="${ctx }/images/delete_icon.png" alt="">
                </a>
            </li>
        </ul>
    </s:iterator>
    <!--分页-->
    <div id="page" class="page_div"></div>
</div>

<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
<script>
    
    //分页
    $("#page").paging({
        pageNo:1,
        totalPage: 5,
        totalSize: 3,
        callback: function(num) {
          /*  $(window).attr('location','/article_list.action?currPage='+num);*/
            alert(num);
        }
    });

    $("#add").click(function () {
        alert("aaa");
        $(window).attr('location','${ctx }/mgr_add_article.jsp');
    });
</script>

</body>
</html>