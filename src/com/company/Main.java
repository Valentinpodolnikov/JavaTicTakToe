package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1.Создать переменную поля размером 3х3 (игра проходит на одном общем поле)
        // 2. Очистить массивы компа и человека (заполнить пустотой)
        // 3. Ход человека (после него переход хода компьютеру)
        // 4. Ход компьютера (после него ход переходит человеку)
        // 5. Начиная с 3-го хода проверять условие победы (в один ряд по любой их трех горизонталей, трех вертикалей и двух диагоналей должны стоять одинаковые символы)
        // 6. В случае, если нет ни одного совпадения по пункту 5 вывести на экран "Ничья" , в случае совпадения вывести на экран "Победил комп/человек"

        int fieldSize = 3;
        char field[][] = new char[fieldSize][fieldSize];


        final char EMPTY_CELL = '.';          //не открытая ячейка
        final char PLAYER_CELL = 'X';         //яйчейки игрока
        final char COMP_CELL = 'O';           //ячейки компа

        int iCell = 0, jCell = 0;

        boolean isPlay = true;
        boolean isCorrectInput = true;

        final int USER_STEP = 1;
        final int COMP_STEP = 2;

        int step = USER_STEP;


        //заполняем поле пустыми ячейками

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = EMPTY_CELL;
            }

        }

        System.out.println("Игра началась!");

        while (isPlay == true) {
            for (int k = 0; k < 1; k++) {
                System.out.println();
            }

            //выводим поле на экран

            for (int i = 0; i < fieldSize; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    System.out.printf("%-3c", field[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            Random random = new Random();

            switch (step) {
                case USER_STEP:
                    System.out.println("Ход игрока");

                    do {
                        isCorrectInput = true;
                        Scanner input = new Scanner(System.in);

                        try {
                            System.out.print("Введите i: ");
                            iCell = input.nextInt();

                            System.out.print("Введите j: ");
                            jCell = input.nextInt();


                        } catch (Exception e) {
                            isCorrectInput = false;
                            continue;
                        }
                        if (iCell < 0 || iCell > fieldSize - 1 || jCell < 0 || jCell > fieldSize - 1) {


                            isCorrectInput = false;
                            continue;

                        }
                        for (int i = 0; i < 1; i++) {
                            for (int j = 0; j < 1; j++) {

                                field[iCell][jCell] = PLAYER_CELL;

                            }
                        }
                    }

                    while (isCorrectInput == false);

                    for (int i = 0; i < fieldSize; i++) {
                        for (int j = 0; j < fieldSize; j++) {
                            System.out.printf("%-3c", field[i][j]);
                        }
                        System.out.println();
                    }

                case COMP_STEP:
                    System.out.println("Ход компьютера");
                    System.out.println("Для продолжения нажмите <Enter>");
                    Scanner input = new Scanner(System.in);
                    input.nextLine();

                    for (int i = 0; i < 1; i++) {
                        for (int j = 0; j < 1; j++) {
                            do {
                                iCell = random.nextInt(fieldSize);
                                jCell = random.nextInt(fieldSize);
                            }
                            while (field[iCell][jCell] != EMPTY_CELL);

                            field[iCell][jCell] = COMP_CELL;

                        }

                    }

            }

            //условия победы игрока

            if (field[0][0] == PLAYER_CELL && field[0][1] == PLAYER_CELL && field[0][2] == PLAYER_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }

            if (field[1][0] == PLAYER_CELL && field[1][1] == PLAYER_CELL && field[1][2] == PLAYER_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }
            if (field[2][0] == PLAYER_CELL && field[2][1] == PLAYER_CELL && field[2][2] == PLAYER_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }
            if (field[0][0] == PLAYER_CELL && field[1][0] == PLAYER_CELL && field[2][0] == PLAYER_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }

            if (field[0][1] == PLAYER_CELL && field[1][1] == PLAYER_CELL && field[2][1] == PLAYER_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }
            if (field[0][2] == PLAYER_CELL && field[1][2] == PLAYER_CELL && field[2][2] == PLAYER_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }
            if (field[2][0] == PLAYER_CELL && field[1][1] == PLAYER_CELL && field[0][2] == PLAYER_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }
            if (field[0][0] == PLAYER_CELL && field[1][1] == PLAYER_CELL && field[2][2] == PLAYER_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }



            //условия победы компьютера

            if (field[0][0] == COMP_CELL && field[0][1] == COMP_CELL && field[0][2] == COMP_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (field[1][0] == COMP_CELL && field[1][1] == COMP_CELL && field[1][2] == COMP_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (field[2][0] == COMP_CELL && field[2][1] == COMP_CELL && field[2][2] == COMP_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (field[0][0] == COMP_CELL && field[1][0] == COMP_CELL && field[2][0] == COMP_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (field[0][1] == COMP_CELL && field[1][1] == COMP_CELL && field[2][1] == COMP_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (field[0][2] == COMP_CELL && field[1][2] == COMP_CELL && field[2][2] == COMP_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (field[2][0] == COMP_CELL && field[1][1] == COMP_CELL && field[0][2] == COMP_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (field[0][0] == COMP_CELL && field[1][1] == COMP_CELL && field[2][2] == COMP_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }

        }

    }
}

