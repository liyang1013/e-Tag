<template>
  <div id="app">
    <router-view/>
  </div>
</template>
<script>
export default {
  data() {
    return {
      flushList: ['eoms','authorityReview','invoice']
    }
  },
  mounted() {
    for(let i = 0; i < this.flushList.length; i++){
      if(window.location.pathname.indexOf('/' + this.flushList[i] + '/') !== -1){
        this.$router.push('/' + this.flushList[i] + '/');
        return
      }
    }
  }
}
</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
