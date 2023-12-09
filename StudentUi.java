import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentUi extends JFrame {

     JTable tbl;

    StudentUi() {

        setTitle("Student Details Management");
        setSize(500, 300);
        setLocation(200, 200);

        Vector<Object> cloumns = new Vector<>();
        cloumns.add("Id");
        cloumns.add("Name");
        cloumns.add("Nic");

        Vector<Object> data = new Vector();

         tbl = new JTable();

        DefaultTableModel tblModel = new DefaultTableModel(data,cloumns);
        tbl.setModel(tblModel);

        Container con = getContentPane();
        FlowLayout lay =new FlowLayout();
        con.setLayout(lay);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize(new Dimension(450, 200));
        jspTable.setViewportView(tbl);

        con.add(jspTable);
      

      intialize();

       

    }

    public void intialize(){
        loadView();
    }
    public void loadView(){

        List<Student> students=StudentController.get();
        fillTable(students);
        
    }

    public void fillTable(List<Student> students){
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();

        for (Student st : students) {
            Vector<Object> row = new Vector();
            row.add(st.getName());
            row.add(st.getNic());
            row.add(st.getGender().getName());

            model.addRow(row);
        }

    }

}
