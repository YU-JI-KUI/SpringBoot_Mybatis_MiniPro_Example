package com.kris.service;

import com.kris.entity.Area;

import java.util.List;

public interface AreaService {

    List<Area> queryArea();

    Area queryByAreaId(Integer areaId);

    boolean addArea(Area area);

    boolean modifyArea(Area area);

    boolean deleteArea(Integer areaId);
}
