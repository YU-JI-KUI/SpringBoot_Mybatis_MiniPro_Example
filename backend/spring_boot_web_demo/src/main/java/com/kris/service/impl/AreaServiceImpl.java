package com.kris.service.impl;

import com.kris.dao.AreaDao;
import com.kris.entity.Area;
import com.kris.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName AreaServiceImpl
 * @Description Service 层的实现
 * @Author Kris
 * @Date 2019/9/6 11:37
 * @Version 1.0
 **/
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryByAreaId(Integer areaId) {
        return areaDao.queryByAreaId(areaId);
    }

    @Override
    @Transactional
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !area.getAreaName().equals("")) {
            area.setLastEditTime(new Date());
            try {
                Integer in = areaDao.insertArea(area);
                if (in > 0) {
                    return true;
                } else {
                    throw new RuntimeException("新增区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("新增区域信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    @Transactional
    public boolean modifyArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            area.setLastEditTime(new Date());
            try {
                Integer in = areaDao.updateArea(area);
                if (in > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(Integer areaId) {
        if (areaId > 0) {
            Integer in = areaDao.deleteArea(areaId);
            if (in > 0) {
                return true;
            } else {
                throw new RuntimeException("删除区域信息失败!");
            }
        } else {
            throw new RuntimeException("区域 ID 不能为空！");
        }
    }
}
