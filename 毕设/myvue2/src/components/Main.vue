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
      <el-menu-item  index="2-1">个人信息</el-menu-item>
      <el-menu-item index="2-2">已接取兼职</el-menu-item>
      <el-menu-item index="2-3">发布兼职</el-menu-item>
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
            <template slot="title">选项3</template>
            <el-menu-item index="1-3-1">选项1</el-menu-item>
          </el-submenu>
          <el-submenu index="1-4">
            <template slot="title">选项4</template>
            <el-menu-item index="1-4-1">选项1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="2">
          <i class="el-icon-refresh-right"></i>
          <span slot="title">刷新</span>
        </el-menu-item>
        <el-menu-item index="3">
          <i class="el-icon-service"></i>
          <span slot="title">举报</span>
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
        <label>商铺名称: <input
          size="medium"
          placeholder="请输入内容"
          suffix-icon="el-icon-date"
          v-model="input2"></label>
<!--        <label> <input-->
<!--          size="small"-->
<!--          placeholder="请输入内容"-->
<!--          suffix-icon="el-icon-date"-->
<!--          v-model="input3"></label>-->
<!--        <label> <input-->
<!--          size="mini"-->
<!--          placeholder="请输入内容"-->
<!--          suffix-icon="el-icon-date"-->
<!--          v-model="input4"></label>-->
        <el-button type="primary" icon="el-icon-search">搜索</el-button>
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
          prop="xq"
          label="详情">
          <button>去兼职</button>
        </el-table-column>
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
          username:"1",
          uphone:"",
          activeIndex: '1',
          activeIndex2: '1',
          visibleCount: 30,
          content: '滚动到底部加载更多',
          pageIndex: 1,
          pageSize: 10,
          tableData:[],
          query: {
            info: '',
          },
          input1: '',
          input2: '',
          // input3: '',
          // input4: ''
        };
      },
      created(){
        let _this = this

        axios.get('http://localhost:8081/fore/order-list?username='+this.username,)
          .then(function (response) {

              console.log("进入这里：")
            for (let i=0;i<response.data.jops.length;i++){
              _this.tableData.push({
                id: response.data.jops[i].jopid,
                stype:response.data.jops[i].joptype,
                salary:response.data.jops[i].salary,
                adrress:response.data.jops[i].address,
                date: response.data.jops[i].enddate
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
