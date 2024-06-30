# Sử dụng image Tomcat 9.0.86 làm nền tảng
FROM tomcat:9.0.86-jdk8-openjdk-slim

# Thêm metadata cho ảnh Docker
LABEL maintainer="Đàm Công Thoại <dthoai2k3@gmail.com>"

# Thiết lập biến môi trường cho ứng dụng Spring
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS

# Xóa file WAR mẫu có sẵn trong Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Sao chép file WAR của ứng dụng Spring vào thư mục webapps của Tomcat
COPY target/bookstore.war /usr/local/tomcat/webapps/

# Câu lệnh để khởi động Tomcat khi container chạy
CMD ["catalina.sh", "run"]
