package com.forskill;

/**
 * @author hallele
 * @date 2019/05/02 15:21
 * @description version 1.0
 */
public class Skill {
    /**
     * 定义x,y轴的最大坐标值
     */
    private static final int MAX = 10;

    /**
     * 主方法
     *
     * @param args *
     */
    public static void main(String[] args) {
        //外层循环控制行(y轴)
        for (int y = 0; y < MAX; y++) {

            //内层循环控制列(x轴)
            for (int x = 0; x < MAX; x++) {

                //函数表达式集合
                boolean[] booleans = {y - x <= 0 && y >= 3};
                boolean flag = false;

                //取所有表达式并集,即所有函数图像的并集
                for (boolean aBoolean : booleans) {
                    flag = aBoolean || flag;
                }

                //满足并集条件就打印*,前面加空格是因为控制台行间距和列间距大小不同,加上保持美观
                //不满足就打印空格
                if (flag) {
                    System.out.print(" *");
                } else {
                    System.out.print("  ");
                }
            }

            //换行
            System.out.println();
        }
    }
}
