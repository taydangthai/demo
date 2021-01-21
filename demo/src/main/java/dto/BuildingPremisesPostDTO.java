package dto;

public class BuildingPremisesPostDTO {
    private Long id;
    private String position;
    private int acreage;
    private Long buildingId;
    private int acreageForRent;
    private int acreageForUse;
    private String note;

    public BuildingPremisesPostDTO() {

    }

    public BuildingPremisesPostDTO(Long id, String position, int acreage, Long buildingId, int acreageForRent, int acreageForUse, String note) {
        this.id = id;
        this.position = position;
        this.acreage = acreage;
        this.buildingId = buildingId;
        this.acreageForRent = acreageForRent;
        this.acreageForUse = acreageForUse;
        this.note = note;
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

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
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
}
