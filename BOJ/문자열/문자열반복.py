import sys

T = int(sys.stdin.readline())

result = ""
for t in range(T):
    R, S = sys.stdin.readline().split()
    R = int(R)
    arr = list(S)
    for i in range(arr.__len__()):
        for j in range(R):
            result+=arr[i]

    result += "\n"

print(result)
