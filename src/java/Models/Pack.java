package Models;

public class Pack {
    private int packID; 
    private String packName;
    private String packType;
    private String description;
    private double price;

    public Pack(int packID, String packName, String packType, String description, double price) {
        this.packID = packID;
        this.packName = packName;
        this.packType = packType;
        this.description = description;
        this.price = price;
    }

    public int getPackID() {
        return packID;
    }

    public void setPackID(int packID) {
        this.packID = packID;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public String getPackType() {
        return packType;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String[] getDescriptionLines() {
        return this.description.split(",");
    }
}
