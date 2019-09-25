package model.action;

import by.epam.task01.action.CalculateTetrahedronDivideXOY;
import by.epam.task01.idgenerator.IdGenerator;
import by.epam.task01.entity.Point;
import by.epam.task01.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculateTetrahedronDivideXOYTest {
    CalculateTetrahedronDivideXOY calculator;
    private final static double DELTA = 0.02;

    @BeforeClass
    public void setUp() {
        calculator = new CalculateTetrahedronDivideXOY();
    }


    private final static Tetrahedron TETRAHEDRON_NOT_INTERACTION_XOY = new Tetrahedron(
            IdGenerator.nextId(),
            new Point().newBuilder().x(1).y(2).z(2).build(),
            new Point().newBuilder().x(5).y(8).z(5).build(),
            new Point().newBuilder().x(3).y(2).z(4).build(),
            new Point().newBuilder().x(1).y(2).z(7).build());
    private final static Tetrahedron TETRAHEDRON_INTERACTION_XOY = new Tetrahedron(
            IdGenerator.nextId(),
            new Point().newBuilder().x(1).y(2).z(-2).build(),
            new Point().newBuilder().x(9).y(2).z(-2).build(),
            new Point().newBuilder().x(5).y(8.93).z(-2).build(),
            new Point().newBuilder().x(5).y(4.31).z(4.532).build());

    @Test
    public void isNotInteractionXOZ() {
        boolean actual = calculator.isInteractionXOY(TETRAHEDRON_NOT_INTERACTION_XOY);
        Assert.assertFalse(actual);
    }


    @Test
    public void testCalculateRatioVolumes() {
        double expected = 0.5;
        double actual = calculator.calculateRatioVolumes(TETRAHEDRON_INTERACTION_XOY);
        Assert.assertEquals(actual, expected, DELTA);

    }
}
