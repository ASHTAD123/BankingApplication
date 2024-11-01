console.log('Js Loaded')


$(document).ready(function() {
 
	 $("#success-alert").hide();
 
   $("#submit").click(function showAlert() {
	 	
		   $("#success-alert").fadeTo(20000, 5003).slideUp(500, function() {
	       $("#success-alert").slideUp(500);
	    });
  });
});