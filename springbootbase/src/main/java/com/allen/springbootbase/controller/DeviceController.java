package com.allen.springbootbase.controller;

import com.allen.springbootbase.module.dto.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/devicedemo")
public class DeviceController {
        
        //@Autowired
        //DeviceRepository deviceRepository;
        
        //增加设备
                @PostMapping(path = "/add")
                public @ResponseBody
                Device addNewDevice(@RequestParam String name) {
                        Device device = new Device();
                        device.setName(name);
                        //deviceRepository.save(device);
                        return device;
                }
                

}