import sys
input = sys.stdin.readline

a, b = map(int, input().split())
total = 153  # 가능한 카드 조합의 수 
ans = 0  # 영학이가 이길 수 있는 경우의 수
if a == b:
    ans = total - (10 - a)
else:
    mypoint = (a + b) % 10  # 영학이의 카드 합의 일의 자리
    for i in range(1, 11):
        for j in range(i + 1, 11):
            if mypoint > (i + j) % 10:  # 상대방의 카드 합의 일의 자리가 작을 경우
                if i == a and j == b:
                    continue  # 영학이의 카드와 같은 카드 조합은 제외
                elif i == a or j == a or i == b or j == b:
                    ans += 2  # 영학이의 카드가 포함되었을 때
                else:
                    ans += 4  # 영학이의 카드가 포함되지 않았을 때
print("%.3f" % (ans / total))