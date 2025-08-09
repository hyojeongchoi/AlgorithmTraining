def d(n):
    total = n
    while n > 0:
        total += n % 10
        n //= 10
    return total

#결과값 저장
made = [False] * (10001)

for i in range(1, 10001):
    next_num = d(i)
    if next_num <= 10000:
        made[next_num] = True

for i in range(1, 10001):
    if not made[i]:
        print(i)
