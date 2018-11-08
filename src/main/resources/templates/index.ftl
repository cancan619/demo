<html>
<head>
    <title>AAAA</title>
    <script src="${request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <link href="${request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
 	
 	<!-- 引入bootstrap的css -->
<link  href="${request.contextPath}/js/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<!-- 引入bootstrap-treeview的css -->
<link  href="${request.contextPath}/js/js/treeview/bootstrap-treeview.min.css" rel="stylesheet" >
<!-- 引入bootstrap-addTabs的css -->
<link  href="${request.contextPath}/js/js/addTabs/addTabs.css" rel="stylesheet" >
<!-- 引入bootstrap-table的css -->
<link  href="${request.contextPath}/js/js/table/bootstrap-table.min.css" rel="stylesheet" >
<!-- 引入fileinput的css -->
<link type="text/css" rel="stylesheet" href="${request.contextPath}/js/js/fileinput/css/fileinput.min.css" />
<!-- 引入jquery -->
<script type="text/javascript" src="${request.contextPath}/js/js/jquery.min.js"></script>
<!-- 引入my97 -->
<script type="text/javascript" src="${request.contextPath}/js/js/my97/WdatePicker.js"></script>
<!-- 引入bootstrap的js-->
<script type="text/javascript" src="${request.contextPath}/js/js/bootstrap/js/bootstrap.min.js"></script>
<!-- 引入bootstrap的js-->
<script type="text/javascript" src="${request.contextPath}/js/js/treeview/bootstrap-treeview.min.js"></script>
<!-- 引入bootstrap的js-->
<script type="text/javascript" src="${request.contextPath}/js/js/addTabs/addTabs.js"></script>
<!-- 引入bootstrap-table的js-->
<script type="text/javascript" src="${request.contextPath}/js/js/table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/js/js/table/locale/bootstrap-table-zh-CN.min.js"></script>
<!-- 引入bootbox.js -->
<script type="text/javascript" src="${request.contextPath}/js/js/bootbox/bootbox.js"></script>
<!-- 引入fileinput的js -->
<script type="text/javascript" src="${request.contextPath}/js/js/fileinput/js/fileinput.min.js"></script>
<!--  引入fileinput的js -->
<script type="text/javascript" src="${request.contextPath}/js/js/fileinput/js/locales/zh.js"></script>


<script type="text/javascript" src="${request.contextPath}/js/js/fileinput/themes/fa/theme.js"></script>
    <style type="text/css">
        .pageDetail {
            display: none;
        }

        .show {
            display: table-row;
        }
    </style>
</head>
<body>
<table id="bootTable"></table>
	
</body>
<script >
$(function (){
	$("#bootTable").bootstrapTable({
		 url:"${request.contextPath}/queryCookMenu",
		 method:"post",
		 striped: true,  	// 斑马线效果     默认false 
		 //只允许选中一行
		 singleSelect:true,
		 //选中行是不选中复选框或者单选按钮
		 clickToSelect:true,
		 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
		 cardView: false,                    //是否显示详细视图
		 uniqueId: "canid",                 //每一行的唯一标识，一般为主键列
		 showColumns: true,                  //是否显示所有的列
		 showRefresh: true,                  //是否显示刷新按钮
		 minimumCountColumns: 2,     //  最少留两列
		 detailView: false,                  //是否显示父子表
		 //发送到服务器的数据编码类型  
		contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
		toolbar:'#tabToolBar',   //  工具定义位置
	//  与 easyui  datagrid 不同的 地方     columns:[[]]   两个中括号
		columns:[
				{field:'chk',title:'选择',width:50,
					formatter:function(value,row,index){   //  格式化  当前单元格内容
						return "<input type='checkbox' value="+row.canId+" name='chk'/>";
					}
				},
				{field:'userId',title:'用户编号',width:100},      //  列    field   代表是 后台  传过来的值
				{field:'userName',title:'用户名称',width:100},    
				{field:'userSex',title:'用户性别',width:100,
					   formatter:function (value,row,index){
						   if(value==1){
							   return "男";
						   }else{
							   return "女";
						   }
					   }
				},
				{field:'userAge',title:'用户年龄',width:100},
				{field:'userDate',title:'用户出生日期',width:100},
				{field:'crud',title:'操作',width:100,
					formatter:function(value,row,index){   //  格式化  当前单元格内容
						return '<a href="javascript:yanqi(&#039;'+row.canId+'&#039;)" role="button">延期</a></br>'+
						'<a  href="javascript:ghtx(&#039;'+row.userId+'&#039;)" role="button">修改</a>';
					} 
				}
				],
		       //传递参数（*）
				 queryParams: function(params) {
					 	var whereParams = {    
					 			/*
					 				分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）           
					 				*/
					 			"pageSize":params.limit,
					 			"start":params.offset,
								"map['canName']":params.search,//精确搜索产品名称
								"map['canName']":$("#canName").val(),
								"map['minDate']":$("#minTime").val(),
								"map['maxDate']":$("#maxTime").val()
					 	}
						 return whereParams;
					 },
					 //前台--排序字段
					 //sortName:'proPrice',
					 //sortOrder:'desc',
					 //前台--搜索框
					 search:true,
					 //启动回车键做搜索功能
					 searchOnEnterKey:true,	 
		         //分页方式   后台请求的分页方式
				 sidePagination:'server',
				 pagination: true,                   //是否显示分页（*）
				 pageNum: 1,                       //每页的记录行数（*）
				 pageSize: 2,                       //每页的记录行数（*）
				 pageList: [2, 6,9,12],        //可供选择的每页的行数（*） 
	});
	
	
})
function addUser(){
	window.open ('${request.contextPath}/tiaoseve','newwindow','height=400,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') 
}
</script>
</html>