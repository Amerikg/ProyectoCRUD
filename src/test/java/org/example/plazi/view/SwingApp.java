package org.example.plazi.view;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.example.plazi.model.Employee;
import org.example.plazi.repository.EmployeeRepository;
import org.example.plazi.repository.Repository;

public class SwingApp extends JFrame {
    private final Repository<Employee> employeeRepository;
    private final JTable employeeTable;

    public SwingApp() {
        this.setTitle("Gestión de Empleados");
        this.setDefaultCloseOperation(3);
        this.setSize(600, 230);
        this.employeeTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(this.employeeTable);
        this.add(scrollPane, "Center");
        JButton agregarButton = new JButton("Agregar");
        JButton actualizarButton = new JButton("Actualizar");
        JButton eliminarButton = new JButton("Eliminar");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
        buttonPanel.add(actualizarButton);
        buttonPanel.add(eliminarButton);
        this.add(buttonPanel, "South");
        agregarButton.setBackground(new Color(46, 204, 113));
        agregarButton.setForeground(Color.WHITE);
        agregarButton.setFocusPainted(false);
        actualizarButton.setBackground(new Color(52, 152, 219));
        actualizarButton.setForeground(Color.WHITE);
        actualizarButton.setFocusPainted(false);
        eliminarButton.setBackground(new Color(231, 76, 60));
        eliminarButton.setForeground(Color.WHITE);
        eliminarButton.setFocusPainted(false);
        this.employeeRepository = new EmployeeRepository();
        this.refreshEmployeeTable();
        agregarButton.addActionListener((e) -> {
            try {
                this.agregarEmpleado();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        actualizarButton.addActionListener((e) -> this.actualizarEmpleado());
        eliminarButton.addActionListener((e) -> this.eliminarEmpleado());
    }

    private void refreshEmployeeTable() {
        try {
            List<Employee> employees = this.employeeRepository.findAll();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Apellido Paterno");
            model.addColumn("Apellido Materno");
            model.addColumn("Email");
            model.addColumn("Salario");

            for(Employee employee : employees) {
                Object[] rowData = new Object[]{employee.getId(), employee.getFirstName(), employee.getPa_surname(), employee.getMa_surname(), employee.getEmail(), employee.getSalary()};
                model.addRow(rowData);
            }

            this.employeeTable.setModel(model);
        } catch (SQLException var6) {
            JOptionPane.showMessageDialog(this, "Error al obtener los empleados de la base de datos", "Error", 0);
        }

    }

    private void agregarEmpleado() throws SQLException {
        JTextField nombreField = new JTextField();
        JTextField paternoField = new JTextField();
        JTextField maternoField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField salarioField = new JTextField();
        Object[] fields = new Object[]{"Nombre:", nombreField, "Apellido Paterno:", paternoField, "Apellido Materno:", maternoField, "Email:", emailField, "Salario:", salarioField};
        int result = JOptionPane.showConfirmDialog(this, fields, "Agregar Empleado", 2);
        if (result == 0) {
            Employee employee = new Employee();
            employee.setFirstName(nombreField.getText());
            employee.setPa_surname(paternoField.getText());
            employee.setMa_surname(maternoField.getText());
            employee.setEmail(emailField.getText());
            employee.setSalary(Float.parseFloat(salarioField.getText()));
            this.employeeRepository.save(employee);
            this.refreshEmployeeTable();
            JOptionPane.showMessageDialog(this, "Empleado agregado correctamente", "Éxito", 1);
        }

    }

    private void actualizarEmpleado() {
        String empleadoIdStr = JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a actualizar:", "Actualizar Empleado", 3);
        if (empleadoIdStr != null) {
            try {
                int empleadoId = Integer.parseInt(empleadoIdStr);
                Employee empleado = (Employee)this.employeeRepository.getById(empleadoId);
                if (empleado != null) {
                    JTextField nombreField = new JTextField(empleado.getFirstName());
                    JTextField apellidoPaternoField = new JTextField(empleado.getPa_surname());
                    JTextField apellidoMaternoField = new JTextField(empleado.getMa_surname());
                    JTextField emailField = new JTextField(empleado.getEmail());
                    JTextField salarioField = new JTextField(String.valueOf(empleado.getSalary()));
                    Object[] fields = new Object[]{"Nombre:", nombreField, "Apellido Paterno:", apellidoPaternoField, "Apellido Materno:", apellidoMaternoField, "Email:", emailField, "Salario:", salarioField};
                    int confirmResult = JOptionPane.showConfirmDialog(this, fields, "Actualizar Empleado", 2);
                    if (confirmResult == 0) {
                        empleado.setFirstName(nombreField.getText());
                        empleado.setPa_surname(apellidoPaternoField.getText());
                        empleado.setMa_surname(apellidoMaternoField.getText());
                        empleado.setEmail(emailField.getText());
                        empleado.setSalary(Float.parseFloat(salarioField.getText()));
                        this.employeeRepository.save(empleado);
                        this.refreshEmployeeTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún empleado con el ID especificado", "Error", 0);
                }
            } catch (NumberFormatException var11) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el ID", "Error", 0);
            } catch (SQLException var12) {
                JOptionPane.showMessageDialog(this, "Error al obtener los datos del empleado de la base de datos", "Error", 0);
            }
        }

    }

    private void eliminarEmpleado() {
        String empleadoIdStr = JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a eliminar:", "Eliminar Empleado", 3);
        if (empleadoIdStr != null) {
            try {
                int empleadoId = Integer.parseInt(empleadoIdStr);
                int confirmResult = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el empleado?", "Confirmar Eliminación", 0);
                if (confirmResult == 0) {
                    this.employeeRepository.delete(empleadoId);
                    this.refreshEmployeeTable();
                }
            } catch (NumberFormatException var4) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el ID del empleado", "Error", 0);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
