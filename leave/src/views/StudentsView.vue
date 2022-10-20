<template>
<div>
  <el-breadcrumb separator="/">
  <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>系统设置</el-breadcrumb-item>
  <el-breadcrumb-item>学生管理</el-breadcrumb-item>
</el-breadcrumb>
<el-card class="box-card">
  <el-row :gutter="20">
    <el-col :span="50">
      <el-input placeholder="请输入内容" v-model="queryInfo.query" clearable @clear="getstudenslist">
    <el-button slot="append" icon="el-icon-search" @click="getstudenslist"></el-button>
  </el-input>
    </el-col>
     <el-col :span="4"><el-button type="primary" @click="addDialogVisible = true">添加学生</el-button>
     </el-col>
  </el-row>
    <el-table :data="studentslist" style="width: 100%" border scripe>  
      <el-table-column type="index"></el-table-column>
      <el-table-column prop="stuNo" label="学号" width="180"> </el-table-column>
      <el-table-column prop="stuName" label="姓名"  width="180"></el-table-column>
      <el-table-column  prop="stuSex"  label="性别" width="180"> </el-table-column>
      <el-table-column  prop="clsId"  label="班级编号" width="180"> </el-table-column>
      <el-table-column    label="操作" >
        <template slot-scope="scope">
          <!-- 修改信息 -->
           <el-tooltip class="item" effect="dark" content="修改信息 " placement="top">
           <el-button type="primary" icon="el-icon-edit"  @click="showEditDialog(scope.row.stuNo)"></el-button>
    </el-tooltip>
        <!-- 删除信息 -->
         <el-tooltip class="item" effect="dark" content="删除整行信息" placement="top">
   <el-button type="danger" icon="el-icon-delete" @click="removeclsId(scope.row.stuNo)"></el-button>
    </el-tooltip>
       
        </template>
         </el-table-column>
    </el-table>
  <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="queryInfo.pagenum"
      :page-sizes="[1, 2, 5, 10]"
      :page-size="queryInfo.pagesize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
    
</el-card>
<!-- 添加班级对话框 -->
<el-dialog title="添加学生" :visible.sync="addDialogVisible" width="50%"  @close="addDialogClosed">
    <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="100px" class="demo-ruleForm">
<el-form-item label="学号" prop="stuNo">
    <el-input v-model="addForm.stuNo"></el-input>
  </el-form-item>
  <el-form-item label="姓名" prop="stuName">
    <el-input v-model="addForm.stuName"></el-input>
  </el-form-item>
<el-form-item label="性别" prop="stuSex">
    <el-input v-model="addForm.stuSex"></el-input>
  </el-form-item>
  <el-form-item label="班级编号" prop="clsId">
    <el-input v-model="addForm.clsId"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="stuPwd">
    <el-input v-model="addForm.stuPwd"></el-input>
  </el-form-item>
  </el-form>
  <span slot="footer" class="dialog-footer">
    <el-button @click="addDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addclass">确 定</el-button>
  </span>
</el-dialog>

<!-- 修改班级信息的对话框 -->
<el-dialog
  title="修改班级信息"  :visible.sync="editDialogVisible" width="50%">
 <el-form :model="editForm" :rules="editFormRules" ref="editFormRef" label-width="100px" >
  <el-form-item label="学号" prop="stuNo" >
    <el-input v-model="editForm.stuNo" disabled></el-input>
  </el-form-item> 
  <el-form-item label="姓名" prop="stuName">
    <el-input v-model="editForm.stuName"></el-input>
  </el-form-item>
<el-form-item label="性别" prop="stuSex">
    <el-input v-model="editForm.stuSex"></el-input>
  </el-form-item>
  <el-form-item label="班级编号" prop="clsId">
    <el-input v-model="editForm.clsId"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="stuPwd">
    <el-input v-model="editForm.stuPwd"></el-input>
  </el-form-item>
  </el-form>
  <span slot="footer" class="dialog-footer">
    <el-button @click="editDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="editclassInfo">确 定</el-button>
  </span>
