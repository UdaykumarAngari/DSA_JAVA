# `Leetcode` 2787: `Ways` to `Express` an `Integer` as `Sum` of `Powers`

## `Problem` `Description`

`Given` two positive integers `n` and `x`, the task is to **return the number of ways `n` can be expressed as the sum of the `x`-th powers of unique positive integers**.

`In` other words, we need to find the number of sets of unique integers `{n1, n2, ..., nk}` such that:

```
n = n1^x + n2^x + ... + nk^x
```

`Since` the result can be very large, the answer should be returned **modulo `10^9 + 7`**.

---

## **`Examples`**

### **`Example`** 1:

**`Input`:**
```
n = 10, x = 2
```
**`Output`:**
```
1
```
****`Explanation`**:** `The` only possible way to express 10 as a sum of unique integers raised to the power of 2 is:
```
1^2 + 3^2 = 1 + 9 = 10
```

---

### **`Example`** 2:

**`Input`:**
```
n = 4, x = 1
```
**`Output`:**
```
2
```
****`Explanation`**:** `The` two possible ways are:

1. `1^1 + 3^1 = 1 + 3 = 4`
2. `4^1 = 4`

---

## `Approach`: `Recursion` with `Memoization` (`Knapsack`-`Style` `Take`/`Skip`)

`This` problem can be modeled as a **0/1 `Knapsack` problem** where:

- **`Items`** = positive integers raised to the power `x`.
- **`Capacity`** = `n` (target sum).
- `Each` item can be **taken at most once**.
- `Order` does **not** matter (combinations, not permutations).

---

### `Recursive` `Steps`

1. **`Start`** with `currentNum = 1`.
2. **`Compute`** `currentPowerValue = currentNum^x`.
3. **`Two` choices** at each step:

    - **`Take` it**:
        - `Include` `currentPowerValue` if it does not exceed the remaining sum.
        - `Reduce` `n` by `currentPowerValue` and move to the next number (`currentNum + 1`).

    - **`Skip` it**:
        - `Leave` `n` unchanged and move to the next number (`currentNum + 1`).

4. **`Sum` the results** from both choices to get the total ways for this state.

---

### `Base` `Cases`

`Base` cases define when recursion stops:

1. **`Exact` match found** (`n == 0`):
    - `We` have successfully formed the target sum.
    - **`Return` `1`** to count this valid combination.

2. **`Sum` overshot** (`n < 0`):
    - `The` current path exceeds the target sum.
    - **`Return` `0`** because this path is invalid.

3. **`No` further numbers possible** (`currentNum^x > n`):
    - `The` current number’s power already exceeds the remaining sum.
    - `Since` numbers only get larger, no valid combinations can be formed.
    - **`Return` `0`**.

---

### `Memoization`

`To` avoid recalculating the same subproblems:

- **`State` `Definition`:**
  `dp[remainingSum][currentNum]` = number of ways to form `remainingSum` starting from `currentNum`.

- **`Initialization`:**
  `Set` all entries in `dp` to `-1` (meaning "uncomputed").

- **`Usage`:**
  `Before` solving `(n, currentNum)`, check if `dp[n][currentNum] != -1`.

    - `If` yes, return the stored value.
    - `If` no, compute it and store it before returning.

- **`Formula`:**
  ```
  dp[n][currentNum] = (take + skip) % `MOD`
  ```
  `Where`:
    - `take` = solve(n - currentPowerValue, currentNum + 1)
    - `skip` = solve(n, currentNum + 1)

---

### Time and Space Complexity

- **`Without Memoization`:**
    - Time complexity is **exponential** (`O(2^K)`) where `K` = number of integers considered.

- **`With Memoization`:**
    - **`Time Complexity`:** `O(N * M)`
        - `N` = target sum.
        - `M` = largest integer whose `x`-th power ≤ `N`.
    - **`Space` `Complexity`:** `O(N * M)` for `DP` table + recursion stack.

---

### `Notes`
This problem is essentially a constrained combination sum problem where each candidate number is raised to a fixed power. The recursion explores all possibilities, and memoization ensures that we do not re-solve the same subproblem multiple times.


## References
- [LeetCode 2787. Ways to Express an Integer as Sum of Powers](https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/)
- Date : 12-08-2025