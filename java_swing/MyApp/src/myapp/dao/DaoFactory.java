/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.dao;

import myapp.dao.custom.impl.UserRoleDaoImpl;

/**
 *
 * @author HP
 */
public class DaoFactory {
    
    private static DaoFactory daoFactory;

    public DaoFactory() {
        
    }
    
    public static DaoFactory getDaoFactory(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        
        return daoFactory;
    }
    
    public ISuperDAO getDao(DaoTypes types){
        switch (types) {
            case USER_ROLE:
                return new UserRoleDaoImpl();
            default:
                return null;
        }
    }
    
    public enum DaoTypes{
        USER_ROLE,
    }
}
