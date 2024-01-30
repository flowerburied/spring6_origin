package com.example.spring6.iocxml.ditest;


import java.util.List;

//部门
public class Dept {
    private String dname;

    public String getDname() {
        return dname;
    }

    //一个部门有好多员工
    private List<Emp> empList;


    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void info() {
        System.out.println("Dept name.." + dname);
        for (Emp emp : empList) {
            System.out.println("empList..." + emp.getEname());
        }
    }
}
