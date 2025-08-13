# LeetCode 326: Power of Three

This repository explores four distinct methods for solving LeetCode problem 326, **"Power of Three."** The goal is to determine if a given integer `n` can be expressed as $3^x$ for some integer `x`. The solutions presented here range from simple iterative and recursive approaches to more advanced, constant-time solutions.

---

## 1. Iterative Division

This is the most intuitive method. It involves repeatedly dividing the given number `n` by 3 until it's no longer divisible.

### Logic
- Handle the base case: if `n <= 0`, return `false`.
- While `n > 1` and divisible by 3, continuously update `n` to `n / 3`.
- After the loop, if `n == 1`, the original number was a power of three.

### Complexity
- **Time Complexity:** $O(\log_3 n)$
- **Space Complexity:** $O(1)$

---

## 2. Recursive Division

This approach uses recursion instead of iteration but implements the same logic.

### Logic
- **Base cases**:
    - If `n <= 0`, return `false`.
    - If `n == 1`, return `true`.
- **Recursive step**:
    - If `n % 3 == 0`, call the function recursively with `n / 3`.
    - Otherwise, return `false`.

### Complexity
- **Time Complexity:** $O(\log_3 n)$
- **Space Complexity:** $O(\log_3 n)$ (recursion stack)

---

## 3. Logarithms

This method uses the mathematical property: if $n = 3^x$, then $x = \log_3(n)$. If `n` is a power of three, `x` must be an integer.

### Logic
- If `n <= 0`, return `false`.
- Compute `x = log10(n) / log10(3)`.
- Check if `x` is very close to its rounded integer value (to handle floating-point inaccuracies).

### Complexity
- **Time Complexity:** $O(1)$
- **Space Complexity:** $O(1)$

---

## 4. Maximum Power of Three (Constant Time)

This is the most performant and elegant solution. It solves the problem in constant time without loops or recursion.

### Logic
- Any power of three must divide the largest power of three within a 32-bit signed integer.
- The largest power of three in 32-bit int is $3^{19} = 1162261467$.
- If `n > 0` and `1162261467 % n == 0`, then `n` is a power of three.

### Why it works
Any number that is a power of three will be a divisor of $3^{19}$. Numbers not powers of three have other prime factors and cannot divide $3^{19}$ evenly.

### Complexity
- **Time Complexity:** $O(1)$
- **Space Complexity:** $O(1)$

---

## References
- [LeetCode 326: Power of Three](https://leetcode.com/problems/power-of-three/)
- Date : 13-08-2025
- 
