def test(s, len):
  i = 0
  j = len - 1
  while i < j:
    if s[i] != s[j]:
      return 0
    i += 1
    j -= 1
  return 1


def main():
  s = ""
  print("Enter the string to test: ",end = '')
  s = input()
  if test(s, len(s)):
    print("The string is palindromic.\n",end = '')
  else: 
    print("The string is not palindromic.\n",end = '')
  return


if __name__ == '__main__':
  main()
