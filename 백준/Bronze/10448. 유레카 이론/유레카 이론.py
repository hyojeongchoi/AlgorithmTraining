import sys

answer = [0] * 1001
tNum = []
for i in range(1, 45):
    tNum.append(i * (i + 1) // 2)

for i in tNum:
    for j in tNum:
        for k in tNum:
            if i + j + k <= 1000:
                answer[i + j + k] = 1

input = sys.stdin.readline
T = int(input())
K = []
for _ in range(T):
    K.append(int(input()))

for i in K:
    print(answer[i])