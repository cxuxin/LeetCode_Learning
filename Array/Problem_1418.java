package Array;

import java.util.*;

/**
 * 1418. 点菜展示表
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * <p>
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * <p>
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
 * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * 解释：
 * 点菜展示表如下所示：
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
 * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
 * 餐桌 10：Corina 点了 "Beef Burrito"
 * 示例 2：
 * <p>
 * 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
 * 输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
 * 解释：
 * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
 * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
 * 示例 3：
 * <p>
 * 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
 * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= orders.length <= 5 * 10^4
 * orders[i].length == 3
 * 1 <= customerNamei.length, foodItemi.length <= 20
 * customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
 * tableNumberi 是 1 到 500 范围内的整数。
 * <p>
 * 链接：https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant/
 */
public class Problem_1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> nameSet = new HashSet<>();
        Map<Integer, Map<String, Integer>> foodsCnt = new HashMap<>();
        for (List<String> order : orders) {
            nameSet.add(order.get(2));
            int id = Integer.parseInt(order.get(1));
            Map<String, Integer> map = foodsCnt.getOrDefault(id, new HashMap<String, Integer>());
            map.put(order.get(2), map.getOrDefault(order.get(2), 0) + 1);
            foodsCnt.put(id, map);
        }

        int n = nameSet.size();
        List<String> names = new ArrayList<>();
        for (String name : nameSet) {
            names.add(name);
        }
        Collections.sort(names);

        int m = foodsCnt.size();
        List<Integer> ids = new ArrayList<>();
        for (int id : foodsCnt.keySet()) {
            ids.add(id);
        }
        Collections.sort(ids);

        List<List<String>> table = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (String name : names) {
            header.add(name);
        }
        table.add(header);
        for (int i = 0; i < m; i++) {
            int id = ids.get(i);
            Map<String, Integer> cnt = foodsCnt.get(id);
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(id));
            for (int j = 0; j < n; j++) {
                row.add(Integer.toString(cnt.getOrDefault(names.get(j), 0)));
            }
            table.add(row);
        }
        return table;
    }

    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>(
                Arrays.asList(Arrays.asList("David", "3", "Ceviche"),
                        Arrays.asList("Corina", "10", "Beef Burrito"),
                        Arrays.asList("David", "3", "Fried Chicken"),
                        Arrays.asList("Carla", "5", "Water"),
                        Arrays.asList("Carla", "5", "Ceviche"),
                        Arrays.asList("Rous", "3", "Ceviche")));

        System.out.println(new Problem_1418().displayTable(orders));

    }
}
