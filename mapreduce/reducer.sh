#!/bin/bash
kcount=0
pcount=0
while read line ; do 
if [ "$line" = "kamakshaiah, 1" ] ; then 
let kcount=kcount+1
elif [ "$line" = "ammu, 1" ] ; then 
let pcount=pcount+1
fi
done 
echo "kamakshaiah, $kcount"
echo "ammu, $pcount"

