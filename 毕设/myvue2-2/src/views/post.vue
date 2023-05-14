<template>
  <div>
    <h1>内容详情</h1>
    <el-form ref="form" :model="form" label-width="100px" el-input="160px">

      <el-form-item label="兼职类型">
        <el-col :span="5">
        <el-input v-model="form.stype"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="发布商铺名">
        <el-col :span="8">
        <el-input v-model="form.sellername"></el-input>
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
      <el-form-item label="酬劳">
        <el-col :span="3">
        <el-input v-model="form.money"></el-input>
        </el-col>
      </el-form-item>

      <el-form-item label="联系电话">
        <el-col :span="11">
          <el-input v-model="form.sphone"></el-input>
        </el-col>
      </el-form-item>

      <el-form-item label="兼职截止时间">
        <el-col :span="11">
          <el-input v-model="form.date1"></el-input>
<!--          <el-date-picker :readonly="readonly" type="date"  v-model="form.date1" style="width: 100%;"></el-date-picker>-->
        </el-col>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">接取</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "post",
  data() {
    return {
      form: {
        jid:'',
        name: '',
        stype:'',
        sellername:'',
        selleradress:'',
        nnumber:'',
        money:'',
        bphone:'',
        sphone:'',

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

    if(sessionStorage.getItem("pbut")==='1'){

    }else {

      sessionStorage.setItem("pbut",count)
    }


    if (sessionStorage.getItem("pbut")==='0') {
      _this.form.jid=this.$route.params.jid,
      _this.form.sellername=this.$route.params.sellername
      _this.form.bphone=this.$route.params.phone,
      _this.form.bpassord=this.$route.params.password,
      _this.form.bidentity=this.$route.params.identity

      count=1
      sessionStorage.setItem("pbut",count)
      sessionStorage.setItem("pjid",this.$route.params.jid)
      sessionStorage.setItem('pname',_this.$route.params.sellername);
      sessionStorage.setItem('pphone', _this.$route.params.phone); //初次收到userKey，存起来
      sessionStorage.setItem('ppassword',_this.$route.params.password);
      sessionStorage.setItem('pbidentity',_this.$route.params.identity);


    }else {
      console.log("第二次")
      _this.form.jid=sessionStorage.getItem("pjid")
      _this.form.sellername = sessionStorage.getItem('pname')
      _this.form.bphone = sessionStorage.getItem('pphone')
      _this.form.bpassord = sessionStorage.getItem('ppassword')
      _this.form.bidentity = sessionStorage.getItem('pbidentity')

    }




    if (_this.form.jid !=null) {
      axios.post(this.api.url+'/fore/searchjop?jid='+_this.form.jid)
        .then(function (response) {

          if (response.data.id===1){
            _this.form.stype=response.data.jop.joptype
            _this.form.sphone=response.data.jop.sellerid
            _this.form.date1=response.data.jop.enddate
            _this.form.desc=response.data.jop.jobdescription
            _this.form.nnumber=response.data.jop.number
            _this.form.money=response.data.jop.salary
            _this.form.selleradress=response.data.jop.address

          }else {
            alert(response.data.msg)

          }




          // _this.tel=response.data.user.phone
          // _this.password=response.data.user.password
          // _this.mail=response.data.user.uemail
          // _this.school=response.data.user.schoollname
          // _this.stuid=response.data.user.studentid
          // _this.caidid=response.data.user.cardid
          // _this.sex=response.data.user.usex
          // _this.adress=response.data.user.address
          // _this.relname=response.data.user.uname
          // _this.username=response.data.user.usename
          // _this.age=response.data.user.useage
        });
    }




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
    sessionStorage.removeItem('pbut')
    sessionStorage.removeItem("pjid")
    sessionStorage.removeItem('pphone')
    sessionStorage.removeItem('pbidentity')
    sessionStorage.removeItem('ppassword')
    sessionStorage.removeItem('pname')
  },
  methods: {


    onSubmit() {
      let _this=this
      console.log(_this.form.bphone)
      if (_this.form.bphone==null || _this.form.bphone=='' ){
        alert("请先登录哦")
      }else {
        axios.post(
          this.api.url+'/fore/Receivjop?jid='+this.form.jid+"&uphone="+this.form.bphone+"&enddate="+this.form.date1

        )
          .then(function (response) {
            alert(response.data.msg)

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



          });
      }


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

</style>
