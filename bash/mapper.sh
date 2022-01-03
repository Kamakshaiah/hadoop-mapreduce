#!/bin/bash
while read line; do
for token in $line; do
if [ "$token" = "kamakshaiah" ] ; then 
echo "kamakshaiah, 1"
elif [ "$token" = "ammu" ] ; then 
echo "ammu, 1"
fi
done 
done 
