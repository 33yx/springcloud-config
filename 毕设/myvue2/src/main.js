// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from "./router";//自动扫描里面的配置
import apiurl from "../public/js/apiurl";



import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'

import { Button } from 'vant';
import { Form } from 'vant';
import { Field } from 'vant';



Vue.use(Form);
Vue.use(Field);
// 方式一. 通过 Vue.use 注册
// 注册完成后，在模板中通过 <van-button> 或 <VanButton> 标签来使用按钮组件
Vue.use(Button);

// 方式二. 通过 Vue.component 注册
// 注册完成后，在模板中通过 <van-button> 标签来使用按钮组件
Vue.component(Button.name, Button);


Vue.use(router)
Vue.use(ElementUI);
Vue.prototype.api=apiurl

/* eslint-disable no-new */
new Vue({
  el: '#app',
  //配置路由
  router,
  render: h =>h(App)
})
