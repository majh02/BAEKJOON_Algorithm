# https://computer-science-student.tistory.com/586 참고했음
import sys
import math

n_max = 123456
is_prime = [True] * (2*n_max+1)
is_prime[0], is_prime[1] = False, False

for i in range(2, int(math.sqrt(2*n_max))+1):
    if is_prime[i]:
        j = 2
        while (i*j) <= (2*n_max):
            is_prime[i*j] = False
            j += 1

while (n := int(sys.stdin.readline())) != 0:
    print(is_prime[n + 1:(2 * n) + 1].count(True))