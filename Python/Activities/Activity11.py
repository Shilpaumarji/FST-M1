fruit_shop = { "mango" : 100,
"guava" : 50,
"apple" : 60,
"chikku": 50}
fruit_available = input("enter which fruit you need: ").lower()
if(fruit_available in fruit_shop):
    print("yes, this is available")
else:
     print("No, this is not available")
