<template>
    
        <el-menu :default-openeds="['1', '3']" style="min-height: 100%; overflow-x: hidden;"
                    background-color="rgb(48, 65, 86)"
                    text-color="#fff"
                    active-text-color="#ffd04b"
                    :collapse-transition="false"
                    :collapse="isCollaspe"
                    router 
        >
        <!-- router可以根据index进行路由 -->
        <div style="height: 60px; line-height: 60px; text-align: center;">
            <img src="../assets/logo.png" alt="" style="width: 20px; position: relative; top:5px; margin-right: 5px;">
            <b style="color:white" v-show="logoTextShow">后台管理系统</b>
        </div>
            <!-- router可以根据index进行路由, 比方说这里的index -->
            <el-menu-item index="/home">
            <template slot="title">
                <i class="el-icon-house"></i>
                <span slot="title">主页</span>
            </template>
            </el-menu-item>

            <el-submenu index="1">
            <template slot="title"><i class="el-icon-menu"></i>
                <span slot="title">系统管理</span>
            </template>
            <el-menu-item index="/user"><i class="el-icon-s-custom"></i>
                用户管理</el-menu-item>
            </el-submenu>

        </el-menu>
</template>
  

<script>
export default {
    name: "Aside",
    // 这里引用
    props: {
        msg: String,
        isCollaspe: Boolean,
        logoTextShow: Boolean,
    },
    methods: { 
        // handleSelect(index){
        //      this.$route.fullPath.split("/")
        // }
    }
}
</script>

<style scoped>

</style>