package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import dto.BuildingDTO;
import entity.Building;
import entity.BuildingServices;
import service.building.BuildingService;
import service.building.BuildingServicePlus;

import java.util.List;

@Controller
@RestController
@RequestMapping
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private BuildingServicePlus buildingServicePlus;

    @GetMapping(path = "/getB")
    public List<BuildingDTO> findAll(){
        try {
            List<BuildingDTO> dtoList = buildingService.get();
            return dtoList;
        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        return findAll();
    }

    @PostMapping(path = "/postB")
    public String addB(@RequestBody BuildingDTO bDTO) {
        if (bDTO == null) {
            return "Failed to insert Building with in the database";
        } else {
            String result = buildingService.post(bDTO);
            return result;
        }
    }

    @PutMapping(path = "/putB")
    public String editB(@RequestBody BuildingDTO bDTO){
        try {
            String edit = buildingService.put(bDTO);
            return edit;
        } catch (Exception e){
          System.out.println(e);
          e.printStackTrace();
        }
        return editB(bDTO);
    }

    @GetMapping(path = "/getBId/{id}")
    public List<BuildingDTO> getNameById(@PathVariable("id") Long id){
        try {
            List<BuildingDTO> list = buildingServicePlus.getNameById(id);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getNameById(id);
    }
    
    @GetMapping(path = "/getPagination/{pageNo}/{pageSize}")
    public List<Building> getPaginatedCountries(@PathVariable(value = "pageNo") int pageNo,
                                        @PathVariable(value = "pageSize") int pageSize) {
        return buildingServicePlus.findPaginated(pageNo, pageSize);
    }
}
