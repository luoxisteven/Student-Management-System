<template>
    <div>
          <div style="padding: 10px 0;">
              <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="username"></el-input>
              <el-input style="width: 200px" placeholder="请输入邮箱" suffix-icon="el-icon-message" v-model="email"></el-input>
              <el-input style="width: 200px" placeholder="请输入地址" suffix-icon="el-icon-location" v-model="address"></el-input>
              <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
              <el-button class="ml-5" type="warning" @click="reset">重置</el-button>
          </div>          

          <div style="margin: 10px 0;">
              <el-button type="primary" @click="handleAdd" class="ml-5">新增 <i class="el-icon-circle-plus-outline"></i> </el-button>
              <el-popconfirm
                  class="ml-5"
                  confirm-button-text='确定'
                  cancel-button-text='取消'
                  icon="el-icon-info"
                  icon-color="red"
                  title="您确定批量删除吗？"
                  @confirm="deleteBatch"
                >
              <el-button type="danger" slot="reference">批量删除 <i class="el-icon-remove-outline"></i> </el-button>
            </el-popconfirm>

              <el-upload
                action="http://localhost:9090/user/import" :show-file-list="false" accept="xlsx" :on-success="handleImportSuccess" style="display: inline-block">
                <el-button type="primary" class="ml-5">导入 <i class="el-icon-bottom"></i> </el-button>
              </el-upload>

              <el-button type="primary" class="ml-5" @click="exp">导出 <i class="el-icon-top"></i> </el-button> 
          </div>

          <el-table :data="tableData" border stripe header-cell-class-name="headerBg" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="id" label="ID" width="80"></el-table-column>
            <el-table-column prop="username" label="用户名" width="120"></el-table-column>
            <el-table-column prop="nickname" label="昵称" width="120"></el-table-column>
            <el-table-column prop="email" label="邮箱"></el-table-column>
            <el-table-column prop="phone" label="电话"></el-table-column>
            <el-table-column prop="address" label="地址"></el-table-column>
            <el-table-column>
              <template slot-scope="scope">
                 <!-- scope.row可以获取行的数据 -->
                <el-button type="success" @click="handleEdit(scope.row)">编辑  <i class="el-icon-edit"></i> </el-button>
                <el-popconfirm
                  class="ml-5"
                  confirm-button-text='确定'
                  cancel-button-text='取消'
                  icon="el-icon-info"
                  icon-color="red"
                  title="您确定删除吗？"
                  @confirm="handleDelete(scope.row.id)"
                >
                <el-button type="danger" slot="reference">删除  <i class="el-icon-remove-outline"></i> </el-button> 
              </el-popconfirm>
              </template>
            </el-table-column>
      
          </el-table>
          <!-- 分页查询 -->
          <div style="padding: 10px 0">
            <el-pagination
              @size-change="handleSizeChange" 
              @current-change="handleCurrentChange"
              :page-sizes="[5, 10, 20, 50]"
              :page-size="pageSize"
              :current-page="pageNum"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
            </el-pagination>
          </div>

          <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="30%">
            <el-form label-width="80px">
              <el-form-item label="用户名">
                <el-input v-model="form.username" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="昵称">
                <el-input v-model="form.nickname" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="邮箱">
                <el-input v-model="form.email" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="电话">
                <el-input v-model="form.phone" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="地址">
                <el-input v-model="form.address" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="handleCancel">取 消</el-button>
              <el-button type="primary" @click="saveUser">确 定</el-button>
            </div>
          </el-dialog>
    </div>
</template>

<script>
export default {
    name: "User",
    data(){
        return{
            tableData: [],
            multipleSelection: [],
            total: 0, //在上面以"total"形式展示
            pageNum: 1,
            pageSize: 5,
            username: "",
            email: "",
            address: "",
            form: {},
            dialogFormVisible: false,
        }
},
created(){
      this.load()
  },
methods: {
          // 请求分页查询数据
    load(){  //http://localhost:9090 (在request.js那里设置了默认，就省略)
        this.request.get("/user/page", {
          params:{
            pageNum: this.pageNum,
            pageSize: this.pageSize,
            username: this.username,
            email: this.email,
            address: this.address
          }
        }).then(res=>{
          this.dialogFormVisible = false
          this.tableData = res.records
          this.total = res.total
        })
      // 不用axios
      //   fetch("http://localhost:9090/user/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&username="+this.username+"&email="+this.email+"&address="+this.address).then(res => res.json()).then(res=>{
      //     //console.log(res)
      //     this.tableData = res.records //MyBatis-plus
      //     // this.tableData = res.data //MyBatis
      //     this.total = res.total
      // })
    },
    reset(){
      this.username = ""
      this.email = ""
      this.address = ""
      this.load()
    },
    saveUser(){ //http://localhost:9090 (在request.js那里设置了默认，就省略)
      this.request.post("/user", this.form).then(res=>{
        if(res){
            this.$message.success("保存成功")
            this.dialogFormVisible = false
            this.load()
        } else{
          this.$message.error("保存失败")
        }
      })
    },
    handleAdd(){
        this.dialogFormVisible = true
        this.form = {}
    },
    handleEdit(row){
        this.form = row
        this.dialogFormVisible = true
  
    },
    handleCancel(){
      this.dialogFormVisible = false
      this.load()
    },
    handleDelete(id){
      this.request.delete("/user/"+id).then(res=>{
        if(res){
            this.$message.success("删除成功")
            this.load()
        } else{
          this.$message.error("删除失败")
        }
      })
    },
    handleImportSuccess(){
      this.$message.success("导入成功")
      this.load()
    },
    handleSizeChange(pageSize){
        //console.log(res)
        this.pageSize = pageSize
        this.load()
    },
    handleCurrentChange(pageNum){
        //console.log(res)
        this.pageNum = pageNum
        this.load()
    },
    handleSelectionChange(val){
      this.multipleSelection = val
    },
    deleteBatch(){
      let ids = this.multipleSelection.map(v => v.id) //[{}, {}, {}] => [1,2,3] 
      this.request.post("/user/del/batch", ids).then(res=>{
        if(res){
            this.$message.success("批量删除成功")
            this.load()
        } else{
          this.$message.error("批量删除失败")
        }
      })
    },
    exp(){
      window.open("http://localhost:9090/user/export")
    },
}

}

</script>

<style>
.headerBg{
  background: #eee !important;
}
</style>