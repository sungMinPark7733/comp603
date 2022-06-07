def read_data(filename):
  records = []
  with open(filename) as fr: #fr = filereader
    lines = fr.readlines()
    for line in lines:
      str_rec = line.strip().split(",")
      width = float(str_rec[0])
      length = float(str_rec[1])
      colour = str(str_rec[2])
      rec = [width, length, colour]
      records.append(rec)
  return records

def search_by_colour(data):
  colour = input("Enter a colour: ")
  rec = data[0]
  rec_found = None
  for rec in data:
    if colour.lower() == rec[2].lower():
      rec_found = rec
  if rec_found == None:
    print(f"No record found for {colour}")
  else:
    print(f"Area: {rec_found[0] * rec_found[1]} ")
    print(f"Perimeter: {(rec_found[0] + rec_found[1]) * 2}")

def get_average_area(data):
  total_area = 0
  for rec in data:
    area = rec[0] * rec[1]
    total_area += area
  avg = total_area / len(data)
  return avg

def print_records(data):
  wi_ttl, le_ttl, co_ttl = "Width", "Length", "Colour"
  print(f"{wi_ttl}{le_ttl:>10}{co_ttl:>10}")
  print("-" * 25)
  num = 0
  for rec in data:
      num += 1
      print(f"{rec[0]:<10.1f}{rec[1]:<10.1f}{rec[2]}")

def main():
  records = read_data("data.txt")
  search_by_colour(records)
  avg_cal =   get_average_area(records)
  print(f"Average area: {avg_cal:.1f}")
  print_records(records)
main()