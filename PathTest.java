package com.example.sivakrishna.myapplication;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PathTest {


    @Test
    public void lowestSumFoundWithUpperWrapping() {
        //arrange
        int[][] grid = {{3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7 ,2 ,8 ,6 ,4}};

        PathResult pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(16, pathSumResult.getLeastCostSum());
    }

    @Test
    public void lowestSumFoundWithLowerWrapping() {
        //arrange
        int[][] grid = {{3 ,4, 1, 2, 8, 6},
                {6 ,1 ,8 ,2 ,7 ,4},
                {5 ,9 ,3 ,9 ,9, 5},
                {8 ,4 ,1 ,3 ,2 ,6},
                {3, 7, 2, 1, 2, 3}};

        //act
        PathResult pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(11, pathSumResult.getLeastCostSum());

    }
    @Test
    public void Singlrowmatrix() {
        //arrange
        int[][] grid = {{5, 8, 5, 3, 5}};

        //act
        PathResult pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(26, pathSumResult.getLeastCostSum());
    }
    @Test
    public void falseIfNoPathCompletedDueToCostOver50() {
        //arrange
        int[][] grid = {{69 ,10, 19, 10, 19},
                {51, 23, 20, 19, 12},
                {60, 12, 20, 11, 10}};

        //act
        PathResult pathResult = Path.navigate(grid);

        //assert
        assertEquals(false, pathResult.getIsPathComplete());
    }



    @Test
    public void checkIfOnevalueIsAbove50(){
        int [][] grid = {{60,3,3,6},
                {6,3,7,9},
                {5,6,8,3}
    };

        //act
        PathResult pathResult = Path.navigate(grid);

        //assert
        assertEquals(true, pathResult.getIsPathComplete());


    }
    @Test
    public  void SIngleColoumnMatrix(){
        int[][] grid = {{5},{ 8},{ 5}, {3},{ 5}};

        //act
        PathResult pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(0, pathSumResult.getLeastCostSum());
    }

    @Test
    public void NegativeValues(){
        int[][] grid = {{6,3,-5,9},
                {-5,2,4,10},
                {3,-2,6,10},
                {6,-1,-2,10}};

        
        PathResult pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(0, pathSumResult.getLeastCostSum());
    }
    @Test
    public void LargeNumberOfColoumns(){
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};

        //act
        PathResult pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(20, pathSumResult.getLeastCostSum());
    }
    @Test
    public void Large(){
        int[][] grid = {{51, 51},
                {0, 51},
                {51, 51},
                {5,5}};
        //act
        PathResult pathSumResult = Path.navigate(grid);
        //assert
        assertEquals(10, pathSumResult.getLeastCostSum());
    }


    //Test Methods
    public int[][] createGrid(int numRows, int numColumns) {
        int[][] grid = new int[numRows][numColumns];
        Random random = new Random();

        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                int randomInt = random.nextInt();
                grid[row][column] = randomInt;
            }
        }
        return grid;
    }

}