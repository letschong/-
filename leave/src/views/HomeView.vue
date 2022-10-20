<template>
    <el-container style="height: 1000px; border: 1px solid #eee">
      <!--头部区-->
  <el-header>
    <div>
      <img src="" alt="">
      <span>学生请假信息管理系统</span>
    </div>
    <el-button type="danger"  @click="logout">退出</el-button> 
  </el-header>
  
  <!--侧边栏-->
  <el-container>
    <el-aside width="200px" height="1000px">
      <!--菜单区-->
      <el-menu background-color="#373741" text-color="#fff" active-text-color="#409BFF" :router="true">
      
      <el-submenu :index="item.psid+''" v-for="item in menuList" :key="item.psid">
        <template slot="title">
          
          <span> {{item.psName}}</span>
        </template>
      <el-menu-item :index="subItem.path" v-for="subItem in item.children" :key="subItem.psid">
        <span>{{subItem.psName}}</span>
      </el-menu-item>
      
        </el-submenu>
    

      
     
      
    </el-menu>
    </el-aside>
    <el-main>
      <router-view></router-view>
    </el-main>
    <!--主体区--> 
  </el-container>
</el-container>

</template>
<style>
.el-header {
    background-color: #373d41;
    line-height: 60px;
      display:flex;
      justify-content:space-between;
      padding-left:0;
      color:#fff;
      font-size:20px;
  }
  
  .el-aside {
   background-color: #333744;
  }
  .el-main{
background-color: #EAEDF1;
  }

  
</style>

<script>
  export default {
    data(){
      return{
      menuList:[]
      }
    },
    created(){
      this.getMenulist()
    },
  
    methods: {
      logout(){
      window.sessionStorage.clear();  
      this.$router.push('/login')

    },
    async getMenulist(){
      const token =window.sessionStorage.getItem('token');
      const{data:res}= await this.$http.post('meuns',{id:token});
      if(res.code=="200"){
        this.menuList=this.transListToTreeData(res.body,0)
        console.log(this.menuList);
      }
       
    },
     transListToTreeData(list, RootValue) {
            let arr = [];
            list.forEach((item) => {
                //如果数据对象的pid为 '' 说明数据为根节点
                if (item.psPid == RootValue) {
                let children = this.transListToTreeData(list,item.psid); //寻找id等于该对象pid的数据，为它的子节点,返回一个数组
                if (children.length) {
                    item.children = children; //往对象添加一个children属性，属性值为一个数组
                }
                arr.push(item);
                }
            });
            return arr;
        },
     
    }

  
    }
  
</script>