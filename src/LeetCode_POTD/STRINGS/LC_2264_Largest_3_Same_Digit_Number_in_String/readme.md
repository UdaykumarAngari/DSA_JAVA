# `LeetCode` 2264: `Largest` `3-Same-Digit` `Number` in `String`

## `Problem` `Description`

You're given a string `num` that represents a large integer. Your task is to find the **largest "good integer"** that is a substring of `num`.

A **"good integer"** is a substring of length 3 made up of only one unique digit (e.g., `"333"`, `"777"`).

If there are multiple "good integers," you should return the largest one. If you can't find any, just return an empty string `""`.

-----

## `Constraints`

- The length of the input string `num` will be between 3 and 1000 characters (i.e., `3 <= num.length <= 1000`).
- The string `num` will only contain digit characters (`'0'` through `'9'`).

-----

## **`Examples`**

### **`Example`** 1:

**`Input`:**

```
num = "6777133339"
```

**`Output`:**

```
"777"
```

**`Explanation`**:\*\* The "good integers" are `"777"` and `"333"`. Since `"777"` is bigger than `"333"`, we return `"777"`.

-----

### **`Example`** 2:

**`Input`:**

```
num = "2300019"
```

**`Output`:**

```
"000"
```

**`Explanation`**:\*\* Here, the only "good integer" is `"000"`.

-----

## `Approach` 1: `Linear` `Scan`

This straightforward approach involves scanning through the input string `num` and checking every possible 3-digit substring.

### `Algorithm`

1.  **`Initialize`** a string variable `max` to an empty string `""`. This will keep track of the biggest "good integer" we find.
2.  **`Iterate`** through the string `num` using a sliding window of size 3. The loop runs from the start of the string up to the third-to-last character.
3.  **`Check` `for` a `Good` `Integer`**: At each position `i`, check if the characters at `i`, `i + 1`, and `i + 2` are all the same.
4.  **`Update` `Maximum`**: If they are identical, you've found a "good integer". Compare this new `triplet` with the current `max`. If the new one is larger, update `max`.
5.  **`Return` `Result`**: After the loop finishes, `max` holds the largest "good integer", or `""` if none were found.

-----

### `Time` and `Space` `Complexity`

- **`Time Complexity`**: $O(n)$
    - We do a single pass over the string. All operations inside the loop (like comparing characters or substrings) are constant time since the length is fixed at 3.
- **`Space` `Complexity`**: $O(1)$
    - The space we use is constant; it doesn't grow with the size of the input string. We just need a couple of variables to store the current and max triplets.

-----

## `Approach` 2: `Check` `Against` a `Predefined` `List`

This clever approach uses the fact that there are only 10 possible "good integers" (`"999"`, `"888"`, ..., `"000"`). We can just check if any of these exist in the input string, starting from the biggest one.

### `Algorithm`

1.  **`Create` a `List`**: Make a list of all possible "good integers" in descending order, from `"999"` down to `"000"`.
2.  **`Iterate` and `Check`**: Loop through this predefined list.
3.  **`Find` `First` `Match`**: For each "good integer" `s` in your list, use `String.contains()` to see if `s` is a substring of `num`.
4.  **`Return` `Immediately`**: Since the list is sorted from largest to smallest, the **first match** you find is guaranteed to be the largest one. Return it right away.
5.  **`Handle` `No` `Match`**: If you finish the loop without finding any matches, it means no "good integers" exist in `num`. Return an empty string `""`.

-----

### `Time` and `Space` `Complexity`

- **`Time Complexity`**: $O(n)$
    - The `String.contains()` method takes about $O(n)$ time. We run this check a constant number of times (at most 10), so the total time complexity remains $O(n)$.
- **`Space` `Complexity`**: $O(1)$
    - The space needed for the list of "good integers" is constant and doesn't depend on the input size.

-----

## `References`

- [LeetCode 2264. Largest 3-Same-Digit Number in String](https://leetcode.com/problems/largest-3-same-digit-number-in-string/)
- Date: `14-08-2025`