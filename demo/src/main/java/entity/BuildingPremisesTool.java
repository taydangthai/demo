package entity;

import javax.persistence.*;

@Entity
@Table(name = "BUILDING_PREMISES_TOOL")
public class BuildingPremisesTool {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    //OneToOne la Lazy
    //OneToMany la EAGER
    //ManyToOne la LAZY
    @OneToOne(optional=false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "building_premises_id", referencedColumnName = "id")
    private BuildingPremises buildingPremises;

    @Column(name = "tool")
    private String tool; // ten tai san

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuildingPremises getBuildingPremises() {
        return buildingPremises;
    }

    public void setBuildingPremises(BuildingPremises buildingPremises) {
        this.buildingPremises = buildingPremises;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }
}
