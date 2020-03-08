package org.pb.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bo.peng
 * @create 2020-03-02 15:01
 */
public class College extends OrganizationComponent{

    private List<OrganizationComponent> departmentList = new ArrayList<>();

    public College(String name, String description) {
        super(name, description);
    }

    @Override
    protected void add(OrganizationComponent component) {
        departmentList.add(component);
    }

    @Override
    protected void remove(OrganizationComponent component) {
        departmentList.remove(component);
    }

    @Override
    protected void print() {
        System.out.println("------------------"+getName()+"------------------");
        departmentList.stream().forEach(component -> component.print());
    }
}
