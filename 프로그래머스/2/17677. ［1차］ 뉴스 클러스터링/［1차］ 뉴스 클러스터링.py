#1 다 대문자로 바꾸기

#1 먼저 다 대문자 혹은 소문자로 바꾸기 
#2 영어만 확인 그 다음에 2개 묶기 
#3 교집합
#4 합집합
#5 자카드 유사도 계산


# 알파벳 묶기
def makePair(s):
    s = s.upper() #모두 대문자로 바꿈
    result=[]
    for i in range(len(s)-1):
        a,b = s[i], s[i+1]
        # 영어인거만 살리기
        if a.isalpha() and b.isalpha():
            result.append(a+b)
    return result

# 교집합, 합집합 계산
def getUnion(list1, list2):
    Clist2= list2[:]  #원본값 변경되지 않게
    intersection = [] #교집합    
    #교집합 연산
    for x in list1:
        if x in Clist2 :
            intersection.append(x)
            Clist2.remove(x)

    #합집합 (중복된거는 두번 카운팅 되니까 그 부분 미리 한번 빼줘야 함)
    union = list1 + list2[:]#합집합
    for x in intersection:
        union.remove(x)
    return intersection, union    


def solution(str1, str2):
    a = makePair(str1)
    b = makePair(str2)
    if not a and not b:
        return 65536
    
    intersection, union = getUnion(a,b)
    answer = len(intersection)/len(union)
                 
    return int(answer * 65536)
