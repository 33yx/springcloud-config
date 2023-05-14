<template>
  <div>
    <h1>已经发布的兼职</h1>
    <el-form>
      <el-table
        :data="tableData"
        height="250"
        border
        style="width: 100%">
        <el-table-column
          prop="date"
          label="发布日期"
          width="180">
        </el-table-column>
        <el-table-column
          prop="jid"
          label="兼职id"
          width="180">
        </el-table-column>
        <el-table-column
          prop="address"
          label="地址"
          width="180">
        </el-table-column>
        <el-table-column
          prop="reuslt"
          label="审核结果">
        </el-table-column>
        <el-table-column
          prop="statu"
          label="状态">
        </el-table-column>
      </el-table>

      <el-form-item>
        <el-button type="primary" @click="cancel">还回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "sellerjoplist",
  data() {
    return {
      tableData: [],
      userphone:'',
      rpassord:'',
      identity:'',
      jid:'',
      statu:'',
      date:'',
      rphone:'',
      address:''

    }
  },
  created(){
    var count=0
    let _this=this
    if(sessionStorage.getItem("unt")==='1'){

    }else {
      sessionStorage.setItem("unt",count)
    }

    if (sessionStorage.getItem("unt")==='0') {
      _this.sellername=this.$route.params.sellername
      _this.rphone=this.$route.params.phone,
        _this.rpassord=this.$route.params.password,
        _this.identity=this.$route.params.identity

      count=1
      sessionStorage.setItem("unt",count)
      sessionStorage.setItem('pname',_this.$route.params.sellername);
      sessionStorage.setItem('phone', _this.$route.params.phone); //初次收到userKey，存起来
      sessionStorage.setItem('rpassword',_this.$route.params.password);
      sessionStorage.setItem('ridentity',_this.$route.params.identity);


    }else {
      _this.sellername = sessionStorage.getItem('pname')
      _this.rphone = sessionStorage.getItem('phone')
      _this.rpassord = sessionStorage.getItem('rpassword')
      _this.identity = sessionStorage.getItem('ridentity')

    }


    if(_this.rphone !=null){
      axios.post(this.api.url+'/fore/toOldjop?uphone='+_this.rphone)
        .then(function (response) {

          if (response.data.id===1){
            for (let i=0;i<response.data.jops.length;i++){
              if (response.data.jops[i].examine==1){//通过
                if (response.data.jops[i].valid==1){
                  _this.tableData.push({
                    jid: response.data.jops[i].jopid,
                    date: response.data.jops[i].pubdate,
                    address:response.data.jops[i].address,
                    reuslt:"通过",
                    statu:"生效中"
                  })
                }else {
                  _this.tableData.push({
                    jid: response.data.jops[i].jopid,
                    date: response.data.jops[i].pubdate,
                    address:response.data.jops[i].address,
                    reuslt:"通过",
                    statu:"已失效"
                  })
                }


              }else if (response.data.jops[i].examine==2) {//不通过
                _this.tableData.push({
                  jid: response.data.jops[i].jopid,
                  date: response.data.jops[i].pubdate,
                  address:response.data.jops[i].address,
                  reuslt:"不通过",
                  statu:"已失效"
                })

              }else {//未审核
                _this.tableData.push({
                  jid: response.data.jops[i].jopid,
                  date: response.data.jops[i].pubdate,
                  address:response.data.jops[i].address,
                  reuslt:"未审核",
                  statu:"未生效"
                })
              }
            }


          }else {
            alert(response.data.msg)

          }

        });


    }else {
      alert("用户错误")
    }



  },
  beforeDestroy () {
//毁灭前先移除掉，否则我跳转到其它地方，sessionStorage里面依旧存在着userKey
    sessionStorage.removeItem('unt')
    sessionStorage.removeItem('phone')
    sessionStorage.removeItem('ridentity')
    sessionStorage.removeItem('rpassword')
    sessionStorage.removeItem('pname')
  },
  methods: {
    tableRowClassName({row, rowIndex}) {
      if (rowIndex === 1) {
        return 'warning-row';
      } else if (rowIndex === 3) {
        return 'success-row';
      }
      return '';
    },


    cancel(){
      let _this=this
      _this.$router.push({
        path: '/main',
        name:'maim',
        params:{
          uname:_this.rphone,
          password:_this.rpassord,
          username:_this.sellername,
          identity:_this.identity
        }


      })
    }
  },
}
</script>

<style scoped>

</style>
