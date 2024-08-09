# Unique IPv4 Address Counter

This project is a test task that efficiently counts unique IPv4 addresses using a custom data structure based on multiple layers of `BitSet`. The program processes IPv4 addresses represented as numbers for optimal performance, avoiding the use of strings and substrings. The conversion is done character by character, directly translating the IP address to a numerical format.

## Approach

Given the vast possible space of IPv4 addresses (2^32), the solution required a custom data structure where multiple layers of `BitSet` are used as an array to manage the data.

### BitSet Layering Strategy

To distribute the IP addresses across these layers, the program uses integer division and modulus operations, implemented as bit shifts to enhance performance:

This approach ensures that each IP address is accurately placed in the corresponding layer and bit within the `BitSet`.

## Performance

The program was tested on a recommended file size of 120GB, containing numerous IPv4 addresses. It successfully identified one billion unique IP addresses in approximately 400 seconds on an Intel i7 processor.

## Development Environment

- **IDE:** IntelliJ IDEA 2023.3.4
- **Language:** Java 21

## Usage

To use this program, ensure you have the following:

- Java 21 installed on your machine.
- The input file named `ip-addresses` placed in the same directory as the project.

Run the program, and it will process the file, outputting the number of unique IPv4 addresses found.