$().ready(function() {

	$('.summernote').summernote({
		height : '220px',
		lang : 'zh-CN',
		callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            }
        }
	});
	validateRule();
});


$.validator.setDefaults({
	submitHandler : function() {
		save(1);
	}
});
function save(status) {
	$("#status").val(status);
	var content_sn = $("#content_sn").summernote('code');
	$("#content").val(content_sn);
	var formFile = new FormData();
	formFile.append("discoverTitle", $("#title").val());
    formFile.append("file", document.getElementById("author").files[0]);  
    formFile.append("discoverMessage", $("#content").val());
    formFile.append("discoverType", $("#sel").val());
	$.ajax({
		cache : true,
		type : "POST",
		url : "/blog/bContent/save",
		data : formFile,//$('#signupForm').serialize(),
		async : false,
		processData: false,//用于对data参数进行序列化处理 这里必须false
	    contentType: false, //必须
		error : function(request) { 
			parent.layer.alert("Connection error");
		},
		success : function(r) {
			if (r.code == 0) {
				parent.layer.msg(r.msg);
				$("#cid").val(r.discoverId);
				var index = parent.layer.getFrameIndex(window.name);  
				parent.layer.close(index); 
				parent.reLoad();
			} else {
				parent.layer.alert(r.msg)
			} 
		}
	});
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
		},
		messages : {
		}
	});
}

function returnList() {
	var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
	parent.layer.close(index);
}