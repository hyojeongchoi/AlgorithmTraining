n=int(input()) 
s=[int(input()) for _ in range(n)] 
dp=[0]*(n) # dp 리스트
if len(s)<=2: # 계단이 2개 이하
    print(sum(s))
else: # 계단이 3개 이상
    dp[0]=s[0] 
    dp[1]=s[0]+s[1] 
    for i in range(2,n): 
        dp[i]=max(dp[i-3]+s[i-1]+s[i], dp[i-2]+s[i])
    print(dp[-1])