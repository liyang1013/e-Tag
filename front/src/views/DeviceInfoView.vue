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
            dialogFormVisible: false
        }
    },
    methods: {
        search() {
            this.$http.get('/api/device/searchDeviceInfo').then(res => this.documentList = res.data.result)
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
</style>
