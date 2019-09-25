package model.repository;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Tetrahedron;
import by.epam.task01.repository.SearchTetraSpeification;
import by.epam.task01.repository.TetraRepository;
import by.epam.task01.repository.impl.TetraRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TetraRepositoryQueryTest {

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
    public void testQueryMinId() {
        SearchTetraSpeification specification = new SearchTetraSpeification();
        specification.setMinId(434);
        List<Tetrahedron> expected = Arrays.asList(FOUR, FIVE, SIX);
        List<Tetrahedron> actual = repository.query(specification.MORE_THEN_MIN_ID);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryMaxId() {
        SearchTetraSpeification specification = new SearchTetraSpeification();
        specification.setMaxId(435);
        List<Tetrahedron> expected = Arrays.asList(ONE, TWO, THREE, FOUR);
        List<Tetrahedron> actual = repository.query(specification.LESS_THEN_MAX_ID);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryMinSquare() {
        SearchTetraSpeification specification = new SearchTetraSpeification();
        specification.setMinSquare(60);
        List<Tetrahedron> expected = Arrays.asList(TWO, THREE, FIVE);
        List<Tetrahedron> actual = repository.query(specification.MORE_THEN_MIN_SQUARE);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryMinVolume() {
        SearchTetraSpeification specification = new SearchTetraSpeification();
        specification.setMinVolume(20);
        List<Tetrahedron> expected = Arrays.asList( TWO, THREE, FIVE);
        List<Tetrahedron> actual = repository.query(specification.MORE_THEN_MIN_VOLUME);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryMinEdge() {
        SearchTetraSpeification specification = new SearchTetraSpeification();
        specification.setMinEdge(3);
        List<Tetrahedron> expected = Arrays.asList(TWO, THREE, FOUR, FIVE);
        List<Tetrahedron> actual = repository.query(specification.MORE_THEN_MIN_EDGE);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryInTheFirstQuadrant() {
        SearchTetraSpeification specification = new SearchTetraSpeification();
        specification.setMinId(433);
        List<Tetrahedron> expected = Arrays.asList(SIX);
        List<Tetrahedron> actual = repository.query(specification.IN_THE_FIRST_QUADRANT);
        Assert.assertNotEquals(actual, expected);
    }
}
