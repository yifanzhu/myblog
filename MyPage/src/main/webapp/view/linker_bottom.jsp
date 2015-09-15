<!-- Check Session --> 
	<script type="text/javascript">
  	$(document).ready(function (){
  		
  		/* $("#post-blog-li").hide(); */
  		$("#error-login").hide();
  		$("#success-post").hide();
  		$("#error-post").hide();
  		$("#sign-out-li").hide();
  		$("#post-blog").hide();
  		
  		
  		var userName = "${sessionScope.user.userName}";		
  		if(userName && userName != "null" && userName != "") {
  		document.getElementById("welcome").innerHTML = userName;
  		$("#sign-in-li").hide();
  		$("#sign-out-li").show();
  		$("#post-blog").show();
  		/* $("#post-blog-li").show(); */
  				
  		} 
  		  			
  	});
	</script>	
	
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
			xmlhttp.onreadystatechange = stateChangeLog;
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
			xmlhttp.onreadystatechange = stateChangeLog;
			xmlhttp.open("GET", "user/logout.do", false);
			xmlhttp.send();
		} else {
			alert("Your browser doesn't support XMLHttpRequest!");
		}
	}
	 
	function stateChangeLog() {
	
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {			
			reponseText = xmlhttp.responseText;
			if (reponseText=="true") {			
				window.location.reload();						
			} else {							
	  			$("#error-login").fadeIn(500).delay(5000).fadeOut(1000);
			}			
		}	
	}
	
	</script>	
	
	
	