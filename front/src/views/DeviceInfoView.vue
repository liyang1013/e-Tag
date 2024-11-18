<template>
    <div> <span style="font-size: 18px;">设备管理</span> <el-button style="float: right;" type="danger"
            round>添加设备</el-button>
        <el-divider></el-divider>
        <el-alert type="warning" :closable="false">
            <p style="font-size: 14px;display: flex;">需要先通过 <el-link style="font-size: 14px;"
                    href="/file/PriceTagSetup-0.24.apk" type="primary" target="_blank">电子价签设置工具</el-link>把电子标签工作模式设置为
                HTTP.</p>
        </el-alert>
        <el-table :data="documentList" border v-loading="tableLoading" element-loading-spinner="el-icon-loading"
            size="medium"
            style=" overflow-y: auto; overflow-x: hidden; height: calc(100vh - 240px); max-height: calc(100vh -240px);">
            <el-table-column prop="clientid" label="客户端ID">
            </el-table-column>
            <el-table-column prop="name" label="蓝牙名称">
            </el-table-column>
            <el-table-column prop="ip" label="地址">
            </el-table-column>
            <el-table-column prop="freespace" label="剩余空间">
                <template slot-scope="scope">
                    {{ (scope.row.freespace / 1048576).toFixed(2) }}MB</template>
            </el-table-column>
            <el-table-column prop="remarks" label="备注">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button type="text" @click="confirmDelete(scope.row)">删除</el-button>
                    <el-button type="text" @click="drawer = true">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-drawer :visible.sync="drawer" :with-header="false" :size="960">
            <el-row justify="center">
                <el-col :span="11" class="col-center">
                    <el-form style="margin-top: 50px;" label-suffix=":" label-position="left" label-width="100px"
                        :model="formLabelAlign">
                        <el-form-item label="视频上传">
                            <el-upload class="upload-demo" action="/api/device/uploadFile" :multiple="false"
                                :show-file-list="false" accept="video/*" :on-success="upload_success"
                                :on-error="upload_err">
                                <el-button type="primary">选择文件</el-button>
                            </el-upload>
                        </el-form-item>
                        <el-form-item label="视频文件">
                            <el-input v-model="forms.video.url" :disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="X">
                            <el-input-number v-model="forms.video.x" controls-position="right" :min="0"
                                :max="400"></el-input-number>
                        </el-form-item>
                        <el-form-item label="Y">
                            <el-input-number v-model="forms.video.y" controls-position="right" :min="0"
                                :max="640"></el-input-number>
                        </el-form-item>
                        <el-form-item label="视频宽度">
                            <el-input-number v-model="forms.video.width" controls-position="right" :min="0"
                                :max="400"></el-input-number>
                        </el-form-item>
                        <el-form-item label="视频高度">
                            <el-input-number v-model="forms.video.height" controls-position="right" :min="0"
                                :max="640"></el-input-number>
                        </el-form-item>
                        <el-form-item label="图片上传">
                            <el-upload class="upload-demo" action="/api/device/uploadFile" :multiple="false"
                                :show-file-list="false" accept="image/*" :on-success="upload_success"
                                :on-error="upload_err">
                                <el-button type="primary">选择文件</el-button>
                            </el-upload>
                        </el-form-item>
                        <el-form-item label="图片文件">
                            <el-input v-model="forms.image.url" :disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="X">
                            <el-input-number v-model="forms.image.x" controls-position="right" :min="0"
                                :max="400"></el-input-number>
                        </el-form-item>
                        <el-form-item label="Y">
                            <el-input-number v-model="forms.image.y" controls-position="right" :min="0"
                                :max="640"></el-input-number>
                        </el-form-item>
                        <el-form-item label="图片宽度">
                            <el-input-number v-model="forms.image.width" controls-position="right" :min="0"
                                :max="400"></el-input-number>
                        </el-form-item>
                        <el-form-item label="图片高度">
                            <el-input-number v-model="forms.image.height" controls-position="right" :min="0"
                                :max="640"></el-input-number>
                        </el-form-item>
                        <el-form-item style="margin:30px -50px">
                            <el-button type="danger">同步</el-button>
                            <el-button type="info">取消</el-button>
                        </el-form-item>
                    </el-form>
                </el-col>
                <el-col :span="11">
                    <el-card class="media-container">
                        <video v-if="forms.video.url" :src="forms.video.url" :style="videoStyle" autoplay loop
                            style="object-fit: cover"></video>
                        <img v-if="forms.image.url" :src="forms.image.url" :style="imageStyle" />
                    </el-card>
                </el-col>
            </el-row>
        </el-drawer>
    </div>
</template>

<script>

export default {
    data() {
        return {
            documentList: [],
            forms: {
                image: {
                    url: 'http://tag.pavodisplay.com/storage/tag/1001.jpg',
                    x: 0,
                    y: 320,
                    width: 400,
                    height: 320,
                },
                video: {
                    url: 'http://tag.pavodisplay.com/storage/video/2001.mp4',
                    x: 0,
                    y: 0,
                    width: 400,
                    height: 320,
                },
            },
            tableLoading: false,
            drawer: false
        }
    },
    computed: {
        videoStyle() {
            return {
                position: 'absolute',
                left: `${this.forms.video.x}px`,
                top: `${this.forms.video.y}px`,
                width: `${this.forms.video.width}px`,
                height: `${this.forms.video.height}px`
            };
        },
        imageStyle() {
            return {
                position: 'absolute',
                left: `${this.forms.image.x}px`,
                top: `${this.forms.image.y}px`,
                width: `${this.forms.image.width}px`,
                height: `${this.forms.image.height}px`
            };
        },
    },
    methods: {
        search() {
            this.$http.get('/api/device/searchDeviceInfo').then(res => this.documentList = res.data.result)
        },
        upload_success(data) {
            this.$message.success(data.message)
        },
        upload_err(data) {
            this.$message.warning(data.message)
        },
        confirmDelete(row) {
            this.$confirm('此操作将永久删除该电子标签, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.deleteDevice(row)
            }).catch(() => {
                this.$message({ type: 'info', message: '已取消删除' });
            });
        },
        deleteDevice(row) {
            this.$http.post('/api/device/deleteDevice', row).then(res => {
                if (res.data.message === '成功') {
                    this.$message({ type: 'success', message: '删除成功!' });
                    this.search()
                }
            })
        }
    },
    mounted() {
        this.search()
    }
}
</script>

<style scoped>
.el-divider--horizontal {
    margin: 20PX 0;
}

/deep/ .media-container {
    margin-top: 50px;
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


.video-container,
.image-container {
    flex: 1;

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
</style>
