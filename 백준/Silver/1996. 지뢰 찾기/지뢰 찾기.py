# N개의 역
# M: 대피선 설치 수
# K:  N까지 소요 분
# X: 일반 열차 개수
# Y: 급행 열차 개수

N = int(input())  
board = []        

for _ in range(N):
    line = input().strip() 
    board.append(list(line)) 

result = [[0] * N for _ in range(N)]  


dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

for i in range(N):
    for j in range(N):
        if board[i][j] != '.':  # 지뢰가 있는 칸이면
            num = int(board[i][j])  # 지뢰 개수
            # 더해주기
            for d in range(8):
                ni = i + dx[d] # 주변 x 좌표
                nj = j + dy[d] # 주변 y 좌표
                # 범위 안, 지뢰 x
                if 0 <= ni < N and 0 <= nj < N and board[ni][nj] == '.':
                    result[ni][nj] += num


for i in range(N):
    row = ''
    for j in range(N):
        if board[i][j] != '.':  # 지뢰칸
            row += '*'
        else:  # 지뢰 x
            if result[i][j] >= 10:
                row += 'M'  # 10 이상이면 M 출력
            else:
                row += str(result[i][j])
    print(row)
