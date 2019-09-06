package com.kris.web;

import com.kris.entity.Area;
import com.kris.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AreaController
 * @Description TODO
 * @Author Kris
 * @Date 2019/9/6 13:47
 * @Version 1.0
 **/
// @RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> getList(){
        Map<String, Object> modelMap = new HashMap();
        List<Area> list = areaService.queryArea();
        modelMap.put("areaList", list);
        return modelMap;
    }

    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    public Map<String, Object> getAreaById (Integer areaId) {
        Map<String, Object> modelMap = new HashMap();
        Area area = areaService.queryByAreaId(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> addArea (@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Map<String, Object> modifyArea (@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap();
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Map<String, Object> deleteArea (Integer areaId) {
        Map<String, Object> modelMap = new HashMap();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }
}
