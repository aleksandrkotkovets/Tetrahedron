package model.parser;

import by.epam.task01.model.entity.Point;
import by.epam.task01.model.parser.DataParser;
import by.epam.task01.model.validator.impl.TetrahedronValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static by.epam.task01.model.parser.DataParser.parsPoints;

public class DataParserImplTest {

    DataParser parser;

    @BeforeTest
    public void setUp() {
        parser = DataParser.getInstance();
    }

    @Test(description = "data is valid")
    public void testParseCorrectData()  {
        List<Point> expected = new ArrayList<>();
        TetrahedronValidatorImpl.countOfGoodData = 4;

        expected.add(new Point().newBuilder().x(1).y(2).z(-2).build());
        expected.add(new Point().newBuilder().x(9).y(2).z(-2).build());
        expected.add(new Point().newBuilder().x(5).y(8.93).z(-2).build());
        expected.add(new Point().newBuilder().x(5).y(4.31).z(4.532).build());
        List<String> lines = new ArrayList<>();
        lines.add("1 2 -2");
        lines.add("9 2 -2");
        lines.add("5 8.93 -2");
        lines.add("5 4.31 4.532");
        List<Point> actual = parsPoints( lines);
        Assert.assertEquals(actual,expected);
    }

}
