# 1이 될 때까지
import time

# 1. 내 코드 -> 시간 오래 걸림

n, k = list(map(int, input().split()))
n2 = n
k2 = k
start_time1 = time.time()
result = 0
while n != 1:
    if n % k == 0:
        n = n / k
    else:
        n = n-1
    result += 1
print(result)
end_time1 = time.time()
print(f"{end_time1 - start_time1:.10f} sec")

# 2. 나동빈님 코드
result = 0
start_time2 = time.time()

while True:
    target = (n2//k2)*k2
    result += (n2-target)
    n2 = target

    if n2 < k2:
        break

    result += 1
    n2 //= k2

result += (n2 - 1)
print(result)
end_time2 = time.time()
print(f"{end_time2 - start_time2:.10f} sec")



