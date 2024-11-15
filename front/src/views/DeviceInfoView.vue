<template>
    <div> <span style="font-size: 18px;">设备管理</span> <el-button style="float: right;" type="danger" round
            @click="() => { dialogFormVisible = true; clearForm() }">添加设备</el-button>
        <el-divider></el-divider>
        <el-alert type="warning" :closable="false">
            <p style="font-size: 14px;display: flex;">需要先通过 <el-link style="font-size: 14px;"
                    href="/file/PriceTagSetup-0.24.apk" type="primary" target="_blank">电子价签设置工具</el-link>把电子标签工作模式设置为
                HTTP-SERVER, 连接同一局域网内WIFI获取IP地址。</p>
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
        <el-dialog title="标签信息" :visible.sync="dialogFormVisible" width="400px" :show-close="false">
            <el-form :model="form" label-width="60px" label-position="left">
                <el-form-item label="IP地址:">
                    <el-input v-model="form.ip" style="width: 250px"></el-input>
                </el-form-item>
                <el-form-item label="备注:">
                    <el-input v-model="form.remarks" style="width: 250px"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer" style="text-align: center;">
                <el-button @click="dialogFormVisible = false;">取 消</el-button>
                <el-button type="primary" @click="addDevice">确 定</el-button>
            </div>
        </el-dialog>
        <el-drawer :visible.sync="drawer" :with-header="false" :size="960">
            <el-row justify="center">
                <el-col :span="11" class="col-center">
                    <el-form style="margin-top: 100px;" label-suffix=":" label-position="left" label-width="100px"
                        :model="formLabelAlign">
                        <el-form-item label="名称">
                            <el-input v-model="formLabelAlign.text"></el-input>
                        </el-form-item>
                        <el-form-item label="视频上传">
                            <el-upload class="upload-demo" action="/api/device/uploadFile" :multiple="false" :show-file-list="false"
                                accept="video/*" :on-success="upload_success" :on-error="upload_err">
                                <el-button type="primary">选择文件</el-button>
                            </el-upload>
                        </el-form-item>
                        <el-form-item label="视频文件">
                            <el-input v-model="formLabelAlign.videoUrl" :disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="视频高度">
                            <el-input-number v-model="formLabelAlign.videoHeight"
                                @change="(val) => changeVideHeight(val)" controls-position="right" :min="0"
                                :max="480"></el-input-number>
                        </el-form-item>
                        <el-form-item label="图片上传">
                            <el-upload class="upload-demo" action="/api/device/uploadFile" :multiple="false" :show-file-list="false"
                                accept="image/*" :on-success="upload_success" :on-error="upload_err">
                                <el-button type="primary">选择文件</el-button>
                            </el-upload>
                        </el-form-item>
                        <el-form-item label="图片文件">
                            <el-input v-model="formLabelAlign.imageUrl" :disabled="true"></el-input>
                        </el-form-item>
                        <el-form-item label="图片高度">
                            <el-input-number v-model="formLabelAlign.imageHeight"
                                @change="(val) => changeImageHeight(val)" controls-position="right" :min="0"
                                :max="480"></el-input-number>
                        </el-form-item>

                        <el-form-item style="margin:30px -50px">
                            <el-button type="danger">同步</el-button>
                            <el-button type="info">取消</el-button>
                        </el-form-item>
                    </el-form>

                </el-col>
                <el-col :span="11">
                    <el-container>
                        <el-header style="height: 40px;margin-top: 50px;">
                            <div class="text-container">
                                <p style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">{{
                                    formLabelAlign.text
                                }}</p>
                                <br>
                            </div>
                        </el-header>
                        <el-main class="col-center">
                            <el-card class="custom-card" style="height: 495px; width: 300px;">
                                <div class="video-container" :style="videoStyle">
                                    <video muted="" autoplay="atuo" :src="formLabelAlign.videoUrl" controls="controls"
                                        loop="true" id="video">
                                        您的浏览器不支持 video 标签。
                                    </video>
                                </div>
                                <div class="image-container" :style="imageStyle">
                                    <img :src="formLabelAlign.imageUrl" />
                                </div>
                            </el-card>
                        </el-main>
                    </el-container>
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
            form: {
                ip: null,
                remarks: null
            },
            tableLoading: false,
            dialogFormVisible: false,
            drawer: false,
            formLabelAlign: {
                text: "丹东草莓",
                videoUrl: "http://tag.pavodisplay.com/storage/video/2001.mp4",
                videoHeight: 240,
                imageUrl: "http://tag.pavodisplay.com/storage/tag/1001.jpg",
                imageHeight: 240
            }
        }
    },
    computed: {
        videoStyle() {
            return {
                height: `${this.formLabelAlign.videoHeight}px`,
            };
        },
        imageStyle() {
            return {
                height: `${this.formLabelAlign.imageHeight}px`,
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
        },
        addDevice() {
            if (!this.form.ip) {
                this.$message({ type: 'warning', message: 'IP地址不能为空' });
                return
            }
            this.$http.post('/api/device/addDevice', this.form).then(res => {
                if (res.data.message === '成功') {
                    this.$message({ type: 'success', message: '添加成功' });
                    this.search()
                    this.dialogFormVisible = false
                }
            })
        },
        changeVideHeight(val) {
            this.formLabelAlign.imageHeight = 480 - val
        },
        changeImageHeight(val) {
            this.formLabelAlign.videoHeight = 480 - val
        },
        clearForm() {
            this.form = {}
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

.custom-card {
    display: flex;
    flex-direction: column;
    overflow: hidden;
    border: 2px solid #cfcfcf;
    border-radius: 8px;
    background-color: #ededed;
}

/deep/ .el-card__body,
.el-main {
    padding: 5px;
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

.text-container {
    display: flex;
    align-items: center;
    justify-content: center;
    flex: none;
    padding: 8px;
    box-sizing: border-box;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    text-align: center;
}
</style>
