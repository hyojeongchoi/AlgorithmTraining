n = int(input())  

for i in range(1, n+1):   
    num = sum((map(int, str(i))))  # 각 자릿수 더함
    num_sum = i + num  # 분해합 = 생성자 + 각 자릿수의 합
    if num_sum == n:
        print(i)
        break
    if i == n:  
        print(0)
    