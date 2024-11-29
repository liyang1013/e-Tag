<template>
    <div class="back">
        <el-form :model="user" label-width="80px" class="login-box" label-position="left">
            <h3 class="login-title">欢迎登录</h3>
            <el-form-item label="用户名:">
                <el-input ref="un" type="text" placeholder="请输入用户名" v-model="user.username"
                    @keyup.enter.native="$refs.pwd.focus();" />
            </el-form-item>
            <el-form-item label="密码:">
                <el-input ref="pwd" type="password" placeholder="请输入密码" v-model="user.password"
                    @keyup.enter.native="login()" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login()">登录</el-button>
            </el-form-item>
        </el-form>
    </div>

</template>

<script>
export default {
    data() {
        return {
            user: {
                username: '',
                password: '',
                ipAddress: null,
                city: null
            }
        }
    },
    methods: {
        login() {
            if (this.user.username === '') { this.$message({ type: 'warning', message: '用户名不能为空' }); return; }
            if (this.user.password === '') { this.$message({ type: 'warning', message: '密码不能为空' }); return; }
            this.$http.post('/api/auth/login', this.user).then(res => {
                if (res.data.status === 200) {
                    localStorage.setItem('token',res.data.message)
                    localStorage.setItem('exp',res.data.result)
                    this.$router.push({ name: 'eTag' });
                }
            })
        },
        getIpInfo(){
            this.$http.get('https://qifu.baidu.com/ip/local/geo/v1/district').then(res => {
                if(res.data.code === 'Success'){
                    const info = res.data
                    this.user.ipAddress = info.ip
                    this.user.city = info.data.country + info.data.prov + info.data.city + info.data.district
                }
            })
        }
    },
    mounted() {
        this.$nextTick(() => {
            this.$refs.un.focus();
            this.getIpInfo()
        }); 
    }
}
</script>
<style scoped>
.back {
    background: url('/src/assets/background.jpg') no-repeat center center fixed;
    background-size: cover;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
}

.login-box {
    background: rgba(255, 255, 255, 0.8);
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
    width: 400px;
    text-align: left;
}

.login-title {
    margin-bottom: 20px;
    color: #333;
    font-size: 24px;
    text-align: center;
    /* 标题仍然居中 */
}

.el-form-item {
    margin-bottom: 15px;
}

.el-input {
    width: 100%;
    box-sizing: border-box;
}

.login-button {
    width: 100%;
    background-color: #409EFF;
    border-color: #409EFF;
    font-size: 16px;
    padding: 10px 0;
}

.login-button:hover {
    background-color: #66b1ff;
    border-color: #66b1ff;
}

.error-message {
    color: red;
    margin-top: 10px;
    text-align: center;
    /* 错误消息居中 */
}
</style>