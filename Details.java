public class Details {
    protected String lastName;
    protected String firstName;
    protected String middleName;
    protected String address;
    protected int age;

    public Details(String lastName, String firstName, String middleName, String address, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.age = age;
    }

    public String getFullName() {
        return firstName + " " + (middleName.isEmpty() ? "" : middleName + " ") + lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
