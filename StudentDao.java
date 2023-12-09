import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

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

                student.setgender(GenderDao.getbyId(rslt.getInt("gender_id")));

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

}
