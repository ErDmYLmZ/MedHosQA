package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestItems {

    private String name;
    private String description;
    private int price;
    private String defaultValMin;
    private String defaultValMax;
    private String createdDate;

    public TestItems() {
    }

    public TestItems(String name, String description, int price, String defaultValMin, String defaultValMax, String createdDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.defaultValMin = defaultValMin;
        this.defaultValMax = defaultValMax;
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDefaultValMin() {
        return defaultValMin;
    }

    public void setDefaultValMin(String defaultValMin) {
        this.defaultValMin = defaultValMin;
    }

    public String getDefaultValMax() {
        return defaultValMax;
    }

    public void setDefaultValMax(String defaultValMax) {
        this.defaultValMax = defaultValMax;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Test_Items{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", defaultValMin='" + defaultValMin + '\'' +
                ", defaultValMax='" + defaultValMax + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}



