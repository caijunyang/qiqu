var prefix = "/xingche"
$(function() {
	load();

});
$('#exampleTable').on('load-success.bs.table', function (e, data) {
		    if (data.total && !data.rows.length) {
		    	$('#exampleTable').bootstrapTable('selectPage').bootstrapTable('refresh');
		    }
		});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						// showRefresh : true,
						// showToggle : true,
						// showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						// search : true, // 是否显示搜索框
						// showColumns : true, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
						// "server"
						queryParams : function(params) {
							return {
								limit : params.limit,
								offset : params.offset,
								sort : 'journey_createtime',
								order : 'desc',
								userName : $("#searchUsername").val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
								{
									field : 'journey_id', // 列字段名
									title : '行程号' // 列标题
								},
								{
									field : 'user_name',
									title : '用户昵称'
								},
								{
									field : 'share_id',
									title : '单车车牌号'
								},
								{
									field : 'journey_time',
									title : '行程花费时间(分)'
								},
								{
									field : 'journey_distance',
									title : '行程距离(Km)'
								},
								{
									field : 'journey_money',
									title : '行程消费(元)'
								},
								{
									field : 'journey_createtime',
									title : '行程开始时间'
								},
								{
									title : '结束',
									field : 'journey_id',
									align : 'center',
									formatter : function(value, row, index) {
										var d = '<a class="btn btn-warning btn-sm" href="#" title="删除"  mce_href="#" onclick="remove2(\''
												+ row.share_id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										if(row.journey_time!=null && row.journey_time!=0){
											return "";
										}else{
											return d;
										}
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'id' : id
			},
			beforeSend : function(request) {
				index = layer.load();
			},
			success : function(r) {
				if (r.code == 0) {
					layer.close(index);
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	})
}

function remove2(id) {
	layer.confirm('确定要结束选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : "/bike/end",
			type : "post",
			data : {
				'shareId' : id,
				"lat" : 11,
				"lng" : 11
			},
			beforeSend : function(request) {
				index = layer.load();
			},
			success : function(r) {
				if (r.code == "200") {
					 layer.close(index);
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	})
}

function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['journey_id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {
	});
}