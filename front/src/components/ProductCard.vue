<template>
  <el-card class="custom-card" style="height: 316px; width: 200px;">
    <div class="video-container" :style="videoStyle">
      <video muted="" src="http://tag.pavodisplay.com/storage/video/2001.mp4" controls="controls" loop="true"
        id="video">
        您的浏览器不支持 video 标签。
      </video>
    </div>
    <div class="image-container" :style="imageStyle">
      <img :src="imageSrc" alt="Image">
    </div>
    <div class="text-container">
      <span style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">{{ text }}</span> <el-button
        type="text" icon="el-icon-edit" circle @click="openDrawer"></el-button>
    </div>
  </el-card>
</template>

<script>
export default {
  name: 'CustomCard',
  data() {
    return {
    }
  },
  methods: {
    openDrawer() {
      this.$emit('open-drawer');
    }
  },
  props: {
    videoSrc: {
      type: String,
      required: true,
    },
    imageSrc: {
      type: String,
      required: true,
    },
    videoHeight: {
      type: Number,
      default: 128,
    },
    videoWidth: {
      type: Number,
      default: 160,
    },
    imageHeight: {
      type: Number,
      default: 128,
    },
    imageWidth: {
      type: Number,
      default: 160,
    },
    text: {
      type: String,
      default: '',
    },
  },
  computed: {
    videoStyle() {
      return {
        height: `${this.videoHeight}px`,
        width: `${this.videoWidth}px`,
      };
    },
    imageStyle() {
      return {
        height: `${this.imageHeight}px`,
        width: `${this.imageWidth}px`,
      };
    },
  }
}
</script>

<style scoped>
.custom-card {
  display: flex;
  flex-direction: column;
  overflow: hidden;
  border: 2px solid #cfcfcf;
  border-radius: 8px;
  background-color: #ededed;
}

.video-container,
.image-container {
  flex: 1;
  max-height: 128px;
  /* Adjust if needed */
}

.video-container video {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.image-container img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}


.text-container {
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex: none;
  padding: 8px;
  box-sizing: border-box;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  text-align: center;
}
</style>