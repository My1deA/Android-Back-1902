<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	<link rel="stylesheet" type="text/css" href="css/login.css" />
		 <link rel="stylesheet" href="css/head.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css" />
	</head>

	<body>
<div class="dvhead">
	<div class="dvlogo"><a href="index.html">你问我答</a></div>
	<div class="dvsearch">10秒钟注册账号，找到你的同学</div>
	<div class="dvreg">
		已有账号，立即&nbsp;<a href="login.html">登录</a>
	</div>
</div>
		<section class="sec">
		<form action="${pageContext.request.contextPath}/UserAction_register " method="post">
			<div class="register-box">
				<label for="username" class="username_label">
					用 户 名
					<input maxlength="20" name="username" type="text"
						placeholder="您的用户名和登录名" />
				</label>
				<div class="tips">

				</div>
			</div>
			<div class="register-box">
				<label for="username" class="other_label">
					设 置 密 码
					<input maxlength="20" type="password" name="password"
						placeholder="建议至少使用两种字符组合" />
				</label>
				<div class="tips">

				</div>
			</div>
			<div class="register-box">
				<label for="username" class="other_label">
					确 认 密 码
					<input maxlength="20" type="password" placeholder="请再次输入密码" />
				</label>
				<div class="tips">

				</div>
			</div>
			
			<div class="register-box">
				<label for="username" class="username_label">
					真实姓名
					<input maxlength="20" name="name" type="text"
						placeholder="您的真实姓名" />
				</label>
				<div class="tips">
				</div>
			</div>
			
			
			<div class="register-box">
				<label for="username" class="username_label">
					邮箱
					<input maxlength="20" name="email" type="text"
						placeholder="您的邮箱" />
				</label>
				<div class="tips">
				</div>
			</div>
			
			<div class="register-box">
				<label for="username" class="username_label">
					手机号
					<input maxlength="20" name="telephone" type="text"
						placeholder="您的手机号" />
				</label>
				<div class="tips">
				</div>
			</div>
	
			<div class="arguement">
				<input type="checkbox" id="xieyi" />
				阅读并同意
				<a href="javascript:void(0)">《错题用户注册协议》</a>
				<a href="login.html">已有账号,立即登录</a>
				<div class="tips">
				</div>
			</div>
			<div class="submit_btn">
				<button type="submit" id="submit_btn">
					立 即 注 册
				</button>
			</div>
		</form>
		</section>
		<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
