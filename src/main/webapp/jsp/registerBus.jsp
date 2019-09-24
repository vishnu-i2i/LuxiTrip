<!DOCTYPE html>
<html>
  <head>
    <title>Travel Booking Form</title>
    <link rel="stylesheet" href="../css/registerBus.css"> 
  </head>
  <body>
    <div class="testbox">
    <form action="/">
      <div class="banner">
        <h1>Bus Registration Form</h1>
      </div>
      <div class="item">
        <p>Bus Number</p>
        <div class="name-item">
          <input type="text" name="bus-number" placeholder="" />
        </div>
      </div>
      <div class="item">
        <p>Capacity</p>
      <div class="name-item">
        <input type="number" name="capacity"/>
      </div>
      </div>
      <div class="item">
        <p>Operator</p>
        <div class="name-item">  
          <input type="text" name="operator"/>
        </div>
      </div>
      <div class="item">
        <p>Type</p>
        <div class="name-item">
          <select required>
            <option selected value="" disabled></option>
            <option value="1">AC</option>
            <option value="2">Non-AC</option>
          </select>
        </div>
      </div>
      
        <div class="btn-block">
          <button type="submit">Register</button>
        </div>
    </form>
    </div>
  </body>
</html>
