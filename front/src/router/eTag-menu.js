export const menu = [
    {
        name: '首页',
        path: 'home',
        icon: 'el-icon-s-home',
        component: () => import('@/views/HomeView')
    },
    {
        name: '模板管理',
        path: 'template',
        icon: 'el-icon-picture',
        component: () => import('@/views/templateView')
    },
    {
        name: '设备管理',
        path: 'deviceInfo',
        icon: 'el-icon-s-platform',
        component: () => import('@/views/deviceInfoView')
    }
]



