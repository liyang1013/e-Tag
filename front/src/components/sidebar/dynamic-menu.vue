<template>
  <div class='menu-container'>
    <template v-for='v in menuList'>
      <el-submenu :index='v.path' v-if='v.children && v.children.length > 0' :key='v.id'>
        <template slot='title'>
          <i class="icon" v-if="v.icon" :class="v.icon"></i>
          <span>{{ v.name }}</span>
        </template>
        <el-menu-item-group>
          <my-nav :menuList='v.children'></my-nav>
        </el-menu-item-group>
      </el-submenu>
      <el-menu-item :key='v.id' :index='v.path' @click='gotoRoute(v)' v-else>
        <i class="icon" v-if="v.icon" :class="v.icon"></i>
        <span slot='title'>{{ v.name }}</span>
      </el-menu-item>
    </template>
    
  </div>
</template>

<script>
import store from "@/store";

export default {
  name: 'my-nav',
  props: {
    menuList: {
      type: Array,
      default: () => {
        return []
      }
    }
  },
  methods: {
    gotoRoute(item) {
      this.$router.push( './' + item.path )
      store.commit('SET_CURRENT_MENU', item.path)
      store.commit('addMenu', {name: item.name,path: item.path})
    }
  }
}
</script>

<style lang='scss'>
.menu-container {
  .icon {
    margin-right: 10px;
  }
}
</style>
