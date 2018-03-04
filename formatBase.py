#!/usr/bin/env python3

import csv
import sys


def main():
    """
    Formats the standard input to standard output
    Replaces lines of the form [\s]*//R(.*)//[\s]* with a line for every row of data.csv
    with the central string formatted according to the row of data.csv
    Replaces lines of the form [\s]*//L(.*)//[\s]* with the central string formatted with the number of rows
    """
    if len(sys.argv) != 2:
        sys.exit("Usage: {} [data.csv] < [ClassBase.java] > [Class.java]".format(sys.argv[0]))

    with open(sys.argv[1]) as f:
        reader = csv.DictReader(f, skipinitialspace=True)
        rows = [{k: v for k, v in row.items()} for row in reader]

    for line_ in sys.stdin:
        line_ = line_.rstrip()
        line = line_.strip()
        if line.startswith("//L") and line.endswith("//"):
            print(line[3:-2].format(len(rows)))

        elif line.startswith("//R") and line.endswith("//"):
            for i, vals in enumerate(rows):
                print(line[3:-2].format(i, **vals))

        else:
            print(line_)


if __name__ == "__main__":
    main()
