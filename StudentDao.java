import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static List<Student> get(String quary){

       ArrayList<Student> students=new ArrayList<>();

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
        //System.out.println(quary);
        List<Student> students = get(quary);
        return students;
    }
    
}
