num_tuple = tuple(input("Enter numbers: ").split(", "))
print(num_tuple)
print("find numbers divisible by 5")   
for num in num_tuple: 
    if (int(num) % 5 == 0):
        print(num)