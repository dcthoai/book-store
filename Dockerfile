
# Sử dụng image Maven để build dự án
FROM maven:3.6.0-jdk-8-slim AS build

# Thêm metadata cho ảnh Docker
LABEL maintainer="Đàm Công Thoại <dthoai2k3@gmail.com>"
LABEL version="1.0"
LABEL description="Image Docker cho ứng dụng Spring MVC bookstore với MySQL"

# Thiết lập working directory
WORKDIR /app

# Sao chép mã nguồn vào container
COPY src ./src
COPY pom.xml .

# Sử dụng file cấu hình settings.xml
#RUN mvn -s /usr/share/maven/ref/settings-docker.xml package

# Build ứng dụng Spring MVC
RUN mvn package

# Sử dụng image Tomcat làm nền tảng
FROM tomcat:9-jdk8-openjdk

# Sao chép file WAR từ giai đoạn build trước đó
COPY --from=build /app/target/ROOT.war /usr/local/tomcat/webapps/

# Câu lệnh để khởi động Tomcat khi container chạy
CMD ["catalina.sh", "run"]
