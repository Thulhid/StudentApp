import java.util.Hashtable;
import java.util.List;

public class StudentController {
    public static List<Student> get(Hashtable<String, Object> ht) {

        List<Student> students;

        if (ht == null)
            students = StudentDao.getAll();

        else {

            String name = (String) ht.get("name");
            Gender gender = (Gender) ht.get("gender");

            if (gender == null)
                students = StudentDao.getbyName(name);

            else if (name == null)
                students = StudentDao.getbyGender(gender);

            else {
                students = StudentDao.getbyNameandGender(gender, name);
            }

        }

        return students;

    }

    public static String post(Student student) {

        String error = "";
        String msg = "";

        Student st = StudentDao.getByNic(student.getNic());

        if (st != null) {
            error = error + "Exsisting Nic";
        }

        if (error.isEmpty()) {
            String dberr = StudentDao.save(student);

            if (dberr.equals("1"))
                msg = "1";

            else
                msg = dberr;

        } else {
            msg = "Data Error/n" + error;
        }
        return msg;
    }

    public static String put(Student student) {

        String msg = "";
        String error = "";

        Student st = StudentDao.getByNic(student.getNic());

        if (st != null && st.getId() != student.getId())
            error = error + "Existing NIC";

        if (error.isEmpty()) {
            String dberr = StudentDao.update(student);
            if (dberr.equals("1"))
                msg = "1";
            else
                msg = dberr;
        } else {
            msg = "Data Error/n" + error;
        }
        return msg;
    }

    public static String delete(Student student) {

        String errors = "";
        String msg = "";

        String sts = StudentDao.delete(student);
        if (sts.equals("1")) {
            msg = sts;
        } else {
            errors = errors + sts;
            msg = errors;
        }

        return msg;

    }
}
