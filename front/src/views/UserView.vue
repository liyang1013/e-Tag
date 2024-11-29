<template>
    <div>
        <el-form ref="form" :model="searchVo" :inline="true" label-suffix=":" class="demo-form-inline">
            <el-form-item style="float:right;">
                <el-button type="primary" @click="search()" round :loading="tableLoading">查询</el-button>
                <el-button type="danger" round style="margin-left: 10px;" @click="newUser()">添加用户</el-button>
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
            <el-table-column prop="lastLoginTime" label="登入时间">
            </el-table-column>
            <el-table-column prop="city" label="登入地址">
            </el-table-column>
            <el-table-column prop="ipAddress" label="登入IP">
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
                    <el-button type="text" @click="editUser(scope.row)">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination background layout="total, sizes, prev, pager, next" :total="searchVo.total"
            @current-change="handleCurrentChange" style=" margin-top: 10px;" @size-change="handleSizeChange"
            :page-sizes="searchVo.sizes" :current-page.sync="searchVo.currentPage" :page-size="searchVo.size">
        </el-pagination>

        <el-drawer :visible.sync="drawer" :with-header="false" :size="360">
            <el-form style="padding:20px" :rules="rules" label-suffix=":" label-position="left" label-width="90px"
                :model="user" ref="userform">
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="user.username" placeholder="用户名" style="width: 240px;"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="user.password" placeholder="密码" show-password style="width: 240px;"></el-input>
                </el-form-item>

                <el-form-item label="授权期" prop="licenseTime">
                    <el-date-picker v-model="user.licenseTime" type="date" placeholder="选择日期"  format="yyyy年MM月dd日" value-format="yyyy-MM-dd">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="appid" prop="appid">
                    <el-input v-model="user.appid" placeholder="标签认证id" style="width: 240px;"></el-input>
                </el-form-item>
                <el-form-item label="appSecret" prop="appSecret">
                    <el-input v-model="user.appSecret" placeholder="标签认证密码" style="width: 240px;"></el-input>
                </el-form-item>
                <el-form-item label="角色" prop="role">
                    <el-select v-model="user.role" placeholder="请选择" style="width: 120px;">
                        <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="danger" @click="addUser()" :loading="submitLoading">保存</el-button>
                </el-form-item>
            </el-form>
        </el-drawer>

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
            options: [
                {
                    value: "admin",
                    label: '管理员'
                },
                {
                    value: "general",
                    label: '普通用户'
                }
            ],
            documentList: [],
            user: {
                username: null,
                password: null,
                licenseTime: new Date(),
                appid: null,
                appSecret: null,
                role: "general",
                uid: null
            },
            rules: {
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                    { min: 5, max: 12, message: '长度为5 ~ 20 个字符', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 5, max: 12, message: '长度为5 ~ 20 个字符', trigger: 'blur' }
                ],
                appid: [
                    { required: true, message: '请输入aapid', trigger: 'blur' },
                    { min: 5, max: 12, message: '长度为5 ~ 32 个字符', trigger: 'blur' }
                ],
                appSecret: [
                    { required: true, message: '请输入appSecret', trigger: 'blur' },
                    { min: 5, max: 12, message: '长度为10 ~ 32 个字符', trigger: 'blur' }
                ],
            },
            tableLoading: false,
            submitLoading: false,
            drawer: false
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
        newUser() {
            this.drawer = true;
            this.user = {
                uid: null,
                username: null,
                password: null,
                appid: null,
                licenseTime: new Date(),
                appSecret: null,
                role: "general"
            }
        },
        editUser(row) {
            this.drawer = true;
            this.user = {
                uid: row.uid,
                username: row.username,
                password: "******",
                appid: row.appid,
                licenseTime: row.licenseTime,
                appSecret: row.appSecret,
                role: row.role
            }
        },
        addUser() {
            this.$refs.userform.validate((valid) => {
                if (valid) {
                    this.submitLoading = true
                    this.$http.post('/api/user/addUser', this.user)
                        .then(res => {
                            if (res.data.status === 200) {
                                this.$message({ type: 'success', message: '保存成功' });
                            }
                        }).finally(() => this.submitLoading = false)
                } else {
                    return false;
                }
            });
        },
        confirmDelete(row) {
            this.$confirm('永久删除该用户并删除名下所有标签, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.deleteUser(row)
            }).catch(() => {
                this.$message({ type: 'info', message: '已取消删除' });
            });
        },
        deleteUser(row) {
            this.$http.get('/api/user/deleteUser?uid='+ row.uid).then(res => {
                if (res.data.message === '成功') {
                    this.$message({ type: 'success', message: '删除成功!' });
                    this.search()
                }
            })
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