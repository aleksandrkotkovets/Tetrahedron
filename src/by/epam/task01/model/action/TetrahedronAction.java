package by.epam.task01.model.action;

import by.epam.task01.model.action.calculate.Calculateble;
import by.epam.task01.model.entity.Point;
import by.epam.task01.model.entity.Tetrahedron;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static by.epam.task01.model.constant.TetrahedronsConstant.*;
import static java.lang.Math.sqrt;

public class TetrahedronAction {
    private static final Logger LOGGER = Logger.getLogger(TetrahedronAction.class);

    public static Calculateble calculateble;

    public static List<Double> findSidesLengths(List<Point> points) {

        LOGGER.info("Method: findSidesLengths");

        List<Double> sides = new ArrayList<>();

        Double xA = points.get(0).getX();
        Double yA = points.get(0).getY();
        Double zA = points.get(0).getZ();

        Double xB = points.get(1).getX();
        Double yB = points.get(1).getY();
        Double zB = points.get(1).getZ();

        Double xC = points.get(2).getX();
        Double yC = points.get(2).getY();
        Double zC = points.get(2).getZ();

        Double xD = points.get(3).getX();
        Double yD = points.get(3).getY();
        Double zD = points.get(3).getZ();

        calculateble = (x1, y1, z1, x2, y2, z2) -> sqrt((x2 - x1) * (x2 - x1)
                + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));

        Double ab = Double.valueOf((Math.round(calculateble.calculateSide(xA, yA, zA, xB, yB, zB))));
        Double ac = Double.valueOf((Math.round(calculateble.calculateSide(xA, yA, zA, xC, yC, zC))));
        Double ad = Double.valueOf((Math.round(calculateble.calculateSide(xA, yA, zA, xD, yD, zD))));
        Double bc = Double.valueOf((Math.round(calculateble.calculateSide(xB, yB, zB, xC, yC, zC))));
        Double bd = Double.valueOf((Math.round(calculateble.calculateSide(xB, yB, zB, xD, yD, zD))));
        Double cd = Double.valueOf((Math.round(calculateble.calculateSide(xC, yC, zC, xD, yD, zD))));

        sides.add(ab);
        sides.add(ac);
        sides.add(ad);
        sides.add(bc);
        sides.add(bd);
        sides.add(cd);
        LOGGER.info("Sides:\n" + "AB=" + ab + '\n' + "AC=" + ac + '\n' + "AD=" + ad + '\n' + "BC=" + bc + '\n' + "BD=" + bd + '\n' + "CD=" + cd + '\n');

        return sides;
    }

    public static double calcSide(List<Point> points) {
        LOGGER.info("Method: calcSide");
        return Math.sqrt(Math.pow(points.get(0).getX() - points.get(1).getX(), SECOND_DEGREE) +
                Math.pow(points.get(0).getY() - points.get(1).getY(), SECOND_DEGREE) +
                Math.pow(points.get(0).getZ() - points.get(1).getZ(), SECOND_DEGREE));
    }

    public static double calcSide(Tetrahedron tetrahedron) {
        LOGGER.info("Method: calcSide");
        Point first = tetrahedron.getPointOne();
        Point second = tetrahedron.getPointTwo();
        return Math.sqrt(Math.pow(first.getX() - second.getX(), SECOND_DEGREE) +
                Math.pow(first.getY() - second.getY(), SECOND_DEGREE) +
                Math.pow(first.getZ() - second.getZ(), SECOND_DEGREE));
    }

    public static double calcSide(Point first, Point second) {
        LOGGER.info("Method: calcSide");
        return Math.sqrt(Math.pow(first.getX() - second.getX(), SECOND_DEGREE) +
                Math.pow(first.getY() - second.getY(), SECOND_DEGREE) +
                Math.pow(first.getZ() - second.getZ(), SECOND_DEGREE));
    }


    public static Double calcSquare(Tetrahedron tetrahedron) {
        LOGGER.info("Method: calculateSquare");
        return Math.pow(tetrahedron.getSide(), SECOND_DEGREE) * SQUARE_ROOT_OF_THREE;
    }

    public static Double calcSquare(Double side) {
        LOGGER.info("Method: calculateSquare");
        return Math.pow(side, SECOND_DEGREE) * SQUARE_ROOT_OF_THREE;
    }


    public static Double calcVolume(Tetrahedron tetrahedron) {
        LOGGER.info("Method: calculateVolume");
        return Math.pow(tetrahedron.getSide(), THIRD_DEGREE) * SQUARE_ROOT_OF_TWO / TWELVE;
    }

    public static Double calcVolume(Double side) {
        LOGGER.info("Method: calculateVolume");
        return Math.pow(side, THIRD_DEGREE) * SQUARE_ROOT_OF_TWO / TWELVE;
    }


    public static Double calcPerimeter(Tetrahedron tetrahedron) {
        LOGGER.info("Method: calculatePerimeter");
        return tetrahedron.getSide() * NUMBERS_OF_SIDES;
    }

    public static Double calcPerimeter(Double side) {
        LOGGER.info("Method: calculatePerimeter");
        return side * NUMBERS_OF_SIDES;
    }

    public  static double calcHeight(Tetrahedron tetrahedron){
        double side = tetrahedron.getSide();
        double height = Math.sqrt(TWO_ON_THREE)*side;
        return  height;
    }
}
