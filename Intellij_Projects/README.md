# Intellij Projects

This project currently contains several sub-projects, each containing Java code focusing on a specific topic or algorithm. These sub-projects are located in the `src/main/java/org/example` directory. Compiled class files are located in the `target/classes/org/example` directory.

Please refer to the individual sub-project directories for more information about each specific project.

## Problem Statements

Here are 5 problems I will try to solve in the next few days (as of 18.6.23) as part of my technical interview preparation:

### 1. Memory Management System using 'First In, First Out' (FIFO) Policy

A system that uses a 'First In, First Out' (FIFO) memory management policy. The cache is initially empty and contains pages numbered in the range 1-100.

**Input:** The first line consists of a positive integer, `inputNum_size`, representing the total number of pages (`N`). The second line consists of `N` space-separated positive integers representing the memory requests for `N` pages. The last line consists of a positive integer, `size`, representing the size of the cache.

**Output:** Print an integer representing the number of cache misses.

**Note:** A cache miss is when a memory is requested but not found in the cache. 

**Example:**
```
Input:
5
1 2 2 1 3
2
Output:
3
```
**Explanation:** Cache state as requests come in ordered longest-time-in-cache to shortest-time-in-cache: 1*, 12, 21, 13*, 31*. Asterisk (*) represents a cache miss. So the total number of cache misses is 3.

### 2. Database Query Cache
A database that employs a query cache to improve response times. The cache is initially empty and contains query strings. A query hit occurs if the requested query is in the cache, otherwise it is a query miss and the system should look into the database for the result, causing additional delay.

**Input:** The first line consists of a positive integer, `inputNum_size`, representing the total number of queries (`N`). The second line consists of `N` space-separated strings representing the query requests for `N` queries. The last line consists of a positive integer, `size`, representing the size of the cache.

**Output:** Print an integer representing the number of query misses.

**Note:** A query miss occurs when a query is requested but is not found in the cache.

**Example:**
```
Input:
4
SELECT * FROM users SELECT * FROM posts SELECT * FROM users SELECT * FROM comments
2
Output:
3
```
**Explanation:** Cache state as requests come in ordered longest-time-in-cache to shortest-time-in-cache: SELECT * FROM users*, SELECT * FROM posts*, SELECT * FROM posts, SELECT * FROM comments*. Asterisk (*) represents a cache miss. So the total number of cache misses is 3.

### 3. Web Browser Cache System

A web browser that uses a memory management policy for its cache. The cache is initially empty and contains URLs represented as strings.

**Input:** The first line consists of a positive integer, `inputNum_size`, representing the total number of URLs (`N`). The second line consists of `N` space-separated strings representing the URL requests for `N` pages. The last line consists of a positive integer, `size`, representing the size of the cache.

**Output:** Print an integer representing the number of cache misses.

**Note:** A cache miss is when a URL is requested but not found in the cache. 

**Example:**
```
Input:
4
google.com facebook.com google.com twitter.com
2
Output:
3
```
**Explanation:** Cache state as requests come in ordered longest-time-in-cache to shortest-time-in-cache: google.com*, facebook.com*, google.com, twitter.com*. Asterisk (*) represents a cache miss. So the total number of cache misses is 3.

### 4. Operating System Process Scheduler

An operating system that uses a memory management policy for its process scheduler. The cache is initially empty and contains process IDs numbered in the range 1-100.

**Input:** The first line consists of a positive integer, `inputNum_size`, representing the total number of processes (`N`). The second line consists of `N` space-separated positive integers representing the process requests for `N` processes. The last line consists of a positive integer, `size`, representing the size of the cache.

**Output:** Print an integer representing the number of cache misses.

**Note:** A cache miss is when a process is requested but not found in the cache. 

**Example:**
```
Input:
6
1 2 3 4 1 2
3
Output:
4
```
**Explanation:** Cache state as requests come in ordered longest-time-in-cache to shortest-time-in-cache: 1*, 12*, 123*, 234*, 341, 412. Asterisk (*) represents a cache miss. So the total number of cache misses is 4.

### 5. CPU Cache 

A CPU cache that uses a memory management policy. The cache is initially empty and contains memory addresses numbered in the range 1-1000.

**Input:** The first line consists of a positive integer, `inputNum_size`, representing the total number of memory addresses (`N`). The second line consists of `N` space-separated positive integers representing the memory requests for `N` addresses. The last line consists of a positive integer, `size`, representing the size of the cache.

**Output:** Print an integer representing the number of cache misses.

**Note:** A cache miss is when a memory address is requested but not found in the cache. 

**Example:**
```
Input:
5
100 200 300 200 100
2
Output:
3
```
**Explanation:** Cache state as requests come in ordered longest-time-in-cache to shortest-time-in-cache: 100*, 200*, 300*, 200, 100. Asterisk (*) represents a cache miss. So the total number of cache misses is 3.
