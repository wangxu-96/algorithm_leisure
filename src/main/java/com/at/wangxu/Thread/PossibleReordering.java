package com.at.wangxu.Thread;

public class PossibleReordering {
    public static int x=0,y=0;
    public static int a=0,b=0;
    public static void main(String[] args) throws InterruptedException {
        int i=0;
        for (;;){
            i++;
            x=0;
            y=0;
            a=0;
            b=0;
            Thread one=new Thread(()->{
              shortWait(50000);
              a=1;
              x=b;
            });
            Thread other=new Thread(()->{
                b=1;
                y=a;
            });
            one.start();
            other.start();
            one.join();
            other.join();
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }

    private static void shortWait(long interval) {
        long start=System.nanoTime();
        long end;
        do {
            end=System.nanoTime();
        }while (start+interval>=end);
    }
}
