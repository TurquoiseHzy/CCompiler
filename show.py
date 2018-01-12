class mystruct:
  def __init__(self):
    return

def main():
  x = mystruct()
  y = mystruct()
  a = [200]
  s = "4xxx"
  x.attr1 = 10
  y.attr2 = 7
  z = 10
  i = 0
  while i < 5:
    if i == 2:
      i = i + 2
      continue
    print("%d"%(a[int(s[0]) + y.attr2 - x.attr1 - 1]),end = '')
    i = i + 2

  return


if __name__ == '__main__':
  main()
