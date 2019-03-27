(function($) {
	$(document).on('submit', 'form', function() {		
		var introduced_input = $("#introduced")[0];
		var discontinued_input = $("#discontinued")[0];
		var name_input = $("#computerName")[0];
		
		var introduced = introduced_input.value;
		var discontinued = discontinued_input.value;
		var name = name_input.value;
		
		var introducedDate = new Date(introduced).getDate();
		var discontinuedDate = new Date(discontinued).getDate();
		
		$(introduced_input.closest('.form-group')).removeClass('has-error');
		$(discontinued_input.closest('.form-group')).removeClass('has-error');
		
		if ( name != "" ) {
			if ( isNaN(introducedDate) && !isNaN(discontinuedDate) ) {
				$(introduced_input.closest('.form-group')).addClass('has-error');
				$(discontinued_input.closest('.form-group')).addClass('has-error');
				return false;
			} else if ( introducedDate > discontinuedDate ) {
				$(introduced_input.closest('.form-group')).addClass('has-error');
				$(discontinued_input.closest('.form-group')).addClass('has-error');
				return false;
			}
		} else {
			$(name_input.closest('.form-group')).addClass('has-error');
			return false;
		}
		
		return true;
	});
}(jQuery));









































/*$(document).ready(function($){
		//(function ( $ ) {
		
    var regEx = "/^(19[5-9][0-9]|20[0-4][0-9]|2050)[//](0?[1-9]|1[0-2])[//](0?[1-9]|[12][0-9]|3[01])$/i";
   
	$("form").submit( function(event){
	
			if(!$("#computerName").val()){
				
				$("#computerName").parent().append("<p class=\"warningName\" style=\"color : red\"> Computer name requiered</p>");
				$("#computerName").css("border" , "red");
				event.preventDefault();
				
			}else{
				
				$(".warningName").remove();
				$("#computerName").css("border" , "green");
				return;
			}		
		}
	)

	 $("#introduced").change(function(){
		 
		 console.log($("#introduced").val());
			console.log(!$("#introduced").val().match(regEx));
			
			//	if($(".warning").lentgh>0){ $(".warning").remove();}
		 // 	regEx = ;
			if(!$("#introduced").val().match(regEx)){
				console.log("Je suis dans le if ");	
				$("#introduced").parent().append("<p id=\"warningDate\" style=\"color : red\">Invalid date</p>");
				$("#introduced").css("border" , "red");
				//event.preventDefault();
				
			}else{
				 console.log("Je suis dans le else ");
						$("#warningDate").remove();
						$("#introduced").css("border" , "green");
						return;
				}
			  }
	 )
	       
	
	
	/*$("#discontinued").focus(function(){
		regEx = "/^\d{4}-\d{2}-\d{2}$/i";
			//if($(".warning").lentgh>0){ $(".warning").remove();}
			if(!$("#discontinued").val().match(regEx)){
				
				$("#discontinued").parent().append("<p class=\"warning\" style=\"color : red\">Invalid date</p>");
				$("#discontinued").css("border" , "red");
				event.preventDefault();
				
			}else{
				
				$(".warning").remove();
				$("#discontinued").css("border" , "green");
				return;
			}
		
			if($("#introduced").val() < $("#discontinued").val()){
				
				$("#discontinued").parent().append("<p class=\"warning\" style=\"color : red\">This date is before introduced date you are arioul ! </p>");
				$("#discontinued").css("border" , "red");
				event.preventDefault();
				
			}else{
				
				$(".warning").remove();
				$("#discontinued").css("border" , "green");
				return;
			}
	   }
	    
	)*/
	
	/*
	         $("#introduced").chnage(function(){
	        	 if(!$("#introduced").val().match(regEx)){
	    		//if($(".warning").lentgh>0){ $(".warning").remove();}
	    		
	    			
	    			$("#introduced").parent().append("<p class=\"warning\" style=\"color : red\">Invalid date</p>");
	    			$("#introduced").css("border" , "red");
	    			//event.preventDefault();
			  })else{
			  $("#introduced").blur(function(){
				  
				  $(".warning").remove();
					$("#introduced").css("border" , "green");
					return;	
				    });}
	       
	       
	       
				
	    		//if($(".warning").lentgh>0){ $(".warning").remove();}
	    		if(!$("#discontinued").val().match(regEx)){
	        $("#discontinued").focus(function(){
	        
	    			
	    			$("#discontinued").parent().append("<p class=\"warning\" style=\"color : red\">Invalid date</p>");
	    			$("#discontinued").css("border" , "red");
	    			//event.preventDefault();
			  }
	    		
	        );}else{
			  $("#discontinued").blur(function(){
				  
				  $(".warning").remove();
					$("#discontinued").css("border" , "green");
					return;	
				    });}
			  
	
	
	


}( jQuery ));*/
