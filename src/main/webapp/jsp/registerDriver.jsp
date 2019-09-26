<!DOCTYPE html>
<html>
  <head>
    <title>Travel Booking Form</title>
    <link rel="stylesheet" href="../css/registerDriver.css">
  </head>
  <body>
    <div class="testbox">
    <form action="registerUser" method="post">
      <div class="banner">
        <h1>Driver Registration Form</h1>
      </div>
      <div class="item">
        <p>Name</p>
        <div class="name-item">
          <input type="text" name="name" placeholder="Enter Name"/>
        </div>
      </div>
      <div class="item">
        <p>Mobile Number</p>
      <div class="name-item">
        <input type="tel" name="number"/>
      </div>
      </div>
      <div class="item">
        <p>Email</p>
      <div class="name-item">  
        <input type="email" name="emailId"/>
      </div>
      <input type="hidden" value="Driver" name="role"/>
      <input type="hidden" value="driver" name="password"/>
       <div class="question">
        <p>Gender</p>
        <div class="question-answer">
          <div>
            <input type="radio" value="none" id="radio_1" name="question1"/>
            <label for="radio_1" class="radio"><span>Male</span></label>
          </div>
          <div>
            <input type="radio" value="none" id="radio_2" name="question1"/>
            <label for="radio_2" class="radio"><span>Female</span></label>
          </div>
        </div>  
        <div class="btn-block">
          <button type="submit">Register</button>
        </div>
    </form>
    </div>
  </body>
</html>
