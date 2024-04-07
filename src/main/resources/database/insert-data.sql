
-- Media

INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('comic.png', 'assets/images/comic.png', null, null, 'admin1');
INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('science.png', 'assets/images/science.png', null, null, 'admin1');
INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('cooking.png', 'assets/images/cooking.png', null, null, 'admin1');
INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('post-1.jpg', 'assets/images/post-1.jpg', null, null, 'admin1');
INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('post-2.jpg', 'assets/images/post-2.jpg', null, null, 'admin1');
INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('post-3.jpg', 'assets/images/post-3.jpg', null, null, 'admin1');
INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('caterpillar.jpg', 'assets/images/caterpillar.jpg', null, null, 'admin1');
INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('kil-bird.jpg', 'assets/images/kil-bird.jpg', null, null, 'admin1');
INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('hail-mary.jpg', 'assets/images/hail-mary.jpg', null, null, 'admin1');
INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('doi-thua.jpg', 'assets/images/doi-thua.jpg', null, null, 'admin1');
INSERT INTO `bookstore`.`media` (`name`, `path`, `type`, `size`, `createdBy`) VALUES ('lang.jpg', 'assets/images/lang.jpg', null, null, 'admin1');

-- Slide

INSERT INTO `bookstore`.`slide` (`thumbnailId`, `caption`, `content`, `link`, `createdBy`) VALUES ('2', 'Khám phá khoa học', 'Kích thích sự tò mò và khám phá với cuốn sách khoa học đầy màu sắc, mang đến những hiểu biết mới mẻ và hấp dẫn cho các trẻ nhỏ!', 'bookstore/product?category=khoa-hoc', 'admin1');
INSERT INTO `bookstore`.`slide` (`thumbnailId`, `caption`, `content`, `link`, `createdBy`) VALUES ('1', 'Giải trí với truyện tranh hấp dẫn', 'Nhập vai vào thế giới phiêu lưu đầy màu sắc và hài hước với những trang truyện tranh tuyệt vời! Khám phá những câu chuyện đầy phép thuật và nhân vật đầy cá tính, sẵn sàng chờ đợi bạn trong những trang sách tranh tuyệt vời!', 'bookstore/product?category=truyen-tranh', 'admin1');
INSERT INTO `bookstore`.`slide` (`thumbnailId`, `caption`, `content`, `link`, `createdBy`) VALUES ('3', 'Cùng nhau vào bếp', 'Khám phá hương vị thế giới và học cách trở thành đầu bếp tài ba với những công thức đơn giản và ngon miệng từ cuốn sách nấu ăn độc đáo này! Từ món ăn truyền thống đến những món mới lạ, tất cả đều sẽ được tiết lộ bí mật trong từng trang sách, mang lại cho bạn trải nghiệm ẩm thực tuyệt vời nhất.', 'bookstore/product?category=nau-an', 'admin1');

-- Author

INSERT INTO `bookstore`.`author` (`name`, `createdBy`) VALUES ('Nam Cao', 'admin1');
INSERT INTO `bookstore`.`author` (`name`, `createdBy`) VALUES ('Kim Lân', 'admin1');
INSERT INTO `bookstore`.`author` (`name`, `createdBy`) VALUES ('Eric Carle', 'admin1');
INSERT INTO `bookstore`.`author` (`name`, `createdBy`) VALUES ('Harper Lee', 'admin1');
INSERT INTO `bookstore`.`author` (`name`, `createdBy`) VALUES ('Andy Weir', 'admin1');

-- Publisher

INSERT INTO `bookstore`.`publisher` (`name`, `address`, `phone`, `email`, `createdBy`) VALUES ('Văn Học', '18 Nguyễn Trường Tộ - Ba Đình - Hà Nội', '024.37161518 - 024.37163409', 'info@nxbvanhoc.com.vn', 'admin1');

-- Category

INSERT INTO `bookstore`.`category` (`name`, `description`, `createdBy`) VALUES ('Văn học', 'Chưa có mô tả', 'admin1');
INSERT INTO `bookstore`.`category` (`name`, `description`, `createdBy`) VALUES ('Nấu ăn', 'Chưa có mô tả', 'admin1');
INSERT INTO `bookstore`.`category` (`name`, `description`, `createdBy`) VALUES ('Khoa học', 'Chưa có mô tả', 'admin1');

-- Language

INSERT INTO `bookstore`.`language` (`name`, `code`, `createdBy`) VALUES ('Tiếng Việt', 'VN', 'admin1');
INSERT INTO `bookstore`.`language` (`name`, `code`, `createdBy`) VALUES ('English', 'ENG', 'admin1');
INSERT INTO `bookstore`.`language` (`name`, `code`, `createdBy`) VALUES ('Chinese', 'CHI', 'admin1');

-- Blog



-- Book

INSERT INTO `bookstore`.`book` (`title`, `description`, `size`, `authorId`, `publisherId`, `languageId`, `categoryId`, `voucherId`, `thumbnailId`, `pages`, `weight`, `price`, `discount`, `purchases`, `rate`, `releaseDate`, `createdBy`) 
VALUES ('Sách Chú Sâu háu ăn', 'Chưa có mô tả', '15x20 cm', '3', '1', '2', '3', NULL, '7', '125', '200', '79000', '5', '0', NULL, '2019-02-16', 'admin1');

INSERT INTO `bookstore`.`book` (`title`, `description`, `size`, `authorId`, `publisherId`, `languageId`, `categoryId`, `voucherId`, `thumbnailId`, `pages`, `weight`, `price`, `discount`, `purchases`, `rate`, `releaseDate`, `createdBy`) 
VALUES ('To Kill A Mocking Bird', 'Chưa có mô tả', '15x20 cm', '4', '1', '2', '3', NULL, '8', '235', '200', '49000', '5', '0', NULL, '2009-02-23', 'admin1');

INSERT INTO `bookstore`.`book` (`title`, `description`, `size`, `authorId`, `publisherId`, `languageId`, `categoryId`, `voucherId`, `thumbnailId`, `pages`, `weight`, `price`, `discount`, `purchases`, `rate`, `releaseDate`, `createdBy`) 
VALUES ('Hail Mary', 'Chưa có mô tả', '15x20 cm', '5', '1', '2', '3', NULL, '9', '125', '290', '109000', '5', '0', NULL, '2023-02-19', 'admin1');

INSERT INTO `bookstore`.`book` (`title`, `description`, `size`, `authorId`, `publisherId`, `languageId`, `categoryId`, `voucherId`, `thumbnailId`, `pages`, `weight`, `price`, `discount`, `purchases`, `rate`, `releaseDate`, `createdBy`) 
VALUES ('Đời thừa', 'Chưa có mô tả', '15x20 cm', '1', '1', '1', '1', NULL, '10', '125', '20', '29000', '1', '0', NULL, '2019-02-26', 'admin1');

INSERT INTO `bookstore`.`book` (`title`, `description`, `size`, `authorId`, `publisherId`, `languageId`, `categoryId`, `voucherId`, `thumbnailId`, `pages`, `weight`, `price`, `discount`, `purchases`, `rate`, `releaseDate`, `createdBy`) 
VALUES ('Làng', 'Chưa có mô tả', '15x20 cm', '2', '1', '1', '1', NULL, '11', '125', '23', '27000', '1', '0', NULL, '2020-07-12', 'admin1');