import Vue from 'vue'
import VueRouter from 'vue-router'
//引入LoginView组件
import LoginView from '@/views/LoginView.vue'

import HomeView  from '@/views/HomeView.vue'
import StudentsView  from '@/views/StudentsView.vue'
import classView  from '@/views/classView.vue'
import departmentView  from '@/views/departmentView.vue'
import userView  from '@/views/userView.vue'
import instructorView  from '@/views/instructorView.vue'
import instructortaskView  from '@/views/instructortaskView.vue'
import leaveView  from '@/views/leaveView.vue'
import auditleaveView  from '@/views/auditleaveView.vue'
import statisticsleaveView  from '@/views/statisticsleaveView.vue'
import daoleaveView  from '@/views/daoleaveView.vue'
import roleView from '@/views/roleView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect:'/login'
  },
  {
    path:'/login',
    component:LoginView
  },
  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/class',
       component:classView
        
    }]
  },
  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/students',
       component:StudentsView
    }]
  },
  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/department',
       component:departmentView
    }]
  },
  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/user',
       component:userView
    }]
  },
  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/instructor',
       component:instructorView
    }]
  },
  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/instructortask',
       component:instructortaskView
    }]
  },
  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/leave',
       component:leaveView
    }]
  },
  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/auditleave',
       component:auditleaveView
    }]
  },
  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/statistics',
       component:statisticsleaveView
    }]
  },
  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/daoleave',
       component:daoleaveView
    }]
  },

  {
    path:'/home',
    component:HomeView,
    children:[{
       path:'/role',
       component:roleView
    }]
  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
