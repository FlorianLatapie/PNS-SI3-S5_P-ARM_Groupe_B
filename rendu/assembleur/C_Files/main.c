#include <parm.h>
#include <stdio.h>
#include <video.h>


void run () {
BEGIN ();
    
    PUTCHAR('P','-','A','R','M');
    PUTCHAR('\n');
    PUTCHAR('G','r','o','u','p','e',' ','B');

    PIXSET(0, 0);    SCRUPD();
    PIXSET(1, 0);    SCRUPD();
    PIXSET(2, 0);    SCRUPD();
    PIXSET(3, 0);    SCRUPD();
    PIXSET(4, 0);    SCRUPD();
    PIXSET(5, 0);    SCRUPD();
    PIXSET(6, 0);    SCRUPD();
    PIXSET(7, 0);    SCRUPD();

    PIXSET(7, 1);    SCRUPD();
    PIXSET(7, 2);    SCRUPD();
    PIXSET(7, 3);    SCRUPD();

    PIXSET(6, 3);    SCRUPD();
    PIXSET(5, 3);    SCRUPD();
    PIXSET(4, 3);    SCRUPD();
    PIXSET(3, 3);    SCRUPD();
    PIXSET(2, 3);    SCRUPD();
    PIXSET(1, 3);    SCRUPD();
    PIXSET(0, 3);    SCRUPD();

    PIXSET(0, 2);    SCRUPD();
    PIXSET(0, 1);    SCRUPD();

    PIXSET(1, 1);    SCRUPD();
    PIXSET(2, 1);    SCRUPD();
    PIXSET(3, 1);    SCRUPD();
    PIXSET(4, 1);    SCRUPD();
    PIXSET(5, 1);    SCRUPD();
    PIXSET(6, 1);    SCRUPD();

    PIXSET(6, 2);    SCRUPD();
    PIXSET(5, 2);    SCRUPD();
    PIXSET(4, 2);    SCRUPD();
    PIXSET(3, 2);    SCRUPD();
    PIXSET(2, 2);    SCRUPD();
    PIXSET(1, 2);    SCRUPD();
   
    PIXCLR(0,0);    PIXCLR(1,0);    PIXCLR(2,0);    PIXCLR(3,0);    PIXCLR(4,0);    PIXCLR(5,0);    PIXCLR(6,0);    PIXCLR(7,0);
    SCRUPD();
    PIXCLR(0,1);    PIXCLR(1,1);    PIXCLR(2,1);    PIXCLR(3,1);    PIXCLR(4,1);    PIXCLR(5,1);    PIXCLR(6,1);    PIXCLR(7,1);
    SCRUPD();
    PIXCLR(0,2);    PIXCLR(1,2);    PIXCLR(2,2);    PIXCLR(3,2);    PIXCLR(4,2);    PIXCLR(5,2);    PIXCLR(6,2);    PIXCLR(7,2);
    SCRUPD();
    PIXCLR(0,3);    PIXCLR(1,3);    PIXCLR(2,3);    PIXCLR(3,3);    PIXCLR(4,3);    PIXCLR(5,3);    PIXCLR(6,3);    PIXCLR(7,3);
    SCRUPD();
   
    int a = 1;
    int b = 2;
    RES = a+b;

    PUTCHAR('\n');
    PUTCHAR('l','a','n','c','e','m','e','n','t',' ','d','u',' ','j','e','u','\n');
    RES = 0;

    int x = 1;
    int y = 1;
    int key = 0;
    PIXSET(7, 3);
    while(1){   
        PIXSET(x, y);

        SCRUPD();

        key = READKEY();

        PIXCLR(x, y);

        if (key == 'q')
            x--;
        else if (key == 'd')
            x++;
        else if (key == 'z')
            y--;
        else if (key == 's')
            y++;

        PUTCHAR(key);
        key = 0; 

        x &= 7;
        y &= 3;

        if (x == 7 && y == 3){
            RES = 10;
            PUTCHAR('\n','g','a','g','n','e');
        }
    }
END ();
}
