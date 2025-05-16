/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp.service;

import myapp.service.custom.impl.UserRoleServiceImpl;

/**
 *
 * @author HP
 */
public class ServiceFactory {
    
    //This variable holds the single instance of ServiceFactory
    //private – so it can’t be accessed or modified directly from outside the class
    //static – it belongs to the class itself
    private static ServiceFactory serviceFactory;

    //constructor - private
    private ServiceFactory() {
    
    }
    
    public static ServiceFactory getServiceFactory(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        
        return serviceFactory;
    }
    
    /*
    *By returning the parent interface ISuperService, 
    *the method doesn't need to know about the specific implementation details of each service.
    */
    //produces or returns service instances based on the ServiceType enum 
    public ISuperService getService(ServiceType type){
        return switch (type) {
            case UserRole -> new UserRoleServiceImpl();
                
            default -> throw new IllegalArgumentException("Unsupported ServiceType: " + type);
        };
    }
    
    public enum ServiceType{
        UserRole,
    }
}
