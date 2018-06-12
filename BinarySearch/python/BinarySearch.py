def find_index_of(value, list):
    index = -1
    if len(list) == 0: index = -1
    else:
        lowpoint = 0
        highpoint = len(list)
        while lowpoint < highpoint:
            midpoint = int((lowpoint + highpoint) / 2)
            if value == list[midpoint]:
                index = midpoint
                break
            if value > list[midpoint]: lowpoint = midpoint + 1
            if value < list[midpoint]: highpoint = midpoint
    return index
