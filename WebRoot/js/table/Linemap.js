/**
 * 地图，标记物，绘线
 */
var map, marker, polyline;
var markers = [];
var count = 0;
map = new AMap.Map('LineMap', {
	resizeEnable : true,
	zoom : 16,
	center : [ 121.61122, 29.91092 ],
});
// 为地图注册click事件获取鼠标点击出的经纬度坐标
var mapDataInfo = [];
var clickEventListener = map.on('click', function(e) {
	count++;
	if (count % 2 != 0) {
		// 起点
		/*
		 * for(var i=0;i<mapDataInfo.length;i++){ alert(mapDataInfo[i]);
		 * map.remove(mapDataInfo[i]); }
		 */
		if (markers != null) {
			// map.remove(polyline);
			map.remove(markers);
		}
		if (polyline != null) {
			map.remove(polyline);
		}
		markers = [];
		mapDataInfo = [];
		addMarker(e.lnglat.getLng(), e.lnglat.getLat());
		mapDataInfo.push([ e.lnglat.getLng(), e.lnglat.getLat() ]);
		$("#LineFirstPolelon").val(e.lnglat.getLng());
		$("#LineFirstPolelat").val(e.lnglat.getLat());
	} else {
		// 终点
		addMarker(e.lnglat.getLng(), e.lnglat.getLat());
		mapDataInfo.push([ e.lnglat.getLng(), e.lnglat.getLat() ]);
		$("#LineLastPolelon").val(e.lnglat.getLng());
		$("#LineLastPolelat").val(e.lnglat.getLat());
		polyline = new AMap.Polyline({
			path : mapDataInfo, // 设置线覆盖物路径
			strokeColor : '#3366FF', // 线颜色
			strokeOpacity : 1, // 线透明度
			strokeWeight : 2, // 线宽
			strokeStyle : 'solid', // 线样式
			strokeDasharray : [ 10, 5 ], // 补充线样式
			geodesic : true
		// 绘制大地线
		});
		polyline.setMap(map);
	}
});
function addMarker(lng, lat) {
	marker = new AMap.Marker({
		icon : "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
		position : [ lng, lat ]
	});
	marker.setMap(map);
	markers.push(marker);
}