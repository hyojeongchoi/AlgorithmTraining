cash_j=int(input())
cash_s = cash_j
li = list(map(int,input().split()))
j, s = 0,0
jooo,joo = 0,0

#준현
for i in range(len(li)):
    if li[i] <= cash_j:
        jooo += cash_j // li[i] #준현이의 주식 수
        cash_j = cash_j % li[i]

j = cash_j + li[-1]*jooo


#성민
for i in range(3,len(li)):

    #매수
    if li[i-3] > li[i-2] > li[i-1] > li[i]:
        joo += cash_s // li[i] #성민이의 주식 수
        cash_s = cash_s % li[i]
        
    # 매도    
    elif li[i-3] < li[i-2] < li[i-1] < li[i]:
        joo += cash_s // li[i]
        cash_s = cash_s % li[i]

s = cash_s + li[-1]*joo

if j > s:
    print("BNP")
elif j < s:
    print("TIMING")
else:
    print("SAMESAME")