def get_next(next, word, l):
  i = 0
  j = -1
  next[0] = -1
  while i<l:
    if j==-1 or word[i]==word[j]:
      j += 1
      i += 1
      if i==l or word[i]!=word[j]:
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
    if j==-1 or text[i]==word[j]:
      i += 1
      j += 1
      if j==l2:
        counter += 1
        result[counter] = i-j
        j = next[j]
    else: 
      j = next[j]
  result[0] = counter
def main():
  text=[0]*2000
  word=[0]*200
  printf()
  scanf(, word)
  printf()
  scanf(, text)
  l1 = strlen(text)
  l2 = strlen(word)
  next=[0]*201
  result=[0]*2001
  get_next(next, word, l2)
  str_kmp(next, text, word, l1, l2, result)
  if result[0]:
    i = 1
    printf(, result[0])
    printf()
    while i<=result[0]:
      printf(, result[i])
      printf()
      i += 1
    printf()
  else: 
    printf()
  return 0
