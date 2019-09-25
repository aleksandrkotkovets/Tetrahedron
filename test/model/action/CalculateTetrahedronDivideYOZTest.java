package model.action;

import by.epam.task01.action.CalculateTetrahedronDevideYOZ;
import by.epam.task01.idgenerator.IdGenerator;
import by.epam.task01.entity.Point;
import by.epam.task01.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculateTetrahedronDivideYOZTest {

    CalculateTetrahedronDevideYOZ calculator;

    private final static double DELTA = 0.02;

    @BeforeClass
    public void setUp() { calculator = new CalculateTetrahedronDevideYOZ(); }

    private final static Tetrahedron TETRAHEDRON_NOT_INTERACTION_YOZ = new Tetrahedron(
            IdGenerator.nextId(),
            new Point().newBuilder().x(1).y(2).z(2).build(),
            new Point().newBuilder().x(5).y(2).z(5).build(),
            new Point().newBuilder().x(3).y(4).z(4).build(),
            new Point().newBuilder().x(1).y(2).z(7).build());
    private final static Tetrahedron TETRAHEDRON_INTERACTION_YOZ = new Tetrahedron(
            IdGenerator.nextId(),
            new Point().newBuilder().x(-2).y(1).z(2).build(),
            new Point().newBuilder().x(-2).y(9).z(2).build(),
            new Point().newBuilder().x(-2).y(5).z(8.928).build(),
            new Point().newBuilder().x(4.532).y(5.4).z(4.31).build());


    @Test
    public void isNotInteractionXOZ(){
        boolean actual= calculator.isInteractionYOZ(TETRAHEDRON_NOT_INTERACTION_YOZ);
        Assert.assertFalse(actual);
    }

    @Test
    public void testCalculateRatioVolumes() {
        double expected = 0.5;
        double actual = calculator.calculateRatioVolumes(TETRAHEDRON_INTERACTION_YOZ);
        Assert.assertEquals(actual, expected, DELTA);
    }

}
