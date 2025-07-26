n = int(input())
s = list(input())

p_list = []
c_list = []

for i in range(n):
    if s[i] == 'P':
        p_list.append(i)  
    elif s[i] == 'C':
        c_list.append(i)  

pair_count = min(len(p_list), len(c_list))

for i in range(pair_count):
    p_idx = p_list[i]
    c_idx = c_list[i]
    s[p_idx], s[c_idx] = s[c_idx], s[p_idx]

print(''.join(s))
