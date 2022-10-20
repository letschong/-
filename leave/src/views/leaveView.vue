<template>
<div>
  <el-breadcrumb separator="/">
  <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>请假管理</el-breadcrumb-item>
  <el-breadcrumb-item>填写请假条</el-breadcrumb-item>
</el-breadcrumb>
<el-card class="box-card">
  <el-row :gutter="20">
    <el-col :span="50">
      <el-input placeholder="请输入内容" v-model="queryInfo.query" clearable @clear="getclasslist">
    <el-button slot="append" icon="el-icon-search" @click="getclasslist"></el-button>
  </el-input>
    </el-col>
     <el-col :span="4"><el-button type="primary" @click="addDialogVisible = true">请假申请</el-button>
     </el-col>
  </el-row>
   <el-table :data="classlist"   style="width: 100%" border>
    <el-table-column type="expand" >
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="请假单号">
            <span>{{ props.row.leaveNo }}</span>
          </el-form-item><br>
          <el-form-item label="请假类型">
            <span>{{ props.row.types }}</span>
          </el-form-item><br>
          <el-form-item label="事由">
            <span>{{ props.row.reason }}</span>
          </el-form-item><br>
          <el-form-item label="开始时间">
            <span>{{ props.row.startTime }}</span>
          </el-form-item><br>
          <el-form-item label="结束时间">
            <span>{{ props.row.endTime }}</span>
          </el-form-item><br>
          <el-form-item label="请假天数">
            <span>{{ props.row.days }}</span>
          </el-form-item><br>
          <el-form-item label="辅导员编号">
            <span>{{ props.row.insNo }}</span>
          </el-form-item><br>
            <el-form-item label="辅导员姓名">
            <span>{{ props.row.insName }}</span>
          </el-form-item><br>
             <el-form-item label="辅导员电话">
            <span>{{ props.row.telephone }}</span>
          </el-form-item><br>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column
      label="姓名"
      prop="stuName">
    </el-table-column>
    <el-table-column
      label="学号"
      prop="stuNo">
    </el-table-column>
    <el-table-column
      label="请假开始时间"
      prop="createTime">
    </el-table-column>
    <el-table-column
      label="状态"
      prop="flag">
    </el-table-column>
     <el-table-column
      label="状态"
      prop="flag">
      <template slot-scope="scope">
        <!-- 撤回请假申请请假信息 -->
         <el-tooltip class="item" effect="dark" content="撤回请假申请" placement="top">
   <el-button type="danger" icon="el-icon-delete" @click="removeclsId(scope.row.stuNo,scope.row.startTime)"></el-button>
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
<!-- 请假申请对话框 -->
<el-dialog title="请假申请" :visible.sync="addDialogVisible" width="50%"  @close="addDialogClosed">
    <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="100px" class="demo-ruleForm">
<el-form-item label="学号" prop="addForm.stuNo">
    <el-input v-model="addForm.stuNo" disabled></el-input>
  </el-form-item>
   <el-select v-model="addForm.types" clearable placeholder="请选择请假类型">
    <el-option 
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value" prop="types">
    </el-option>
  </el-select>
<el-form-item label="事由" prop="reason">
    <el-input v-model="addForm.reason"></el-input>
  </el-form-item>
    <el-date-picker
      v-model="addForm.startTime"
      type="datetime"
      prop="startTime"
      placeholder="选择开始时间">
    </el-date-picker><br>
    <el-date-picker
      v-model="addForm.endTime"
      type="datetime"
      prop="endTime"
      placeholder="选择结束时间">
    </el-date-picker>
  <el-form-item label="辅导员编号" prop="insNo">
    <el-input v-model="addForm.insNo"></el-input>
  </el-form-item>
  </el-form>
  <span slot="footer" class="dialog-footer">
    <el-button @click="addDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addclass">确 定</el-button>
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
            options: [{
          value: '事假',
          label: '事假'
        }, {
          value: '病假',
          label: '病假'
        }],
        value: '',
         queryInfo:{
           query:'',
           pagenum:1,
           pagesize:2,
           userid:''
         },
         classlist:[],
         total:0,
         //控制添加对话框的显示与隐藏
         addDialogVisible: false,
         //添加班级的表达数据
         addForm:{
           stuNo:'',
           types:'',
           reason:'',
           startTime:'',
           endTime:'',
           insNo:'',
           },
         //添加把表单的验证规则对象
         addFormRules:{
             stuNo:[
             {required:true ,message:'请输入学号', rigger:'blur'}
           ],
            types:[
             {required:true ,message:'请选择请假类型', rigger:'blur'}
           ],
            reason:[
             {required:true ,message:'请输入请假事由', rigger:'blur'}
           ],
            startTime:[
             {required:true ,message:'请输入请假开始时间', rigger:'blur'}
           ],
            endTime:[
             {required:true ,message:'请输入请假结束时间', rigger:'blur'}
           ],
            insNo:[
             {required:true ,message:'请输入辅导员编号', rigger:'blur'}
           ],
         },
       
       }
     },
     created(){
        this.getclasslist()
     },
     methods:{
     async getclasslist(){
          this.addForm.stuNo = window.sessionStorage.getItem("userid");
            this.queryInfo.userid = window.sessionStorage.getItem("userid");
      const { data:res}=await this.$http.get('leave',{
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
           const { data:res}=await this.$http.get('addleave',{
       params: this.addForm
        })
           console.log(res);
           if(res.code!=200){
            this.$message.error('请假失败')
           }
            this.$message.success('请假成功')
            this.addDialogVisible=false
        })
      },
    async removeclsId(stuNo,startTime){
       console.log(stuNo,startTime);
    const confirmResult = await this.$confirm('此操作将会撤回请假申请信息, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).catch(err => err)
        //如果确定删除，返回confirm
        ///如果取消删除，返回cancel
        console.log(confirmResult);
        if(confirmResult!='confirm'){
          return  this.$message.info('已经取消撤回请假申请信息')
        }

         const { data:res}=await this.$http.post('updaleave',{stuNo:stuNo,startTime:startTime}) 
          console.log(res)
         if(res.code!=200){
          return  this.$message.error('撤回请假申请信息失败')
           }
           this.$message.success('撤回请假信息成功！')
     }
     }
   }
</script>