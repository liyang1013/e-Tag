export const menu = [
    {
        name: '首页',
        path: 'home',
        icon: 'el-icon-s-home',
        component: () => import('@/views/HomeView')
    },
    // {
    //     name: '标准模板',
    //     path: 'template',
    //     icon: 'el-icon-picture',
    //     component: () => import('@/views/TemplateView')
    // },
    {
        name: '设备列表',
        path: 'deviceInfo',
        icon: 'el-icon-s-platform',
        component: () => import('@/views/DeviceInfoView')
    }
]



