def solution(answers):
    answer = []
    person = [[1, 2, 3, 4, 5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    
    score = [0]*3
    for i in range(3):
        length = len(person[i])
        for j in range(len(answers)):
            print(answers[j], person[i][j%length])
            if answers[j]==person[i][j%length]:
                score[i]+=1
    
    max_score = max(score)
    for i in range(3):
        if max_score==score[i]:
            answer.append(i)
        
    return answer

print(solution([1,2,3,4,5]))