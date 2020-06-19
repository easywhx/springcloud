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
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome-ie7.min.css" />
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-ie.min.css" />
    <script src="${ctx}/resource/assets/js/jquery.min.js"></script>
    <script src="${ctx}/resource/assets/js/bootstrap.min.js"></script>
    <script src="${ctx}/resource/assets/js/typeahead-bs2.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/H-ui.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/H-ui.admin.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript" ></script>
    <script src="${ctx}/resource/assets/laydate/laydate.js" type="text/javascript"></script>
    <script src="${ctx}/resource/AJAX.js" type="text/javascript"></script>
    <script src="${ctx}/resource/js/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.ui.touch-punch.min.js"></script>
    <script src="${ctx}/resource/assets/js/ace-elements.min.js"></script>
    <script src="${ctx}/resource/assets/js/ace.min.js"></script>
    <script src="${ctx}/resource/AJAX.js"></script>

    <title>设备列表</title>
    <script>
        $(function () {
            alert(${login})
            if ('${login}' == '1'){
                top.location = 'login_tuichu';
            }
        })
    </script>
</head>

<body>
<div class="page-content clearfix">
    <div id="Member_Ratings">
        <div class="d_Confirm_Order_style">
            <form method="post" action="curriculum_dataList">
            <div class="search_style">
                <ul class="search_content clearfix">
                    <li><label class="l_f">实验室课程名称</label><input name="curriculum" type="text" value="" class="text_add"  style=" width:200px"/></li>
                    <li style="width:90px;"><button type="submit" class="btn_search"><i class="icon-search"></i>查询</button></li>
                </ul>
            </div>
                </form>
            <%--<form  method="post" action="equipment_export.do">--%>
                <%--<input name="xh" type="hidden" value="${bean.xh}" class="text_add"  style=" width:200px"/>--%>
                <%--<input name="zzs" type="hidden" value="${bean.zzs}" class="text_add"  style=" width:200px"/>--%>
                <%--<input name="sbxlh" type="hidden" value="${bean.sbxlh}" class="text_add"  style=" width:200px"/>--%>
            <%--<!-- <div class="border clearfix">--%>
       <%--<span class="l_f" style="display: none;" >--%>
        <%--<button type="submit" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>导出表格</button>--%>
       <%--</span>--%>
            <%--</div> -->--%>
            <%--</form>--%>
            <a href="javascript:;" id="member_add" class="btn btn-warning" onclick="member_add()"><i class="icon-plus"></i>添加实验室课程</a>

            <div class="table_menu_list">
                <table class="table table-striped table-bordered table-hover" id="sample-table">
                    <thead>
                    <tr>
                    	<th width="150">实验室名称</th>
                    	<th width="150">实验室课程</th>
                    	<th width="150">课程大纲</th>
                        <th width="150">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${pgs}" var="c" varStatus="l">
                        <tr>
                         <td>${c.laboratory.name}</td>
                         <td>${c.curriculum}</td>
                         <td>
                            <c:if test="${not empty c.ht}">
                            <a href="curriculum_download?id=${c.id}"><span class="label label-success radius">查看大纲</span></a>
                            </c:if>
                            <c:if test="${empty c.ht}">
                            <span class="label label-defaunt radius">无</span>
                            </c:if>
                        </td>
                        <td class="td-manage">
                            <%--<a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a>--%>
                                <%--<c:if test="${c.isFw == 0}">--%>
                            <%--<a title="开始使用" onclick="sh(${c.id})" href="javascript:;"  class="btn btn-xs btn-warning" ><i class="icon-edit bigger-120"></i></a>--%>
                                <%--</c:if>--%>
                                <a title="添加课程大纲"  onclick="cli(${c.id})" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a>

                            <a title="删除" href="javascript:;"  onclick="member_del(this,${c.id})" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>

                        </td>
                    </tr>
                          </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- 分页开始 -->
    <div class="pagelist">
        <pg:pager url="${ctx}/equipment_dataList.do" maxIndexPages="5" items="${pagers.total}" maxPageItems="5"
                  export="curPage=pageNumber">
            <pg:param name="xh" value="${bean.xh}"/>
            <pg:param name="zzs" value="${bean.zzs}"/>
            <pg:param name="sbxlh" value="${bean.sbxlh}"/>
            <pg:last>
                共${pagers.total}记录,共${pageNumber}页,
            </pg:last>
            当前第${curPage}页
            <pg:first>
                <a href="${pageUrl}">首页</a>
            </pg:first>
            <pg:prev>
                <a href="${pageUrl}">上一页</a>
            </pg:prev>
            <pg:pages>
                <c:choose>
                    <c:when test="${curPage eq pageNumber}">
                        <font color="red"><span class="current">${pageNumber }</span></font>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageUrl}">${pageNumber}</a>
                    </c:otherwise>
                </c:choose>
            </pg:pages>
            <pg:next>
                <a href="${pageUrl}">下一页</a>
            </pg:next>
            <pg:last>
                <c:choose>
                    <c:when test="${curPage eq pageNumber}">
                        <a href="##">尾页</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageUrl}">尾页</a>
                    </c:otherwise>
                </c:choose>

            </pg:last>
        </pg:pager>
    </div>
    <!-- 分页结束 -->
</div>
<!--添加用户图层-->
<form action="curriculum_updateDoc" method="post" class="form form-horizontal" id="form-user-add" enctype="multipart/form-data">
<div class="add_menber" id="add_menber_style" style="display:none; margin-top: 50px; text-align: center; ">
    <div class="form-group" style="width: 100%">
        <label class="col-sm-1 control-label no-padding-right" for="form-field-1" style="width: 100px;">实验大纲： </label>
        <div class="col-sm-9">
            <input type="file" name="file" id="id-input-file-2" class="请选择文件" style="width: 300px " accept="text/plain,application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document"/>
            <input type="hidden" name="id" id="isId" value=""/>
        </div>
    </div>
    <%--<input type="submit" value="提交"/>--%>
    </form>

</body>
</html>
<script>
    $('#id-input-file-2').ace_file_input({
        no_file:'选择上传大纲 ...',
        btn_choose:'选择',
        btn_change:'更改',
        droppable:false,
        onchange:null,
        scrollbar: false,
        thumbnail:false, //| true | large
        whitelist:'doc'
        //blacklist:'exe|php'
        //onchange:''
        //
    });



    function  cli(id) {
        $('#isId').val(id);
        layer.open({
            type: 1,
            title: '添加实验大纲',
            maxmin: true,
            scrollbar: false,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '300px'],
            content:$('#add_menber_style'),
            btn:['提交','取消'],
            yes:function(index,layero){
                var num=0;
                var str="";
                $(".add_menber input[type$='file']").each(function(n){
                    if($(this).val()==""){
                        layer.alert(str+=""+$(this).attr("class"),{
                            title: '提示框',
                            icon:0,
                        });
                        num++;
                        return false;
                    }
                });
                if(num>0){
                    return false;
                }else{
                    $('#form-user-add').submit();
                }
            }
        });

    }


    function member_add() {
        layer.open({
            type: 2,
            area: ['910px', '500px'],
            content: ['curriculum_add', 'no']  //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
    }


    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            updateId("curriculum_delete", "删除成功", id)
        });
    }
    laydate({
        elem: '#start',
        event: 'focus'
    });

</script>