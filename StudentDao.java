import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class StudentDao {

    private static List<Student> get(String quary) {

        List<Student> students = new ArrayList<>();

        try {
            ResultSet rs = CommonDao.get(quary);

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setNic(rs.getString("nic"));
                student.setGender(GenderDao.getbyId(rs.getInt("gender_id")));

                students.add(student);

            }
        } catch (Exception e) {
            System.out.println("Can't Connect As" + e.getMessage());

        }

        return students;

    }

    public static List<Student> getAll() {
        String quary = "Select * from student";
        // System.out.println(quary);
        List<Student> students = get(quary);
        return students;
    }

    public static List<Student> getbyGender(Gender gender) {

        String qry = "Select * from student where gender_id =" + gender.getId();
        // System.out.println(qry);

        List<Student> students = get(qry);
        return students;
    }

    public static List<Student> getbyName(String name) {
        String qry = "Select * from student where name like'" + name + "%'";

        List<Student> students = get(qry);
        return students;
    }

    public static List<Student> getbyNameandGender(Gender gender, String name) {
        String qry = "Select * from student where name like'" + name + "%' AND gender_id= " + gender.getId();

        List<Student> students = get(qry);
        return students;
    }

    public static Student getByNic(String nic) {

        Student student = null;

        try {

            String quary = "Select * from student where nic='" + nic + "'";
            ResultSet rslt = CommonDao.get(quary);

            if (rslt.next() && rslt != null) {

                student = new Student();
                student.setId(rslt.getInt("id"));
                student.setName(rslt.getString("name"));
                student.setNic(rslt.getString("nic"));

                student.setGender(GenderDao.getbyId(rslt.getInt("gender_id")));

            }
        } catch (Exception e) {
            System.out.println("Can't Connect as : " + e.getMessage());
        }

        return student;

    }

    public static String save(Student student) {

        String msg = "";

        String quary = "INSERT INTO student(name,nic,gender_id) values ('"
                + student.getName() + "','"
                + student.getNic() + "',"
                + student.getGender().getId() + ")";
        // System.out.println(quary);

        msg = CommonDao.modify(quary);

        return msg;
    }

    public static String update(Student student) {

        String msg = "Can't Connect Database";

        String qry = "UPDATE student SET name ='" +
                student.getName() + "',nic='" +
                student.getNic() + "',gender_id=" +
                student.getGender().getId() +
                " WHERE id=" + student.getId();

        // INSERT INTO student (name,nic,gender_id) values('"
        // Kamal','
        // 2004344126740',
        // 1);

        // System.out.println(qry);

        msg = CommonDao.modify(qry);

        return msg;

}

public static String delete(Student student) {

    String msg = "Can't Connect Database";

    String qry = "DELETE FROM student WHERE id=" + student.getId();
    msg = CommonDao.modify(qry);

    return msg;
}

}
