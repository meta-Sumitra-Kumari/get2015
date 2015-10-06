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
  df[5].onkeyup=function() {
df[4].value+=df[5].value.charAt(k);
   k++;
for(c=0;c<df[5].value.length;c++) {
   df[5].value=df[5].value.replace(df[5].value.charAt(c),'*');
   }
  }
 }
 
 function validatename()
 {
 var x = document.forms[0][0].value;
 if(x=="")
			{
			alert("name is not filled");
			}
			else
			{
			 alert("name is "+x);
			}
			
    if(!forms[0].terms.checked) {
      alert("Please indicate that you accept the Terms and Conditions");
      form.terms.focus();
      return false;
    }
    return true;
 }
 function CheckIsNumeric(objEvt) {
        var charCode = (objEvt.which) ? objEvt.which : event.keyCode
        if (charCode > 31 && ((charCode < 48 || charCode > 57  )&& charCode!=46)) {
            return false;
        }
        else {
            return true;
        }
    }
	   function dynamicdropdown(listindex)
            {
                document.getElementById("subcategory").length = 0;
                switch (listindex)
                {
                    case "Rajasthan" :
                        document.getElementById("subcategory").options[0]=new Option("Please select framework","");
                        document.getElementById("subcategory").options[1]=new Option("Jaipur","Jaipur");
                        document.getElementById("subcategory").options[2]=new Option("Ajmer","Ajmer");
                        document.getElementById("subcategory").options[3]=new Option("Chittorgarh","Chittorgarh");
                        document.getElementById("subcategory").options[4]=new Option("Jodhpur","Jodhpur");
                        document.getElementById("subcategory").options[5]=new Option("Udaipur","Udaipur");
                        break;
                    
                    case "MP" :
                        document.getElementById("subcategory").options[0]=new Option("Please select framework","");
                        document.getElementById("subcategory").options[1]=new Option("Indor","Indor");
                        document.getElementById("subcategory").options[2]=new Option("Bhopal","Bhopal");
						 document.getElementById("subcategory").options[3]=new Option("Jabalpur","Jabalpur");
						  document.getElementById("subcategory").options[4]=new Option("Gwaliar","Gwaliar");
						   document.getElementById("subcategory").options[5]=new Option("Ujjain","Ujjain");
                        break;
                    case "UP" :
                        document.getElementById("subcategory").options[0]=new Option("Please select framework","");
                        document.getElementById("subcategory").options[1]=new Option("Kanpur","Kanpur");
                        document.getElementById("subcategory").options[2]=new Option("Lucknow","Lucknow");
                        document.getElementById("subcategory").options[3]=new Option("Agra","Agra");
                        document.getElementById("subcategory").options[4]=new Option("Allahbad","Allahbad");
                        document.getElementById("subcategory").options[5]=new Option("Jhasi","Jhasi");
                        break;
                    case "Maharastra" :
                        document.getElementById("subcategory").options[0]=new Option("Please select framework","");
                        document.getElementById("subcategory").options[1]=new Option("Mumbai","Mumbai");
						document.getElementById("subcategory").options[2]=new Option("Pune","Pune");
						document.getElementById("subcategory").options[3]=new Option("Thane","Thane");
						document.getElementById("subcategory").options[4]=new Option("Nagpur","Nagpur");
						document.getElementById("subcategory").options[5]=new Option("Nashik","Nashik");
                        break;
                }
                return true;
            }
