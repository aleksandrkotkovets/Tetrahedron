package by.epam.task01.model.parser;

import by.epam.task01.model.entity.Point;
import by.epam.task01.model.validator.TetrahedronValidator;
import by.epam.task01.model.validator.impl.TetrahedronValidatorImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    private static final Logger LOGGER = LogManager.getLogger(DataParser.class);

    private static final DataParser INSTANCE = new DataParser();

    private DataParser() {}

    public static DataParser getInstance() {
        return INSTANCE;
    }

    public static List<Point> parsPoints(List<String> lines) {
        LOGGER.info("Method: parsPoints");

        TetrahedronValidator validator = TetrahedronValidatorImpl.getInstance();

        Point point;
        String[] numbers;
        List<Point> points = new ArrayList<>();

        if (validator.checkCountOfGoodData()) {
            for (String line : lines) {
                numbers = line.split(" ");
                point = Point.newBuilder()
                        .x(Double.parseDouble(numbers[0]))
                        .y(Double.parseDouble(numbers[1]))
                        .z(Double.parseDouble(numbers[2]))
                        .build();
                points.add(point);
                LOGGER.info("Coordinate(x,y,z):" + lines);
            }
        } else {
            LOGGER.info("Count of good reader < 4 ;");
        }
        return points;
    }
}
