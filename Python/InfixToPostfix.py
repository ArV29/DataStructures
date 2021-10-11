from stack import Stack

def infixToPostfix(expression):
  operators = Stack(len(expression))
  result = ''
  openingBrackets = {'(', '[', '{'}
  closingBrackets = {')', ']', '}'}
  bracketsPair = {')':'(', ']':'[', '}':'{'}
  precedence = {'+':1, '-':1, '*':2, '/':2, '^':3}
  for i in expression:
    if i in openingBrackets:
      operators.push(i)
    elif i in closingBrackets:
      if operators.isEmpty():
        print("Invalid Expression")
        return
      while(operators.peek()!=bracketsPair[i]):
        if operators.isEmpty():
          print("Invalid Expression")
          return
        result += operators.pop()
      if operators.isEmpty():
        print("Invalid Expression")
        return
      operators.pop()
    elif i in precedence:
      if operators.isEmpty() or operators.peek() in openingBrackets:
        operators.push(i)
      elif precedence[i] < precedence.get(operators.peek(), 0):
        while(not operators.isEmpty() and 
              not operators.peek() in openingBrackets and 
              precedence[operators.peek()]>=precedence[i]):
          result += operators.pop()
        operators.push(i)
      else:
        operators.push(i)
    else:
      result+=i
  while(not operators.isEmpty()):
    result+=operators.pop()

  print("Postfix Expression: ", result )


def main():
  expression = input("Enter infix expresssion: ")
  infixToPostfix(expression)

main()