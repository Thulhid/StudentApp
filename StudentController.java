import java.util.Hashtable;
import java.util.List;

public class StudentController {
    public static List<Student> get(Hashtable <String,Object> ht){

    List<Student> students;

    if (ht==null)
     students = StudentDao.getAll();
    

    else{

        String name = (String) ht.get("name");
        Gender gender =(Gender) ht.get("gender");


     if(gender==null)
        students = StudentDao.getbyName(name);
     
        else if(name==null)
       students =StudentDao.getbyGender(gender);

        else{
            students = StudentDao.getbyNameandGender(gender, name);
        }

    }

    return students;

    
}
}
