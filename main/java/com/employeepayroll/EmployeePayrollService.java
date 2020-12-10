package com.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService
{
    public enum IOService{CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

    public List<EmployeePayrollData> employeePayrollList;

    //public EmployeePayrollService() {}

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList)
    {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args)
    {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        //Scanner consoleInputReader = new Scanner(System.in);
        //employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
    }

    public void writeEmployeePayrollData(IOService ioService)
    {
        if(ioService.equals(IOService.CONSOLE_IO))
        {
            System.out.println("\nWriting Employee Payroll Details to Console\n" + employeePayrollList);
        }
        else if(ioService.equals(IOService.FILE_IO))
        {
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
        }
    }

    public void printData(IOService ioService)
    {
        if(ioService.equals(IOService.FILE_IO))
        {
            new EmployeePayrollFileIOService().printData();
        }
    }

    public long countEntries(IOService ioService)
    {
        if(ioService.equals(IOService.FILE_IO))
        {
            return new EmployeePayrollFileIOService().countEntries();
        }
        return 0;
    }

    public List<String> readData(IOService ioService)
    {
        if(ioService.equals(IOService.FILE_IO))
        {
            return new EmployeePayrollFileIOService().readData();
        }
        return null;
    }
}
