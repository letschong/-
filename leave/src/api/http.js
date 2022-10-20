/** 封装axios请求*/
import axios from "axios";
import qs from 'qs'
const instance = axios.create({
    timeout: 5000,
    baseURL: '/api',
    headers: {
        'content-type': 'application/x-www-form-urlencoded'
    }
});
//配置请求拦截器
instance.interceptors.request.use(config => {
        //axios 默认是 Payload 格式数据请求，后端接收参数要求必须是 Form Data 格式的，
        //所以我们就得进行转换。Payload 和 Form Data 的主要设置是根据请求头的 Content-Type 的值来的。
        //Payload 格式：  Content-Type: ‘application/json; charset=utf-8’
        //FormData 格式： Content-Type: ‘application/x-www-form-urlencoded’
        config.data = qs.stringify(config.data) //转换为formData格式数据，axios默认为
        return config
    },
    error => {
        // do something with request error
        console.log(error) // for debug
        return Promise.reject(error)
    }
)
export default instance;