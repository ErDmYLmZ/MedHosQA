package pojos;

public class CState {
    private int id;
    private String name;
    private Country country;

    public CState(int id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CState() {
    }

    @Override
    public String toString() {
        return "CState{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
