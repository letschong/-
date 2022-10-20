<template>
<div>
  <el-breadcrumb separator="/">
  <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>请假管理</el-breadcrumb-item>
  <el-breadcrumb-item>请假情况统计</el-breadcrumb-item>
</el-breadcrumb>
<el-card class="box-card">
  <el-row :gutter="20">
    <el-col :span="50">
   <el-input placeholder="请输入查询班级" v-model="queryInfo.query" clearable @clear="getclasslist"></el-input>
      <el-date-picker
      v-model="queryInfo.startTime"
      type="date"
      placeholder="选择开始时间">
    </el-date-picker><br>
     <el-date-picker
      v-model="queryInfo.endTime"
      type="date"
      placeholder="选择结束时间">
    </el-date-picker>
    </el-col>
     <el-col :span="4"><el-button type="primary" @click="getclasslist">查询</el-button>
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
  
  </el-table>
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
           startTime:'',
           endTime:'',
         },
         classlist:[],
         
       }
     },
     created(){
        this.getclasslist()
     },
     methods:{
     async getclasslist(){
      const { data:res}=await this.$http.get('statistics',{
       params: this.queryInfo
        })
        console.log(res);
        if(res.code!=200) {
              return this.$message.error('获取失败');
        }
      this.classlist=res.body
        console.log(res)
      },
     
      
     
    
     
     }
     
      
     }
   
</script>