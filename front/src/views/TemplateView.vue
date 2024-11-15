<template>
    <div>
        <span style="font-size: 18px;">模板管理</span> <el-button style="float: right;margin-right: 20px;" type="danger"
            round @click="() => { dialogFormVisible = true; clearForm() }">添加模板</el-button>

        <el-divider></el-divider>

        <div
            style="  overflow-y: auto; overflow-x: hidden; height: calc(100vh - 200px); max-height: calc(100vh -200px);">
            <ProductCard :ishosw="true" @open-drawer="handleOpenDrawer(item)" style="float: left; margin: 10px; position: relative;"
                v-for="item in 5" :key="item" text="丹东草莓丹东草莓丹东草莓"
                imageSrc="http://tag.pavodisplay.com/storage/tag/1001.jpg"
                videoSrc="http://tag.pavodisplay.com/storage/video/2001.mp4">
            </ProductCard>
        </div>


        <el-drawer :visible.sync="drawer" :with-header="false" :size="960">
            <el-row>
                <el-col span="12">设置</el-col>
                <el-col span="12">图像</el-col>
            </el-row>
        </el-drawer>
    </div>

</template>

<script>
import ProductCard from '@/components/ProductCard'
export default {

    data() {
        return {
            dialogFormVisible: false,
            drawer: false
        }
    },
    components: {
        ProductCard
    },
    methods: {
        clearForm() { },
        handleOpenDrawer(item) {
            console.log(item)
            this.drawer = true
        }
    }
}
</script>

<style scoped>
.el-divider--horizontal {
    margin: 20PX 0;
}
</style>
