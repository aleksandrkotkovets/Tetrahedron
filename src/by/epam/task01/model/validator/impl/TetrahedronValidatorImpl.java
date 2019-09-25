package by.epam.task01.model.validator.impl;

import by.epam.task01.model.validator.TetrahedronValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.task01.model.constant.TetrahedronsConstant.FIND_ONLY_NUMBERS;


public class TetrahedronValidatorImpl implements TetrahedronValidator {

    private static final Logger LOGGER = LogManager.getLogger(TetrahedronValidatorImpl.class);

    public static int countOfBadData = 0;
    public static int countOfGoodData = 0;

    private static final TetrahedronValidatorImpl INSTANCE = new TetrahedronValidatorImpl();

    private TetrahedronValidatorImpl() {
    }

    public static TetrahedronValidatorImpl getInstance() {
        return INSTANCE;
    }

    public boolean isEqualSides(List<Double> sides) {

        LOGGER.info("Method: isEqualSides");

        boolean result;
        if (sides.get(0).equals(sides.get(1)) && sides.get(1).equals(sides.get(2))
                && sides.get(2).equals(sides.get(3))) {
            LOGGER.info("Sides are equal.");
            result = true;
        } else {
            LOGGER.info("Sides are not equal.");
            result = false;
        }
        return result;
    }

    public boolean isTetrahedron(List<Double> sides) {

        LOGGER.info("Method: isTetrahedron");

        if (isEqualSides(sides) == true && sides.get(0) != 0) {
            LOGGER.info("It's a tetrahedron.");
            return true;
        } else {
            LOGGER.info("It's not a tetrahedron.");
            return false;
        }
    }

    public List<String> checkReadData(List<String> lines) {

        LOGGER.info("Method: checkReadData");

        List<String> resultLines = new ArrayList<>();

        Pattern pattern = Pattern.compile(FIND_ONLY_NUMBERS);
        Matcher matcher;

        for (int i = 0; i < lines.size(); i++) {
            matcher = pattern.matcher(lines.get(i));
            if (matcher.matches()) {
                resultLines.add(lines.get(i));
                countOfGoodData++;
            } else {
                countOfBadData++;
            }

        }
        LOGGER.info("Count of Good reader = " + countOfGoodData + "\n" + "Count of Bad reader = " + countOfBadData);
        return resultLines;
    }


    public boolean isCorrectSection(Double xA, Double zA, Double xB, Double yB, Double zB, Double yC, Double zC) {

        boolean isCorrect = false;
        Double xBase = 0.0, yBase = 0.0, zBase = 0.0;
        if ((xBase == xB && xBase < xA) || (xBase > xB && xBase < xA) || (xBase > xB && xBase == xA)) {
            isCorrect = true;
        } else if ((yBase > yB && yBase < yC) || (yC == yBase && yBase > yB)) {
            isCorrect = true;
        } else if (zA == zBase && zC == zBase && zB == zBase) {
            isCorrect = true;
        }
        return isCorrect;
    }

    public boolean checkCountOfGoodData() {
        boolean result = true;
        if (countOfGoodData < 4) {
            LOGGER.warn("Count of Good reader = " + countOfGoodData + "\n" + "Count of Bad reader = " + countOfBadData);
            result = false;
        }
        return result;
    }
}
