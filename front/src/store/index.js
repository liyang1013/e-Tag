import Vue from 'vue'
import Vuex from 'vuex'
import router from "@/router";

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        isSidebarNavCollapse: false,
        currentMenu: 'home',
        activeMenuList: []
    },
    getters: {},
    mutations: {
        toggleNavCollapse(state) {
            state.isSidebarNavCollapse = !state.isSidebarNavCollapse
        },
        SET_CURRENT_MENU(state, currentMenu) {
            state.currentMenu = currentMenu
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
        }
    },
    actions: {},
    modules: {}
})
