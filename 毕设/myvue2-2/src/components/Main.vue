<template>
  <div>
  <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b">
    <el-menu-item index="1">兼职信息中心</el-menu-item>
    <el-submenu index="2">
      <template slot="title">我的工作台</template>
      <el-menu-item @click="toshowinfo"  index="2-1">个人信息</el-menu-item>
      <el-menu-item @click="torjoplist" v-if="identity==1" index="2-2">已接取兼职</el-menu-item>
      <el-menu-item @click="tomenghong" v-if="identity==2" index="2-3">发布兼职</el-menu-item>
      <el-menu-item @click="tosellerjoplist" v-if="identity==2" index="2-3">已发布的兼职</el-menu-item>
    </el-submenu>
<!--    <el-menu-item index="3" disabled>消息中心</el-menu-item>-->
<!--    <el-menu-item index="4"><a href="" target="_blank">订单管理</a></el-menu-item>-->
  </el-menu>

  <el-row class="tac">
    <el-col :span="4">
      <h5>用户名：{{username}}</h5>
      <el-menu
        default-active="2"
        class="el-menu-vertical-demo"


        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>导航一</span>
          </template>
<!--          <el-menu-item-group>-->
<!--            <template slot="title">分组一</template>-->
<!--            <el-menu-item index="1-1">选项1</el-menu-item>-->
<!--            <el-menu-item index="1-2">选项2</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-menu-item-group title="分组2">-->
<!--            <el-menu-item index="1-3">选项3</el-menu-item>-->
<!--          </el-menu-item-group>-->
          <el-submenu index="1-3">
            <template slot="title">地图</template>
            <el-menu-item @click="tobaiduditu" index="1-3-1">百度地图</el-menu-item>
          </el-submenu>
<!--          <el-submenu index="1-4">-->
<!--            <template slot="title">选项4</template>-->
<!--            <el-menu-item index="1-4-1">选项1</el-menu-item>-->
<!--          </el-submenu>-->
        </el-submenu>
        <el-menu-item index="2">
          <i class="el-icon-refresh-right"></i>
          <span slot="title" @click="reflash">刷新</span>
        </el-menu-item>
        <el-menu-item index="3">
          <i class="el-icon-service"></i>
          <span slot="title" @click="toResport">举报</span>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-error"></i>
          <span slot="title" @click="Loginout">退出</span>
        </el-menu-item>
      </el-menu>
    </el-col>
    <el-col :span="20">
      <div class="demo-input-size">
       <label>兼职ID: <input
          placeholder="请输入内容"
          suffix-icon="el-icon-date"
          v-model="input1"></label>
<!--        <label>商铺名称: <input-->
<!--          size="medium"-->
<!--          placeholder="请输入内容"-->
<!--          suffix-icon="el-icon-date"-->
<!--          v-model="input2"></label>-->
<!--        <label> <input-->
<!--          size="small"-->
<!--          placeholder="请输入内容"-->
<!--          suffix-icon="el-icon-date"-->
<!--          v-model="input3"></label>-->
        <label>地址： <input
          size="mini"
          placeholder="请输入内容"
          suffix-icon="el-icon-date"
          v-model="input3"
        ></label>
        <el-button type="primary" icon="el-icon-search" @click="search(input1,input3)">搜索</el-button>
      </div>
      <el-table
        :span="10"
        height="600"
        :data="visibleData"
        style="width: 100%"
        v-load-more.expand="{func: loadmore, target: '.el-table__body-wrapper', delay: 300}"
        :load-more-disabled="disabledLoad">
        <el-table-column
          prop="id"
          label="ID">
        </el-table-column>
        <el-table-column
          prop="adrress"
          label="地址">
        </el-table-column>
        <el-table-column
          prop="stype"
          label="类型">
        </el-table-column>
        <el-table-column
          prop="salary"
          label="酬劳">
        </el-table-column>
        <el-table-column
          prop="date"
          label="截止日期">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="详情"
          width="120">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent="gopost(scope.$index, tableData,scope.row)"
              type="text"
              size="small">
              去兼职
            </el-button>
          </template>
        </el-table-column>
<!--        <el-table-column-->
<!--          prop="xq"-->
<!--          label="详情">-->
<!--          <button prop="id" @click="topost" v-model.trim.tableData="id">去兼职</button>-->
<!--        </el-table-column>-->
        <!-- 底部文案 -->
        <div v-if="visibleData.length>=15" slot="append" style="margin-top:10px; margin-bottom:10px; text-align:center; font-size:15px ">{{content}}</div>

      </el-table>
    </el-col>


  </el-row>


