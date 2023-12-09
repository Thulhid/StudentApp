public class Student {

    private int id;
    private String name;
    private String nic;
    private Gender gender;
   

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getNic() {
        return nic;
    }

    public void setgender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
   
}