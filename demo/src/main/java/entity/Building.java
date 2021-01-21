package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BUILDING")

//@SqlResultSetMapping(name="", classes = {
//        @ConstructorResult(targetClass = Building.class,
//                columns = {
//                @ColumnResult(name="id"), @ColumnResult(name="name"), @ColumnResult(name="address")
//                        , @ColumnResult(name="manager"), @ColumnResult(name="year_use")})})

public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "manager")
    private String manager;

    @Column(name = "year_use")
    private int yearUse;

    //OneToOne la Lazy
    //OneToMany la EAGER
    //ManyToOne la LAZY
    @OneToMany(mappedBy = "building", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<BuildingPremises> buildingPremises;

    @OneToOne(mappedBy = "building", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private BuildingServices buildingService;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getYearUse() {
        return yearUse;
    }

    public void setYearUse(int yearUse) {
        this.yearUse = yearUse;
    }

    public Set<BuildingPremises> getBuildingPremises() {
        return buildingPremises;
    }

    public void setBuildingPremises(Set<BuildingPremises> buildingPremises) {
        this.buildingPremises = buildingPremises;
    }

    public BuildingServices getBuildingService() {
        return buildingService;
    }

    public void setBuildingService(BuildingServices buildingService) {
        this.buildingService = buildingService;
    }
}
