package by.epam.task01.action;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class CalculateTetrahedronDivideXOY {

    private static final TetrahedronAction CALCULATOR = new TetrahedronAction();

    public boolean isInteractionXOY(Tetrahedron tetrahedron){
        return !(isAllNegativeZ(tetrahedron.getAllPoints()) || isAllPositiveZ(tetrahedron.getAllPoints()));
    }

    private boolean isAllPositiveZ(List<Point> points){
        for(Point point : points){
            if(point.getZ() < 0){
                return false;
            }
        }
        return  true;
    }
    private boolean isAllNegativeZ(List<Point> points){
        for(Point point : points){
            if(point.getZ()> 0){
                return false;}
        }
        return  true;
    }

    private Point getTetrahedronTop(Tetrahedron tetrahedron) {
        List<Point> positiveZ = new ArrayList<>();
        List<Point> negativeZ = new ArrayList<>();
        for (Point point : tetrahedron.getAllPoints()) {
            if (point.getZ() >= 0) {
                positiveZ.add(point);
            } else {
                negativeZ.add(point);
            }
        }
        if(positiveZ.size()==1) {
            return positiveZ.get(0);
        }else{
            return negativeZ.get(0);
        }
    }
    public double calculateRatioVolumes(Tetrahedron tetrahedron){
        if(this.isInteractionXOY(tetrahedron)) {
            Point topOfTetrahedron = getTetrahedronTop(tetrahedron);
            double bigEdge = CALCULATOR.calcSide(tetrahedron);
            double bigHeight = CALCULATOR.calcHeight(tetrahedron);
            double smallEdge = (bigEdge * topOfTetrahedron.getZ()) / bigHeight;
            double bigTetrahedronVolume = CALCULATOR.calcVolume(bigEdge);
            double smallTetrahedronVolume = CALCULATOR.calcVolume(smallEdge);
            return smallTetrahedronVolume / (bigTetrahedronVolume - smallTetrahedronVolume);
        }
        else return 0.;
    }
}
