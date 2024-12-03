<template>
    <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span>标签系统信息</span>
            <el-button size="medium" style="float: right; padding: 3px 0" type="text" @click="getSystemInfo()" icon="el-icon-refresh"></el-button>
        </div>
        <div class="info">
            <p>接口地址: {{  info.password }}</p>
            <p>appid: {{  info.appid }}</p>
            <p>appSecret: {{  info.appSecret }}</p>
            <p>系统授权到期日：{{ info.licenseTime }}</p>
            <p>上次登入时间: {{  info.lastLoginTime }}</p>
            <p>上次登入IP: {{  info.ipAddress }}</p>
            <p>上次登入地址: {{  info.city }}</p>
        </div>
    </el-card>

</template>
<script>

export default {
    data() {
        return {
            info: {
                licenseTime: null,
                password: null,
                appid: null,
                appSecret: null,
                lastLoginTime: null,
                ipAddress: null,
                city: null
            }
        }
    },
    methods: {
        getSystemInfo() {
            this.$http.get('/api/user/getSystemInfo').then(res => {
                if(res.data.status === 200){
                    this.info = res.data.result
                }
            })
        }
    },
    mounted() {
        this.getSystemInfo()
    }
}
</script>


<style scoped>
.item {
    margin-bottom: 18px;
}

.info>p {
    font-size: 20px;
    margin-top: 15px;
}

.clearfix:before,
.clearfix:after {
    display: table;
    content: "";
}

.clearfix:after {
    clear: both
}

.box-card {
    width: 480px;
}
</style>