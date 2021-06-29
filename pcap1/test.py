import threading
def fun_timer():
    print('***********************************************************!')
    return 0

while True:
    print("Dasdasfdas")
    timer = threading.Timer(10,fun_timer)
    timer.start()
    timer.join()

