N = int(input())
arr = list(input())

rainbow_lower = {'r', 'o', 'y', 'g', 'b', 'i', 'v'}
rainbow_upper = {'R', 'O', 'Y', 'G', 'B', 'I', 'V'}

arr_set = set(arr)

has_lower = rainbow_lower.issubset(arr_set)
has_upper = rainbow_upper.issubset(arr_set)

if has_lower and has_upper:
    print("YeS")
elif has_lower:
    print("yes")
elif has_upper:
    print("YES")
else:
    print("NO!")
