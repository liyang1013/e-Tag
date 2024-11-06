<template>
  <el-menu :collapse="isSidebarNavCollapse" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b"
           :default-active="currentMenu" :unique-opened="true">
    <DynamicMenu :menuList="menu" ></DynamicMenu>
  </el-menu>
</template>

<script>
import DynamicMenu from './dynamic-menu.vue'
import {mapState} from 'vuex'

export default {
  name: 'sidebar',
  props:{
    menu : [],
  },
  data() {
    return {
      isCollapse: true,
    }
  },
  computed: {
    ...mapState(['isSidebarNavCollapse']),
    ...mapState(['currentMenu'])
  },
  components: {
    DynamicMenu
  }
}
</script>
