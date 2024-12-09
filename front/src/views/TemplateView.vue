<template>
    <div>
        <el-form ref="form" :model="searchVo" :inline="true" label-suffix=":" class="demo-form-inline">
            <el-form-item style="float:right;">
                <el-button type="primary" @click="search()" round :loading="tableLoading">查询</el-button>
                <el-button type="danger" round style="margin-left: 10px;" @click="newTemplate()">添加模板</el-button>
            </el-form-item>
            <el-form-item label="名称">
                <el-input v-model="searchVo.name" style="width: 160px;" clearable placeholder="模板名称"></el-input>
            </el-form-item>
        </el-form>

        <div
            style="  overflow-y: auto; overflow-x: hidden; height: calc(100vh - 200px); max-height: calc(100vh -200px);">
            <ProductCard :ishosw="true" @open-drawer="handleOpenDrawer(item)"
                style="float: left; margin: 10px; position: relative;" v-for="item in 5" :key="item" text="丹东草莓丹东草莓丹东草莓"
                imageSrc="http://tag.pavodisplay.com/storage/tag/1001.jpg"
                videoSrc="http://tag.pavodisplay.com/storage/video/2001.mp4">
            </ProductCard>
        </div>

        <el-drawer :visible.sync="drawer" :with-header="false" :size="960">
            <el-row justify="center">
                <el-col :span="11" class="col-center">
                    <el-form :rules="rules" style="margin-top: 20px;" label-suffix=":" label-position="left"
                        label-width="100px" :model="forms" ref="forms">
                        <el-form-item label="模板名" prop="name">
                            <el-input v-model="forms.name" placeholder="自定义模板名称" prop="name"></el-input>
                        </el-form-item>

                        <el-form-item label="视频上传">
                            <el-upload class="upload-demo" action="/api/device/uploadFile" :multiple="false"
                                :show-file-list="false" accept="video/*" :headers="header"
                                :on-success="(res) => upload_success(res, 'video')">
                                <el-button type="primary">选择文件</el-button>
                            </el-upload>
                        </el-form-item>
                        <el-form-item label="视频文件" prop="video.name">
                            <el-input v-model="forms.video.name" :disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="左边距(X)" prop="video.x">
                            <el-input-number v-model="forms.video.x" controls-position="right" :min="0"
                                :max="400"></el-input-number>
                        </el-form-item>
                        <el-form-item label="上边距(Y)" prop="video.y">
                            <el-input-number v-model="forms.video.y" controls-position="right" :min="0"
                                :max="640"></el-input-number>
                        </el-form-item>
                        <el-form-item label="视频宽度" prop="video.width">
                            <el-input-number v-model="forms.video.width" controls-position="right" :min="0"
                                :max="400"></el-input-number>
                        </el-form-item>
                        <el-form-item label="视频高度" prop="video.height">
                            <el-input-number v-model="forms.video.height" controls-position="right" :min="0"
                                :max="640"></el-input-number>
                        </el-form-item>
                        <el-form-item label="图片上传">
                            <el-upload class="upload-demo" action="/api/device/uploadFile" :multiple="false"
                                :show-file-list="false" accept="image/*" :headers="header"
                                :on-success="(res) => upload_success(res, 'image')">
                                <el-button type="primary">选择文件</el-button>
                            </el-upload>
                        </el-form-item>
                        <el-form-item label="图片文件" prop="image.name">
                            <el-input v-model="forms.image.name" :disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="左边距(X)" prop="image.x">
                            <el-input-number v-model="forms.image.x" controls-position="right" :min="0"
                                :max="400"></el-input-number>
                        </el-form-item>
                        <el-form-item label="上边距(Y)" prop="image.y">
                            <el-input-number v-model="forms.image.y" controls-position="right" :min="0"
                                :max="640"></el-input-number>
                        </el-form-item>
                        <el-form-item label="图片宽度" prop="image.width">
                            <el-input-number v-model="forms.image.width" controls-position="right" :min="0"
                                :max="400"></el-input-number>
                        </el-form-item>
                        <el-form-item label="图片高度" prop="image.height">
                            <el-input-number v-model="forms.image.height" controls-position="right" :min="0"
                                :max="640"></el-input-number>
                        </el-form-item>
                        <el-form-item style="margin: 30px -50px">
                            <el-button type="danger" @click="submitForm('forms')"
                                :loading="submitLoading">保存</el-button>
                            <el-button type="info" @click="resetForm('forms')">重置</el-button>
                        </el-form-item>
                    </el-form>
                </el-col>
                <el-col :span="11">
                    <el-card class="media-container">
                        <video :src="'/api/uploads/' + forms.video.name" :style="videoStyle" autoplay loop
                            muted></video>
                        <!-- <img :src="'/api/uploads/' + forms.image.name" :style="imageStyle" /> -->
                        <div :style="imageStyle"></div>
                    </el-card>
                </el-col>
            </el-row>
        </el-drawer>
    </div>

</template>

<script>
import ProductCard from '@/components/ProductCard'
export default {

    data() {
        return {
            searchVo: {
                name: null,
                currentPage: 1,
                sizes: [20, 50, 100, 500],
                size: 20,
                total: 0
            },
            header: {
                token: localStorage.getItem('token')
            },
            forms: {
                clientId: null,
                name: null,
                image: {
                    name: '1001.jpg',
                    x: 0,
                    y: 320,
                    width: 400,
                    height: 320,
                    type: 'image'
                },
                video: {
                    name: '2001.mp4',
                    x: 0,
                    y: 0,
                    width: 400,
                    height: 320,
                    type: 'video'
                }
            },
            dialogFormVisible: false,
            drawer: false
        }
    },
    components: {
        ProductCard
    },
    methods: {
        search() { },
        addTemplate() { }
        , clearForm() { },
        handleOpenDrawer(item) {
            console.log(item)
            this.drawer = true
        }
    }
}
</script>

<style scoped>
.media-container {
    margin-top: 30px;
    flex-direction: column;
    overflow: hidden;
    border: 2px solid #cfcfcf;
    border-radius: 8px;
    position: relative;
    width: 400px;
    height: 640px;
}

.col-center {
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
