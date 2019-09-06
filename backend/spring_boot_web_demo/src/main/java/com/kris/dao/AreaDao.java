package com.kris.dao;

import com.kris.entity.Area;

import java.util.List;

public interface AreaDao {

    List<Area> queryArea();

    Area queryByAreaId(Integer areaId);

    Integer insertArea(Area area);

    Integer updateArea(Area area);

    Integer deleteArea(Integer areaId);

}
