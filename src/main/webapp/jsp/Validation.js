function EmployeeFormValidation() {
        var name = document.forms["employeeCreateForm"]["employeeName"].value;
        var date = document.forms["employeeCreateForm"]["dateOfJoin"].value;
        var email = document.forms["employeeCreateForm"]["employeeEmailId"].value;
        var blood = document.forms["employeeCreateForm"]["bloodGroup"].value;
        var mobileNo = document.forms["employeeCreateForm"]["mobileNumber"].value;
        var role = document.forms["employeeCreateForm"]["role"].value;
        var pinCode = document.forms["employeeCreateForm"]["pinCode"].value;
        if (name == "") {
          alert("Name must be filled out");
          return false;
        }
        if (!(name.match("^[A-Za-z]+$"))) {
          alert("Enter valid name");
          return false;
        }
        if (date == "") {
          alert("Date must be filled out");
          return false;
        }
        if (email == "") {
          alert("mail must be filled out");
          return false;
        }
        if (email.indexOf("@", 0) < 0) {
          alert("Enter valid mailId");
          return false;
        }
        if (email.indexOf(".", 0) < 0) {
          alert("Enter valid mailId");
          return false;
        }
        if (mobileNo == "") {
          alert("mobile no must be filled out");
          return false;
        }
        if (!(/^\d{10}/.test(mobileNo))) {
          alert("Enter valid mobile No");
          return false;
        }
       
        if (role == "") {
          alert("Designation must be filled out");
          return false;
        }
        if (!(role.match("^[A-Za-z]+$"))) {
          alert("Enter valid designation");
          return false;
        }
        if (!(pinCode.match(/^\d{6}/))) {
          alert("Enter valid pin code");
          return false;
        }
      }
      
      
      function ClientFormValidation() {
        var clientId = document.forms["ClientCreateForm"]["clientId"].value;
        var client = document.forms["ClientCreateForm"]["client"].value;
        var contactPerson = document.forms["ClientCreateForm"]["contactPerson"].value;
        var mobileNo = document.forms["ClientCreateForm"]["mobileNumber"].value;
        var mailId = document.forms["ClientCreateForm"]["mailId"].value;
        var pinCode = document.forms["ClientCreateForm"]["pinCode"].value;
        
        if (!(client.match("^[A-Za-z]+$"))) {
          alert("Enter valid Client");
          return false;
        }
        if (!(contactPerson.match("^[A-Za-z]+$"))) {
          alert("Enter valid contact Person name");
          return false;
        }
        if (!(/^\d{10}/.test(mobileNo))) {
          alert("Enter valid mobile No");
          return false;
        }
        if (mailId.indexOf("@", 0) < 0) {
          alert("Enter valid mailId");
          return false;
        }
        if (mailId.indexOf(".", 0) < 0) {
          alert("Enter valid mailId");
          return false;
        }
        if (!(pinCode.match(/^\d{6}/))) {
          alert("Enter valid pin code");
          return false;
        }
        }
      
      
      function ProjectFormValidation() {
        var projectName = document.forms["ProjectCreateForm"]["projectName"].value;
        var domain = document.forms["ProjectCreateForm"]["domain"].value;
        
        if (!(projectName.match("^[A-Za-z]+$"))) {
          alert("Enter valid Project Name");
          return false;
        }
        if (!(domain.match("^[A-Za-z]+$"))) {
          alert("Enter valid Domain");
          return false;
        }
      }

    function navOpen() {
    document.getElementById("mySidebar").style.display = "block";
    }
    function navClose() {
    document.getElementById("mySidebar").style.display = "none";
    }   
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
