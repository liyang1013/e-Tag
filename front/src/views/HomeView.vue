<template>
    <el-calendar v-model="nowDate" ></el-calendar>
</template>

<script>
export default {
  name: 'home',
  data() {
    return {
      nowDate: new Date()
    }
  }
}
</script>

<style lang="scss" scoped>
::v-deep  .el-calendar-table .el-calendar-day{
  width: 60px;
  height: 60px;
}

</style>