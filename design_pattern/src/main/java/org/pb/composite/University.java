package org.pb.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式：大学Composite
 * @author bo.peng
 * @create 2020-03-02 14:50
 */
public class University extends OrganizationComponent {

    private List<OrganizationComponent> collegeList = new ArrayList<>();

    public University(String name, String description) {
        super(name, description);
    }

    @Override
    protected void add(OrganizationComponent component) {
        collegeList.add(component);
    }

    @Override
    protected void remove(OrganizationComponent component) {
        collegeList.remove(component);
    }

    @Override
    protected void print() {
        System.out.println("------------------"+getName()+"------------------");
        collegeList.stream().forEach(component -> component.print());
    }
}
