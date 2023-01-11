package service;

import configuration.JPAConfiguration;
import entity.EmployeeDetail;
import repository.EmployeeDetailRepository;

public class EmployeeDetailService {

    private EmployeeDetailRepository employeeDetailRepository;

    public EmployeeDetailService() {
        this.employeeDetailRepository = new EmployeeDetailRepository(JPAConfiguration.getEntityManager());
    }

    public EmployeeDetail createEmployeeDetail(EmployeeDetail employeeDetail){
        return employeeDetailRepository.createEmployeeDetail(employeeDetail);
    }
}