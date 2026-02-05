# Sieve of Eratosthenes & Prime Checking in DSA

## 1. Sieve of Eratosthenes – Theory 

The **Sieve of Eratosthenes** is an efficient algorithm to **find all prime numbers up to a given number `n`**.

### Idea

* Assume all numbers are prime.
* Start from the smallest prime (2).
* Mark all multiples of that prime as **not prime**.
* Move to the next unmarked number and repeat.
* Stop when `p * p > n`.

**Why `p * p ≤ n`?**
Because any composite number ≤ `n` must have at least one factor ≤ √n.

---

## 2. Algorithm Steps

1. Create a boolean array `isPrime[0..n]`.
2. Initialize all values as `true`.
3. Mark `0` and `1` as `false`.
4. For `i = 2` to `√n`:

   * If `isPrime[i]` is `true`:

     * Mark all multiples of `i` (from `i*i` to `n`) as `false`.
5. Remaining `true` values are **prime numbers**.

---

## 3. Time & Space Complexity

* **Time Complexity:** `O(n log log n)`
* **Space Complexity:** `O(n)`

Much faster than checking each number individually using `O(n√n)`.

---

## 4. Solve Prime Checking Using Sieve

For checking if a **single number** `a` is prime, we can compute all primes up to `a` using the sieve, then directly query `isPrime[a]`.

### Java Code

```java
import java.util.*;

public class Prime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();

        if (a < 2) {
            System.out.println("Not Prime");
            return;
        }

        boolean[] isPrime = sieve(a);

        if (isPrime[a])
            System.out.println("Prime");
        else
            System.out.println("Not Prime");

        s.close();
    }

    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];

        // Initialize all entries to true manually
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }

        // Note: Instead of the manual loop above, we could use:
        // Arrays.fill(isPrime, true);
        // This method fills all elements of the array with 'true' in one line.

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}

```
| Aspect     | Complexity                                                                                                                                                                                                          |
| ---------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Time**   | O(n log log n)                                                                                                                                                                                                      |
| **Space**  | O(n)                                                                                                                                                                                                                |
| **Reason** | Outer loop runs up to √n; inner loop marks multiples of prime `i`. Total marks ≈ n * (1/2 + 1/3 + 1/5 + …) ≈ n log log n. It’s **log log n** instead of log n because we sum **only over primes**, not all numbers. |

---

## 5. When to Use Sieve in DSA

Use **Sieve of Eratosthenes** when:

* You need **multiple prime queries**.
* You need **all primes up to N**.
* Constraints go up to `10^6` or `10^7`.

Use **√n method** when:

* You check **only one number**.
* Memory is limited.

---

## 6. √n Method vs Sieve of Eratosthenes – Comparison

| Feature              | √n Method                                               | Sieve of Eratosthenes                                                                   |
| -------------------- | ------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| **Purpose**          | Check if a **single number `a`** is prime               | Find **all primes up to `N`**                                                           |
| **Idea**             | Try dividing `a` by all numbers from 2 to √a            | Start from 2, mark multiples as non-prime, iterate up to √N                             |
| **Time Complexity**  | `O(√a)` per query                                       | `O(n log log n)` for all numbers up to n                                                |
| **Space Complexity** | `O(1)`                                                  | `O(n)` (boolean array)                                                                  |
| **Best For**         | Single number prime check                               | Multiple queries or all primes ≤ n                                                      |
| **Implementation**   | Simple loop                                             | Slightly more code (array + nested loop)                                                |
| **Practical Notes**  | Fast for small numbers, no extra memory needed          | Very fast if multiple numbers need checking; precompute once, query in `O(1)`           |
| **Example Limit**    | Works for `a ≤ 10^12` (with optimization)               | Typically `n ≤ 10^7` (memory limits)                                                    |
| **Optimizations**    | Check only odd numbers after 2; early exit if divisible | Start marking multiples from i*i; only check odd numbers; can use bitset to save memory |

**Summary (Rule of Thumb)**

* **Single number prime check → √n method**
* **Multiple prime queries or all primes up to N → Sieve**

---

