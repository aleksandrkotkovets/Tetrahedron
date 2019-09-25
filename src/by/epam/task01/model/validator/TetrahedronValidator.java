package by.epam.task01.model.validator;

import java.util.List;

public interface TetrahedronValidator {
    boolean isEqualSides(List<Double> sides);

    boolean isTetrahedron(List<Double> sides);

    List<String> checkReadData(List<String> lines);

    boolean isCorrectSection(Double xA, Double zA, Double xB, Double yB, Double zB, Double yC, Double zC);

    boolean checkCountOfGoodData();

}
