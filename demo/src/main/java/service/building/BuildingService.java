package service.building;

import java.util.List;

import dto.BuildingDTO;

public interface BuildingService {

    List<BuildingDTO> get();
    String post(BuildingDTO bDTO);
    String put(BuildingDTO bDTO);

}