</el-dialog>
</div>
</template>
<style>
.el-breadcrumb{
  margin-bottom: 30px;
}
  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 100%px;
  }
  .el-table{
  margin-top: 15px;
}
.el-pagination{
  margin-top: 15px;
}
.el-tooltip{
  width:100px;
}
</style>
<script>
   export default{
     data(){
       return{
         queryInfo:{
           query:'',
           pagenum:1,
           pagesize:2
         },
         studentslist:[],
         total:0,
         //控制添加对话框的显示与隐藏
         addDialogVisible: false,
         //添加班级的表达数据
         addForm:{
           stuNo:'',
           stuName:'',
           stuSex:'',
           clsId:'',
           },
         //添加把表单的验证规则对象
         addFormRules:{
            stuNo:[
             {required:true ,message:'请输入学号', rigger:'blur'}
           ],
            stuName:[
             {required:true ,message:'请输入姓名', rigger:'blur'}
           ],
            stuSex:[
             {required:true ,message:'请输入性别', rigger:'blur'}
           ],
            clsId:[
             {required:true ,message:'请输入班级', rigger:'blur'}
           ],
            stuPwd:[
             {required:true ,message:'请输入密码', rigger:'blur'}
           ],
         },
         //控制修改对话框的显示与隐藏
         editDialogVisible:false,
         editForm:{},
         editFormRules:{
            stuNo:[
             {required:true ,message:'请输入学号', rigger:'blur'}
           ],
            stuName:[
             {required:true ,message:'请输入姓名', rigger:'blur'}
           ],
            stuSex:[
             {required:true ,message:'请输入性别', rigger:'blur'}
           ],
            clsId:[
             {required:true ,message:'请输入班级', rigger:'blur'}
           ],
            stuPwd:[
             {required:true ,message:'请输入密码', rigger:'blur'}
           ],
         } 
       }
     },
     created(){
        this.getstudenslist()
     },
     methods:{
     async getstudenslist(){
      const { data:res}=await this.$http.get('students',{
       params: this.queryInfo
        })
        console.log(res);
        if(res.code!=200) {
              return this.$message.error('获取失败');
        }
      this.studentslist=res.body.rows 
      this.total=res.body.totalCount 
        console.log(res)
      },
      handleSizeChange(newSize){
         // console.log(newSize)
         this.queryInfo.pagesize=newSize
         this.getstudenslist()
      },
      handleCurrentChange(newPage){
        //  console.log(newPage)
        this.queryInfo.pagenum=newPage
        this.getstudenslist()
      },
      //监听添加班级用户对话框的关闭事件
      addDialogClosed(){
          this.$refs.addFormRef.resetFields()
      },
      //添加班级信息并提交
      addclass(){
        this.$refs.addFormRef.validate(async valid =>{
         // console.log(valid)
          if(!valid) return
           const { data:res}=await this.$http.get('addstudents',{
       params: this.addForm
        })
           console.log(res);
           if(res.code!=200){
            this.$message.error('添加学生信息失败')
           }
            this.$message.success('添加学生信息成功')
            this.addDialogVisible=false
        })
      },
      //修改弹框获取数据
    async showEditDialog(stuNo){
      const { data:res}=await this.$http.post('sleeditstudents',{stuNo:stuNo}) 
      console.log(res)
      if(res.code!=200){
            this.$message.error('查询失败')
           }
           this.editForm =res.body[0]
           console.log(this.editForm);
             this.editDialogVisible=true  
      },
      //修改信息并提交
      editclassInfo(){
           this.$refs.editFormRef.validate(async valid =>{
         console.log(valid)
          if(!valid) return
          const { data:res}=await this.$http.get('updastudents',{
       params: this.editForm
        })
           console.log(res);
           if(res.code!=200){
            this.$message.error('修改学生信息失败')
           }
            this.$message.success('修改学生信息成功')
            this.editDialogVisible=false
        })
      },
    async removeclsId(stuNo){
       console.log(stuNo);
    const confirmResult = await this.$confirm('此操作将永久删除该学生信息, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).catch(err => err)
        //如果确定删除，返回confirm
        ///如果取消删除，返回cancel
        console.log(confirmResult);
        if(confirmResult!='confirm'){
          return  this.$message.info('已经取消删除')
        }

         const { data:res}=await this.$http.post('deletestudents',{stuNo:stuNo}) 
          console.log(res)
         if(res.code!=200){
          return  this.$message.error('删除学生信息失败')
           }
           this.$message.success('删除成功！')
     }
     }
   }
</script>