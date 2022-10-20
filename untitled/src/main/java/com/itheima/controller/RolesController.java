package com.itheima.controller;

import com.itheima.dto.ApiResult;
import com.itheima.entity.Meun;
import com.itheima.entity.Meuns;
import com.itheima.entity.Role;
import com.itheima.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RolesController {
    @Autowired
    private RolesService rolesService;

    /*    @RequestParam("query") String query,@RequestParam("pagenum") int pagenum,@RequestParam("pagesize") int pagesize*/
    @RequestMapping(value = "/meuns")
    @ResponseBody
    public ApiResult meuns(@RequestParam(name = "id",required = false,defaultValue = "") String id) {
        Meun meun=new Meun();
        meun.setId(id);
        ApiResult result=new ApiResult();
        List<Meun> meunList=rolesService.meun_information(meun);
        result.setCode("200");
        result.setBody(meunList);
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/rolezz")
    @ResponseBody
    public ApiResult rolezz() {
        ApiResult result=new ApiResult();
        List<Role> roles=rolesService.role_information();
        result.setCode("200");
        result.setBody(roles);
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/deletemenu")
    @ResponseBody
    public ApiResult deletemenu(@RequestParam(name = "id",required = false,defaultValue = "") String id,
                                @RequestParam(name = "psid",required = false,defaultValue = "") String psid) {
        Meun meun=new Meun();
        meun.setId(id);
        meun.setPsid(psid);
        ApiResult result=new ApiResult();
        rolesService.deletemenu(meun);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/meun")
    @ResponseBody
    public ApiResult meun() {
        ApiResult result=new ApiResult();
        List<Meuns> meuns=rolesService.meuns();
        result.setCode("200");
        result.setBody(meuns);
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/addrole")
    @ResponseBody
    public ApiResult addrole(@RequestParam(name = "id",required = false,defaultValue = "") String id,
                                @RequestParam(name = "psid",required = false,defaultValue = "") String[] psid) {
        ApiResult result=new ApiResult();
        for(int i=0;i<psid.length;i++){
            Meun meun=new Meun();
            meun.setId(id);
            meun.setPsid(psid[i]);
            rolesService.addrele(meun);
        }
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }
}
