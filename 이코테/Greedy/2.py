# 숫자 카드 게임
#행 개수만 가지고 값을 집어넣기 때문에 열의 개수가 초과되도 오류 안남

# n과 m을 입력받음
n, m = list(map(int,input().split()))

result = 0
# 한 줄씩 입력받아서 배열에 넣어주기
for i in range(n):
    data = list(map(int, input().split()))
    # 현재 줄에서 '가장 작은 수 찾기'
    min_value = min(data)
    # '가장 작은 수'들 중에서 가장 큰 수 찾기
    result = max(result, min_value)

print(result)

