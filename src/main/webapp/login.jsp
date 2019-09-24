<!DOCTYPE html>
<head>
   <meta charset="UTF-8" />
   <title>Luxitrip</title>
   <link rel = "icon" href = "4339.png" style = "width:100px">
   <link rel="stylesheet" type="text/css" href="/css/Style.css" />
   <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
</head>
<body>
   <div class="container">
      <button><img  class = "img" src = "../img/4339.png"></button>
      <header>
         <h1>Welcome to LUXITRIP</h1>
      </header>
      <section>
         <div id="container_demo" >
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
               <div id="login" class="animate form">
                  <form  action="validateUser" autocomplete="on">
                     <h1>Log in</h1>
                     <p> 
                        <label for="username" class="uname" >Email or Mobile </label>
                        <input id="username" name="userName" required="required" type="text" placeholder="mymail@mail.com or xxxxxxxxxx"/>
                     </p>
                     <p> 
                        <label for="password" class="youpasswd">Password </label>
                        <input type="password" placeholder="Enter Password" name="password" id ="pwd" required><br><br>
                        <input type="checkbox" onclick="myFunction()">Show Password
                        <script>
                            function myFunction() {
                            var x = document.getElementById("pwd");
                            if (x.type === "password") {
                               x.type = "text";
                            } else {
                               x.type = "password";
                            }
                           }
                        </script>  
                     </p>
                     <p class="login button"> 
                        <input type="submit" value="Login"/>
                     </p>
                     <p class="change_link">
                        Not a member yet ?
                        <a href="#toregister" class="to_register">Join us</a>
                     </p>
                  </form>
               </div>
               <div id="register" class="animate form">
                  <form  action="registerUser" autocomplete="on">
                     <h1> Sign up </h1>
                     <p> 
                        <label>Username</label>
                        <input required="required" name="name" type="text" placeholder="john" />
                     </p>
                     <p> 
                        <label>Email</label>
                        <input required="required" name="emailId" type="email" placeholder="mac@gmail.com"/> 
                     </p>
                     <p> 
                        <label>Mobile Number</label>
                        <input type="tel" required="required" name="number" placeholder="9879879870"/> 
                     </p>
                     <p>
                     <label>Password </label>
                     <input required="required" type="password" name="password" placeholder="X8df!90EO"/>
                     </p>
                     <p class="signin button"> 
                        <input type="submit" value="Sign up"/> 
                     </p>
                     <p class="change_link">  
                        Already a member ?
                        <a href="#tologin" class="to_register"> Go and log in </a>
                     </p>
                  </form>
               </div>
            </div>
         </div>
      </section>
   </div>
</body>
</html>
