<template>
  <div class="login_container">
     
     <div class="box-login">
             <h1>学生请假信息管理系统</h1><br>
     <el-input name="userid" v-model="userid"  placeholder="请输入用户名"  ></el-input><br>
       <el-input name="password" v-model="password"  placeholder="请输入密码" show-password></el-input><br>
   <el-button type="primary" @click="login">登录</el-button>
       </div>
      
  </div>
</template>
<style>
.login_container{
    background-color:#2b4b6b;
    height:1000px;
}
    .box-login{
    width:500px;
    height:300px;
    background-color:#fff;
    border-radius:3px;
    position:absolute;
    left:50%;
    top:50%;
    transform:translate(-50%,-50%);
   }
</style>
<script>
    export default {
        name: 'LoginView',
        data() {
            return {
                userid: 'admin',
                password: '123456',
                token:''
            }
        },
        methods: {
            login() {
                let data = {
                    
                        userid: this.userid,
                        password: this.password
                    }
                    //发起请求
                    window.sessionStorage.setItem('userid',this.userid)
                   
                this.$http.post('/login', data).then(resp => {
                    
                    let code = resp.data.code
                    console.log(resp.data);
                    if (code == '200') {
                        this.token=resp.data.token
                         window.sessionStorage.setItem('token',this.token)
                        this.$router.push({
                            path: '/home'
                        })
                    }
                })
            }
        },
    }
</script>