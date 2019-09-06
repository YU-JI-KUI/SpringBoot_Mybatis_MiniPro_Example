package com.kris.dao;

import com.kris.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() throws Exception {
        List<Area> list = areaDao.queryArea();
        assertEquals(2,list.size());
    }

    @Test
    @Ignore
    public void queryByAreaId() throws Exception {
        Area area = areaDao.queryByAreaId(2);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() throws Exception {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(3);
        Integer in = areaDao.insertArea(area);
        assertEquals(1,in.intValue());
    }

    @Test
    @Ignore
    public void updateArea() throws Exception {
        Area area = new Area();
        area.setAreaId(3);
        area.setAreaName("北苑");
        area.setPriority(5);
        area.setLastEditTime(new Date());
        Integer in = areaDao.updateArea(area);
        assertEquals(1,in.intValue());
    }

    @Test
    public void deleteArea() throws Exception {
        Integer in = areaDao.deleteArea(6);
        assertEquals(1,in.intValue());
    }

}