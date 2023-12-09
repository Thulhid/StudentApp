import java.sql.ResultSet;

public class GenderDao {

    public static Gender getbyId(int id) {

        Gender gender = new Gender();

        try {
            String quary = "Select * from gender where id = " + id + ";";
            ResultSet rslt = CommonDao.get(quary);

            rslt.next();
            gender.setId(rslt.getInt("id"));
            gender.setName(rslt.getString("name"));

            return gender;


        } catch (Exception e) {

            System.out.println("Can't Connect as  :" + e.getMessage());

        }

        return null;

    }

   
}




        

        
    
        

    



