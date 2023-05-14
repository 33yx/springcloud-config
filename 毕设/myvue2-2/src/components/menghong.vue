<template>
  <div>
    <h1>兼职活动发布</h1>
    <el-form ref="form" :model="form" label-width="100px" el-input="160px">

      <el-form-item label="兼职类型">
        <el-col :span="5">
          <el-input v-model="form.stype"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="发布商铺名">
        <el-col :span="8">
          <el-input v-model="form.sellername">{{form.sellername}}</el-input>
        </el-col>
      </el-form-item>


      <el-form-item label="工作介绍">
        <el-col :span="12">
          <el-input type="textarea" :rows="6" v-model="form.desc"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="工作地址">
        <el-col :span="8">
          <el-input v-model="form.selleradress"></el-input>
        </el-col>
      </el-form-item>

      <el-form-item label="需要人数">
        <el-col :span="2">
          <el-input v-model="form.nnumber"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="酬劳(元/小时)">
        <el-col :span="3">
          <el-input v-model="form.money"></el-input>
        </el-col>
      </el-form-item>

      <el-form-item label="兼职截止时间">
        <el-col :span="11">
          <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
        </el-col>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "menghong",
  data() {
    return {
      form: {
        name: '',
        stype:'',
        sellername:'',
        selleradress:'',
        nnumber:'',
        money:'',
        bphone:'',
        bpassord:'',
        identity:'',

        region: '',
        dates:'',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      }
    }
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




    // if (this.identity==1){
    //   axios.post(this.api.url+'/fore/usersearch?email='+this.rphone+"&password="+this.rpassord)
    //     .then(function (response) {
    //       _this.tel=response.data.user.phone
    //       _this.password=response.data.user.password
    //       _this.mail=response.data.user.uemail
    //       _this.school=response.data.user.schoollname
    //       _this.stuid=response.data.user.studentid
    //       _this.caidid=response.data.user.cardid
    //       _this.sex=response.data.user.usex
    //       _this.adress=response.data.user.address
    //       _this.relname=response.data.user.uname
    //       _this.username=response.data.user.usename
    //
    //       _this.age=response.data.user.useage
    //
    //
    //
    //     });
    // }
    //
    // if(this.identity==2){
    //   axios.post(this.api.url+'/fore/sellersearch?email='+this.rphone+"&password="+this.rpassord)
    //     .then(function (response) {
    //       console.log("进入还回")
    //       _this.tel=response.data.sellerAndCard.sphone
    //       _this.password=response.data.sellerAndCard.spasswoed
    //       _this.mail=response.data.sellerAndCard.semail
    //       _this.caidid=response.data.sellerAndCard.carid
    //       _this.sex=response.data.sellerAndCard.ssex
    //       _this.adress=response.data.sellerAndCard.saddress
    //       _this.relname=response.data.sellerAndCard.cname
    //       _this.username=response.data.sellerAndCard.sname
    //       _this.age=response.data.sellerAndCard.cage
    //       _this.sbus=response.data.sellerAndCard.businesslicense
    //     });
    // }




  },
  beforeDestroy () {
//毁灭前先移除掉，否则我跳转到其它地方，sessionStorage里面依旧存在着userKey
    sessionStorage.removeItem('but')
    sessionStorage.removeItem('bphone')
    sessionStorage.removeItem('bidentity')
    sessionStorage.removeItem('bpassword')
  },
  methods: {
    onSubmit() {
      console.log("类型为："+this.form.stype+this.form.bphone+this.form.date1)
      console.log("转化为："+parseTime(this.form.date1))
      this.form.dates=parseTime(this.form.date1)
      let _this=this

      axios.post(
        this.api.url+'/fore/addjop?joptype='+this.form.stype+"&sellerid="+this.form.bphone+"&enddate="+this.form.dates+"&jobdescription="+this.form.desc+"&number="+this.form.nnumber+"&salary="+this.form.money+"&address="+this.form.selleradress

      )
        .then(function (response) {
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

          console.log("值为："+response.data.rid)
        });


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



function parseTime(time, cFormat) {
  if (arguments.length === 0) {
    return null
  }
  const format = cFormat || '{y}-{m}-{d} {h}:{i}:{s}'
  let date
  if (typeof time === 'object') {
    date = time
  } else {
    if (('' + time).length === 10) time = parseInt(time) * 1000
    date = new Date(time)
  }
  const formatObj = {
    y: date.getFullYear(),
    m: date.getMonth() + 1,
    d: date.getDate(),
    h: date.getHours(),
    i: date.getMinutes(),
    s: date.getSeconds(),
    a: date.getDay()
  }
  // eslint-disable-next-line
  const time_str = format.replace(/{(y|m|d|h|i|s|a)+}/g, (result, key) => {
    let value = formatObj[key]
    if (key === 'a') return ['一', '二', '三', '四', '五', '六', '日'][value - 1]
    if (result.length > 0 && value < 10) {
      value = '0' + value
    }
    return value || 0
  })
  // eslint-disable-next-line
  return time_str
}
</script>

