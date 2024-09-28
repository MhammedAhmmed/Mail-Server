import { createRouter, createWebHistory } from 'vue-router'
import Signup from '../views/Sign-up.vue'
import Signin from '../views/Sign-in.vue'

const routes = [
  {
    path: '/',
    name: 'sign-up',
    component: Signup
  },
  {
    path:'/sign-in',
    name:'sign-in',
    component:Signin
  },
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
