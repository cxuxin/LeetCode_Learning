package Math;

import Graph.Problem_815;

/**
 * 168. Excel表列名称
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 * <p>
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 * <p>
 * 示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 * <p>
 * 示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * <p>
 * 提示：
 * 1 <= columnNumber <= 2^31 - 1
 * <p>
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class Problem_168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuffer = new StringBuilder();
        while (columnNumber != 0) {
            int temp = columnNumber % 26;
            if (temp == 0) {
                temp = 26;
                columnNumber--;
            }
            stringBuffer.append((char) (temp - 1 + 'A'));
            columnNumber /= 26;
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem_168().convertToTitle(702));
    }
}
