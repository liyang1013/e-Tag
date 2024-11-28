<template>
  <div :class="{ navCollapsed: isSidebarNavCollapse }">
    <sidebarNav class="sidebar" :menu="arr" />
    <div class="main-container">
      <TopAside />
      <el-card class="box-card" shadow="always">
        <keep-alive :max="8">
          <router-view class="content"></router-view>
        </keep-alive>
      </el-card>
    </div>
  </div>
</template>

<script>

import sidebarNav from '@/components/sidebar/sidebar-nav'
import TopAside from '@/components/main-content/top-aside'
import { mapState } from 'vuex'
import { menu } from "@/router/eTag-menu";
import router from "@/router";

export default {
  data() {
    return {
      menuList: menu,
      arr: []
    }
  },
  computed: {
    ...mapState(['isSidebarNavCollapse']),
    ...mapState(['activeMenuList'])
  },
  components: {
    sidebarNav,
    TopAside
  },
  methods: {
    filterRoute(arr) {
      let route = [];
      arr.forEach(e => {
        if (e.component !== null) {
          route.push({ ...e })
        } else if (e.children && e.children.length)
          route = route.concat(this.filterRoute(e.children))
      });
      return route;
    },
    routesData(menuList) {
      menuList.forEach(view => {
        const temp = {
          name: view.path,
          path: '/eTag/' + view.path,
          component: view.component
        }
        router.addRoute('eTag', temp)
      })
    },
    getView() {
      this.$http.get('/api/view/getView').then(res => {
        this.arr = res.data.result
      })
    }
  },
  mounted() {
    this.getView()
    this.routesData(this.filterRoute(menu))
    this.$router.push('/eTag/home')
  }
}
</script>

<style lang="scss" scoped>
.main-container {
  height: 100vh;
  background-color: rgb(240 242 245);

  .box-card {
    padding: 0;
    .content {
      width: 100%;
      height: calc(100vh - 120px);
      overflow: hidden;
    }
  }
}
</style>
