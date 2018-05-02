package com.tiangouforum.controller;

import com.tiangouforum.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Du Yihong
 * Decription：
 * Date Create in 2018/4/15
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
    @Resource(name = "HomeService")
    private HomeService homeService;

    @RequestMapping("/homeIndex")
    public ModelAndView homeIndex(String username) {
        Map<String, String> modelMap = new HashMap<String, String>();
        modelMap.put("username", username);
        return new ModelAndView("home/tiangou_home_index", modelMap);
    }

}
