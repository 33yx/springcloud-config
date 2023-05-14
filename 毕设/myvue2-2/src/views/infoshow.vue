<template>
  <div id="background">
    <h1>个人信息页面
    </h1>


    <div class="form">
      <label>账号(手机号)：</label><input :readonly="by==0 ? false : 'readonly'" type="tel" v-model.trim="tel"><br/>
    </div>
    <div class="form">
      <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：</label><input :readonly="by==0 ? false : 'readonly'" type="password" v-model.trim="password"><br/>
    </div>
    <div class="form">
      <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱：</label><input :readonly="by==0 ? false : 'readonly'" type="email" v-model.trim="mail"><br/>
    </div>
    <div class="form">
      <label for="">性别：</label>
      <label for="">男</label>
      <input :readonly="by==0 ? false : 'readonly'" type="radio" v-model.trim="sex" value="男">
      <label for="">女</label>
      <input :readonly="by==0 ? false : 'readonly'" type="radio" v-model.trim="sex" value="女">
    </div>
    <div class="form">
      <label>真实姓名：</label><input :readonly="by==0 ? false : 'readonly'" type="text" v-model.trim="relname"><br/>
    </div>
    <div class="form">
      <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年龄：</label><input :readonly="by==0 ? false : 'readonly'" type="text" v-model.trim="age"><br/>
    </div>
    <div class="form">
      <label>&nbsp;&nbsp;&nbsp;身份证：</label><input :readonly="by==0 ? false : 'readonly'" type="text" v-model.trim="caidid"><br/>
    </div>
    <div class="form">
      <label>所在地：</label><input :readonly="by==0 ? false : 'readonly'" type="text" v-model.trim="adress"><br/>
    </div>
    <div>
      <input disabled="disabled" type="radio" v-model.trim="identity" value="1" >
      <label><span class="x-red">学生</span></label>
      <input disabled="disabled" type="radio" v-model.trim="identity"  value="2" >
      <label><span class="x-red">商家</span></label>
    </div>
    <div v-if="identity==1" class="form">
      <label>用户名：</label><input :readonly="by==0 ? false : 'readonly'" type="text" v-model.trim="username"><br/>
    </div>
    <div v-if="identity==1" class="form">
      <label>学校名称：</label><input :readonly="by==0 ? false : 'readonly'" type="text" v-model.trim="school"><br/>
    </div>
    <div v-if="identity==1" class="form">
      <label>学号：</label><input :readonly="by==0 ? false : 'readonly'" type="text" v-model.trim="stuid"><br/>
    </div>
    <div v-if="identity==2" class="form">
      <label>商铺名称：</label><input :readonly="by==0 ? false : 'readonly'" type="text" v-model.trim="ssname"><br/>
    </div>
    <div v-if="identity==2" class="form">
      <label>营业执照：</label><input :readonly="by==0 ? false : 'readonly'" type="text" v-model.trim="sbus"><br/>
    </div>

    <div>
      <el-button v-if="by==1" @click="changeVersion"  type="primary" icon="el-icon-edit">修改</el-button>

      <el-button v-if="by==0" @click="eidt"  type="primary" >确认</el-button>

      <el-button type="primary" @click="cancel" icon="el-icon-caret-left">还回</el-button>
    </div>

  </div>
</template>


<script>
import axios from "axios";

