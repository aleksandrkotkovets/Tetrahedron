package by.epam.task01.model.entity;

import by.epam.task01.model.idgenerator.IdGenerator;
import by.epam.task01.model.observer.Observer;
import by.epam.task01.model.observer.impl.ObserverImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

import static by.epam.task01.model.action.TetrahedronAction.calcSide;

/**
 * The class describes the entity Tetrahedron.
 *
 * @author Kotkovets Aleksandr Sergeevich
 * @version 1.0 11.09.2019
 * @since JDK1.0
 */

public class Tetrahedron extends Observable {

    private long idTetrahedron;
    private Double side;
    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;
    private Point pointFour;

    Observer observer = new ObserverImpl();

    public Tetrahedron(long idTetrahedron,List<Point> points) {
        this.idTetrahedron = idTetrahedron;
        this.pointOne = points.get(0);
        this.pointTwo = points.get(1);
        this.pointThree = points.get(2);
        this.pointFour = points.get(3);
        side = calcSide(points);
    }

    public void setIdTetrahedron(long idTetrahedron) {
        this.idTetrahedron = idTetrahedron;
    }

    public static Tetrahedron createTetrahedron(List<Point> points){
        return new Tetrahedron(IdGenerator.nextId(), points);
    }

    public Tetrahedron(long idTetrahedron,  Point pointOne, Point pointTwo, Point pointThree, Point pointFour) {
        this.idTetrahedron = idTetrahedron;
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;
        this.pointFour = pointFour;
        side = calcSide(pointOne,pointTwo);
    }

    public static Tetrahedron createTetrahedron(Point pointOne, Point pointTwo, Point pointThree, Point pointFour) {
        return new Tetrahedron(IdGenerator.nextId(), pointOne, pointTwo, pointThree, pointFour);
    }

    public void setPointOne(Point pointOne) {
        this.pointOne = pointOne;
        notifyObserver();
    }


    public void setPointTwo(Point pointTwo) {
        this.pointTwo = pointTwo;
        notifyObserver();
    }

    public void setPointThree(Point pointThree) {
        this.pointThree = pointThree;
        notifyObserver();
    }


    public void setPointFour(Point pointFour) {
        this.pointFour = pointFour;
        notifyObserver();
    }

    public void setSide(Double side) {
        this.side = side;
        notifyObserver();
    }

    public long getId() {
        return idTetrahedron;
    }

    public Point getPointOne() {
        return pointOne;
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public Point getPointThree() {
        return pointThree;
    }

    public Point getPointFour() {
        return pointFour;
    }

    public List<Point> getAllPoints() {
        return Arrays.asList(pointOne, pointTwo, pointThree, pointFour);
    }

    public double getSide() {
        return side;
    }



    @Override
    public String toString() {
        return "Tetrahedron{" +
                "id=" + idTetrahedron +
                ", pointOne=" + pointOne +
                ", pointTwo=" + pointTwo +
                ", pointThree=" + pointThree +
                ", pointFour=" + pointFour +
                ", side=" + side +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tetrahedron that = (Tetrahedron) obj;
        return idTetrahedron == that.idTetrahedron &&
                side == that.side &&
                pointOne.equals(that.pointOne) &&
                pointTwo.equals(that.pointTwo) &&
                pointThree.equals(that.pointThree) &&
                pointFour.equals(that.pointFour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTetrahedron, side, pointOne, pointTwo, pointThree, pointFour);
    }

    public void notifyObserver() {
        side = calcSide(pointOne, pointTwo);
        observer.update(this);
    }
}
