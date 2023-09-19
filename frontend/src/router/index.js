import { createRouter, createWebHashHistory } from 'vue-router'
import loginForm from '@/components/LoginForm.vue'
import registrationForm from '@/components/RegistrationForm.vue'
import hello from '@/components/Hello.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    component: loginForm
  },
  {
    path: '/registration',
    name: 'registration',
    component: registrationForm
  },
  {
    path: '/hello',
    name: 'hello',
    component: hello
  },
  
]

const router = createRouter({  
  history: createWebHashHistory(),
  routes
})

export default router
