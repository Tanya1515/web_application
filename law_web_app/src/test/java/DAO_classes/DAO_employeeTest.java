package DAO_classes;

import org.testng.annotations.Test;
import entities.Employee;
import org.testng.Assert;
import static org.testng.Assert.*;

public class DAO_employeeTest {

    @Test
    public void testDelete_ok() {
        DAO_employee dao_emp = new DAO_employee();
        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        dao_emp.save(new_emp);

        Assert.assertEquals(dao_emp.delete(new_emp), true);
    }

    @Test
    public void testDelete_not_ok() {
        DAO_employee dao_emp = new DAO_employee();
        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        dao_emp.save(new_emp);
        dao_emp.delete(new_emp);

        Assert.assertEquals(dao_emp.delete(new_emp), false);
    }

    @Test
    public void testFindById_ok() {
        DAO_employee dao_emp = new DAO_employee();
        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        dao_emp.save(new_emp);

        Assert.assertNotNull(dao_emp.findById(new_emp.getId_employee()));
        dao_emp.delete(new_emp);
    }

    @Test
    public void testFindById_not_ok() {
        DAO_employee dao_emp = new DAO_employee();
        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);

        Assert.assertNull(dao_emp.findById(new_emp.getId_employee()));
    }


    @Test
    public void testSave_ok() {
        DAO_employee dao_emp = new DAO_employee();
        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);

        Assert.assertEquals(dao_emp.save(new_emp), true);
        dao_emp.delete(new_emp);
    }

    @Test
    public void testSave_not_ok() {
        DAO_employee dao_emp = new DAO_employee();
        Employee new_emp = new Employee("Tanya", "Ozerova", null, "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);

        Assert.assertEquals(dao_emp.save(new_emp), false);
    }

    @Test
    public void testUpdate_ok() {
        DAO_employee dao_emp = new DAO_employee();
        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        dao_emp.save(new_emp);

        new_emp.setWork_experience(3);
        Assert.assertEquals(dao_emp.update(new_emp), true);
        dao_emp.delete(new_emp);
    }

    @Test
    public void testUpdate_not_ok() {
        DAO_employee dao_emp = new DAO_employee();
        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);

        Assert.assertEquals(dao_emp.update(new_emp), false);

    }
}