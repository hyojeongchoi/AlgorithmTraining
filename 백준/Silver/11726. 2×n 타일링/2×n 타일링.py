n = int(input())
# memoization을 위함
cache = [0]*1001
# n이 1,2인 경우는 명확
cache[1]=1
cache[2]=2
# dynamic programming
for i in range(3,1001):
  cache[i] = (cache[i-1]+cache[i-2])%10007

print(cache[n])