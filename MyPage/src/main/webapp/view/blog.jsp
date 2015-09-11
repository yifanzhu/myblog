<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
    <title>Blog</title>
    
	<!-- Global Style Top -->
    <%@ include file = "linker_top.jsp" %>
    
    <!-- Custom CSS -->
	<link href="<%=path%>/css/blog.css" rel="stylesheet">

	<!-- Multiple Select -->
	<link href="<%=path%>/css/multiple-select.css" rel="stylesheet">

  </head>
  
   <body data-spy="scroll" data-target="#myScrollspy" data-offset="20">   
   	<header class="header">  
	  	<nav class="navbar navbar-inverse navbar-fixed-top">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>                        
		      </button>
		      <a class="navbar-brand" href="page/showBlogPage.do">Blog</a>
		    </div>
		    <div class="collapse navbar-collapse" id="myNavbar">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="<%=path%>/view/index.jsp">Home</a></li>	   
		        <li><a href="#">Travel</a></li>	        
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		      	<!-- <li id="post-blog-li">
                    <a href=""><span><i class="fa fa-pencil"></i></span>   Post</a>                 
                </li> -->		        
		        <li id="sign-in-li">
                    <a href="" data-toggle="modal" data-target="#myModal">Sign In</a>                 
                </li>
                <li id="sign-out-li" class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.user.userName}<b class="caret"></b></a>
                    <ul class="dropdown-menu"> 
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
                                <h4 class="modal-title" id="myModalLabel">Login</h4>
                            </div>
                                                                        
                            <form action="javascript:login()">
                                <div class="modal-body">
                                	<div id="error-login" class="error-login">
	                                	<p>Wrong Email or Password!</p>
	                                </div>	                                
                                	<div class="text">
                                		<label for="session_email">Email</label>
	                                    <div class="input-group">
	                                        <span class="input-group-addon">
	                                            <i class="fa fa-envelope-o"></i>
	                                        </span>
	                                        <input id="user-email" type="text" name="userEmail"/>
	                                    </div>
                                	</div>
                                	<div class="text">
                                		<label for="session_password">Password</label>
	                                    <div class="input-group">
	                                        <span class="input-group-addon">
	                                            <i class="fa fa-key"></i>
	                                        </span>
	                                        <input id="user-pwd" type="password" name="userPwd"/>
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
	                                <input type="submit" class="btn btn-primary" value="Login"/>     	                                                 
	                            </div>
                            </form>
                            
                        </div>
                    </div>
                </div>
	   
	      	</ul>
	    </div>
	  </div>
	</nav>
  
	 	<div class="welcome">
	 		<div class="col-md-5">
	 			<img class="img-responsive img-circle" src="<%=path%>/img/img2.png">
	 		</div>
	 		<div class="col-md-1">
	 		</div>
	 		<div class="col-md-6">
	 			<h3 id="welcome">Hi! Guest</h3>
	 		</div>
											  
		</div>
	</header>
	
	<section class="blog">
		<div class="container">
			<div class="row">				
				<div class="col-lg-8">
					<div id="post-blog" class="post-blog col-lg-12">
						<div id="success-post" class="col-lg-12 success-post">
		                    <p>Successfully Post!</p>
		                </div>
		                <div id="error-post" class="col-lg-12 error-post">
		                    <p>Error Post!</p>
		                </div>
						<form action="javascript:post()" method="post">
							<div class="col-lg-6">
								<div class="form-group">
									<label for="title">Title</label>
									<input type="text" name="blogTitle" class="form-control" placeholder="Enter title" />
								</div>
							</div>	
							<div class="col-lg-6">
								<div class="form-group">
									<label for="category">Category</label>					
									<select id="category" multiple="multiple" >
					        			
				    				</select>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group">
									<label for="content">Post Content</label>
									<textarea name="blogContent" class="form-control" rows="9" cols="25" placeholder="Post content..."></textarea>
								</div>
							</div>
							<div class="col-lg-12">
								<button id="btnPost" type="submit" class="btn btn-skin pull-right" >Post</button>
							</div>
						</form>
					</div>
					
					<div id="blog">					
					
					</div>
																													
				</div><!-- col-lg-8 -->
			
				<div class="col-lg-4">
					<div class="sidebar archives">
						<h4>Archives</h4>
						<ul>
							<li>1</li>
							<li>2</li>
							<li>3</li>					
						</ul>
					</div>
					<div class="sidebar categories">
						<h4>Categories</h4>
						<ul id="category-sidebar">
												
						</ul>		
					</div>		
				</div>
			</div>			
		</div>
	</section>	
		
	<!-- Global Style Bottom -->
    <%@ include file = "linker_bottom.jsp" %>
    
    <!-- Custom Javascript -->
    <script src="<%=path%>/js/blog.js"></script>
	
	<!-- Multiple Select -->
	<script src="<%=path%>/js/jquery.multiple.select.js"></script>
	<script>
		$(document).ready(function (){
	  		var categoryListJson = ${categoryListJson};
	  		for(var i = 0; i < categoryListJson.length; i++) {
	  			document.getElementById("category").innerHTML +=
	  			"<option value=" + categoryListJson[i].categoryName + ">" + categoryListJson[i].categoryName + "</option>"
	  			document.getElementById("category-sidebar").innerHTML +=
	  			"<li>" + categoryListJson[i].categoryName + "</li>"
	  		} 
	  		$('#category').multipleSelect({
        		placeholder: "Select Categories"
        	}); 		
	  	}); 	  	             
    </script>
    
    <script>
	function myFunction() {
	    document.getElementById("btnPost").style.color = "red";
	}
	</script>
    <!-- Display Blog -->
    <script type="text/javascript">
	  	$(document).ready(function (){
	  		var displayListJson = ${displayListJson};		 		
	  		for (var i = displayListJson.length - 1; i >= 0; i--) { 	 	
	  		 	document.getElementById("blog").innerHTML += 
	  		 	"<div id='display-blog' class='display-blog col-lg-12'>"													
				+"	<h3 id ='blog-title' class='blog-title'>" + displayListJson[i].blogTitle + "</h3>"
				+"	<div class='tag'>"
				+"		<p>"
				+"			<table style='width:100%'>"
				+"			  <tr>"
				+"			    <td><span><i class='fa fa-user'></i><a href='#'>" + displayListJson[i].userName + "</a></span></td>"
				+"			    <td><span><i class='fa fa-calendar'></i><a href='#'>" + displayListJson[i].createTime + "</a></span></td>" 
				+"			    <td><span><i class='fa fa-tag' ></i><a href='#'>Uncategories</a>, <a href='#'>Lanscape</a></span></td>"
				+"			  </tr>"		  
				+"			</table>"															
				+"		</p>"
				+"	</div>"
				+"	<div class='hr-blog'></div>"	
				+"	<div id='blog-content' class='blog-content'>"
				+"		<p>" + displayListJson[i].blogContent + "</p>"
				+"	</div>"
				+"	<div class='hr-blog'></div>"													
				+"</div>";		  		
	  		 } 	
	  	});   
    </script>
	
  </body>
</html>
