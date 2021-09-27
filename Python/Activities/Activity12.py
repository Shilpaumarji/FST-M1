def sum(num):
    if num:
        return num+sum(num-1)
    else:
        return 0

#call function
x = sum(3)
print(x)
