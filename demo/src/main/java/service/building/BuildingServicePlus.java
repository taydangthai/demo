package service.building;

import java.util.List;

import dto.BuildingDTO;
import entity.Building;

import java.util.List;

public interface BuildingServicePlus {

    List<BuildingDTO> getNameById(Long id);

    List<Building> findPaginated(int pageNo, int pageSize);
}
