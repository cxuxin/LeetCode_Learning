# LeetCode_Learning
创建本项目的是为了练习*LeetCode*题目并记录，以提升编程能力。

刷*LeetCode*时经常刷完过几天就忘了，所以每次刷完一题后对题目进行解法记录以加深印象。
## Array
[Middle 523. 连续的子数组和](https://leetcode-cn.com/problems/continuous-subarray-sum/) ： 前缀和+哈希  前缀和相减得到[i,j]的和，若这个数是k的倍数，那么i和j位置除以k的余数相同。所以只需存储余数即可，查看是否有位置相距不小于2的相同的余数。

[Middle 525. 连续数组](https://leetcode-cn.com/problems/contiguous-array/) 前缀和+哈希  与523相似，0与1的数量相同，如果把0看成-1，就可以看成是和为零的最长子数组长度。利用哈希存储前缀和，当两个值相等时，就是区间内和为零的情况。

[Middle 1442. 形成两个异或相等数组的三元组数目](https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/) ：
若 `a=b`，则有`S_{i}⊕ S_{j}=S_{j}⊕ S_{k+1}` 即`S_i=S_{k+1}`
## Bit
[Middle 477. 汉明距离总和](https://leetcode-cn.com/problems/total-hamming-distance) ：先统计在某个位置上1的个数c，则给位置不同的位数有c * (n-c) 再相加即可。

[Simple 231. 2 的幂](https://leetcode-cn.com/problems/power-of-two/) ： 二的幂次满足特点：1. n & (n-1) == 0; 2. n & (-n) == n; 3. 二进制位上只有一个1.   可挑选以上一个特点或使用递归进行判断。
## LinkList
[Simple 160. 相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/) ： 一次遍历headA哈希存储现有节点，再遍历headB查看是否含有A中的节点。

[Simple 203. 移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements/) ： 按照链表迭代即可。
## String
[Middle 12. 整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman)

## Tree
[Simple 872. 叶子相似的树](https://leetcode-cn.com/problems/leaf-similar-trees) ：
深度优先遍历得到两棵树的叶值序列后比较两个序列是否相等。

[Simple 993. 二叉树的堂兄弟节点](https://leetcode-cn.com/problems/cousins-in-binary-tree) ：深度优先搜索得到目标值的「深度」以及「父节点」两个参数即可。
## DP
[Middle 494. 目标和](https://leetcode-cn.com/problems/target-sum/) ：1.遍历所有排列情况，统计和为target的个数； 2.设所有元素和为sum，负数的整数部分和为neg，则正数部分为sum-neg，
目标要求(sum-neg)-neg = target，可得neg = (sum - target) / 2，因此题目转化成在数组 nums 中选取若干元素，使得这些元素之和等于 neg。利用动态规划dp[i][j] 表示在数组 nums 的前 i 个数中选取元素，使得这些元素之和等于 j 的方案数。
转移方程如下：![image](pics/Problem_494/Problem_494.png)

[Hard 664. 奇怪的打印机](https://leetcode-cn.com/problems/strange-printer)

[Hard 1269. 停在原地的方案数](https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps) :
运用动态规划 用 dp [i][j] 表示在 i 步操作之后，指针位于下标 j 的方案数，其中0≤i≤steps，j≤min(arrLen-1,steps)
每一步操作中，指针可以向左或向右移动 1 步，或者停在原地。因此，当 1≤i≤steps 时，状态 dp[i][j] 可以从 dp[i-1][j-1]、dp[i-1][j] 和 dp[i-1][j+1] 这三个状态转移得到。状态转移方程如下：

dp[i][j]=dp[i-1][j-1]+dp[i-1][j]+dp[i-1][j+1]


## Math
[Middle 1310. 子数组异或查询](https://leetcode-cn.com/problems/decode-xored-permutation) ：暴力破解方法也可以解决但容易超时，
可以先逐个计算前k个数字的异或操作存储在数组XOR，在计算Li 到 Ri 的值时，读取XOR第Li和Ri的值进行异或操作，
0~Li的数会因异或操作的自反性相互抵消，即可得到最终结果。

[Middle 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？](https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/) ： 计算能吃到的糖果的位置区间和目标糖果的位置区间，验证两个区间是否存在交集即可。由于题目涉及数字较大，需要用long存储。

[Middle 1734. 解码异或后的排列](https://leetcode-cn.com/problems/decode-xored-permutation) ：
由 ![image](pics/Problem_1734/Problem_1734_1.gif) 我们可以得到 ![image](pics/Problem_1734/Problem_1734_2.gif)

因此我们只需要获得perm任意一个位置的数，就可以得到原始的perm。perm[0]是最容易获得的，通过下述方法：

perm数组是由1~n的整数排列而成，由此我们可以计算 ![image](pics/Problem_1734/Problem_1734_3.gif)

又因为
![image](pics/Problem_1734/Problem_1734_4.gif)
![image](pics/Problem_1734/Problem_1734_5.gif)

由异或操作的自反性可以得到
![image](pics/Problem_1734/Problem_1734_6.gif)