export default {
  name: "infoshow",
  props: {
    msg: String
  },
  data(){
    return{
      by:1,
      name:"",
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
      rphone:"",
      rpassord:"",


    };
  },
  created(){
    var count=0
    let _this=this

    if(sessionStorage.getItem("unt")==='1'){

    }else {

      sessionStorage.setItem("unt",count)
    }

    if (sessionStorage.getItem("unt")==='0') {

       _this.rphone=this.$route.params.phone,
       _this.rpassord=this.$route.params.password,
       _this.identity=this.$route.params.identity

      count=1
      sessionStorage.setItem("unt",count)

      sessionStorage.setItem('phone', _this.$route.params.phone); //初次收到userKey，存起来
      sessionStorage.setItem('rpassword',_this.$route.params.password);
      sessionStorage.setItem('ridentity',_this.$route.params.identity);


    }else {

      _this.rphone = sessionStorage.getItem('phone')
      _this.rpassord = sessionStorage.getItem('rpassword')
      _this.identity = sessionStorage.getItem('ridentity')

    }



    if (this.identity==1){
      axios.post(this.api.url+'/fore/usersearch?email='+this.rphone+"&password="+this.rpassord)
        .then(function (response) {
          _this.tel=response.data.user.phone
          _this.password=response.data.user.password
          _this.mail=response.data.user.uemail
          _this.school=response.data.user.schoollname
          _this.stuid=response.data.user.studentid
          _this.caidid=response.data.user.cardid
          _this.sex=response.data.user.usex
          _this.adress=response.data.user.address
          _this.relname=response.data.user.uname
          _this.username=response.data.user.usename

          _this.age=response.data.user.useage



        });
    }

    if(this.identity==2){
      axios.post(this.api.url+'/fore/sellersearch?email='+this.rphone+"&password="+this.rpassord)
        .then(function (response) {
           console.log("进入还回")
          _this.tel=response.data.sellerAndCard.sphone
          _this.password=response.data.sellerAndCard.spasswoed
          _this.mail=response.data.sellerAndCard.semail
          _this.caidid=response.data.sellerAndCard.carid
          _this.sex=response.data.sellerAndCard.ssex
          _this.adress=response.data.sellerAndCard.saddress
          _this.relname=response.data.sellerAndCard.cname
          _this.username=response.data.sellerAndCard.sname
          _this.age=response.data.sellerAndCard.cage
          _this.sbus=response.data.sellerAndCard.businesslicense
        });
    }

  },
  beforeDestroy () {
//毁灭前先移除掉，否则我跳转到其它地方，sessionStorage里面依旧存在着userKey
    sessionStorage.removeItem('unt')
    sessionStorage.removeItem('phone')
    sessionStorage.removeItem('ridentity')
    sessionStorage.removeItem('rpassword')
  },

  methods:{
    postData() {
      console.log(this.user);
    },

    changeVersion(){



      this.by=0;

    },
    eidt(){

      this.by=1;
    },
    //点击完成按钮触发handlefinish
    handlefinish:function()
    {
       if(this.tel==='')
      {
        alert("账号不能为空");
      }
      else if(this.password===''){
        alert("密码不能为空");
      }
      else if(this.mail===''){
        alert("邮箱不能为空");
      }
      else if(this.sex===''){
        alert("选择性别");
      }
      else if(this.relname===''){
        alert("填写真实姓名");
      }
      else if(this.age===''){
        alert("年龄为空");
      }
      else if(this.caidid===''){
        alert("身份证不能为空");
      }
      else if(this.identity===''){
        alert("请确定身份");
      }
      else if(this.adress===''){
        alert("地址不能为空");
      }
      else if(this.identity==1 && this.username===''){
        alert("用户名为空");
      }
      else if(this.identity==1 && this.school===''){
        alert("学校不能为空");
      }
      else if(this.identity==1 && this.stuid===''){
        alert("学号为空");
      }
      else if(this.identity==2 && this.ssname===''){
        alert("商铺名称为空");
      }
      else{//将新用户信息存储到localStorage
        this.axios({
          url:'/sys/addusera',
          method:'post',
          params:{"usename":this.username,"useage":this.age,"schoollname":this.school,
            "studentid":this.stuid,"cardid":this.caidid,"phone":this.tel,"password":this.password,"usex":this.sex}
        }).then(res => {
          console.log('数据接收');
          console.log(res.data.data);
        });


        localStorage.setItem('name',this.name);
        localStorage.setItem('password',this.password);
        localStorage.setItem('mail',this.mail);
        localStorage.setItem('tel',this.tel);
        localStorage.setItem('s',"false");
        this.$router.replace('/Login');//完成注册后跳转至登录页面
      }
    },

    cancel(){
      let _this=this
      _this.$router.push({
        path: '/main',
        name:'maim',
        params:{
          uname:_this.rphone,
          password:_this.rpassord,
          username:_this.username,
          identity:_this.identity
        }


      })
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
/*button{*/
/*  position: relative;*/
/*  height: 33px;*/
/*  width: 150px;*/
/*  background: rgba(35, 19, 252, 0.425);*/
/*  border-radius: 10px;*/
/*  margin-top: 38px;*/
/*  box-shadow: none;*/
/*  color: white;*/
/*  margin-left: 40px;*/
/*}*/
</style>
