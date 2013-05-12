
$(document).ready(function() {
	// Variant two - call with request parameter
	$.ajax({
		url: "resources/users/getUserInfo?userId=1",
		success: function(user) {
			$('#requestParam .name').text(user.name);
			$('#requestParam .username').text(user.username);
			$('#requestParam .email').text(user.email);
		}
	});
	
	// Variant one - call with path variable
	$.ajax({
		url: "resources/users/getUserInfo/1",
		success: function(user) {
			$('#pathParam .name').text(user.name);
			$('#pathParam .username').text(user.username);
			$('#pathParam .email').text(user.email);
		}
	});
	
	$.ajax({
		url: "resources/users/getUsers",
		success: fillUsersTable
	});
	
});


function fillUsersTable(users) {
	$("#usersTableBody").empty();
	$.each(users, function(index, user) {
		var trTdValue = "<tr>" +
				"<td>" + user.userId + "</td>" + 
				"<td>" + user.name + "</td>" + 
				"<td>" + user.username + "</td>" + 
				"<td>" + user.email + "</td>" +
				"</tr>";
			
		$("#usersTableBody").append(trTdValue);
	});
}