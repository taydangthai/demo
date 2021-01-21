package service.building;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dao.building.BuildingDAO;
import dao.building.BuildingDAOPlus;
import dto.BuildingDTO;
import entity.Building;
import repository.BuildingRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class BuildingServiceImpl implements  BuildingService, BuildingServicePlus{

    @Autowired
    private BuildingDAO buildingDAO ;

    @Autowired
    private BuildingDAOPlus buildingDAOPlus;

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    @Transactional
    public List<BuildingDTO> get() {
        try {
            List<Building> building = buildingDAO.findAll();
            List<BuildingDTO> bDTOList = new ArrayList<>();

            for (Building b: building) {
                BuildingDTO bDTO = new BuildingDTO();

                bDTO.setId(b.getId());
                bDTO.setName(b.getName());
                bDTO.setAddress(b.getAddress());
                bDTO.setManager(b.getManager());
                bDTO.setYearUse(b.getYearUse());

                bDTOList.add(bDTO);
            }
            return bDTOList;
        } catch (Exception e){
            System.out.println("Error get by BuildingServiceImp! \n" +e);
        }
        return get();
    }

    @Override
    @Transactional
    public String post(BuildingDTO bDTO) {
        try {
            Building b = new Building();

            b.setId(bDTO.getId());
            b.setName(bDTO.getName());
            b.setAddress(bDTO.getAddress());
            b.setManager(bDTO.getManager());
            b.setYearUse(bDTO.getYearUse());

            buildingDAO.addB(b);
        } catch (Exception e){
            System.out.println(e);
        }
        return "Success";
    }

    @Override
    @Transactional
    public String put(BuildingDTO bDTO) {
        try {
            Building b = new Building();

            b.setId(bDTO.getId());
            b.setName(bDTO.getName());
            b.setAddress(bDTO.getAddress());
            b.setManager(bDTO.getManager());
            b.setYearUse(bDTO.getYearUse());

            buildingDAO.editB(b);
        } catch (Exception e){
            System.out.println(e);
        }
        return "Success";
    }

    @Override
    @Cacheable("Building")
    public List<BuildingDTO> getNameById(Long id) {
        try {
            List<Building> listB = buildingDAOPlus.getNameById(id);
            List<BuildingDTO> listBDTO = new ArrayList<>();

            for (Building b: listB) {
                BuildingDTO dto = new BuildingDTO();

                dto.setId(b.getId());
                dto.setName(b.getName());
                dto.setAddress(b.getAddress());
                dto.setManager(b.getManager());
                dto.setYearUse(b.getYearUse());

                listBDTO.add(dto);
            }
            return listBDTO;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getNameById(id);
    }


    @Override
    public List<Building> findPaginated(int pageNo, int pageSize) {
        Pageable building = PageRequest.of(pageNo, pageSize);
        Page<Building> pagedResult = buildingRepository.findAll(building);

        return pagedResult.toList();
    }
}
