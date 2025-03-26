N = int(input())

dp = [0] * 10000001
for i in range (2, N+1) :
    dp[i] = dp[i-1] + 1 # 1을 빼주는 경우는 모든 숫자에 대해서 가능
    
    if i % 2 == 0: # 2로 나누어 떨어지는 경우, 최소값 갱신
        dp[i] = min(dp[i], dp[i//2] + 1) 
    
    if i % 3 == 0 :# 3으로 나누어 떨어지는 경우, 최소값 갱신
        dp[i] = min(dp[i], dp[i//3] + 1)

print(dp[N])