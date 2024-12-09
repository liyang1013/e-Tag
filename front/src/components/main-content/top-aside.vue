<template>
  <div>
    <aside class="aside__top" ref="asideTop" style="white-space:nowrap;">
      <span class="iconfont icon-nav toggleNavCollapse" :class="{ active: isSidebarNavCollapse }"
        @click="toggleNavCollapse">
      </span>
      <div style="display: inline-block;">
        <div class="tags" style="position: relative;  transition: .3s; display: inline; left: 0px">
          <el-tag key="home" @click="openMenu('home')" size="small" :effect="isCurrentMenu('home')">
            首页
          </el-tag>
          <el-tag :key="tag.path" @click="openMenu(tag.path)" size="small" v-for="(tag, index) in activeMenuList"
            :closable="true" :disable-transitions='true' :effect="isCurrentMenu(tag.path)" @close="handleClose(tag)"
            v-show="index < maxTagNum">
            {{ tag.name }}
          </el-tag>
          <el-tag v-if="activeMenuList.length > maxTagNum">
            + {{ activeMenuList.length - maxTagNum }}
          </el-tag>
        </div>
      </div>
      <el-popover placement="top-end" width="200" trigger="hover" style="margin-left: auto;">
        <div style="display: flex; flex-direction: column; align-items: center; justify-content: center;">

          <p style="margin-top: 10px; font-size: 16px;">{{ username }}</p>
          <div style="margin-top: 20px;">
            <el-button type="text" round size="mini" @click="logout()">退出登入</el-button>
            <el-button type="text" round size="mini" @click="show()">修改密码</el-button>
          </div>
        </div>
        <el-avatar slot="reference" size="medium"
          src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
      </el-popover>
    </aside>
    <el-dialog title="修改密码" :visible.sync="dialogVisible" width="30%">
      <el-form :model="form" :rules="rules" ref="form">
        <el-form-item label="旧密码" prop="oldPassword">
          <el-input type="password" v-model="form.oldPassword" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="新密码" prop="newPassword">
          <el-input type="password" v-model="form.newPassword" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认新密码" prop="confirmPassword">
          <el-input type="password" v-model="form.confirmPassword" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="submitForm('form')">确定</el-button>
      </div>
    </el-dialog>
  </div>

</template>
<script>
import { mapState } from 'vuex'

export default {
  data() {
    return {
      tagCount: 1,
      maxTagNum: 8,
      username: localStorage.getItem('username'),
      dialogVisible: false,
      form: {
        oldPassword: '',
        newPassword: '',
        confirmPassword: '',
      },
      rules: {
        oldPassword: [
          { required: true, message: '请输入旧密码', trigger: 'blur' },
        ],
        newPassword: [
          { required: true, message: '请输入新密码', trigger: 'blur' },
          { min: 5, max: 20, message: '长度在 5 到 20 个字符', trigger: 'blur' },
        ],
        confirmPassword: [
          { required: true, message: '请确认新密码', trigger: 'blur' },
          { validator: this.validateConfirmPassword, trigger: 'blur' },
        ],
      },
    }
  },
  computed: {
    ...mapState(['isSidebarNavCollapse']),
    ...mapState(['activeMenuList']),
    ...mapState(['currentMenu'])
  },
  methods: {
    toggleNavCollapse() {
      this.$store.commit('toggleNavCollapse')
    },
    handleClose(tag) {
      this.$store.commit('deleteMenu', tag);

    },
    openMenu(path) {
      this.$store.commit('SET_CURRENT_MENU', path)
      this.$router.push(path);
    },
    isCurrentMenu(path) {
      let style;
      this.currentMenu === path ? style = 'dark' : style = 'plain'
      return style
    },
    show() {
      this.dialogVisible = true;
      this.$refs.form.resetFields();

    },
    validateConfirmPassword(rule, value, callback) {
      if (value === '') {
        callback(new Error('请确认新密码'));
      } else if (value !== this.form.newPassword) {
        callback(new Error('两次输入的新密码不一致'));
      } else {
        callback();
      }
    },
    submitForm(formName) {

      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http.post('/api/user/changePwd', this.form).then(res => {
            if (res.data.status === 200) {
              this.$message({ type: 'success', message: '修改密码成功' });
              this.dialogVisible = false;
            }
          })
        } else {
          return false;
        }
      });
    },
    logout() {
      localStorage.removeItem('token')
      localStorage.removeItem('exp')
      this.$router.push({ name: 'login' });
    }
  },
  mounted() {
    let tagsWidth = this.$refs.asideTop.offsetWidth - 100;
    this.maxTagNum = (tagsWidth / 100).toFixed(0)
  }
}
</script>

<style lang="scss" scoped>
.aside__top {
  border-bottom: 1px solid #e5e5e5;
  height: 45px;
  line-height: 45px;
  position: fixed;
  left: 200px;
  top: 0;
  right: 0;
  background: #fff;
  z-index: 1000;
  transition: left 0.25s;
  display: flex; // 添加这一行来启用 flexbox
  align-items: center; // 垂直居中子元素
  justify-content: space-between; // 让子元素在主轴上分布，首尾对齐
  padding: 0 10px; // 可选，为内部元素提供一些内边距

  .el-tag {
    margin-left: 10px;
  }

  .toggleNavCollapse {
    display: inline-block;
    margin-left: 8px;
    padding: 0 10px;
    font-size: 26px;
    vertical-align: middle;
    color: #333;
    cursor: pointer;
    transition: all 0.5s;

    &.active {
      transform: rotate(90deg);
    }
  }
}

.breadcrumb-enter,
.breadcrumb-leave-active {
  opacity: 0;
  transform: translateX(20px);
}

.breadcrumb-enter-active,
.breadcrumb-leave-active {
  transition: all 0.6s;
}

.breadcrumb-leave-active {
  position: absolute;
}

.popover-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;

  p {
    margin: 10px 0;
  }

  .el-button {
    margin: 5px 0;
  }
}
</style>
