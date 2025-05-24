n, k= map(int,input().split())
arr = list(map(int,input().split()))
result = []

for i in range(0, n-k+1):
    result.append(sum(arr[i:i+k]))

print(max(result))