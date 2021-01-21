package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BUILDING_PREMISES")
public class BuildingPremises {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "position")
    private String position;

    @Column(name = "acreage")
    private int acreage;

    @ManyToOne(optional=false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="building_id",referencedColumnName="id")
    private Building building;

    @Column(name = "acreage_for_rent")
    private int acreageForRent;

    @Column(name = "acreage_for_use")
    private int acreageForUse;

    @Column(name = "note")
    private String note;

    //OneToOne la Lazy
    //OneToMany la EAGER
    //ManyToOne la LAZY
    @OneToOne(mappedBy = "buildingPremises",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BuildingPremisesTool buildingPremisesTools;

    public BuildingPremises() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getAcreageForRent() {
        return acreageForRent;
    }

    public void setAcreageForRent(int acreageForRent) {
        this.acreageForRent = acreageForRent;
    }

    public int getAcreageForUse() {
        return acreageForUse;
    }

    public void setAcreageForUse(int acreageForUse) {
        this.acreageForUse = acreageForUse;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BuildingPremisesTool getBuildingPremisesTools() {
        return buildingPremisesTools;
    }

    public void setBuildingPremisesTools(BuildingPremisesTool buildingPremisesTools) {
        this.buildingPremisesTools = buildingPremisesTools;
    }
}
