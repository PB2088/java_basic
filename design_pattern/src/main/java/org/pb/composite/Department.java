package org.pb.composite;

/**
 * @author bo.peng
 * @create 2020-03-02 15:01
 */
public class Department extends OrganizationComponent {

    public Department(String name, String description) {
        super(name, description);
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }
}
