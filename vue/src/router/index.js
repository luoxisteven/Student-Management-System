import Vue from 'vue'
import VueRouter from 'vue-router'
// import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import Manage from '@/views/Manage.vue'
import store from '@/store'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Manage,
    redirect: "/home",
    children :[
      {
        path: 'home',
        name: '首页',
        component: () => import('../views/Home.vue')
      },
      {
        path: 'user',
        name: '用户管理',
        component: () => import('../views/User.vue')
      }
    ]
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 路由守卫
router.beforeEach((to,from,next)=>{
  localStorage.setItem("currentPathName", to.name) //设置当前路由名称
  store.commit("setPath") //触发store数据更新
  next() //放行
})

export default router
