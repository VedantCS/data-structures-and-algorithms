You’re given:
an integer array nums
AND an integer k

Return true if there are two equal values nums[i] == nums[j] such that
|i - j| <= k.

Otherwise, return false.

# Intuition:
We don’t care how many duplicates exist

We only care about the distance between duplicate indices

As soon as we find a valid pair → we can stop

So for each number, we want to know:
When was the last time I saw this number?

# Why this is a Sliding Window pattern 

The condition in the problem is:

|i - j| <= k

That automatically creates a window of size k.

At index i, the only indices that matter are:

[i - k, i]


Anything older than i - k is irrelevant.

# So conceptually:

We slide forward one index at a time

We only care about elements inside a distance of k

That’s exactly what sliding window is about:

Maintaining useful information about a moving range of indices
# Why HashMap instead of HashSet?
What we need to know

For each number:

Have we seen it before?
 AND If yes, where (which index)?

A HashSet can only tell us:

“Does this exist?”

But a HashMap tells us:

“Does this exist, AND what was its last index?”

That index is crucial to compute:

i - lastIndex <= k


So:

HashSet → presence

HashMap → presence + position

That’s why HashMap is the better fit here.

# Sliding Window + HashMap is used when:

You process data left to right

You care about a fixed or bounded range

You need to track elements or counts inside the window

HashMap lets you remember state about the window efficiently.  

# EXAMPLE of similar problems:
Longest substring without repeating characters

Permutation in string

Minimum window substring

“Longest / shortest subarray where…”

“At most K distinct elements”

“Exactly K occurrences”

## Solution:
```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // If we've seen this number before
            if (map.containsKey(nums[i])) {
                int lastIndex = map.get(nums[i]);
                if (i - lastIndex <= k) {
                    return true;
                }
            }

            // Update the latest index for this number
            map.put(nums[i], i);
        }

        return false;
    }
}

```
Step-by-step example

Input

nums = [1, 2, 3, 1], k = 3

Walkthrough

i = 0 → map = {1 → 0}

i = 1 → map = {1 → 0, 2 → 1}

i = 2 → map = {1 → 0, 2 → 1, 3 → 2}

i = 3 → number = 1
last index = 0
3 - 0 = 3 <= k → return true
