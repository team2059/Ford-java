#!/bin/zsh
\cd "$(dirname "$0")">/dev/null
# Options:
# --mode=java    : Java formatting
# -xc            : Brace attached to class names
# --style=google : Google style (similar to 1tbs)
# -j             : Always add brackets (even on one line if statements)
# -s2            : Three spaces
# -xG            : Indent modifiers (C++ only, but i'm keeping it)
# -S             : Indent switches
# -K             : Indent cases
# -N             : Indent namespaces (unsure if this applies to Java, keeping it anyway)
# -xn            : Attach bracket to namespace
# -xl            : Attach inlines
# -n             : Don't make a backup
# -p             : Pad operators
# -H             : Pad header (space after if, for, while)
OPTS=( --mode=java -xc --style=google -j -s2 -xG -S -K -N -xn -xl -n -p -H )
GLOB=( src/**/*.java )
astyle $OPTS $GLOB|\grep -P '^(?!Unchanged)'
\cd ->/dev/null
