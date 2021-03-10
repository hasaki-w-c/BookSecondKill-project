<!DOCTYPE html>
<html lang="ch_ZN">
<head>
<#--	<link rel="shortcut icon" href="#"/>-->
	<meta charset="UTF-8">
	<title>书城首页</title>
	<link type="text/css" rel="stylesheet" href="/static/css/style.css" >
	<script type="text/javascript" src="/static/jquery-1.7.2.js"></script>
</head>
<body>
	
	<div id="header" style="text-align: center">
			<img class="logo_img" alt="" src="/static/img/logo.gif">
			<span class="wel_word">网上书城</span>
	</div>
	<div id="main" style="text-align: center">
		<div id="book">

			<div class="b_list" style="text-align: center">
				<div class="img_div" style="text-align: center">
					<img class="book_img" alt="" src="/static/img/default.jpg">
				</div>
				<div class="book_info" style="text-align: center">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">${book.price?string('￥0.00')}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
				</div>
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