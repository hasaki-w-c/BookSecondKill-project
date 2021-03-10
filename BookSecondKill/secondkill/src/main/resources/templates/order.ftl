<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<link type="text/css" rel="stylesheet" href="/static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="/static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<div>
				<span>欢迎<span class="um_span"></span>光临hasaki书城</span>
				<a href="order.ftl">我的订单</a>
			</div>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>		
			<tr>
				<td><h4>${order.orderId}</h4></td>
				<td>${order.createTime?string('yyyy年MM月dd日')}</td>
				<td>${order.price?string('￥0.00')}</td>
				<td>
					<#if order.status = 0>
						未发货
						<#elseif order.status = 1>
							已发货
						<#else >
							已签收
					</#if>

				</td>
				<td>
					<#list orderItemList as o>
						<li>编号：${o.id}</li>
						<li>书名：${o.name}</li>
						<li>数量：${o.count}</li>
						<li>单价：${o.price?string('￥0.00')}</li>
						<li>总价：${o.totalPrice?string('￥0.00')}</li>
						******************************************************
					</#list>
				</td>
			</tr>
		</table>
		
	
	</div>
	
	<div id="bottom">
		<span>
			hasaki书城.Copyright &copy;2020
		</span>
	</div>
</body>
</html>