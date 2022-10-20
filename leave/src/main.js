import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import JsonExcel from 'vue-json-excel'
    import axios from '@/api/http'
Vue.config.productionTip = false
Vue.component('downloadExcel', JsonExcel)
axios.interceptors.request.use(config =>{
    console.log(config)
    config.headers.Authorization =window.sessionStorage.getItem('token')
    return config 
})
Vue.prototype.$http = axios;
Vue.use(ElementUI);
new Vue({
    router,
    render: h => h(App)
}).$mount('#app')