# Assignment 1: Divide-and-Conquer Algorithm Analysis

## Project Overview

This project implements four divide-and-conquer algorithms:

- MergeSort
- QuickSort
- Deterministic Select (Median of Medians)
- Closest Pair of Points

The goal is to compare theoretical complexity with practical performance.

## Algorithm Analysis

### MergeSort

MergeSort divides the array into two halves, sorts both halves recursively, and merges them.

Time Complexity: O(n log n)  
Space Complexity: O(n)

Recurrence:

T(n) = 2T(n/2) + O(n)

By the Master Theorem, the complexity is O(n log n).

### QuickSort

QuickSort chooses a random pivot and partitions the array into smaller and larger elements.

Average Time Complexity: O(n log n)  
Worst Case: O(n²)

Recurrence in a balanced case:

T(n) = 2T(n/2) + O(n)

Random pivot selection helps avoid bad partitions.

The algorithm recursively processes the smaller partition and uses iteration for the larger one to reduce recursion depth.

### Deterministic Select

Deterministic Select finds the k-th smallest element.

It divides elements into groups of five and chooses the median of medians as the pivot.

Worst-case Time Complexity: O(n)

Recurrence:

T(n) = T(n/5) + T(7n/10) + O(n)

This recurrence gives linear worst-case complexity.

### Closest Pair of Points

Closest Pair finds the minimum distance between two points.

The points are sorted by x-coordinate, divided into two halves, and solved recursively.

A middle strip is then checked using y-order.

Time Complexity: O(n log n)

Recurrence:

T(n) = 2T(n/2) + O(n)

By the Master Theorem, the complexity is O(n log n).

### QuickSort

QuickSort chooses a random pivot and partitions the array into two parts.

Average Time Complexity: O(n log n)  
Worst Case: O(n²)

The algorithm recursively processes the smaller partition and uses iteration for the larger one to reduce recursion depth.

### Deterministic Select

Deterministic Select finds the k-th smallest element.

It divides elements into groups of five and uses the median of medians as the pivot.

Worst-case Time Complexity: O(n)

### Closest Pair of Points

This algorithm finds the minimum distance between two points.

It sorts points by x-coordinate, divides them into two parts, and checks the middle strip.

Time Complexity: O(n log n)

## Experimental Results

The experiments were performed for all four algorithms:

- MergeSort
- QuickSort
- Deterministic Select
- Closest Pair of Points

The program measures:

- Execution time
- Maximum recursion depth
- Number of comparisons

The results are stored in:

`results/results.csv`

Input sizes:

- 100
- 1000
- 10000

Input types:

- Random
- Sorted
- Reverse-sorted
- Duplicate-heavy

## Testing

MergeSort and QuickSort are compared with `Arrays.sort()`.

Deterministic Select is tested with 100 random test cases.

Closest Pair is compared with a brute-force solution.

All tests passed successfully.

## Discussion

The experimental results generally match the expected theoretical complexity.

MergeSort has stable O(n log n) performance.

QuickSort performance depends on pivot selection, but randomized pivot selection reduces the chance of bad partitions.

Using recursion on the smaller partition helps reduce recursion depth.

Median of Medians guarantees linear worst-case complexity because it chooses a balanced pivot.

The divide-and-conquer Closest Pair algorithm is faster than the O(n²) brute-force solution for large inputs.

Practical performance can also be affected by JVM warm-up, memory, garbage collection, and CPU cache.

## Reflection

I learned how divide-and-conquer algorithms work and how recursion can affect performance.

The main challenge was implementing the algorithms correctly and measuring execution time, recursion depth, and comparisons.

## Screenshots

Screenshots of program output, test results, and plots are stored in:

`docs/screenshots/`

Plots are stored in:

`docs/plots/`