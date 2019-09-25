package model.warehouse;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Tetrahedron;
import by.epam.task01.entity.TetrahedronCharacteristic;
import by.epam.task01.warehouse.Warehouse;
import by.epam.task01.warehouse.impl.WarehouseImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WareHouseImplTest {

    Warehouse warehouse;

    @BeforeTest
    public void setUp() {
        warehouse = WarehouseImpl.getInstance();
        warehouse.addRecord(new TetrahedronCharacteristic(ONE));
        warehouse.addRecord(new TetrahedronCharacteristic(TWO));
        warehouse.addRecord(new TetrahedronCharacteristic(THREE));
    }


    private final static Tetrahedron ONE = new Tetrahedron(
            432,
            new Point().newBuilder().x(0.577).y(0).z(1.634).build(),
            new Point().newBuilder().x(0).y(-1).z(0).build(),
            new Point().newBuilder().x(1.732).y(0).z(0).build(),
            new Point().newBuilder().x(0).y(1).z(0).build());

    private final static Tetrahedron TWO = new Tetrahedron(
            433,
            new Point().newBuilder().x(-2).y(1).z(2).build(),
            new Point().newBuilder().x(-2).y(9).z(2).build(),
            new Point().newBuilder().x(-2).y(5).z(8.928).build(),
            new Point().newBuilder().x(4.532).y(5).z(4.31).build());

    private final static Tetrahedron THREE = new Tetrahedron(
            434,
            new Point().newBuilder().x(1).y(2).z(-2).build(),
            new Point().newBuilder().x(9).y(2).z(-2).build(),
            new Point().newBuilder().x(5).y(8.93).z(-2).build(),
            new Point().newBuilder().x(5).y(4.31).z(4.532).build());

    @Test
    public void testUpdateRecord() {
        List<TetrahedronCharacteristic> expected = new ArrayList<>();
        TetrahedronCharacteristic changedRecord = new TetrahedronCharacteristic(new Tetrahedron(101,
                new Point().newBuilder().x(0).y(-5).z(0).build(),
                new Point().newBuilder().x(0).y(-1).z(0).build(),
                new Point().newBuilder().x(1.732).y(0).z(0).build(),
                new Point().newBuilder().x(0).y(1).z(0).build()));

        expected.add(new TetrahedronCharacteristic(TWO));
        expected.add(new TetrahedronCharacteristic(THREE));
        expected.add(changedRecord);

        ONE.setPointOne(new Point().newBuilder().x(0).y(-5).z(0).build());
        List<TetrahedronCharacteristic> actual =  warehouse.getAllRecords();
        Assert.assertEquals(actual ,expected);

    }
}
