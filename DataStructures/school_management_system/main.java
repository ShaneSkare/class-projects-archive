public class main {
        public static void main(String[] args)
        {
            School SCD = new School("SCD");
            SCD.readData("./test6.txt");
            SCD.assignInstructor (301, 300);
            SCD.assignInstructor (302, 300);
            SCD.assignInstructor (303, 300);
            SCD.register (301, 1111);
            SCD.register (301, 2222);
            SCD.register (301, 3333);
            SCD.register (302, 3333);
            SCD.register (302, 2222);
            SCD.register (302, 1111);
            SCD.register (303, 1111);
            SCD.register (303, 2222);
            SCD.register (303, 3333);
            SCD.unRegister (303, 1111);
            SCD.unRegister (303, 2222);
            SCD.unRegister (303, 3333);
            System.out.println("\n\n===== ANSWER: 3 Courses with 301 (3 enrolled), 302 (3 enrolled) and 303 (0 enrolled) =====\n");
            SCD.courseInfo();
        }

/* This is "./test6.txt"
5
100,A. AAA,aaa@csumb.edu,111-111-1111
200,B. BBB,bbb@csumb.edu,222-222-2222
300,C. CCC,ccc@csumb.edu,333-333-3333
400,D. DDD,ddd@csumb.edu,444-444-4444
500,E. EEE,eee@csumb.edu,555-555-5555
3
301,CST301 - Course 301,3,BIT 101
302,CST302 - Course 302,3,BIT 102
303,CST303 - Course 303,3,BIT 104
3
1111,AA AAAA
2222,BB BBBB
3333,CC CCCC
*/

}
