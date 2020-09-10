package com.allen.springbootenterprisedevelopment.controller;

import com.allen.springbootenterprisedevelopment.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/9/8 16:24
 * @Description:
 */
@RestController
@Api(tags = "用户数据接口")
public class UserController {

    @ApiOperation(value = "查询用户", notes = "根据ID查询用户")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true)
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Integer id){

        return "/user/" + id;
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败！")
    })
    @ApiOperation(value = "删除用户", notes = "根据ID删除用户")
    @DeleteMapping("/user/{id}")
    public Integer deleteUserById(@PathVariable Integer id ){
        return id;
    }

    @ApiOperation(value = "添加用户", notes = "添加一个用户，传入用户名和地址")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType = "query", name = "username", value = "用户名", defaultValue = "allen"),
            @ApiImplicitParam( paramType = "query", name = "address", value = "地址", defaultValue = "guangzhou")
    })
    @PostMapping("/user")
    public String addUser(@RequestParam String username, @RequestParam String address){
        return username + ":" + address;
    }

    @ApiOperation(value = "修改用户", notes = "修改用户，传入用户信息")
    @PutMapping("/user")
    public String updateUser(@Validated User user, BindingResult result) throws JsonProcessingException {
        List<String> errors = new ArrayList<>();
        if( result.hasErrors() ){
            List<ObjectError> allErrors = result.getAllErrors();
            for ( ObjectError error : allErrors ){
                errors.add(error.getDefaultMessage());
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(errors);
    }

    @GetMapping("/ignore")
    @ApiIgnore
    public void ignore(){

    }


}
