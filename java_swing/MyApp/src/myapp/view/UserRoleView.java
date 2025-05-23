/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myapp.view;

import java.util.List;
import javax.swing.JOptionPane;
import myapp.controller.UserRoleController;
import myapp.dto.userRole.UserRoleDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import myapp.dto.userRole.UserRoleSaveDTO;

/**
 *
 * @author HP
 */
public class UserRoleView extends javax.swing.JFrame {

    /**
     * Creates new form UserRoleView
     */
    
    private final UserRoleController userRoleController;
    
    public UserRoleView() {
        initComponents();
        
        userRoleController = new UserRoleController();
        loadAllUserRoles();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle1 = new javax.swing.JLabel();
        lblId1 = new javax.swing.JLabel();
        txt_roleName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_userRoleList = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle1.setBackground(new java.awt.Color(204, 204, 204));
        lblTitle1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("Roles");

        lblId1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblId1.setText("Name :");

        tbl_userRoleList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_userRoleList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_userRoleListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_userRoleList);

        btnDelete.setLabel("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setLabel("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setLabel("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblId1)
                                .addGap(30, 30, 30)
                                .addComponent(txt_roleName, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 411, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_roleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteUserRole();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateUserRole();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addUserRole();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tbl_userRoleListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_userRoleListMouseClicked
        getSelectedRow();
    }//GEN-LAST:event_tbl_userRoleListMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UserRoleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UserRoleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UserRoleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UserRoleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UserRoleView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblId1;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JTable tbl_userRoleList;
    private javax.swing.JTextField txt_roleName;
    // End of variables declaration//GEN-END:variables


    //------------ [ Start - btn handle] -------------
    private void addUserRole() {
        if (!isRoleNameValid()) {
            return;
        }

        try {
            UserRoleSaveDTO userRoleSaveDTO = new UserRoleSaveDTO(txt_roleName.getText().trim());
            String result = userRoleController.addUserRole(userRoleSaveDTO);
            postOperationSuccess(result);
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void updateUserRole() {
        Integer id = getSelectedUserRoleId();
        if (id == null || !isRoleNameValid()) {
            return;
        }

        try {
            UserRoleDTO userRoleDTO = new UserRoleDTO(id, txt_roleName.getText().trim());
            String result = userRoleController.updateUserRole(userRoleDTO);
            postOperationSuccess(result);
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void deleteUserRole() {
        Integer id = getSelectedUserRoleId();
        if (id == null) {
            return;
        }

        try {
            String result = userRoleController.deleteUserRole(id);
            postOperationSuccess(result);
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void getSelectedRow() {
        Integer id = getSelectedUserRoleId();
        if (id == null) {
            return;
        }

        try {
            UserRoleDTO userRoleDTO = userRoleController.getUserRoleById(id);
            if (userRoleDTO != null) {
                txt_roleName.setText(userRoleDTO.getRole_name());
            } else {
                JOptionPane.showMessageDialog(this, "User role not found");
            }
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private Integer getSelectedUserRoleId() {
        int selectedRow = tbl_userRoleList.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }

        Object idObj = tbl_userRoleList.getValueAt(selectedRow, 0);
        if (idObj == null || idObj.toString().isBlank()) {
            return null;
        }

        try {
            return Integer.valueOf(idObj.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private boolean isRoleNameValid() {
        String roleName = txt_roleName.getText().trim();
        if (roleName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Role name cannot be empty.");
            return false;
        }
        return true;
    }

    private void postOperationSuccess(String message) {
        JOptionPane.showMessageDialog(this, message);
        loadAllUserRoles();
        clearForm();
    }

    private void handleException(Exception ex) {
        Logger.getLogger(UserRoleView.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }

    private void clearForm() {
        txt_roleName.setText("");
    }

    private void loadAllUserRoles() {
        try {
            List<UserRoleDTO> roles = userRoleController.getAllUserRoles();
            String[] columns = {"role_Id", "No", "Role Name"};

            DefaultTableModel dtm = new DefaultTableModel(columns, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            tbl_userRoleList.setModel(dtm);

            if (roles != null && !roles.isEmpty()) {
                for (int i = 0; i < roles.size(); i++) {
                    UserRoleDTO role = roles.get(i);
                    dtm.addRow(new String[]{
                        String.valueOf(role.getRole_id()),
                        String.valueOf(i + 1),
                        role.getRole_name()
                    });
                }
            } else {
                dtm.addRow(new String[]{"", "No roles found", ""});
            }

            // Hide ID column
            for (int i = 0; i <= 0; i++) {
                tbl_userRoleList.getColumnModel().getColumn(i).setMinWidth(0);
                tbl_userRoleList.getColumnModel().getColumn(i).setMaxWidth(0);
                tbl_userRoleList.getColumnModel().getColumn(i).setWidth(0);
            }

        } catch (Exception ex) {
            handleException(ex);
        }
    }
    //------------ [ End - btn handle] ---------------
}
