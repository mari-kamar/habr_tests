sudo docker build - < Dockerfile

FROM selenium/standalone-chrome

MAINTAINER engalychevamg

RUN sudo apt-get update \
&& sudo apt-get -y install git

RUN git clone https://github.com/mari-kamar/habr_tests.git

RUN sudo apt-get install -assume-yes maven

CMD echo "Hello, my tests!"