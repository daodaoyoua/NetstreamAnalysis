import threading
import time

# 为线程定义一个函数

# 创建两个线程
from client import run

if __name__ == '__main__':
    print("12312321")
    threads = []
    try:
        for i in range (0,100):
            s = "D:\datawireshark\\" + str((i%5+1)) + ".pcap"
            temp = threading.Thread(target=run,args=(s,))
            threads.append(temp)
        # t1 = threading.Thread(target=run,args=('D:\datawireshark\\DATA_MAX_00001_20210628180403.pcap',))
        # threads.append(t1)
        # t2 = threading.Thread(target=run,args=('D:\datawireshark\Xing\\1_00001_20211008161455.pcap',))
        # threads.append(t2)
    except:
        print
        "Error: unable to start thread"
    print(len(threads));
    for t in threads:
        # t.setDaemon(True)
        t.start()
        # print("321313")
    # print "all over %s" %ctime()