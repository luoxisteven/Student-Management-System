<template>
    <div style="font-size: 12px; line-height: 60px; display: flex;">
        <div style="flex: 1; font-size: 20px">
            <span :class="collapseBtnClass" style="cursor: pointer; font-size: 18px"@click="collapse"></span>
            <el-breadcrumb separator="/" style="display: inline-block; margin-left:10px" >
              <el-breadcrumb-item :to="'/'" >首页</el-breadcrumb-item>
              <el-breadcrumb-item >{{currentPathName}}</el-breadcrumb-item>
              <!-- <el-breadcrumb-item>用户管理</el-breadcrumb-item> -->
            </el-breadcrumb>

            <div style="margin-bottom: 10px" >
          </div>

          <el-form :rules="rules">
            
          </el-form>

          </div>

          <el-dropdown style="width: 70px; cursor: pointer">
            <span>王小虎</span><i class="el-icon-arrow-down" style="margin-left: 5px;"></i>
            <el-dropdown-menu slot="dropdown" style="width: 80px; text-align: center;">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>
                <router-link to="/login" style="text-decoration: none">退出</router-link>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
    </div>
</template>

<script>
export default {
  name: "Header",
  props:{
    collapseBtnClass: String,
    collapse: Boolean,
  },
  computed:{
    currentPathName(){
      return this.$store.state.currentPathName
    }
  },
  watch:{
    currentPathName(newVal, oldVal){
      console.log(newVal)
    }
  },
  // data(){
  //   return{
  //     currentPathName: ''
  //   }
  // },
}
</script>

<style scoped>

</style>