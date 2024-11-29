<template>
  <aside class="aside__top" ref="asideTop" style="white-space:nowrap;">
    <span class="iconfont icon-nav toggleNavCollapse" :class="{ active: isSidebarNavCollapse }"
      @click="toggleNavCollapse">
    </span>
    <div style="display: inline-block;">
      <div class="tags" style="position: relative;  transition: .3s; display: inline; left: 0px">
        <el-tag key="home" @click="openMenu('home')" size="small" :effect="isCurrentMenu('home')">
          首页
        </el-tag>
        <el-tag :key="tag.path" @click="openMenu(tag.path)" size="small" v-for="(tag, index) in activeMenuList"
          :closable="true" :disable-transitions='true' :effect="isCurrentMenu(tag.path)" @close="handleClose(tag)"
          v-show="index < maxTagNum">
          {{ tag.name }}
        </el-tag>
        <el-tag v-if="activeMenuList.length > maxTagNum">
          + {{ activeMenuList.length - maxTagNum }}
        </el-tag>
      </div>
    </div>
    <el-button type="danger" round size="mini" style=" margin-left: auto; " @click="logout()">退出</el-button>
  </aside>
</template>
<script>
import { mapState } from 'vuex'

export default {
  data() {
    return {
      tagCount: 1,
      maxTagNum: 8
    }
  },
  computed: {
    ...mapState(['isSidebarNavCollapse']),
    ...mapState(['activeMenuList']),
    ...mapState(['currentMenu'])
  },
  methods: {
    toggleNavCollapse() {
      this.$store.commit('toggleNavCollapse')
    },
    handleClose(tag) {
      this.$store.commit('deleteMenu', tag);

    },
    openMenu(path) {
      this.$store.commit('SET_CURRENT_MENU', path)
      this.$router.push(path);
    },
    isCurrentMenu(path) {
      let style;
      this.currentMenu === path ? style = 'dark' : style = 'plain'
      return style
    },
    logout() {
      localStorage.removeItem('token')
      localStorage.removeItem('exp')
      this.$router.push({ name: 'login' });
    }
  },
  mounted() {
    let tagsWidth = this.$refs.asideTop.offsetWidth - 100;
    this.maxTagNum = (tagsWidth / 100).toFixed(0)
  }
}
</script>

<style lang="scss" scoped>
.aside__top {
  border-bottom: 1px solid #e5e5e5;
  height: 45px;
  line-height: 45px;
  position: fixed;
  left: 200px;
  top: 0;
  right: 0;
  background: #fff;
  z-index: 1000;
  transition: left 0.25s;
  display: flex; // 添加这一行来启用 flexbox
  align-items: center; // 垂直居中子元素
  justify-content: space-between; // 让子元素在主轴上分布，首尾对齐
  padding: 0 10px; // 可选，为内部元素提供一些内边距

  .el-tag {
    margin-left: 10px;
  }

  .toggleNavCollapse {
    display: inline-block;
    margin-left: 8px;
    padding: 0 10px;
    font-size: 26px;
    vertical-align: middle;
    color: #333;
    cursor: pointer;
    transition: all 0.5s;

    &.active {
      transform: rotate(90deg);
    }
  }
}

.breadcrumb-enter,
.breadcrumb-leave-active {
  opacity: 0;
  transform: translateX(20px);
}

.breadcrumb-enter-active,
.breadcrumb-leave-active {
  transition: all 0.6s;
}

.breadcrumb-leave-active {
  position: absolute;
}
</style>
