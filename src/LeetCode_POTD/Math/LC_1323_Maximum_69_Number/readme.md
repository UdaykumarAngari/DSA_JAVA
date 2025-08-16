# 1323\. Maximum 69 Number

## Problem Description

You're given a positive integer `num` consisting only of digits `6` and `9`. Your task is to return the **maximum number** you can get by changing **at most one** digit (`6` becomes `9`, or `9` becomes `6`).

-----

## Constraints

* `1 <= num <= 10^4`
* `num` consists of only `6` and `9` digits.

-----

## Examples

### Example 1:

**Input:**
```
num = 9669
```
**Output:**
```
9969
```
**Explanation**: Changing the second digit (`6`) to a `9` yields the largest possible number.

-----

### Example 2:

**Input:**

```
num = 9996
```

**Output:**

```
9999
```

**Explanation**: Changing the last digit (`6`) results in the maximum number.

-----

### Example 3:

**Input:**

```
num = 9999
```
**Output:**
```
9999
```

**Explanation**: The number is already maximized, so no change is needed.

-----

## Solution Explanations

The core idea for solving this problem is that to maximize a number, you should make the largest possible change at the most significant (leftmost) position. Since `9 > 6`, the best strategy is to find the **first occurrence of a '6' from the left** and change it to a `'9'`. Changing a `'9'` to a `'6'` would always result in a smaller number, so that is never the optimal choice.

-----

### Approach 1: Brute Force 

This method exhaustively tries every possible single-digit flip, stores the results, and returns the maximum. It's a straightforward way to guarantee the correct answer by checking all possibilities.

#### Algorithm

1.  **Convert to String**: Change the integer `num` into a character array.
2.  **Iterate and Flip**: Loop through each digit. In each iteration:
    * Flip the current digit (`'6'` to `'9'` or `'9'` to `'6'`).
    * Convert the modified array back into a new number.
    * Compare this new number with the maximum number found so far and update if needed.
    * **Crucially**, restore the digit to its original value before the next iteration to ensure only one change is made from the original number.
3.  **Return Max**: After the loop, return the maximum value found.

This approach is correct but inefficient because it performs unnecessary checks, like changing a `'9'` to a `'6'`.

-----

### Approach 2: Greedy with String Manipulation 

This is a much more optimized approach that directly implements the core idea. It's "greedy" because it makes the locally optimal choice at each step (the first '6' it finds) which leads to the global optimal solution.

#### Algorithm

1.  **Convert to String**: Change `num` into a character array.
2.  **Iterate from Left**: Loop through the characters from left to right.
3.  **Find and Replace**: The *first* time you encounter a `'6'`, change it to a `'9'` and immediately **break** the loop. This is the most effective change you can make.
4.  **Return Result**: Convert the modified character array back to an integer. If no `'6'` was found, the original number is returned.

-----

### Approach 3: Optimal Mathematical Method 

This is the most efficient solution because it solves the problem using arithmetic, avoiding the overhead of string conversions. The goal is to find the place value of the leftmost `'6'` and add the required amount to flip it to a `'9'`.

#### Algorithm

1.  **Find Leftmost '6'**: We can find the leftmost `'6'` by scanning the number from right to left. We use a `while` loop with modulo (`%`) and division (`/`) to inspect each digit. We keep a variable, `pos`, that records the position of the *last* `'6'` we've seen. This "last '6' from the right" is exactly the "first '6' from the left".
2.  **Handle No '6's**: If the loop finishes and we never found a `'6'`, `pos` will be unchanged (e.g., at its initial `-1` value), and we can just return the original number.
3.  **Calculate the Result**: If we found a `'6'` at position `pos` (0-indexed from the right), we need to add enough to change it to a `'9'`. The difference is `3`, and its place value is $10^{pos}$. So, we add $3 \\times 10^{pos}$ to the original number.

For `num = 9669`:

- The leftmost `'6'` is at the hundreds place, which is position `2` from the right.
- We calculate `9669 + 3 * 10^2` = `9669 + 300` = `9969`. 

-----

## Complexity Summary

| Approach                 | Time Complexity      | Space Complexity |
| ------------------------ | -------------------- | ---------------- |
| 1. Brute Force           | $O(L^2)$             | $O(L)$           |
| 2. Greedy (String)       | $O(L)$               | $O(L)$           |
| 3. Optimal (Mathematical) | $O(L)$ or $O(\\log\_{10} n)$ | $O(1)$           |

*Where $L$ is the number of digits in `num`.*

-----

## References

- [LeetCode 1323. Maximum 69 Number](https://leetcode.com/problems/maximum-69-number/)
- Date: 16-08-2025