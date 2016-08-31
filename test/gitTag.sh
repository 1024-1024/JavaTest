#!/bin/bash
var=$(find ./src/test1 -name '*1.java')
echo $var
arr=(${var//./ })
echo ${arr[${#arr[@]}-1]}
tagName=${arr[${#arr[@]}-1]}
echo $tagName
git tag -a v$tagName -m "$tagName"
git push origin v$tagName

