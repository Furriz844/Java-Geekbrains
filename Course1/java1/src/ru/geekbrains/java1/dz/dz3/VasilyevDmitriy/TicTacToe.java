package ru.geekbrains.java1.dz.dz3.VasilyevDmitriy;

/**
 * Created by VasilyevD on 24.08.2016.
 * Класс, описывающий логику игры
 */
public class TicTacToe {

    public static final int SIZE = 3; //Размер игрового поля Рекомендуется от 3 до 9
    private static char[][] map = new char[SIZE][SIZE]; // игровое поле

    public static void initMap() { // инициализируем массив map(игровое поле)
        for (int i = 0; i < SIZE; i++) { // двойным циклом проходимся по всему массиву
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = '*'; // и заполняем каждую ячейку *
            }
        }
    }
    //Новые методы, выполняемые в рамках ДЗ

    //Метод, печатающий  строку координат
    private static String printFirstString(int size){
        String firstLine="";
        for (int i = 0; i<=size;i++){
            firstLine = new StringBuffer(firstLine).append(i+" ").toString();
        }
        return firstLine;
    }

    //Метод, возвращающий координаты для предупреждения победы игрока
    public static String predictWin(char x) {
        //Поиск по вертикали и горизонтали
        int signV; //коэффициент, показывающий выйгрышную комбинацию игрока по горизонтали
        int signH; //коэффициент, показывающий выйгрышную комбинацию игрока по вертикали
        int xW = 0; //Переменная, запомиинающая координату х пустой клетки по горизонтали
        int yW = 0;//Переменная, запомиинающая координату у пустой клетки по горизонтали
        int xWh=0;//Переменная, запомиинающая координату х пустой клетки по вертикали
        int yWh=0;//Переменная, запомиинающая координату у пустой клетки по вертикали
/*        Идем по строке и столбцу. Если встречаем Х то коэффициент увеличиваем на 1
        Если О - уменьшаем. Если встречаем *(пустая клетка) то запоминаем координаты
         Если коэффицикет равен 2, то в данной строке/столбце есть выигрышная комбинация
         игрока и, значит, необходимо вернуть координаты пустой клетки, куда компьютер поставит свою фишку =) */

        for (int i=0; i<SIZE;i++) {
            signV=0;
            signH=0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == x) {
                    signV++;
                }
                if ((map[i][j] != x)&&(map[i][j] != '*')) {
                    signV--;
                }
                if (map[i][j] == '*') {
                    xW=j;
                    yW=i;
                }
                if (map[j][i] == x) {
                    signH++;
                }
                if ((map[j][i] != x)&& (map[j][i] != '*')) {
                    signH--;
                }
                if (map[j][i] == '*') {
                    xWh=i;
                    yWh=j;
                }

            }
            if (signV==SIZE-1) return xW+" "+yW;
            if (signH==SIZE-1) return xWh+" "+yWh;
        }

        //Обнуляем коэффициенты и переменные для поиска по диагоналям
        signV = 0;
        signH=0;
        xW = 0;
        yW = 0;
        xWh=0;
        yWh=0;

        //Аналогичен поиск по диагоналям
        for (int i=0; i<SIZE;i++) {
            if (map[i][i] == x) {
                signV++;
            }
            if ((map[i][i] != x)&&(map[i][i] != '*')) {
                signV--;
            }
            if (map[i][i] == '*') {
                xW = i;
                yW = i;
            }
            if (map[SIZE-1-i][i] == x) {
                signH++;
            }
            if ((map[SIZE-1-i][i] != x)&&(map[SIZE-1-i][i] != '*')) {
                signH--;
            }
            if (map[SIZE-1-i][i] == '*') {
                xWh = i;
                yWh = SIZE-i-1;
            }
        }
        if (signV==SIZE-1) return xW+" "+yW;
        if (signH==SIZE-1) return xWh+" "+yWh;

        return "NO"; //Если комбинаций нет, то возвращаем NO
    }

    public static boolean checkWin(char ox) { // Проверяем победу

        boolean flagH;
        boolean flagV;
        boolean flagD1=true;
        boolean flagD2=true;

        //Проверка по горизонтали и вертикали
        for (int i=0; i<SIZE;i++) {
            flagH=true;
            flagV =true;
            for (int j=0; j<SIZE; j++) {
                if (map[i][j]!=ox) flagH = false;
                if (map[j][i]!=ox) flagV = false;
            }
            if (flagH || flagV) return true;
        }

        //Проверка по диагоналям
        for (int i=0; i<SIZE;i++) {
            if (map[i][i]!=ox) flagD1 = false;
            if (map[SIZE-1-i][i]!=ox) flagD2 = false;
        }
        if (flagD1 || flagD2) return true;

        return false;        // если ни одной линии не нашли, значит игрок еще не победил
    }

    //Методы, которые были изначально

    public static void printMap() { // выводим игровое поле в консоль
        System.out.println(printFirstString(SIZE)); // первая строка с координатами
        for (int i = 0; i < SIZE; i++) { // начинаем печатать поле
            System.out.print((i + 1) + " "); // ставим номер строки 1-3
            for (int j = 0; j < SIZE; j++) { // начинаем печатать строку
                System.out.print(map[i][j] + " "); // посимвольно печатаем содержимое каждой ячейки поля
            }
            System.out.println(); // после распечатки строки, делаем перевод каретки
        }
        System.out.println(); // делаем дополнительный перевод строки
    }

    //Метод, описывающий запуск и ход игры
    public static void gameStart() {
        while (true) { // запускаем игровой цикл
            Gamers.humanTurn(map); // ход человека
            printMap(); // печать поля
            if (checkWin('X')) { // проверка победы человека
                System.out.println("Победил игрок");
                break;
            }
            if (isMapFull()) break; // если поле заполнилось, завершаем игру
            Gamers.aiTurn(map); // ход компьютера
            printMap(); // печать поля
            if (checkWin('O')) { // проверка победы компьютера
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull()) break;
        }
        System.out.println("Игра окончена");
    }



    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == '*') return false; // если на поле нашли хотя бы одну *, значит поле еще не заполнилось
            }
        }
        return true;
    }

    public static boolean isCellEmpty(int x, int y) { // проверка является ли ячейка свободной
        if (x < 0 || x > SIZE-1 || y < 0 || y > SIZE-1) return false; // если указаны неверные координаты, считаем что ячейка условно занята
        if (map[x][y] != '*') return false; // если в ячейке не *, значит занята
        return true; // ячейка свободна
    }
}
