#!/bin/bash

javac *.java

# Time quick sort
echo "REGULAR QUICK SORT"
time java Quick 1
time java Quick 1
time java Quick 1
echo ""
time java Quick 2
time java Quick 2
time java Quick 2

echo "PREVIOUS QUICK SORT"
time java QuickOld 1
time java QuickOld 1
time java QuickOld 1
echo ""
time java QuickOld 2
time java QuickOld 2
time java QuickOld 2
