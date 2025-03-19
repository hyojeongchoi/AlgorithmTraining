import sys
sys.setrecursionlimit(10**6)

T = int(input())

# dfs
def dfs(x, y):
    if x < 0 or y < 0 or x >= M or y >= N: # 재귀호출을 했을 때 좌표 확인
        return False
    if array[x][y] == 1: # 배추가 심어져 있으면
        array[x][y] = 0 # 0로로 바꾸어 방문표시
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y+1)
        dfs(x, y-1)
        return True
    return False # 배추가 심어져 있지 않은 경우

for i in range(T): # T번 반복
    M, N, K = map(int, input().split())
    array = [[0] * N for i in range(M)]

    for i in range(K):
        x, y = map(int, input().split())
        array[x][y] = 1
    # print(array)
    
    # 그래프를 순회하며 탐색
    total = 0
    for i in range(M):
        for j in range(N):
            if dfs(i, j) == True:
                total += 1
    print(total)