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
                student.setgender(GenderDao.getbyId(rs.getInt("gender_id")));

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
}
