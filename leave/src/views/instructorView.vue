<template>
<div>
  <el-breadcrumb separator="/">
  <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>系统设置</el-breadcrumb-item>
  <el-breadcrumb-item>辅导员管理</el-breadcrumb-item>
</el-breadcrumb>
<el-card class="box-card">
  <el-row :gutter="20">
    <el-col :span="50">
      <el-input placeholder="请输入内容" v-model="queryInfo.query" clearable @clear="getclasslist">
    <el-button slot="append" icon="el-icon-search" @click="getclasslist"></el-button>
  </el-input>
    </el-col>
     <el-col :span="4"><el-button type="primary" @click="addDialogVisible = true">添加辅导员</el-button>
     </el-col>
  </el-row>
    <el-table :data="classlist" style="width: 100%" border scripe>  
      <el-table-column type="index"></el-table-column>
      <el-table-column prop="insNo" label="辅导员编号" width="180"> </el-table-column>
      <el-table-column prop="insName" label="姓名"  width="180"></el-table-column>
      <el-table-column  prop="depId"  label="所属学院" width="180"> </el-table-column>
      <el-table-column  prop="telephone"  label="手机" width="180"> </el-table-column>
      <el-table-column    label="操作" >
        <template slot-scope="scope">
          <!-- 修改信息 -->
           <el-tooltip class="item" effect="dark" content="修改信息 " placement="top">
           <el-button type="primary" icon="el-icon-edit"  @click="showEditDialog(scope.row.insNo)"></el-button>
    </el-tooltip>
        <!-- 删除信息 -->
         <el-tooltip class="item" effect="dark" content="删除整行信息" placement="top">
   <el-button type="danger" icon="el-icon-delete" @click="removeclsId(scope.row.insNo)"></el-button>
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
<!-- 添加辅导员对话框 -->
<el-dialog title="添加辅导员" :visible.sync="addDialogVisible" width="50%"  @close="addDialogClosed">
    <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="100px" class="demo-ruleForm">
<el-form-item label="辅导员编号" prop="insNo">
    <el-input v-model="addForm.insNo"></el-input>
  </el-form-item>
  <el-form-item label="姓名" prop="insName">
    <el-input v-model="addForm.insName"></el-input>
  </el-form-item>
<el-form-item label="密码" prop="insPwd">
    <el-input v-model="addForm.insPwd"></el-input>
  </el-form-item>
  <el-form-item label="所属学院" prop="depId">
    <el-input v-model="addForm.depId"></el-input>
  </el-form-item>
  <el-form-item label="手机号" prop="telephone">
    <el-input v-model="addForm.telephone"></el-input>
  </el-form-item>
  </el-form>
  <span slot="footer" class="dialog-footer">
    <el-button @click="addDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addclass">确 定</el-button>
  </span>
</el-dialog>

<!-- 修改班级信息的对话框 -->
<el-dialog
  title="修改辅导员信息"  :visible.sync="editDialogVisible" width="50%">
 <el-form :model="editForm" :rules="editFormRules" ref="editFormRef" label-width="100px" >
  <el-form-item label="辅导员编号" prop="insNo" >
    <el-input v-model="editForm.insNo" disabled></el-input>
  </el-form-item> 
  <el-form-item label="姓名" prop="insName">
    <el-input v-model="editForm.insName"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="insPwd">
    <el-input v-model="editForm.insPwd"></el-input>
  </el-form-item>
  <el-form-item label="所属学院" prop="depId">
    <el-input v-model="editForm.depId"></el-input>
  </el-form-item>
  <el-form-item label="手机号" prop="telephone">
    <el-input v-model="editForm.telephone"></el-input>
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
         classlist:[],
         total:0,
         //控制添加对话框的显示与隐藏
         addDialogVisible: false,
         //添加班级的表达数据
         addForm:{
           insNo:'',
           insName:'',
           insPwd:'',
           depId:'',
           telephone:'',
           },
         //添加把表单的验证规则对象
         addFormRules:{
            insNo:[
             {required:true ,message:'请输入辅导员编号', rigger:'blur'}
           ],
            insName:[
             {required:true ,message:'请输入姓名', rigger:'blur'}
           ],
            insPwd:[
             {required:true ,message:'请输入密码', rigger:'blur'}
           ],
            depId:[
             {required:true ,message:'请输入所属学院', rigger:'blur'}
           ],
            telephone:[
             {required:true ,message:'请输入手机号', rigger:'blur'}
           ],
         },
         //控制修改对话框的显示与隐藏
         editDialogVisible:false,
         editForm:{},
         editFormRules:{
            clsId:[
             {required:true ,message:'请输入班级编号', rigger:'blur'}
           ],
            clsName:[
             {required:true ,message:'请输入班级名称', rigger:'blur'}
           ],
            insPwd:[
             {required:true ,message:'请输入密码', rigger:'blur'}
           ],
            clsMajor:[
             {required:true ,message:'请输入专业', rigger:'blur'}
           ],
            depId:[
             {required:true ,message:'请输入所属学院', rigger:'blur'}
           ],
            clsGrade:[
             {required:true ,message:'请输入年级', rigger:'blur'}
           ],
         } 
       }
     },
     created(){
        this.getclasslist()
     },
     methods:{
     async getclasslist(){
      const { data:res}=await this.$http.get('instructor',{
       params: this.queryInfo
        })
        console.log(res);
        if(res.code!=200) {
              return this.$message.error('获取失败');
        }
      this.classlist=res.body.rows 
      this.total=res.body.totalCount 
        console.log(res)
      },
      handleSizeChange(newSize){
         // console.log(newSize)
         this.queryInfo.pagesize=newSize
         this.getclasslist()
      },
      handleCurrentChange(newPage){
        //  console.log(newPage)
        this.queryInfo.pagenum=newPage
        this.getclasslist()
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
           const { data:res}=await this.$http.get('addinstructor',{
       params: this.addForm
        })
           console.log(res);
           if(res.code!=200){
            this.$message.error('添加辅导员信息失败')
           }
            this.$message.success('添加辅导员信息成功')
            this.addDialogVisible=false
        })
      },
      //修改弹框获取数据
    async showEditDialog(insNo){
      const { data:res}=await this.$http.post('sleeditinstructor',{insNo:insNo}) 
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
          const { data:res}=await this.$http.get('updainstructor',{
       params: this.editForm
        })
           console.log(res);
           if(res.code!=200){
            this.$message.error('修改辅导员信息失败')
           }
            this.$message.success('修改辅导员信息成功')
            this.editDialogVisible=false
        })
      },
    async removeclsId(insNo){
       console.log(insNo);
    const confirmResult = await this.$confirm('此操作将永久删除该辅导员信息, 是否继续?', '提示', {
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

         const { data:res}=await this.$http.post('deleteinstructor',{insNo:insNo}) 
          console.log(res)
         if(res.code!=200){
          return  this.$message.error('删除辅导员信息失败')
           }
           this.$message.success('删除成功！')
     }
     }
   }
</script>