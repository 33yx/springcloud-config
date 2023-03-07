<template>
  <div id="background">
      <h1>注册界面</h1>
    <h6>请如实填写</h6>


        <div class="form">
          <label>账号(手机号)：</label><input type="tel" v-model.trim="tel"><br/>
        </div>
        <div class="form">
          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：</label><input type="password" v-model.trim="password"><br/>
        </div>
        <div class="form">
       <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱：</label><input type="email" v-model.trim="mail"><br/>
       </div>
       <div class="form">
          <label for="">性别：</label>
          <label for="">男</label>
          <input type="radio" v-model.trim="sex" value="boy">
          <label for="">女</label>
          <input type="radio" v-model.trim="sex" value="girl">
        </div>
       <div class="form">
      <label>真实姓名：</label><input type="text" v-model.trim="relname"><br/>
       </div>
    <div class="form">
      <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年龄：</label><input type="text" v-model.trim="age"><br/>
    </div>
    <div class="form">
      <label>&nbsp;&nbsp;&nbsp;身份证：</label><input type="text" v-model.trim="caidid"><br/>
    </div>
    <div class="form">
      <label>所在地：</label><input type="text" v-model.trim="adress"><br/>
    </div>
    <div>
      <input type="radio" v-model.trim="identity" value="1" >
      <label><span class="x-red">学生</span></label>
      <input type="radio" v-model.trim="identity"  value="2" >
      <label><span class="x-red">商家</span></label>
    </div>
    <div v-if="identity==1" class="form">
      <label>用户名：</label><input type="text" v-model.trim="username"><br/>
    </div>
    <div v-if="identity==1" class="form">
      <label>学校名称：</label><input type="text" v-model.trim="school"><br/>
    </div>
    <div v-if="identity==1" class="form">
      <label>学号：</label><input type="text" v-model.trim="stuid"><br/>
    </div>
    <div v-if="identity==2" class="form">
      <label>商铺名称：</label><input type="text" v-model.trim="ssname"><br/>
    </div>
    <div v-if="identity==2" class="form">
      <label>营业执照：</label><input type="text" v-model.trim="sbus"><br/>
    </div>


<!--    <div>-->
<!--      <button @click="getCode" id="d" class="getphone" v-show="show">获取验证码</button>-->
<!--      <button class="blue" v-show="!show" disabled="disabled">{-->
<!--        {count}}秒后重新发送</button>-->
<!--    </div>-->
    <div>
      <label>验证码：</label><input type="text" v-model.trim="Emsg">
      <button v-if="!sendMsgDisabled" @click.prevent="huoqu">获取验证码</button>
      <button v-if="sendMsgDisabled">{{ time+'秒后获取' }}</button>
    </div>
<!--    <div  class="form">-->

