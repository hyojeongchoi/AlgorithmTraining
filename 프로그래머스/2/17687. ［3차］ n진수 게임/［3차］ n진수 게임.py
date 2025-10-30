def solution(n, t, m, p):
    def convert(num, base):
        digits = "0123456789ABCDEF"
        if num == 0:
            return "0"
        result = ""
        while num > 0:
            result = digits[num % base] + result
            num //= base
        return result

    # 1. 전체 문자열 만들기 (t*m개 이상 확보)
    s = ""
    num = 0
    while len(s) < t * m:
        s += convert(num, n)
        num += 1

    # 2. 튜브 차례만 t개 뽑기
    answer = ""
    for i in range(t):
        answer += s[p - 1 + i * m]  

    return answer
