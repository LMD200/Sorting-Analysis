# Sorting Algorithm Performance Analysis

A Java application that analyzes and compares the performance of three sorting algorithms—Merge Sort, Quick Sort with a fixed pivot, and Quick Sort with a random pivot—on randomly generated integer arrays of varying sizes.

## Features

- **Random Array Generation:** Generates integer arrays of configurable sizes with random values.
- **Merge Sort Implementation:** Recursively sorts arrays and merges results.
- **Quick Sort (Fixed Pivot):** Uses the last element as the pivot.
- **Quick Sort (Random Pivot):** Selects a random pivot for improved average-case performance.
- **Benchmarking:** Measures and displays the execution time (in milliseconds) for each algorithm and array size.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed

### Running the Program

1. Clone the repository:
    ```bash
    git clone https://github.com/LMD200/your-repo.git
    cd your-repo
    ```
2. Compile the Java file:
    ```bash
    javac SortingAnalysis.java
    ```
3. Run the analysis:
    ```bash
    java SortingAnalysis
    ```

## Usage

- When run, the program outputs the time taken (in milliseconds) to sort randomly generated arrays of sizes 1,000; 10,000; 100,000; and 1,000,000 using each algorithm.
- Use the output to compare the efficiency and scalability of each sorting method.

## Example Output

```
Test Case for size: 1000
Merge Sort Time: 2.1 ms
Quick Sort with Fixed Pivot Time: 1.3 ms
Quick Sort with Random Pivot Time: 1.2 ms

Test Case for size: 10000
Merge Sort Time: 18.7 ms
Quick Sort with Fixed Pivot Time: 14.0 ms
Quick Sort with Random Pivot Time: 13.5 ms

...
```
