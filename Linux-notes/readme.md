# To review boot messages in Linux:
- you can follow these steps:

- Open a terminal: Launch a terminal on your Linux system. You can usually find it in the Applications menu or by using the shortcut key combination Ctrl+Alt+T.

- View system logs: Linux distributions typically store boot messages in system log files. The most common log file to review boot messages is /var/log/dmesg. Run the following command to display the boot messages:

        dmesg
- This command displays the entire boot log. 
- 
# How can I verify which ports are listening on Linux server?/ How to check if port is in use in
-  it may be necessary to check if a port is already in use by a different application on your servers.
1. Open a terminal application i.e. shell prompt.
2. Run any one of the following command on Linux to see open ports

                - lsof -i  | grep LISTEN      < it only gives you the what are the ports are open to access, "systemd-127.0.0.1", 
                - ss -tulpn | grep LISTEN
                - netstat -tulpn | grep ':80'
                 - nc -zv ip port
** Network troubleshooting commands ** 


netstat -plunt | grep "listen"
# edit file via sed command
                
                sed 's/unix/linux/' geekfile.txt

# /How can I verify which ports are listening on Linux server?/ How to check if port is in use in

 $ nc -zv localhost 2379
 
 $ netstat -plunt | grep "2379"

////find the empty directory inside linux?
$ find /path/to/directory -type d -empty


search pattern in linux.
$ grep  -i "error" /var/log/messages


FIND disk type of linux

/usr/sbin/lspci | grep SATA

available disk in linux
$ lscsi

# find the empty directories in linux?
        find /path/to/directory -type d -empty
`with python scripts` 
                                               
                                        import os

                                                def find_empty_directories(directory):
                                                    empty_dirs = []
                                                
                                                    for root, dirs, files in os.walk(directory, topdown=False):
                                                        for dir_name in dirs:
                                                            dir_path = os.path.join(root, dir_name)
                                                            if not os.listdir(dir_path):
                                                                empty_dirs.append(dir_path)
                                                
                                                    return empty_dirs
                                                
                                                directory_path = '/path/to/directory'
                                                empty_dirs = find_empty_directories(directory_path)
                                                
                                                for dir_path in empty_dirs:
                                                    print(dir_path)

