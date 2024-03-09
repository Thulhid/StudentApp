import java.util.Hashtable;
import java.util.List;

public class UT {

    public static void main(String args[]){
       


           //==========Unit test-1->GenderDao->getById()==========

       /* Gender gen1 = GenderDao.getById(1);
        System.out.println(gen1.getId() + " ");
        System.out.println(gen1.getName() + "\n");

        Gender gen2 = GenderDao.getById(2);
        System.out.println(gen2.getId() + " ");
        System.out.println(gen2.getName() + "\n");

        Gender gen3 = GenderDao.getById(3);
        System.out.println(gen3.getId() + " ");
        System.out.println(gen3.getName());
       */


       //========Unit Test-2->StudentDao->getAll()===========

       /* //Unit Test-3->StudentController->get()
       List<Student> students = StudentDao.getAll();

       for (Student st : students){
        System.out.print(st.getId() + " ");
        System.out.print(st.getName() + " ");
        System.out.print(st.getNic() + " ");
        System.out.println(st.getGender().getName() + "\n");
        */


       
  
    
    
    //==========Unit Test-4->StudentDao->getbyGender()===========
        
    /*Gender gen = GenderDao.getbyId(1);
        List<Student> students = StudentDao.getbyGender(gen);
        for(Student st : students){
            System.out.println(st.getId()+"  ");
            System.out.println(st.getName()+"  ");
            System.out.println(st.getNic()+"  ");
            System.out.println(st.getGender().getName()+"\n");

        }*/

     //==========Unit Test-5->GenderDao->getAll()==========
        /*
         * List<Gender> genders = GenderDao.getAll();
         * 
         * for (Gender gen : genders) {
         * System.out.println(gen.getId() + " ");
         * System.out.println(gen.getName() + "\n");
         * }
         */
    
     // ==========Unit Test-5->GenderController ->get()============

        /*
         * List<Gender> genders = GenderController.get();
         * 
         * for (Gender gen : genders) {
         * System.out.println(gen.getId() + " ");
         * System.out.println(gen.getName() + "\n");
         * 
         * 
         * }
         */

    // ===========Unit Test-6->StudentDao ->getbyName() ==================
           /*
         * List<Student> students = StudentDao.getAllByName("h");
         * 
         * for (Student st : students) {
         * System.out.println(st.getId() + " ");
         * System.out.println(st.getName() + " ");
         * System.out.println(st.getNic() + " ");
         * System.out.println(st.getGender().getName() + "\n");
         * 
         * }
         */


     //==========Unit Test-3->StudentController->get()===========

      //=======Without Hashtable=======

        // List<Student> students = StudentController.get(null);

        // for (Student st : students) {
        // System.out.print(st.getId() + " ");
        // System.out.print(st.getName() + " ");
        // System.out.print(st.getNic() + " ");
        // System.out.println(st.getGender().getName() + "\n");
        // }

        // =======Hashtable with Name=======

        // Hashtable<String, Object> ht = new Hashtable<>();
        // ht.put("name", "h");

        // List<Student> students = StudentController.get(ht);

        // for (Student st : students) {
        // System.out.print(st.getId() + " ");
        // System.out.print(st.getName() + " ");
        // System.out.print(st.getNic() + " ");
        // System.out.println(st.getGender().getName() + "\n");
        // }

        // =======Hashtable with Gender-Male=======

        // Gender gender = GenderDao.getbyId(1);

        // Hashtable<String, Object> ht = new Hashtable<>();
        // ht.put("gender", gender);

        // List<Student> students = StudentController.get(ht);

        // for (Student st : students) {
        // System.out.print(st.getId() + " ");
        // System.out.print(st.getName() + " ");
        // System.out.print(st.getNic() + " ");
        // System.out.println(st.getGender().getName() + "\n");
        // }

        // =======Hashtable with Gender-Female=======

        // Gender gender = GenderDao.getbyId(2);

        // Hashtable<String, Object> ht = new Hashtable<>();
        // ht.put("gender", gender);

        // List<Student> students = StudentController.get(ht);

        // for (Student st : students) {
        // System.out.print(st.getId() + " ");
        // System.out.print(st.getName() + " ");
        // System.out.print(st.getNic() + " ");
        // System.out.println(st.getGender().getName() + "\n");
        // }

        // =======Hashtable with Name and Gender========

        /*Gender gender = GenderDao.getbyId(1);

        Hashtable<String, Object> ht = new Hashtable<>();
        ht.put("name", "h");
        ht.put("gender", gender);

        List<Student> students = StudentController.get(ht);

        for (Student st : students) {
            System.out.print(st.getId() + " ");
            System.out.print(st.getName() + " ");
            System.out.print(st.getNic() + " ");
            System.out.println(st.getGender().getName() + "\n");
         }*/

          // ==========Unit Test-10>StudentDao.Save()===========

        /*Student student = new Student();
        student.setName("Nimali");
        student.setNic("954558452V");
        student.setgender(GenderDao.getbyId(2));



        String msg = StudentDao.save(student);
        System.out.println(msg);*/

         // ===========Unit Test-11->EmployeDao.getByNic()=================

        // =====With Existing NIC======

            // Student student = StudentDao.getByNIC("200330112037");

            // if (student != null)
            // System.out.println("Exsist");
            // else
            // System.out.println("new NIC");

             // ====With New Nic======

        //   Student student = StudentDao.getByNIC("123456789");

            
        //     if (student != null)
        //     System.out.println("Nic is Exist");
        //     else
        //     System.out.println("New NIC");

  //==================== Unit Test-12->StudentController.post()=========================

// ======With Exsisting NIC=======

/*Student student = new Student();
student.setName("Sunimal");
student.setNic("954558442V");
student.setgender(GenderDao.getbyId(1));

String msg = StudentController.post(student);
System.out.println(msg);*/

// =======With New NIC=======

// Student student = new Student();
// student.setName("Boralu");
// student.setNic("123456789");
// student.setGender(GenderDao.getById(1));

// String msg = StudentController.post(student);
//  System.out.println(msg);


 // ============== Update ->name============
        // Student Student = StudentDao.getByNIC("123456789V");
        // Student.setName("Ahinsa");

        // String msg = StudentController.put(Student);
        // System.out.println(msg);

        // ============== Update ->Nic to Exsisting Nic============
       // Student student = StudentDao.getByNic("123456789123");
       // student.setNic("376501293763");

        //String msg = StudentController.put(student);
        //System.out.println(msg);

        // ============== Update ->Nic to New Nic============
        // Student student = StudentDao.getByNic("123456789V");
        // student.setNic("");

        // String msg = StudentController.put(student);
        // System.out.println(msg);

        // ============== Update ->Gender============
        // Student student = StudentDao.getByNic("123456789V");
        // student.setName("");
        // student.setGender(GenderDao.getById(1));

        // String msg = StudentController.put(student);
        // System.out.println(msg);

        // ============== Delete ->============
       Student student = StudentDao.getByNic("909090908V");
        //student.setName("Nimal");

        String msg = StudentController.delete(student);
       System.out.println(msg);





    }
}

          
    
    

