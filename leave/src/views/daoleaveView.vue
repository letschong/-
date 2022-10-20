<template>
<div>
  <el-breadcrumb separator="/">
  <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>请假管理</el-breadcrumb-item>
  <el-breadcrumb-item>导出请假名单</el-breadcrumb-item>
</el-breadcrumb>
<el-card class="box-card">
     <download-excel
          class="export-excel-wrapper"
          :data="classlist"
          type="xls"
          worksheet="My Worksheet"
          name="请假信息"
          >
      <el-button  @click="getleaveList">导出请假名单</el-button> 
      </download-excel>
  
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
           stuNo:'',
           types:'',
           reason:'',
           startTime:'',
           endTime:'',
           insNo:'',
           },
       
       }
     },
     created(){
        this.getclasslist()
     },
     methods:{
     async getclasslist(){
      const { data:res}=await this.$http.get('daoleave',{
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
    
     
    
    
     }
     
      
     }
   
</script>