<!DOCTYPE html>
<html lang="ch-ZN">
<head>
    <meta charset="UTF-8">
    <title>订单页面</title>
    <link type="text/css" rel="stylesheet" href="/static/css/style.css" >
    <script type="text/javascript" src="/static/jquery-1.7.2.js"></script>
</head>
<body>

<div id="header" style="text-align: center">
    <img class="logo_img" alt="" src="/static/img/logo.gif" >
    <span class="wel_word">创建订单</span>
</div>
<div id="main" style="text-align: center">
    <div id="book" style="text-align: center">

        <div class="b_list" style="text-align: center">
            <div class="img_div">
                <img class="book_img" alt="" src="/static/img/default.jpg" />
            </div>
<#--            <div class="book_info">-->
<#--                <div class="book_name">-->
<#--                    <span class="sp1">书名:</span>-->
<#--                    <span class="sp2">${book.name}</span>-->
<#--                </div>-->
<#--                <div class="book_author">-->
<#--                    <span class="sp1">作者:</span>-->
<#--                    <span class="sp2">${book.author}</span>-->
<#--                </div>-->
<#--                <div class="book_price">-->
<#--                    <span class="sp1">价格:</span>-->
<#--                    <span class="sp2">${book.price?string('￥0.00')}</span>-->
<#--                </div>-->
<#--                <div class="book_sales">-->
<#--                    <span class="sp1">销量:</span>-->
<#--                    <span class="sp2">${book.sales}</span>-->
<#--                </div>-->
<#--                <div class="book_amount">-->
<#--                    <span class="sp1">库存:</span>-->
<#--                    <span class="sp2">${book.stock}</span>-->
<#--                </div>-->
<#--            </div>-->
        </div>

        <div style="background-color: #398a98">
            <h2>收件人：<span id="name">hasaki</span>&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<span>12345678910</span></h2><br>
            <h2>收货地址：<span>北京市海淀区xxx路xxx号</span></h2><br>
            <h2>商品单价：<span>￥9.9</span>&nbsp;&nbsp;&nbsp;&nbsp;购买数量：<span>1包</span></h2><br>
            <h2>商品总价：<span>￥9.9</span>&nbsp;&nbsp;&nbsp;&nbsp;邮费：<span>￥0.00</span></h2><br>
            <h2>实付款：<span style="color: red">￥9.9</span>&nbsp&nbsp&nbsp&nbsp<button style="color: red" id="btnPay" >支付订单</button></h2>
        </div>

    </div>


</div>

<div id="bottom">
		<span>
			hasaki书城.Copyright &copy;2020
		</span>
</div>
</body>
</html>