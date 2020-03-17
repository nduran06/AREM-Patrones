var apiclient = (function () {
    var appUrl = "http://ec2-3-85-221-208.compute-1.amazonaws.com:8080/patterns";

    return {
    	
        getUsers: function (callback) {
        	jQuery.ajax({
        		url: appUrl,
        		type: "GET",
        		success: function(respuesta) {
        			callback(respuesta);
        		}
        	});
        },

        setUser: function (user){
        	var postRequest=$.ajax({
				url:  appUrl,
				type: 'POST',
				data: user,
				contentType: "application/json"
			});
			postRequest.then(
				function(){
					alert("successful process");
					location.reload(); 
				},
				function(){
					alert("failed addition");
				}
			);
        	
        }
    };
})();