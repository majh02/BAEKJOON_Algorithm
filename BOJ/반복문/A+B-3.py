T = int(input())

result = ""
for i in range(0, T) :
    A, B = input().split()
    A = int(A)
    B = int(B)
    sum = A+B
    result+=(str(sum)+"\n")

print(result)