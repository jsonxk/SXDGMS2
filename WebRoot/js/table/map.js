//高德地图
function map(){
	alert(1);
    var windowsArr = [];
    var marker = [];
      //获取当前经纬度
 var mMap=function(){
    function rad(d){
        return d*Math.PI/180.0;
    }
    this.map={},
    this.geolocation={},
    this.k=0,
    //加载地图，调用浏览器定位服务
    this.initMap=function(mapContainer,completFunc){
        if(typeof(AMap)=="object"){
            this.map = new AMap.Map(mapContainer, {
             resizeEnable: true
         });
     this.map.plugin('AMap.Geolocation', function () {
            this.geolocation = new AMap.Geolocation({
                enableHighAccuracy: true,//是否使用高精度定位，默认:true
                timeout: 1000,          //超过10秒后停止定位，默认：无穷大
                maximumAge: 0,           //定位结果缓存0毫秒，默认：0
                convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
                showButton: true,        //显示定位按钮，默认：true
                buttonPosition: 'LB',    //定位按钮停靠位置，默认：'LB'，左下角
                buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
                showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true
                panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
                zoomToAccuracy:true      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            });
            this.map.addControl(this.geolocation);
            AMap.event.addListener(this.geolocation, 'complete', onComplete);//返回定位信息
            AMap.event.addListener(this.geolocation, 'error', onError);      //返回定位出错信息
        });
        function onComplete(data){
            console.log(completFunc)
            console.log(data)
            if(completFunc){
                completFunc(data);
            }
        }
        function onError(data){
            var str = '定位失败,';
            str += '错误信息：';
            switch(data.info) {
                case 'PERMISSION_DENIED':
                    str += '浏览器阻止了定位操作';
                    break;
                case 'POSITION_UNAVAILBLE':
                    str += '无法获得当前位置';
                    break;
                case 'TIMEOUT':
                    str += '定位超时';
                    break;
                default:
                    str += '未知错误';
                    break;
            }
            alert("无法定位");
            locationFunc();
            //alert(str)
        }
    }
},
 this.getCurrentPosition=function(callback){
    if(typeof(this.geolocation.getCurrentPosition)!='undefined'){
        this.geolocation.getCurrentPosition();
    }else{
        setTimeout(function(){
            //将获得的经纬度信息，放入sessionStorge
            this.getSessionLocation(callback)
        },200)
    }

},

this.distance = function(obj1,obj2){//return：m
    var lng=new AMap.LngLat(obj1.lng, obj1.lat);
    var lag=new AMap.LngLat(obj2.lng, obj2.lat);
    var ss=lng.distance(lag);
    return ss;
},
this.getSessionLocation=function(callback){
    if(sessionStorage.getItem('location')){
        callback();
    }else{
        this.initMap('',function(data){
            sessionStorage.setItem("location",JSON.stringify(data))
            callback();
        });
        this.getCurrentPosition(callback);
       }
    },
 this.serverDistance = function(obj1,obj2){//return：m
    var radLat1 = rad(obj1.lat);
    var radLat2 = rad(obj2.lat);
    var a = radLat1 - radLat2;
    var b = rad(obj1.lng)- rad(obj2.lng);
    var s =  2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s *6378137;
        s = Math.round(s * 10000)/10000 ;
    return s;
}
     return this;
}();
 mMap.getSessionLocation(locationFunc)
        function locationFunc(){
        var data = JSON.parse(sessionStorage.getItem("location"));
         if(data==null){
               // lng=121.611207;
               // lat=29.911439;
            var map = new AMap.Map("mapContainer", {
               resizeEnable: true,
               zoom: 15,//地图显示的缩放级别
               keyboardEnable: false
           });
        }else{
               lng=data.position.lng;
               lat=data.position.lat;
             var map = new AMap.Map("mapContainer", {
               resizeEnable: true,
               center: [lng,lat],//地图中心点
               zoom: 15,//地图显示的缩放级别
               keyboardEnable: false
           });
        }
          
    AMap.plugin(['AMap.Autocomplete','AMap.PlaceSearch'],function(){
      var autoOptions = {
        input:"input"//使用联想输入的input的id
      };
      autocomplete= new AMap.Autocomplete(autoOptions);
      var placeSearch = new AMap.PlaceSearch({
            // city:'北京',
            map:map
      });
      AMap.event.addListener(autocomplete, "select", function(e){
         //TODO 针对选中的poi实现自己的功能
         placeSearch.setCity(e.poi.adcode);
         var start=document.getElementById("start");
         var end=document.getElementById("end");
         if(start.value==""){
            start.value=e.poi.district+e.poi.address;
         }else{
            end.value=e.poi.district+e.poi.address;
         }
         //alert(e.poi.district);
         placeSearch.search(e.poi.name);//具体名称
      });
    });

        AMap.plugin('AMap.Geocoder',function(){
        var geocoder = new AMap.Geocoder({
            city: "010"//城市，默认：“全国”
        });
        var marker = new AMap.Marker({
            map:map,
            bubble:true
        })
        var input = document.getElementById('input');
        var end=document.getElementById('end');
        function location(){
          var start=document.getElementById('start');
           var locate=[]
            locate[0]=lng;
            locate[1]=lat;
            marker.setPosition(locate);
            geocoder.getAddress(locate,function(status,result){
              if(status=='complete'){
              }else{
                // message.innerHTML = '无法获取地址'
              }
            });
        }
        location();
   /*     map.on('click',function(e){
            marker.setPosition(e.lnglat);
            geocoder.getAddress(e.lnglat,function(status,result){
              if(status=='complete'){
                 input.value = result.regeocode.formattedAddress;
                 end.value=result.regeocode.formattedAddress;
              }else{
                // message.innerHTML = '无法获取地址'
                input.value = "无法获取位置";
              }
            })
        });*/
  
      /*  input.onchange = function(e){
            var address = input.value;
            geocoder.getLocation(address,function(status,result){
              if(status=='complete'&&result.geocodes.length){
                marker.setPosition(result.geocodes[0].location);
                map.setCenter(marker.getPosition())
              }else{
              }
            })
        }*/
    });
}
   //locationFunc();
  /*    $.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js', function(_result) {
            if (remote_ip_info.ret == '1') {
               // alert('国家：' + remote_ip_info.country + '<BR>省：' + remote_ip_info.province + '<BR>市：' + remote_ip_info.city + '<BR>区：' + remote_ip_info.district + '<BR>ISP：' + remote_ip_info.isp + '<BR>类型：' + remote_ip_info.type + '<BR>其他：' + remote_ip_info.desc);
                var city=document.getElementById("povince");
                city.innerText=remote_ip_info.city;
            } else {
                alert('没有找到匹配的IP地址信息！');
            }
        });*/

    }
$(function(){
	map();
})