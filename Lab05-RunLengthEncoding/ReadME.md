# Lab 5 — Run-Length Encoding (RLE)

A Java implementation of Run-Length Encoding (RLE), a lossless string compression method that replaces consecutive identical characters with the character and its count.

## How It Works

RLE scans the input string and replaces each run of identical characters with `<count><character>`.

**Example:**

| Input     | Compressed   | Ratio   |
|-----------|-------------|---------|
| `3322251` | `23321511`  | 114.3%  |
| `aaabbc`  | `3a2b1c`    | 100.0%  |
| `aaaaaaa` | `7a`        | 28.6%   |

Strings with long runs compress well. Strings without runs may actually get longer — there's no free lunch with data compression.

## Build & Run

```bash
cd src
javac RunLengthEncoding.java
java RunLengthEncoding
```

You'll be prompted to enter a string, and the program will output the compressed version along with the compression ratio.

## Sample Output

```
Enter the string to be compressed: 3322251
Compressed as: 23321511
114.3% (because the 'compressed' version is actually 14.3% longer than the original!)
```
