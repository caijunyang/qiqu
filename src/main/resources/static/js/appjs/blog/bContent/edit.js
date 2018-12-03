$().ready(function() {
	$('.summernote').summernote({
		height : '220px',
		lang : 'zh-CN',
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                console.log("onImageUpload");
                sendFile(files);
            }
        }
    });
	var content = $("#content").val();

	$('#content_sn').summernote('code', content);
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save(status) {
	$("#status").val(status);

	var content_sn = $("#content_sn").summernote('code');
	$("#content").val(content_sn);
	var formFile = new FormData(); 
	formFile.append("discoverId", $("#cid").val());
	formFile.append("discoverTitle", $("#title").val());
	formFile.append("discoverType", $("#sel").val());
	var file = document.getElementById("author").files[0];
	var url = "/blog/bContent/save";
	if(file == null || file == undefined ){
		url = "/blog/bContent/update";
	}else{
		formFile.append("file",file);  
	}
    formFile.append("discoverMessage", $("#content").val());
	$.ajax({
		cache : true,
		type : "POST",
		url : url,
		data : formFile,// 你的formid
		async : false,
		processData: false,//用于对data参数进行序列化处理 这里必须false
	    contentType: false, //必须
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				var index = parent.layer.getFrameIndex(window.name);  
				parent.layer.close(index); 
				parent.reLoad();
			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}

function returnList() {
	var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
	parent.layer.close(index);
}

