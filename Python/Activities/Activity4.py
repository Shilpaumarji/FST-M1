player1 = str(input("what is first player name: "))
player2 = str(input("what is second player name: "))
while True:
     player1input = str(input("choose one of the type, rock, paper or scissors: ")).lower()
     player2input = str(input("choose one of the type, rock, paper or scissors: ")).lower()
     if player1input == player2input:
        print("diqualified")
     elif player1input  == "rock":
         if player2input == "scissors":
            print("rock wins!")
         else:
            print("paper wins!")
     elif player1input  == "scissors":
          if player2input == "paper":
             print("Scissors wins!")
          else:
             print("rock wins!") 
     elif player1input  == "paper":
          if player2input == "rock":
            print("paper wins!")
          else:
            print("scissors wins!") 
     else:
         print("not a valid input")                        
     repeat = input("Do you want to play another round? Yes/No: ").lower()
     if(repeat == "yes"):
        pass
     elif(repeat == "no"):
        raise SystemExit
     else:
           print("You entered an invalid option. Exiting now.")
           raise SystemExit
  
