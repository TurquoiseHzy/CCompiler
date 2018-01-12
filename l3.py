def Priority(op):
  if op == '#':
    return 0
  if op == '+' or op == '-':
    return 1
  if op == '*' or op == '/':
    return 2
  return -1


def Operate(x, y, op):
  if op == '+':
    return x + y
  if op == '-':
    return x - y
  if op == '*':
    return x * y
  if op == '/':
    return x / y
  return -1


def Calc(str):
  stDit = [0]*300
  stOp = ""
  n = len(str)
  top1 = -1
  top2 = -1
  top2 += 1
  stOp = stOp[:top2] +'#' + stOp[1+top2:]
  str = str[:n] +'#' + str[1+n:]
  n += 1
  i = 0
  while i < n:
    if str[i] == ' ' or str[i] == '\n' or str[i] == '\t':
      i += 1
      continue
    if str[i].isdigit():
      tmp = int(str[i])
      while str[i + 1].isdigit():
        i += 1
        tmp = tmp * 10 + (int(str[i]))
      top1 += 1
      stDit[top1] = tmp
      i += 1
      continue
    if str[i] == '(':
      top2 += 1
      stOp = stOp[:top2] +str[i] + stOp[1+top2:]
      i += 1
      continue
    if str[i] == ')':
      while stOp[top2] != '(':
        y = stDit[top1]
        top1 -= 1
        x = stDit[top1]
        top1 -= 1
        op = stOp[top2]
        top2 -= 1
        top1 += 1
        stDit[top1] = Operate(x, y, op)
      top2 -= 1
    else: 
      while Priority(stOp[top2]) >= Priority(str[i]):
        if str[i] == '#' and stOp[top2] == '#':
          return stDit[top1]
        y = stDit[top1]
        top1 -= 1
        x = stDit[top1]
        top1 -= 1
        op = stOp[top2]
        top2 -= 1
        top1 += 1
        stDit[top1] = Operate(x, y, op)
      top2 += 1
      stOp = stOp[:top2] +str[i] + stOp[1+top2:]
    i += 1

  return stDit[top1]


def main():
  str = ""
  print("Please enter an arithmetic expression, less than 100 characters:\n",end = '')
  while 1:
    str = input()
    if not(str != ""):
      continue
    else: 
      print("%.2lf\n"%(Calc(str)),end = '')
      return


if __name__ == '__main__':
  main()
