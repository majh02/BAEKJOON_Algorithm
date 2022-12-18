def solution(N, number):
    
    dp = []
    for i in range(1, 9):
        tmp_set = set()
        tmp_set.add(int(str(N)*i))
        for j in range(i-1):
            print(f'i: {i}, j:{j}, i-j:{i-j}')
            for prevNum in dp[j]:
                for postNum in dp[-j-1]:
                    tmp_set.add(prevNum+postNum)
                    tmp_set.add(prevNum-postNum)
                    tmp_set.add(prevNum*postNum)
                    if postNum!=0 : tmp_set.add(prevNum/postNum)
                
        if (number in tmp_set)==True:
            return i
        
        print(tmp_set)
        dp.append(tmp_set)
    
    return -1

N = 5
number = 12

print(solution(N, number))