package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Registrant {
    private int id;
    private String login;
    private boolean activated;
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private String ssn;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String langKey;
    public String getLangKey() {
        return langKey;
    }
    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }
    public Registrant (){
    }
    public Registrant(int id, String login, boolean activated, String createdBy, String createdDate, String lastModifiedBy, String lastModifiedDate, String ssn, String firstName, String lastName, String username, String email, String password) {
        this.id = id;
        this.login = login;
        this.activated = activated;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public boolean isActivated() {
        return activated;
    }
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Registrant{" +
                "ssn='" + ssn + '\'' +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}