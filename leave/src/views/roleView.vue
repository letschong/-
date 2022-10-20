<template>
<div>
    <el-breadcrumb separator="/">
  <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>系统设置</el-breadcrumb-item>
  <el-breadcrumb-item>权限管理</el-breadcrumb-item>
</el-breadcrumb>
<el-card class="box-card">
   <el-table :data="classlist"  @expand-change="getalist"   border stripe>
    <el-table-column  type="expand" >    
     <template slot-scope="scope">
        <el-row :class="['bdbottom',i1==0?'bdtop':'']" v-for="(item1,i1) in alist" :key="item1.id"  >
            <!-- 渲染一级列表 -->
            <el-col :span="5">
                   <el-tag  closable @close="removerolesId(item1.psid,scope.row.id)"> {{item1.psName}}</el-tag>
                    <i class="el-icon-caret-right"></i>
            </el-col>
            <!-- 渲染二级列表 -->
             <el-col :span="19">
                 <el-row v-for="(item2) in item1.children"   :key="item2.id" >
                   <el-cok>
                       <el-tag  closable @close="removerolesId(item2.psid,scope.row.id)">{{item2.psName}}</el-tag>    
                            <i class="el-icon-caret-right"></i>
                   </el-cok>
                 </el-row>
             </el-col>
        </el-row>
     </template>
    </el-table-column>
    <el-table-column   label="id"   prop="id">  </el-table-column>
    <el-table-column  label="名称" prop="rolesname"> </el-table-column>
    <el-table-column  label="描述"  prop="rolesdescribe"></el-table-column>
    <el-table-column label="分配权限">
        <template slot-scope="scope">
 <el-tooltip class="item" effect="dark" content="分配权限 " placement="top">
           <el-button type="primary" icon="el-icon-edit"  @click="showSetRighteditDialog(scope.row.id)"></el-button>
            </el-tooltip>
        </template>
    </el-table-column>
  </el-table>
  
</el-card>
<el-dialog title="分配权限" :visible.sync="setroledialogVisible" width="50%" @close="setRightdialogclosed">
  <el-tree :data="rolelist" :props="treeProps" show-checkbox node-key="psid" default-expand-all :default-expanded-keys="defKeys" ref="treeRef" ></el-tree>
  <span slot="footer" class="dialog-footer">
    <el-button @click="setroledialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="allRights">确 定</el-button>
  </span>
</el-dialog>
</div>
</template>
<style scope>
.el-row{
    size:100px;
}
.el-tag{
    margin:7px;
}
.bdtop{
    border-top:1px solid #eee
}
.bdbottom{
     border-bottom:1px solid #eee
}
</style>
<script>
import qs from 'qs'
   export default{
     data(){
       return{
       classlist:[],
         alist:[],
         //控制添加对话框的显示与隐藏
         setroledialogVisible: false,
         rolelist:[],
        treeProps:{
            label:'psName',
            children:'children',
          
        },
        //默认选择psid值 
        defKeys:[],
       roleid:'',
       }
     },
     created(){
        this.getclasslist() 
     },
     methods:{
     async getclasslist(){
      const { data:res}=await this.$http.get('rolezz')
        console.log(res);
        if(res.code!=200) {
              return this.$message.error('获取失败');
        }
      this.classlist=res.body
        console.log(res)
      },
   async  getalist(row,expandedRows ){
       console.log(row.id)
       console.log(expandedRows )
        const { data:res}=await this.$http.post('meuns',{id:row.id})
        console.log(res);
        if(res.code!=200) {
              return this.$message.error('获取失败');
        }
      this.alist=this.transListToTreeData(res.body,0)
      console.log(this.alist);
        console.log(res)
     },
       transListToTreeData(list, RootValue) {
            let arr = [];
            list.forEach((item) => {
                //如果数据对象的pid为 '' 说明数据为根节点
                if (item.psPid == RootValue) {
                let children = this.transListToTreeData(list, item.psid); //寻找id等于该对象pid的数据，为它的子节点,返回一个数组
                if (children.length) {
                    item.children = children; //往对象添加一个children属性，属性值为一个数组
                }
                arr.push(item);
                }
            });
            return arr;
            
        },
         async  removerolesId(psid,id){
            console.log(psid)
         console.log(id)
    const confirmResult = await this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).catch(err => err)
        //如果确定删除，返回confirm
        ///如果取消删除，返回cancel
        console.log(confirmResult)
        if(confirmResult!='confirm'){
          return  this.$message.info('已经取消删除')
        }

         const { data:res}=await this.$http.post('deletemenu',{psid:psid,id:id}) 
          console.log(res)
         if(res.code!=200){
          return  this.$message.error('删除失败')
           }
           this.$message.success('删除成功！')
     },
    async showSetRighteditDialog(id){
       this.roleid = id
       console.log(this.roleid);
         //获取所有权限数据
          const { data:res}=await this.$http.post('meun')
        console.log(res);
        if(res.code!=200) {
              return this.$message.error('获取失败');
        }
        this.rolelist=this.transListToTreeData(res.body,0)
        console.log(this.rolelist)
        console.log(this.defKeys);
      this.setroledialogVisible=true 
     },
      setRightdialogclosed(){
           this.defkeys =[]
       },
         async allRights(){
          const keys=[
             ...this.$refs.treeRef.getCheckedKeys(),
              ...this.$refs.treeRef.getHalfCheckedKeys()
          ]
          console.log(keys);
          const psid=qs.stringify({psid:keys},{indices:false})
         console.log(psid,this.roleid);
      const {data:res} = await this.$http.get('addrole?'+psid+'&&id='+this.roleid)
         this.alist
             if(res.code == 200){ 
             this.setroledialogVisible=false;
             return this.$message.success('分配权限成功')
         }
         else{
             return this.$message.error('分配失败')
         }
     }
   }
   }
</script>