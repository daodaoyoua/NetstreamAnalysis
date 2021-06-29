# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.



# # Press the green button in the gutter to run the script.
# if __name__ == '__main__':
#     # pkts = rdpcap('C:/Users/Mloong/Desktop/Pcap_Analyzer-master/pcaps/123.pcap')
#     # pkts.show()
#     pkts = open('C:/Users/Mloong/Desktop/Pcap_Analyzer-master/pcaps/123.pcap','rb')
#     pcap = dpkt.pcap.Reader(pkts)
#     for ts, buf in pcap:
#         eth = dpkt.ethernet.Ethernet(buf)


# See PyCharm help at https://www.jetbrains.com/help/pycharm/
import dpkt
import datetime
import socket
from dpkt.compat import compat_ord
import time
for i in range (0,2):
    t = time.time()
    print(i)
    print(t)
    print(type(t))
    print(str(datetime.datetime.fromtimestamp(t)))



##
# def mac_addr(address):
#     """Convert a MAC address to a readable/printable string
#
#        Args:
#            address (str): a MAC address in hex form (e.g. '\x01\x02\x03\x04\x05\x06')
#        Returns:
#            str: Printable/readable MAC address
#     """
#     return ':'.join('%02x' % compat_ord(b) for b in address)
#
#
#
# def inet_to_str(inet):
#     """Convert inet object to a string
#
#         Args:
#             inet (inet struct): inet network address
#         Returns:
#             str: Printable/readable IP address
#     """
#     # First try ipv4 and then ipv6
#     try:
#         return socket.inet_ntop(socket.AF_INET, inet)
#     except ValueError:
#         return socket.inet_ntop(socket.AF_INET6, inet)
#
#
# def print_packets(pcap):
#     """Print out information about each packet in a pcap
#
#        Args:
#            pcap: dpkt pcap reader object (dpkt.pcap.Reader)
#     """
#     # For each packet in the pcap process the contents
#     for timestamp, buf in pcap:
#         eth = dpkt.ethernet.Ethernet(buf)
#         if not isinstance(eth.data, dpkt.ip.IP):
#             ## print('Non IP Packet type not supported %s\n' % eth.data.__class__.__name__)
#             continue
#
#         # Print out the timestamp in UTC
#         print('Timestamp: ', str(datetime.datetime.utcfromtimestamp(timestamp)))
#
#         # Unpack the Ethernet frame (mac src/dst, ethertype)
#
#         print('Ethernet Frame: ', mac_addr(eth.src), mac_addr(eth.dst), eth.type)
#
#         # Make sure the Ethernet data contains an IP packet
#
#         # Now unpack the data within the Ethernet frame (the IP packet)
#         # Pulling out src, dst, length, fragment info, TTL, and Protocol
#         ip = eth.data
#
#         # Pull out fragment information (flags and offset all packed into off field, so use bitmasks)
#         do_not_fragment = bool(ip.off & dpkt.ip.IP_DF)
#         more_fragments = bool(ip.off & dpkt.ip.IP_MF)
#         fragment_offset = ip.off & dpkt.ip.IP_OFFMASK
#         # Print out the info
#         print("ToS: ", ip.tos)
#         print("pro: ", ip.p)
#         print(("class",type(ip.p)))
#         print('IP: %s -> %s   (len=%d ttl=%d DF=%d MF=%d offset=%d)' % \
#               (inet_to_str(ip.src), inet_to_str(ip.dst), ip.len, ip.ttl, do_not_fragment, more_fragments, fragment_offset))
#         transf_data = ip.data  # 传输层负载数据，基本上分析流量的人都是分析这部分数据，即应用层负载流量
#         print("sport:",transf_data.sport)
#         print("dport:", transf_data.dport)
#         print(("class", type(transf_data.sport)))
#         print("*************************\n")
#
# def mac_addr(address):
#     """Convert a MAC address to a readable/printable string
#
#        Args:
#            address (str): a MAC address in hex form (e.g. '\x01\x02\x03\x04\x05\x06')
#        Returns:
#            str: Printable/readable MAC address
#     """
#     return ':'.join('%02x' % compat_ord(b) for b in address)
# def printPcap(pcap):
#     for (ts,buf) in pcap: # ts：时间戳  # buf：二进制数据包
#         try:
#             eth = dpkt.ethernet.Ethernet(buf)
#             print(mac_addr(eth.src))
#             print("**********************")
#             print(mac_addr(eth.dst))
#             ip = eth.data
#             src = socket.inet_ntoa(ip.src)
#             dst = socket.inet_ntoa(ip.dst)
#             print ('[+] Src:'+src+' -->Dst:'+dst)
#         except:
#             pass
# def main():
#     f = open('C:/Users/Mloong/Desktop/Pcap_Analyzer-master/pcaps/123.pcap',  'rb')
#     pcap = dpkt.pcap.Reader(f)
#     print_packets(pcap)
# #
# if __name__ == '__main__':
#     main()
