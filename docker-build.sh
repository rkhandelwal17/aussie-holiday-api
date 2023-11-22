docker build -t <your-repo-name> .

aws ecr get-login-password  | docker login --username AWS --password-stdin <your-account>.dkr.ecr.us-west-2.amazonaws.com

docker tag <your-repo-name> <your-account>.dkr.ecr.us-west-2.amazonaws.com/<your-repo-name>:v1                                                                            
docker push <your-account>.dkr.ecr.us-west-2.amazonaws.com/<your-repo-name>:v1