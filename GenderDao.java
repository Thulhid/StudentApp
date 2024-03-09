import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("hashi");
        }

        return null;

    }

    public static List<Gender> getAll() {

        List<Gender> genders = new ArrayList<>();

        try {
            String qry = "Select * from gender";
            ResultSet rslt =CommonDao.get(qry);

            while (rslt.next()) {
                Gender gender = new Gender();
                gender.setId(rslt.getInt("id"));
                gender.setName(rslt.getString("name"));

                genders.add(gender);
            }
        }catch (Exception e) {

            System.out.println("Can't Connect As :"+ e.getMessage());
        }

        return genders;

    }
}
