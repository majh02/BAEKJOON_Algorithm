import sys
import math

R = int(sys.stdin.readline())

result1 = round(R*R*math.pi, 6)
result2 = R*R*2
print("{:.6f}".format(result1))
print("{:.6f}".format(result2))