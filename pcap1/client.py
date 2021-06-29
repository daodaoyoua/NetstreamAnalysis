import threading

import grpc
import Simulator_pb2
import Simulator_pb2_grpc
import dpkt
import datetime
import time
import socket
from dpkt.compat import compat_ord

def send(stub,netstream):
    return stub.sendNetStream(netstream)
def mac_addr(address):
    """Convert a MAC address to a readable/printable string

       Args:
           address (str): a MAC address in hex form (e.g. '\x01\x02\x03\x04\x05\x06')
       Returns:
           str: Printable/readable MAC address
    """
    return ':'.join('%02x' % compat_ord(b) for b in address)
def inet_to_str(inet):
    """Convert inet object to a string

        Args:
            inet (inet struct): inet network address
        Returns:
            str: Printable/readable IP address
    """
    # First try ipv4 and then ipv6
    try:
        return socket.inet_ntop(socket.AF_INET, inet)
    except ValueError:
        return socket.inet_ntop(socket.AF_INET6, inet)
def pack(eth, netstream, head, dict):     # 流打包,返回当前的流数量

    ip = eth.data
    transf = ip.data
    if ip.p == 1 or ip.p == 2:
        sp = 0
        dp = 0
    else:
        sp = transf.sport
        dp = transf.dport

    seven = mac_addr(eth.src) + mac_addr(eth.dst) + inet_to_str(ip.src) + inet_to_str(ip.src)\
          + str(ip.tos) + str(ip.p) + str(sp) + str(dp)
    if(seven in dict):
        dict.get(seven).Package_count += 1
        dict.get(seven).Byte_count += ip.len
        dict.get(seven).End_time = time.time()
    else:
        body = Simulator_pb2.NSbody()
        body.Start_time    = time.time()
        body.End_time      = time.time()
        body.Package_count = 1
        body.Byte_count    = ip.len
        body.Protocol_type = ip.p
        body.Dst_IP        = inet_to_str(ip.src)
        body.Src_IP        = inet_to_str(ip.src)
        body.Next_IP       = "0.0.0.0"
        body.Dstmask       = "255.255.255.0"
        body.Srcmask       = "255.255.255.0"
        body.Dst_AS        = 0
        body.Src_AS        = 0
        body.Out_interface = mac_addr(eth.src)
        body.In_interface  = mac_addr(eth.dst)
        body.Dst_port      = dp
        body.Src_port      = sp
        body.Tos           = ip.tos
        body.Reserved      = ""

        head.count += 1
        dict[seven] = body
        netstream.body.append(body)
    return head.count
def initHead(FLOW_SEQUENCE):
    head = Simulator_pb2.NShead()
    head.version        = 5
    head.count          = 0
    head.SysUptime      = time.time()
    head.unix_secs      = time.time()
    head.unix_nsecs     = time.time()
    head.flow_sequence  = FLOW_SEQUENCE
    head.engine_type    = 1
    head.engine_id      = 1
    head.reserved       = '0'
    return head
def run():
    # NOTE(gRPC Python Team): .close() is possible on a channel and should be
    # used in circumstances in which the with statement does not fit the needs
    # of the code.


    with grpc.insecure_channel('localhost:50001') as channel:
        stub = Simulator_pb2_grpc.SimulatorServiceStub(channel)

        f = open('D:\datawireshark\\DATA_MAX_00001_20210628180403.pcap', 'rb')
        pcap = dpkt.pcap.Reader(f)
        FLOW_SEQUENCE = 0    # 输出的流记录的顺序号
        count = 0# 统计IP包的数量
        netstream = Simulator_pb2.NetStream(head = initHead(FLOW_SEQUENCE))

        dict = {}
        c = 1  
        while True:
            for timestamp, buf in pcap:
                eth = dpkt.ethernet.Ethernet(buf)
                if not isinstance(eth.data, dpkt.ip.IP):
                     # print('Non IP Packet type not supported %s\n' % eth.data.__class__.__name__)
                    continue
                counter = pack(eth, netstream, netstream.head, dict)
                # 计数，如果遍历1000个包，则打包发送，并且初始化netstream
                count = count + 1

                if count == 10000 or counter == 30:
                    count = 0
                    dict.clear()
                    # netstream['head'] = head
                    FLOW_SEQUENCE += netstream.head.count
                    send(stub, netstream)  # 发送netstream
                    if c==10000:
                        break;
                    # print(netstream.head.flow_sequence)
                    # print()
                    print("打包成功",c)
                    print(datetime.datetime.fromtimestamp(netstream.head.unix_secs))
                    c+=1
                    netstream = Simulator_pb2.NetStream(head = initHead(FLOW_SEQUENCE)) # 初始化netstream
            break;
if __name__ == '__main__':
    run()

