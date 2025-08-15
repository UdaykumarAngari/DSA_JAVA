# `LeetCode` 342: `Power` of `Four`

## `Problem` `Description`

You're given an integer `n`. Your task is to return `true` if `n` is a **power of four**. Otherwise, you should return `false`.

An integer `n` is a **power of four** if there exists an integer `x` such that `n == 4^x`.

***

## `Constraints`

* The input integer `n` will be within the range of a 32-bit signed integer (i.e., `-2^31 <= n <= 2^31 - 1`).

***

## `Examples`

### `Example` 1:
**`Input`:**
```
n = 16
```
**`Output`:**
```
true
```
**`Explanation`**: $16$ is a power of four because $16 = 4^2$.

***

### `Example` 2:

**`Input`:**
```
n = 5
```
**`Output`:**
```
false
```
**`Explanation`**: `5` cannot be expressed as `4` raised to any integer power.

***

### `Example` 3:

**`Input`:**
```
n = 1
```
**`Output`:**
```
true
```
**`Explanation`**: `1` is a power of four because $1 = 4^0$.

***

## `Approach` 1: `Iterative` `Division`

This intuitive approach checks if a number is a power of four by repeatedly dividing it by 4. If the final result is 1, the number is a power of four.

### `Algorithm`

1.  **`Handle` `Edge` `Cases`**: A power of four must be positive. If `n` is `0` or negative, it can't be a power of four, so return `false`.
2.  **`Iterate` `with` a `Loop`**: Use a `while` loop that continues as long as `n` is perfectly divisible by 4 (i.e., `n % 4 == 0`).
3.  **`Divide`**: Inside the loop, update `n` by dividing it by 4 (`n /= 4`).
4.  **`Return` `Final` `Check`**: After the loop terminates, the original number was a power of four if and only if the remaining value of `n` is `1`.

***

### `Time` and `Space` `Complexity`

-   **`Time Complexity`**: $O(\log_4 n)$
    -   In each step of the loop, we divide the input `n` by 4, so the number of iterations is logarithmic.
-   **`Space` `Complexity`**: $O(1)$
    -   We only use a few variables to store the input and loop state, so the space required is constant.

***

## `Approach` 2: `Bit` `Manipulation` (Using `bitCount`)

This clever solution avoids loops by checking the unique bitwise properties of powers of four.

### `Algorithm`
A number is a power of four if and only if it satisfies two conditions:
1.  It must be a power of two.
2.  Its exponent (in base 2) must be an **even** number (since $4^x = (2^2)^x = 2^{2x}$).



The algorithm checks these two conditions as follows:

1.  **`Check` `for` `Power` of `Two`**: Use the bitwise trick `(n > 0) && (n & (n - 1)) == 0`. A positive number is a power of two if it has exactly one `1` bit in its binary form. This check efficiently filters out any number that isn't a power of two.
2.  **`Check` `if` `Exponent` `is` `Even`**: Use the property `Integer.bitCount(n - 1) % 2 == 0`. For any power of two `n = 2^p`, the number `n - 1` is represented in binary by exactly `p` ones.
    * For `n = 16` ($2^4$), `n-1 = 15` (binary `1111`). `bitCount` is **4** (even).
    * For `n = 64` ($2^6$), `n-1 = 63` (binary `111111`). `bitCount` is **6** (even).
    * For `n = 8` ($2^3$), `n-1 = 7` (binary `111`). `bitCount` is **3** (odd).
    
    By counting the `1`s in `n-1`, we find the exponent `p`. The check `% 2 == 0` verifies that this exponent is even.

***

### `Time` and `Space` `Complexity`

-   **`Time Complexity`**: $O(1)$
    -   All bitwise operations are single, constant-time CPU instructions.
-   **`Space` `Complexity`**: $O(1)$
    -   The space used is constant and does not depend on the input size.

***

## `References`

-   [LeetCode 342. Power of Four](https://leetcode.com/problems/power-of-four/)
-   Date: `15-08-2025`