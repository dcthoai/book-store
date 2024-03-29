-- Insert media

INSERT INTO `bookstore`.`media` (`mediaID`, `mediaName`, `mediaPath`, `mediaType`, `mediaSize`) VALUES ('1', '2', 'null', 'image', '123');
INSERT INTO `bookstore`.`media` (`mediaID`, `mediaName`, `mediaPath`, `mediaType`, `mediaSize`) VALUES ('2', '2', 'null', 'image', '123');
INSERT INTO `bookstore`.`media` (`mediaID`, `mediaName`, `mediaPath`, `mediaType`, `mediaSize`) VALUES ('3', '3', 'null', 'image', '123');

-- Insert slide
INSERT INTO `bookstore`.`slide` (`slideId`, `slideMedia`, `caption`, `content`) 
VALUES ('1', '1', 'Khám phá khoa học', 'Kích thích sự tò mò và khám phá với cuốn sách khoa học đầy màu sắc,
                                		mang đến những hiểu biết mới mẻ và hấp dẫn cho các trẻ nhỏ!');
INSERT INTO `bookstore`.`slide` (`slideId`, `slideMedia`, `caption`, `content`) 
VALUES ('2', '2', 'Truyện tranh hấp dẫn', 'Nhập vai vào thế giới phiêu lưu đầy màu sắc và hài hước với những trang truyện tranh tuyệt vời! 
                                			Khám phá những câu chuyện đầy phép thuật và nhân vật đầy cá tính, sẵn sàng chờ đợi bạn trong những trang sách tranh tuyệt vời!');
INSERT INTO `bookstore`.`slide` (`slideId`, `slideMedia`, `caption`, `content`) 
VALUES ('3', '3', 'Cùng nhau vào bếp', 'Khám phá hương vị thế giới và học cách trở thành đầu bếp tài ba với những công thức đơn giản
                                		và ngon miệng từ cuốn sách nấu ăn độc đáo này! 
                                		Từ món ăn truyền thống đến những món mới lạ, tất cả đều sẽ được tiết lộ bí mật trong từng trang sách, 
                                		mang lại cho bạn trải nghiệm ẩm thực tuyệt vời nhất.');

-- Insert blog
INSERT INTO `bookstore`.`blog` (`blogID`, `author`, `thumbnail`, `title`, `content`) VALUES ('1', '1', '1', 'Blog 1', 'Nội dung demo');
INSERT INTO `bookstore`.`blog` (`blogID`, `author`, `thumbnail`, `title`, `content`) VALUES ('2', '2', '2', 'Blog 2', 'Nội dung demo 2');
INSERT INTO `bookstore`.`blog` (`blogID`, `author`, `thumbnail`, `title`, `content`) VALUES ('3', '3', '3', 'Blog 3', 'Nội dung demo 3');

