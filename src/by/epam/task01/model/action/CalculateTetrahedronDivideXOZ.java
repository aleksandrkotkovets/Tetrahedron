package by.epam.task01.model.action;

import by.epam.task01.model.entity.Point;
import by.epam.task01.model.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class CalculateTetrahedronDivideXOZ {
    private static final TetrahedronAction CALCULATOR = new TetrahedronAction();

    public boolean isInteractionXOZ(Tetrahedron tetrahedron){
        return !(isAllNegativeY(tetrahedron.getAllPoints()) || isAllPositiveY(tetrahedron.getAllPoints()));
    }

    private boolean isAllPositiveY(List<Point> points){
        for(Point point : points){
            if(point.getY() < 0){
                return false;
            }
        }
        return  true;
    }
    private boolean isAllNegativeY(List<Point> points){
        for(Point point : points){
            if(point.getY()> 0){
                return false;}
        }
        return  true;
    }

    private Point getTetrahedronTop(Tetrahedron tetrahedron) {
        List<Point> positiveY = new ArrayList<>();
        List<Point> negativeY = new ArrayList<>();
        for (Point point : tetrahedron.getAllPoints()) {
            if (point.getY() >= 0) {
                positiveY.add(point);
            } else {
                negativeY.add(point);
            }
        }
        if(positiveY.size()==1) {
            return positiveY.get(0);
        }else{
            return negativeY.get(0);
        }
    }
    public double calculateRatioVolumes(Tetrahedron tetrahedron){
        if(this.isInteractionXOZ(tetrahedron)) {
            Point topOfTetrahedron = getTetrahedronTop(tetrahedron);
            double bigEdge = CALCULATOR.calcSide(tetrahedron);
            double bigHeight = CALCULATOR.calcHeight(tetrahedron);
            double smallEdge = (bigEdge * topOfTetrahedron.getY()) / bigHeight;
            double bigTetrahedronVolume = CALCULATOR.calcVolume(bigEdge);
            double smallTetrahedronVolume = CALCULATOR.calcVolume(smallEdge);
            return smallTetrahedronVolume / (bigTetrahedronVolume - smallTetrahedronVolume);
        }
        else return 0.;
    }

}
