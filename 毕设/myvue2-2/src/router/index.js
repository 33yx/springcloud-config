import Vue from "vue";

import VueRouter from "vue-router";

import Content from "../components/Content";
import Main from "../components/Main";
import menghong from "../components/menghong";
import Login from "../views/Login";
import Logon from "../views/logon";
import infoshow from "../views/infoshow";
import post from "../views/post";
import rjoplist from "../views/rjoplist";
import sellerjoplist from "../views/sellerjoplist";
import report from "../views/report";
// import ceshi from "../views/ceshi";

// import Main1 from "../views/Main1";
import baidutu from "../views/baidutu";
//安装路由
Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
    //路由路径
    path: '/content',
    name: 'content',
    //跳转的组件
    component: Content
  },
    {
      //路由路径
      path: '/main',
      name: 'maim',
      //跳转的组件
      component: Main
    },
    {
    //路由路径
    path: '/menghong',
    name: 'menghong',
     //跳转的组件
    component: menghong
     }
   ,{
    path:'/login',
      name:'login',
     component:Login
    },
    {path:'/logon',
      name:'logon',
      component:Logon
    },{
    path:'/infoshow',
      name:'infoshow',
      component:infoshow
    },{
      path:'/',
      name:'login',
      component:Login
    },{
    path:'/post',
      name:'post',
      component:post
    },{
    path:'/rjoplist',
      name:'rjoplist',
      component:rjoplist
    },{
    path:'/sellerjoplist',
      name:'sellerjoplist',
      component:sellerjoplist
    },
    {path:'/report',
     name:'report',
     component:report
     },
    {path:'/baidutu',
      name:'baidutu',
      component:baidutu
    }

    ]

});
