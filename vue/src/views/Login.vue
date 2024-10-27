<template>
    <div class="wrapper">
  
    <div style="margin: 200px auto; background-color: #fff; width: 350px; height: 300px; padding: 20px; border-radius: 10px">
    <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>登录</b></div>

    <!-- 下面有Rules, 这个model和下面的v-model一样的(user.username)和下面data()的user也一致-->
        <!-- 通过userForm获取表单 -->
    <el-form :model="user" :rules="rules" ref="userForm"> 

    <el-form-item prop="username">
    <el-input prop="name" size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>
    </el-form-item>
    
    <el-form-item prop="password">
    <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
    </el-form-item>

    </el-form>

    <div style="margin: 10px 0; text-align: right">
    <el-button type="primary" size="small" autocomplete="off" @click="valid">登录</el-button>
    <el-button type="warning" size="small" autocomplete="off">注册</el-button>
    </div>
    </div>
</div>
</template>
  
<script>
export default {
    name: "Login",
    data() {
        return {
            user: {},
            rules: {
                username: [
                    {required: true, message: "请输入用户名", trigger: "blur"},
                    {min: 3, max: 10, message: "长度在 3 到 5 个字符", trigger: "blur"}
                ],
                password:[
                    {required: true, message: "请输入密码", trigger: "blur"},
                    {min: 6, max: 10, message: "长度在 3 到 5 个字符", trigger: "blur"}
                ]
            }
        }
    },
    methods:{
        // 这里valid用上面rules的规则，如果符合则调用login到后台
        valid(){
            this.$refs["userForm"].validate((valid)=>{
                if (valid){
                    this.login();
                } else{
                    return false;
                }
                
        })
        },
        login(){
             this.request.post("user/login", this.user).then(res =>{
                if(!res){
                    this.$message("用户名或密码错误");
                } else{
                    this.$router.push("/") //跳到主页面
                }
             })
        }
    }
}
</script>

<style>
  .wrapper {
    height: 100vh;
    background-image: linear-gradient(to bottom right, #FC466B, #3F5EFB);
    overflow: hidden;
  }
</style>