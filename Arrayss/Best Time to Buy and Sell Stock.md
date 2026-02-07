
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

# Idea

Track the minimum price so far

At each day, compute the profit if you sell today

Keep updating the maximum profit

You only need one transaction (buy once, sell once).

## Optimal Approach

### Key Idea
- Keep track of the **minimum stock price** seen so far
- For each day, calculate the profit if sold on that day
- Update the **maximum profit**

This guarantees:
- Buy happens before sell
- Only one transaction is made

---

## Algorithm
1. Initialize:
   - `minPrice` to a very large number
   - `maxProfit` to `0`
2. Iterate through the price array:
   - Update `minPrice` if the current price is lower
   - Otherwise, calculate profit and update `maxProfit`
3. Return `maxProfit`

---


```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}
```

# Time and Space Complexity

Time Complexity: O(n)

Space Complexity: O(1)
