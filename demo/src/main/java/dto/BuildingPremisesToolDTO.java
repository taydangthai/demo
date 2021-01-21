package dto;

public class BuildingPremisesToolDTO {

    private Long id;
    private Long buildingPremisesId;
    private String tool;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuildingPremisesId() {
        return buildingPremisesId;
    }

    public void setBuildingPremisesId(Long buildingPremisesId) {
        this.buildingPremisesId = buildingPremisesId;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }
}
