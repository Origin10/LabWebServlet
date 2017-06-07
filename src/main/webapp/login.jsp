<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   <meta name="description" content="Bootstrap Admin App + jQuery">
   <meta name="keywords" content="app, responsive, jquery, bootstrap, dashboard, admin">
   <title>Angle - Bootstrap Admin Template</title>
   <!-- =============== VENDOR STYLES ===============-->
   <!-- FONT AWESOME-->
   <link rel="stylesheet" href="WEB-INF/vendor/fontawesome/css/font-awesome.min.css">
   <!-- SIMPLE LINE ICONS-->
   <link rel="stylesheet" href="WEB-INF/vendor/simple-line-icons/css/simple-line-icons.css">
   <!-- =============== BOOTSTRAP STYLES ===============-->
   <link rel="stylesheet" href="css/bootstrap.css" id="bscss">
   <!-- =============== APP STYLES ===============-->
   <link rel="stylesheet" href="css/app.css" id="maincss">
</head>

<body>
   <div class="wrapper">
      <div class="block-center mt-xl wd-xl">
         <!-- START panel-->
         <div class="panel panel-dark panel-flat">
            <div class="panel-heading text-center">
               <a href="#">
                  <h4>Logo</h4>
                  <img src="" alt="Image" class="block-center img-rounded">
               </a>
            </div>
            <div class="panel-body">
               <p class="text-center pv">SIGN IN TO CONTINUE.</p>
               <form role="form"  data-parsley-validate="" novalidate="" class="mb-lg" action="login" method="post">
                  <div class="form-group has-feedback">
                     <input id="exampleInputEmail1" type="email" placeholder="Enter email" autocomplete="off" required class="form-control">
                     <span class="fa fa-envelope form-control-feedback text-muted"></span>
                  </div>
                  <div class="form-group has-feedback">
                     <input id="exampleInputPassword1" type="password" placeholder="Password" required class="form-control">
                     <span class="fa fa-lock form-control-feedback text-muted"></span>
                  </div>
                  <div class="clearfix">
                     <div class="checkbox c-checkbox pull-left mt0">
                        <label>
                           <input type="checkbox" value="" name="remember">
                           <span class="fa fa-check"></span>Remember Me</label>
                     </div>
                     <div class="pull-right"><a href="recover.html" class="text-muted">Forgot your password?</a>
                     </div>
                  </div>
                  <button type="submit" class="btn btn-block btn-primary mt-lg">Login</button>
               </form>
               <p class="pt-lg text-center">Need to Signup?</p><a href="register.html" class="btn btn-block btn-default">Register Now</a>
            </div>

            <form name="loginForm" onSubmit="return login_validate()" action="/login" method="post">
				<table width="900" border="0" style="border: solid gray 1pt;" cellpadding="0" cellspacing="0">
					<tr><td height="76"> </td> </tr>
					<tr>
						<td height="25" colspan="3" bgcolor="#6C7B8B">
							<a href="index.jsp"><span class="STYLE1">歡迎使用</span></a><span class="STYLE1">&gt;&gt;&gt;&gt;&gt;員工登陸</span>
						</td>
					</tr>
					<tr valign="top" height="500" >
						<td height="254">
							<br><br>
							<table width="437" height="247" border="0" align="center" background="images/login_1.jpg" >
								<tr><td colspan="3" height="25"></td></tr>
								<tr>
									<td height="25" width="37%">
										<div align="right">
											用戶名：
										</div>
									</td>
									<td width="65%">
										<input type="text" name="username" size="20" value=""/>
										<%--<%=name %>--%>
									</td>
								</tr>
								<tr>
									<td height="25">
										<div align="right">
											密&nbsp;&nbsp;碼：
										</div>
									</td>
									<td>
										<input type="password" name="password" size="20" value=""/>
										<%--<%=psw %>--%>
									</td>
								</tr>
								<tr>
									<td height="25">
										<div align="right">
											驗證碼：
										</div>
									</td>
									<td width="20%">
										<input name="randcode" type="text" size=6 onkeyup="f_change(this.value)">
										<img src="Code" /><span id="i_code"></span>
									</td>
								</tr>
								<tr>
									<td height="25">
										<div align="right"></div>
									</td>
									<td >
										<input type="radio" name="autologin" value="auto" >
										保存密碼
									</td>
								</tr>
								<tr>
									<td height="25">
										<div align="right"></div>
									</td>
									<td >
										<input name="register" type="button" value="註冊"
											onclick="window.location.replace('register.jsp')"/>
										&nbsp;&nbsp;
										<input type="submit" name="submit" value="登錄"
											onclick="return login_validate();" />
										&nbsp;&nbsp;
										<a href="findpassword.jsp"><span style="color: red">忘記密碼</span></a>
									</td>
								</tr>
							</table>
						</td>
					</tr>

					<tr>
						<td height="76">
							<%--<%@ include file="tail.jsp"%>--%>
						</td>
					</tr>
				</table>
				<input type="hidden" name="index" value="0" />
				<input type="hidden" name="pagenow" value="0" />
			</form>
         </div>


         <!-- END panel-->
         <div class="p-lg text-center">
            <span>&copy;</span>
            <span>2017</span>
            <span>-</span>
            <span>Angle</span>
            <br>
            <span>Bootstrap Admin Template</span>
         </div>
      </div>
   </div>
   <!-- =============== VENDOR SCRIPTS ===============-->
   <!-- MODERNIZR-->
   <script src="WEB-INF/vendor/modernizr/modernizr.custom.js"></script>
   <!-- JQUERY-->
   <script src="WEB-INF/vendor/jquery/dist/jquery.js"></script>
   <!-- BOOTSTRAP-->
   <script src="WEB-INF/vendor/bootstrap/dist/js/bootstrap.js"></script>
   <!-- STORAGE API-->
   <script src="WEB-INF/vendor/jQuery-Storage-API/jquery.storageapi.js"></script>
   <!-- PARSLEY-->
   <script src="WEB-INF/vendor/parsleyjs/dist/parsley.min.js"></script>
   <!-- =============== APP SCRIPTS ===============-->
   <script src="js/app.js"></script>
</body>

</html>
