package dao.building;



import java.util.List;

import entity.Building;

public interface BuildingDAOPlus {
    List<Building> getNameById(Long id);
    Building nameById(Long id);


}
