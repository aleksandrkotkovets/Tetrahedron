package by.epam.task01.model.entity;

import by.epam.task01.model.action.TetrahedronAction;

public class TetrahedronCharacteristic {
    private long id;
    private double square;
    private double volume;
    private double perimeter;

    public TetrahedronCharacteristic(long id, double square, double volume, double perimeter) {
        this.id = id;
        this.square = square;
        this.volume = volume;
        this.perimeter = perimeter;
    }

    public TetrahedronCharacteristic (Tetrahedron tetrahedron){
        TetrahedronAction action = new TetrahedronAction();
        this.id = tetrahedron.getId();
        this.square = action.calcSquare(tetrahedron);
        this.volume = action.calcVolume(tetrahedron);
        this.perimeter = action.calcPerimeter(tetrahedron);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public long getId() {
        return id;
    }

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }

    public double getPerimeter() {
        return perimeter;
    }


    @Override
    public String toString() {
        return "TetraWarehouseRecord{" +
                "id=" + id +
                ", square=" + square +
                ", volume=" + volume +
                ", perimeter=" + perimeter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TetrahedronCharacteristic that = (TetrahedronCharacteristic) o;
        return  Double.compare(that.square, square) == 0 &&
                Double.compare(that.volume, volume) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        int PRIME = 31;
        hash *= PRIME + Double.valueOf(square);
        hash *= PRIME + Double.valueOf(volume);
        hash *= PRIME + Double.valueOf(perimeter);
        return hash;
    }

}
