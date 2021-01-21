package repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import entity.Building;

@Repository
public interface BuildingRepository extends PagingAndSortingRepository<Building, Long> {

}
