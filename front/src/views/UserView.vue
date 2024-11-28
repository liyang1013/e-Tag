<template>
    <div>
        <el-form ref="form" :model="searchVo" :inline="true" label-suffix=":" class="demo-form-inline">
            <el-form-item style="float:right;">
                <el-button type="primary" @click="search()" round :loading="tableLoading">查询</el-button>
                <el-button type="danger" round style="margin-left: 10px;" @click="newLabel()">添加用户</el-button>
            </el-form-item>
            <el-form-item label="用户名">
                <el-input v-model="searchVo.name" style="width: 160px;" clearable placeholder="用户名"></el-input>
            </el-form-item>
        </el-form>

        <el-table :data="documentList" border v-loading="tableLoading" element-loading-spinner="el-icon-loading"
            size="medium"
            style=" overflow-y: auto; overflow-x: hidden; height: calc(100vh - 215px); max-height: calc(100vh -215px);">
            <el-table-column prop="username" label="用户名">
            </el-table-column>
            <el-table-column prop="role" label="角色">
            </el-table-column>
            <el-table-column prop="lastLoginTime" label="最近登入时间">
            </el-table-column>
            <el-table-column prop="ipAddress" label="最近登入IP">
            </el-table-column>
            <el-table-column prop="licenseTime" label="授权期">
            </el-table-column>
            <el-table-column prop="appid" label="标签许可ID">
            </el-table-column>
            <el-table-column prop="appSecret" label="标签许可码">
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
    </div>
</template>

<script>

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
            documentList: [],
            tableLoading: false,
        }
    },
    methods: {
        search(val = 1) {
            this.tableLoading = true;
            this.searchVo.currentPage = val;
            this.$http.post('/api/user/searchUser', this.searchVo)
                .then(res => {
                    this.documentList = res.data.result;
                    this.searchVo.total = res.data.total;
                }).finally(() => this.tableLoading = false)
        },
        confirmDelete(row) {
            this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
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