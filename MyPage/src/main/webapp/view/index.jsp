<%@ page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Yifan Zhu</title>
    <meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Global Style Top-->
    <%@ include file = "linker_top.jsp" %>
		
	<!-- Custom CSS -->
	<link href="<%=path%>/css/index.css" rel="stylesheet">
	
	<!-- Animate -->
	<link href="<%=path%>/css/animate.css" rel="stylesheet">
	
	<!-- Carousel -->
	<link rel="stylesheet" href="<%=path%>/css/owl.carousel.css">	 		
				
  </head>
  
  <body data-spy="scroll" data-target="#myScrollspy" data-offset="20">
    
  <nav id="myScrollspy" class="navbar navbar-inverse navbar-custom navbar-fixed-top" role="navigation">
    <div class="container-fluid">
    	<div class="welcome">
    	 <p id="welcome"></p>
    	</div>       
    	
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	    </div>
        <div id="myNavbar" class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#intro">Home</a></li>
                <li><a href="#portfolio">Portfolio</a></li>
                <li><a href="#skills">Skill</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
               
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Life<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="page/showBlogPage.do" method="post">Blog</a></li>
                        <li><a href="<%=path%>/view/travel.jsp">Travel</a></li>
                        <li id="sign-in-li">
                            <a href="" data-toggle="modal" data-target="#myModal">Sign In</a>                 
                        </li> 
                        <li id="sign-out-li">
                            <a href="javascript:logout()">Sign Out</a>                 
                        </li>                      
                    </ul>
                </li>
              
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Sign In</h4>
                            </div>
                                                                        
                            <form action="javascript:login()">
                                <div class="modal-body">
                                	<div id="error" class="error">
                                		<p>Wrong Email or Password!</p>
                                	</div>
                                	<div class="text">
                                		<label for="session_email">Email</label>
	                                    <div class="input-group">
	                                        <span class="input-group-addon">
	                                            <i class="fa fa-envelope-o"></i>
	                                        </span>
	                                        <input type="text" name="userEmail"/>
	                                    </div>
                                	</div>
                                	<div class="text">
                                		<label for="session_password">Password</label>
	                                    <div class="input-group">
	                                        <span class="input-group-addon">
	                                            <i class="fa fa-key"></i>
	                                        </span>
	                                        <input type="password" name="userPwd"/>
	                                    </div> 	
                                	</div>                                                                       					    							    		
							    		<!-- <tr>
							    			<td>User Gender:</td>
							    			<td><input type="radio" name="userGender" value="male"/>Male</td>
							    			<td><input type="radio" name="userGender" value="female"/>Female</td>
							    		</tr> -->							    	
                              	</div>

	                            <div class="modal-footer">
	                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	                                <input type="submit" class="btn btn-primary" value="Sign In"/>     	                                                 
	                            </div>
                            </form>
                            
                        </div>
                    </div>
                </div>

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>	
  
	<!-- Section: intro -->
	<section id="intro" class="intro">		
		<div class="slogan">
			<h2>HELLO, I AM <span>YIFAN ZHU</span></h2>
			<br/>
			<h4>I'm a web developer living in Arlington, Virginia.</h4>
		</div>
		<div class="page-scroll">
			<a href="#portfolio">
				Read More
			</a>
		</div>
	</section>
	<!-- /Section: intro -->

	<!-- Section: portfolio -->
	<section id="portfolio" class="portfolio">		
		<h3 class="heading">PORTFOLIO</h3>		
			<div class="wrap">
				<div id="owl-demo" class="owl-carousel">
					<div class="item">
						<div class="image">
							<img src="<%=path%>/img/portfolio1.png" alt="">
						</div>
						<div class="text">
							<div class="desc">
								<h1>Company</h1>
								<p>RETREAT Magzine</p>
							</div>
							<div class="desc">
								<h1>Role in project</h1>
								<p>Web Developer</p>
							</div>
							<div class="desc">
								<h1>project included</h1>
								<p>Develop and maintain web interface</p>
							</div>
							<div class="button">
								<a href="http://retreatmag.com/">Preview</a>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="image">
							<img src="<%=path%>/img/img2.png" alt="">
						</div>
						<div class="text">
							<div class="desc">
								<h1>Name</h1>
								<p>Blog</p>
							</div>							
							<div class="desc">
								<h1>project included</h1>
								<p>Develop and maintain web interface</p>
							</div>
							<div class="button">
								<a href="blog">Preview</a>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="image">
							<img src="<%=path%>/img/img3.png" alt="">
						</div>
						<div class="text">
							<div class="desc">
								<h1>Name</h1>
								<p>Travel Timeline</p>
							</div>							
							<div class="desc">
								<h1>project included</h1>
								<p>Mobile and web interface</p>
							</div>
							<div class="button">
								<a href="travel">Preview</a>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	<!-- /Section: portfolio -->

	<!-- Section: skills -->
	<section id="skills" class="skills">		
		<h3 class="heading">Skills</h3>
		<p>I am an experienced and passionate web developer with computer science background.<br>My goal is to engage myself in real world development and make cool website.</p>
			<div class="text-center centertxt">	
				<div class="chart" data-percent="75" data-bar-color="#FF0000" data-animate="2500">
					<div class="chart-content" style="top: 32.5px;">
						<div class="percent">75</div>
						<div class="chart-title">Java</div>								
						<canvas height="356" width="356" style="height: 178px; width: 178px;"></canvas>
					</div>
				</div>	
				<div class="chart" data-percent="60" data-bar-color="#e97b00" data-animate="3500">
					<div class="chart-content" style="top: 32.5px;">
						<div class="percent">60</div>
						<div class="chart-title">SQL/MySQL</div>								
						<canvas height="356" width="356" style="height: 178px; width: 178px;"></canvas>
					</div>
				</div>				
				<div class="chart" data-percent="90" data-bar-color="#8AC007" data-animate="4000">
					<div class="chart-content" style="top: 32.5px;">
						<div class="percent">90</div>
						<div class="chart-title">HTML/CSS</div>							
						<canvas height="356" width="356" style="height: 178px; width: 178px;"></canvas>
					</div>
				</div>						
				<div class="chart" data-percent="80" data-bar-color="#6f5499" data-animate="3000">
					<div class="chart-content" style="top: 32.5px;">
						<div class="percent">80</div>
						<div class="chart-title">Bootstrap</div>								
						<canvas height="356" width="356" style="height: 178px; width: 178px;"></canvas>
					</div>
				</div>												
			</div>								
	</section>
	<!-- /Section: skills -->

	<!-- Section: about -->
	<section id="about" class="about">
		<h3 class="heading">About Me</h3>	                           														
		<div class="container">			
			<div class="row">
			
				<div class="col-xs-6 col-sm-3 col-md-3">
					<div class="bounceInUp" data-wow-delay="0.2s">
						<div class="box text-center">							
							<h5>Piano</h5>								
							<div class="avatar">
								<img src="<%=path%>/img/piano.jpg" alt="" class="img-responsive img-circle" />
							</div>						
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-3 col-md-3">
					<div class="bounceInUp" data-wow-delay="0.5s">
						<div class="box text-center">							
							<h5>Art</h5>
							<p class="subtitle">Sculpture</p>
							<p class="subtitle">Sketching</p>
							<div class="avatar">
								<img src="<%=path%>/img/sketching.jpg" alt="" class="img-responsive img-circle" />
							</div>
						</div>						
					</div>
				</div>
				<div class="col-xs-6 col-sm-3 col-md-3">
					<div class="bounceInUp" data-wow-delay="0.8s">
						<div class="box text-center">							
							<h5>Swimming</h5>
							<div class="avatar">
								<img src="<%=path%>/img/swimming.jpg" alt="" class="img-responsive img-circle" />
							</div>							
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-3 col-md-3">
					<div class="bounceInUp" data-wow-delay="1s">
						<div class="box text-center">
							<h5>Skiing</h5>
							<div class="avatar">
								<img src="<%=path%>/img/skiing.jpg" alt="" class="img-responsive img-circle" />
							</div>
						</div>
					</div>
				</div>			
			</div>		
		</div>
	</section>
	<!-- /Section: about -->

	<!-- Section: contact -->
	<section id="contact" class="contact">
		<div class="text-center">		
			<h3 class="heading">Get in touch</h3>	                           
			<i class="fa fa-2x fa-angle-down"></i>
		</div>		
		<div class="container">
			<div class="row">	
				<div class="col-lg-12 box">
					<form id="contact-form">
						<div class="col-md-6">
							<div class="form-group">
								<label for="name">Name</label>
								<input type="text" class="form-control" id="name" placeholder="Enter name" required="required" />
							</div>
							<div class="form-group">
								<label for="email">Email Address</label>
								<div class="input-group">
									<span class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</span>
									<input type="email" class="form-control" id="email" placeholder="Enter email" required="required" />
								</div>
							</div>
							<div class="form-group">
								<label for="email">Phone Number (Optional)</label>
								<div class="input-group">
									<span class="input-group-addon">
										<i class="fa fa-phone fa-lg"></i>
									</span>
									<input type="phone" class="form-control" id="phone" placeholder="Enter phone number" />
								</div>
							</div>
							<div class="form-group">
								<label for="subject">Subject</label>
								<input type="text" id="subject" class="form-control" rows="9" cols="25" required="required" placeholder="Subject"/>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="name">Message</label>
								<textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required" placeholder="Message"></textarea>
							</div>
						</div>
						<div class="col-md-12">
							<button type="submit" class="btn btn-skin pull-right" id="btnContactUs">Send Message</button>
						</div>
					</form>
				</div><!-- box -->
			</div>
		</div>
		
		<div class="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-lg-12">
						<p>&copy;Copyright 2015 - Yifan Zhu. All rights reserved.</p>					
						<a href="#intro">
							<i class="fa fa-arrow-circle-o-up fa-3x"></i>
						</a>						
					</div>				
				</div>	
			</div>
		</div>
		
	</section>
	<!-- /Section: contact -->
	
	<!-- Check Session --> 
	<script type="text/javascript">
  	$(document).ready(function (){
  		
  		$("#sign-out-li").hide();
  		$("#error").hide();
  		
  		var userName = "${sessionScope.user.userName}";		
  		if(userName && userName != "null" && userName != "") {
  		document.getElementById("welcome").innerHTML = userName;
  		$("#sign-in-li").hide();
  		$("#sign-out-li").show();		
  		} 
  		  			
  	});
	</script>	
    
    <!-- Custom Javascript -->
  	<script type="text/javascript" src="<%=path%>/js/index.js"></script>		
		
	<!-- ScrollTo JavaScript -->
	<script src="<%=path%>/js/jquery.easing.min.js"></script>	
	<script src="<%=path%>/js/jquery.scrollTo.js"></script>
	<script src="<%=path%>/js/wow.min.js"></script>    
    <script src="<%=path%>/js/custom.js"></script>
    
    <!-- Carousel -->
	<script src="<%=path%>/js/owl.carousel.js"></script>
    
    <!-- Chart -->
	<script type="text/javascript" src="<%=path%>/js/plugins.js"></script>
	<script type="text/javascript" src="<%=path%>/js/script.js"></script>
		
	<!-- User Login/Logout -->
	<script type="text/javascript">
	var userEmail, userPwd;
	var reponseText;
	var xmlhttp = null;
	
	function login() {	
		
		userEmail = $("input[name='userEmail']");
		userPwd = $("input[name='userPwd']"); 
			
		if (window.XMLHttpRequest) {
		
			xmlhttp = new XMLHttpRequest();
		} else { // code for IE6, IE5	
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlhttp != null) {	
			xmlhttp.onreadystatechange = state_change;
			xmlhttp.open("GET", "user/login.do?userEmail=" + userEmail.val() + "&userPwd=" + userPwd.val(), false);
			xmlhttp.send();		
		} else {
			alert("Your browser doesn't support XMLHttpRequest!");
		}
	}
	
	function logout() {	
	
		if (window.XMLHttpRequest) {		
			xmlhttp = new XMLHttpRequest();
		} else { // code for IE6, IE5		
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlhttp != null) {		
			xmlhttp.onreadystatechange = state_change;
			xmlhttp.open("GET", "user/logout.do", false);
			xmlhttp.send();
		} else {
			alert("Your browser doesn't support XMLHttpRequest!");
		}
	}
	 
	function state_change() {
	
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {			
			reponseText = xmlhttp.responseText;
			if (reponseText=="true") {			
				window.location.reload();						
			} else {							
	  			$("#error").show();
			}			
		}	
	}
	
	</script>	
	
  </body>
</html>
