package by.epam.task01.model.repository;

import by.epam.task01.model.action.TetrahedronAction;

public class SearchTetraSpeification {
    private long minId;
    private long maxId;
    private double minSquare;
    private double minVolume;
    private double minSide;

    private static final TetrahedronAction CALCULATOR = new TetrahedronAction();


    public final TetraSpecification MORE_THEN_MIN_ID = t -> t.getId() >= minId;

    public final TetraSpecification LESS_THEN_MAX_ID = t -> t.getId() <= maxId;

    public final TetraSpecification MORE_THEN_MIN_SQUARE = t -> CALCULATOR.calcSquare(t) >= minSquare;

    public final TetraSpecification MORE_THEN_MIN_VOLUME = t -> CALCULATOR.calcVolume(t) >= minVolume;

    public final TetraSpecification MORE_THEN_MIN_EDGE = t -> t.getSide() >= minSide;

    public final TetraSpecification IN_THE_FIRST_QUADRANT = t -> {
        return
                t.getPointOne().getX() >= 0 &&
                        t.getPointOne().getY() >= 0 &&
                        t.getPointOne().getZ() >= 0 &&

                        t.getPointTwo().getX() >= 0 &&
                        t.getPointTwo().getY() >= 0 &&
                        t.getPointTwo().getZ() >= 0 &&

                        t.getPointThree().getX() >= 0 &&
                        t.getPointThree().getY() >= 0 &&
                        t.getPointThree().getZ() >= 0 &&

                        t.getPointFour().getX() >= 0 &&
                        t.getPointFour().getY() >= 0 &&
                        t.getPointFour().getZ() >= 0;
    };

    public void setMinId(long minId) {
        this.minId = minId;
    }

    public void setMaxId(long maxId) {
        this.maxId = maxId;
    }

    public void setMinSquare(double minSquare) {
        this.minSquare = minSquare;
    }

    public void setMinVolume(double minVolume) {
        this.minVolume = minVolume;
    }

    public void setMinEdge(double minEdge) {
        this.minSide = minEdge;
    }
}