(function (window) {
	$(document).ready(function () {
		showTodoAll();
		count();
	});
})(window);	

$(function(){
	$(".filters li a").click(function(){
	$(".filters li a").removeClass("selected");
	$(this).addClass("selected");
	});
});

$("#ntodo").keydown(function(key) {
	if(key.keyCode == 13) {
		var ntodo=$("#ntodo").val();
		if(ntodo =='') {
			alert('한글자 이상의 값을 입력하세요!')
		} else {
			$.ajax({
				   url : "api/todos/insert",
			   	   type : "post",
			       contentType: "application/json;",
			       dataType : "json",
			       data : JSON.stringify(ntodo),
			       complete: function() {
			    	    showTodoAll();
						count();
			       }
		    });
			
		}
	 }
});

function count() {
	  $("#count").empty();
	  $.ajax({
		   url : "api/todos/count",
		   type : "get",
		   success : function(data){
			   $("#count").append(data);
		   }
		});
}

function showTodoAll() {
	$('.todo-list').empty();
	$.ajax({
		url : "api/todos/showTodoAll",
		type : "get",
		success : function(data){
		jQuery.each(data,function(i, val){
			if(val.completed == 1) {
					$('.todo-list').append('<li class="completed"><div class="view"><input class="toggle" type="checkbox" checked><label>'+val.todo+'</label><button class="destroy" onclick="deleteById(this)"></button></div><input class="edit" value="Create a TodoMVC template"><input type="hidden" value="'+val.id+'"></li>');
				} else {
					$('.todo-list').append('<li class="notComplete"><div class="view"><input class="toggle" type="checkbox" onclick="updateComplete(this)"><label>'+val.todo+'</label><button class="destroy" onclick="deleteById(this)"></button></div><input class="edit" value="Rule the web"><input type="hidden" value="'+val.id+'"></li>');
				}
			});
		}
	});  
}
		
function showTodoCompleted() {
	$('.todo-list').empty();
	$.ajax({
		url : "api/todos/showTodoCompleted",
		type : "get",
		success : function(data){
		jQuery.each(data,function(i, val){
			$('.todo-list').append('<li class="completed"><div class="view"><input class="toggle" type="checkbox" checked><label>'+val.todo+'</label><button class="destroy" onclick="deleteById(this)"></button></div><input class="edit" value="Create a TodoMVC template"></li>');				   
		});
		}
	});
}
			  

function showTodoActive() {
			  
	$('.todo-list').empty();	  
	$.ajax({				   
		url : "api/todos/showTodoActive",
		type : "get",
		success : function(data){
		jQuery.each(data,function(i, val){
			$('.todo-list').append('<li class="notComplete"><div class="view"><input class="toggle" type="checkbox" onclick="updateComplete(this)"><label>'+val.todo+'</label><button class="destroy" onclick="deleteById(this)></button></div><input class="edit" value="Rule the web"></li>');
		});
	    }
	});
}

function deleteById(_this) {
		  var id = $(_this).closest("li").find("input[type=hidden]").val();
		  var url = "api/todos/"+id
		  $.ajax({
			   url : url,
			   type : "delete",
			   contentType: "application/json;",
		       dataType : "json",
		       complete: function() { 
				  	showTodoAll();
				  	count();
			   }
		  }); 
}

function updateComplete(_this) {
	  var id = $(_this).closest("li").find("input[type=hidden]").val();
	  var url = "api/todos/"+id
	  $.ajax({
		   url : url,
		   type : "put",
		   contentType: "application/json;",
	       dataType : "json",
	       complete: function() { 
			  	showTodoAll();
			  	count();
		   }
	  });
}

function clearCompleted() {
	  $.ajax({
		   url : "api/todos/clearCompleted",
		   type : "delete",
		   complete: function() { 
			  	showTodoAll();
		   }
	  });  
}
