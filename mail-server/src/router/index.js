import { createRouter, createWebHistory } from 'vue-router'
import Signup from '../views/Sign-up.vue'
import Signin from '../views/Sign-in.vue'
import Inbox from '../views/Inbox.vue'
import Sent from '../views/Sent.vue'
import Draft from '../views/Draft.vue'
import Trash from '../views/Trash.vue'
import Contacts from '../views/Contacts.vue'


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
  {
    path:'/Inbox',
    name:'Inbox',
    component:Inbox
  },
  {
    path:'/Sent',
    name:'Sent',
    component:Sent
  },
  {
    path:'/Draft',
    name:'Draft',
    component:Draft
  },
  {
    path:'/Trash',
    name:'Trash',
    component:Trash
  },
  {
    path:'/Contacts',
    name:'Contacts',
    component:Contacts
  }
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
