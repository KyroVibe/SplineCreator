#!/usr/bin/env python3

import matplotlib.pyplot as plt

leftx = []
lefty = []
rightx = []
righty = []

file = open("C:\\Users\\997CHSROBOTICS\\Desktop\\PathData.spart", "r")
data = file.read()

twocords = data.split('\n')

def printList(lst):
    for x in range(len(lst)):
        print(lst[x])

for x in range(len(twocords) - 1):
    cords = twocords[x].split(',')
    printList(cords)
    left = cords[0].split('%')
    leftx.append(float(left[0]))
    lefty.append(float(left[1]))
    right = cords[1].split('%')
    rightx.append(float(right[0]))
    righty.append(float(right[1]))

plt.plot(leftx, lefty)
plt.plot(rightx, righty)

plt.xlabel('X')
plt.ylabel('Y')

plt.show()