</div>
</template>



<script type="text/javascript">
    import axios from "axios";

    export default {
      data() {
        return {
          username:"",
          uphone:"",
          password:"",
          identity:"",
          activeIndex: '1',
          activeIndex2: '1',
          visibleCount: 30,
          content: '滚动到底部加载更多',
          pageIndex: 1,
          pageSize: 10,
          tableData:[],
          jid:'',
          query: {
            info: '',
          },
          input1: '',
          input2: '',
          input3: '',
          // input4: ''
        };
      },
      created(){
        let _this = this

        var count=0

        if(sessionStorage.getItem("count")==='1'){

        }else {
          sessionStorage.setItem("count",count)
        }

        if (sessionStorage.getItem("count")==='0') {
          _this.username=_this.$route.params.username
          _this.uphone=_this.$route.params.uname
          _this.identity=_this.$route.params.identity
          _this.password=_this.$route.params.password

          count=1
          sessionStorage.setItem("count",count)
          sessionStorage.setItem('username', _this.$route.params.username) //初次收到userKey，存起来
          sessionStorage.setItem('uphone',_this.$route.params.uname);
          sessionStorage.setItem('identity',_this.$route.params.identity);
          sessionStorage.setItem('password',_this.$route.params.password);
        }else {
          _this.username = sessionStorage.getItem('username')
          _this.uphone = sessionStorage.getItem('uphone')
          _this.identity = sessionStorage.getItem('identity')
          _this.password = sessionStorage.getItem('password')
        }

        axios.get(this.api.url+'/fore/jop-list?username='+this.username,)
          .then(function (response) {
            console.log("进入")
            console.log(response)
            for (let i=0;i<response.data.jops.length;i++){
              _this.tableData.push({
                id: response.data.jops[i].jopid,
                stype:response.data.jops[i].joptype,
                salary:response.data.jops[i].salary,
                adrress:response.data.jops[i].address,
                date: response.data.jops[i].enddate,
              })
            }

          });
        // let count = 20
        // while(count >= 0) {
        //   count--
        //   this.tableData.push({
        //     id: count,
        //     adrress:"天下",
        //     date: "2016-05-02"
        //   })
        // }
      },
      computed: {
        // 是否禁止无限加载
        disabledLoad() {
          return false
        },
        visibleData() {
          return this.tableData.slice(0, Math.min(this.tableData.length, this.visibleCount))
        }
      },
      directives: {
        'load-more': {
          bind (el, binding, vnode) {
            const { expand } = binding.modifiers
            // 使用更丰富的功能，支持父组件的指令作用在指定的子组件上
            if (expand) {
              /**
               * target 目标DOM节点的类名
               * distance 减少触发加载的距离阈值，单位为px
               * func 触发的方法
               * delay 防抖时延，单位为ms
               * load-more-disabled 是否禁用无限加载
               */
              let { target, distance = 1, func, delay = 200 } = binding.value
              if (typeof target !== 'string') return
              let targetEl = el.querySelector(target)
              if (!targetEl) {
                console.log('Container Not Found')
                return
              }
              binding.handler = debounce(function () {
                const { scrollTop, scrollHeight, clientHeight } = targetEl
                let disabled = el.getAttribute('load-more-disabled')
                disabled = vnode[disabled] || disabled

                if (scrollHeight <= scrollTop + clientHeight + distance) {
                  if (disabled) return
                  func && func()
                }
              }, delay)
              targetEl.addEventListener('scroll', binding.handler)
            } else {
              binding.handler = helper.debounce(function () {
                const { scrollTop, scrollHeight, clientHeight }  = el
                if (scrollHeight === scrollTop + clientHeight) {
                  binding.value && binding.value()
                }
              }, 200)
              el.addEventListener('scroll', binding.handler)
            }
          },

          unbind (el, binding) {
            let { arg } = binding
            // 使用更丰富的功能，支持父组件的指令作用在指定的子组件上
            if (arg === 'expand') {
              /**
               * target 目标DOM节点的类名
               * offset 触发加载的距离阈值，单位为px
               * method 触发的方法
               * delay 防抖时延，单位为ms
               */
              const { target } = binding.value
              if (typeof target !== 'string') return
              let targetEl = el.querySelector(target)
              targetEl && targetEl.removeEventListener('scroll', binding.handler)
              targetEl = null
            } else {
              el.removeEventListener('scroll', binding.handler)
              el = null
            }
          }
        }
      },
      methods: {
        Loginout(){
          this.$router.replace({path: '/login'});
        },
        reflash(){
          console.log("刷新")
          location.reload();
        },
        toshowinfo(){
         let _this=this
          // this.$router.push({path: '/infoshow'});
          _this.$router.push({
            path: '/infoshow',
            name:'infoshow',
            params:{
              phone:_this.uphone,
              password:_this.password,
              identity:_this.identity
            }
          });
        },
        tomenghong(){//发布兼职
          let _this=this
          this.$router.push({
            path: '/menghong',
            name:'menghong',
            params:{
              sellername:_this.username,
              phone:_this.uphone,
              password:_this.password,
              identity:_this.identity
            }
          });
        },
        torjoplist(){
          console.log("去接单个人")
          let _this=this
          // this.$router.push({path: '/infoshow'});
          _this.$router.push({
            path: '/rjoplist',
            name:'rjoplist',
            params:{
              sellername:_this.username,
              phone:_this.uphone,
              password:_this.password,
              identity:_this.identity
            }
          });


        },

        tosellerjoplist(){
          let _this=this
          // this.$router.push({path: '/infoshow'});
          _this.$router.push({
            path: '/sellerjoplist',
            name:'sellerjoplist',
            params:{
              sellername:_this.username,
              phone:_this.uphone,
              password:_this.password,
              identity:_this.identity
            }
          });

        },

        toResport(){
          let _this=this

          _this.$router.push({
            path: '/report',
            name:'report',
            params:{
              sellername:_this.username,
              phone:_this.uphone,
              password:_this.password,
              identity:_this.identity
            }
          });
        },
        tobaiduditu(){
          let _this=this

          _this.$router.push({
            path: '/baidutu',
            name:'baidutu',
            params:{
              sellername:_this.username,
              phone:_this.uphone,
              password:_this.password,
              identity:_this.identity
            }
          });
        },

        gopost(index, rows,row) {
          let _this=this
          console.log(row);
          this.$router.push({
            path:'/post',
            name:'post',
            params:{
              jid:row.id,
              sellername:_this.username,
              phone:_this.uphone,
              password:_this.password,
              identity:_this.identity
            }

          });

          // rows.splice(index, 1);
        },

        search(input1,input3){
          let _this=this
          axios.get(this.api.url+'/fore/jopSearch-list?input1='+input1+"&input3="+input3,)
            .then(function (response) {
              _this.tableData=[]
              for (let i=0;i<response.data.jops.length;i++){
                _this.tableData.push({
                  id: response.data.jops[i].jopid,
                  stype:response.data.jops[i].joptype,
                  salary:response.data.jops[i].salary,
                  adrress:response.data.jops[i].address,
                  date: response.data.jops[i].enddate,
                })
              }
            });
          this.input1=''
          this.input3=''
        },



        async loadmore() {
          console.log('滚动到底部了')
          this.pageIndex++
          await this.scrollMethod(this.pageIndex, this.pageSize)
          this.visibleCount += 10
          if (this.visibleCount > this.tableData.length) {
            this.content = '暂无更多数据'
          }
        },
        //动态加载表数据方法
        async scrollMethod(pageIndex, pageSize){
          this.query.page = pageIndex
          this.query.size = pageSize
          let count = 1
          console.log('应该添加新数据啦');
          while(count <11) {
            count++
            this.tableData.push({
              id: pageIndex+count,
              adrress:"厦门",
              date: "2016-05-02"
            })
          }
          /**
           * 添加数据
           * /
           /*if(this.checkQuery()){
                        let result = await findPage(this.query)
                        if (result) {
                            this.dataList = result.list
                            //累加
                            if(this.dataList.length>0){
                                let i =0 ;
                                for(i;i< this.dataList.length ;i++){
                                    this.tableData.push(this.dataList[i])
                                }
                            }
                        }
                    }*/
        },
        //强制重新加载子组件
        /*  rebuileComponents() {
              // 销毁子标签
              this.hackReset = false;
              // 重新创建子标签
              this.$nextTick(() => {
                  this.hackReset = true;
              });
          },*/


        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        }
      },
      beforeDestroy () {
//毁灭前先移除掉，否则我跳转到其它地方，sessionStorage里面依旧存在着userKey
        sessionStorage.removeItem('count')
        sessionStorage.removeItem('username')
        sessionStorage.removeItem('uphone')
        sessionStorage.removeItem('identity')
        sessionStorage.removeItem('password')

      }
    }

    const debounce = function (func, delay) {
      let timer = null
      return function () {
        if (timer) clearTimeout(timer)
        timer = null
        let self = this
        let args = arguments
        timer = setTimeout(() => {
          func.apply(self, args)
        }, delay)
      }
    }
  </script>
