class stuct:
  def __init__(self):
    return

def get_next(next, word, l):
  i = 0
  j = -1
  next[0] = -1
  while i < l:
    if j == -1 or word[i] == word[j]:
      j += 1
      i += 1
      if i == l or word[i] != word[j]:
        next[i] = j
      else: 
        next[i] = next[j]
    else: 
      j = next[j]


def str_kmp(next, text, word, l1, l2, result):
  i = -1
  j = -1
  counter = 0
  while i < l1:
    if j == -1 or text[i] == word[j]:
      i += 1
      j += 1
      if j == l2:
        counter += 1
        result[counter] = i - j
        j = next[j]
    else: 
      j = next[j]
  result[0] = counter


def main():
  print("Please enter the keyword:\n",end = '')
  word = input()
  print("Please enter the text:\n",end = '')
  text = input()
  tst = [stuct()]*200
  pt = stuct()
  pt.a = 1
  tst[pt.a].a = 1
  l1 = len(text)
  l2 = len(word)
  next = [0]*201
  result = [0]*2001
  get_next(next, word, l2)
  str_kmp(next, text, word, l1, l2, result)
  if result[0]:
    i = 1
    print("%d"%(result[0]),end = '')
    print(": ",end = '')
    while i <= result[0]:
      print("%d"%(result[i]),end = '')
      print(" ",end = '')
      i += 1
    print("\n",end = '')
  else: 
    print("Null",end = '')
  return


if __name__ == '__main__':
  main()
