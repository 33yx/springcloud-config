<template>
  <div id="background">
    <h1>举报页面</h1>
    <form @submit.prevent="submitReport">
      <div tyle="margin-bottom:30px margin-top:40px;">
        <label for="reporter-name">订单编号：</label>
        <input type="text" id="reporter-name" v-model="orderId" required>
      </div>
<!--      <div>-->
<!--        <label for="reporter-name">  </label>-->
<!--      </div>-->
<!--      <div>-->
<!--        <label for="reporter-email">   举报人邮箱：</label>-->
<!--        <input type="email" id="reporter-email" v-model="reporterEmail" required>-->
<!--      </div>-->
<!--      <div>-->
<!--        <label for="report-type">举报类型：</label>-->
<!--        <select id="report-type" v-model="reportType" required>-->
<!--          <option value="">请选择举报类型</option>-->
<!--          <option value="spam">垃圾信息</option>-->
<!--          <option value="hate-speech">仇恨言论</option>-->
<!--          <option value="harassment">骚扰</option>-->
<!--        </select>-->
<!--      </div>-->
      <div style="margin-top:10px;">
        <label for="report-description">举报描述：</label>
        <textarea id="report-description" v-model="reportDescription" required></textarea>
      </div>

      <el-button style=" margin-top:40px;" type="primary submit" @click="submitReport">提交举报</el-button>
      <el-button style="margin-top:40px;" type="primary" @click="cancel">取消</el-button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "report",
  data() {
    return {
      orderId: '',
      reportDescription: '',
      form:{
        sellername:'',
        bphone:'',
        bpassord:'',
        bidentity:''
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


  },
  beforeDestroy () {
//毁灭前先移除掉，否则我跳转到其它地方，sessionStorage里面依旧存在着userKey
    sessionStorage.removeItem('but')
    sessionStorage.removeItem('bphone')
    sessionStorage.removeItem('bidentity')
    sessionStorage.removeItem('bpassword')
  },
  methods: {


    submitReport() {
      let _this=this
      axios.post(
        this.api.url+'/fore/addReport?reporterName='+this.form.bphone+"&reportOrdersId="+this.orderId+"&reason="+this.reportDescription+"&jobdescription="
      ).then(function (response) {
        alert(response.data.msg)
          //
        });
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

      // // 提交成功后清空表单
      // this.orderId = ''
      // this.reportDescription = ''
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
#background{
  width: 100%;
  height: 100%;
  background: url(https://img-blog.csdnimg.cn/d3193e11a340429d9c5ee40396c6a146.jpg);
  background-size:100% 100%;
  position: fixed;
  top: 0;
  left: 0;
}
</style>
