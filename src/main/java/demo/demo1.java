package demo;

/**
 *冒泡排序
 */
public class demo1 {
    public static void main(String[] args) {
        int temp = 0;
        int qsm[] = {1,33, 31, 4, 7, 23, 56, 98, 13};
        for (int i = 0; i < qsm.length; i++) {
            for (int j = 0; j < qsm.length - 1; j++) {
                if (qsm[j] > qsm[j + 1]) {
                    temp = qsm[j];
                    qsm[j] = qsm[j + 1];
                    qsm[j + 1] = temp;
                }
            }
            System.out.println(qsm[i]);
        }
    }
}
