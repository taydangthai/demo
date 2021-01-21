package dao.building;


import java.util.List;

import entity.Building;

public interface BuildingDAO {

    List<Building> findAll();
    void addB(Building b);
    void editB(Building b);
}
