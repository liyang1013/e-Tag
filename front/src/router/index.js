import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '@/store'

Vue.use(VueRouter)

//重复点击报错
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch((err) => err)
}

const routes = [
    {
        path: '/',
        name: 'eTag',
        component: () => import('@/views/ETagIndex')
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('@/views/LoginView')
    },
    {
        path: '*',
        name: '404',
        component: () => import('@/views/exception/404')
    },
    {
        path: '/403',
        name: '403',
        component: () => import('@/views/exception/403')
    },
    {
        path: '/500',
        name: '500',
        component: () => import('@/views/exception/500')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

/**
 * 路由守护
 */
router.beforeEach((to, from, next) => {
    if(to.name !== 'login' && store.state.token === null){
        next('/login')
    }else
        next();
})

export default router
