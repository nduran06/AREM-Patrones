var api = apiclient;
var app = (function () {
	
	    
	var addUser = function(userName, userBirth, userDoc, userPhone, userEmail) {
		var newUser = {
			name : userName,
			birthday : userBirth,
			document : userDoc,
			phone : userPhone,
			email : userEmail
		};
		api.setUser(JSON.stringify(newUser));
		
		
	}
	
	
	var getTable = function (users) {
		
        $("#usersTableBody").empty();
        users.map(function (user) {
            $("#usersTableBody").append(
                "<tr> " +
                "<td>" + user.name + "</td> " +
                "<td>" + user.birthday + "</td> " +
                "<td>" + user.document + "</td> " +
                "<td>" + user.phone + "</td> " +
                "<td>" + user.email + "</td> " +
                "</tr>"
            );
        });
	}
	
	var onload = function(){
		api.getUsers(getTable);
	}
    
    return {
    	onload : onload,
    	addUser: addUser
    };
})();