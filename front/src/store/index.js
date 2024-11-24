import Vue from 'vue'
import Vuex from 'vuex'
import router from "@/router";
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        isSidebarNavCollapse: false,
        currentMenu: 'home',
        activeMenuList: [],
        token: null
    },
    getters: {
        getToken(state){
           return state.token
        }
    },
    mutations: {
        toggleNavCollapse(state) {
            state.isSidebarNavCollapse = !state.isSidebarNavCollapse
        },
        SET_CURRENT_MENU(state, currentMenu) {
            state.currentMenu = currentMenu
        },
        setToken(state, newToken){
            state.token = newToken
        },
        addMenu(state, menu) {
            let index = state.activeMenuList.findIndex(item => {
                return item.name === menu.name;
            });
            if (index === -1 && menu.path !== 'home') {
                state.activeMenuList.push({name: menu.name, path: menu.path})
            }
        },
        deleteMenu(state, menu){
            state.activeMenuList.splice(state.activeMenuList.indexOf(menu), 1);
            let path = 'home'
            if(state.activeMenuList.length === 0 ){
                state.currentMenu = 'home'
            } else{
                path = state.activeMenuList.at( state.activeMenuList.length - 1).path
                state.currentMenu = path
            }
            router.push(path);
        },
       
    },
    plugins: [createPersistedState({
           
        storage: window.sessionStorage, 
        key: 'vuex', // 存储在 localStorage 或 sessionStorage 中的键名
        // 如果你只想持久化部分状态，可以使用 `include` 或 `exclude`
        include: ['token'], // 只持久化指定的状态
        // exclude: ['otherState'], // 不持久化指定的状态
      })],
    actions: {},
    modules: {}
})
