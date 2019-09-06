package com.kris.service.impl;

import com.kris.entity.Area;
import com.kris.service.AreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {

    @Autowired
    AreaService areaService;

    @Test
    public void queryArea() throws Exception {
        List<Area> areas = areaService.queryArea();
        assertEquals(4,areas.size());
    }

    @Test
    public void queryByAreaId() throws Exception {

    }

    @Test
    public void addArea() throws Exception {

    }

    @Test
    public void modifyArea() throws Exception {
    }

    @Test
    public void deleteArea() throws Exception {
    }

}