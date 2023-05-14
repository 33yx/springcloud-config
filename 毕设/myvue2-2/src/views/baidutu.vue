<template>
  <div>
    <div>
      <label>当前所在位置：</label><input v-model="form.address1"><el-button style="margin-top:40px;" type="primary" @click="cancel">返回</el-button>
    </div>
    <div id="allmap" class="allmap" />
  </div>

</template>

<script>
export default {
  data() {
    return {
      map: undefined,
      form:{
        sellername:'',
        bidentity:'',
        bphone:'',
        bpassord:'',
        address1:'',
      }
    }
  },
  mounted() {
    this.initMap()
  },
  created(){
    var count=0
    let _this=this
    if(sessionStorage.getItem("but")==='1'){
    }else {

      sessionStorage.setItem("but",count)
    }
    if (sessionStorage.getItem("but")==='0') {

      _this.form.sellername=this.$route.params.sellername
      _this.form.bphone=this.$route.params.phone,
        _this.form.bpassord=this.$route.params.password,
        _this.form.bidentity=this.$route.params.identity

      count=1
      sessionStorage.setItem("but",count)

      sessionStorage.setItem('bname',_this.$route.params.sellername);
      sessionStorage.setItem('bphone', _this.$route.params.phone); //初次收到userKey，存起来
      sessionStorage.setItem('bpassword',_this.$route.params.password);
      sessionStorage.setItem('bidentity',_this.$route.params.identity);


    }else {

      _this.form.sellername = sessionStorage.getItem('bname')
      _this.form.bphone = sessionStorage.getItem('bphone')
      _this.form.bpassord = sessionStorage.getItem('bpassword')
      _this.form.bidentity = sessionStorage.getItem('bidentity')

    }


  },
  beforeDestroy () {
//毁灭前先移除掉，否则我跳转到其它地方，sessionStorage里面依旧存在着userKey
    sessionStorage.removeItem('but')
    sessionStorage.removeItem('bphone')
    sessionStorage.removeItem('bidentity')
    sessionStorage.removeItem('bpassword')
  },
  methods: {
    initMap() {
      // 百度地图API功能
      // 创建Map实例
      var map = new BMap.Map('allmap', { enableMapClick: false })
      this.map = map
      // 初始化地图,设置中心点坐标和地图级别
      map.centerAndZoom(new BMap.Point(106.55, 29.57), 13)
      // 允许滚轮缩放
      map.enableScrollWheelZoom(true)
      // 禁止拖拽
      // map.disableDragging()
      // 允许拖拽
      // map.enableDragging()
      // 获取可视区域
      var bs = map.getBounds()
      // 可视区域左下角
      var bssw = bs.getSouthWest()
      // 可视区域右上角
      var bsne = bs.getNorthEast()
      console.log('当前地图可视范围是：' + bssw.lng + ',' + bssw.lat + '到' + bsne.lng + ',' + bsne.lat)
      // 添加平移和缩放按钮
      map.addControl(new BMap.NavigationControl({ anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL }))
      // 添加地图类型(2D图，混合图)
      var mapType1 = new BMap.MapTypeControl(
        {
          mapTypes: [BMAP_NORMAL_MAP, BMAP_HYBRID_MAP],
          anchor: BMAP_ANCHOR_TOP_LEFT
        }
      )
      map.addControl(mapType1)
      // 添加定位控件
      let _this=this
      var geolocationControl = new BMap.GeolocationControl()
      geolocationControl.addEventListener('locationSuccess', function(e) {
        console.log(e)
        // 定位成功事件
        var address = ''
        address += e.addressComponent.province
        address += e.addressComponent.city
        address += e.addressComponent.district
        address += e.addressComponent.street
        address += e.addressComponent.streetNumber
        _this.form.address1=address
        console.log('当前定位地址为：' + this.form.address1)
        console.log('当前定位地址为：' + address)

      })
      geolocationControl.addEventListener('locationError', function(e) {
        // 定位失败事件
        console.log("定位失败:"+e.message)
      })
      map.addControl(geolocationControl)
      // 缩放事件(缩放完成后触发) 对应的有 zoomstart 拖拽前触发
      map.addEventListener('zoom', function() {
        console.log(map.getBounds())
        console.log(map.getBounds().getSouthWest())
      })
      // 拖拽事件(拖拽完成后触发) 对应的有 dragstart 拖拽前触发 dragging 拖拽中触发
      map.addEventListener('dragend', function() {
        console.log(map.getBounds())
        console.log(map.getBounds().getSouthWest())
      })
    },
    zoomend() {
    },
    cancel(){
      let _this=this
      _this.$router.push({
        path: '/main',
        name:'maim',
        params:{
          uname:_this.form.bphone,
          password:_this.form.bpassord,
          username:_this.form.sellername,
          identity:_this.form.bidentity
        }
      })
    }
  }
}
</script>

<style scoped>
html,body,.allmap{
  width: 100%;
  height: calc(88vh);
  overflow: hidden;
  margin: 0;
  font-family: "微软雅黑";
}
</style>





<!--<template>-->
<!--  <baidu-map class="map" >-->
<!--    <bm-geolocation anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :showAddressBar="true" :autoLocation="true"></bm-geolocation>-->
<!--  </baidu-map>-->
<!--</template>-->
<!--<style>-->
<!--.map {-->
<!--  width: 100%;-->
<!--  height: 400px;-->
<!--}-->
<!--</style>-->




