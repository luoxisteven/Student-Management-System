<template>
    <el-container style="min-height: 100vh;">
      <el-aside :width="sideWidth + 'px'" style="background-color: rgb(238, 241, 246); box-shadow: 2px 0 6px rga(0, 21, 41, 0.35) 2px 0px 6px ;">
        <Aside :isCollaspe="isCollaspe" :logoTextShow="logoTextShow" />
           <!-- 引用components.Aside,然后传入变量，再再Aside.vue里面加上pros -->
        <!-- </Aside> -->
      </el-aside>
      
      <el-container>

        <el-header style="border-bottom: 1px solid #ccc;">
          <Header :collapseBtnClass="collapseBtnClass" :collapse="isCollaspe"> </Header>
        </el-header>

        <el-main>
          <!-- 表示当前页面的子路由会在 router-view 里面展示 -->
            <router-view />
        </el-main>
      </el-container>
    </el-container>
</template>

<script>
// import request from '@/utils/request';
import { Collapse } from 'element-ui';
import Aside from "@/components/Aside"
import Header from "@/components/Header"


export default {
  name: 'HomeView',
  data(){ 
      return {
        // tableData: [],
        // total: 0, //在上面以"total"形式展示
        // pageNum: 1,
        // pageSize: 5,
        // username: "",
        // email: "",
        // address: "",
        // form: {},
        // logoTextShow: true,
        // dialogFormVisible: false,

        logoTextShow: true,
        collapseBtnClass: 'el-icon-s-fold',
        isCollaspe: false,
        sideWidth: 200,
      }
  },
  // created(){
  //     this.load()
  // },
  components:{
    Aside,
    Header
  },
  methods: {
    collapse(){
      this.isCollaspe =! this.isCollaspe;
      if(this.isCollaspe){
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false
      } else{
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = true
      }
    },
    //   // 请求分页查询数据
    //   load(){  //http://localhost:9090 (在request.js那里设置了默认，就省略)
    //     this.request.get("/user/page", {
    //       params:{
    //         pageNum: this.pageNum,
    //         pageSize: this.pageSize,
    //         username: this.username,
    //         email: this.email,
    //         address: this.address
    //       }
    //     }).then(res=>{
    //       this.dialogFormVisible = false
    //       this.tableData = res.records
    //       this.total = res.total
    //     })
    //   // 不用axios
    //   //   fetch("http://localhost:9090/user/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&username="+this.username+"&email="+this.email+"&address="+this.address).then(res => res.json()).then(res=>{
    //   //     //console.log(res)
    //   //     this.tableData = res.records //MyBatis-plus
    //   //     // this.tableData = res.data //MyBatis
    //   //     this.total = res.total
    //   // })
    // },
    // reset(){
    //   this.username = ""
    //   this.email = ""
    //   this.address = ""
    //   this.load()
    // },
    // saveUser(){ //http://localhost:9090 (在request.js那里设置了默认，就省略)
    //   this.request.post("/user", this.form).then(res=>{
    //     if(res){
    //         this.$message.success("保存成功")
    //         this.dialogFormVisible = false
    //         this.load()
    //     } else{
    //       this.$message.error("保存失败")
    //     }
    //   })
    // },
    // handleAdd(){
    //     this.dialogFormVisible = true
    //     this.form = {}
    // },
    // handleEdit(row){
    //     this.form = row
    //     this.dialogFormVisible = true
  
    // },
    // handleCancel(){
    //   this.dialogFormVisible = false
    //   this.load()
    // },
    // handleDelete(id){
    //   this.request.delete("/user/"+id).then(res=>{
    //     if(res){
    //         this.$message.success("删除成功")
    //         this.load()
    //     } else{
    //       this.$message.error("删除失败")
    //     }
    //   })
    // },
    // handleSizeChange(pageSize){
    //     //console.log(res)
    //     this.pageSize = pageSize
    //     this.load()
    // },
    // handleCurrentChange(pageNum){
    //     //console.log(res)
    //     this.pageNum = pageNum
    //     this.load()
    // },
    // handleSelectionChange(val){
    //   this.multipleSelection = val
    // },
    // deleteBatch(){
    //   let ids = this.multipleSelection.map(v => v.id) //[{}, {}, {}] => [1,2,3] 
    //   this.request.post("/user/del/batch", ids).then(res=>{
    //     if(res){
    //         this.$message.success("批量删除成功")
    //         this.load()
    //     } else{
    //       this.$message.error("批量删除失败")
    //     }
    //   })
    // },
  }
}
</script>

<!-- <style>
.headerBg{
  background: #eee !important;
}

</style> -->