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
