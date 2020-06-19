<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/resource/css/style.css"/>
    <link href="${ctx}/resource/assets/css/codemirror.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome.min.css" />
    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-ie.min.css" />
    <![endif]-->
    <script src="${ctx}/resource/assets/js/jquery.min.js"></script>
    <script src="${ctx}/resource/AJAX.js"></script>

    <!-- <![endif]-->

    <!--[if IE]>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <![endif]-->

    <!--[if !IE]> -->

    <script type="text/javascript">
        window.jQuery || document.write("<script src='${ctx}/resource/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
    </script>

    <!-- <![endif]-->

    <!--[if IE]>
    <script type="text/javascript">
        window.jQuery || document.write("<script src='${ctx}/resource/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
    </script>
    <![endif]-->

    <script src="${ctx}/resource/assets/js/bootstrap.min.js"></script>
    <script src="${ctx}/resource/assets/js/typeahead-bs2.min.js"></script>
    <!-- page specific plugin scripts -->
    <script src="${ctx}/resource/assets/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/H-ui.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/H-ui.admin.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript" ></script>
    <script src="${ctx}/resource/assets/laydate/laydate.js" type="text/javascript"></script>
    <title>修改</title>
</head>

<body>
<!--添加用户图层-->
<form action="laboratory_update" method="post" class="form form-horizontal" id="update" >
    <input value="${bean.id}" name="id"  type="hidden" class="text_add"/>
    <div class="add_menber" id="add_menber_update">
        <ul>
            <li><label class="label_name" style="width: 130px">实验课程名称：</label>
                <span class="add_name">
                <input value="${bean.name}" name="curriculum" type="text" id="实验课程名称" class="text_add"/>
            </span>
            </li>
            <li>
                <label class="label_name"style="width: 130px">所属实验室：</label>
                <span class="add_name">
                <select name="laboratory_id" style="width: 165px; margin-left: 10px" class="text_add">
                    <option value="" id="所属实验室">请选择</option>
                    <c:forEach items="${pgs2}" var="b" varStatus="l">
                        <option value="${b.id}">${b.name}</option>
                    </c:forEach>
                </select>
        </span>
            </li>
        </ul>
    </div>
        <div style="float: left; margin-top: 50px; margin-left: 40%">
            <input class="btn btn-primary radius" type="button"  onclick="save_info();" value="提交" >
        </div>
</form>
<script>
    function save_info(){
        var num=0;
        var str="";
        $(".add_menber_update input[type$='text']").each(function(n){
            if($(this).val()==""){
                layer.alert(str+=""+$(this).attr("id")+"不能为空！\r\n",{
                    title: '提示框',
                    icon:0,
                });
                num++;
                return false;
            }
        });
        if(num>0){  return false;}
        else{
            AJAX("curriculum_save", "添加成功", "update");
        }
    };

</script>
</body>

</html>