<!--      <label>验证码：</label><input type="text" v-model.trim="Emsg">-->
<!--      <button  class="getphone" @click.prevent="huoqu">获取验证码</button> <br/>-->
<!--    </div>-->

    <div>
      <button @click.prevent="handlefinish">提交</button>
      <button @click.prevent="qiu">取消</button>
    </div>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "logon",
  props: {
    msg: String
  },
  data(){

    return{
      time: 60, // 发送验证码倒计时
      sendMsgDisabled: false,
      name:"",
      Emsg:'',
      password:"",
      mail:"",
      tel:"",
      sex:"",
      relname:"",
      age:"",
      caidid:"",
      identity:"",
      adress:"",
      username:"",
      school:"",
      stuid:"",
      ssname:"",
      sbus:"",
      msgd:"",
      code:""

    };
  },methods:{
    open3() {
      this.$message({
        showClose: true,
        message: this.msgd,
        type: 'success'
      });
    },
    postData() {
      console.log(this.user);
    },

    //点击完成按钮触发handlefinish
    handlefinish:function() {
      if(this.tel==='')
      {
        alert("账号不能为空");
      }
    //   else if(this.password===''){
    //     alert("密码不能为空");
    //   }
    //   else if(this.mail===''){
    //     alert("邮箱不能为空");
    //   }
    //   else if(this.sex===''){
    //     alert("选择性别");
    //   }
    //   else if(this.relname===''){
    //     alert("填写真实姓名");
    //   }
    //   else if(this.age===''){
    //     alert("年龄为空");
    //   }
    // else if(this.caidid===''&& this.caidid.length==18){
    //   alert("身份证填写有误");
    // }
    // else if(this.identity===''){
    //   alert("请确定身份");
    // }
    // else if(this.adress===''){
    //   alert("地址不能为空");
    // }
    // else if(this.identity==1 && this.username===''){
    //   alert("用户名为空");
    // }
    // else if(this.identity==1 && this.school===''){
    //   alert("学校不能为空");
    // }
    // else if(this.identity==1 && this.stuid===''){
    //   alert("学号为空");
    // }
    //   else if(this.identity==2 && this.ssname===''){
    //     alert("商铺名称为空");
    //   }
      else{//将新用户信息存储到localStorage
          console.log(typeof this.age)
         var catin=0;
          let _this=this
        if (this.identity==1){
          if (this.code==this.Emsg){
            axios.post(this.api.url+'/fore/addusera'+
              '?usename='+this.username+"&useage="+this.age+"&schoollname="+this.school+"&address="+this.adress+"&uemail="+this.mail+"&uname="+this.relname
              +"&studentid="+this.stuid+"&cardid="+this.caidid+"&phone="+this.tel+"&password="+this.password+"&usex="+this.sex+"&code="+this.Emsg,
            ).then(function (response)  {
              if(response.data.rid==1){
                console.log('数据接收');
                alert("注册成功，快去登陆吧");
                _this.$router.replace('/Login');//完成注册后跳转至登录页面
              }else {
                alert(response.data.msg)
              }
            });
          }else {
            alert("请填写正确的验证码")
          }

        }

        if (this.identity==2){

        }

      }
    },

    huoqu:function (){
      let _this=this
      //3224915249@qq.com
      const that = this
      that.sendMsgDisabled = true
      const interval = window.setInterval(function() {
        if ((that.time--) <= 0) {
          that.time = 60
          that.sendMsgDisabled = false
          window.clearInterval(interval)
        }
      }, 1000)

      axios.post(this.api.url+'/fore/sendMsg?email='+this.mail+"&uphone="+this.tel
      ).then(function (response)  {
        _this.code=response.data.code
        console.log("验证码为"+_this.code)
        _this.msgd = response.data.msg+"，请输入"
        _this.open3()
      });
    },
    // count(){
    //   const that = this
    //   that.sendMsgDisabled = true
    //   const interval = window.setInterval(function() {
    //     if ((that.time--) <= 0) {
    //       that.time = 60
    //       that.sendMsgDisabled = false
    //       window.clearInterval(interval)
    //     }
    //   }, 1000)
    // },


    qiu:function (){
      this.$router.replace('/Login');
    }

  }
};
</script>

<style scoped>



#background{
  width: 100%;
  height: 100%;
  background: url(https://img-blog.csdnimg.cn/3b98a2b657bf4ed8a066229f2b58ef0a.jpg);
  background-size:100% 100%;
  position: fixed;
  top: 0;
  left: 0;
}
#contain{
  width: 580px;
  height: 560px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  background:#00000090;
  text-align: center;
  border-radius: 20px;
}
#contain h1{
  color: white;
}


.getphone {
  display: block;
  height: 46px;
  font-size: 22px;
  color: #aaaaaa;
  border: 1px solid #e6e6e6;
  text-align: center;
  border-radius: 23px;
  background: white;
  box-sizing: border-box;
  padding:0 20px;
  line-height: 46px;
}
.blue {
  color: #508bef;
  display: block;
  height: 46px;
  line-height: 46px;
  font-size: 22px;
  text-align: center;
  border: 1px solid #e6e6e6;
  border-radius: 23px;
  box-sizing: border-box;
  padding:0 20px;
}

/*.form{*/
/*  color: white;*/
/*  margin-left: 20%;*/
/*  margin-top: 60px;*/
/*  font-size: 20px;*/
/*  text-align: left;*/
/*}*/
/*label{*/
/*  float:left;*/
/*  width: 5em;*/
/*  margin-right: 1em;*/
/*  text-align: right;*/
/*}*/
/*input,textarea{*/
/*  margin-left: 10px;*/
/*  padding: 4px;*/
/*  border: solid 1px #4e5ef3;*/
/*  outline: 0;*/
/*  font: normal 13px/100% Verdana,Tahoma,sans-serif;*/
/*  width: 200px;*/
/*  height: 20px;*/
/*  background:#f1f1f190;*/
/*  box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;*/
/*}*/
/*input:hover,textarea:hover,input:focus,textarea:focus{border-color:#0d0aa1;}*/
button{
  position: relative;
  height: 33px;
  width: 150px;
  background: rgba(35, 19, 252, 0.425);
  border-radius: 10px;
  margin-top: 38px;
  box-shadow: none;
  color: white;
  margin-left: 40px;
}
</style>





