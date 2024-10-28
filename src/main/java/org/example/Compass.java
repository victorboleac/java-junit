package org.example;

import static javax.swing.SwingConstants.NORTH;

public class Compass {
    public enum Point{
        NORTH, SOUTH, EAST, WEST
    }
    public enum Direction {
        LEFT, RIGHT
    }
    public Point point;
    public Point rotate(Point point, Direction direction){
            if(point == Point.NORTH){
                if(direction == Direction.RIGHT){
                    this.point = Point.EAST;
                    return this.point;
                }
                return null;

            } else if (point == Point.EAST) {
                if(direction == Direction.RIGHT){
                    this.point = Point.SOUTH;
                    return this.point;
                }
            } else if (point == Point.SOUTH) {
                if(direction == Direction.RIGHT){
                    this.point = Point.WEST;
                    return this.point;
                }
            } else if (point == Point.WEST){
                if(direction == Direction.RIGHT){
                    this.point = Point.NORTH;
                    return this.point;
                }

            }

        return null;
    }
}
