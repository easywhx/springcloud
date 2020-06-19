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
    <!-- page specific plugin scripts -->
    <script src="${ctx}/resource/assets/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/H-ui.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/H-ui.admin.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript" ></script>
    <script src="${ctx}/resource/echarts/echarts.min.js" type="text/javascript"></script>
    <title>实验室列表</title>
    <script>
        $(function () {
            if ('${login}' == '1'){
                top.location = 'login_login.do';
            }
            getData();
        })
    </script>
</head>

<body>
<div class="page-content clearfix">
	<div id="main" style="width: 900px;height:600px;"></div>
</div>
</body>
</html>
<script>
var myChart = echarts.init(document.getElementById('main'));

function getData(){
	$.ajax({
		url:'equipmentlog_get_stats_data',
		success:function(data){
			if(data.flag){
				var xdata = [],ydata = [];
				$.each(data.statsData, function (key, value) {
					xdata.push(key);
					ydata.push(value);
				});
				// 指定图表的配置项和数据
				var option = {
				    title: {
				        text: '实验室设备情况统计'
				    },
				    tooltip: {
				        trigger: 'axis',
				        axisPointer: {
				            type: 'cross',
				            label: {
				                backgroundColor: '#283b56'
				            }
				        }
				    },
				    legend: {
				        data:['借用次数']
				    },
				    xAxis: {
				        data: xdata
				    },
				    yAxis: {},
				    series: [{
				        name: '借用次数',
				        type: 'line',
				        data: ydata
				    }]
				};
				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
				return;
			}
			alert('还没有预约数据!');
		}
	})
}
</script>