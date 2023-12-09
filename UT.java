import java.util.List;

public class UT {

    public static void main(String args[]){
        Gender gen = GenderDao.getbyId(1);
        List<Student> students = StudentDao.getbyGender(gen);
        for(Student st : students){
            System.out.println(st.getId()+"  ");
            System.out.println(st.getName()+"  ");
            System.out.println(st.getNic()+"  ");
            System.out.println(st.getGender().getName()+"\n");

        }

          
    }
    
}
