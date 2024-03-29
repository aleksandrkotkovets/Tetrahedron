package model.repository;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Tetrahedron;
import by.epam.task01.repository.TetraRepository;
import by.epam.task01.repository.impl.TetraRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TetraRepositoryImplTest {

    TetraRepository repository;

    @BeforeTest
    public void setUp() {
        repository = new TetraRepositoryImpl();
        repository.addTetrahedron(ONE);
        repository.addTetrahedron(TWO);
        repository.addTetrahedron(THREE);
        repository.addTetrahedron(FOUR);
        repository.addTetrahedron(FIVE);
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

    private final static Tetrahedron FOUR = new Tetrahedron(
            435,
            new Point().newBuilder().x(2.82).y(1.66).z(0).build(),
            new Point().newBuilder().x(-2).y(0.41).z(0).build(),
            new Point().newBuilder().x(0.7).y(-0.4).z(4.19).build(),
            new Point().newBuilder().x(1.42).y(-3.27).z(0).build()
    );

    private final static Tetrahedron FIVE = new Tetrahedron(
            436,
            new Point().newBuilder().x(-2.83).y(0.96).z(0).build(),
            new Point().newBuilder().x(1.42).y(-3.27).z(0).build(),
            new Point().newBuilder().x(1.3).y(1.57).z(0).build(),
            new Point().newBuilder().x(-0.04).y(-0.89).z(3.95).build()
    );

    private final static Tetrahedron SIX = new Tetrahedron(
            437,
            new Point().newBuilder().x(0.36).y(1.25).z(0).build(),
            new Point().newBuilder().x(2.18).y(0.83).z(0).build(),
            new Point().newBuilder().x(1.64).y(2.62).z(0).build(),
            new Point().newBuilder().x(1.4).y(1.57).z(1.53).build()
    );

    @Test
    public void tesAddTetrahedron() {
        List<Tetrahedron> expected = Arrays.asList(ONE,TWO,THREE, FOUR,FIVE,SIX);
        repository.addTetrahedron(SIX);
        List<Tetrahedron> actual = repository.getAllTetrahedrons();
        Assert.assertEquals(actual ,expected);
    }

    @Test
    public void testRemoveTetrahedron() {

        List<Tetrahedron> expected = Arrays.asList(ONE, TWO, FOUR, FIVE);
        repository.removeTetrahedron(THREE);
        repository.removeTetrahedron(SIX);
        List<Tetrahedron> actual = repository.getAllTetrahedrons();
        Assert.assertEquals(actual ,expected);
    }

    @Test(description = "update first point in first tetrahedron in repository")
    public void testUpdateTetrahedron() {
        ONE.setPointOne(new Point().newBuilder().x(0).y(0).z(0).build());
        Tetrahedron actual = repository.getTetrahedron(0);
        Assert.assertEquals(actual, ONE);
    }

}
