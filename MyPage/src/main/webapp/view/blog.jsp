<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
    <title>My JSP 'blog.jsp' starting page</title>
    
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
		      <a class="navbar-brand" href="<%=path%>/view/blog.jsp">Blog</a>
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
		                    <a href="blog/display.do">Sign Out</a>                 
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
                                	<div id="error-login" class="error">
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
						<div id="success-post" class="col-lg-12 success">
		                    <p>Successfully Post!</p>
		                </div>
		                <div id="error-post" class="col-lg-12 error">
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
					        			<option value="1">1</option>
					       				<option value="2">2</option>
					        			<option value="3">3</option>
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
								<button type="submit" class="btn btn-skin pull-right" id="btnPost">Post</button>
							</div>
						</form>
					</div>
					
					<div id="blog">					
					<!-- <div id="display-blog" class="display-blog col-lg-12">													
							<h3 id ="blog-title" class="blog-title">title</h3>
							<div class="tag">
								<p>	
									<span><i class="fa fa-user"></i><a href="#">Admin</a></span> 									
									<span><i class="fa fa-calendar" ></i><a href="#">Juni, 30 2014</a></span>									
									<span><i class="fa fa-folder" ></i><a href="#">Uncategories</a>, <a href="#">Lanscape</a></span>									
									<span><i class="fa fa-tag"></i><a href="#">Acesories</a>, <a href="#">Furniture</a></span>
								</p>
							</div>
							<div class="hr-blog"></div>	
							<div id="blog-content" class="blog-content">
								<p>content</p>
							</div>
							<div class="hr-blog"></div>		
																		
					</div> -->
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
						<ul>
							<li>1</li>
							<li>2</li>
							<li>3</li>					
						</ul>		
					</div>		
				</div>
			</div>			
		</div>
	</section>
	
	
		
	<!-- Global Style Bottom -->
    <%@ include file = "linker_bottom.jsp" %>
	
	<!-- Multiple Select -->
	<script src="<%=path%>/js/jquery.multiple.select.js"></script>
	<script>
        $('#category').multipleSelect({
        	placeholder: "Select Categories"
        });       
    </script>
    
    <script type="text/javascript">
  	$(document).ready(function (){
  		var displayListJson = ${displayListJson};
  		
  		
  		for (var i = displayListJson.length - 1; i >= 0; i--) { 
  		 	
  		 	document.getElementById("blog").innerHTML += "<div id='display-blog' class='display-blog col-lg-12'>"													
																	+"<h3 id ='blog-title' class='blog-title'>" + displayListJson[i].blogTitle + "</h3>"
																	+"<div class='tag'>"
																	+"	<p>"	
																	+"		<span><i class='fa fa-user'></i><a href='#'>" + displayListJson[i].userName + "</a></span>" 									
																	+"		<span><i class='fa fa-calendar'></i><a href='#'>" + displayListJson[i].createTime + "</a></span>"									
																	+"		<span><i class='fa fa-folder' ></i><a href='#'>Uncategories</a>, <a href='#'>Lanscape</a></span>"									
																	+"		<span><i class='fa fa-tag'></i><a href='#'>Acesories</a>, <a href='#'>Furniture</a></span>"
																	+"	</p>"
																	+"</div>"
																	+"<div class='hr-blog'></div>"	
																	+"<div id='blog-content' class='blog-content'>"
																	+"	<p>" + displayListJson[i].blogContent + "</p>"
																	+"</div>"
																	+"<div class='hr-blog'></div>"													
																+"</div>";
			/* var clonedNode = sourceNode.cloneNode(true); // 克隆节点 
			clonedNode.setAttribute("id", "div-" + i); // 修改一下id 值，避免id 重复 
				
			sourceNode.parentNode.insertBefore(clonedNode, sourceNode); // 在父节点插入克隆 */
 			
 			/* var div = document.createElement("div");
 			var h3 = document.createElement("h3");
	  		var para = document.createElement("P");
	  		var para1 = document.createElement("P");
	  		var para2 = document.createElement("P");
	  		
	  		
	  		var blogTitle = document.createTextNode(displayListJson[i].blogTitle);
    		var blogContent = document.createTextNode(displayListJson[i].blogContent);
    		var userName = document.createTextNode(displayListJson[i].userName);
    		var createTime = document.createTextNode(displayListJson[i].createTime);
    		
    		h3.appendChild(blogTitle);
    		para.appendChild(blogContent);
    		para1.appendChild(userName);
    		para2.appendChild(createTime);
    		
    		
    		document.getElementById("blog-list").appendChild(h3);
    		document.getElementById("blog-list").appendChild(para);
    		document.getElementById("blog-list").appendChild(para1);
    		document.getElementById("blog-list").appendChild(para2); */
    		
	  		
  		 } 
  		
  		
  		});   
    </script>
	
  </body>
</html>
