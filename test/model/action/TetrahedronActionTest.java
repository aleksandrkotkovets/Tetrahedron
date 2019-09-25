package model.action;

import by.epam.task01.action.TetrahedronAction;
import by.epam.task01.idgenerator.IdGenerator;
import by.epam.task01.entity.Point;
import by.epam.task01.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronActionTest {

    TetrahedronAction action;
    private final static double DELTA = 0.01;

    @BeforeClass
    public void setUp() {
        action = new TetrahedronAction();
    }

    private static final Tetrahedron TETRAHEDRON = new Tetrahedron(
            IdGenerator.nextId(),
            new Point().newBuilder().x(-3).y(0).z(0).build(),
            new Point().newBuilder().x(0).y(-0.35).z(0).build(),
            new Point().newBuilder().x(-1.2).y(2.43).z(0).build(),
            new Point().newBuilder().x(-1.4).y(0.69).z(2.47).build()
    );

    @Test
    public void testFindSidesLengthsRight(){
      List<Double> expected = new ArrayList<>();
      expected.add(3.0);
      expected.add(3.0);
      expected.add(3.0);
      expected.add(3.0);
      expected.add(3.0);
      expected.add(3.0);
      List<Double> actual = findSidesLengths(TETRAHEDRON.getAllPoints());
      Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindSidesLengthsWrong(){
        List<Double> expected = new ArrayList<>();
        expected.add(3.5);
        expected.add(3.0);
        expected.add(3.3);
        expected.add(3.0);
        expected.add(3.0);
        expected.add(3.6);
        List<Double> actual = findSidesLengths(TETRAHEDRON.getAllPoints());
        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void testCalcSideRightFirstWay(){
        Double expected = 3.02;
        Double actual = calcSide(new Point().newBuilder().x(-3).y(0).z(0).build(),
                new Point().newBuilder().x(0).y(-0.35).z(0).build());
        Assert.assertEquals(expected,actual,DELTA);
    }

    @Test
    public void testCalcSideRightSecondWay(){
        Double expected = 3.02;
        Double actual = calcSide(TETRAHEDRON.getAllPoints());
        Assert.assertEquals(expected,actual,DELTA);
    }

    @Test
    public void testCalcSideRightThirdWay(){
        Double expected = 3.02;
        Double actual = calcSide(TETRAHEDRON);
        Assert.assertEquals(expected,actual,DELTA);
    }

    @Test
    public void testCalcSquareFirstWay(){
        Double expected = 15.8;
        Double actual = calcSquare(TETRAHEDRON);
        Assert.assertEquals(expected,actual,DELTA);
    }

    @Test
    public void testCalcSquareSecondWay(){
        Double expected = 15.8;
        Double side = 3.02;
        Double actual = calcSquare(side);
        Assert.assertEquals(expected,actual,DELTA);
    }

    @Test
    public void testCalcVolumeFirstWay(){
        Double expected = 3.24;
        Double side = 3.02;
        Double actual = calcVolume(side);
        Assert.assertEquals(expected,actual,DELTA);
    }

    @Test
    public void testCalcVolumeSecondWay(){
        Double expected = 3.24;
        Double actual = calcVolume(TETRAHEDRON);
        Assert.assertEquals(expected,actual,DELTA);
    }

    @Test
    public void testCalcPerimeterFirstWay(){
        Double expected = 18.12;
        Double side = 3.02;
        Double actual = calcPerimeter(side);
        Assert.assertEquals(expected,actual,DELTA);
    }

    @Test
    public void testCalcPerimeterSecondWay(){
        Double expected = 18.12;
        Double actual = calcPerimeter(TETRAHEDRON);
        Assert.assertEquals(expected,actual,DELTA);
    }

    @Test
    public void testCalcHeight(){
        Double expected = 2.46;
        Double actual = calcHeight(TETRAHEDRON);
        Assert.assertEquals(expected,actual,DELTA);
    }
}

