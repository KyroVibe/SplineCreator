#!/usr/bin/env python3

import matplotlib.pyplot as plt

x_list = []
y_list = []

file = open("/home/n30b4rt/Desktop/AccelCords.spart", "r")
data = file.read()

cords = data.split('\n')

print(cords)

for x in range(len(cords) - 1):
    print(cords[x] + "\n=========")
    x_list.append(float(cords[x].split(',')[0]))
    y_list.append(float(cords[x].split(',')[1]))

plt.plot(x_list, y_list)

plt.xlabel('X')
plt.ylabel('Y')

plt.show()