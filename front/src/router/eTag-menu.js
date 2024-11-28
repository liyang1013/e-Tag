export const menu = [
    {
        path: 'home',
        component: () => import('@/views/HomeView')
    },
    {
        path: 'device',
        component: () => import('@/views/DeviceView')
    },
    {
        path: 'user',
        component: () => import('@/views/UserView')
    },
    {
        path: 'template',
        component: () => import('@/views/TemplateView')
    },
    {
        path: 'info',
        component: () => import('@/views/InfoView')
    }
]



