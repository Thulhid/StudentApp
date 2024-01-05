import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class StudentUi extends JFrame {

    Color valid;
    Color invalid;
    Color initial;

    JTable tblStudent;
    JComboBox cmb;
    JTextField txt;
    Vector<Object> columns;
    JComboBox cmbSv;
    JTextField nameSv;
    JTextField nicSv;
    JButton btnSvAdd;
    JButton btnUpdate;
    JButton btnDelete;

    StudentUi() {

        setTitle("Student Detail Management");
        setSize(500, 300);
        setLocation(500, 600);

        columns = new Vector();
        columns.add("Name");
        columns.add("NIC");
        columns.add("Gender");

        cmb = new JComboBox<>();
        JLabel cmbLable = new JLabel("Search Gender");
        txt = new JTextField(10);
        JLabel txtLable = new JLabel("Search Name");
        JButton btnSearch = new JButton("Search");
        JButton btnClear = new JButton("Clear");

        JLabel nameSaveLable = new JLabel("Name");
        nameSv = new JTextField(10);
        JLabel nicSvLable = new JLabel("NIC");
        nicSv = new JTextField(10);
        JLabel genderSvLable = new JLabel("Gender");
        cmbSv = new JComboBox<>();
       btnSvAdd = new JButton("Add");
        JButton btnSvClear = new JButton("Clear");
         btnDelete = new JButton("Delete");
         btnUpdate = new JButton("Update");

        tblStudent = new JTable();
        DefaultTableModel tblModel = new DefaultTableModel(null, columns);
        tblStudent.setModel(tblModel);

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);
        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize(new Dimension(450, 180));
        jspTable.setViewportView(tblStudent);

        con.add(nameSaveLable);
        con.add(nameSv);
        con.add(nicSvLable);
        con.add(nicSv);
        con.add(genderSvLable);
        con.add(cmbSv);
        con.add(btnSvAdd);
        con.add(btnSvClear);
        con.add(btnUpdate);
        con.add(btnDelete);
        con.add(txtLable);
        con.add(txt);
        con.add(btnSearch);
        con.add(btnClear);
        con.add(cmbLable);
        con.add(cmb);
        con.add(jspTable);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchAp(e);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnClearSearchAp(e);
            }
        });

        btnSvAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSvAddAp(e);
            }
        });

        btnSvClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSvClearAp(e);

            }
        });

        initialize();

    }

    public void initialize() {
        loadView();
        LoadForm();
    }

    public void loadView() {
        List<Student> stlist = StudentController.get(null);
        fillTable(stlist);

        List<Gender> gendlist = GenderController.get();
        Vector<Object> genders = new Vector<>();
        genders.add("Select a Gender");

        for (Gender gen : gendlist) {
            genders.add(gen);
        }

        DefaultComboBoxModel<Object> genModel = new DefaultComboBoxModel<Object>(genders);

        cmb.setModel(genModel);
      

    }

    public void LoadForm(){
        List<Gender> gendlist = GenderController.get();
        Vector<Object> genders = new Vector<Object>();
        genders.add("Select a Gender");

        for (Gender gen : gendlist) {
            genders.add(gen);
        }
        DefaultComboBoxModel<Object> genModel = new DefaultComboBoxModel<Object>(genders);
        cmbSv.setModel(genModel);

        nameSv.setText("");
        nicSv.setText("");

        setStyle(initial);
        enbaleButtons(true,false,false);



    }

    // public void fillTable(List<Student> stlist) {

    // DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();

    // for (Student st : stlist) {
    // Vector row = new Vector();
    // row.add(st.getName());
    // row.add(st.getNic());
    // row.add(st.getGender().getGender_type());

    // model.addRow(row);
    // }

    // }

    public void fillTable(List<Student> stlist) {

        Vector<Object> data = new Vector<>();

        for (Student st : stlist) {
            Vector row = new Vector<>();
            row.add(st.getName());
            row.add(st.getNic());
            row.add(st.getGender());
            data.add(row);
        }
        DefaultTableModel tblModel = new DefaultTableModel(data, columns);
        tblStudent.setModel(tblModel);

    }

    public void btnSearchAp(ActionEvent e) {
        // System.out.println("1111");

        Gender gender = null;

        String name = txt.getText();
        Object sitem = cmb.getSelectedItem();

        Hashtable<String, Object> ht = new Hashtable<>();
        ht.put("name", name);

        if (!sitem.equals("Select a Gender"))
            gender = (Gender) sitem;

        if (gender != null)
            ht.put("gender", gender);

        List<Student> students = StudentController.get(ht);

        fillTable(students);

    }

    public void btnClearSearchAp(ActionEvent e) {
        // Sout("Test Ok")

        int op = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the search..?");

        if (op != 1) {
            txt.setText("");
            cmb.setSelectedIndex(0);

            List<Student> employees = StudentController.get(null);
            fillTable(employees);
        }

    }

    public void btnSvAddAp(ActionEvent e) {

        valid = Color.GREEN;
        invalid = Color.PINK;
        initial = Color.WHITE;
        // System.out.println("Test-OK");
        String error = "";

        String name = nameSv.getText();
        Object gen = cmbSv.getSelectedItem();
        String nic = nicSv.getText();

        Student student = new Student();

        if (name.matches("^[A-Z][a-z]*$")) {
            nameSv.setBackground(valid);
            student.setName(name);
        }

        else {
            nameSv.setBackground(invalid);
            error = error + "Invalid student name\n";
        }

        if (nic.matches("[0-9]{9}V$")) {
            nicSv.setBackground(valid);
            student.setNic(nic);
        }

        else {
            nicSv.setBackground(invalid);
            error = error + "Invalid student nic\n";
        }

        if (gen != "Select a Gender") {
            cmbSv.setBackground(valid);
            student.setgender((Gender) cmbSv.getSelectedItem());
        }

        else {
            cmbSv.setBackground(invalid);
            error = error + "Invalid student Gender\n";
        }

        if (error.isEmpty()) {
            int msg = JOptionPane.showConfirmDialog(null,
                    "Are you Sure to Save?\n" + "Name -" + name + "\n" + "Nic -" + nic + "\n" + "Gender -" + gen + "\n");

            if (msg == 0) {

                String st = StudentController.post(student);
                JOptionPane.showMessageDialog(null, "Successfully Saved");

            }

        }

        else {

            JOptionPane.showMessageDialog(null, "Your in Following Error" + "\n" + error);

        }

    }

    public void setStyle(Color clr) {
        nameSv.setBackground(clr);
        nicSv.setBackground(clr);
        cmbSv.setBackground(clr);
    }

    public void enbaleButtons(boolean add, boolean upd, boolean del) {
        btnSvAdd.setEnabled(add);
        btnUpdate.setEnabled(upd);
        btnDelete.setEnabled(del);
    }


    public void btnSvClearAp(ActionEvent e){
        //System.out.println("Test-Ok");

        int op =JOptionPane.showConfirmDialog(null, "Are you sure you Sure want to clear this Form?");

        if (op == 0){
            LoadForm();
    }

}

}
