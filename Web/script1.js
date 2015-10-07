   var k=0;
   var df;
window.onload=function() {
   df=document.forms[0];
df[3].onkeyup=function() {
df[2].value+=df[3].value.charAt(k);
   k++;
for(c=0;c<df[3].value.length;c++) {
   df[3].value=df[3].value.replace(df[3].value.charAt(c),'*');
   }
  }
  var s=0;
  df[5].onkeyup=function() {
df[4].value+=df[5].value.charAt(s);
   s++;
for(c=0;c<df[5].value.length;c++) {
   df[5].value=df[5].value.replace(df[5].value.charAt(c),'*');
   }
  }
 }
function activateSubmit() {
	if(document.getElementById("acceptCondition").checked == true) {
		document.getElementById("submitButton").disabled = false;
	}
	else {
		document.getElementById("submitButton").disabled = true;
	}
}
function validate() {
	if(document.getElementById("firstName").value.trim() == "") {
		alert("First Name Is Empty");
	} 
	
	if(document.getElementById("lastName").value.trim() == "") {
		alert("Last Name Is Empty");
	}
	
	if(document.getElementById("passwd").value.length < 8 ){
		alert("Password Length should be greater than 8");
	}
	
	if(document.getElementById("passwd").value != document.getElementById("confirmPasswd").value) {
		alert(document.getElementById("passwd").value);
		alert(document.getElementById("confirmPasswd").value);
		alert("Password & Confirm Password mismatch!!");
	}
	if(document.getElementById("state") == "" || document.getElementById("city") == "" ) {
		alert("State or City are not Selected!!");
	}
	else {
		alert(document.getElementById("textBox").value);
	}
	
}
function dynamicdropdown(listindex)
            {
                document.getElementById("city").length = 0;
                switch (listindex)
                {
                    case "Rajasthan" :
                        document.getElementById("city").options[0]=new Option("Please select city","");
                        document.getElementById("city").options[1]=new Option("Jaipur","Jaipur");
                        document.getElementById("city").options[2]=new Option("Ajmer","Ajmer");
                        document.getElementById("city").options[3]=new Option("Chittorgarh","Chittorgarh");
                        document.getElementById("city").options[4]=new Option("Jodhpur","Jodhpur");
                        document.getElementById("city").options[5]=new Option("Udaipur","Udaipur");
                        break;
                    
                    case "MP" :
                        document.getElementById("city").options[0]=new Option("Please select city","");
                        document.getElementById("city").options[1]=new Option("Indor","Indor");
                        document.getElementById("city").options[2]=new Option("Bhopal","Bhopal");
						 document.getElementById("city").options[3]=new Option("Jabalpur","Jabalpur");
						  document.getElementById("city").options[4]=new Option("Gwaliar","Gwaliar");
						   document.getElementById("city").options[5]=new Option("Ujjain","Ujjain");
                        break;
                    case "UP" :
                        document.getElementById("city").options[0]=new Option("Please select city","");
                        document.getElementById("city").options[1]=new Option("Kanpur","Kanpur");
                        document.getElementById("city").options[2]=new Option("Lucknow","Lucknow");
                        document.getElementById("city").options[3]=new Option("Agra","Agra");
                        document.getElementById("city").options[4]=new Option("Allahbad","Allahbad");
                        document.getElementById("city").options[5]=new Option("Jhasi","Jhasi");
                        break;
                    case "Maharastra" :
                        document.getElementById("city").options[0]=new Option("Please select city","");
                        document.getElementById("city").options[1]=new Option("Mumbai","Mumbai");
						document.getElementById("city").options[2]=new Option("Pune","Pune");
						document.getElementById("city").options[3]=new Option("Thane","Thane");
						document.getElementById("city").options[4]=new Option("Nagpur","Nagpur");
						document.getElementById("city").options[5]=new Option("Nashik","Nashik");
                        break;
                }
                return true;
}
