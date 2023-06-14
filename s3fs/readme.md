sudo s3fs mbucket2.0 /mnt/mybucket -o passwd_file=~/passwd-s3fs -o umask=022 -o url=https://s3.amazonaws.com -o allow_other -o use_path_request_style
