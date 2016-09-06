package ru.geekbrains.java1.dz.dz5.VasilyevDmitriy;

/**
 * Created by VasilyevD on 05.09.2016.
 */
public class Chess {
     abstract static class Figure {
         protected int startX, startY, endX, endY, deltaX, deltaY;
        Figure(String startPoint, String endPoint){
            this.startX = (int) startPoint.charAt(0);
            this.startY = Character.getNumericValue(startPoint.charAt(1));
            this.endX = (int) endPoint.charAt(0);
            this.endY = Character.getNumericValue(endPoint.charAt(1));
            deltaX=startX - endX;
            deltaY=endY - startY;
        }
         abstract boolean isRightMove();
    }
    public static class Peshka extends Figure{
        Peshka(String a, String b){
            super(a, b);
        }
        @Override
        public boolean isRightMove(){
            if(!checkMate(startX, startY, endX, endY)) {
                System.out.println("Стартовая и/или конечная позиция находятся за пределами игрового поля");
                return false;
            }
            //ВНИМАНИЕ! Рассматривается только стандартный ход пешки.
            //Не рассматривается первый ход на 2 и ход, съедаемый фигуру по диагонали
            return (deltaX==0 && deltaY==1);
        }
    }
    public static class Slon extends Figure{
        Slon(String a, String b){
            super(a, b);
        }
        @Override
        public boolean isRightMove(){
            if(!checkMate(startX, startY, endX, endY)) {
                System.out.println("Стартовая и/или конечная позиция находятся за пределами игрового поля");
                return false;
            }
            return Math.abs(deltaX) == Math.abs(deltaY);
        }
    }
    public static class Ladya extends Figure{
        Ladya(String a, String b){
            super(a, b);
        }
        @Override
        public boolean isRightMove(){
            if(!checkMate(startX, startY, endX, endY)) {
                System.out.println("Стартовая и/или конечная позиция находятся за пределами игрового поля");
                return false;
            }
            return Math.abs(deltaX) == 0  || Math.abs(deltaY) == 0;
        }
    }
    public static class Kon extends Figure{
        Kon(String a, String b){
            super(a, b);
        }
        @Override
        public boolean isRightMove(){
            if(!checkMate(startX, startY, endX, endY)) {
                System.out.println("Стартовая и/или конечная позиция находятся за пределами игрового поля");
                return false;
            }
            return ((Math.abs(deltaX)==2&&Math.abs(deltaY)==1)||(Math.abs(deltaX)==1&&Math.abs(deltaY)==2));
        }
    }
    public static class Ferz extends Figure{
        Ferz(String a, String b){
            super(a, b);
        }
        @Override
        public boolean isRightMove(){
            if(!checkMate(startX, startY, endX, endY)) {
                System.out.println("Стартовая и/или конечная позиция находятся за пределами игрового поля");
                return false;
            }
            return (Math.abs(deltaX)==Math.abs(deltaY)||Math.abs(deltaX) == 0 || Math.abs(deltaY) == 0);
        }
    }
    public static class Korol extends Figure{
        Korol(String a, String b){
            super(a, b);
        }
        @Override
        public boolean isRightMove(){
            if(!checkMate(startX, startY, endX, endY)) {
                System.out.println("Стартовая и/или конечная позиция находятся за пределами игрового поля");
                return false;
            }
            return (Math.abs(deltaX)==1 || Math.abs(deltaY)==1);
        }
    }

    private static boolean checkMate(int sx, int sy, int ex, int ey) {
        if (!(checkH(sx) && checkV(sy) && checkH(ex) && checkV(ey))) {
            return false;
        }
        return true;
    }
    private static boolean checkH(int x) {
        int a = (int)'a';
        int h = (int)'h';
        return ((x >= a) && (x <= h)) ;
    }
    private static boolean checkV(int y) {

        return (y >= 1 && (y <= 8)) ;
    }
}
