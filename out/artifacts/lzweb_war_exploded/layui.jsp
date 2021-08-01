<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 --> 
 
<script>
layui.use('table', function(){
  var table = layui.table;
  table.render({
    elem: '#test'
    ,url:'http://localhost:8080/QueryStudentServlet'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'id', title:'ID', width:300, fixed: 'left', unresize: true, sort: true}
      ,{field:'num', title:'学号', width:100}
      ,{field:'userName', title:'用户名', width:120, edit: 'text'}
      ,{field:'psd', width:80, title:'密码'}
      ,{field:'zy', title:'专业', width:80, sort: true}
    ]]
    ,page: true
  });
  //监听行工具事件
});
</script>

</body>
</html>