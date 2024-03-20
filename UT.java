
public class UT {

    public static void main(String args[]) {

        // =======================UnitTest-1->GenderDao.getbyId()=======================

        // Gender gen = GenderDao.getbyId(1);
        // List<Student> students = StudentDao.getbyGender(gen);
        // for(Student st : students){
        // System.out.println(st.getId()+" ");
        // System.out.println(st.getName()+" ");
        // System.out.println(st.getNic()+" ");
        // System.out.println(st.getGender().getName()+"\n");

        // }

        // =======================UnitTest-2->StudentDao.getByNic()=========================

        // Student st =StudentDao.getByNic("200330112036");
        //
        // if (st == null)
        // System.out.println("New Nic");
        //
        // else{
        // System.out.println("Existing Nic");
        // }

        // =======================UnitTest-3->StudentController.post()=======================

        Student student = new Student();
        student.setName("Peeter");
        student.setNic("123456787V");
        student.setGender(GenderDao.getbyId(1));

        String st= StudentController.post(student);
        System.out.println(st);

    }
    

}
