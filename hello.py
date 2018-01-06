def get_next(next, word, l):
  i = 0
  j = -1
  next[0] = -1
  while i<l:
    if j==-1||word[i]==word[j]:
      j++
      i++
      if i==l||word[i]!=word[j]:
        next[i] = j
      else: 
        next[i] = next[j]
    else: 
      j = next[j]
def str_kmp(next, text, word, l1, l2, result):
  i = -1
  j = -1
  counter = 0
  while i<l1:
    if j==-1||text[i]==word[j]:
      i++
      j++
      if j==l2:
        counter++
        result[counter] = i-j
        j = next[j]
    else: 
      j = next[j]
  result[0] = counter
def main():
      printf()
  scanf(, word)
  printf()
  scanf(, text)
  l1 = strlen(text)
  l2 = strlen(word)
      get_next(next, word, l2)
  str_kmp(next, text, word, l1, l2, result)
  if result[0]:
    i = 1
    printf(, result[0])
    printf()
    while i<=result[0]:
      printf(, result[i])
      printf()
      i++
    printf()
  else: 
    printf()
  return 0
