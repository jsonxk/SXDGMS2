/**
 * 地图，标记物，绘线
 */
var map, marker, polyline;
/**
 * 所有标记物
 */
var markers = [];
/**
 * 判断第几次点击
 */
var count = 0;
/**
 * 用户计算两点距离
 */
var lnglat,Pointdistance,distanceNew; 
var regular=/([0-9]+\.[0-9]{2})[0-9]*/;
map = new AMap.Map('LineMap', {
	resizeEnable : true,
	zoom : 16,
	center : [ 121.61122, 29.91092 ],
});
// 为地图注册click事件获取鼠标点击出的经纬度坐标
var mapDataInfo = [];
/**
 * 地图点击监听事件
 */
var clickEventListener = map.on('click', function(e) {
	count++;
	if (count % 2 != 0) {
		// 起点
		/**
		 * 移除画线和标记物
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
		mapDataInfo.push([e.lnglat.getLng(), e.lnglat.getLat()]);
		$("#LineFirstPolelon").val(e.lnglat.getLng());
		$("#LineFirstPolelat").val(e.lnglat.getLat());
	} else {
		// 终点
		addMarker(e.lnglat.getLng(), e.lnglat.getLat());
		mapDataInfo.push([ e.lnglat.getLng(), e.lnglat.getLat()]);
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
		/*
		 * 计算选择点的距离
		 */
		lnglat = new AMap.LngLat(mapDataInfo[0].lng,mapDataInfo[0].lat);
		Pointdistance=lnglat.distance([mapDataInfo[1].lng,mapDataInfo[1].lat])+"";
		distanceNew=Pointdistance.replace(regular,"$1");
		$("#LineLength").val(distanceNew);
	}
});
/**
 * 添加标记
 * @param lng经纬度
 * @param lat
 */
function addMarker(lng, lat) {
	marker = new AMap.Marker({
		icon : "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
		position : [ lng, lat ]
	});
	marker.setMap(map);
	markers.push(marker);
}
/**
 * 地点搜索提示 
 */
/*var autoOptions = {
        input: "LinePlace"
};
var auto = new AMap.Autocomplete(autoOptions);
*//**
 * 地点查询类
 *//*
var placeSearch = new AMap.PlaceSearch({
    map: map
});
*//**
 * 注册监听，当选中某条记录时会触发
 *//*
AMap.event.addListener(auto, "select", select);
function select(e) {
    placeSearch.setCity(e.poi.adcode);
    placeSearch.search(e.poi.name);  //关键字查询查询
}*/

/**
 * polemap
 */
var PoleMap,PoleMarker;
var PoleMarkers=[];
PoleMap = new AMap.Map('mapdiv', {
	resizeEnable : true,
	zoom : 16,
	center : [ 121.61122, 29.91092 ],
});
var mapclickEventListener = PoleMap.on('click', function(e) {
	addMarkerPole(e.lnglat.getLng(), e.lnglat.getLat());
	$("#PoleLon").val(e.lnglat.getLng());
	$("#PoleLat").val(e.lnglat.getLat());
});
function addMarkerPole(lng, lat) {
	if(PoleMarkers!=null)
		{
			PoleMap.remove(PoleMarkers);
		}
	PoleMarker = new AMap.Marker({
		icon : "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
		position : [ lng, lat ]
	});
	PoleMarker.setMap(PoleMap);
	PoleMarkers.push(PoleMarker);
}
