<template>
    <div>
        <el-form ref="form" :model="searchVo" :inline="true" label-suffix=":" class="demo-form-inline">
            <el-form-item style="float:right;">
                <el-button type="primary" @click="search()" round :loading="tableLoading">查询</el-button>
                <el-button type="danger" round style="margin-left: 10px;" @click="newLabel()">添加标签</el-button>
            </el-form-item>
            <el-form-item label="客户端ID">
                <el-input v-model="searchVo.code" style="width: 160px;" clearable placeholder="客户端ID"></el-input>
            </el-form-item>
            <el-form-item label="标签名">
                <el-input v-model="searchVo.name" style="width: 160px;" clearable placeholder="标签名"></el-input>
            </el-form-item>
            <el-form-item label="状态">
                <el-select v-model="searchVo.status" placeholder="请选择" style="width: 90px;">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>

            </el-form-item>

        </el-form>

        <el-alert type="warning" :closable="false">
            <p style="font-size: 14px;display: flex;">需要先通过 <el-link style="font-size: 14px;"
                    href="/file/PriceTagSetup-0.24.apk" type="primary" target="_blank">电子价签设置工具</el-link>把电子标签工作模式设置为
                HTTP,获取到客户端ID</p>
        </el-alert>
        <el-table :data="documentList" border v-loading="tableLoading" element-loading-spinner="el-icon-loading"
            size="medium"
            style=" overflow-y: auto; overflow-x: hidden; height: calc(100vh - 255px); max-height: calc(100vh -255px);">
            <el-table-column prop="clientId" label="客户端ID">
            </el-table-column>
            <el-table-column prop="name" label="标签名">
            </el-table-column>

            <el-table-column prop="status" label="是否启用">
                <template slot-scope="scope">
                    <el-switch v-model="scope.row.status" active-color="#13ce66" inactive-color="#ff4949"
                        @change="isEnable(scope.row)">
                    </el-switch>
                </template>
            </el-table-column>

            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button type="text" @click="confirmDelete(scope.row)">删除</el-button>
                    <el-button type="text" @click="edit(scope.row)">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination background layout="total, sizes, prev, pager, next" :total="searchVo.total"
            @current-change="handleCurrentChange" style=" margin-top: 10px;" @size-change="handleSizeChange"
            :page-sizes="searchVo.sizes" :current-page.sync="searchVo.currentPage" :page-size="searchVo.size">
        </el-pagination>


        <el-drawer :visible.sync="drawer" :with-header="false" :size="960">
            <el-row justify="center">
                <el-col :span="11" class="col-center">
                    <el-form :rules="rules" style="margin-top: 20px;" label-suffix=":" label-position="left"
                        label-width="100px" :model="forms" ref="forms">
                        <el-form-item label="客户端ID" prop="clientId">
                            <el-input v-model="forms.clientId" placeholder="蓝牙工具获取"
                                :disabled="abledClientid"></el-input>
                        </el-form-item>
                        <el-form-item label="标签名" prop="name">
                            <el-input v-model="forms.name" placeholder="自定义标签名称" prop="name"></el-input>
                        </el-form-item>

                        <el-form-item label="视频上传">
                            <el-upload class="upload-demo" action="/api/device/uploadFile" :multiple="false"
                                :show-file-list="false" accept="video/*"
                                :on-success="(res) => upload_success(res, 'video')" :on-error="upload_err">
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
                                :show-file-list="false" accept="image/*"
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

export default {
    data() {
        return {
            searchVo: {
                code: null,
                name: null,
                status: true,
                currentPage: 1,
                sizes: [20, 50, 100, 500],
                size: 20,
                total: 0
            },
            options: [
                {
                    value: null,
                    label: '全部'
                },
                {
                    value: true,
                    label: '启用'
                },
                {
                    value: false,
                    label: '禁用'
                }
            ],
            documentList: [],
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
            rules: {
                clientId: [
                    { required: true, message: '请输入客户端ID', trigger: 'blur' },
                    { min: 12, max: 12, message: '长度为 12 个字符', trigger: 'blur' }
                ]
            },
            editTemp: {},
            abledClientid: false,
            tableLoading: false,
            submitLoading: false,
            drawer: false
        }
    },
    computed: {
        videoStyle() {
            return {
                position: 'absolute',
                objectFit: 'cover',
                left: `${this.forms.video.x}px`,
                top: `${this.forms.video.y}px`,
                width: `${this.forms.video.width}px`,
                height: `${this.forms.video.height}px`

            };
        },
        imageStyle() {
            return {
                position: 'absolute',
                backgroundSize: '100% auto',
                backgroundRepeat: 'repeat-y',
                left: `${this.forms.image.x}px`,
                top: `${this.forms.image.y}px`,
                width: `${this.forms.image.width}px`,
                height: `${this.forms.image.height}px`,
                backgroundImage: `url(/api/uploads/${this.forms.image.name})`
            };
        },
    },
    methods: {
        search(val = 1) {
            this.tableLoading = true;
            this.searchVo.currentPage = val;
            this.$http.post('/api/device/searchDevicePageHelper', this.searchVo)
                .then(res => {
                    this.documentList = res.data.result;
                    this.searchVo.total = res.data.total;
                }).finally(() => this.tableLoading = false)
        },
        newLabel() {
            this.drawer = true;
            this.abledClientid = false
            this.$nextTick(() => {
                this.$refs.forms.resetFields()
            })
        },
        isEnable(row) {
            this.$http.post('/api/device/enable', row)
        },
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.submitLoading = true
                    this.$http.post('/api/device/addLabel', this.forms)
                        .then(res => {
                            if (res.data.status === 200) {
                                this.$message({ type: 'success', message: '保存成功' });
                                this.editTemp = JSON.parse(JSON.stringify(this.forms));
                            }
                        }).finally(() => this.submitLoading = false)
                } else {
                    return false;
                }
            });
        },
        resetForm(formName) {
            if (this.abledClientid) {
                this.forms = JSON.parse(JSON.stringify(this.editTemp));
            } else { this.$nextTick(() => { this.$refs[formName].resetFields() }) }
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
        edit(row) {
            this.drawer = true;
            this.abledClientid = true
            this.$http.post('/api/device/getTemplate', row).then(res => {
                if (res.data.status === 200) {
                    this.editTemp = {
                        clientId: row.clientId,
                        name: row.name,
                        image: res.data.result.find(item => item.type === 'image'),
                        video: res.data.result.find(item => item.type === 'video')
                    }
                    this.forms = JSON.parse(JSON.stringify(this.editTemp));
                    this.$nextTick(() => {
                        this.$refs.forms.clearValidate(['clientId']);
                    });
                }
            })
        },
        upload_success(data, type) {
            if (data.status === 200) {
                if (type === 'image')
                    this.forms.image.name = data.message
                else if (type === 'video')
                    this.forms.video.name = data.message
            } else
                this.$message({ type: 'error', message: data.message });

        },
        handleCurrentChange(val) {
            this.search(val);
        },
        handleSizeChange(val) {
            this.searchVo.size = val;
            this.search(1);
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
