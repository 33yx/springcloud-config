<template>
  <div id="app" >
<!--   <h1>欢迎来到校园兼职</h1>-->

<!--   下面的方法相当于：<a href=""></a>-->
<!--    <router-link to="/main">首页</router-link>-->
<!--    <router-link to="/content">内容页</router-link>-->
<!--    <router-link to="/menghong">分页1</router-link>-->
<!--    <router-link to="/login">登陆</router-link>-->

    <router-view></router-view>

  </div>
</template>
<script>



export default {
  name: `App`

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
