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
    
    //This variable holds the single instance of DaoFactory
    //private – so it can’t be accessed or modified directly from outside the class
    //static – it belongs to the class itself
    private static DaoFactory daoFactory;

    //constrctor - private
    public DaoFactory() {
        
    }
    
    public static DaoFactory getDaoFactory(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        
        return daoFactory;
    }
    
    /*
    *By returning the parent interface ISuperDAO, 
    *the method doesn't need to know about the specific implementation details of each dao.
    */
    //produces or returns dao instances based on the DaoType enum 
    public ISuperDAO getDao(DaoType type){
        return switch (type) {
            case USER_ROLE -> new UserRoleDaoImpl();
            
            default -> throw new IllegalArgumentException("Unsupported DaoType: " + type);
        };
    }
    
    public enum DaoType{
        USER_ROLE,
    }
}
