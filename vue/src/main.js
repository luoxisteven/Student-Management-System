import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import router from './router'
import store from "./store"

import "./assets/global.css"
import 'element-ui/lib/theme-chalk/index.css';
import request from './utils/request';


Vue.use(ElementUI, {size: "mini"});
Vue.config.productionTip = false
Vue.prototype.request = request //配置axios, request.js

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

