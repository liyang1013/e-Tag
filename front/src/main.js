import Vue from 'vue'
import App from '@/App.vue'
import router from '@/router'
import store from '@/store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import '@/styles/index.scss'
import http from '@/http/httpConfig'
import * as globalFilter from '@/filters/filters'
import '@/styles/base.scss'

Vue.prototype.$http = http
Vue.config.productionTip = false
ElementUI.TableColumn.props.showOverflowTooltip ={type:Boolean, default: true}
Vue.use(ElementUI,{ size: 'mini'})

for (const key in globalFilter) {
  Vue.filter(key, globalFilter[key])
}

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
