<template>
    <div>
        <ProductCard @mouseover="showEditIcon = true" @mouseleave="showEditIcon = false" style="float: left; margin: 10px; position: relative;" v-for="item in 5" :key="item" text="丹东草莓"
            imageSrc="http://tag.pavodisplay.com/storage/tag/1001.jpg"
            videoSrc="http://tag.pavodisplay.com/storage/video/2001.mp4">
            <div v-if="showEditIcon" class="edit-icon">
                <i class="el-icon-edit" @click="handleEdit"></i>
            </div>
        </ProductCard>
    </div>

</template>

<script>
import ProductCard from '@/components/ProductCard'
export default {

    data() {
        return {
            showEditIcon: false
        }
    },
    components: {
        ProductCard
    }
}
</script>

<style scoped>
.edit-icon {
  position: absolute;
  top: 10px; /* 根据需要调整位置 */
  right: 10px; /* 根据需要调整位置 */
  z-index: 10; /* 确保图标在内容之上 */
}
 
.edit-icon i {
  font-size: 20px; /* 根据需要调整图标大小 */
  color: #409EFF; /* 图标颜色，可以根据主题调整 */
  cursor: pointer; /* 鼠标悬停时显示可点击的手型 */
}</style>