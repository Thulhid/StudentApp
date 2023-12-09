import java.util.List;

public class StudentController {

    public static List<Student> get(){

        List<Student> students =StudentDao.getAll();

        return students;
        
    }
    
}
