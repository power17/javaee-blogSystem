<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<style>
    .content_item {
        height: 160px;
        position: relative;
    }

    .content_item img {
        position: absolute;
        right: 10px;
        top: 10px;
        width: 250px;
        height: 140px;
    }

</style>
<!-- 内容区 -->
<section class="layout main-wrap  content">
    <section class='col-main'>

        <article class="mainarea" style="display:block;">
            <div class="blog-tab">

                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active" id="tab">
                        <%--分类信息--%>
                        <div id="lk_blog_two" class="container">
                            <div class="row">
                                <button class="btn-tag">Mysql</button>
                                <button class="btn-tag">面向对象</button>
                                <button class="btn-tag">jdbc</button>
                                <button class="btn-tag">web服务器</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
        <!--博客社区-->
        <article class="mainarea" style="display:block;">
            <div class="blog-tab">

                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active" id="home">

                        <div id="lk_blog_list" class="container">
                            <div class="row">
                                <ul class="blog-list" id="content">
                                    <li class="content_item">
                                        <div class="blog-list-left" style="float: left;">
                                            <div class="main-title">
                                                <a href="detail.jsp">标题标题标题标题标题标题</a>
                                            </div>
                                            <p class="sub-title">描述描述描述描述描述描述描述描述</p>
                                            <div class="meta">
                                                2020-08-31
                                            </div>
                                        </div>
                                        <img src="images/blog_img.png" alt="" class="img-rounded">
                                    </li>
                                    <li class="content_item">
                                        <div class="blog-list-left" style="float: left;">
                                            <div class="main-title">
                                                <a href="detail.jsp">标题标题标题标题标题标题</a>
                                            </div>
                                            <p class="sub-title">描述描述描述描述描述描述描述描述</p>
                                            <div class="meta">
                                                2020-08-31
                                            </div>
                                        </div>
                                        <img src="images/blog_img.png" alt="" class="img-rounded">
                                    </li>
                                    <li class="content_item">
                                        <div class="blog-list-left" style="float: left;">
                                            <div class="main-title">
                                                <a href="detail.jsp">标题标题标题标题标题标题</a>
                                            </div>
                                            <p class="sub-title">描述描述描述描述描述描述描述描述</p>
                                            <div class="meta">
                                                2020-08-31
                                            </div>
                                        </div>
                                        <img src="images/blog_img.png" alt="" class="img-rounded">
                                    </li>
                                </ul>
                                <div id="page" class="page_div"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
    </section>

</section>
<footer id="lk_footer">
    <div class="container">
        <div class="footer-top">
          <!--分页-->
        </div>
        <div class="footer-bottom col-sm-offset-2 hidden-sm hidden-xs">
            <ul>
                <li><a href="">学科报名</a></li>
                <li><a href="">师资团队</a></li>
                <li><a href="">线上公开课</a></li>
                <li><a href="">联络我们</a></li>
                <li><a href="">支持我们</a></li>
                <li><a href="">沪ICP备 18026591号-1</a></li>
            </ul>
        </div>
    </div>
</footer>
<script>
    $.post("${ctx}/web_getPageList.action",function (data) {
        console.log(data);
    })


    //分页
    $("#page").paging({
        pageNo:3 ,
        totalPage: 4,
        totalSize: 20,
        callback: function(num) {

        }
    });
</script>

</body>
</html>