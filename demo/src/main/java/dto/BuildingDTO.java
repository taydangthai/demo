package dto;



public class BuildingDTO {

    private long id;
    private String name;
    private String address;
    private String manager;
    private int yearUse;

    public BuildingDTO() {
    }

    public BuildingDTO(long id, String name, String address, String manager, int yearUse) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.manager = manager;
        this.yearUse = yearUse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
